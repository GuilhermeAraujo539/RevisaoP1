package br.gov.sp.cps.revisaop1.pizzaria;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import br.gov.sp.cps.revisaop1.R;

public class PizzaOpcoes extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pizzaflavors_screen);

        String sabores = getIntent().getStringExtra("SABORES");
        RadioGroup rgTamanho = findViewById(R.id.rgTamanho);
        RadioGroup rgPagamento = findViewById(R.id.rgPagamento);

        findViewById(R.id.btnFinalizar).setOnClickListener(v -> {
            double valorBase = 0;
            String tamanho = "";

            int idT = rgTamanho.getCheckedRadioButtonId();
            if(idT == R.id.rbPequena) { valorBase = 30.0; tamanho = "Pequena"; }
            else if(idT == R.id.rbMedia) { valorBase = 45.0; tamanho = "Média"; }
            else if(idT == R.id.rbGrande) { valorBase = 60.0; tamanho = "Grande"; }

            int idP = rgPagamento.getCheckedRadioButtonId();
            String pag = (idP == R.id.rbDinheiro) ? "Dinheiro" : "Cartão";

            Intent intent = new Intent(this, PizzaResumoActivity.class);
            intent.putExtra("SABORES", sabores);
            intent.putExtra("TAMANHO", tamanho);
            intent.putExtra("PAGAMENTO", pag);
            intent.putExtra("TOTAL", valorBase);
            startActivity(intent);
        });
    }
}