package Leetcode.BinarySearch;

public class LC34FindFirstandLastPositionofElementinSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int n=nums.length;
        int low=0;
        int high=n-1;
        int first=-1,last=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]==target){
                first=mid;
                high=mid-1;
            }
            else if(nums[mid]<target){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        low=0;
        high=n-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]==target){
                last=mid;
                low=mid+1;
            }
            else if(nums[mid]<target){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return new int[]{first,last};
    }
    public static void main(String[] args) {
        LC34FindFirstandLastPositionofElementinSortedArray soln = new LC34FindFirstandLastPositionofElementinSortedArray();
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] result = soln.searchRange(nums, target);
        System.out.println("First and last positions: [" + result[0] + ", " + result[1] + "]");
    }
}
