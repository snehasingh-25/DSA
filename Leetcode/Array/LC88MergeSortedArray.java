import java.util.Arrays;

public class LC88MergeSortedArray {

    // Swap elements between two arrays if nums1[i] > nums2[j]
    public static void swap(int[] nums1, int[] nums2, int i, int j) {
        if (nums1[i] > nums2[j]) {
            int temp = nums1[i];
            nums1[i] = nums2[j];
            nums2[j] = temp;
        }
    }

    // Merge nums2 into nums1 using the Gap method
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = m + n;
        int gap = (len / 2) + (len % 2);

        while (gap > 0) {
            int left = 0;
            int right = gap;

            while (right < len) {
                // Case 1: both pointers in nums1
                if (left < m && right < m) {
                    swap(nums1, nums1, left, right);
                }
                // Case 2: left in nums1, right in nums2
                else if (left < m && right >= m) {
                    swap(nums1, nums2, left, right - m);
                }
                // Case 3: both pointers in nums2
                else {
                    swap(nums2, nums2, left - m, right - m);
                }
                left++;
                right++;
            }

            if (gap == 1) break;
            gap = (gap / 2) + (gap % 2);
        }

        // Copy merged nums2 back to nums1
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[6];
        nums1[0] = 1;
        nums1[1] = 3;
        nums1[2] = 5;
        int[] nums2 = {2, 4, 6};
        int m = 3;
        int n = 3;

        System.out.println("Before merging:");
        System.out.println("nums1: " + Arrays.toString(nums1));
        System.out.println("nums2: " + Arrays.toString(nums2));

        merge(nums1, m, nums2, n);

        System.out.println("\nAfter merging:");
        System.out.println("nums1: " + Arrays.toString(nums1));
    }
}
