package com.java.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceDemo {
    private AtomicReference<Employee> employeeAtomicReference;

    public AtomicReferenceDemo() {
        this.employeeAtomicReference = new AtomicReference<>();
    }

    public static void main(String[] args) {
        AtomicReferenceDemo obj = new AtomicReferenceDemo();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for(int i = 0; i < 10; i++){
            //System.out.println(obj.employeeAtomicReference.getAndUpdate();
        }
        executorService.shutdown();
    }
}

class Employee{
    private Integer id;
    private String name;

    public Employee(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
