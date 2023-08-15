package com.java.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class AtomicVariables {
    AtomicInteger atomicInteger;
    AtomicBoolean atomicBoolean;
    AtomicLong atomicLong;

    public AtomicVariables() {
        this.atomicInteger = new AtomicInteger();
        this.atomicBoolean = new AtomicBoolean();
        this.atomicLong = new AtomicLong();
    }

    public static void main(String[] args) {
        AtomicVariables atomicVariables = new AtomicVariables();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int i = 0; i < 10; i++){
            executorService.submit(() -> System.out.println("pool 1   : " +
                    Thread.currentThread().getName() + ":  val: " + atomicVariables.atomicInteger.getAndIncrement()));
        }
        executorService.shutdown();
        System.out.println("--------------------------------------");
        executorService = Executors.newFixedThreadPool(5);
        for(int i = 0; i < 10; i++){
            executorService.submit(() -> System.out.println("pool 2   : " +
                    Thread.currentThread().getName() + ":  val: " + atomicVariables.atomicInteger.getAndDecrement()));
        }
        executorService.shutdown();
    }
}
