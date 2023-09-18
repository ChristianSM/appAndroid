package com.example.appprueba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    private TextView textView2;
    private Button btnVolver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();

        Toast.makeText(this, bundle.getString("valor1"), Toast.LENGTH_SHORT).show();
        mostrarTexto(bundle.getString("valor1"));

        btnVolver = (Button) findViewById(R.id.btnVolver);
        btnVolver.setOnClickListener(accionBtnVolver);

    }

    private View.OnClickListener accionBtnVolver = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(getApplicationContext(), "volviendo a la activity 1", Toast.LENGTH_SHORT).show();
            volver(v);
        }
    };

    private void mostrarTexto(String texto){
        textView2 = (TextView) findViewById(R.id.textView2);
        textView2.setText(texto);
    }

    private void volver(View v){
        Intent intent = new Intent(this, MainActivity.class);
        //Bundle bundle = new Bundle();
        //bundle.putString("valor2", "Hemos vuelto desde la ventana 1");
        //intent.putExtras(bundle);
        startActivity(intent);
    }
}