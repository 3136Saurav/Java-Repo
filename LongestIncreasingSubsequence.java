package competitiveProgramming;

import java.util.Scanner;

public class LongestIncreasingSubsequence {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter the Array Size: ");
        int size = sc.nextInt();
        System.out.println("Enter Array elements: ");
        int arr[] = new int[size];
        for(int i=0; i<size; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Longest Increasing Subsequence is: " + lis(arr));
    }

    public static int lis(int[] arr){
        int lis[] = new int[arr.length];
        for(int i=0; i<lis.length; i++)
            lis[i] = 1;

        for(int i=1; i<arr.length; i++){
            for(int j=0; j<i; j++){
                if(arr[j] < arr[i] && lis[i] < lis[j]+1){
                    lis[i] = lis[j] + 1;
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i=0; i<lis.length; i++)
            if(max < lis[i])
                max = lis[i];

        return max;
    }
}
