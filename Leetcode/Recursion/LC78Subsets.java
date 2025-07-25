import java.util.*;
public class LC78Subsets{
    public List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> result=new ArrayList<>();
        List<Integer>subset=new ArrayList<>();
        create(0,nums,subset,result);
        return result;
    }
    private void create(int index, int[] nums, List<Integer> subset, List<List<Integer>> result) {
        if(index==nums.length){
            result.add(new ArrayList<>(subset));
            return;
        }
        // Include the current element
        subset.add(nums[index]);
        create(index+1, nums, subset, result);
        
        // Exclude the current element
        subset.remove(subset.size()-1);
        create(index+1, nums, subset, result);
    }
    public static void main(String[] args){
        LC78Subsets solution = new LC78Subsets();
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = solution.subsets(nums);
        
        System.out.println("Subsets of " + Arrays.toString(nums) + ":");
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }
}