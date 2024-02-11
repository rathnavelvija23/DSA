package com.DSA.interview;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//   Program using streams to print Fibonacci series till 21
    //    Program to reverse eachword of a given string using java 8
   //     Program to merge two unsorted arrays into a sorted array
public class AltTest{

    public static void main(String[] args) {

//        IntStream.range(0, count)
//                .forEach(i -> {
//                    if (i < 2) {
//                        fibonacciSeries[i] = i;
//                    } else {
//                        fibonacciSeries[i] = fibonacciSeries[i - 1] + fibonacciSeries[i - 2];
//                    }
//                });
//
//        List<Integer> result = myList.stream().filter(i -> Collections.frequency((list,i) ==1))
//                .filter(i -> Collections.frequency(myList, i) == 1)
//                .collect(toList());

        String str = "Coding interview with Alt";
        String[] strArray= str.split(" ");
        List<String> strList = Arrays.asList(strArray);
        System.out.println(strList.stream().map( s-> new StringBuilder(s).reverse()).collect(Collectors.toList()));

        List<String> mlist = strList.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        System.out.println(mlist);

    List<Integer> list1 = Arrays.asList(1,2,3,4,5);
    List<Integer> list2 = Arrays.asList(2,3,4,5);

      //  list1.stream().sorted().c
        System.out.println(Stream.of(list1,list2).flatMap(x -> x.stream()).sorted().collect(Collectors.toList()));

    }
}
