package Learn.DataStructure.Complexities;

import java.util.Scanner;

public class TimeComplexity {

    public static void main(String[] args) {
        double now = System.currentTimeMillis();
        System.out.println(getSumOfNumbers(99999));
        System.out.println(System.currentTimeMillis()-now);

    }

    private static int getSumOfNumbers(int n) {
       // return n*(n+1)/2;
        int sum=0;
        int i=1;
        while(i<=n){
            sum = sum +i;
            i++;
        }

        return sum;
    }
}
