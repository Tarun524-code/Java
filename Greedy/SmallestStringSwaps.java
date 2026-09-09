package Greedy;
import java.util.*;

public class SmallestStringSwaps {
    static class DSU {
        int[] parent;
        DSU(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }
        int find(int x) {
            if (parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }
        void union(int x, int y) {
            int rx = find(x), ry = find(y);
            if (rx != ry) parent[ry] = rx;
        }
    }

    public static String smallestString(String s, int[][] pairs) {
        int n = s.length();
        DSU dsu = new DSU(n);
        for (int[] p : pairs) dsu.union(p[0], p[1]);

        Map<Integer, List<Integer>> groups = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = dsu.find(i);
            groups.computeIfAbsent(root, k -> new ArrayList<>()).add(i);
        }

        char[] res = new char[n];
        for (List<Integer> group : groups.values()) {
            List<Character> chars = new ArrayList<>();
            for (int idx : group) chars.add(s.charAt(idx));
            Collections.sort(chars);
            Collections.sort(group);
            for (int i = 0; i < group.size(); i++) {
                res[group.get(i)] = chars.get(i);
            }
        }
        return new String(res);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string: ");
        String s = sc.nextLine();
        System.out.print("Enter number of pairs: ");
        int m = sc.nextInt();
        int[][] pairs = new int[m][2];
        System.out.println("Enter pairs:");
        for (int i = 0; i < m; i++) {
            pairs[i][0] = sc.nextInt();
            pairs[i][1] = sc.nextInt();
        }

        String result = smallestString(s, pairs);
        System.out.println("Lexicographically smallest string: " + result);
        sc.close();
    }
}
