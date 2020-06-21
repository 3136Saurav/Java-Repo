package competitiveProgramming;

public class MinimumCostPath {

    public static int min(int a, int b, int c) {
        if (a > b)
            return b > c ? c : b;

        else
            return a > c ? c : a;
    }

    public static int minCostPathTopDown(int[][] path, int m, int n) {
        if (m<0 || n<0)
            return Integer.MAX_VALUE;

        else if(m == 0 && n == 0)
            return path[m][n];

        else
            return path[m][n] + min(minCostPathTopDown(path, m-1, n), minCostPathTopDown(path, m-1, n-1) , minCostPathTopDown(path, m, n-1));
    }

    public static int minCostPathBottomUp(int[][] path, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = path[0][0];

        for (int i=1; i<dp.length; i++){
            dp[i][0] = dp[i-1][0] + path[i][0];
        }
        for (int j=1; j<dp[0].length; j++){
            dp[0][j] = dp[0][j-1] + path[0][j];
        }

        for (int i=1; i<dp.length; i++){
            for (int j=1; j<dp[0].length; j++) {
                dp[i][j] = min(dp[i-1][j], dp[i-1][j-1], dp[i][j-1]) + path[i][j];
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        int[][] path = {{1, 2, 3},
                        {4, 8, 2},
                        {1, 5, 3}};

        int m = path.length - 1;
        int n = path[0].length - 1;
        System.out.println(m + " " + n);
        System.out.println(minCostPathTopDown(path, m, n));
        System.out.println(minCostPathBottomUp(path, m, n));

    }
}
