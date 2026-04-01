package br.gov.sp.cps.revisaop1.virtualStore;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import br.gov.sp.cps.revisaop1.R;

public class Confirm extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirmvirtualstore_screen);

        TextView tvMensagem = findViewById(R.id.tvMensagemBoasVindas);
        Button btnVoltar = findViewById(R.id.btnVoltarInicio);

        String nome = getIntent().getStringExtra("NOME_USUARIO");
        tvMensagem.setText("Bem-vindo, " + nome + "!");

        btnVoltar.setOnClickListener(v -> {
            Intent intent = new Intent(this, Home.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        });
    }
}
