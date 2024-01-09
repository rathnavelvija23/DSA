package com.recursion;

public class Factorial {

    private static int getFactorial(int n){
        if(n<=1) return n;
            int fact;
        fact = n*getFactorial(n-1);
        return fact;
    }

    public static void main(String[] args) {

        System.out.println(getFactorial(3));
    }
}
