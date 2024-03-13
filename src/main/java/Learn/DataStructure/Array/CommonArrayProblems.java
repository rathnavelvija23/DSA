package Learn.DataStructure.Array;

import java.util.Arrays;

public class CommonArrayProblems {

    public static void main(String[] args) {
        int[] arr ={1,2,3,4};
        int[] arr2 ={1,2,3,4};
        int start =0;
       int end = arr.length-1;
       reverseWithTemp(arr2,start,end);
       reverseWithoutTemp(arr,start,end);
       findmin(arr);
       findmax(arr);

    }

    private static void findmax(int[] arr) {
    }

    private static void findmin(int[] arr) {
    }

    private static void reverseWithTemp(int[] arr, int start, int end) {

        while(start<end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void reverseWithoutTemp(int[] arr, int start, int end) {
        while(start<end){
            arr[start] = arr[start] + arr[end];
            arr[end] = arr[start] - arr[end];
            arr[start]=arr[start] - arr[end];
            start++;
            end--;
        }
        System.out.println(Arrays.toString(arr));
    }
}
