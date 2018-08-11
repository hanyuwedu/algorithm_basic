package arrays_numbers.partition;

import java.util.Arrays;

public class Median {
    /**
     * 8/4/2018
     *
     * @param nums: A list of integers
     * @return: An integer denotes the middle number of the array
     */
    public int median(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        if (nums.length % 2 == 0) {
            return getKsmallest(nums, nums.length / 2 - 1);
        } else {
            return getKsmallest(nums, nums.length / 2);
        }
    }

    private int getKsmallest(int[] nums, int k) {
        int start = 0, end = nums.length - 1;

        while (start < end) {
            int mid = partition(nums, start, end);
            if (mid > k) {
                end = mid;
            } if (mid < k) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return nums[start];
    }

    private int partition(int[] nums, int start, int end) {
        int left = start, right = end;
        int pivot = nums[(start + end) / 2];

//        System.out.println(Arrays.toString(nums));
//        System.out.println(left);
//        System.out.println(right);
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

    public static void main(String[] args) {
        Median m = new Median();
        int[] input = {4,5,1,2,3};

        System.out.println(m.median(input));
    }
}
