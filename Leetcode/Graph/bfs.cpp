// File: BFSGraph.cpp
#include <iostream>
#include <vector>
#include <queue>
using namespace std;

class Solution {
public:
    vector<int> bfsOfGraph(int V, vector<int> adj[]) {
        vector<int> res;
        vector<int> vis(V, 0);
        queue<int> q;

        q.push(0);
        vis[0] = 1;

        while (!q.empty()) {
            int node = q.front();
            q.pop();
            res.push_back(node);
            for (auto it : adj[node]) {
                if (!vis[it]) {
                    vis[it] = 1;
                    q.push(it);
                }
            }
        }

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
    vector<int> bfs_result = sol.bfsOfGraph(V, adj);

    cout << "BFS Traversal: ";
    for (int node : bfs_result) {
        cout << node << " ";
    }
    cout << endl;

    return 0;
}
