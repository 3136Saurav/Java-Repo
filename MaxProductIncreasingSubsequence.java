package competitiveProgramming;

import java.util.Scanner;

public class MaxProductIncreasingSubsequence {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
//        System.out.println("Enter Array Size: ");
//        int size = sc.nextInt();
//        int arr[] = new int[size];
//        System.out.println("Enter Array Elements: ");
//        for(int i=0; i<arr.length; i++){
//            arr[i] = sc.nextInt();
//        }
        int[] arr = {3, 100, 4, 5, 150, 6, 200};
        System.out.println("Maximum Product of Increasing Subsequence is: " + maxProdSubsequence(arr));
    }

    public static int maxProdSubsequence(int[] arr) {

        int[] dp = new int[arr.length];
        for (int i=0; i<arr.length; i++)
            dp[i] = arr[i];

        for (int i=1; i<dp.length; i++) {
            for (int j=0; j<i; j++) {
                if (arr[i] > arr[j] && dp[i] <= dp[j] * arr[i])
                    dp[i] = dp[j] * arr[i];
            }
        }

        int maxProd = Integer.MIN_VALUE;
        for (int i=0; i<dp.length; i++)
            if (maxProd < dp[i])
                maxProd = dp[i];

        return maxProd;
    }
}
