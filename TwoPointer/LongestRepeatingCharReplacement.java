package TwoPointer;
import java.util.*;

public class LongestRepeatingCharReplacement {
    public static int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int left = 0, maxCount = 0, maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            count[s.charAt(right) - 'A']++;
            maxCount = Math.max(maxCount, count[s.charAt(right) - 'A']);

            while ((right - left + 1) - maxCount > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string (uppercase letters): ");
        String s = sc.nextLine();
        System.out.print("Enter k: ");
        int k = sc.nextInt();

        int result = characterReplacement(s, k);
        System.out.println("Longest substring length: " + result);
        sc.close();
    }
}

