package br.gov.sp.cps.revisaop1.virtualStore;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import br.gov.sp.cps.revisaop1.R;

public class Login extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginvirtualstore_screen);

        TextInputEditText editNome = findViewById(R.id.editNomeCliente);
        Button btnFinalizar = findViewById(R.id.btnFinalizarCadastro);

        btnFinalizar.setOnClickListener(v -> {
            String nome = editNome.getText().toString();
            if (nome.isEmpty()) {
                editNome.setError("Por favor, insira seu nome");
                return;
            }

            Intent intent = new Intent(this, Confirm.class);
            intent.putExtra("NOME_USUARIO", nome);
            startActivity(intent);
            finish();
        });
    }
}