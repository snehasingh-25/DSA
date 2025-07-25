import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC90SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> subset=new ArrayList<>();
        Arrays.sort(nums);
        create(0,nums,ans,subset);
        return ans;
    }
    void create(int index,int[] nums,List<List<Integer>> ans,List<Integer> subset){
        ans.add(new ArrayList<>(subset));
        for(int i=index;i<nums.length;i++){
            if(i>index && nums[i]==nums[i-1]) continue;
            subset.add(nums[i]);
            create(i+1,nums,ans,subset);
            subset.remove(subset.size()-1);
        }
    }
    public static void main(String[] args){
        LC90SubsetsII solution = new LC90SubsetsII();
        int[] nums={1,2,2};
        List<List<Integer>> subsets=solution.subsetsWithDup(nums);
        System.out.println("Subsets of " + Arrays.toString(nums) + ":");
        for(List<Integer> subset:subsets){
            System.out.println(subset);
        }
    }
}
