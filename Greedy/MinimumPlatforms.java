package Greedy;
import java.util.*;

public class MinimumPlatforms {
    public static int findPlatforms(int[] arr, int[] dep, int n) {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int platNeeded = 1, result = 1;
        int i = 1, j = 0;

        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                platNeeded++;
                i++;
            } else {
                platNeeded--;
                j++;
            }
            result = Math.max(result, platNeeded);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of trains: ");
        int n = sc.nextInt();
        int[] arr = new int[n], dep = new int[n];
        System.out.println("Enter arrival times:");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        System.out.println("Enter departure times:");
        for (int i = 0; i < n; i++) dep[i] = sc.nextInt();

        int result = findPlatforms(arr, dep, n);
        System.out.println("Minimum platforms needed: " + result);
        sc.close();
    }
}
