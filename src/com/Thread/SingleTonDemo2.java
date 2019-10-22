package com.Thread;

//饿汉模式，在类加载的时候new出来对象
public class SingleTonDemo2 {
    private static SingleTonDemo2 singleTon = new SingleTonDemo2();
    private SingleTonDemo2(){}

    public static SingleTonDemo2 getInstance(){
        return singleTon;
    }
}

