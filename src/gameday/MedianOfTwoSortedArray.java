package gameday;

public class MedianOfTwoSortedArray {
    /**
     * 2/21/2019
     * Gameday
     * https://www.lintcode.com/problem/median-of-two-sorted-arrays/description
     *
     * @param A: An integer array
     * @param B: An integer array
     * @return: a double whose format is *.5 or *.0
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length, n = B.length;
        if ((m + n) % 2 == 1) {
            return 1.0 * getKSmallest(A, B, (m + n) / 2 + 1);
        } else {
            return 0.5 * (getKSmallest(A, B, (m + n) / 2) + getKSmallest(A, B, (m + n) / 2 + 1));
        }
    }

    private int getKSmallest(int[] A, int[] B, int k) {
        int a = 0, b = 0;
        while (k > 1) {
            if (a + k/2 > A.length) {
                b += k/2;
            } else if (b + k/2 > B.length) {
                a += k/2;
            } else {
                if (A[a + k/2 - 1] > B[b + k/2 - 1]) {
                    b += k/2;
                } else {
                    a += k/2;
                }
            }
            k -= k/2;
        }

        if (a == A.length) {
            return B[b];
        } else if (b == B.length) {
            return A[a];
        } else {
            return Math.min(A[a], B[b]);
        }
    }
}
