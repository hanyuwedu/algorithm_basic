package arrays_numbers.subarray;

import java.util.Arrays;

public class MaximumSubarray {
    /**
     * 8/2/2018
     *
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] prefixSum = new int[nums.length + 1];
        for (int i = 1; i <= prefixSum.length - 1; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }


        int max = Integer.MIN_VALUE;
        int left = 0;
        for (int i = 1; i <= prefixSum.length - 1; i++) {
            int current = prefixSum[i];
            max = Math.max(current - left, max);
            left = Math.min(left, current);
        }

        return max;
    }

    public  static void main(String[] args) {
        MaximumSubarray ms = new MaximumSubarray();
        int [] input = {-1};

        System.out.println(ms.maxSubArray(input));
    }
}
