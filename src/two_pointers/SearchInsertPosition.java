package two_pointers;


public class SearchInsertPosition {
    /**
     * @param A: an integer sorted array
     * @param target: an integer to be inserted
     * @return: An integer
     *
     * Find the first position that element >= target
     */
    public int searchInsert(int[] A, int target) {
        if (A == null || A.length == 0) {
            return 0;
        }

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

        if (A[left] >= target) {
            return left;
        } else if (A[right] >= target) {
            return right;
        } else {
            return right + 1;
        }
    }



    public static void main(String[] args) {
        int[] A = {1,3,5,6};
        System.out.println(new SearchInsertPosition().searchInsert(A, 3));
    }
}
