// File: LC2441LargestPositiveWithNegative.java

import java.util.*;

public class LC2441LargestPositiveWithNegative {

    // Function to find the largest positive integer that exists with its negative
    public int findMaxK(int[] nums) {
        Arrays.sort(nums); // Sort the array
        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            if (nums[l] == -nums[r]) {
                return nums[r];
            } else if (nums[r] > -nums[l]) {
                r--;
            } else {
                l++;
            }
        }

        return -1; // No such pair found
    }

    // Utility function to print array
    public static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    // Example usage
    public static void main(String[] args) {
        LC2441LargestPositiveWithNegative sol = new LC2441LargestPositiveWithNegative();

        int[] nums1 = {-1, 2, -3, 3};
        int[] nums2 = {-1, 10, 6, 7, -7, 1};
        int[] nums3 = {-10, 8, 6, 7, -2, -3};

        System.out.print("Input 1: ");
        printArray(nums1);
        System.out.println("Output: " + sol.findMaxK(nums1)); // 3

        System.out.print("\nInput 2: ");
        printArray(nums2);
        System.out.println("Output: " + sol.findMaxK(nums2)); // 7

        System.out.print("\nInput 3: ");
        printArray(nums3);
        System.out.println("Output: " + sol.findMaxK(nums3)); // -1
    }
}
