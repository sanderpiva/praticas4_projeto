package com.sanderpiva.appmatematico;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class Proporcao extends AppCompatActivity {

    private android.widget.EditText n, m, n1;
    private android.widget.TextView resultado;
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
        n = findViewById(R.id.editTextValorConteudo1a);
        m = findViewById(R.id.editTextValor2a);
        n1 = findViewById(R.id.editTextValor1b);
        resultado = findViewById(R.id.textViewResultadoPr);
        android.widget.Button btncalcular = findViewById(R.id.buttonCalcularProporcao);

        btncalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String resN = n.getText().toString();
                String resM = m.getText().toString();
                String resN1 = n1.getText().toString();
                if(resN.isEmpty()||resM.isEmpty()||resN1.isEmpty()){
                    View layoutProporcao = findViewById(R.id.activity_proporcao);
                    Snackbar.make(layoutProporcao, "Preencha todos os dados", Snackbar.LENGTH_SHORT).show();
                }else{
                    ProcessaProporcao p = new ProcessaProporcao(resN, resM, resN1);
                    resultado.setText(String.valueOf(p.calculaProporcao()));
                }
            }
        });

        //

    }
}