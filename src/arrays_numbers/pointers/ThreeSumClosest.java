package arrays_numbers.pointers;

import java.util.Arrays;

public class ThreeSumClosest {
    /**
     * 8/1/2018
     *
     * @param numbers: Give an array numbers of n integer
     * @param target: An integer
     * @return: return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) {
            return 0;
        }

        int[] copy = numbers.clone();
        Arrays.sort(copy);

        int result = Integer.MAX_VALUE;
        int pivot = 0;

        while (pivot < copy.length - 1) {
            int left = pivot + 1, right = copy.length - 1;
            while (left < right) {
                int sum = copy[pivot] + copy[left] + copy[right];
                result = Math.abs(sum - target) > Math.abs(result - target) ? result : sum;

                if (sum > target) {
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    return target;
                }
            }

            while (pivot < copy.length - 1 && copy[pivot] == copy[pivot + 1]) {
                pivot++;
            }
            pivot++;
        }

        return result;
    }
}
