package com.mashael.magentodemo.ui.whats_new;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class WhatsNewViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public WhatsNewViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is what's new fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}