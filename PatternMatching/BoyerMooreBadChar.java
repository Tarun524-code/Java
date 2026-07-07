package PatternMatching;

import java.util.*;

public class BoyerMooreBadChar {
    
    private static int[] buildBadCharTable(String pattern) {
        final int ALPHABET_SIZE = 256;
        int[] badChar = new int[ALPHABET_SIZE];
        Arrays.fill(badChar, -1);
        for (int i = 0; i < pattern.length(); i++) {
            badChar[(int) pattern.charAt(i)] = i;
        }
        return badChar;
    }
    
    public static void search(String text, String pattern) {
        int m = pattern.length();
        int n = text.length();
        int[] badChar = buildBadCharTable(pattern);
        int shift = 0;
        boolean found = false;
        
        while (shift <= (n - m)) {
            int j = m - 1;
            while (j >= 0 && pattern.charAt(j) == text.charAt(shift + j)) {
                j--;
            }
            if (j < 0) {
                System.out.println("Pattern found at index " + shift);
                found = true;
                shift += (shift + m < n) ? m - badChar[text.charAt(shift + m)] : 1;
            } else {
                shift += Math.max(1, j - badChar[text.charAt(shift + j)]);
            }
        }
        
        if (!found) {
            System.out.println("Pattern not found in the text.");
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the text: ");
        String text = sc.nextLine();
        System.out.print("Enter the pattern: ");
        String pattern = sc.nextLine();
        System.out.println("\nSearching...");
        search(text, pattern);
        sc.close();
    }
}
