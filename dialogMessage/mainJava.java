package com.example.aulacheckbox;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;

import android.view.View;

import android.widget.CheckBox;
import android.widget.ImageView;

import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.github.chrisbanes.photoview.PhotoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void dialog(View view){
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);

        //configurar titulo e mensagem
        dialog.setTitle("Dialog title");
        dialog.setMessage("Dialog message");

        //configurar cancelemaneto do alertDialog
        dialog.setCancelable(false);

        //Configurar ícone
        dialog.setIcon(android.R.drawable.ic_btn_speak_now);

        //configurar açoes para sim e nâo
        dialog.setPositiveButton("sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Executar açâo ao clicar no botão sim", Toast.LENGTH_SHORT).show();

            }
        });

        //configura ação de não
        dialog.setNegativeButton("nao", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Executar açâo ao clicar no botão não", Toast.LENGTH_SHORT).show();

            }
        });
        dialog.create();
        dialog.show();
    }
}
