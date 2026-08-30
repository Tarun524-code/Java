package Greedy;

import java.util.*;

class Edge implements Comparable<Edge> {
    int src, dest, weight;
    Edge(int s, int d, int w) { src = s; dest = d; weight = w; }
    public int compareTo(Edge other) { return this.weight - other.weight; }
}

class DSU {
    int[] parent, rank;
    DSU(int n) {
        parent = new int[n]; rank = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
    }
    int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }
    void union(int x, int y) {
        int rx = find(x), ry = find(y);
        if (rx == ry) return;
        if (rank[rx] < rank[ry]) parent[rx] = ry;
        else if (rank[rx] > rank[ry]) parent[ry] = rx;
        else { parent[ry] = rx; rank[rx]++; }
    }
}

public class KruskalMST {
    public static int kruskal(int V, List<Edge> edges) {
        Collections.sort(edges);
        DSU dsu = new DSU(V);
        int totalWeight = 0;
        for (Edge e : edges) {
            if (dsu.find(e.src) != dsu.find(e.dest)) {
                dsu.union(e.src, e.dest);
                totalWeight += e.weight;
            }
        }
        return totalWeight;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();
        System.out.print("Enter number of edges: ");
        int E = sc.nextInt();
        List<Edge> edges = new ArrayList<>();
        System.out.println("Enter edges (src dest weight):");
        for (int i = 0; i < E; i++) {
            int s = sc.nextInt(), d = sc.nextInt(), w = sc.nextInt();
            edges.add(new Edge(s, d, w));
        }

        int result = kruskal(V, edges);
        System.out.println("Weight of MST: " + result);
        sc.close();
    }
}

