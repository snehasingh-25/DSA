import java.util.*;

public class LC121BestTimeToBuyAndSellStock {

    // Core LeetCode logic
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int lowPrice = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            lowPrice = Math.min(prices[i], lowPrice);
            maxProfit = Math.max(maxProfit, prices[i] - lowPrice);
        }

        return maxProfit;
    }

    // Main method for testing
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println("Prices: " + Arrays.toString(prices));

        int result = maxProfit(prices);
        System.out.println("Maximum Profit: " + result);
    }
}
