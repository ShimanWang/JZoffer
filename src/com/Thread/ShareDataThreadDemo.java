package com.Thread;

public class ShareDataThreadDemo {
    class MyThread1 implements Runnable{

        @Override
        public void run() {

        }
    }

     static class MyThread2 extends Thread{

    }



    public static void main(String[] args) {
        MyThread2 m2 = new MyThread2();
        m2.start();
    }
}
