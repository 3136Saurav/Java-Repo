package competitiveProgramming;

import java.util.Arrays;

public class LargesrDivisiblePairSubset {

    public static int lengthOfLargestDivisiblePairSubset(int[] arr){
        Arrays.sort(arr);
        int[] divCount = new int[arr.length];
        Arrays.fill(divCount, 1);

        for (int i=1; i<arr.length; i++){
            for (int j=0; j<i; j++){
                if (arr[i]%arr[j] == 0 && divCount[j]+1 > divCount[i])
                    divCount[i] = divCount[j] + 1;
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i=0; i<divCount.length; i++){
            if (max < divCount[i])
                max = divCount[i];
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {18, 1, 3, 6, 13, 17};
        System.out.println("Length of Largest Divisible Pair Subset is: " + lengthOfLargestDivisiblePairSubset(arr));

    }


}
