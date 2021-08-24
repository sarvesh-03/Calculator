package com.example.calculator;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class model extends ViewModel {
    private MutableLiveData<String> result=new MutableLiveData<>();


    public void SetResult(String string){
        result.setValue(string);
    }

    public LiveData<String>getText(){return result;}


}
