package br.senac.imc2_a_missao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultadoActivity extends AppCompatActivity {

    private TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        txtResultado = findViewById(R.id.resultadoTxtResultado);

        // getIntent() pega a intent que vem de outra activity
        Intent intent = getIntent();
        //getDoubleExtra() -> Pega um double do putExtra
        double imc = intent.getDoubleExtra(MainActivity.RESULTADO,0);
        //String.valueOf() - Extrai de outros tipos para String(Converte para string)
        txtResultado.setText(String.valueOf(imc));
    }
}
