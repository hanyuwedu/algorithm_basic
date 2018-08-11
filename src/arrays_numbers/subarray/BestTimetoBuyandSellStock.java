package arrays_numbers.subarray;

public class BestTimetoBuyandSellStock {
    /**
     * 8/2/2018
     *
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int left = Integer.MAX_VALUE;
        int profit = 0;

        for (int i = 0; i <= prices.length - 1; i++) {
            int current = prices[i];
            profit = Math.max(profit, current - left);
            left = Math.min(left, current);
        }

        return profit;
    }
}
