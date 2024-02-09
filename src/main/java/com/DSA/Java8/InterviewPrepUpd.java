//package com.DSA.Java8;
//
//import org.springframework.util.StringUtils;
//
//import javax.sound.midi.Soundbank;
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.util.*;
//import java.util.stream.Collectors;
//
//public class InterviewPrepUpd {
//
//
//        public static void main(String[] args) {
//            List<DataEntry> dataList = List.of(
//                    new DataEntry("2022-01-01", "10"),
//                    new DataEntry("2022-01-02", "10"),
//                    new DataEntry("2022-01-03", "11"),
//                    new DataEntry("2022-02-01", "1"),
//                    new DataEntry("2022-02-02", "1"),
//                    new DataEntry("2022-02-03", "10")
//            );
//
//            //Update the date field in employee add one day to the existing dates
//            List<Employee1> emplist = new ArrayList<Employee1>();
//            emplist.add(new Employee1("Vija", "Delhi", 21, LocalDate.now()));
//            emplist.add(new Employee1("Vija-1", "Delhi1", 22, LocalDate.now()));
//            //using seprate method in employee class
//            System.out.println("data   "+ emplist.stream().map(Employee1::modifyDate).collect(Collectors.toList()));
//            //using Map
//            emplist.stream().map( e -> {
//                e.setDate(e.getDate().plusDays(1));
//                return e;
//            }).collect(Collectors.toList()).forEach(System.out::println);
//            //using ForEach
//            emplist.stream().forEach( e -> e.setDate(e.getDate().plusDays(1)));
//            emplist.stream().forEach(System.out::println);
//
//
//            // Calculate monthly sum using streams
//            Map<String, Integer> monthlySumMap = dataList.stream()
//                    .collect(Collectors.groupingBy(
//                            entry -> entry.getDate().substring(5, 7) + "-" + entry.getDate().substring(2, 4),
//                            Collectors.summingInt(entry -> Integer.parseInt(entry.getValue()))
//                    ));
//
//
//            Map<String, Integer> monthlySumMap1 = dataList.stream()
//                    .collect(Collectors.groupingBy(
//                            entry -> parseDate(entry.getDate()).getMonth().toString().toLowerCase(Locale.ENGLISH)
//                                    + "-"+ parseDate(entry.getDate()).getYear(),
//                            Collectors.summingInt(entry -> Integer.parseInt(entry.getValue()))
//                    ));
//
////
//
//
//            Map<String, Integer> map =   dataList.stream().collect(Collectors.groupingBy( e -> {
//                LocalDate date = LocalDate.parse(e.getDate());
//                return date.getMonth().toString().toLowerCase(Locale.ENGLISH)+"-"+ String.valueOf(date.getYear()).substring(2,4);
//
//
//            }, Collectors.summingInt(e -> Integer.parseInt(e.getValue()))));
//            System.out.println("Updated Map"+map);
//
//
//        }
//
//    // Function to parse date
//    private static LocalDate parseDate(String date) {
//        return LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);
//    }
//
//
//
//
//    // DataEntry class to represent each entry in the list
//        static class DataEntry {
//            private String date;
//            private String value;
//
//            public DataEntry(String date, String value) {
//                this.date = date;
//                this.value = value;
//            }
//
//            public String getDate() {
//                return date;
//            }
//
//            public String getValue() {
//                return value;
//            }
//        }
//    }