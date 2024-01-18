package com.DSA.Java8.Map;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class SortingUsingStreams {

    public static void main(String[] args) {
        simpleSortbyKey();
        simpleSortbyValue();
        simpleSortbyValuegetAsMap();

    }

    private static void simpleSortbyValuegetAsMap() {

        System.out.println( Objectcreate().entrySet().stream()
                .sorted(Map.Entry.comparingByValue(
                        Comparator.comparing(Employee::getName).thenComparing(Employee::getCity)))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (v1, v2) -> v2, LinkedHashMap::new)));
        
    }

    private static void simpleSortbyKey() {

       // cannot be cast to class java.lang.Comparable - Runtime error
       // Objectcreate().entrySet().stream().sorted().collect(Collectors.toList());

        System.out.println("SimpleSortbyKey :"+
                Objectcreate().entrySet().stream()
                        .sorted(Map.Entry.comparingByKey())
                        .collect(Collectors.toList()));
    }

    private static void simpleSortbyValue() {
        //here the Issue is we cannot sort directly by Object as it didnot implements Comparable<Employee> and compareTo
        //Objectcreate().entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toList()));


       // Sort by both name and City
        System.out.println("SimpleSortbyValue :"+
                Objectcreate().entrySet().stream()
                        .sorted(Map.Entry.comparingByValue(Comparator.comparing(Employee::getName)
                        .thenComparing(Employee::getCity)))
                        .collect(Collectors.toList()));

    }

    public static Map<Integer,Employee> Objectcreate(){
        Map<Integer,Employee> empMap = new HashMap<>();
        empMap.put(1,new Employee(1,"Vija-1","Madurai-1", LocalDate.parse("2024-01-17")));
        empMap.put(2,new Employee(2,"Vija-3","Madurai-2", LocalDate.parse("2024-01-18")));
        empMap.put(3,new Employee(3,"Vija-4","Madurai-5", LocalDate.parse("2024-01-17")));
        empMap.put(4,new Employee(4,"Vija-2","Madurai-4", LocalDate.parse("2024-01-19")));
        return empMap;
    }

}
