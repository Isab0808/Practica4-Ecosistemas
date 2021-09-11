package com.isabella.practica4_ecosistemas;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class BuscarHosts extends AppCompatActivity {
    private TextView textViewparahost;
    private Button buttonregresarh;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_hosts);

        textViewparahost = findViewById(R.id.textViewparahost);
        buttonregresarh = findViewById(R.id.buttonregresarh);

        buttonregresarh.setOnClickListener(
                (v)->{
                    Intent i = new Intent(this,MainActivity.class);
                    startActivity(i);
                }
        );
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            String ipLocal = inetAddress.getHostAddress();
            System.out.println(ipLocal);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }
}