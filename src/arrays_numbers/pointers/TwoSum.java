package arrays_numbers.pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class TwoSum {
    public class Element {
        int val;
        int index;

        public Element(int val, int index) {
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
     * 8/1/2018
     *
     * @param numbers: An array of Integer
     * @param target: target = numbers[index1] + numbers[index2]
     * @return: [index1, index2] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        int m = numbers.length;
        Element[] elementArray = new Element[m];

        for (int i = 0; i <= m - 1; i++) {
            elementArray[i] = new Element(numbers[i], i);
        }

        Arrays.sort(elementArray, Comparator.comparing(Element::getVal).thenComparing(Element::getIndex));

        int left = 0, right = m - 1;

        while (left <= right) {
            int sum = elementArray[left].val + elementArray[right].val;
            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                int[] result = new int[2];
                result[0] = elementArray[left].index;
                result[1] = elementArray[right].index;
                Arrays.sort(result);

                return result;
            }
        }

        return new int[0];
    }
}
