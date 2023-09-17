package com.example.appprueba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Has pulsado el primer botón", Toast.LENGTH_SHORT).show();
            }
        });

        btn2 = (Button) findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Has pulsado el segundo botón", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void ir_a_segunda(View v){
        Intent intent = new Intent(this, MainActivity2.class);
        Bundle bundle = new Bundle();

        bundle.putString("valor1", "Estamos en la segunda pantalla, llamada desde el botón");
        intent.putExtras(bundle);
        startActivity(intent);

    }
}