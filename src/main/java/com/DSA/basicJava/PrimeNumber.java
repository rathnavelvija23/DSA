package com.DSA.basicJava;


import java.util.stream.IntStream;

public class PrimeNumber {

    public static void main(String[] args) {
        int limit = 21;

        System.out.println("Prime numbers up to " + limit + ":");
        findPrimes(limit).forEach(System.out::println);
    }

    private static IntStream findPrimes(int limit) {
         return IntStream.rangeClosed(2, limit)
                .filter(PrimeNumber::isPrime)
                 //    .filter(prime -> isPrime(limit - prime))
               // .forEach(prime -> System.out.println(limit + " = " + prime + " + " + (limit - prime)))
                ;
    }

    private static boolean isPrime(int number) {
        return IntStream.rangeClosed(2, (int) Math.sqrt(number))
                .allMatch(i -> number % i != 0);
    }
}
