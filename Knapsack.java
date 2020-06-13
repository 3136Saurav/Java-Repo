package competitiveProgramming;

public class Knapsack {

    public static int max(int a, int b){
        if (a > b)
            return a;
        return b;
    }

    public static int knapsackBottomUp(int[] weight, int[] values, int maxCapacity){
        int[][] dp = new int[values.length+1][maxCapacity+1];
        for (int i=0; i< values.length; i++){
            dp[i][0] = 0;
        }
        for (int j=0; j< values.length; j++){
            dp[0][j] = 0;
        }

        for (int i=1; i<=values.length; i++){
            for (int j=1; j<=maxCapacity; j++){
                if (weight[i-1] > j)
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = max(dp[i-1][j], dp[i-1][j-weight[i-1]] + values[i-1]);
            }
        }
        return dp[values.length][maxCapacity];
    }

    public static int knapsackTopDown(int[] weight, int[] values, int maxCapacity, int n){
        if (n < 0 || maxCapacity ==0) return 0;

        if (weight[n] <= maxCapacity)
            return max(knapsackTopDown(weight, values, maxCapacity, n-1), values[n] + knapsackTopDown(weight, values, maxCapacity-weight[n], n-1));
        else
            return knapsackTopDown(weight, values, maxCapacity, n-1);
    }

    public static void main(String[] args) {
        int[] weight = {10, 20, 30};
        int[] values = {60, 100, 120};
        int maxCapacity = 50;
        int n = weight.length - 1;
        System.out.println(knapsackTopDown(weight, values, maxCapacity, n));
        System.out.println(knapsackBottomUp(weight, values, maxCapacity));

    }

}
