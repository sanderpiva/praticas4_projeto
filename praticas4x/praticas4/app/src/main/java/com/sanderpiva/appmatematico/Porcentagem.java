package com.sanderpiva.appmatematico;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import java.text.DecimalFormat;

public class Porcentagem extends AppCompatActivity {

    //private Button btnPDF;
    private android.widget.EditText valor1, valor2, op;
    private android.widget.TextView resultado;
    private android.widget.Button btncalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_porcentagem);
        //getSupportActionBar().hide();

        Button btnVideo = (Button) findViewById(R.id.btnVideoPorcentagem);
        btnVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Porcentagem.this, Vporcentagem.class);
                startActivity(intent);
            }
        });

        Button btnPdf = (Button) findViewById(R.id.btnMaterialApoioPorcentagem);
        btnPdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Porcentagem.this, MaterialApoioPitagoras.class);
                startActivity(intent);
                // Snackbar.make(view, "Indisponivel", Snackbar.LENGTH_LONG).show();
            }
        });

        //

        valor1 = findViewById(R.id.editTextValor1);
        valor2 = findViewById(R.id.editTextValor2);
        op = findViewById(R.id.editTextOperador);
        resultado = findViewById(R.id.textViewResultadoPorcentagem);

        android.widget.Button btncalcular = findViewById(R.id.btnCalcular);
        btncalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String resV1 = valor1.getText().toString();
                String resV2 = valor2.getText().toString();
                String resOp = op.getText().toString();
                if(resV1.isEmpty() || resV2.isEmpty()|| resOp.isEmpty()){
                    View layoutPorcentagem = findViewById(R.id.activity_porcentagem);
                    Snackbar.make(layoutPorcentagem, "Preencha todos os dados", Snackbar.LENGTH_SHORT).show();

                }else{
                    //double resposta = porcentagem(view);
                    //resultado.setText(String.valueOf(resposta));
                    ProcessaPorcentagem p = new ProcessaPorcentagem(resV1, resV2, resOp);
                    //resultado.setText(String.valueOf(p.calculaPorcentagem()));

                    double res = (p.getValor1()*p.getValor2());
                    double res2 = res/100;

                    if(p.calculaPorcentagem()==0){
                        View layoutPorcentagem = findViewById(R.id.activity_porcentagem);
                        Snackbar.make(layoutPorcentagem, "Verifique se o sinal do seu operador foi digitado corretamente", Snackbar.LENGTH_SHORT).show();

                    }else{
                        /*resultado.setText("Resolucao: "+p.getValor1()+" "+" "+p.op()+
                                " ("+p.getValor1() +"*" +p.getValor2()+")"+"/ 100"+" = "
                                +p.getValor1()+" "+" "+p.op()+" "+"("+res+")"+"/ 100"+" = "+
                                p.getValor1()+" "+p.op()+" "+res2+" = "+p.calculaPorcentagem());*/


                        if(p.op().equals("+")){
                            double resul1= 1+(p.getValor2()/100);
                            resultado.setText("Resolucao: "+p.getValor1()+" * "+"(1 +"+(p.getValor2()/100)+")"+" = "+
                                    p.getValor1()+" + "+resul1+" = "+p.calculaPorcentagem());
                        }else{
                            double resul2=1-(p.getValor2()/100);
                            resultado.setText("Resolucao: "+p.getValor1()+" * "+"(1 -"+(p.getValor2()/100)+")"+" = "+
                                    p.getValor1()+" - "+resul2+" = "+p.calculaPorcentagem());
                        }

                    }
                }
            }
        });
    }
}