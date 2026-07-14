package PatternMatching;
import java.util.*;
class BoyerMooreGoodSuffix {
    private static int[] buildGoodSuffixTable(String pattern) {
        int n = pattern.length();
        int[] goodSuffix = new int[n];
        int[] suffix = new int[n];
        suffix[n - 1] = n;
        for (int i = n - 2; i >= 0; i--) {
            int j = i;
            while (j >= 0 && pattern.charAt(j) == pattern.charAt(n - 1 - (i - j))) {
                j--;
            }
            suffix[i] = i - j;
        }
        Arrays.fill(goodSuffix, n);
        int j = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (suffix[i] == i + 1) {
                for (; j < n - 1 - i; j++) {
                    if (goodSuffix[j] == n) {
                        goodSuffix[j] = n - 1 - i;
                    }
                }
            }
        }
        for (int i = 0; i <= n - 2; i++) {
            goodSuffix[n - 1 - suffix[i]] = n - 1 - i;
        }
        return goodSuffix;
    }

    public static void search(String text, String pattern) {
        int m = pattern.length();
        int n = text.length();
        int[] goodSuffix = buildGoodSuffixTable(pattern);
        int shift = 0;
        boolean found = false;
        while (shift <= n - m) {
            int j = m - 1;
            while (j >= 0 && pattern.charAt(j) == text.charAt(shift + j)) {
                j--;
            }
            if (j < 0) {
                System.out.println("Pattern found at index " + shift);
                found = true;
                shift += goodSuffix[0];
            } else {
                shift += goodSuffix[j];
            }
        }
        if (!found) {
            System.out.println("Pattern not found in the text.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String t = sc.nextLine();
        String p = sc.nextLine();
        search(t, p);
        sc.close();
    }
}