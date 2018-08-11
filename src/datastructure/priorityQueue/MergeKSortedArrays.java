package datastructure.priorityQueue;

import java.util.*;

public class MergeKSortedArrays {
    private class Element implements Comparable<Element> {
        int val, x, y;

        private Element(int val, int y, int x) {
            this.val = val;
            this.y = y;
            this.x = x;
        }

        @Override
        public int compareTo(Element another) {
            return this.val - another.val;
        }
    }

    /**
     * 8/10/2018
     * Heap merge
     *
     * @param arrays: k sorted integer arrays
     * @return: a sorted array
     */
    public int[] mergekSortedArrays(int[][] arrays) {
        if (arrays == null || arrays.length == 0) {
            return new int[0];
        }

        List<Integer> result = new ArrayList<Integer>();
        Queue<Element> heap = new PriorityQueue<>();

        for (int i = 0; i <= arrays.length - 1; i++) {
            if (arrays[i] != null && arrays[i].length > 0) {
                Element current = new Element(arrays[i][0], i, 0);
                heap.add(current);
            }
        }

        while (!heap.isEmpty()) {
            Element current = heap.remove();
            result.add(current.val);

            if (arrays[current.y].length > current.x + 1) {
                Element next = new Element(arrays[current.y][current.x + 1], current.y, current.x + 1);
                heap.add(next);
            }
        }

        int[] intArray = new int[result.size()];
        for (int i = 0; i <= result.size() - 1; i++) {
            intArray[i] = result.get(i);
        }

        return intArray;
    }



    /**
     * 8/10/2018
     * divide and conquer
     *
     * @param arrays: k sorted integer arrays
     * @return: a sorted array
     */
    public int[] mergekSortedArrays2(int[][] arrays) {
        /// Base case:
        if (arrays == null || arrays.length == 0) {
            return new int[0];
        }

        if (arrays.length == 1) {
            return arrays[0];
        }

        /// Divide
        int mid = arrays.length % 2 - 1;
        int[][] leftArrays = getArrays(arrays, 0, mid);
        int[][] rightArrays = getArrays(arrays, mid + 1, arrays.length - 1);

        int[] left = mergekSortedArrays(leftArrays);
        int[] right = mergekSortedArrays(rightArrays);

        /// Conquer
        return(merge(left, right));
    }

    private int[] merge(int[] left, int[] right) {
        if (left == null && right == null) {
            return new int[0];
        }

        int[] result = new int[left.length + right.length];
        int leftPointer = 0, rightPointer = 0, current = 0;

        while (leftPointer <= left.length - 1 || rightPointer <= right.length - 1) {
            if (leftPointer > left.length - 1) {
                result[current++] = right[rightPointer++];
            } else if (rightPointer > right.length - 1) {
                result[current++] = left[leftPointer++];
            } else {
                if (left[leftPointer] < right[rightPointer]) {
                    result[current++] = left[leftPointer++];
                } else {
                    result[current++] = right[rightPointer++];
                }
            }
        }

        return result;
    }

    private int[][] getArrays(int[][] arrays, int start, int end) {
        return Arrays.copyOfRange(arrays, start, end + 1);
    }

    public static void main(String[] args) {
        int[][] input = {{1,3,5,7},{2,4,6},{0,8,9,10,11}};
        System.out.println(Arrays.toString(new MergeKSortedArrays().mergekSortedArrays2(input)));
    }
}
