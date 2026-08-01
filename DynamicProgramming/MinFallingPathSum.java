package DynamicProgramming;
import java.util.Scanner;

public class MinFallingPathSum {
    public static int minFallingPathSum(int[][] matrix, int n) {
        int[][] dp = new int[n][n];
        for (int j = 0; j < n; j++) dp[0][j] = matrix[0][j];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int minAbove = dp[i - 1][j];
                if (j > 0) minAbove = Math.min(minAbove, dp[i - 1][j - 1]);
                if (j < n - 1) minAbove = Math.min(minAbove, dp[i - 1][j + 1]);
                dp[i][j] = matrix[i][j] + minAbove;
            }
        }

        int result = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) result = Math.min(result, dp[n - 1][j]);
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter matrix size (n): ");
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        System.out.println("Enter matrix values:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        int result = minFallingPathSum(matrix, n);
        System.out.println("Minimum Falling Path Sum: " + result);
        sc.close();
    }
}
