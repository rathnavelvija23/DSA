package com.Test2;

import java.util.function.Function;
import java.util.stream.Collectors;

public class Test3 {

  /*  public class RemoveNumbers {

        public static void main(String[] args) {
            String str = "java8_sp3r_j9p";
       /*
       expected output = 'java#spr#jp'

        }
    } */

    public static void main(String[] args) {
        String str = "java8_sp3r_j9p";
     /*
        str.chars().mapToObj(s -> (char) s).map( s -> {
            StringBuilder sb = new StringBuilder();

            if(!Character.isDigit(s)){
                sb.append(String.valueOf(s));

            }
            sb.replace("_","#");
        })
    } */
        char[] ch = str.toCharArray();
        int length = str.toCharArray().length;
        for(int i =0; i<length;i++){
            if(!Character.isDigit(ch[i])){
                if(ch[i]=='_'){
                    System.out.print('#');
                    continue;
                }
                System.out.print(ch[i]);
            }
        }


    }
}
