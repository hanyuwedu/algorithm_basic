package arrays_numbers.partition;

public class SortIntegersII {
    /**
     * 8/4/2018
     * Quick sort
     *
     * @param A: an integer array
     * @return: nothing
     */
    public void sortIntegers2(int[] A) {
        if (A == null || A.length == 0) {
            return;
        }

        quickSort(A, 0, A.length - 1);
    }

    private void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = partition(nums, start, end);

        quickSort(nums, start, mid);
        quickSort(nums, mid + 1, end);
    }

    private int partition(int[] nums, int start, int end) {
        int left = start, right = end;
        int pivot = nums[start];

        while (left <= right) {
            while (left <= right && nums[left] < pivot) {
                left++;
            }

            while (left <= right && nums[right] > pivot) {
                right--;
            }

            if (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }

        return left - 1;
    }
}
