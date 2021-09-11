package com.isabella.practica4_ecosistemas;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.net.InetAddress;

public class VentanaPing extends AppCompatActivity {
    public TextView textViewparaping;
    public Button buttonregresar;
    public boolean corriendo;
    public boolean estado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventana_ping);
        textViewparaping = findViewById(R.id.textViewparaping);
        buttonregresar = findViewById(R.id.buttonregresarh);
        textViewparaping.setText("ok");
        corriendo = true;
        ping();

        buttonregresar.setOnClickListener(
                (v)->{
                    Intent i = new Intent(this,MainActivity.class);
                    corriendo=false;
                    startActivity(i);
                }
        );
    }

    public void ping(){
        new Thread(
                ()->{
                    String ip = getIntent().getExtras().getString("IP");
                    long inicio=System.currentTimeMillis();
                    while(corriendo){
                        long actual = System.currentTimeMillis()-inicio;
                        if(actual>=2000){
                            try {
                                long tic=System.currentTimeMillis();
                                InetAddress address = InetAddress.getByName(ip);
                                estado = address.isReachable(2000);
                                System.out.println(estado);
                                runOnUiThread(
                                        ()->{
                                            textViewparaping.setText((estado?"Recibido":"Perdido"));

                                        }
                                );
                            }
                            catch(Exception e){
                                e.printStackTrace();
                            }
                            inicio=System.currentTimeMillis();
                        }

                    }

                }
        ).start();

    }


}