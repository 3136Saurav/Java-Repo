package competitiveProgramming;

import java.util.Scanner;

public class FriendPairingDP {

    public static int friendPairTopDown(int n) {
        if (n < 2)
            return n;

        else
            return friendPairTopDown(n-1) + (n-1) * friendPairTopDown(n-2);
    }

    public static int friendPairBottomUp(int n) {
        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for (int i=2; i<=n; i++)
            dp[i] = dp[i-1] + (i-1) * dp[i-2];

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(friendPairTopDown(n));
        System.out.println(friendPairBottomUp(n));
    }
}
