#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    // 1. Recursive approach (not recommended due to TLE)
    int recur(vector<vector<int> >& obstacleGrid, int i, int j) {
        if (i < 0 || j < 0) return 0;
        if (obstacleGrid[i][j] == 1) return 0;
        if (i == 0 && j == 0) return 1;
        int left = recur(obstacleGrid, i, j - 1);
        int up = recur(obstacleGrid, i - 1, j);
        return left + up;
    }

    // 2. Memoization (Top-down DP)
    int memo(vector<vector<int> >& obstacleGrid, int i, int j, vector<vector<int> >& dp) {
        if (i < 0 || j < 0) return 0;
        if (obstacleGrid[i][j] == 1) return 0;
        if (i == 0 && j == 0) return 1;
        if (dp[i][j] != -1) return dp[i][j];
        int left = memo(obstacleGrid, i, j - 1, dp);
        int up = memo(obstacleGrid, i - 1, j, dp);
        return dp[i][j] = left + up;
    }

    // 3. Tabulation (Bottom-up DP)
    int tabulation(vector<vector<int> >& obstacleGrid, int n, int m, vector<vector<int> >& dp) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                } else {
                    int left = (j > 0) ? dp[i][j - 1] : 0;
                    int up = (i > 0) ? dp[i - 1][j] : 0;
                    dp[i][j] = left + up;
                }
            }
        }
        return dp[n - 1][m - 1];
    }

    // 4. Space optimized
    int space(vector<vector<int> >& obstacleGrid, int n, int m) {
        vector<int> prev(m, 0);
        for (int i = 0; i < n; i++) {
            vector<int> cur(m, 0);
            for (int j = 0; j < m; j++) {
                if (obstacleGrid[i][j] == 1) {
                    cur[j] = 0;
                } else if (i == 0 && j == 0) {
                    cur[j] = 1;
                } else {
                    int left = (j > 0) ? cur[j - 1] : 0;
                    int up = prev[j];
                    cur[j] = left + up;
                }
            }
            prev = cur;
        }
        return prev[m - 1];
    }

    // Main function
    int uniquePathsWithObstacles(vector<vector<int> >& obstacleGrid) {
        int n = obstacleGrid.size();
        int m = obstacleGrid[0].size();
        if (obstacleGrid[0][0] == 1) return 0;

        // Recursive
        // return recur(obstacleGrid, n - 1, m - 1);

        // Memoization
        // vector<vector<int>> dp(n, vector<int>(m, -1));
        // return memo(obstacleGrid, n - 1, m - 1, dp);

        // Tabulation
        // vector<vector<int>> dp(n, vector<int>(m, 0));
        // return tabulation(obstacleGrid, n, m, dp);

        // Space optimized
        return space(obstacleGrid, n, m);
    }
};

// Example usage
int main() {
    Solution sol;
    vector<vector<int> > obstacleGrid = {
        {0, 0, 0},
        {0, 1, 0},
        {0, 0, 0}
    };
    cout << "Unique paths avoiding obstacles: " << sol.uniquePathsWithObstacles(obstacleGrid) << endl;
    return 0;
}
