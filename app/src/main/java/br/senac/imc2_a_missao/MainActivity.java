package br.senac.imc2_a_missao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final int QUADRADO_EXPOENTE = 2;
    public static final String RESULTADO = "IMC";
    private EditText editPeso;
    private EditText editAltura;
    private Button btnCalcularIMC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Recuperando as views(campos de texto e botões) xml
        editPeso = findViewById(R.id.mainEditPeso);
        editAltura = findViewById(R.id.mainEditAltura);
        btnCalcularIMC = findViewById(R.id.mainBtnCalcular);

        cliqueBotao();
    }

    //Realiza o tratamento do clique do botão calcularIMC
    private void cliqueBotao(){
        //Metodo setOnClickListener() fica escutando(vigiando) o momento em que
        //for dado o clique
        btnCalcularIMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Recuperando o peso e transformando(Converter) para double
                //Primeiro converte o text para string e depois usa a classe Double chamando
                //o metodo que converte string para double
                double peso = Double.parseDouble(editPeso.getText().toString());
                double altura = Double.parseDouble(editAltura.getText().toString());

                //Classe Math possui metodos para calculos matemáticos
                //pow() - potenciação
                double imc = peso/Math.pow(altura, QUADRADO_EXPOENTE);

                //Para mandar para outra activity precisamos de uma... Intent
                Intent intent = new Intent(MainActivity.this,ResultadoActivity.class);
                intent.putExtra(RESULTADO,imc);//Colocando a variavel na intent
                startActivity(intent);//Manda(incia) para outra activity
            }
        });
    }
}
