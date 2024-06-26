package com.example.myapplication0320;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class Ratemanager {
    private DBHelper dbHelper;
    private String TBNAME;

    public Ratemanager(Context context) {
        dbHelper = new DBHelper(context);
        TBNAME = DBHelper.TB_NAME;
    }

    public void add(RateItem item) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("curname", item.getCurName());
        values.put("currate", item.getCurRate());
        db.insert(TBNAME, null, values);
        db.close();
    }

    public void addAll(List<RateItem> list) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        for (RateItem item : list) {
            ContentValues values = new ContentValues();
            values.put("curname", item.getCurName());
            values.put("currate", item.getCurRate());
            db.insert(TBNAME, null, values);
        }
        db.close();
    }
    public void deleteAll(){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(TBNAME,null,null);
        db.close();
    }
    public void delete(int id){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(TBNAME,"ID=?",new String[]{String.valueOf(id)});
        db.close();
    }
    public void update(RateItem item){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("curname", item.getCurName());
        values.put("currate", item.getCurRate());
        db.update(TBNAME, values,"ID=?",new String[]{String.valueOf(item.getId())});
        db.close();
    }
    @SuppressLint("Range")
    public List<RateItem> listAll(){
        List<RateItem> ratelist =null;
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor= db.query(TBNAME,null,null,null,null,null,null);
        if (cursor!=null){
            ratelist=new ArrayList<RateItem>();
            while(cursor.moveToNext()){
                RateItem item= new RateItem("测试币种", 333f);
                item.setId(cursor.getInt(cursor.getColumnIndex("ID")));
                item.setCurName(cursor.getString(cursor.getColumnIndex("CURNAME")));
                item.setCurRate(cursor.getString(cursor.getColumnIndex("CURRATE")));
                ratelist.add(item);
            }
            cursor.close();
        }
        db.close();
        return ratelist;
    }
    @SuppressLint("Range")
    public RateItem findByID(int id){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor= db.query(TBNAME,null,"ID=?",new String[]{String.valueOf(id)},null,null,null);
        RateItem rateItem=null;
        if (cursor!=null&&cursor.moveToFirst()){
            rateItem= new RateItem("测试币种", 333f);
            rateItem.setId(cursor.getInt(cursor.getColumnIndex("ID")));
            rateItem.setCurName(cursor.getString(cursor.getColumnIndex("CURNAME")));
            rateItem.setCurRate(cursor.getString(cursor.getColumnIndex("CURRATE")));
            cursor.close();
        }
        db.close();
        return rateItem;
    }
}
