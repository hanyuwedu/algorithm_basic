package arrays_numbers.pointers;

import java.util.Arrays;

public class TwoSumClosesttotarget {
    /**
     * 8/1/2018
     *
     * @param nums: an integer array
     * @param target: An integer
     * @return: the difference between the sum and the target
     */
    public int twoSumClosest(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int diff = Integer.MAX_VALUE;

        int[] copy = nums.clone();
        Arrays.sort(copy);
        int left = 0, right = copy.length - 1;

        while (left < right) {
            int sum = copy[left] + copy[right];
            diff = Math.abs(target - sum) > diff ? diff : Math.abs(target - sum);

            if (sum > target) {
                right--;
            } else if (sum < target) {
                left++;
            } else {
                return 0;
            }
        }

        return diff;
    }
}
