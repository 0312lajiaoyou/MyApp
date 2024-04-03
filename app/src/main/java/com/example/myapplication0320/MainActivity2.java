package com.example.myapplication0320;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

    }
    public void Click(View view) {
        TextView scoreA=findViewById(R.id.out);
        int score_old=Integer.parseInt(scoreA.getText().toString());
        if(view.getId()==R.id.button3){
            //+3
            scoreA.setText(String.valueOf(score_old+3));
        } else if (view.getId()==R.id.button2) {
            //+2
            scoreA.setText(String.valueOf(score_old+2));
        }else if (view.getId()==R.id.button1) {
            //+1
            scoreA.setText(String.valueOf(score_old+1));
        }
    }
    public void reset(View view) {
        TextView scoreA=findViewById(R.id.out);
        int sum=0;
        scoreA.setText(String.valueOf(sum));
    }
}