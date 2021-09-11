package com.isabella.practica4_ecosistemas;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextcuad1;
    private EditText editTextcuad2;
    private EditText editTextcuad3;
    private EditText editTextcuad4;
    private Button buttonping;
    private Button buttonbuscarhosts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextcuad1 = findViewById(R.id.editTextcuad1);
        editTextcuad2 = findViewById(R.id.editTextcuad2);
        editTextcuad3 = findViewById(R.id.editTextcuad3);
        editTextcuad4 = findViewById(R.id.editTextcuad4);
        buttonping = findViewById(R.id.buttonping);
        buttonbuscarhosts = findViewById(R.id.buttonbuscarhosts);

        buttonping.setOnClickListener(
                (v)->{
                    String ip = editTextcuad1.getText()+"."+editTextcuad2.getText()+"."+editTextcuad3.getText()+"."+editTextcuad4.getText();
                    Intent i = new Intent(this, com.isabella.practica4_ecosistemas.VentanaPing.class);
                    i.putExtra("IP",ip);
                    startActivity(i);

                }
        );
        buttonbuscarhosts.setOnClickListener(
                (v)->{
                    Intent i = new Intent(this, com.isabella.practica4_ecosistemas.BuscarHosts.class);
                    startActivity(i);
                }
        );

        //InetAddress inetAddress = null;
        //try {
           // inetAddress = InetAddress.getByName("192.168.1.15");
       // } catch (UnknownHostException e) {
           // e.printStackTrace();
       // }
        //String iphone8plus = inetAddress.getHostAddress();
       // System.out.println(iphone8plus);
       // try {
          // boolean conectado =  inetAddress.isReachable(2000);
           //System.out.println("conectado:"+conectado);
       // } catch (IOException e) {
          //  e.printStackTrace();
        }

    }



