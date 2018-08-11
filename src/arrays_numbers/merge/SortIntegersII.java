package arrays_numbers.merge;

public class SortIntegersII {
    /**
     * 8/4/2018
     * merge sort
     *
     * @param A: an integer array
     * @return: nothing
     */
    public void sortIntegers2(int[] A) {
        if (A == null || A.length == 0) {
            return;
        }

        mergeSort(A, 0, A.length - 1);
    }

    private void mergeSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = (start + end) / 2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);

        merge(nums, start, mid + 1, end);
    }

    private void merge(int[] nums, int start, int mid, int end) {
        int[] copy = new int[end - start + 1];
        int current = 0, left = start, right = mid;

        while (current <= copy.length - 1) {
            if (left >= mid) {
                copy[current++] = nums[right++];
            } else if (right > end) {
                copy[current++] = nums[left++];
            } else {
                if (nums[left] <= nums[right]) {
                    copy[current++] = nums[left++];
                } else {
                    copy[current++] = nums[right++];
                }
            }
        }

        for (int i = 0; i <= copy.length - 1; i++) {
            nums[i + start] = copy[i];
        }
    }
}
