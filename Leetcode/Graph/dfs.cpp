// File: DFSGraph.cpp
#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    void dfs(int node, vector<int> adj[], vector<int> &vis, vector<int> &res) {
        vis[node] = 1;
        res.push_back(node);
        for (auto it : adj[node]) {
            if (!vis[it]) {
                dfs(it, adj, vis, res);
            }
        }
    }

    vector<int> dfsOfGraph(int V, vector<int> adj[]) {
        vector<int> res;
        vector<int> vis(V, 0);
        dfs(0, adj, vis, res);  // Starting DFS from node 0
        return res;
    }
};

int main() {
    int V = 5;
    vector<int> adj[V];

    // Example graph:
    adj[0] = {1, 2};
    adj[1] = {3, 4};
    // adj[2], adj[3], adj[4] are empty or implicitly initialized

    Solution sol;
    vector<int> dfs_result = sol.dfsOfGraph(V, adj);

    cout << "DFS Traversal: ";
    for (int node : dfs_result) {
        cout << node << " ";
    }
    cout << endl;

    return 0;
}
//     0
//    / \
//   v   v
//   1   2
//  / \
// v   v
// 3   4
