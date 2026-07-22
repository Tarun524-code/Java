package DynamicProgramming;
import java.util.Scanner;

public class MatrixChain {
    public static int matrixChainOrder(int[] p, int n) {
        int[][] dp = new int[n][n];
        for (int len = 2; len < n; len++) {
            for (int i = 0; i < n - len; i++) {
                int j = i + len;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    int cost = dp[i][k] + dp[k][j] + p[i] * p[k] * p[j];
                    if (cost < dp[i][j]) dp[i][j] = cost;
                }
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of matrices: ");
        int n = sc.nextInt();
        int[] p = new int[n + 1];
        System.out.println("Enter dimensions array (length " + (n + 1) + "):");
        for (int i = 0; i <= n; i++) p[i] = sc.nextInt();
        int result = matrixChainOrder(p, n + 1);
        System.out.println("Minimum multiplications: " + result);
        sc.close();
    }
}
