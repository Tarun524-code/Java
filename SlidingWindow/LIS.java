package SlidingWindow;
import java.util.Scanner;

public class LIS {
    public static int lis(int[] arr, int n) {
        int[] dp = new int[n];
        int max = 1;
        for (int i = 0; i < n; i++) dp[i] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
            if (dp[i] > max) max = dp[i];
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        int result = lis(arr, n);
        System.out.println("Length of LIS: " + result);
        sc.close();
    }
}
