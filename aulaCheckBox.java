package com.example.aulacheckbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Cria as variaveis
    private CheckBox checkboxGreen;
    private CheckBox checkboxBlue;
    private CheckBox checkboxRed;
    private TextView textResult;

    private RadioButton radiobuttonArroz;

    private RadioButton radiobuttonFeijao;

    private RadioGroup radiogroupAlmoco;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Pega o conteúdo do Id e salva nas variáveis criadas anteriormente
        checkboxGreen = findViewById(R.id.checkboxGreen);

        checkboxBlue = findViewById(R.id.checkboxBlue);

        checkboxRed = findViewById(R.id.checkboxRed);

        textResult = findViewById(R.id.textResult);

        //Pega os conteúdos dos radioButton e radioGroup
        radiobuttonArroz = findViewById(R.id.radiobuttonArroz);

        radiobuttonFeijao = findViewById(R.id.radiobuttonFeijao);

        radiogroupAlmoco = findViewById(R.id.radiogroupAlmoco);

        radiobuttonListener();

    }
    //Metódo checkbox para verificar se o checkbox está marcado ou não
    public void checkbox(){

        String texto = "";

        //Metódo ischecheck retorna true caso a checkbox estaja marcada, então o if é executado
        if (checkboxGreen.isChecked()){
            //textResult.setText("Hey, You just picked the color Green. Nice!");
            texto = "Green selected - ";

        }
        if (checkboxBlue.isChecked()){
            //textResult.setText("Hey, You just picked the color Blue. Nice!");
            texto+= "Blue selecionado - ";
        }

        if (checkboxRed.isChecked()){
            //textResult.setText("Hey, You just picked the color Red. Nice!");
            texto+= "Red Selected - ";
        }

        //Mostra a string final e mostrar todas as cores selecionadas
        //Caso mais de um checkbox esteja marcado.
        textResult.setText(texto);

    }

    public void radioButton(){
        if (radiobuttonArroz.isChecked()) {
            textResult.setText("Arroz");

        }

        else if (radiobuttonFeijao.isChecked()) {
            textResult.setText("Feijão");

        }

    }

    public void radiobuttonListener(){

        //cria um listner no radiogroupAlmoco
        radiogroupAlmoco.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                //verifica se o id marcardo é a caixa do arroz
                if (checkedId == R.id.radiobuttonArroz) {
                    textResult.setText("You selected Rice!");

                } else if (checkedId == R.id.radiobuttonFeijao) { //verifica se o id marcado é a caixa do feijão
                    textResult.setText("You selected Beans!");

                }

            }
        });
    }


    public void enviar(View view)
    {
        //Chama o metódo checkBox()
        //checkbox();

        radioButton();

    }


}
