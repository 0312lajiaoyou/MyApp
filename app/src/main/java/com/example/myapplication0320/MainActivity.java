package com.example.myapplication0320;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String Tag="mainactivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView myout= findViewById(R.id.out);
        myout.setText("Hello BMI");
        System.out.println("this is system.out.println");

        //Log.i(tag:"aaa",msg:"onCreate:");
    }

    public void Click(View view) {
        String msg = "Click:111111111";
        Log.i(Tag,msg);
        EditText input1=findViewById(R.id.input1);
        EditText input2=findViewById(R.id.input2);
        float height=Float.parseFloat(input1.getText().toString());
        float weight=Float.parseFloat(input2.getText().toString());
        float x1=height*height;
        float bmi=weight/x1;

        TextView myout=findViewById(R.id.out);
        String result;
        if(bmi<18){
            result="\n您偏瘦了";
        }else if(bmi<24){
            result="\n您bmi正常";
        }else{
            result="\n您偏胖了";
        }
        myout.setText(String.format("您的BMI为：%.2f "+result, bmi));
    }
}