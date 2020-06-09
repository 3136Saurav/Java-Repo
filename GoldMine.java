package competitiveProgramming;

public class GoldMine {
    public static int max(int a, int b){
        return a>b ?  a : b;
    }

    public static int max(int a, int b, int c){
        return max(a, max(b, c));
    }

    public static void displayGoldMine(int[][] goldMine){
        int rows = goldMine.length;
        int cols = goldMine[0].length;
        for (int r=0; r<rows; r++){
            for (int c=0; c<cols; c++){
                System.out.print(goldMine[r][c] + " ");
            }
            System.out.println();
        }
    }

    public static int computeMaxGold(int[][] mine){
        int newMine[][] = new int[mine.length][mine[0].length];

        int rows = mine.length;
        int cols = mine[0].length;
        for (int c=cols-1; c>=0; c--){
            for (int r=0; r<rows; r++){
                if (c == cols - 1)
                    newMine[r][c] = mine[r][c];
                else{
                    if (r == 0)
                        newMine[r][c] = mine[r][c] + max(newMine[r][c+1], newMine[r+1][c+1]);
                    else if (r == rows-1)
                        newMine[r][c] = mine[r][c] + max(newMine[r][c+1], newMine[r-1][c+1]);
                    else
                        newMine[r][c] = mine[r][c] + max(newMine[r][c+1], newMine[r+1][c+1], newMine[r-1][c+1]);
                }
            }
        }
        System.out.println("================================================");
        displayGoldMine(newMine);
        System.out.println("================================================");

        int maxVal = Integer.MIN_VALUE;
        for (int r=0; r<rows; r++)
            if (newMine[r][0] > maxVal)
                maxVal = newMine[r][0];

        return maxVal;
    }

    public static void main(String[] args) {
        int[][] goldMineMatrix = {{1, 3, 1, 2},
                                  {2, 5, 1, 1},
                                  {3, 1, 1, 3},
                                  {1, 2, 1, 6},
                                  {0, 6, 7, 5}};

        System.out.println("Max Gold that can be accumulated: " + computeMaxGold(goldMineMatrix));
    }

}
