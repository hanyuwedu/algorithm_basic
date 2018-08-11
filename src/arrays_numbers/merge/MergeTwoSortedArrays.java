package arrays_numbers.merge;

public class MergeTwoSortedArrays {
    /**
     * 8/1/2018
     *
     * @param A: sorted integer array A
     * @param B: sorted integer array B
     * @return: A new sorted integer array
     */
    public int[] mergeSortedArray(int[] A, int[] B) {
        if (A == null && B == null) {
            return new int[0];
        } else if (A == null) {
            return B;
        } else if (B == null) {
            return A;
        }

        int m = A.length, n = B.length;
        int[] merge = new int[m + n];

        int left = 0, right = 0, current = 0;
        while (left <= m - 1 || right <= n - 1) {
            if (left > m - 1) {
                merge[current++] = B[right++];
            } else if (right > n - 1) {
                merge[current++] = A[left++];
            } else {
                if (A[left] > B[right]) {
                    merge[current++] = B[right++];
                } else {
                    merge[current++] = A[left++];
                }
            }
        }

        return merge;
    }
}
