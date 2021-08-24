package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity  {
    private Calculator calculator;
    private Result result;
    private model m1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calculator=new Calculator();
        result=new Result();
        getSupportFragmentManager().beginTransaction().replace(R.id.calccontain,calculator).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.resultcontain,result).commit();
         m1= new ViewModelProvider(this).get(model.class);




    }


}