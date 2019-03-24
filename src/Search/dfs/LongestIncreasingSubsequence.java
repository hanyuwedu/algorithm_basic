package Search.dfs;

import java.util.Stack;

public class LongestIncreasingSubsequence {
    /**
     * 8/13/2018
     *
     * @param nums: An integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] longest = {0};
        Stack<Integer> stack = new Stack();

        dfs(nums, stack, longest, 0, 0);

        return longest[0];
    }

    private void dfs(int[] nums, Stack<Integer> stack, int[] longest, int current, int i) {
        longest[0] = Math.max(longest[0], current);

        if (i == nums.length) {
            return;
        }

        for (int j = i; j <= nums.length - 1; j++) {
            if (stack.isEmpty() || nums[j] > stack.peek()) {
                stack.add(nums[j]);
                dfs(nums, stack, longest, current + 1, j + 1);
                stack.pop();
            }
        }
    }
}
