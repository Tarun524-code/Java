package Graphs;
import java.util.*;

class DGAm {
    int n;
    int[][] m;

    DGAm(int n) {
        this.n = n;
        m = new int[n][n];
    }

    public void addEdge(int u, int v) {
        m[u][v] = 1;
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();
        DGAm g = new DGAm(n);

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
        sc.close();
    }
}
