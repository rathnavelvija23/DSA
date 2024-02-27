package com.Test3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Test {

    //List find out list start with 1
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,11,111);
       // 2,4,1,5,11,111

        System.out.println( list.stream().map( c-> c+"")
                .filter(c -> c.startsWith("1")).collect(Collectors.toList()));

        LinkedList<Integer> list1 = new LinkedList<>();


    }


}



