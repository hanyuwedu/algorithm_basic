package arrays_numbers.merge;

public class MergeSortedArray {
    /*
     * 8/1/2018
     *
     * @param A: sorted integer array A which has m elements, but size of A is m+n
     * @param m: An integer
     * @param B: sorted integer array B which has n elements
     * @param n: An integer
     * @return: nothing
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        if (A == null) {
            return;
        }

        int left = m - 1, right = n - 1, current = m + n - 1;

        while (current >= 0) {
            if (left < 0) {
                A[current--] = B[right--];
            } else if (right < 0) {
                A[current--] = A[left--];
            } else {
                if (A[left] > B[right]) {
                    A[current--] = A[left--];
                } else {
                    A[current--] = B[right--];
                }
            }
        }
    }
}
