package br.gov.sp.cps.revisaop1.projectsMenu;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import br.gov.sp.cps.revisaop1.R;
import br.gov.sp.cps.revisaop1.shopping.shopping;


public class MainActivity extends AppCompatActivity {

    private Button btnCompras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnCompras = findViewById(R.id.btnCompras);

        setupClicks();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void setupClicks(){
        btnCompras.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, shopping.class);
            startActivity(intent);
            finish();
        });
    }
}