package binary_search;

public class FindPeakElement {
    /**
     * 5/30/18
     *
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        if (A == null || A.length <= 2) {
            return -1;
        }

        int left = 0, right = A.length - 1;

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (A[mid - 1] < A[mid] && A[mid] < A[mid + 1]) {
                left = mid;
            } else if (A[mid - 1] > A[mid] && A[mid] < A[mid + 1]) {
                left = mid;
            } else if (A[mid - 1] > A[mid] && A[mid] > A[mid + 1]) {
                right = mid;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
