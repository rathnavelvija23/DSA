//package com.Test;
//
//
////"10:37:49":
//
///*binary_clock("10:37:49") ➞ [
//        " 0 0 1",
//        " 00110",
//        "001100",
//        "101101"
//        ]
//*/
//public class BinaryClock {
//
//
//    public static void main(String[] args) {
//        String date = "10:37:49";
//        modifytoBinary(date);
//    }
//
//
//    public static String findHourbinary(String hour){
//        String hourBinary="";
//        char[] ch = hour.toCharArray();
//
//       // 1248
//              addRecursion(ch[0]);
////        if(ch[0]==1)
////            hourBinary="1";
////        else if(ch[0]==2)
////            hourBinary="2";
////        else
////            System.out.println("Throw error");
//
//
//    }
//
//    private static String addRecursion(char ch) {
//        if(ch==0){
//
//        }
//    }
//
//    private static void modifytoBinary(String date) {
//        String[] splitDate = date.split(":");
//        if(splitDate.length ==3) {
//            String hour = splitDate[0];
//            String min = splitDate[1];
//            String sec = splitDate[2];
//
//            findHourbinary(hour);
//        }
//
//
//
//    }
//}
