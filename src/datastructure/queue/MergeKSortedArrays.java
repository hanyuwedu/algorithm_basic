package datastructure.queue;

import java.util.LinkedList;
import java.util.Queue;

public class MergeKSortedArrays {
    /**
     * 8/10/20018
     *
     * @param arrays: k sorted integer arrays
     * @return: a sorted array
     */
    public int[] mergekSortedArrays(int[][] arrays) {
        if (arrays == null) {
            return null;
        }

        Queue<int[]> queue = new LinkedList<>();
        for (int[] array : arrays) {
            queue.add(array);
        }

        while (queue.size() > 1) {
            int[] first = queue.remove();
            int[] second = queue.remove();
            int[] merge  = mergeTwoArray(first, second);
            queue.add(merge);
        }

        return queue.remove();
    }

    private int[] mergeTwoArray(int[] first, int[] second) {
        if (first == null && second == null) {
            return new int[0];
        } else if (first == null) {
            return second;
        } else if (second == null) {
            return first;
        }

        int left = 0, right = 0, current = 0;
        int[] merge = new int[first.length + second.length];

        while (left < first.length || right < second.length) {
            if (left == first.length) {
                merge[current++] = second[right++];
            } else if (right == second.length) {
                merge[current++] = first[left++];
            } else {
                if (first[left] < second[right]) {
                    merge[current++] = first[left++];
                } else {
                    merge[current++] = second[right++];
                }
            }
        }

        return merge;
    }
}
