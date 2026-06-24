package Graphs;
import java.util.*;

class DGALNL {
    List<List<Integer>> g;
    int n;
    DGALNL(int n){
        this.n = n;
        g = new ArrayList<>();
        for(int i=0;i<n;i++){
            g.add(new ArrayList<>());
        }
    }
    public void addEdge(int u,int v){
        g.get(u).add(v);
    }
    public void display(){
        System.out.println("Adjacency List:");
        int vertex = 0;
        for (List<Integer> neighbors : g) {
            System.out.print(vertex + " -> ");
            for (int neighbor : neighbors) {
                System.out.print(neighbor + " -> ");
            }
            System.out.println("null");
            vertex++;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();
        DGALNL g = new DGALNL(n);

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