package com.example.appprueba;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    private static final String MILOG = "Alex";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        incluirVideo();
    }

    private void incluirVideo(){
        //LayoutInflater inflater = getLayoutInflater(); //LayoutInflater.from(this.getActivity());
        MediaController mediaController = new MediaController(this);
        //View view = inflater.inflate(R.layout.activity_main, findViewById(R.id.videoView));

        VideoView videoView = findViewById(R.id.videoView);
        String ruta = "android.resource://" + getPackageName() + "/" + R.raw.la_pandilla_voladora;
        Log.w(MILOG,  "Ruta del paquete completa desde MainActivity -> " + ruta);
        videoView.setVideoURI(Uri.parse(ruta));
        videoView.setMediaController(mediaController);
        videoView.start();

    }
}