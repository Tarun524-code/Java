package DSU;
import java.util.Scanner;

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

    int specificComponent(int i) {
        return find(i);
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();
        Graph g = new Graph(n);

        while (true) {
            System.out.println("\n--- DSU Menu ---");
            System.out.println("1. Union two nodes");
            System.out.println("2. Find representative of a node");
            System.out.println("3. Get number of components");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter two nodes to union: ");
                    int a = sc.nextInt();
                    int b = sc.nextInt();
                    if (g.union(a, b))
                        System.out.println("Union successful.");
                    else
                        System.out.println("They are already in the same component.");
                    break;

                case 2:
                    System.out.print("Enter node: ");
                    int node = sc.nextInt();
                    System.out.println("Representative: " + g.specificComponent(node));
                    break;

                case 3:
                    System.out.println("Number of components: " + g.getComponent());
                    break;

                case 4:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
