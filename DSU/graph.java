package DSU;
import java.util.*;

class Graph {
    int n;
    int components;
    int parent[];

    public Graph(int n) {
        this.n = n;
        components = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
    }

    public int find(int i) {
        return parent[i] == i ? i : (parent[i] = find(parent[i]));
    }

    public boolean union(int i, int j) {
        int r1 = find(i), r2 = find(j);
        if (r1 == r2) return false;
        parent[r2] = r1;
        components--;
        return true;
    }

    int getComponent() {
        return components;
    }

    void printAllComponents() {
        Map<Integer, List<Integer>> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = find(i);
            hm.putIfAbsent(root, new ArrayList<>());
            hm.get(root).add(i);
        }
        System.out.println("Components:");
        for (List<Integer> comp : hm.values()) {
            System.out.println(comp);
        }
    }

    void printSpecificComponent(int node) {
        int root = find(node);
        List<Integer> comp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (find(i) == root) comp.add(i);
        }
        System.out.println("Component containing " + node + ": " + comp);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();
        Graph g = new Graph(n);

        while (true) {
            System.out.println("\n--- DSU Menu ---");
            System.out.println("1. Add edge");
            System.out.println("2. Number of components");
            System.out.println("3. All components");
            System.out.println("4. Specific component");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter two nodes to union: ");
                    int a = sc.nextInt();
                    int b = sc.nextInt();
                    if (g.union(a, b))
                        System.out.println("Edge added.");
                    else
                        System.out.println("They are already in the same component.");
                    break;

                case 2:
                    System.out.println("Number of components: " + g.getComponent());
                    break;

                case 3:
                    g.printAllComponents();
                    break;

                case 4:
                    System.out.print("Enter node: ");
                    int node = sc.nextInt();
                    g.printSpecificComponent(node);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}