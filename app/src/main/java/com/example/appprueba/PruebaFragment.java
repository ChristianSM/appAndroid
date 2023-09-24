package com.example.appprueba;

import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PruebaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PruebaFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private static final String LOG = "ALEX";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private MediaController mediaController;
    public PruebaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PruebaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PruebaFragment newInstance(String param1, String param2) {
        PruebaFragment fragment = new PruebaFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        getActivity().setContentView(R.layout.fragment_prueba);

        //incluirVideo();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        incluirVideo();

        return inflater.inflate(R.layout.fragment_prueba, container, false);
    }

    private void incluirVideo(){
        VideoView videoView = (VideoView) getActivity().findViewById(R.id.contenedorVideo);

        String ruta = "android.resource://" + getActivity().getPackageName() + "/" + R.raw.la_pandilla_voladora;
        Log.w(LOG, "ruta completa -> " + ruta);
        Log.w(LOG, "Uri.parse -> " + Uri.parse(ruta));

        videoView.setVideoURI(Uri.parse(ruta));
        videoView.start();

    }
}