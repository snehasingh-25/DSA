import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LC347TopKFrequentElements{
    class Pair{
        int num;
        int freq;
        Pair(int num, int freq){
            this.num = num;
            this.freq = freq;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Pair> minHeap=new PriorityQueue<>(Comparator.comparingInt(a->a.freq));
        Map<Integer,Integer> freq=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            freq.put(nums[i],freq.getOrDefault(nums[i],0)+1);
        }
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            minHeap.add(new Pair(entry.getValue(), entry.getKey()));
            if (minHeap.size() > k) {
                minHeap.poll(); 
            }
        }
        int[] ans=new int[k];
        int i=0;
        while(!minHeap.isEmpty()){
            Pair p=minHeap.poll();
            ans[i++]=p.num;
        }
        return ans;
    }
    public static void main(String[] args) {
        LC347TopKFrequentElements solution = new LC347TopKFrequentElements();
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        int[] result = solution.topKFrequent(nums, k);
        System.out.print("Top " + k + " frequent elements: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}