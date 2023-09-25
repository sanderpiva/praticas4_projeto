package com.sanderpiva.appmatematico.Model;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.sanderpiva.appmatematico.R;

public class Proporcao extends AppCompatActivity {

    private android.widget.EditText a, b, c;
    private android.widget.TextView resultado, desc;
    private android.widget.Button btncalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proporcao);
        //getSupportActionBar().hide();

        Button btnVideo = (Button) findViewById(R.id.btnVideoProporcao);
        btnVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Proporcao.this, Vproporcao.class);
                startActivity(intent);
            }
        });

        Button btnPdf = (Button) findViewById(R.id.btnMaterialApoioProporcao);
        btnPdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Proporcao.this, MaterialApoioProporcao.class);
                startActivity(intent);
                // Snackbar.make(view, "Indisponivel", Snackbar.LENGTH_LONG).show();
            }
        });

        //
        a = findViewById(R.id.editTextValorConteudo1a);
        b = findViewById(R.id.editTextValor2a);
        c = findViewById(R.id.editTextValor1b);
        resultado = findViewById(R.id.textViewResultadoPr);
        desc = findViewById(R.id.textViewDescResultadoProporcao);
        android.widget.Button btncalcular = findViewById(R.id.buttonCalcularProporcao);

        btncalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String resA = a.getText().toString();
                String resB = b.getText().toString();
                String resC = c.getText().toString();
                if(resA.isEmpty()||resB.isEmpty()||resC.isEmpty()){
                    View layoutProporcao = findViewById(R.id.activity_proporcao);
                    Snackbar.make(layoutProporcao, "Preencha todos os dados", Snackbar.LENGTH_SHORT).show();
                }else{
                    ProcessaProporcao p = new ProcessaProporcao(resA, resB, resC);
                    //resultado.setText(String.valueOf(p.calculaProporcao()));
                    resultado.setText(String.format("%.2f", p.calculaProporcao()));
                    desc.setText("D*"+p.getV1()+" = "+p.getV3()+ "*"+p.getV2()+"=> D = "+
                            "("+p.getV3()+" * "+p.getV2()+")"+"/"+p.getV1()+" = "
                    +(p.getV3()*p.getV2())+" / "+p.getV1()+" = "+p.calculaProporcao());
                    /*
                    desc.setText(String.format("C: (%.2f) * B: (%.2f) / A: (%.2f) = %.2f / %.2f = %.2f",
                            p.getV3(), p.getV2(), p.getV1(),
                            p.getV3() * p.getV2(), p.getV1(),
                            p.calculaProporcao()));*/

                }
            }
        });

        //

    }
}