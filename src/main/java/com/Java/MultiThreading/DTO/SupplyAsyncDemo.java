package com.Java.MultiThreading.DTO;

import com.Java.MultiThreading.Database.DataBase;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

public class SupplyAsyncDemo {


    public List<Employee> getEmployee() throws ExecutionException, InterruptedException {

        CompletableFuture<List<Employee>> completableList = CompletableFuture.supplyAsync(() -> {
            System.out.println("Thread:"+Thread.currentThread().getName());
            return DataBase.getEmployee();
        });

        return completableList.get();

    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        SupplyAsyncDemo supplyAsyncDemo = new SupplyAsyncDemo();
        System.out.println(supplyAsyncDemo.getEmployee());

    }
}
