package Graphs;
import java.util.*;

class UDGAm {
    int n;
    int[][] m;

    UDGAm(int n) {
        this.n = n;
        m = new int[n][n];
    }

    public void addEdge(int u, int v) {
        m[u][v] = 1;
        m[v][u] = 1;
    }

    public void display() {
        System.out.println("Adjacency Matrix:");
        for (int[] row : m) {
            for (int x : row) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }

    public void dfs(int s, boolean visited[]) {
        visited[s] = true;
        System.out.print(s + " ");

        for (int i = 0; i < n; i++) {
            if (m[s][i] == 1 && !visited[i]) {
                dfs(i, visited);
            }
        }
    }

    public void dfsIterative(int s) {
        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(s);

        while (!stack.isEmpty()) {
            int u = stack.pop();
            if (visited[u]) {
                continue;
            }
            visited[u] = true;
            System.out.print(u + " ");

            for (int i = n - 1; i >= 0; i--) {
                if (m[u][i] == 1 && !visited[i]) {
                    stack.push(i);
                }
            }
        }
    }

    public void search(Scanner sc) {
    while (true) {
        System.out.print("Enter starting vertex for DFS (-1 to quit): ");
        int s = sc.nextInt();
        if (s == -1) {
            break;
        }
        if (s < 0 || s >= n) {
            System.out.println("Invalid start vertex");
            continue;
        }

        boolean[] visited = new boolean[n];
        System.out.println("DFS traversal starting from vertex " + s + ": ");

        while (true) {
            System.out.println("1. With Recursion");
            System.out.println("2. Without Recursion");
            System.out.println("3. Exit DFS menu");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    dfs(s, visited);
                    System.out.println();
                    break;
                case 2:
                    dfsIterative(s);
                    System.out.println();
                    break;
                case 3:
                    System.out.println("Exiting DFS menu...");
                    return;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }
}


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();
        UDGAm g = new UDGAm(n);

        while (true) {
            System.out.print("Enter edge (u v): ");
            int u = sc.nextInt();
            int v = sc.nextInt();
            g.addEdge(u, v);

            System.out.print("Enter -1 to quit or any other number to continue: ");
            int ch = sc.nextInt();
            if (ch == -1) break;
        }

        g.display();

        g.search(sc);

        sc.close();
    }
}
