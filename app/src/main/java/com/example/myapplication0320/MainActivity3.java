package com.example.myapplication0320;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
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
                rmbResult = input / 7.24;
            }else if(view.getId()==R.id.button2){
                rmbResult = input / 7.80;
            }else if(view.getId()==R.id.button3){
                rmbResult = input / 0.0054;
            }
            TextView result=findViewById(R.id.out);
            result.setText(String.format("%.2f",rmbResult));
        }
    }

}