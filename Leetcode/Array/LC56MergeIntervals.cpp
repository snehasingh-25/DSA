#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        sort(intervals.begin(), intervals.end());
        vector<vector<int>> ans;

        for (int i = 0; i < intervals.size(); i++) {
            // If ans is empty or no overlap, push the interval
            if (ans.empty() || intervals[i][0] > ans.back()[1]) {
                ans.push_back(intervals[i]);
            } else {
                // Merge intervals
                ans.back()[1] = max(ans.back()[1], intervals[i][1]);
            }
        }

        return ans;
    }
};

// Utility function to print 2D vector
void printIntervals(const vector<vector<int>>& intervals) {
    for (const auto& interval : intervals) {
        cout << "[" << interval[0] << ", " << interval[1] << "]" << endl;
    }
}

int main() {
    Solution sol;
    vector<vector<int>> intervals = {
        {1, 3}, {2, 6}, {8, 10}, {15, 18}
    };

    cout << "Original Intervals:\n";
    printIntervals(intervals);

    vector<vector<int>> merged = sol.merge(intervals);

    cout << "\nMerged Intervals:\n";
    printIntervals(merged);

    return 0;
}
