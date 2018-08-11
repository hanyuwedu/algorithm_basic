package arrays_numbers.partition;

public class SortColors {
    /**
     * 8/4/2018
     *
     * @param nums: A list of integer which is 0, 1 or 2
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int sortRed = partition(nums, 0, nums.length - 1, 0);
        int sortWhite = partition(nums, sortRed, nums.length - 1, 1);
        return;
    }

    private int partition(int[] nums, int start, int end, int pivot) {
        int left = start, right = end;
        while (left <= right) {
            while (left <= right && nums[left] <= pivot) {
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

        return left;
    }
}
