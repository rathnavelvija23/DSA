package com.DSA.practice.v2;




import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringOperations1 {

    static class  Operations{

        //("a2b4c1d3").equals("aabbbbcddd")
        static String repeatValuesbasedonCount(String str){

            String[] strArray = str.split("");
            StringBuilder builder = new StringBuilder();
            for(int i=0;i< strArray.length-1;i+=2){
                int count =  Integer.parseInt(strArray[i+1]);
                while(count >0){
                    builder.append(strArray[i]);
                    count--;
                }
            }
           return builder.toString();
        }

        // new int[]{1, 2, 3, 4, 11, 5, 6, 66}).equals("1,11") ? true : false);
        static String getIntStringStartswithOne(int[] intArray) {

            String str = Arrays.stream(intArray).mapToObj(c -> c + "").filter(c -> c.startsWith("1")).collect(Collectors.joining(","));

            System.out.println(str);

            return str;

        }
        //("java8_sp3r_j9p").equals("java#spr#jp")
        static String modifytheString(String str) {

            String collect = str.chars().mapToObj(c -> (char) c).filter(i -> !Character.isDigit(i))
                    .map(c -> c.equals('_') ? String.valueOf('#') : String.valueOf(c))
                    .collect(Collectors.joining());

            System.out.println(collect);

        return collect;



        }

        static String nonRepeatedStringFrequency(String str){

            List<String> stringList = Arrays.asList(str.split(" "));

           String out=  stringList.stream().filter( c -> Collections.frequency(stringList,c) == 1)
                   .collect(Collectors.joining(" "));
            List<String> stringList1=  stringList.stream().filter( c -> Collections.frequency(stringList,c) == 1)
                    .collect(Collectors.toList());

            System.out.println(stringList.hashCode());
            System.out.println(stringList.stream().filter( c -> Collections.frequency(stringList,c) == 1)
                    .collect(Collectors.toList()).hashCode());
            return out;

        }

        static String nonRepeatedStringGrouping(String str){

        String out    = Arrays.stream(str.split(" ")).collect(Collectors
                    .groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()))
                    .entrySet().stream().filter(e -> e.getValue() == 1)
                    .map( e-> e.getKey())
                    .collect(Collectors.joining(" "));
            System.out.println(out);
        return out;


        }

        static String countbasedonRepeatValues(String str) {

            System.out.println( str.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
            );
            String collect = str.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                    .entrySet().stream().map(entry -> String.valueOf(entry.getKey()) + String.valueOf(entry.getValue()))
                    .collect(Collectors.joining());

            System.out.println(collect);

            return collect;

        }

        static String getLongestString(String str) {

            System.out.println( Arrays.stream(str.split(" ")).reduce((word1,word2) -> word1.length() > word2.length() ?
                    word1 : word2).get());

         return Arrays.stream(str.split(" ")).reduce((word1,word2) -> word1.length() > word2.length() ?
                 word1 : word2).get();
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
