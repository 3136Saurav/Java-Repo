package competitiveProgramming;

import java.util.Scanner;

public class MaxProductIncreasingSubsequence {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter Array Size: ");
        int size = sc.nextInt();
        int arr[] = new int[size];
        System.out.println("Enter Array Elements: ");
        for(int i=0; i<arr.length; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Maximum Product of Increasing Subsequence is: " + maxProdSubsequence(arr));
    }

    public static int maxProdSubsequence(int[] arr){
        int mips[] = new int[arr.length];
        for (int i=0; i<mips.length; i++)
            mips[i] = arr[i];

        for(int i=1; i<arr.length; i++){
            for(int j=0; j<i; j++){
                if( (arr[j] < arr[i]) && mips[i] < (arr[i] * mips[j]))
                    mips[i] = arr[i] * mips[j];
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i=0; i<mips.length; i++)
            if(max < mips[i])
                max = mips[i];

        return max;
    }
}
