package competitiveProgramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Contiguous_Array {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter Binary Array Size: ");
        int size = sc.nextInt();
        System.out.println("Enter Array Elements: ");
        int array[] = new int[size];
        for (int i=0; i<size; i++)
            array[i] = sc.nextInt();
        System.out.println("Longest Subarray length with equal no. of 0s and 1s is: " + contiguousArray(array));
    }

    public static int contiguousArray(int[] arr){
        int longest_sum = 0;
        int max = 0;
        int sum = 0;
        int[] newArray = Arrays.copyOf(arr, arr.length);
        HashMap<Integer, Integer> hmap = new HashMap<>();

        for(int i=0; i<newArray.length; i++)
            if(newArray[i] == 0)
                newArray[i] = -1;

        for(int i=0; i<newArray.length; i++){
            sum = sum + newArray[i];
            if(sum == 0)
                max = i + 1;
            else if(hmap.containsKey(sum))
                max = i - hmap.get(sum);
            else
                hmap.put(sum, i);

            if(max > longest_sum)
                longest_sum = max;
        }

        return longest_sum;
    }
}
