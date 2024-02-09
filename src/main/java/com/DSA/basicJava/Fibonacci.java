package com.DSA.basicJava;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Fibonacci {
    public static void main(String[] args) {
        int n = 21;
    //    IntStream.range(0,n).mapToObj(Fibonacci::fib).filter(a -> a <n).forEach( num -> System.out.println(num+" "));
        /******************/
        fibonacciSeries(n).forEach(System.out::println);
    }
    public static int fib(int n){
        if(n <=1) return n;
        else return (n-1) + (n-2);
    }

    private static Stream<Integer> fibonacciSeries(int limit) {

    //Limit mentions how many numbers
//        return Stream.iterate(new int[]{0,1}, fib -> new int[]{fib[1],fib[0] +fib[1]})
//                .limit(limit)
//                .map(fib -> fib[0]);

        //Limit mentions till which number
        return Stream.iterate(new int[]{0,1}, fib -> new int[]{fib[1],fib[0] +fib[1]})
                .map(fib -> fib[0])
         //       .takeWhile(fib -> fib <= limit);
;
    }
}
