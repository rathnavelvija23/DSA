package com.Test2;

import java.util.*;
import java.util.stream.Collectors;

public class SumofPrime {


    /*   Write a java program to check if any number given as input is the sum of 2 prime numbers.
       Example :
       Input - 18
       Output -
               18 = 13 + 5
               18 = 11 + 7 */
    public static void main(String[] args) {


        //  Find duplicates in the list [3,4,6,5,5,2,3] using Java stream; output is 3 & 5
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>(Arrays.asList(3, 4, 6, 5, 5, 2, 3));
        System.out.println(list.stream().filter(i -> Collections.frequency(list, i) > 1).distinct().collect(Collectors.toList()));


        int[] prime = new int[2];

        int count=0;


        while(count <2) {
            int value=scanner.nextInt();
            if (primeNumberorNot(value)) {
                prime[count] = value;
                count++;
            }else{
                System.out.println("try other");
            }
            int sum = prime[0] + prime[1];
            System.out.println(sum);

        }

    }

    public static boolean primeNumberorNot(int value){
        if(value<2){
            return false;
        }
        for(int i=2; i<=Math.sqrt(value);i++){
            if (value % i == 0) {
                return false;
            }
        }
       return true;
    }

}