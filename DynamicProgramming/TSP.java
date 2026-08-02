package DynamicProgramming;
import java.util.Scanner;

public class TSP {
    static int N;
    static int[][] dist;
    static int[][] dp;

    public static int tsp(int mask, int pos) {
        if (mask == (1 << N) - 1) return dist[pos][0];
        if (dp[mask][pos] != -1) return dp[mask][pos];

        int ans = Integer.MAX_VALUE;
        for (int city = 0; city < N; city++) {
            if ((mask & (1 << city)) == 0) {
                int newAns = dist[pos][city] + tsp(mask | (1 << city), city);
                ans = Math.min(ans, newAns);
            }
        }
        return dp[mask][pos] = ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of cities: ");
        N = sc.nextInt();
        dist = new int[N][N];
        dp = new int[1 << N][N];

        System.out.println("Enter distance matrix:");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dist[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < (1 << N); i++) {
            for (int j = 0; j < N; j++) {
                dp[i][j] = -1;
            }
        }

        int result = tsp(1, 0);
        System.out.println("Minimum cost of TSP: " + result);
        sc.close();
    }
}
