package com.Test2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Emp{
    public Emp(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    String id;
    String name;
}
public class Test {

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>(Arrays.asList("hi", "new", "gg", "new"));
        String str="wwwffgghha";

        List<Emp> empList = new ArrayList<>();
        empList.add(new Emp("1","vija"));
        empList.add(new Emp("2","vija1"));
        empList.add(new Emp("3","vija2"));
        empList.add(new Emp("4","vija1"));
        empList.add(new Emp("5","vija2"));

        Stream<Map.Entry<Character, Long>> strarray = str.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()
        )).entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        System.out.println(strarray);

        System.out.println(stringList.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())));

        System.out.println(str.chars().mapToObj( c-> (char) c).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
);

        List<String> stringList1 = empList.stream().map(e -> e.getName()).collect(Collectors.toList());
        System.out.println(stringList1.stream()
                .filter(i -> Collections.frequency(stringList1,i )==1).collect(Collectors.toList()));

        System.out.println(empList.stream().collect(Collectors.groupingBy( e -> e.getName(),Collectors.counting())));

        System.out.println(empList.stream().collect
                (Collectors.groupingBy(e -> e.getName(),
                        Collectors.summingInt(e -> Integer.valueOf(e.getId())))));

        System.out.println( empList.stream().collect(Collectors.groupingBy( e-> e.getName(), Collectors.counting()))
                .entrySet().stream().filter(e -> e.getValue() == 1).map( e-> e.getKey()).collect(Collectors.toList()));



    }
}
