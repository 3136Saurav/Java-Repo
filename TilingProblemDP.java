package competitiveProgramming;

import java.util.Scanner;

public class TilingProblemDP {
    private static Scanner sc = new Scanner(System.in);

    public static int countNumberOfTiles(int n, int m){
        int count[] = new int[n+1];
        count[0] = 0;
        for (int i=1; i<n+1; i++){
            if(i < m || i == 1)
                count[i] = 1;
            else if(i == m)
                count[i] = 2;
            else
                count[i] = count[i-1] + count[i-m];
        }
        return count[n];
    }

    public static void main(String[] args) {
        System.out.println("Enter the number of rows: ");
        int n = sc.nextInt();
        System.out.println("Enter the number of columns: ");
        int m = sc.nextInt();
        System.out.println("Total number of ways: " + countNumberOfTiles(n, m));
    }
}
