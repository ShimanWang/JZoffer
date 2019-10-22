package com.Thread;

//懒汉模式，延迟加载
public class SingleTonDemo3 {

    public static void main(String[] args) {
        ThreadDemo threadDemo = new ThreadDemo();
        Thread t1 = new Thread(threadDemo);
        t1.start();
        Thread t2 = new Thread(threadDemo);
        t2.start();

    }
}

class ThreadDemo implements Runnable{

    @Override
    public void run() {

    }
}

class SingleTonE{
    private static SingleTonDemo3 singleTon = null;

    private SingleTonE(){}

    public static SingleTonDemo3 getInstance(){
        if(singleTon==null){
            synchronized (SingleTonE.class){
                if(singleTon==null){
                    singleTon = new SingleTonDemo3();
                }
            }
        }
        return singleTon;
    }

}
