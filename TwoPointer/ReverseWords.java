package TwoPointer;

import java.util.Scanner;

public class ReverseWords {
    public static String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        int left = 0, right = words.length - 1;
        while (left < right) {
            String temp = words[left];
            words[left] = words[right];
            words[right] = temp;
            left++;
            right--;
        }
        return String.join(" ", words);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string: ");
        String s = sc.nextLine();
        String result = reverseWords(s);
        System.out.println("Reversed words: " + result);
        sc.close();
    }
}

