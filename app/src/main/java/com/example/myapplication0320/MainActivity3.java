package com.example.myapplication0320;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {
    float dollarRate;
    float euroRate;
    float wonRate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        //接收传入数据
        Intent intent = getIntent();
        dollarRate = intent.getFloatExtra("dollar_key",7.24f);
        euroRate = intent.getFloatExtra("euro_key",7.80f);
        wonRate = intent.getFloatExtra("won_key",0.0054f);
        Log.i(TAG,"onCreate: get dollar2="+dollarRate);
        Log.i(TAG,"onCreate: get euro2="+euroRate);
        Log.i(TAG,"onCreate: get won2="+wonRate);

        //显示在控件中
        //dollarEdit = findViewById(R.id.dollar_edit);
        //euroEdit = findViewById(R.id.euro_edit);
        //wonEdit = findViewById(R.id.won_edit);
        //dollarEdit.setText(String.valueOf(dollarRate));
        //euroEdit.setText(String.valueOf(euroRate));
        //wonEdit.setText(String.valueOf(wonRate));
    }

    public void Click(View view) {
        //open activity
        //Intent intent = new Intent(this,MainActivity2.class);
        //startActivity(intent);

        //拨打电话
        //Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:87092173"));
        //startActivity(callIntent);

        //判断是否输入数据
        EditText rmbInput = findViewById(R.id.rmb);
        String rmb =rmbInput.getText().toString();
        if (rmb.length()==0){
            //提示消息
            Toast.makeText(this, "请输入正确的数据", Toast.LENGTH_SHORT).show();
        }else {
            float input=Float.parseFloat(rmb);
            double rmbResult= 0f;
            //判断用户按钮
            if (view.getId()==R.id.button1){
                rmbResult = input / dollarRate;
            }else if(view.getId()==R.id.button2){
                rmbResult = input / euroRate;
            }else if(view.getId()==R.id.button3){
                rmbResult = input / wonRate;
            }
            TextView result=findViewById(R.id.out);
            result.setText(String.format("%.2f",rmbResult));
        }
    }
    public void Config(View view) {
        //open activity
        Intent intent = new Intent(this,ConfigActivity.class);
        startActivity(intent);
    }

}