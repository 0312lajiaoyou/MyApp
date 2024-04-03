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
        TextView scoreA=findViewById(R.id.out1);
        TextView scoreB=findViewById(R.id.out2);
        int score_oldA=Integer.parseInt(scoreA.getText().toString());
        int score_oldB=Integer.parseInt(scoreB.getText().toString());
        if(view.getId()==R.id.button3){//+3
            scoreA.setText(String.valueOf(score_oldA+3));
        } else if (view.getId()==R.id.button2) {//+2
            scoreA.setText(String.valueOf(score_oldA+2));
        }else if (view.getId()==R.id.button1) {//+1
            scoreA.setText(String.valueOf(score_oldA+1));
        }else if(view.getId()==R.id.button6){//+3
            scoreB.setText(String.valueOf(score_oldB+3));
        } else if (view.getId()==R.id.button5) {//+2
            scoreB.setText(String.valueOf(score_oldB+2));
        }else if (view.getId()==R.id.button4) {//+1
            scoreB.setText(String.valueOf(score_oldB+1));
        }
    }
    public void reset(View view) {
        TextView scoreA=findViewById(R.id.out1);
        TextView scoreB=findViewById(R.id.out2);
        int sum=0;
        scoreA.setText(String.valueOf(sum));
        scoreB.setText(String.valueOf(sum));
    }
}