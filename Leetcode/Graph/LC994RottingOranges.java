// File: RottingOranges.java
import java.util.*;

public class LC994RottingOranges {

    // Function to calculate minimum time to rot all oranges
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        int cntFresh = 0;

        // Visited matrix to mark rotted cells
        int[][] vis = new int[n][m];

        // Add all initially rotten oranges to queue and count fresh ones
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                    vis[i][j] = 2;
                }
                if (grid[i][j] == 1) {
                    cntFresh++;
                }
            }
        }

        int cnt = 0;
        int time = 0;

        // 4 direction vectors: up, right, down, left
        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};

        // Multi-source BFS
        while (!q.isEmpty()) {
            int size = q.size();
            boolean turned = false;

            for (int i = 0; i < size; i++) {
                int[] cell = q.poll();
                int row = cell[0];
                int col = cell[1];

                for (int k = 0; k < 4; k++) {
                    int nrow = row + delrow[k];
                    int ncol = col + delcol[k];

                    // If neighbor is fresh and unvisited, rot it
                    if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m &&
                        grid[nrow][ncol] == 1 && vis[nrow][ncol] == 0) {
                        vis[nrow][ncol] = 2;
                        cnt++;
                        turned = true;
                        q.offer(new int[]{nrow, ncol});
                    }
                }
            }

            // Increment time if at least one orange rotted in this round
            if (turned) time++;
        }

        // Check if all fresh oranges were rotted
        return (cnt == cntFresh) ? time : -1;
    }

    // Example usage
    public static void main(String[] args) {
        LC994RottingOranges sol = new LC994RottingOranges();
        int[][] grid = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        };

        int result = sol.orangesRotting(grid);
        System.out.println("Minutes to rot all oranges: " + result);
    }
}
