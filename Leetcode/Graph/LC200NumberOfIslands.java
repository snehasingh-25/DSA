// File: NumberOfIslands.java
import java.util.*;

public class LC200NumberOfIslands {

    // Perform DFS to mark all connected '1's as visited
    public void dfs(int i, int j, boolean[][] vis, char[][] grid, int n, int m) {
        vis[i][j] = true;

        // Directions: up, right, down, left
        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};

        for (int k = 0; k < 4; k++) {
            int nrow = i + delrow[k];
            int ncol = j + delcol[k];

            // Check boundaries and if cell is unvisited land
            if (nrow >= 0 && ncol >= 0 && nrow < n && ncol < m &&
                grid[nrow][ncol] == '1' && !vis[nrow][ncol]) {
                dfs(nrow, ncol, vis, grid, n, m);
            }
        }
    }

    // Main function to count islands
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int cnt = 0;

        // Traverse the entire grid
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // If an unvisited land cell is found
                if (!vis[i][j] && grid[i][j] == '1') {
                    cnt++;
                    dfs(i, j, vis, grid, n, m);
                }
            }
        }
        return cnt;
    }

    // Example usage
    public static void main(String[] args) {
        LC200NumberOfIslands sol = new LC200NumberOfIslands();
        char[][] grid = {
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'}
        };
        int result = sol.numIslands(grid);
        System.out.println("Number of Islands: " + result);
    }
}
