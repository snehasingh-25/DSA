// LC547NumberOfProvinces.java
// Leetcode 547 - Number of Provinces
// DFS approach directly on adjacency matrix

public class LC547NumberOfProvinces {

    public void dfs(int i, boolean[] vis, int[][] isConnected) {
        vis[i] = true;
        // for(int it : adj.get(i)) {
        //     if(!vis[it]) {
        //         dfs(it, vis, adj);
        //     }
        // }
        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[i][j] == 1 && !vis[j]) {
                dfs(j, vis, isConnected);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int V = isConnected.length;

        // List<List<Integer>> adj = new ArrayList<>();
        // for(int i = 0; i < V; i++) {
        //     adj.add(new ArrayList<>());
        // }
        // for(int i = 0; i < V; i++) {
        //     for(int j = 0; j < V; j++) {
        //         if(isConnected[i][j] == 1 && i != j) {
        //             adj.get(i).add(j);
        //             adj.get(j).add(i);
        //         }
        //     }
        // }

        boolean[] vis = new boolean[V];
        int cnt = 0;

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                cnt++;
                dfs(i, vis, isConnected);
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        LC547NumberOfProvinces sol = new LC547NumberOfProvinces();
        int[][] isConnected = {
            {1, 1, 0},
            {1, 1, 0},
            {0, 0, 1}
        };
        System.out.println("Number of Provinces: " + sol.findCircleNum(isConnected));
    }
}
