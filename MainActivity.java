package com.example.ejempohandler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
Thread hilo;
Button btn_contar;
Handler h;
TextView texto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       texto=findViewById(R.id.tv_numero);
        btn_contar=findViewById(R.id.btn_contar);
        h=new Handler(getMainLooper()){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (msg.obj==null) {//Me mandan obj relleno al terminar
                    String texto_i = String.valueOf(msg.arg1);
                    texto.setText(texto_i);
                }
                else
                {
                    String texto_i=(String) msg.obj;
                    texto.setText(texto_i);
                }
            }
        };
        btn_contar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hilo=new Thread(new MiRunnable(h));
                hilo.start();
            }
        });
    }
}
