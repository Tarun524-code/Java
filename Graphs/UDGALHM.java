package Graphs;
import java.util.*;
class UDGALHM {
    Map<Integer,List<Integer>> g;
    int n;
    UDGALHM(int n){
        this.n = n;
        g = new HashMap<>();
        for(int i=0;i<n;i++){
            g.put(i,new ArrayList<Integer>());
        }
    }
    public void addEdge(int u,int v){
        g.get(u).add(v);
        g.get(v).add(u);
    }
    public void display(){
        for(Map.Entry<Integer,List<Integer>> r : g.entrySet()) {
            System.out.print(r.getKey()+"->");
            List<Integer> n = r.getValue();
            for(int i=0;i<n.size();i++){
                System.out.print(n.get(i));
                if(i<n.size()-1)
                    System.out.print(", ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();
        UDGALHM g = new UDGALHM(n);

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
