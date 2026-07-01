package Graphs;
import java.util.*;

public class TopoSort {
    HashMap<Integer, List<Integer>> g;
    int n;

    public TopoSort(int n) {
        this.n = n;
        g = new HashMap<>();
        for (int i = 0; i < n; i++) {
            g.put(i, new ArrayList<>());
        }
    }

    public void addEdge(int u, int v) {
        g.get(u).add(v);
    }

    public List<Integer> topoSortDFS() {
        boolean[] visited = new boolean[n];
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, visited, s);
            }
        }

        List<Integer> res = new ArrayList<>();
        while (!s.isEmpty()) {
            res.add(s.pop());
        }
        return res;
    }

    void dfs(int node, boolean[] visited, Stack<Integer> st) {
        visited[node] = true;

        for (int nei : g.get(node)) {
            if (!visited[nei]) {
                dfs(nei, visited, st);
            }
        }
        st.push(node);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();
        TopoSort graph = new TopoSort(n);

        System.out.print("Enter number of edges: ");
        int m = sc.nextInt();

        System.out.println("Enter edges (u v) for directed graph:");
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.addEdge(u, v);
        }

        List<Integer> order = graph.topoSortDFS();
        System.out.println("Topological Sort:");
        for (int x : order) {
            System.out.print(x + " ");
        }
        sc.close();
    }
}
