package competitiveProgramming;

import java.util.Scanner;

public class CoinChange {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter the number of types of denomination: ");
        int n = sc.nextInt();
        System.out.println("Enter the denominations: ");
        int deno[] = new int[n];
        for (int i=0; i<n; i++)
            deno[i] = sc.nextInt();
        System.out.println("Enter the Coin: ");
        int coin = sc.nextInt();
        // System.out.println("No of ways to make change of " + coin + " is: " + coinChange(deno, coin));
        // coinChange(deno, coin);
        coinChangeGFG(deno, coin);
    }

    public static void coinChangeGFG(int[] deno, int coin){
        int[][] changeMatrix = new int[coin+1][deno.length];
        int x=0, y=0;

        for(int i=0; i<deno.length; i++)
            changeMatrix[0][i] = 1;

        for (int i=1; i<coin+1; i++){
            for (int j=0; j<deno.length; j++){
                if(i >= deno[j])
                    x = changeMatrix[i-deno[j]][j];
                else
                    x = 0;

                if(j >= 1)
                    y = changeMatrix[i][j-1];
                else
                    y= 0;

                changeMatrix[i][j] = x + y;
            }
        }
        for (int i=0; i<coin+1; i++){
            for(int j=0; j<deno.length; j++){
                System.out.print(changeMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void coinChange(int[] deno, int coinVal){
        int[][] changeMatrix = new int[deno.length][coinVal+1];
        for(int i=0; i<deno.length; i++) {
            changeMatrix[i][0] = 1;
        }

        for(int j=0; j<=coinVal; j++) {
            changeMatrix[0][j] = 0;
        }

        for (int i=1; i<deno.length; i++){
            for(int j=1; j<=coinVal; j++) {
                if (j >= deno[i])
                    changeMatrix[i][j] = changeMatrix[i - 1][j] + changeMatrix[i][j - deno[i]];
                else
                    changeMatrix[i][j] = changeMatrix[i - 1][j];
            }
        }
        for (int i=0; i<deno.length; i++){
            for(int j=0; j<=coinVal; j++){
                System.out.print(changeMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
