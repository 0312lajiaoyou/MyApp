package com.example.myapplication0320;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import static org.jsoup.nodes.Document.OutputSettings.Syntax.html;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
public class NetActivity extends AppCompatActivity {
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net);
        handler=new Handler(Looper.myLooper()) {
            @Override
            public void handleMessage (@NonNull Message msg){
                if (msg.what == 5) {
                    Log.i(TAG, "handleMessage:getMessage msg=" + msg.obj);
                    //TextView result = findViewById(R.id.out);
                    //result.setText(str);
                }
                super.handleMessage(msg);
            }
        };
    }
    public void search(View btn) {
        Log.i(TAG, "onCreate:start Thread");
        //开启子线程
        Thread t = new Thread(this::run);
        t.start();
    }
    public void run() {
        Log.i(TAG, "run:run()......");
        //获取网络数据
        try {
            Document doc = Jsoup.connect("https://www.boc.cn/sourcedb/whpj").get();
            Element table = doc.getElementsByTag("table").get(1);
            Elements trs = table.getElementsByTag("tr");
            for (Element tr : trs) {
                Elements tds = tr.getElementsByTag("td");
                if (tds.size()>6){
                    String name = tds.get(0).text();
                    String rate = tds.get(5).text();
                    Log.i(TAG, "run:" + name + "==>" + rate);
                }
            }
        }catch(MalformedURLException e) {
            e.printStackTrace();
        }catch(IOException e) {
            e.printStackTrace();
        }
        //获取MSG对象，用于返回主线程
        Message msg = handler.obtainMessage(5,html);
        handler.sendMessage(msg);
    }
    private String inputStream2String(InputStream inputStream) throws IOException {
        final int bufferSize = 1024;
        final char[] buffer = new char[bufferSize];
        final StringBuilder out = new StringBuilder();
        Reader in = new InputStreamReader(inputStream,"utf-8");
        while(true){
            int rsz = in.read(buffer,0,buffer.length);
            if (rsz<0)
                break;
            out.append(buffer,0,rsz);
        }
        return out.toString();
    }
}