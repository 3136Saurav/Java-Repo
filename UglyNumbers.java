package competitiveProgramming;
import java.util.Scanner;

public class UglyNumbers {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter Number: ");
        int num = sc.nextInt();

        System.out.println("Nth Ugly Number is: " + calculateNthUglyNumber(num));
        System.out.println("Nth Ugly Number is: " + calculateBruteForceNthUglyNumber(num));
    }

    public static int divideGreatest(int a, int b){
        while(a % b == 0)
            a = a/b;
        return a;
    }

    public static boolean isUgly(int num){
        int no = num;
        no = divideGreatest(no, 2);
        no = divideGreatest(no, 3);
        no = divideGreatest(no, 5);
        if (no == 1)
            return true;
        return false;
    }

    public static int calculateBruteForceNthUglyNumber(int n){
        int count = 1;
        int i = 1;
        while(count < n){
            i++;
            if(isUgly(i)) {
                count++;
            }
        }
        return i;
    }

    public static int calculateNthUglyNumber(int n){
        int[] uglyList = new int[n];
        int i2 = 0, i3 = 0, i5 = 0;
        int next_number = 0;
        int next_multiple_2 = 2;
        int next_multiple_3 = 3;
        int next_multiple_5 = 5;
        uglyList[0] = 1;

        for(int i=1; i<n; i++) {
            next_number = Math.min(next_multiple_2, Math.min(next_multiple_3, next_multiple_5));

            uglyList[i] = next_number;
            if (next_number == next_multiple_2){
                i2 = i2 + 1;
                next_multiple_2 = uglyList[i2] * 2;
            }

            if (next_number == next_multiple_3){
                i3 = i3 + 1;
                next_multiple_3 = uglyList[i3] * 3;
            }

            if (next_number == next_multiple_5){
                i5 = i5 + 1;
                next_multiple_5 = uglyList[i5] * 5;
            }
        }
        return next_number;
    }
}
