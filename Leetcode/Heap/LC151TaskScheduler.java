import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class LC151TaskScheduler {

    class Pair {
        int freq;
        int time;

        Pair(int freq, int time) {
            this.freq = freq;
            this.time = time;
        }
    }

    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        Map<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < tasks.length; i++) {
            freq.put(tasks[i], freq.getOrDefault(tasks[i], 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            maxHeap.add(entry.getValue());
        }
        Queue<Pair> cooldown = new LinkedList<>();

        int totalTime = 0;
        while (!maxHeap.isEmpty() || !cooldown.isEmpty()) {
            totalTime++;
            if (!cooldown.isEmpty() && cooldown.peek().time == totalTime) {
                maxHeap.add(cooldown.poll().freq);
            }
            if (!maxHeap.isEmpty()) {
                int frequency = maxHeap.poll() - 1;
                if (frequency > 0) {
                    cooldown.offer(new Pair(frequency, totalTime + n + 1));
                }
            }
        }
        return totalTime;

    }

    public static void main(String[] args) {
        LC151TaskScheduler solution = new LC151TaskScheduler();
        char[] tasks = { 'A', 'A', 'A', 'B', 'B', 'B' };
        int n = 2;
        int result = solution.leastInterval(tasks, n);
        System.out.println("Minimum intervals required: " + result);
    }
}
