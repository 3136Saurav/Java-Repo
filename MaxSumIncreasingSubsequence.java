package competitiveProgramming;

import java.util.Scanner;

public class MaxSumIncreasingSubsequence {
    private static Scanner sc = new Scanner(System.in);

    public static int longestIncreasingSum(int[] arr){
        int lis[] = new int[arr.length];

        for (int i=0; i<lis.length; i++)
            lis[i] = arr[i];

        for (int i=1; i<arr.length; i++){
            for (int j=0; j<i; j++){
                if (arr[j] < arr[i] && lis[i] <= lis[j] + arr[i])
                    lis[i] = lis[j] + arr[i];
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i=0; i<lis.length; i++){
            if (max < lis[i])
                max = lis[i];
        }

        return max;
    }

    public static void main(String[] args) {

        System.out.println("Enter array size: ");
        int n = sc.nextInt();
        int arr[] = new int[n]; // 1, 101, 2, 3, 100, 4, 5

        System.out.println("Enter array elements: ");
        for (int i=0; i<arr.length; i++)
            arr[i] = sc.nextInt();

        sc.nextLine();

        System.out.println("Maximum Sum increasing subsequence is : " + longestIncreasingSum(arr));

    }

}
