package com.example.appprueba.ui.cuartoFragment;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CuartoViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public CuartoViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Fragment 4");
    }

    public LiveData<String> getText() {
        return mText;
    }
}