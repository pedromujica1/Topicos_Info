package com.example.aulaseekbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.math.RoundingMode;
import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {
    private SeekBar seekBarPessoas;
    private SeekBar seekbarPorcentagem;
    private TextView pessoas;
    private TextView porcentagem;
    private TextView resultados;
    private int temp_pessoas;
    private int temp_porcentagem;
    private EditText valorConta;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pessoas = findViewById(R.id.pessoas);
        porcentagem = findViewById(R.id.porcentagem);
        seekBarPessoas = findViewById(R.id.seekBarPessoas);
        seekbarPorcentagem=findViewById(R.id.seekBarPorcentagem);
        resultados = findViewById(R.id.resultados);
        valorConta = findViewById(R.id.valorConta);

        DecimalFormat decimalFormat = new DecimalFormat("0.##");



        seekBarPessoas.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                temp_pessoas = progress;
                pessoas.setText("Número de pessoas: "+progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                temp_pessoas = seekBarPessoas.getProgress();
                pessoas.setText("Número de pessoas: "+ temp_pessoas);


            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                temp_pessoas = seekBarPessoas.getProgress();
                pessoas.setText("Número de pessoas: "+ temp_pessoas);

            }
        });

        seekbarPorcentagem.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                temp_porcentagem = progress;
                porcentagem.setText("Número de pessoas: "+progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                temp_porcentagem = seekbarPorcentagem.getProgress();
                porcentagem.setText("Porgentagem: "+temp_porcentagem);

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                temp_porcentagem = seekbarPorcentagem.getProgress();
                porcentagem.setText("Porgentagem: "+temp_porcentagem);

            }
        });




    }

    public void valorgorjeta(View view){


        AlertDialog.Builder dialog = new AlertDialog.Builder(this);

        //configurar titulo e mensagem
        dialog.setTitle("Escolha uma opção");
        dialog.setMessage("Valor com ou sem gorjeta?");

        //configurar cancelemaneto do alertDialog
        dialog.setCancelable(false);

        //Configurar ícone
        dialog.setIcon(android.R.drawable.ic_btn_speak_now);

        //configurar açoes para sim e nâo
        dialog.setPositiveButton("Com gorjeta", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                String conta_total = valorConta.getText().toString();
                double conta_double = Double.parseDouble(conta_total);

                float porcentagem = temp_porcentagem;

                double gorjeta_value = conta_double* (porcentagem/100.00);
                double resultado = (conta_double / temp_pessoas) +gorjeta_value;


                DecimalFormat df = new DecimalFormat("#.##");
                df.setRoundingMode(RoundingMode.FLOOR);

                String formatadoResult = df.format(resultado);

                resultados.setText("Esse é o seu valor com gorjeta: R$"+formatadoResult);


                Toast.makeText(getApplicationContext(), formatadoResult,
                        Toast.LENGTH_SHORT).show();
            }
        });

        //configura ação de não
        dialog.setNegativeButton("Sem gorjeta", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Toast.makeText(getApplicationContext(), "Sem gorjeta", Toast.LENGTH_SHORT).show();
                String conta_total = valorConta.getText().toString();
                double conta_double = Double.parseDouble(conta_total);
                double resultado = conta_double/temp_pessoas;

                //
                //DecimalFormat df = new DecimalFormat("#.##");
                //        df.setRoundingMode(RoundingMode.FLOOR);
                //        String roundOff = df.format(random);
                DecimalFormat df = new DecimalFormat("#.##");
                df.setRoundingMode(RoundingMode.FLOOR);

                String formatadoResult = df.format(resultado);



                resultados.setText("Esse é o seu valor sem gorjeta: R$"+formatadoResult);

                Toast.makeText(getApplicationContext(), formatadoResult,
                        Toast.LENGTH_SHORT).show();



            }
        });






        dialog.create();
        dialog.show();

    }

    }

