// File: BFSGraph.java
import java.util.*;

public class BFSGraph {
    public List<Integer> bfsOfGraph(int V, List<List<Integer>> adj) {
        boolean[] vis = new boolean[V];
        List<Integer> ls = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        int start = 0;
        vis[start] = true;
        q.offer(start);

        while (!q.isEmpty()) {
            int i = q.poll();
            ls.add(i);
            for (int it : adj.get(i)) {
                if (!vis[it]) {
                    vis[it] = true;
                    q.offer(it);
                }
            }
        }
        return ls;
    }

    public static void main(String[] args) {
        int V = 5;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(3);
        adj.get(1).add(4);

        BFSGraph obj = new BFSGraph();
        List<Integer> res = obj.bfsOfGraph(V, adj);

        System.out.print("BFS Traversal: ");
        for (int node : res) System.out.print(node + " ");
        System.out.println();
    }
}
