#include <iostream>
#include <vector>
#include <climits>
using namespace std;

class Solution
{
public:
    // 1. Recursion (not recommended for large input)
    int recur(vector<vector<int>> &triangle, int n, int i, int j)
    {
        if (i == n - 1)
            return triangle[i][j];
        int down = triangle[i][j] + recur(triangle, n, i + 1, j);
        int diag = triangle[i][j] + recur(triangle, n, i + 1, j + 1);
        return min(down, diag);
    }

    // 2. Memoization (Top-down DP)
    int memo(vector<vector<int>> &triangle, int n, int i, int j, vector<vector<int>> &dp)
    {
        if (i == n - 1)
            return triangle[i][j];
        if (dp[i][j] != -1)
            return dp[i][j];
        int down = triangle[i][j] + memo(triangle, n, i + 1, j, dp);
        int diag = triangle[i][j] + memo(triangle, n, i + 1, j + 1, dp);
        return dp[i][j] = min(down, diag);
    }

    // 3. Tabulation (Bottom-up DP)
    int tabulation(vector<vector<int>> &triangle, int n,
                   vector<vector<int>> &dp)
    {
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < i + 1; j++)
            {
                if (i == 0 && j == 0)
                    dp[i][j] = triangle[i][j];
                else
                {
                    int up = (j < i) ? triangle[i][j] + dp[i - 1][j] : INT_MAX;
                    int diag =
                        (j > 0) ? triangle[i][j] + dp[i - 1][j - 1] : INT_MAX;
                    dp[i][j] = min(up, diag);
                }
            }
        }
        int ans = INT_MAX;
        for (int j = 0; j < n; j++)
        {
            ans = min(ans, dp[n - 1][j]);
        }
        return ans;
        //return *min_element(dp[n - 1].begin(), dp[n - 1].end());
    }
    int space(vector<vector<int>> &triangle, int n)
    {
        vector<int> prev(1);
        prev[0] = triangle[0][0];
        for (int i = 0; i < n; i++)
        {
            vector<int> cur(i + 1, 0);
            for (int j = 0; j < i + 1; j++)
            {
                if (i == 0 && j == 0)
                    cur[j] = triangle[i][j];
                else
                {
                    int up = (j < i) ? triangle[i][j] + prev[j] : INT_MAX;
                    int diag =
                        (j > 0) ? triangle[i][j] + prev[j - 1] : INT_MAX;
                    cur[j] = min(up, diag);
                }
            }
            prev = cur;
        }
        int ans = INT_MAX;
        for (int j = 0; j < n; j++)
        {
            ans = min(ans, prev[j]);
        }
        return ans;
        //return *min_element(prev.begin(), prev.end());
    }

    int minimumTotal(vector<vector<int>> &triangle)
    {
        int n = triangle.size();

        // RECURSION
        // return recur(triangle, n, 0, 0);

        // MEMOIZATION
        // vector<vector<int>> dp(n);
        // for (int i = 0; i < n; i++) {
        //     dp[i] = vector<int>(i + 1, -1);
        // }
        // return memo(triangle, n, 0, 0, dp);

        // TABULATION
        // return tabulation(triangle, n,dp);

        // SPACE OPTIMIZED
        return space(triangle, n);
    }
};

int main()
{
    Solution sol;

    // Example triangle
    vector<vector<int>> triangle = {
        {2},
        {3, 4},
        {6, 5, 7},
        {4, 1, 8, 3}};

    int result = sol.minimumTotal(triangle);
    cout << "Minimum path sum: " << result << endl;

    return 0;
}
