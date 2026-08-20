package TwoPointer;
import java.util.*;

public class PairSumUnsorted {
    public static boolean hasPair(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) return true;
            else if (sum < target) left++;
            else right--;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        System.out.print("Enter target sum: ");
        int target = sc.nextInt();

        boolean result = hasPair(arr, target);
        System.out.println("Pair exists: " + result);
        sc.close();
    }
}
