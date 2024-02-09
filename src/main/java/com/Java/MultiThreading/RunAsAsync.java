package com.Java.MultiThreading;

import com.Java.MultiThreading.DTO.Employee;
import com.Java.MultiThreading.Database.DataBase;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.*;

public class RunAsAsync {

    public void saveEmployee(File jsonFile) throws ExecutionException, InterruptedException {

        ObjectMapper objectMapper = new ObjectMapper();
        CompletableFuture<Void> runAsyncFuture = CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                try {
                    List<Employee> employeeList = objectMapper.readValue(jsonFile, new TypeReference<List<Employee>>() {
                    });
                    System.out.println("Thread:" + Thread.currentThread().getName());
                    System.out.println(employeeList.size());
                    // save employee
                    //repo.saveAll(employeeList)
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        runAsyncFuture.get();
    }

    public void saveEmployeeWithLambdaCustomexecutor(File jsonFile) throws ExecutionException, InterruptedException {

        ObjectMapper objectMapper = new ObjectMapper();
        Executor executor = Executors.newFixedThreadPool(5);
        CompletableFuture<Void> runAsyncFuture = CompletableFuture.runAsync( () -> {

                try {
                    List<Employee> employeeList = objectMapper.readValue(jsonFile, new TypeReference<List<Employee>>() {
                    });
                    System.out.println("Thread:" + Thread.currentThread().getName());
                    System.out.println(employeeList.size());
                    // save employee
                    //repo.saveAll(employeeList)
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
        },executor);
      //  runAsyncFuture.toCompletableFuture(); use to close the completablefuture
        runAsyncFuture.get();
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        RunAsAsync runasync = new RunAsAsync();
        runasync.saveEmployee(new File("employee.json"));
        runasync.saveEmployeeWithLambdaCustomexecutor(new File("employee.json"));

    }
}
