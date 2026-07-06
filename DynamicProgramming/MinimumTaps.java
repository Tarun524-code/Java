package DynamicProgramming;

import java.util.*;
class MinimumTaps {
    public int minTaps(int n, int[] ranges) {
        int[] maxReach = new int[n + 1];
        for (int i = 0; i < ranges.length; i++) {
            int start = Math.max(0, i - ranges[i]);
            int end = Math.min(n, i + ranges[i]);
            maxReach[start] = Math.max(maxReach[start], end);
        }
        
        int taps = 0;
        int currentEnd = 0;
        int nextEnd = 0;
        
        for (int i = 0; i < n; i++) {
            nextEnd = Math.max(nextEnd, maxReach[i]);
            if (i == currentEnd) {
                taps++;
                currentEnd = nextEnd;
                if (currentEnd <= i) return -1;
            }
        }
        return taps;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ranges = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            ranges[i] = sc.nextInt();
        }
        MinimumTaps sol = new MinimumTaps();
        System.out.println(sol.minTaps(n, ranges));
        sc.close();
    }
}
