package DynamicProgramming;
import java.util.Scanner;

public class DiceRollSum {
    public static int countWays(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int dice = 1; dice <= 6; dice++) {
                if (i - dice >= 0) {
                    dp[i] += dp[i - dice];
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter target sum: ");
        int n = sc.nextInt();
        int result = countWays(n);
        System.out.println("Number of ways: " + result);
        sc.close();
    }
}
