package com.Thread;

import java.util.concurrent.Executors;

public class ThreadPool {
    public static void main(String[] args) {
        Executors.newSingleThreadScheduledExecutor();
        Executors.newSingleThreadExecutor();
        Executors.newCachedThreadPool();
        Executors.newFixedThreadPool(3);
    }
}
