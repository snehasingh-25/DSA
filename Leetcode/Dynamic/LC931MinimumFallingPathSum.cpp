#include <iostream>
#include <vector>
#include <climits>
using namespace std;

class Solution {
public:
    // 1. Recursion (Exponential Time, not recommended for large inputs)
    int recur(vector<vector<int>>& matrix, int i, int j) {
        if (j < 0 || j >= matrix[0].size()) return INT_MAX;
        if (i == 0) return matrix[i][j];

        int leftdiag = recur(matrix, i - 1, j - 1);
        int up = recur(matrix, i - 1, j);
        int rightdiag = recur(matrix, i - 1, j + 1);

        return matrix[i][j] + min(up, min(leftdiag, rightdiag));
    }

    // 2. Memoization (Top-down DP)
    int memo(vector<vector<int>>& matrix, int i, int j, vector<vector<int>>& dp) {
        if (j < 0 || j >= matrix[0].size()) return INT_MAX;
        if (dp[i][j] != -1) return dp[i][j];
        if (i == 0) return dp[i][j] = matrix[i][j];

        int leftdiag = memo(matrix, i - 1, j - 1, dp);
        int up = memo(matrix, i - 1, j, dp);
        int rightdiag = memo(matrix, i - 1, j + 1, dp);

        return dp[i][j] = matrix[i][j] + min(up, min(leftdiag, rightdiag));
    }

    // 3. Tabulation (Bottom-up DP)
    int tabulation(vector<vector<int>>& matrix, int n, int m, vector<vector<int>>& dp) {
        for (int j = 0; j < m; j++) {
            dp[0][j] = matrix[0][j];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int leftdiag = (j > 0) ? dp[i - 1][j - 1] : INT_MAX;
                int up = dp[i - 1][j];
                int rightdiag = (j < m - 1) ? dp[i - 1][j + 1] : INT_MAX;

                dp[i][j] = matrix[i][j] + min(up, min(leftdiag, rightdiag));
            }
        }

        int ans = INT_MAX;
        for (int j = 0; j < m; j++) {
            ans = min(ans, dp[n - 1][j]);
        }
        return ans;
    }

    // Main function to call desired approach
    int minFallingPathSum(vector<vector<int>>& matrix) {
        int n = matrix.size();
        int m = matrix[0].size();

        // === Recursion ===
        // int ans = INT_MAX;
        // for (int j = 0; j < m; j++) {
        //     ans = min(ans, recur(matrix, n - 1, j));
        // }
        // return ans;

        // === Memoization ===
        // vector<vector<int>> dp(n, vector<int>(m, -1));
        // int ans = INT_MAX;
        // for (int j = 0; j < m; j++) {
        //     ans = min(ans, memo(matrix, n - 1, j, dp));
        // }
        // return ans;

        // === Tabulation ===
        vector<vector<int>> dp(n, vector<int>(m, 0));
        return tabulation(matrix, n, m, dp);
    }
};


int main() {
    Solution sol;

    vector<vector<int>> matrix = {
        {2, 1, 3},
        {6, 5, 4},
        {7, 8, 9}
    };

    cout << "Minimum Falling Path Sum: " << sol.minFallingPathSum(matrix) << endl;

    return 0;
}
