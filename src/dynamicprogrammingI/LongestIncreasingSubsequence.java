package dynamicprogrammingI;

public class LongestIncreasingSubsequence {
    /**
     * 6/6/2018
     *
     * @param nums: An integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length - 1;
        int[] lis = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            lis[i] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= i - 1; j++) {
                if (nums[i] > nums[j]) {
                    lis[i] = Math.max(lis[j] + 1, lis[i]);
                }
            }
        }

        int max = 0;
        for (int i = 0; i <= n; i++) {
            max = Math.max(max, lis[i]);
        }
        return max;
    }
}
