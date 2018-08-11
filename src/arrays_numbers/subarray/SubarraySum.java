package arrays_numbers.subarray;

import java.util.*;

public class SubarraySum {
    /**
     * 8/2/2018
     *
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    public List<Integer> subarraySum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<Integer>();
        }

        Map<Integer, Integer> prefixSum = new HashMap<Integer, Integer>();
        int sum = 0;
        prefixSum.put(0, 0);
        for (int i = 1; i <= nums.length; i++) {
            sum += nums[i - 1];
            if (!prefixSum.containsKey(sum)) {
                prefixSum.put(sum, i);
            } else {
                List<Integer> result = new ArrayList<>();
                result.add(prefixSum.get(sum));
                result.add(i - 1);
                return result;
            }
        }

        return new ArrayList<Integer>();
    }


    private class Num {
        int val, index;
        private Num(int val, int index) {
            this.val = val;
            this.index = index;
        }

        public int getVal() {
            return this.val;
        }

        public int getIndex() {
            return this.index;
        }
    }
    /**
     * 8/2/2018
     * sort
     *
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    public List<Integer> subarraySum2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        Num[] numbers = new Num[nums.length + 1];
        numbers[0] = new Num(0, 0);

        int sum = 0;

        for (int i = 1; i <= numbers.length - 1; i++) {
            sum += nums[i - 1];
            numbers[i] = new Num(sum, i);
        }

        Arrays.sort(numbers, Comparator.comparing(Num::getVal).thenComparing(Num::getIndex));

        for (int i = 1; i <= numbers.length - 1; i++) {
            if (numbers[i].getVal() == numbers[i - 1].getVal()) {
                List<Integer> result = new ArrayList<>();
                result.add(numbers[i - 1].getIndex());
                result.add(numbers[i].getIndex() - 1);

                return result;
            }
        }

        return new ArrayList<>();
    }
}
