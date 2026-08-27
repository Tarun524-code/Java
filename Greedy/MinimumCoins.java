package Greedy;
import java.util.*;

public class MinimumCoins {
    public static int minCoins(int[] coins, int amount) {
        Arrays.sort(coins);
        int count = 0;
        for (int i = coins.length - 1; i >= 0; i--) {
            while (amount >= coins[i]) {
                amount -= coins[i];
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of coin denominations: ");
        int n = sc.nextInt();
        int[] coins = new int[n];
        System.out.println("Enter coin denominations:");
        for (int i = 0; i < n; i++) coins[i] = sc.nextInt();
        System.out.print("Enter target amount: ");
        int amount = sc.nextInt();

        int result = minCoins(coins, amount);
        System.out.println("Minimum coins required: " + result);
        sc.close();
    }
}
