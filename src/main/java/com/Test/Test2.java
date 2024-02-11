package com.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Test2 {

    public static void main(String[] args) {
        List<Integer> list= new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,2,3,4));

        System.out.println("Duplicated values"+list.stream().filter(i -> Collections.frequency(list,i) > 1).distinct().collect(Collectors.toList()));

    }
}
