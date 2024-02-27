package com.DSA.Java8.Map;



import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {
        Map<Integer,Employee> map = new HashMap<>();
        map.put(1,new Employee(1,"emp1","city1", LocalDate.now()));
        map.put(2,new Employee(2,"emp2","city2", LocalDate.now().plusDays(2)));
        map.put(3,new Employee(3,"emp3","city3", LocalDate.now().plusDays(3)));
        map.put(5,new Employee(5,"emp5","city5", LocalDate.now()));
        map.put(4,new Employee(4,"emp4","city4", LocalDate.now()));

        Map<Integer,String> numMap = new HashMap<>();
        numMap.put(1,"1");
        numMap.put(2,"3"); numMap.put(4,"8");
        numMap.put(3,"4"); numMap.put(7,"6");

        System.out.println(numMap.keySet().stream().max(Integer::compareTo).get());
        System.out.println( numMap.values().stream().max(String::compareTo).get());

        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1,"emp1","city1", LocalDate.now()));
        list.add(new Employee(2,"emp2","city2", LocalDate.now().plusDays(45)));
        list.add(new Employee(3,"emp3","city3", LocalDate.now().plusDays(2)));
        list.add(new Employee(7,"emp4","city4", LocalDate.now()));
        list.add(new Employee(5,"emp5","city5", LocalDate.now()));
        System.out.println("list"+list.stream().count());

        List newList = new ArrayList();
        newList.add(1);
        newList.add("2");
        newList.add(2.0d);
        System.out.println("dummy list"+newList);

        Map<String,Integer> empCity = list.stream().collect(Collectors.groupingBy(Employee::getCity,Collectors.summingInt(Employee::getEmpId)));
        System.out.println("list"+empCity);

         list.stream().collect(Collectors.groupingBy( e->
         {
            LocalDate date = e.getDate();
            return date.getMonth()+"--"+String.valueOf(date.getYear()).substring(0,2);
        }, Collectors.counting()));
        System.out.println(list.stream()
                .sorted(Comparator.comparing(Employee::getEmpId).reversed()).skip(2)
                 .collect(Collectors.toMap(Employee::getCity, Function.identity())));

        numMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(String::compareTo)).collect(Collectors.toList());

        map.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toList());
        System.out.println(map.entrySet().stream().sorted(Map.Entry.comparingByKey(Collections.reverseOrder()))
                        .collect(Collectors.toList()));


        System.out.println( map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.comparing(Employee::getCity)
                        .thenComparing(Employee::getName).reversed())).collect(Collectors.toList())
        );


        Map<Employee,Integer> sortedMap= map .entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.comparing(Employee::getDate).reversed()))
                .collect(Collectors.toMap(Map.Entry::getValue,Map.Entry::getKey,(l1,l2) -> l2, LinkedHashMap::new));

        map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.comparing(Employee::getDate)
                        .thenComparing(Employee::getName).reversed()))
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(l1,l2) -> l2 , LinkedHashMap::new));
                //.forEach((k,v) -> System.out.println("Key=="+k+"...."+"Value=="+v) );


        System.out.println("Newwwww"  +   map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.comparing(Employee::getEmpId).thenComparing(Employee::getDate).reversed())
        ).collect(Collectors.toMap(Map.Entry::getKey,
                        e ->{
            Employee d1 = e.getValue();
            d1.setCity("Updated");
            return d1;
                        },
                        (v1,v2)->v1,LinkedHashMap::new)));


















        map.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry ->
        {
            Employee emp = entry.getValue();
            if(emp.getDate().equals(LocalDate.now())){
                emp.setEmpId(Integer.valueOf(emp.getDate().getMonth().getValue()));
            }
            return emp;
        },(l1,l2) -> l2, LinkedHashMap::new)).forEach((k,v) -> System.out.println(k+"..."+v) );

        List<String> stringList = new ArrayList<>(Arrays.asList("a","b","c","c","b"));
        stringList.add(2,"f");
        System.out.println(stringList.stream().map(String::toUpperCase).collect(Collectors.joining(" ")));

        System.out.println(stringList.stream()
                .filter(i -> Collections.frequency(stringList,i) > 1).collect(Collectors.toList()));

        String input ="programming";
        Map<Character, Integer> charCountMap =  input.chars().mapToObj( c-> (char) c)
               .collect(LinkedHashMap::new,(hashMap,ch)-> hashMap.merge(ch,1,Integer::sum) ,LinkedHashMap::putAll);
        System.out.println(charCountMap);
        System.out.println( charCountMap.entrySet().stream().filter(entry -> entry.getValue() > 1).skip(1).findFirst().get().getKey());

    }
}
