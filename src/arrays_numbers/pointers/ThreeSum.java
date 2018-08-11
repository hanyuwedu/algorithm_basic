package arrays_numbers.pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    /**
     * 8/1/3028
     *
     * @param numbers: Give an array numbers of n integer
     * @return: Find all unique triplets in the array which gives the sum of zero.
     */
    public List<List<Integer>> threeSum(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return new ArrayList<List<Integer>>();
        }

        int pivot = 0;
        List<List<Integer>> collect = new ArrayList<List<Integer>>();
        Arrays.sort(numbers);

        while (pivot < numbers.length - 1) {
            int left = pivot + 1, right = numbers.length - 1;

            while (left < right) {
                int sum = numbers[pivot] + numbers[left] + numbers[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    List<Integer> current = new ArrayList<>();
                    current.add(numbers[pivot]);
                    current.add(numbers[left]);
                    current.add(numbers[right]);
                    collect.add(current);

                    while (left < right && numbers[left] == numbers[left + 1]) {
                        left++;
                    }
                    left++;

                    while (left < right && numbers[right] == numbers[right - 1]) {
                        right--;
                    }
                    right--;
                }
            }

            while (pivot < numbers.length - 1 && numbers[pivot] == numbers[pivot + 1]) {
                pivot++;
            }
            pivot++;
        }

        return collect;
    }
}
