package com.example.myapplication0320;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ConfigActivity extends AppCompatActivity {
    Float dollarRate2;
    Float euroRate2;
    Float wonRate2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);
    }

    public void save(View view) {
        Intent intent1 = new Intent(this, RateActivity.class);

        EditText dollarInput = findViewById(R.id.dollar);
        EditText euroInput = findViewById(R.id.euro);
        EditText wonInput = findViewById(R.id.won);
        dollarRate2 =Float.valueOf(dollarInput.getText().toString());
        euroRate2 =Float.valueOf(euroInput.getText().toString());
        wonRate2 =Float.valueOf(wonInput.getText().toString());
        //传递参数
        intent1.putExtra("dollar_key",dollarRate2);
        intent1.putExtra("euro_key",euroRate2);
        intent1.putExtra("won_key",wonRate2);

        startActivity(intent1);
    }
}