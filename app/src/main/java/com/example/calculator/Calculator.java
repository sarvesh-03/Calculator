package com.example.calculator;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Calculator#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Calculator extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Calculator() {
        // Required empty public constructor
    }

    public interface FragmentListener{
        void inputSent(String s);
    }
    private LinearLayout linearLayout;
    private LinearLayout l1;
    private LinearLayout l2;
    private LinearLayout l3;
    private LinearLayout l4;
    private LinearLayout l5;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Calculator.
     */
    // TODO: Rename and change types and number of parameters
    public static Calculator newInstance(String param1, String param2) {
        Calculator fragment = new Calculator();
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
    }
    private FragmentListener fragmentListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_calculator, container, false);
        View.OnClickListener onClickListener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textView=(TextView)v;
                if(!textView.getText().toString().equals(""))
                updateData(textView.getText().toString());
            }
        };
        LinearLayout linearLayout1;
        textView=view.findViewById(R.id.textView);
        fragmentListener=(FragmentListener)getActivity();
        linearLayout=view.findViewById(R.id.linearlayout);
        l1=view.findViewById(R.id.l1);
        for (int j=0;j<5;j++) {
            LinearLayout linear=(LinearLayout)linearLayout.getChildAt(j);
            for (int i = 0; i < 4; i++) {
                linear.getChildAt(i).setOnClickListener(onClickListener);
            }
        }






        return view;
    }
    private TextView textView;
    private String a="";
    private String b="";
    private String Operator="";
    private String result="";
    private String temp="";


    public void updateData(String s) {
        if (s.equals("AC")) {
            a = "";
            b = "";
            Operator = "";
            fragmentListener.inputSent("");
        } else if (s.equals("DEL")) {
            if (Operator.equals("")&&!a.equals("")) {
                a = a.substring(0, a.length() - 1);
            }

        else if (b.equals(""))
            Operator = "";
        else {

            b=b.substring(0,b.length()-1);


        }
    }
        else if(s.equals("%")){
            if(!a.equals("")) {
                if (Operator.equals("")) {
                    Operator = s;

                } else {
                    Toast.makeText(getContext(), "Operator already added", Toast.LENGTH_SHORT).show();
                }
            }
            else Toast.makeText(getContext(), "Enter First Input", Toast.LENGTH_SHORT).show();

        }
        else if(s.equals("/")){
            if(!a.equals("")) {
                if (Operator.equals("")) {
                    Operator = s;

                } else {
                    Toast.makeText(getContext(), "Operator already added", Toast.LENGTH_SHORT).show();
                }
            }
            else Toast.makeText(getContext(), "Enter First Input", Toast.LENGTH_SHORT).show();

        }
        else if(s.equals("X")){
            if(!a.equals("")) {
                if (Operator.equals("")) {
                    Operator = s;

                } else {
                    Toast.makeText(getContext(), "Operator already added", Toast.LENGTH_SHORT).show();
                }
            }
            else Toast.makeText(getContext(), "Enter First Input", Toast.LENGTH_SHORT).show();

        }
        else if(s.equals("-")){
            if(!a.equals("")) {
                if (Operator.equals("")) {
                    Operator = s;

                } else {
                    Toast.makeText(getContext(), "Operator already added", Toast.LENGTH_SHORT).show();
                }
            }
            else Toast.makeText(getContext(), "Enter First Input", Toast.LENGTH_SHORT).show();

        }
        else if(s.equals("+")){
            if(!a.equals("")) {
                if (Operator.equals("")) {
                    Operator = s;

                } else {
                    Toast.makeText(getContext(), "Operator already added", Toast.LENGTH_SHORT).show();
                }
            }
            else Toast.makeText(getContext(), "Enter First Input", Toast.LENGTH_SHORT).show();

        }
        else if(s.equals("=")){
            if(!b.equals(""))
            CalculateData();

        }
        else if(s.equals(".")){
            if(!a.equals("")&&Operator.equals("")) {
                if (!a.contains("."))
                    a = a + s;
            }
            else if(!Operator.equals("")){
                if(b.equals(""))
                    Toast.makeText(getContext(), "Invalid Input", Toast.LENGTH_SHORT).show();
                else if(!b.contains("."))
                    b=b+s;

            }


        }
        else {
            if(a.equals("")||Operator.equals(""))
                a=a+s;
            else b=b+s;
        }
        textView.setText(a+Operator+b);
        Log.v("tag","a="+a+"b="+b+"Op"+Operator);

    }

    private void CalculateData() {
        Double a1=Double.valueOf(a);
        Double b1=Double.valueOf(b);
        Double res=new Double(0.0);
        if(Operator.equals("+")){
            res=a1+b1;
        }
        else if(Operator.equals("-")){
            res=a1-b1;
        }
        else if(Operator.equals("X")){
            res=a1*b1;
        }
        else if(Operator.equals("/")){
            if(b1!=0) {
                res = a1/ b1;
            }
            else result="Math Error";
        }
        result=res.toString();
        fragmentListener.inputSent(result);
    }
}