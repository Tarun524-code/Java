package TwoPointer;
import java.util.Scanner;

public class SortColors {
    public static void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;
        while (mid <= high) {
            if (nums[mid] == 0) {
                int temp = nums[low]; nums[low] = nums[mid]; nums[mid] = temp;
                low++; mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                int temp = nums[mid]; nums[mid] = nums[high]; nums[high] = temp;
                high--;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter array elements (0,1,2):");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        sortColors(arr);
        System.out.println("Sorted array:");
        for (int num : arr) System.out.print(num + " ");
        sc.close();
    }
}
