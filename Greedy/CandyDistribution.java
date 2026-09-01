package Greedy;
import java.util.*;

public class CandyDistribution {
    public static int minCandies(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);

        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        int total = 0;
        for (int c : candies) total += c;
        return total;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of children: ");
        int n = sc.nextInt();
        int[] ratings = new int[n];
        System.out.println("Enter ratings:");
        for (int i = 0; i < n; i++) ratings[i] = sc.nextInt();

        int result = minCandies(ratings);
        System.out.println("Minimum candies required: " + result);
        sc.close();
    }
}
