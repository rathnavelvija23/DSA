package com.DSA.Java8.Map;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class SortingUsingStreams {

    public static void main(String[] args) {
     /*   simpleSortbyKey();
        simpleSortbyValue();
        simpleSortbyValuegetAsMap();
        simpleSortbyValuegetAsMapForEach();
        modifytheDateinMap();
        markCityAsPassWhenEmpIdisabove3(); */
        simpleSortTest();

    }
    private static void simpleSortTest() {
//Key

       Map<Integer,Employee> map = new HashMap<>();
       map.put(1, new Employee(11,"Name1","City1",LocalDate.now(),20000d));
        map.put(2, new Employee(12,"Name2","City2",LocalDate.now(),20001d));
        map.put(3, new Employee(13,"Name3","City3",LocalDate.now(),20002d));
        map.put(7, new Employee(17,"Name7","City7",LocalDate.now(),20003d));
        map.put(4, new Employee(14,"Name4","City4",LocalDate.now(),20003d));
        map.put(5, new Employee(15,"Name5","City7",LocalDate.now(),20004d));
        map.put(6, new Employee(16,"Name6","City6",LocalDate.now(),20005d));

//sort by key
        System.out.println(map.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toList()));
        System.out.println(map.entrySet().stream().sorted(Map.Entry.comparingByKey(Collections.reverseOrder())).collect(Collectors.toList()));
        LinkedHashMap<Integer, Employee> out = map.entrySet().stream().sorted(Map.Entry
                        .comparingByValue(Comparator.comparing(Employee::getCity)
                                .thenComparing(Employee::getName).reversed()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (v1, v2) -> v1, LinkedHashMap::new));
        System.out.println(out);

        LinkedHashMap<Integer, Employee> out1 = map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.comparing(Employee::getCity)))
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> {
                    Employee e = entry.getValue();
                    e.setDate(LocalDate.now());
                    return e;
                }, (v1, v2) -> v1, LinkedHashMap::new));

        System.out.println(out1);

    }















    private static void markCityAsPassWhenEmpIdisabove3() {
        System.out.println("Modified Map based on condition");
        Objectcreate().entrySet().stream().collect(Collectors.toMap(
                Map.Entry::getKey,
                entry -> {
                    Employee emp = entry.getValue();
                    if(emp.getEmpId() >= 3)
                        emp.setCity("Passed verification");
                    return emp;

                }, (e1,e2) -> e1, HashMap::new
        )).forEach((k,v) -> System.out.println(k +" "+ v) );
    }

    private static void modifytheDateinMap() {
        System.out.println("Modified Map");
        Objectcreate().entrySet().stream().collect(
                Collectors.toMap(Map.Entry::getKey,
                        entry -> {
                            Employee emp = entry.getValue();
                            if(!emp.getCity().equals("Madurai-2"))
                                emp.setDate(LocalDate.now().plusDays(2));
                            return emp;
                        },(e1,e2) -> e1,LinkedHashMap::new)).forEach((k,v) -> System.out.println(k +" "+ v));

    }

    private static void simpleSortbyValuegetAsMap() {

        Map<Integer,Employee> empMap = Objectcreate().entrySet().stream()
                .sorted(Map.Entry.comparingByValue(
                        Comparator.comparing(Employee::getName).thenComparing(Employee::getCity)))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (v1, v2) -> v2, LinkedHashMap::new))
                ;
        System.out.println(empMap);
    }

    private static void simpleSortbyValuegetAsMapForEach() {

       Objectcreate().entrySet().stream()
                .sorted(Map.Entry.comparingByValue(
                        Comparator.comparing(Employee::getName).thenComparing(Employee::getCity)))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (v1, v2) -> v2, LinkedHashMap::new))
                .forEach( (k,v) ->System.out.println( k +" "+v));
    }

    private static void simpleSortbyKey() {

       // cannot be cast to class java.lang.Comparable - Runtime error
       // Objectcreate().entrySet().stream().sorted().collect(Collectors.toList());


        System.out.println("SimpleSortbyKey-Ascending :"+
                Objectcreate().entrySet().stream()
                        .sorted(Map.Entry.comparingByKey())
                        .collect(Collectors.toList()));

        System.out.println("SimpleSortbyKey-Descending :"+
                Objectcreate().entrySet().stream()
                        .sorted(Map.Entry.comparingByKey(Collections.reverseOrder()))
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

        System.out.println("SimpleSortbyKey-Descending :"+
                Objectcreate().entrySet().stream()
                        .sorted(Map.Entry.comparingByValue(Comparator.comparing(Employee::getName)
                                .thenComparing(Employee::getCity).reversed()))
                        .collect(Collectors.toList()));

    }



    public static Map<Integer,Employee> Objectcreate(){
        Map<Integer,Employee> empMap = new HashMap<>();
        empMap.put(1,new Employee(1,"Vija-1","Madurai-1", LocalDate.parse("2024-01-17"),2000));
        empMap.put(2,new Employee(6,"Vija-1","Madurai-1", LocalDate.parse("2024-01-17"),20001));
        empMap.put(3,new Employee(2,"Vija-3","Madurai-2", LocalDate.parse("2024-02-18"),20002));
        empMap.put(4,new Employee(3,"Vija-4","Madurai-5", LocalDate.parse("2024-01-17"),20003));
        empMap.put(5,new Employee(4,"Vija-2","Madurai-4", LocalDate.parse("2024-01-19"),20004));
        return empMap;
    }

}
