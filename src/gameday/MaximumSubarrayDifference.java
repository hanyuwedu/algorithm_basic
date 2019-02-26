package gameday;

public class MaximumSubarrayDifference {
    /**
     * 2/21/2019
     * Gameday
     * https://www.lintcode.com/problem/maximum-subarray-difference/description
     *
     * @param nums: A list of integers
     * @return: An integer indicate the value of maximum difference between two substrings
     */
    public int maxDiffSubArrays(int[] nums) {
        int n = nums.length;

        int[] reverse = new int[n];
        for (int i = 0; i <= n - 1; i++) {
            reverse[i] = nums[n - i - 1];
        }

        int[] sum = getSum(nums);
        int[] reverseSum = getSum(reverse);

        int[] maxArray = getMax(sum);
        int[] reverseMaxArray = getMax(reverseSum);
        int[] minArray = getMin(sum);
        int[] reverseMinArray = getMin(reverseSum);

        int max = 0;

        for (int i = 1; i <= n - 1; i++) {
            max = Math.max(max, Math.max(Math.abs(maxArray[i] - reverseMinArray[n - i]), Math.abs(reverseMaxArray[i] - minArray[n - i])));
        }

        return max;
    }

    private int[] getSum(int[] nums) {
        int[] sum = new int[nums.length + 1];
        for (int i = 0; i <= nums.length - 1; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }

        return sum;
    }

    private int[] getMax(int[] sum) {
        int[] maxArray = new int[sum.length];

        int min = 0, max = Integer.MIN_VALUE;

        for (int i = 1; i <= sum.length - 1; i++) {
            max = Math.max(max, sum[i] - min);
            maxArray[i] = Math.max(max, sum[i] - min);
            min = Math.min(min, sum[i]);
        }

        return maxArray;
    }

    private int[] getMin(int[] sum) {
        int[] minArray = new int[sum.length];

        int max = 0, min = Integer.MAX_VALUE;

        for (int i = 1; i <= sum.length - 1; i++) {
            min = Math.min(min, sum[i] - max);
            minArray[i] = min;
            max = Math.max(max, sum[i]);
        }

        return minArray;
    }
}
