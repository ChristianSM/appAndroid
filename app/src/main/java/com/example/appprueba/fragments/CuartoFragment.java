package com.example.appprueba.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.appprueba.R;
import com.example.appprueba.databinding.FragmentCuartoBinding;
import com.example.appprueba.databinding.FragmentHomeBinding;
import com.example.appprueba.ui.cuartoFragment.CuartoViewModel;

public class CuartoFragment extends Fragment {
    private FragmentCuartoBinding binding;

    public CuartoFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        CuartoViewModel cuartoViewModel = new ViewModelProvider(this).get(CuartoViewModel.class);

        binding = FragmentCuartoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textView3;
        cuartoViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}