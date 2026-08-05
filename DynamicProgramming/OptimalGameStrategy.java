package DynamicProgramming;

import java.util.Scanner;

public class OptimalGameStrategy {
    public static int optimalStrategy(int[] arr, int n) {
        int[][] dp = new int[n][n];
        for (int gap = 0; gap < n; gap++) {
            for (int i = 0, j = gap; j < n; i++, j++) {
                int x = (i + 2) <= j ? dp[i + 2][j] : 0;
                int y = (i + 1) <= (j - 1) ? dp[i + 1][j - 1] : 0;
                int z = i <= (j - 2) ? dp[i][j - 2] : 0;
                dp[i][j] = Math.max(arr[i] + Math.min(x, y),
                                    arr[j] + Math.min(y, z));
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of coins: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter coin values:");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        int result = optimalStrategy(arr, n);
        System.out.println("Maximum value first player can collect: " + result);
        sc.close();
    }
}

