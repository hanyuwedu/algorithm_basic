package datastructure.priorityQueue;

import java.util.*;

public class UglyNumberII {
    /**
     * 8/10/2018
     *
     * @param n: An integer
     * @return: the nth prime number as description.
     */
    public int nthUglyNumber(int n) {
        if (n <= 0) {
            return -1;
        }

        Queue<Long> heap = new PriorityQueue<>();
        Set<Long> visited = new HashSet<>();
        Integer[] factor = {2, 3, 5};
        heap.add(Long.valueOf(1));
        visited.add(Long.valueOf(1));

        for (int i = 1; i <= n - 1; i++) {
            Long current = heap.remove();
            for (Integer f : factor) {
                if (!visited.contains(f * current)) {
                    heap.add(f * current);
                    visited.add(f * current);
                }
            }
        }

        return heap.peek().intValue();
    }
}
