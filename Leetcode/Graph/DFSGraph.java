
import java.util.*;

public class DFSGraph {
    public void dfs(int i, List<List<Integer>> adj, boolean[] vis, List<Integer> ls) {
        vis[i] = true;
        ls.add(i);
        for (int it : adj.get(i)) {
            if (!vis[it]) {
                dfs(it, adj, vis, ls);
            }
        }
    }

    public List<Integer> dfsOfGraph(int V, List<List<Integer>> adj) {
        boolean[] vis = new boolean[V];
        List<Integer> ls = new ArrayList<>();
        dfs(0, adj, vis, ls); // start from node 0
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

        DFSGraph obj = new DFSGraph();
        List<Integer> res = obj.dfsOfGraph(V, adj);

        System.out.print("DFS Traversal: ");
        for (int node : res) System.out.print(node + " ");
        System.out.println();
    }
}
