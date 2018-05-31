package binary_search;

public class SearchForARange {
    /**
     * 5/30/18
     * Search for the first and last position respectively
     *
     * @param A: an integer sorted array
     * @param target: an integer to be inserted
     * @return: a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] A, int target) {
        if (A == null || A.length == 0) {
            int[] dum = {-1, -1};
            return dum;
        }

        int[] ans = new int[2];

        /// Find the first position
        int left = 0, right = A.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (A[mid] > target) {
                right = mid;
            } else if (A[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }

        if (A[left] == target) {
            ans[0] = left;
        } else if (A[right] == target) {
            ans[0] = right;
        } else {
            ans[0] = -1;
        }

        /// Find the last position
        left = 0;
        right = A.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (A[mid] > target) {
                right = mid;
            } else if (A[mid] < target) {
                left = mid;
            } else {
                left = mid;
            }
        }

        if (A[right] == target) {
            ans[1] = right;
        } else if (A[left] == target) {
            ans[1] = left;
        } else {
            ans[1] = -1;
        }

        return ans;
    }
}
