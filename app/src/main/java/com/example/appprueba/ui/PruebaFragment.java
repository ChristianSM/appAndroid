package com.example.appprueba.ui;

import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.appprueba.R;

public class PruebaFragment extends Fragment {
    private VideoView videoView;
    private MediaController mediaController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_prueba, container, false);

        incluirVideo(view);

        return view;
    }

    private void incluirVideo(View view){
        /*  */
        videoView = (VideoView) view.findViewById(R.id.contenedorVideo);
        String ruta = "android.resource://" + getActivity().getPackageName() + "/" + R.raw.la_pandilla_voladora;
        videoView.setVideoURI(Uri.parse(ruta));

        mediaController = new MediaController(getActivity());
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);

        //Inicia el video nada más llamar al fragment.
        //videoView.start();
    }

    @Override
    public void onDestroy() {
        videoView.suspend();
        super.onDestroy();
    }
}