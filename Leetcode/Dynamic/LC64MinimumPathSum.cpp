#include <iostream>
#include <vector>
#include <climits>
using namespace std;

class Solution {
public:
    int recur(vector<vector<int>>& grid, int i, int j) {
        if (i == 0 && j == 0) return grid[i][j];
        if (i < 0 || j < 0) return INT_MAX;
        int left = (j > 0) ? grid[i][j] + recur(grid, i, j - 1) : INT_MAX;
        int up = (i > 0) ? grid[i][j] + recur(grid, i - 1, j) : INT_MAX;
        return min(left, up);
    }

    int memo(vector<vector<int>>& grid, int i, int j, vector<vector<int>>& dp) {
        if (i == 0 && j == 0) return grid[i][j];
        if (i < 0 || j < 0) return INT_MAX;
        if (dp[i][j] != -1) return dp[i][j];
        int left = (j > 0) ? grid[i][j] + memo(grid, i, j - 1, dp) : INT_MAX;
        int up = (i > 0) ? grid[i][j] + memo(grid, i - 1, j, dp) : INT_MAX;
        return dp[i][j] = min(left, up);
    }

    int tabulation(vector<vector<int>>& grid, int n, int m, vector<vector<int>>& dp) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0)
                    dp[i][j] = grid[i][j];
                else {
                    int left = (j > 0) ? grid[i][j] + dp[i][j - 1] : INT_MAX;
                    int up = (i > 0) ? grid[i][j] + dp[i - 1][j] : INT_MAX;
                    dp[i][j] = min(left, up);
                }
            }
        }
        return dp[n - 1][m - 1];
    }

    int space(vector<vector<int>>& grid, int n, int m) {
        vector<int> prev(m, 0);
        for (int i = 0; i < n; i++) {
            vector<int> cur(m, 0);
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0)
                    cur[j] = grid[i][j];
                else {
                    int left = (j > 0) ? grid[i][j] + cur[j - 1] : INT_MAX;
                    int up = (i > 0) ? grid[i][j] + prev[j] : INT_MAX;
                    cur[j] = min(left, up);
                }
            }
            prev = cur;
        }
        return prev[m - 1];
    }

    int minPathSum(vector<vector<int>>& grid) {
        int n = grid.size();
        int m = grid[0].size();


        // 1. Recursion (Not recommended for large grids)
        // return recur(grid, n - 1, m - 1);

        // 2. Memoization
        // vector<vector<int>> dp(n, vector<int>(m, -1));
        // return memo(grid, n - 1, m - 1, dp);

        // 3. Tabulation
        // vector<vector<int>> dp(n, vector<int>(m, 0));
        // return tabulation(grid, n, m, dp);

        // 4. Space Optimized
        return space(grid, n, m);
    }
};

// ----------------- Main Function -----------------
int main() {
    vector<vector<int>> grid = {
        {1, 3, 1},
        {1, 5, 1},
        {4, 2, 1}
    };

    Solution sol;
    int result = sol.minPathSum(grid);
    cout << "Minimum Path Sum = " << result << endl;

    return 0;
}
