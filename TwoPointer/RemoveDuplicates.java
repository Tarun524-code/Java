package TwoPointer;

import java.util.Scanner;

public class RemoveDuplicates {
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int left = 0;
        for (int right = 1; right < nums.length; right++) {
            if (nums[right] != nums[left]) {
                left++;
                nums[left] = nums[right];
            }
        }
        return left + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter sorted array elements:");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        int newLength = removeDuplicates(arr);
        System.out.println("Array after removing duplicates:");
        for (int i = 0; i < newLength; i++) System.out.print(arr[i] + " ");
        sc.close();
    }
}
