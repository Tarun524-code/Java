package DynamicProgramming;
import java.util.Scanner;

public class PalindromePartition {
    public static int minCut(String s) {
        int n = s.length();
        boolean[][] isPal = new boolean[n][n];
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j < 2 || isPal[j + 1][i - 1])) {
                    isPal[j][i] = true;
                    min = j == 0 ? 0 : Math.min(min, dp[j - 1] + 1);
                }
            }
            dp[i] = min;
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string: ");
        String s = sc.nextLine();
        int result = minCut(s);
        System.out.println("Minimum cuts needed: " + result);
        sc.close();
    }
}
