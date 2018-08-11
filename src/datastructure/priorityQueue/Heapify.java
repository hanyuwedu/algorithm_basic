package datastructure.priorityQueue;

import java.util.Arrays;

public class Heapify {
    /*
     * 8/10/2018
     * @param A: Given an integer array
     * @return: nothing
     */
    public void heapify(int[] A) {
        if (A == null || A.length == 0) {
            return;
        }

        for (int i = 0; i <= A.length - 1; i++) {
            siftDown(A, i);
            siftUp(A, i);
        }
    }

    private void siftDown(int[] A, int index) {
        int leftIndex = index * 2 + 1;
        int rightIndex = index * 2 + 2;

        if (leftIndex >= A.length) {
            return;
        } else if (rightIndex >= A.length) {
            if (A[index] > A[leftIndex]) {
                int temp = A[leftIndex];
                A[leftIndex] = A[index];
                A[index] = temp;
            }
            return;
        }

        if (A[index] < Math.min(A[leftIndex], A[rightIndex])) {
            return;
        }

        if (A[leftIndex] < A[rightIndex]) {
            interchange(A, leftIndex, index);
            siftDown(A, leftIndex);
        } else {
            interchange(A, rightIndex, index);
            siftDown(A, rightIndex);
        }
    }

    private void siftUp(int[] A, int index) {
        int parentIndex = (index - 1) / 2;
        if (index == 0) {
            return;
        }

        if (A[parentIndex] < A[index]) {
            return;
        } else {
            interchange(A, index, parentIndex);
            siftUp(A, parentIndex);
        }
    }

    private void interchange(int[] A, int left, int right) {
        int temp = A[left];
        A[left] = A[right];
        A[right] = temp;
    }
}
