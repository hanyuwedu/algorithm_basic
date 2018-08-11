package arrays_numbers.subarray;

public class BestTimetoBuyandSellStockII {
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

        int profit = 0, left = Integer.MAX_VALUE;

        for (int i = 0; i <= prices.length - 1; i++) {
            int current = prices[i];
            if (current > left) {
                profit += current - left;
                left = current;
            } else {
                left = current;
            }
        }

        return profit;
    }
}
