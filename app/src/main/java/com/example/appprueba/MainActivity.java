package com.example.appprueba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn1, btn2, btnCambiarActivity;
    private static final String MILOG = "LogsAndroid";

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
        btn2.setOnClickListener(this);

        btnCambiarActivity = (Button) findViewById(R.id.btnCambiarActivity);
        btnCambiarActivity.setOnClickListener(this);

        //Prueba logs
        Log.e(MILOG, "Mensaje de error");
        Log.w(MILOG, "Mensaje de warning");
        Log.i(MILOG, "Mensaje de información");
        Log.d(MILOG, "Mensaje de depuración");
        Log.v(MILOG, "Mensaje de verbose");
    }

    /*private View.OnClickListener accionBtn2 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(getApplicationContext(), "Has pulsado el segundo botón", Toast.LENGTH_SHORT).show();
        }
    };

    private View.OnClickListener accionBtnCambiarActivity = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(getApplicationContext(), "Cambiando de activity", Toast.LENGTH_SHORT).show();
            ir_a_segunda(view);
        }
    };*/

    private void ir_a_segunda(View v){
        Intent intent = new Intent(this, MainActivity2.class);
        Bundle bundle = new Bundle();

        bundle.putString("valor1", "Estamos en la segunda pantalla, llamada desde el botón");
        intent.putExtras(bundle);
        startActivity(intent);

    }

    @Override
    public void onClick(View v){
        if(v.getId() == R.id.btn2){
            Toast.makeText(getApplicationContext(), "Has pulsado el segundo botón", Toast.LENGTH_SHORT).show();
        }

        if (v.getId() == R.id.btnCambiarActivity){
            Toast.makeText(getApplicationContext(), "Cambiando de activity", Toast.LENGTH_SHORT).show();
            ir_a_segunda(v);
        }
    }
}