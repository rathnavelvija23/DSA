package com.DSA.practice.StringOperations;



import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringOperations {

    static class  Operations{

         static String repeatValuesbasedonCount(String str){

             StringBuilder stringBuilder = new StringBuilder();
             char[] chArray = str.toCharArray();
             for(int i =0 ;i <chArray.length;i+=2){
                 int count = Character.getNumericValue(chArray[i+1]);
                 for(int j=1;j<=count;j++){
                     stringBuilder.append(chArray[i]);
                 }
             }
             return stringBuilder.toString();
        }

        static String nonRepeatedStringFrequency(String str){
            List<String> stringList = Arrays.asList(str.split(" "));
            return stringList.stream().filter(i -> Collections.frequency(stringList,i) ==1)
                    .collect(Collectors.joining(" "));
        }

        static String nonRepeatedStringGrouping(String str){
            List<String> stringList = Arrays.asList(str.split(" "));
            return stringList.stream().collect(Collectors
                    .groupingBy( e-> e, LinkedHashMap::new, Collectors.counting()))
                    .entrySet().stream().filter( e-> e.getValue() == 1).map( e-> e.getKey())
                    .collect(Collectors.joining(" "));

        }

        static String countbasedonRepeatValues(String str) {
             StringBuilder stringBuilder = new StringBuilder();
            Map<Character, Long> value = str.chars().mapToObj(c -> (char) c)
                    .collect(Collectors
                            .groupingBy(Function.identity(), Collectors.counting()));
            value.forEach((k, v) -> stringBuilder.append(k).append(v));
             return stringBuilder.toString();
        }

        static String getLongestString(String str) {
            Optional<String> longString = Arrays.stream(str.split(" "))
                    .reduce(
                            (word1, word2) -> word1.length() > word2.length() ? word1 : word2);

        return longString.get();
        }

        static String getIntStringStartswithOne(int[] intArray) {

           return Arrays.stream(intArray).mapToObj( c -> c+"")
                     .filter( a-> a.startsWith("1")).collect(Collectors.joining(","));


        }

        static String modifytheString(String str) {
            return str.chars().mapToObj(c -> (char) c).filter( c-> !Character.isDigit(c))
                    .map( c -> c.equals('_') ? String.valueOf('#') : String.valueOf(c))
                    .collect(Collectors.joining());

        }
    }

    public static void main(String[] args) {
        System.out.println(Operations.repeatValuesbasedonCount("a2b4c1d3").equals("aabbbbcddd") ? true : false);
        System.out.println(Operations.countbasedonRepeatValues("aabbbbcddd").equals("a2b4c1d3") ? true : false);
        System.out.println(Operations.nonRepeatedStringFrequency("red green blue white red blue").equals("green white") ? true : false);
        System.out.println(Operations.nonRepeatedStringGrouping("red green blue white red blue").equals("green white") ? true : false);
        System.out.println(Operations.getLongestString("red green blue orange").equals("orange") ? true : false);
        System.out.println(Operations.getIntStringStartswithOne(new int[]{1, 2, 3, 4, 11, 5, 6, 66}).equals("1,11") ? true : false);
        System.out.println(Operations.modifytheString("java8_sp3r_j9p").equals("java#spr#jp") ? true : false);

    }
}
