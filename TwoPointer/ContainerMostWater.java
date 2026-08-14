package TwoPointer;
import java.util.Scanner;

public class ContainerMostWater {
    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, area);
            if (height[left] < height[right]) left++;
            else right--;
        }
        return maxArea;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter heights:");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        int result = maxArea(arr);
        System.out.println("Maximum water area: " + result);
        sc.close();
    }
}
