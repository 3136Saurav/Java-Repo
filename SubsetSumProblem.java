package competitiveProgramming;

import java.util.Scanner;

public class SubsetSumProblem {
    private static Scanner sc = new Scanner(System.in);

    public static boolean isSubsetSumTopDown(int sum, int[] arr, int n){
        if (sum == 0)
            return true;

        if (sum != 0 && n == 0)
            return false;

        if (arr[n-1] > sum)
            return isSubsetSumTopDown(sum, arr, n-1);

        else
            return (isSubsetSumTopDown(sum, arr, n-1) || isSubsetSumTopDown(sum - arr[n], arr, n - 1));
    }

    public static boolean isSubsetSumPresent(int[] arr, int sum){
        boolean[][] subsetMatrix = new boolean[arr.length + 1][sum + 1];
        for (int i=0; i<=arr.length; i++){
            for (int j=0; j<=sum; j++) {
                if (i == 0)
                    subsetMatrix[i][j] = false;
                if (j == 0)
                    subsetMatrix[i][j] = true;
            }
        }

        for (int i=1; i<=arr.length; i++){
            for (int j=1; j<=sum; j++){
                if( arr[i-1] > j)
                    subsetMatrix[i][j] = subsetMatrix[i-1][j];
                else{
                    subsetMatrix[i][j] = subsetMatrix[i - 1][j] || subsetMatrix[i - 1][j - arr[i-1]];
                }
            }
        }
        for (int i=0; i<=arr.length; i++){
            for (int j=0; j<=sum; j++)
                System.out.print(subsetMatrix[i][j] + " ");
            System.out.println();
        }


        return subsetMatrix[arr.length][sum];
    }

    public static void main(String[] args) {
        System.out.println("Enter Size of Array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter Array Elements: ");
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter sum: ");
        int sum = sc.nextInt();

        int N = n-1;
//        System.out.println(isSubsetSumPresent(arr, sum));
        System.out.println(isSubsetSumTopDown(sum, arr, N));
    }
}
