package competitiveProgramming;

import java.util.Scanner;

public class FriendPairingDP {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Enter the number of friends: ");
        int n = sc.nextInt();
        for(int i=0; i < DP.length; i++)
            DP[i] = -1;

        System.out.println("Number of pairs possible are: " + friendPairBottomUp(n));
        System.out.println("Number of pairs possible are: " + friendPairTopDown(n));
    }

    private static int DP[] = new int[30];

    public static int friendPairTopDown(int n){
        if(DP[n] != -1)
            return DP[n];

        if(n<=2)
            return DP[n] = n;
        else
            return DP[n] = friendPairTopDown(n-1) + (n-1) * friendPairTopDown(n-2);

    }

    public static int friendPairBottomUp(int n){
        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3; i<=n; i++){
            dp[i] = dp[i-1] + (i-1)*dp[i-2] ;
        }
        return dp[n];
    }
}
