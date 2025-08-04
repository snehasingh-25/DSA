package Leetcode.BinarySearch;

public class LC35SearchInsertPosition {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }
    public static void main(String[] args){
        LC35SearchInsertPosition soln= new LC35SearchInsertPosition();
        int[] nums = {-1,0,3,5,9,12};
        int target = 2;
        int result=soln.search(nums,target);
        System.out.println("Index of target: " + result); 
    }
}
