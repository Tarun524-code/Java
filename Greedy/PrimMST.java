package Greedy;
import java.util.*;

public class PrimMST {
    static class Edge {
        int dest, weight;
        Edge(int d, int w) { dest = d; weight = w; }
    }

    public static int primMST(List<List<Edge>> graph, int V) {
        boolean[] visited = new boolean[V];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{0, 0});
        int totalWeight = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0], w = curr[1];
            if (visited[u]) continue;
            visited[u] = true;
            totalWeight += w;

            for (Edge e : graph.get(u)) {
                if (!visited[e.dest]) {
                    pq.add(new int[]{e.dest, e.weight});
                }
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

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) graph.add(new ArrayList<>());

        System.out.println("Enter edges (src dest weight):");
        for (int i = 0; i < E; i++) {
            int s = sc.nextInt(), d = sc.nextInt(), w = sc.nextInt();
            graph.get(s).add(new Edge(d, w));
            graph.get(d).add(new Edge(s, w));
        }

        int result = primMST(graph, V);
        System.out.println("Weight of MST: " + result);
        sc.close();
    }
}
