package arrays_numbers.subarray;

import java.util.List;

public class MaximumSubarrayII {
    /*
     * 8/2/2018
     *
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    public int maxTwoSubArrays(List<Integer> nums) {
        if (nums == null || nums.size() <= 1) {
            return 0;
        }

        int[] prefixSum = new int[nums.size() + 1];
        int[] postfixSum = new int[nums.size() + 1];

        for (int i = 1; i <= prefixSum.length - 1; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums.get(i - 1);
        }

        for (int j = 1; j <= postfixSum.length - 1; j++) {
            postfixSum[j] = postfixSum[j - 1] + nums.get(nums.size() - j);
        }

        int[] leftMax = new int[prefixSum.length];
        int[] rightMax = new int[postfixSum.length];

        int left = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= prefixSum.length - 1; i++) {
            max = Math.max(max, prefixSum[i] - left);
            leftMax[i] = max;
            left = Math.min(left, prefixSum[i]);
        }

        left = 0; max = Integer.MIN_VALUE;
        for (int j = 1; j <= postfixSum.length - 1; j++) {
            max = Math.max(max, postfixSum[j] - left);
            rightMax[j] = max;
            left = Math.min(left, postfixSum[j]);
        }

        int result = Integer.MIN_VALUE;
        for (int i = 1; i <= nums.size() - 1; i++) {
            result = Math.max(result, leftMax[i] + rightMax[nums.size() - i]);
        }

        return result;
    }
}
