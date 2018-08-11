package gameday;

import java.util.PriorityQueue;
import java.util.Queue;

public class FindMedianfromDataStream {
    /**
     * 8/10/2018
     *
     * @param nums: A list of integers
     * @return: the median of numbers
     */
    public int[] medianII(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        Queue<Integer> left = new PriorityQueue<>((i1, i2) -> i2 - i1);
        Queue<Integer> right = new PriorityQueue<>();

        int[] median = new int[nums.length];
        median[0] = nums[0];
        left.add(nums[0]);

        for (int i = 1; i <= nums.length - 1; i++) {
            if (nums[i] > left.peek()) {
                right.add(nums[i]);
            } else {
                left.add(nums[i]);
            }

            balance(left, right);
            median[i] = left.peek();
        }

        return median;
    }

    private void balance(Queue<Integer> left, Queue<Integer> right) {
        while (left.size() < right.size()) {
            left.add(right.remove());
        }

        while (left.size() > right.size() + 1) {
            right.add(left.remove());
        }
    }
}
