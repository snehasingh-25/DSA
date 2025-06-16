import java.util.*;

public class LC56MergeIntervals {

    // Core LeetCode logic to merge overlapping intervals
    public static int[][] merge(int[][] intervals) {
        // Sort intervals based on start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> ans = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            // If the list is empty or current interval does not overlap
            if (ans.isEmpty() || intervals[i][0] > ans.get(ans.size() - 1)[1]) {
                ans.add(intervals[i]);
            } else {
                // Overlap: merge with the last interval
                ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1], intervals[i][1]);
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }

    // Utility function to print 2D array
    public static void print2DArray(int[][] arr) {
        for (int[] interval : arr) {
            System.out.println(Arrays.toString(interval));
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        int[][] intervals = {
            {1, 3},
            {2, 6},
            {8, 10},
            {15, 18}
        };

        System.out.println("Original Intervals:");
        print2DArray(intervals);

        int[][] merged = merge(intervals);

        System.out.println("\nMerged Intervals:");
        print2DArray(merged);
    }
}
