package com.Test;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class JavaTest {


    public static void main(String[] args) {

        groupByJava8();
        groupbyJavaEmp();

        String s = "abcdacabc";
        String[] ch= s.split("");
        List<String> chList= Arrays.asList(ch);
        System.out.println(chList.stream().filter(i -> Collections.frequency(chList,i) ==1).collect(Collectors.toList()));
        System.out.println("Oracle"+1+2);
        System.out.println(1+2+"Oracle");

       // input --> [1,3,4,5]
       // Output--> [1,2,3,4,5]

        List<Integer> intList =Arrays.asList(1,3,4,5);
        List<Integer> intListNew =new ArrayList<>(Arrays.asList(1,3,4,5));
      //  List<Integer> intWriteList = new CopyOnWriteArrayList();
      //  intWriteList=Arrays.asList(1,3,4,5);
        intListNew.add(1,2);
        System.out.println(intListNew);
    //   intList.add(1,2);
        System.out.println("ModifiedList"+intListNew);
        int index=0;
        for(int i:intList){
            if(index==1){
                intListNew.add(2);
            }
            intListNew.add(i);
            index++;
        }
        System.out.println(intListNew);

    }

    private static void groupbyJavaEmp() {
        String s = "abcdacabc";
        String[] sArray=s.split("");
        List<String> sList=new ArrayList(Arrays.asList(sArray));
        List<String> sList1=new ArrayList(Arrays.asList(sArray));

        System.out.println("new "+Stream.of(sList,sList1).flatMap(x -> x.stream()).collect(Collectors.toList()));
        Employee emp1 = new Employee(1,"a");
        Employee emp2 = new Employee(2,"b");
        Employee emp3 = new Employee(3,"c");
        Employee emp4 = new Employee(4,"d");
        Employee emp5 = new Employee(5,"a");
        Employee emp6 = new Employee(6,"b");
        Employee emp7 = new Employee(7,"c");
       List<Employee> empList = new ArrayList<>();
       empList.add(emp1);empList.add(emp2);empList.add(emp3);empList.add(emp4);empList.add(emp5);empList.add(emp6);
       empList.add(emp7);

      Map<String,Integer> empMap = empList.stream().collect(Collectors.groupingBy(Employee::getEmpName, Collectors.summingInt(Employee::getEmpid)));

        Map<String,Integer> empMap1 = empList.stream().collect(Collectors.groupingBy( e ->
        {
             if(e.getEmpName().equals("b"))
                 e.setEmpName("z");
             return e.getEmpName();
        },Collectors.summingInt(Employee::getEmpid)));
        System.out.println("new Map" + empMap);
        System.out.println("new Map-1" + empMap1);
    }

    private static void groupByJava8() {

        String s = "abcdacabc";
        String[] sArray=s.split("");
        List<String> sList=new ArrayList(Arrays.asList(sArray));
       Map<String, Long> smap = sList.stream().collect(Collectors.groupingBy( c -> c , Collectors.counting()))
               .entrySet().stream().filter( e -> e.getValue()==1).collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));
        System.out.println(smap);
        Map<String, Long> charCountMap = sList.stream()
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        char[] ch = s.toCharArray();
        List<Character> charList = s.chars().mapToObj( c-> (char) c).collect(Collectors.toList());


    }

}


