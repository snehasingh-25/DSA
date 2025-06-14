import java.util.Arrays;

public class LC75SortColors {

    public void sortColors(int[] nums) {
        int n = nums.length;
        int low = 0, mid = 0, high = n - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else if (nums[mid] == 2) {
                swap(nums, mid, high);
                high--;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Test case
    public static void main(String[] args) {
        LC75SortColors sorter = new LC75SortColors();
        int[] nums = {2, 0, 2, 1, 1, 0};

        System.out.println("Original: " + Arrays.toString(nums));
        sorter.sortColors(nums);
        System.out.println("Sorted:   " + Arrays.toString(nums));
    }
}
 
