package com.DSA.Java8;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class InterviewPrep {

    public static void main(String[] args) {

        int[] intArray= {1,2,3,4,6,};
        System.out.println(Arrays.stream(intArray).boxed().collect(Collectors.toList()).stream().collect(Collectors.summingInt(e -> e.intValue())));
        System.out.println(Arrays.stream(intArray).sum());
        System.out.println("before"+Arrays.toString(intArray));
        String str11="vija";


        char[] chars1 = str11.toCharArray();
        int left=0;
        int right= chars1.length-1;
        char temp;
        while(left<right){
            temp = chars1[left];
            chars1[left] = chars1[right];
            chars1[right] = temp;
            left++;
            right--;
        }
        System.out.println("Chars:::"+Arrays.toString(chars1));

        System.out.println( new String(chars1).chars().mapToObj(c -> String.valueOf((char) c)).collect(Collectors.joining()));
       String newStr = IntStream.range(0, chars1.length).mapToObj(i -> String.valueOf(chars1[i])).collect(Collectors.joining());
        System.out.println(newStr);













//
//        char[] ch=str11.toCharArray();
//        int left=0;
//        int right= str11.length()-1;
//        char temp;
//
//        while(left<right){
//            temp=ch[left];
//            ch[left]=ch[right];
//            ch[right]=temp;
//            left++;
//            right--;
//        }

//
//        int left=0;
//        int right= intArray.length-1;
//        int temp;
//        while(left<right){
//            temp = intArray[left];
//            intArray[left] = intArray[right];
//            intArray[right]=temp;
//            left++;
//            right--;
//        }
    //    System.out.println("After"+new String(ch));

//        System.out.println( IntStream.range(0,ch.length).mapToObj(i-> String.valueOf(ch[i])).collect(Collectors.joining()));

        Predicate<Integer> lessthan = i -> (i < 10);

        System.out.println(lessthan.test(20));

        Stream.iterate(new long[] {1,1}, p->new long[]{p[1],p[0]+p[1]}).limit(10)
                .forEach( p -> System.out.print(p[0]));



        Stream.iterate(new long[]{1,1}, p -> new long[]{p[1],p[0]+p[1]}).limit(10)
                .forEach(p -> System.out.println(p) );

       // Stream.iterate(new long[] {1,1}, p-> new long[]{p[1],p[0]+p[1]}).limit(5).forEach(p -> System.out.print(p[0]));



        //palindrome
        String str="abcba";
        boolean equals = str.equals(new StringBuilder(str).reverse().toString());
        IntStream.range(0,str.length()/2).noneMatch(i -> str.charAt(i) != str.charAt(str.length()-i-1));

        //Anagram
        String str1="Race";
        String str2="Care";
        char[] strArray1 =str1.toLowerCase().toCharArray(); Arrays.sort(strArray1);
        char[] strArray2 =str2.toLowerCase().toCharArray(); Arrays.sort(strArray2);
        System.out.println(Arrays.equals(strArray1,strArray2));

        //Counting
        String str3 = "my name name is name is Java";
        List<String> strList = Arrays.asList(str3.split(" "));
        System.out.println(strList.stream().collect(Collectors.groupingBy(String::valueOf,Collectors.counting())));

        //Optional.ofNullable( ) vs Optional.of
        Optional<String> optionalValueOrEmpty = Optional.ofNullable(null); //No Exception
      //  System.out.println("Value-Nullable"+optionalValueOrEmpty.get()); //if we use .get() -- NOsuchelement error will throw
       // Optional<String> optionalValue = Optional.of(null); // Nullpointer exception

        //Second Max array
        List<Integer> list = Arrays.asList(3,4,5,6,70,80,30);
        System.out.println(list.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get());

        //Steam Joining -> List<string> to string -- 2. for char list use .map(String::valueOf)
        System.out.println(strList.stream().collect(Collectors.joining(" ")));


        //Sorting a map
        Map<String, Integer> unsortMap = new HashMap<>();
        unsortMap.put("z", 10);
        unsortMap.put("b", 5);
        unsortMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        int length =0;
        for(String a: strList){
            length = length + a.length();
        }
        System.out.println("Length::"+length);
    }

}
