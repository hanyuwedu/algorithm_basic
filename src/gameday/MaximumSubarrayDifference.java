package gameday;

public class MaximumSubarrayDifference {
    /**
     * 8/2/2018
     * reverse array operation
     *
     * @param nums: A list of integers
     * @return: An integer indicate the value of maximum difference between two substrings
     */
    public int maxDiffSubArrays(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        int[] reverse = getReverse(nums);

        int[] maxSum = getMaxSum(nums);
        int[] minSum = getMinSum(nums);
        int[] maxSumReverse = getMaxSum(reverse);
        int[] minSumReverse = getMinSum(reverse);

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= nums.length - 1; i++) {
            max = Math.max(max, Math.max(Math.abs(maxSum[i] - minSumReverse[nums.length - i]),
                    Math.abs(minSum[i] - maxSumReverse[nums.length - i])));
        }

        return max;
    }

    private int[] getReverse(int[] nums) {
        int[] reverse = new int[nums.length];
        for (int i = 0; i <= nums.length - 1; i++) {
            reverse[i] = nums[nums.length - 1 - i];
        }

        return reverse;
    }

    private int[] getMaxSum(int[] nums) {
        int[] prefix = getPrefixSum(nums);
        int[] maxSum = new int[nums.length + 1];

        int left = 0, max = Integer.MIN_VALUE;
        for (int i = 1; i <= nums.length; i++) {
            max = Math.max(max, prefix[i] - left);
            maxSum[i] = max;
            left = Math.min(left, prefix[i]);
        }

        return maxSum;
    }

    private int[] getMinSum(int[] nums) {
        int[] prefix = getPrefixSum(nums);
        int[] minSum = new int[nums.length + 1];

        int left = 0, min = Integer.MAX_VALUE;
        for (int i = 1; i <= nums.length; i++) {
            min = Math.min(min, prefix[i] - left);
            minSum[i] = min;
            left = Math.max(left, prefix[i]);
        }

        return minSum;
    }

    private int[] getPrefixSum(int[] nums) {
        int[] prefix = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }

        return prefix;
    }
}
