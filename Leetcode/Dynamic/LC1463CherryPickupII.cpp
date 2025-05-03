#include <iostream>
#include <vector>
#include <climits>
using namespace std;

class Solution {
public:
    // Recursive solution (Exponential Time)
    int recur(vector<vector<int>>& grid, int n, int m, int i, int j1, int j2) {
        if (j1 < 0 || j2 < 0 || j1 >= m || j2 >= m)
            return -1e8;  // invalid positions
        if (i == n - 1) {
            // Same cell
            if (j1 == j2) return grid[i][j1];
            // Different cells
            return grid[i][j1] + grid[i][j2];
        }

        int maxi = -1e8;
        for (int dj1 = -1; dj1 <= 1; dj1++) {
            for (int dj2 = -1; dj2 <= 1; dj2++) {
                int value = (j1 == j2) ? grid[i][j1] : (grid[i][j1] + grid[i][j2]);
                value += recur(grid, n, m, i + 1, j1 + dj1, j2 + dj2);
                maxi = max(maxi, value);
            }
        }
        return maxi;
    }

    // Memoized solution (Top-down DP)
    int memo(vector<vector<int>>& grid, int n, int m, int i, int j1, int j2, vector<vector<vector<int>>>& dp) {
        if (j1 < 0 || j2 < 0 || j1 >= m || j2 >= m)
            return -1e8;
        if (i == n - 1) {
            if (j1 == j2) return dp[i][j1][j2] = grid[i][j1];
            return dp[i][j1][j2] = grid[i][j1] + grid[i][j2];
        }
        if (dp[i][j1][j2] != -1) return dp[i][j1][j2];

        int maxi = -1e8;
        for (int dj1 = -1; dj1 <= 1; dj1++) {
            for (int dj2 = -1; dj2 <= 1; dj2++) {
                int value = (j1 == j2) ? grid[i][j1] : (grid[i][j1] + grid[i][j2]);
                value += memo(grid, n, m, i + 1, j1 + dj1, j2 + dj2, dp);
                maxi = max(maxi, value);
            }
        }
        return dp[i][j1][j2] = maxi;
    }

    int cherryPickup(vector<vector<int>>& grid) {
        int n = grid.size();
        int m = grid[0].size();

        // === Recursion ===
        // return recur(grid, n, m, 0, 0, m - 1);

        // === Memoization ===
        vector<vector<vector<int>>> dp(n, vector<vector<int>>(m, vector<int>(m, -1)));
        return memo(grid, n, m, 0, 0, m - 1, dp);
    }
};

// === Optional: Driver Code for Testing ===
int main() {
    Solution sol;

    vector<vector<int>> grid = {
        {3, 1, 1},
        {2, 5, 1},
        {1, 5, 5},
        {2, 1, 1}
    };

    cout << "Maximum Cherries Collected: " << sol.cherryPickup(grid) << endl;

    return 0;
}
