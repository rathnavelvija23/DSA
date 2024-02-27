package com.DSA.Java8.Map;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static com.DSA.Java8.Map.SortingUsingStreams.Objectcreate;

public class groupingByStreams {

    public static void main(String[] args) {
        groupbyCity();
        groupbyDate();

    }

    private static void groupbyDate() {
     //   "2024-01-17" , "2024-01-18", "2024-01-19"  ->> {Feburary-22 = countof empid}
        Objectcreate().values().stream().collect(Collectors.groupingBy( e-> {
              //  LocalDate date = LocalDate.parse("string value of date")
                LocalDate date = e.getDate();
            return date.getMonth()+"-"+String.valueOf(date.getYear()).substring(2,4);
                },Collectors.summingInt(Employee::getEmpId)

        )).forEach((k,v) -> System.out.println(k +"<--Key : Value -->"+ v));

















        //   "2024-01-17" , "2024-01-18", "2024-01-19"  ->> {Feburary-22 = countof empid}

        Map<String, Integer> str = Objectcreate().values().stream().collect(Collectors.groupingBy(e -> {
            Employee e1 = (Employee) e;
            return e1.getDate().getMonth().toString() + "-" + String.valueOf(e1.getDate().getYear()).substring(2,4);
        }, LinkedHashMap::new,Collectors.summingInt(Employee::getEmpId)));

        System.out.println( Objectcreate().entrySet().stream()
                .map( c-> c.getValue()).collect(Collectors.groupingBy(Employee::getCity,Collectors.counting())));
        System.out.println(str);
    }

    private static void groupbyCity() {

        //Group by city and add the count of empID
        Objectcreate().values().stream().collect(Collectors.groupingBy(
                Employee::getCity,Collectors.summingDouble(Employee::getEmpId)
        ));
           //     .forEach((k,v) -> System.out.println(k +"<--Key : Value -->"+ v));

    }

}
