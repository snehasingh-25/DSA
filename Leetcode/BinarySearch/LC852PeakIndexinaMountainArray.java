package Leetcode.BinarySearch;

public class LC852PeakIndexinaMountainArray {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1; // Move to the right side
            } else {
                right = mid; // Move to the left side
            }
        }

        return left; 
    }

    public static void main(String[] args) {
        LC852PeakIndexinaMountainArray solution = new LC852PeakIndexinaMountainArray();
        int[] arr = {0, 2, 1, 0};
        int result = solution.peakIndexInMountainArray(arr);
        System.out.println("Peak index: " + result);
    }
}
