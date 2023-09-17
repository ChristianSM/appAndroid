package com.example.appprueba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    private TextView textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();

        Toast.makeText(this, bundle.getString("valor1"), Toast.LENGTH_SHORT).show();
        mostrarTexto(bundle.getString("valor1"));
    }

    private void mostrarTexto(String texto){
        textView2 = (TextView) findViewById(R.id.textView2);
        textView2.setText(texto);
    }
}