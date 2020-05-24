package competitiveProgramming;

import java.util.Scanner;

public class BellNumbers {
    private static Scanner sc =new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter number: ");
        int n = sc.nextInt();
        System.out.println("The Bell Number is: " + bellNumberComputation(n));
    }

    public static int bellNumberComputation(int n){
        int bell[][] = new int[n+1][n+1];
        bell[0][0] = 1;
        for(int i=1; i<=n; i++){
            bell[i][0] = bell[i-1][i-1];
            for (int j=1; j<=i; j++)
                bell[i][j] = bell[i-1][j] + bell[i][j-1];
        }
        return bell[n][0];
    }
}
