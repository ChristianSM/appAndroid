package com.example.appprueba.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.appprueba.databinding.FragmentCuartoBinding;
import com.example.appprueba.databinding.FragmentQuintoBinding;

public class QuintoFragment extends Fragment {
    private FragmentQuintoBinding binding;
    private String texto;
    public QuintoFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        texto = "Prueba quinto fragment";
        binding = FragmentQuintoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.txtQuintoFragment;
        textView.setText(texto);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}