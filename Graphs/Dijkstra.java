package Graphs;

import java.util.*;

class Dijkstra {
    private int V;
    private List<List<Node>> adj;

    static class Node {
        int vertex, weight;
        Node(int v, int w) {
            vertex = v;
            weight = w;
        }
    }

    Dijkstra(int V) {
        this.V = V;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    void addEdge(int u, int v, int w) {
        adj.get(u).add(new Node(v, w));
        adj.get(v).add(new Node(u, w));
    }

    void dijkstra(int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.weight));
        pq.add(new Node(src, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            int u = curr.vertex;

            for (Node neighbor : adj.get(u)) {
                int v = neighbor.vertex;
                int weight = neighbor.weight;

                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.add(new Node(v, dist[v]));
                }
            }
        }

        System.out.println("Shortest distances from source " + src + ":");
        for (int i = 0; i < V; i++) {
            System.out.println("To " + i + " -> " + dist[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();
        Dijkstra g = new Dijkstra(V);

        System.out.print("Enter number of edges: ");
        int E = sc.nextInt();

        System.out.println("Enter edges (u v w):");
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            g.addEdge(u, v, w);
        }

        System.out.print("Enter source vertex: ");
        int src = sc.nextInt();

        g.dijkstra(src);
        sc.close();
    }
}
