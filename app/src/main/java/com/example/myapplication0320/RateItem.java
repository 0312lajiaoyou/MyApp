package com.example.myapplication0320;

public class RateItem {
    private int id;
    private String curName;
    private String curRate;
    public RateItem(String 测试币种, float v){
        super();
        curName="";
        curRate="";
    }
    public RateItem(String curName,String curRate){
        super();
        this.curName=curName;
        this.curRate=curRate;
    }
    public int getId(){
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCurName(){
        return curName;
    }
    public void setCurName(String curName) {
        this.curName = curName;
    }
    public String getCurRate(){
        return curRate;
    }
    public void setCurRate(String curRate) {
        this.curRate = curRate;
    }
}
