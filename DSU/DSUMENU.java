package DSU;

import java.util.*;

public class DSUMENU {
    private static int[] parent;

    public static void init(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
    }

    public static int find(int i) {
        return parent[i] == i ? i : (parent[i] = find(parent[i]));
    }

    public static boolean union(int i, int j) {
        int r1 = find(i), r2 = find(j);
        if (r1 == r2) return false;
        parent[r2] = r1;
        return true;
    }

    public static int countGroups() {
        Set<Integer> s = new HashSet<>();
        for (int i = 0; i < parent.length; i++) s.add(find(i));
        return s.size();
    }

    public static List<List<Integer>> groups() {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < parent.length; i++) {
            map.computeIfAbsent(find(i), k -> new ArrayList<>()).add(i);
        }
        return new ArrayList<>(map.values());
    }

    private static boolean valid(int a) {
        return a >= 0 && a < parent.length;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of people: ");
        int n = sc.nextInt();
        init(n);
        while (true) {
            System.out.println("\nMenu:\n1. Add friendship\n2. Check friendship\n3. Count groups\n4. Show groups\n5. Exit");
            System.out.print("Choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1: {
                    int a = sc.nextInt(), b = sc.nextInt();
                    if (valid(a) && valid(b))
                        System.out.println(union(a, b) ? "Friendship added." : "Already friends.");
                    else System.out.println("Invalid indexes.");
                    break;
                }
                case 2: {
                    int a = sc.nextInt(), b = sc.nextInt();
                    if (valid(a) && valid(b))
                        System.out.println(find(a) == find(b) ? "Yes." : "No.");
                    else System.out.println("Invalid indexes.");
                    break;
                }
                case 3:
                    System.out.println("Groups: " + countGroups());
                    break;
                case 4:
                    for (List<Integer> g : groups()) System.out.println(g);
                    break;
                case 5:
                    System.out.println("Exiting.");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
