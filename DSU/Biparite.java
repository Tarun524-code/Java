package DSU;

import java.util.Scanner;

public class Biparite {
    private int[] parent;
    private int[] rank;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int[][] graph = new int[n][];
        
        for (int i = 0; i < n; i++) {
            int numNeighbors = sc.nextInt();
            graph[i] = new int[numNeighbors];
            for (int j = 0; j < numNeighbors; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        Biparite b = new Biparite();
        boolean result = b.isBipartite(graph);
        System.out.println(result);
        sc.close();
    }

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        parent = new int[n];
        rank = new int[n];
        
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int u = 0; u < n; u++) {
            for (int v : graph[u]) {
                if (find(u) == find(v)) {
                    return false;
                }
                union(graph[u][0], v);
            }
        }
        return true;
    }

    private int find(int i) {
        if (parent[i] == i) {
            return i;
        }
        return parent[i] = find(parent[i]);
    }

    private void union(int i, int j) {
        int rootI = find(i);
        int rootJ = find(j);
        if (rootI != rootJ) {
            if (rank[rootI] < rank[rootJ]) {
                parent[rootI] = rootJ;
            } else if (rank[rootI] > rank[rootJ]) {
                parent[rootJ] = rootI;
            } else {
                parent[rootJ] = rootI;
                rank[rootI]++;
            }
        }
    }
}
