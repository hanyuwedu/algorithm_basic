package binary_search;

public class FindMinimumInARotatedSortedArray {
    /**
     * 5/30/18
     *
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }

        int pivot = nums[nums.length - 1];
        int left = 0, right = nums.length - 1;

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > pivot) {
                left = mid;
            } else if (nums[mid] < pivot) {
                right = mid;
            } else {
                return Integer.MIN_VALUE;
            }
        }

        return Math.min(nums[left], nums[right]);
    }
}
