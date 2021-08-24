package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements Calculator.FragmentListener {
    private Calculator calculator;
    private Result result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calculator=new Calculator();
        result=new Result();
        getSupportFragmentManager().beginTransaction().replace(R.id.calccontain,calculator).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.resultcontain,result).commit();




    }

    @Override
    public void inputSent(String s) {
        result.setText(s);
    }
}