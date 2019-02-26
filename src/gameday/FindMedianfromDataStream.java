package gameday;

import java.util.PriorityQueue;
import java.util.Queue;

public class FindMedianfromDataStream {
    /**
     * 2/21/2019
     * Gameday
     * https://www.lintcode.com/problem/find-median-from-data-stream/description
     *
     * @param nums: A list of integers
     * @return: the median of numbers
     */
    public int[] medianII(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int[] median = new int[nums.length];

        Queue<Integer> left = new PriorityQueue<>((a, b) -> b - a);
        Queue<Integer> right = new PriorityQueue<>((a, b) -> a - b);

        for (int i = 0; i <= nums.length - 1; i++) {
            if (left.isEmpty() || nums[i] <= left.peek()) {
                left.add(nums[i]);
            } else {
                right.add(nums[i]);
            }

            while (left.size() < right.size()) {
                left.add(right.remove());
            }

            while (left.size() > right.size() + 1) {
                right.add(left.remove());
            }

            median[i] = left.peek();
        }

        return median;
    }
}
