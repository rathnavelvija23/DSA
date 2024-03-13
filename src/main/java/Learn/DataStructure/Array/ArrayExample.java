package Learn.DataStructure.Array;

import java.util.Arrays;

public class ArrayExample {

    public static void main(String[] args) {
        int[] arr=new int[5];
        arr[0]=1;
        System.out.println(Arrays.toString(arr));
        // Output -> [1, 0, 0, 0, 0]

        int[] array = {1,2,3,4};
      //  array[4] =0; --> ArrayIndexOutOfBoundsException: Index 4 out of bounds for length 4
        System.out.println(Arrays.toString(array));
        //Output [1, 2, 3, 4];
        printArray(arr);

    }

    public static void printArray(int[] arr){
        for(int i=0;i<=arr.length-1;i++){
            System.out.println(i+":::"+arr[i]);
        }
    }
}
