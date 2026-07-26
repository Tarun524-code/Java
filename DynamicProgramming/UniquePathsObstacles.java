package DynamicProgramming;
import java.util.Scanner;

public class UniquePathsObstacles {
    public static int uniquePathsWithObstacles(int[][] grid, int n, int m) {
        if (grid[0][0] == 1) return 0;
        int[][] dp = new int[n][m];
        dp[0][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    if (i > 0) dp[i][j] += dp[i - 1][j];
                    if (j > 0) dp[i][j] += dp[i][j - 1];
                }
            }
        }
        return dp[n - 1][m - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int n = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int m = sc.nextInt();
        int[][] grid = new int[n][m];
        System.out.println("Enter grid values (0 free, 1 obstacle):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        int result = uniquePathsWithObstacles(grid, n, m);
        System.out.println("Unique paths: " + result);
        sc.close();
    }
}
