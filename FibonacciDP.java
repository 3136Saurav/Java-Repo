package competitiveProgramming;

import java.util.Scanner;

public class FibonacciDP {
    private static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {
        System.out.println("Enter Number: ");
        int num = sc.nextInt();
        System.out.println("Nth Fibonacci number is: " + fibonacciBottomUp(num));
        System.out.println("Nth Fibonacci number is: " + fibonacciTopDown(num));
    }

    public static int fibonacciBottomUp(int n){
        int fib[] = new int[n+1];
        fib[0] = 0;
        fib[1] = 1;
        for(int i=2; i<=n; i++)
            fib[i] = fib[i-1] + fib[i-2];
        return fib[n];
    }

    private static  int[] fibArray = new int[40];
    public static int fibonacciTopDown(int num){
        if (num<=1) {
            fibArray[num] = num;
            return num;
        }
        if(fibArray[num] != 0)
            return fibArray[num];
        return fibonacciTopDown(num-1) + fibonacciTopDown(num-2);
    }
}
