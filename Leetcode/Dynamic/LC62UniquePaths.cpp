#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    // 1. Recursive approach (not used in final answer due to TLE)
    int recur(int m, int n) {
        if (m == 0 && n == 0) return 1;
        if (m < 0 || n < 0) return 0;
        int left = recur(m, n - 1);
        int up = recur(m - 1, n);
        return left + up;
    }

    // 2. Memoization (Top-down DP)
    int memo(int m, int n, vector<vector<int> >& dp) {
        if (m == 0 && n == 0) return 1;
        if (m < 0 || n < 0) return 0;
        if (dp[m][n] != -1) return dp[m][n];
        int left = memo(m, n - 1, dp);
        int up = memo(m - 1, n, dp);
        return dp[m][n] = left + up;
    }

    // 3. Tabulation (Bottom-up DP)
    int tabulation(int m, int n, vector<vector<int> >& dp) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) dp[i][j] = 1;
                else {
                    int left = (j > 0) ? dp[i][j - 1] : 0;
                    int up = (i > 0) ? dp[i - 1][j] : 0;
                    dp[i][j] = left + up;
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    // 4. Space Optimized DP (1D)
    int helperspace(int m, int n) {
        vector<int> prev(n, 0);
        for (int i = 0; i < m; i++) {
            vector<int> cur(n, 0);
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) cur[j] = 1;
                else {
                    int left = (j > 0) ? cur[j - 1] : 0;
                    int up = prev[j];
                    cur[j] = left + up;
                }
            }
            prev = cur;
        }
        return prev[n - 1];
    }

    // Main function
    int uniquePaths(int m, int n) {
        // Recursive: return recur(m - 1, n - 1); // Not efficient for large inputs

        // Memoization
        // vector<vector<int>> dp(m, vector<int>(n, -1));
        // return memo(m - 1, n - 1, dp);

        // Tabulation
        vector<vector<int> > dp(m, vector<int>(n, 0));
        return tabulation(m, n, dp);

        // Space optimized
        // return helperspace(m, n);
    }
};

// Example usage
int main() {
    Solution sol;
    int m = 3, n = 7;
    cout << "Unique paths from top-left to bottom-right: " << sol.uniquePaths(m, n) << endl;
    return 0;
}
