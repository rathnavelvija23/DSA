package com.Java.MultiThreading;


import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class FutureTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Future<List<Integer>> future1 = executorService.submit(() -> {
            System.out.println("Thread:" + Thread.currentThread().getName().toLowerCase());
            delay(1);
            return Arrays.asList(1,2,3,6);
        }); //runnable will not return callable return future

        Future<List<Integer>> future2 = executorService.submit(() -> {
            System.out.println("Thread:" + Thread.currentThread().getName().toLowerCase());
            delay(1);
            return Arrays.asList(1,2,3,6);
        }); //runnable will not return callable return future


        List<Integer> list = future1.get();
        //no complete method
        //no method to pass the output of above future
        //no chaining mechanism like future1.future2(like joining);

        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        completableFuture.get();
       // completableFuture.thenRunAsync();

    }

    private static void delay(int min)  {
        try {
            TimeUnit.MINUTES.sleep(min);
        }catch(InterruptedException ex){
            System.out.println("Exception Occured"+ ex.getMessage());
        }
    }
}
