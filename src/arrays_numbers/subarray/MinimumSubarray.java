package arrays_numbers.subarray;

import java.util.List;

public class MinimumSubarray {
    /*
     * 8/2/2018
     *
     * @param nums: a list of integers
     * @return: A integer indicate the sum of minimum subarray
     */
    public int minSubArray(List<Integer> nums) {
        if (nums == null || nums.isEmpty()) {
            return 0;
        }

        int[] prefixSum = new int[nums.size() + 1];
        for (int i = 1; i <= prefixSum.length - 1; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums.get(i - 1);
        }

        int left = 0, min = Integer.MAX_VALUE;
        for (int i = 1; i <= prefixSum.length - 1; i++) {
            int current = prefixSum[i];
            min = Math.min(current - left, min);
            left = Math.max(left, current);
        }

        return min;
    }
}
