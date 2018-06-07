package gameday;

public class MedianOfTwoSortedArray {
    /**
     * 5/30/18
     * Pointer defined in "previous ith item"
     *
     * @param A: An integer array
     * @param B: An integer array
     * @return: a double whose format is *.5 or *.0
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        int count = A.length + B.length;
        if (count % 2 == 1) {
            return getK(A, B, count / 2 + 1) * 1.0;
        } else {
            return (getK(A, B, count / 2) + getK(A, B, count / 2 + 1)) * 0.5;
        }
    }

    /**
     * Find kth smallest element
     *
     */
    private int getK(int[] A, int[] B, int k) {
        int left = 0, right = 0;

        while (k > 1) {
            int move = k / 2;
            if (left + move > A.length) {
                right = right + move;
            } else if (right + move > B.length) {
                left = left + move;
            } else {
                if (A[left + move - 1] > B[right + move - 1]) {
                    right = right + move;
                } else {
                    left = left + move;
                }
            }
            k = k - move;
        }

        if (left == A.length) {
            return B[right];
        } else if (right == B.length) {
            return A[left];
        } else {
            return Math.min(A[left], B[right]);
        }
    }
}
