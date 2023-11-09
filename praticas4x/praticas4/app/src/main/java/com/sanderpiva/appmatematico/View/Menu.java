package com.sanderpiva.appmatematico.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.android.material.snackbar.Snackbar;
import com.sanderpiva.appmatematico.Model.Aquadrado;
import com.sanderpiva.appmatematico.Model.PA;
import com.sanderpiva.appmatematico.Model.PG;
import com.sanderpiva.appmatematico.Model.PerimetroQuadrado;
import com.sanderpiva.appmatematico.Model.Pitagoras;
import com.sanderpiva.appmatematico.Model.Porcentagem;
import com.sanderpiva.appmatematico.Model.Proporcao;
import com.sanderpiva.appmatematico.Model.SenoCossenoTangente;
import com.sanderpiva.appmatematico.R;

public class Menu extends AppCompatActivity {

    private android.widget.Button btn1;
    private android.widget.Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Spinner spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.seletor_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        break;
                    case 1:
                        Intent intent1 = new Intent(Menu.this, Pitagoras.class);
                        startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2 = new Intent(Menu.this, Aquadrado.class);
                        startActivity(intent2);
                        break;
                    // Adicione os outros casos conforme a necessidade
                    case 3:
                        Intent intent3 = new Intent(Menu.this, SenoCossenoTangente.class);
                        startActivity(intent3);
                        break;
                    case 4:
                        Intent intent4 = new Intent(Menu.this, PerimetroQuadrado.class);
                        startActivity(intent4);
                        break;
                    case 5:
                        Intent intent5 = new Intent(Menu.this, PA.class);
                        startActivity(intent5);
                        break;
                    case 6:
                        Intent intent6 = new Intent(Menu.this, PG.class);
                        startActivity(intent6);
                        break;
                    case 7:
                        Intent intent7 = new Intent(Menu.this, Porcentagem.class);
                        startActivity(intent7);
                        break;
                    case 8:
                        Intent intent8 = new Intent(Menu.this, Proporcao.class);
                        startActivity(intent8);
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + position);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Não é necessário implementar nada aqui
            }
        });
    }
}
