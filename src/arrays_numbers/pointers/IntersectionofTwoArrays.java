package arrays_numbers.pointers;

import java.util.*;
import java.util.stream.Collectors;

public class IntersectionofTwoArrays {
    /*
     * 8/1/20018
     * Two pointers
     *
     * @param nums1: an integer array
     * @param nums2: an integer array
     * @return: an integer array
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] nums1Copy = nums1.clone();
        int[] nums2copy = nums2.clone();

        Arrays.sort(nums1Copy);
        Arrays.sort(nums2copy);

        int left = 0, right = 0;
        List<Integer> result = new ArrayList<Integer>();

        while (left < nums1Copy.length && right < nums2copy.length) {
            if (nums1Copy[left] < nums2copy[right]) {
                left++;
            } else if (nums1Copy[left] > nums2copy[right]) {
                right++;
            } else {
                result.add(nums1Copy[left]);
                while (left < nums1Copy.length - 1 && nums1Copy[left] == nums1Copy[left + 1]) {
                    left++;
                }
                left++;

                while (right < nums2copy.length - 1 && nums2copy[right] == nums2copy[right + 1]) {
                    right++;
                }
                right++;
            }
        }

        return result.stream().mapToInt(ele -> ele).toArray();
    }

    /*
     * 8/1/2018
     * HashSet
     *
     * @param nums1: an integer array
     * @param nums2: an integer array
     * @return: an integer array
     */
    public int[] intersection1(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<Integer>();
        for (Integer current : nums1) {
            set.add(current);
        }

        List<Integer> result = new ArrayList<Integer>();

        for (Integer current : nums2) {
            if (set.contains(current)) {
                result.add(current);
                set.remove(current);
            }
        }

        return result.stream().mapToInt(ele -> ele).toArray();
    }
}
