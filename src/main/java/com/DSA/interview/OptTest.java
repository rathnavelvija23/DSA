package com.DSA.interview;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class OptTest {

    public static void main(String[] args) {
        String s="red green white red blue white black";

       List<String> strList = Arrays.asList(s.split(" "));

        System.out.println(strList.stream().filter(i -> Collections.frequency(strList,i) == 1).collect(Collectors.toList())
       );
        List<Integer> s1 = Arrays.asList(1, 2,3,4 ,5);
        System.out.println(s1.stream().collect(Collectors.summingInt(Integer::intValue)));



    }
}
