package datastructure.priorityQueue;

import java.util.PriorityQueue;
import java.util.Queue;



public class TopkLargestNumbers {
    /**
     * 8/10/2018
     *
     * @param nums: an integer array
     * @param k: An integer
     * @return: the top k largest numbers in array
     */
    public int[] topk(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        Queue<Integer> heap = new PriorityQueue<>();

        for (int i : nums) {
            heap.add(i);
            if (heap.size() > k) {
                heap.remove();
            }
        }

        int[] result = new int[k];
        for (int i = 0; i <= k - 1; i++) {
            result[k - 1 - i] = heap.remove();
        }

        return result;
    }
}
