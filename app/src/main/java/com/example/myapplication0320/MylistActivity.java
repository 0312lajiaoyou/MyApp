package com.example.myapplication0320;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.widget.SimpleAdapter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;

public class MylistActivity extends ListActivity {
    private static final String TAG ="MylistActivity";
    private ArrayList<HashMap<String,String>> listItems;
    private SimpleAdapter listItemAdapter;
    Handler handler;
    String text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       //setListAdapter(listItemAdapter);
        handler = new Handler(Looper.getMainLooper()) {
            @Override
            public void handleMessage(@NonNull Message msg) {
                Log.i(TAG,"收到消息"+msg.what);
                if (msg.what == 8) {
                    Log.i(TAG, "handleMessage:what="+msg.what );
                    listItems=(ArrayList<HashMap<String, String>>)msg.obj;
                    listItemAdapter= new SimpleAdapter(MylistActivity.this,listItems,
                            R.layout.list_item,
                            new String[]{"itemTitle","itemDetail"},
                            new int[]{R.id.itemTitle,R.id.itemDetail});
                setListAdapter(listItemAdapter);
                }
                super.handleMessage(msg);
            }
        };
        //定义一个线程获取数据
        Thread t = new Thread(()->{
            ArrayList<HashMap<String,String>> list= new ArrayList<HashMap<String,String>>();
            int id=0;
            try {
                Document doc = Jsoup.connect("https://www.huilvzaixian.com").get();
                Elements tables = doc.getElementsByTag("ul");
                for (Element ulElement : tables) {
                    Elements liElements = ulElement.select("li");
                    for(Element liElement : liElements){
                        if(id!=0) break;
                        text=liElement.text();
                        id=1;
                    }
                }
                String[] message = text.split("\\s");
                for(int i=0;i+2<message.length;i+=3){
                    String name = message[i+1];
                    String rate = message[i+2];
                    Log.i(TAG, "run:" + name + "==>" + rate);
                    HashMap<String,String> map = new HashMap<String,String>();
                    map.put("itemTitle",name);
                    map.put("itemDetail",rate);
                    list.add(map);
                }
            }catch(MalformedURLException e) {
                e.printStackTrace();
            }catch(IOException e) {
                e.printStackTrace();
            }
            //获取MSG对象，用于返回主线程
            Message msg = handler.obtainMessage(8,list);
            handler.sendMessage(msg);
        });
        t.start();
    }

    private void initListView(){
        //数据
        listItems= new ArrayList<HashMap<String,String>>();
        for(int i=0;i<30;i++){
            HashMap<String,String> map=new HashMap<String,String>();
            map.put("itemTitle","Rate:"+i);
            map.put("itemDetail","detail"+i);
            listItems.add(map);
        }
        //生成适配器的item和动态数组对应的元素
        listItemAdapter= new SimpleAdapter(this,listItems,
                R.layout.list_item,
                new String[]{"itemTitle","itemDetail"},
                new int[]{R.id.itemTitle,R.id.itemDetail});
    }
}