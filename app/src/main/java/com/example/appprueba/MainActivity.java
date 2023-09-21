package com.example.appprueba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.util.Log;

import com.example.appprueba.clases.Contador;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn1, btn2, btnCambiarActivity;
    private Contador contLeido = new Contador();
    private static final String MILOG = "LogsAndroid";
    private Intent intent;
    private Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(this);

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
        intent = new Intent(this, MainActivity2.class);
        bundle = new Bundle();

        intent.putExtras(bundle);
        startActivity(intent);
    }

    private void ir_a_navigation(View v){
        intent = new Intent(this, NavigationActivity.class);
        bundle = new Bundle();

        rellenarBundle(bundle);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    private void rellenarBundle(Bundle b){
        b.putString("fragmentGalery", "Estamos en el fragmentGalery");
        b.putString("fragmentHome", "Estamos en el fragmentHome");
        b.putString("fragmentSlideshow", "Estamos en el fragmentSlideshow");
    }

    @Override
    public void onClick(View v){
        if (v.getId() == R.id.btn1){
            contLeido.sumarContador();
            Toast.makeText(getApplicationContext(), "Sumamos a contador", Toast.LENGTH_SHORT).show();
        }

        if(v.getId() == R.id.btn2){
            if(contLeido.getContador() >= 1){
                contLeido.reiniciarContador();
                ir_a_navigation(v);
            }else{
                Toast.makeText(getApplicationContext(), "Debe sumar primer contador", Toast.LENGTH_SHORT).show();
            }

            //ir_a_navigation(v);
        }

        if (v.getId() == R.id.btnCambiarActivity){
            contLeido.reiniciarContador();
            Toast.makeText(getApplicationContext(), "Reiniciamos el contador: " + contLeido.getContador(), Toast.LENGTH_SHORT).show();
            //ir_a_segunda(v);
        }
    }
}