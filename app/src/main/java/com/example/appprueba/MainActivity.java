package com.example.appprueba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    VideoView video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        video = (VideoView) findViewById(R.id.videoView);
        video.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.atom));

        MediaController mediaController = new MediaController(this);
        video.setMediaController(mediaController);

        video.start();

        Button botonNavigation = (Button) findViewById(R.id.buttonSegundaPantalla);
        botonNavigation.setOnClickListener(new OnClickListener);


    }

    public void irSegundaPantalla(View vista){
        Intent intent = new Intent(MainActivity.this, SegundaActivity.class);
        startActivity(intent);
    }
}