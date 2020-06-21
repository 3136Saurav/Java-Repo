package competitiveProgramming;

public class SubsetSumProblem {

    public static boolean isSubsetSumTopDown(int sum, int[] arr, int n){
        if (n == 0 && sum!=0)
            return false;

        if (sum == 0)
            return true;

        if (sum < arr[n-1])
            return isSubsetSumTopDown(sum, arr, n-1);
        else
            return isSubsetSumTopDown(sum, arr, n-1) || isSubsetSumTopDown(sum-arr[n-1], arr, n-1);
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
//        System.out.println("Enter Size of Array: ");
//        int n = sc.nextInt();
//        int arr[] = new int[n];
//        System.out.println("Enter Array Elements: ");
//        for(int i=0; i<n; i++){
//            arr[i] = sc.nextInt();
//        }
//        System.out.println("Enter sum: ");
//        int sum = sc.nextInt();
        int n = 4;
        int[] arr = {1, 3, 6, 2};
        int sum = 12;
        int N = n;
//        System.out.println(isSubsetSumPresent(arr, sum));
        System.out.println(isSubsetSumTopDown(sum, arr, N));
    }
}
