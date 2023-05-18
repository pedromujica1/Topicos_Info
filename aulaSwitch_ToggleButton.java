package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private ToggleButton toggleButtonLigado;
    private Switch switchSenha;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toggleButtonLigado = findViewById(R.id.toggleButtonLigado);
        switchSenha = findViewById(R.id.switchSenha);
        textResultado = findViewById(R.id.textResultado);

        carregarListener();

    }

    public void carregarListener(){

        switchSenha.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked){
                    textResultado.setText("Switch is on. Now with listener component!");
                }
                else{
                    textResultado.setText("Switch is off.");
                }
            }
        });
    }


    public void Enviar(View view){




        //Verifica se o toggleButton está marcado e mostra a mensagem no textview
        if (toggleButtonLigado.isChecked()){
            textResultado.setText("Toggle Button is on, and ready to go!");
        }
        else{
            textResultado.setText("Toggle Button is off, Try turning it on.");
        }


    }
}
