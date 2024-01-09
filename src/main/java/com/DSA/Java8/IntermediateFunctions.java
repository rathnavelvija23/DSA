package com.DSA.Java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;

public class IntermediateFunctions {

    public static void main(String[] args) {
        List<Employee> emp = new ArrayList<Employee>();
        emp.add(new Employee("Dipak", "Delhi", 21));
        emp.add(new Employee("Sumit", "Delhi", 21));
        emp.add(new Employee("Karan", "Delhi", 23));
        emp.add(new Employee("Mona", "Udaipur", 23));
        emp.add(new Employee("Rajesh", "Banglore", 23));
        emp.add(new Employee("Niraj", "Banglore", 31));

        System.out.println(emp.stream().collect(Collectors.maxBy(Comparator.comparing(Employee::getAge))).get().getCity());


        Map<String,Long> empCity=emp.stream().collect(Collectors.groupingBy(Employee::getCity,
                Collectors.filtering(p -> p.getAge() > 22, counting())));
        System.out.println(empCity);
    }


}
