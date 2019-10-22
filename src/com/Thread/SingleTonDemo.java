package com.Thread;

//单代表唯一，例代表实例
//懒汉式
public class SingleTonDemo {
    //    public static void main(String[] args) {
//        MyThread p = new MyThread();
//        Thread t1 = new Thread(p);
//        t1.start();
//        Thread t2 = new Thread(p);
//        t2.start();
//    }
//}
//
//class MyThread implements Runnable{
//
//    //run方法里面调用getInstance()
//    @Override
//    public void run() {
//        SingleTon.getInstance();
//    }
    public static void main(String[] args) {
        MyThread p = new MyThread();
        Thread t1 = new Thread(p);
        t1.start();
        Thread t2 = new Thread(p);
        t2.start();
    }

}

class MyThread implements Runnable{


    @Override
    public void run() {
        SingleTon.getInstance();
    }
}

class SingleTon {
    private static SingleTon singleTon = null;

    private SingleTon() {
        System.out.println("单例模式");
    }

    public static SingleTon getInstance() {
        if(singleTon == null){
            synchronized (SingleTon.class){
                if (singleTon == null) {
                    singleTon = new SingleTon();
                }
            }
        }
        return singleTon;
    }
}


//class SingleTon{
//
//    private static SingleTon singleTon = null;
//    private SingleTon(){
//        System.out.println("单例模式");
//    }
//
//    public static SingleTon getInstance(){
//        //二次判断，只有当第一个线程进来的时候执行这个同步块
//        if(singleTon==null){
//            synchronized (SingleTon.class){
//                if(singleTon == null){
//                    singleTon = new SingleTon();
//                }
//            }
//        }
//        return singleTon;
//    }
//}


//class SingleTon{
//    private static SingleTon singleTon = new SingleTon();
//
//    private SingleTon(){}
//
//    public static SingleTon getInstance(){
//        return singleTon;
//    }
//}

