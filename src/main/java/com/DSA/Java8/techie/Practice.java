package com.DSA.Java8.techie;

import com.Test2.Employee;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Student{

    int id;
    String name;
    String city;

    int marks;

    public Student(int id, String name, String city, int marks) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.marks = marks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", marks=" + marks +
                '}';
    }
}
public class Practice {

    public static void practiceMap(){

        Map<Integer,Student> studentMap;
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1,"vija1","mdu1",401));
        studentList.add(new Student(2,"vija2","mdu2",402));
        studentList.add(new Student(5,"vija5","mdu5",405));
        studentList.add(new Student(3,"vija3","mdu3",403));
        studentList.add(new Student(4,"vija4","mdu4",404));

        studentMap = studentList.stream().collect(Collectors.toMap(e -> e.getId(), Function.identity()));

        studentMap.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toList());
        List<Map.Entry<Integer, Student>> list = studentMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue
                        (Comparator.comparing(Student::getMarks).thenComparing(Student::getCity).reversed()))
                .collect(Collectors.toList());

        LinkedHashMap<Integer, Student> updMap = studentMap.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.comparing(Student::getMarks).thenComparing(Student::getCity).reversed()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (l1, l2) -> l2, LinkedHashMap::new));
        System.out.println(updMap);
        System.out.println(list.stream().findFirst().get().getValue().getId());
        System.out.println(studentMap);
    }

    public static void main(String[] args) {
        String str = "ilovejavatechie";
            practiceMap();

        List<Character> map = str.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(e -> e.getValue() == 1).map(e -> e.getKey()).collect(Collectors.toList());
        System.out.println(map.stream().skip(1).findFirst().get());
        Map<Character, Long> strMap = str.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(strMap);

        System.out.println(str.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter( a -> a.getValue() > 1).map( e -> e.getKey()).collect(Collectors.toList()));

        LinkedHashMap<Character, Long> orderedMap = str.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
        System.out.println(orderedMap);

        System.out.println(   str.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new
                                , Collectors.counting()))
                .entrySet().stream().filter( e -> e.getValue() > 1).map( e -> e.getKey()).skip(1).findFirst().get());


        int[] numbers = {1,2,3,4,11,5,6,66};
        System.out.println(
        Arrays.stream(numbers).boxed().sorted(Comparator.reverseOrder())
                .skip(1).limit(1).collect(Collectors.toList()));

        String[] strArray = {"a","aa","aaaa","aaaa"};

        System.out.println(Arrays.stream(strArray).reduce((word1,word2) -> word1.length() > word2.length() ? word1 : word2));

        List<String> inttoString = Arrays.stream(numbers).mapToObj(s -> s + "").filter(s -> s.startsWith("1")).collect(Collectors.toList());

        System.out.println(inttoString);

        System.out.println( String.join("-",strArray));

        System.out.println(IntStream.range(0,10).boxed().filter( e -> e%2==0).skip(2).collect(Collectors.toList()));

    }
}
