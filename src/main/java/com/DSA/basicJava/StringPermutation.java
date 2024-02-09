package com.DSA.basicJava;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StringPermutation {

    public static void main(String[] args) {
        String input = "abc";
        generatePermutations("", input).forEach(System.out::println);
    }

    private static java.util.List<String> generatePermutations(String prefix, String remaining) {
        return remaining.isEmpty() ?
                Arrays.asList(prefix) :
                remaining.chars()
                        .mapToObj(ch -> generatePermutations(prefix + (char) ch,
                                remaining.replaceFirst(String.valueOf((char) ch), "")))
                        .flatMap(java.util.List::stream)
                        .collect(Collectors.toList());
    }
}