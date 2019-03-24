package Search.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Subsets {
    /**
     * 8/13/2018
     *
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null) {
            return new ArrayList();
        }

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList();
        Stack<Integer> current = new Stack();

        dfs(result, current, nums, 0);

        return result;
    }

    private void dfs(List<List<Integer>> result, Stack<Integer> current, int[] nums, int i) {
        result.add(new ArrayList<Integer>(current));

        if (i == nums.length) {
            return;
        }

        for (int j = i; j <= nums.length - 1; j++) {
            current.add(nums[j]);
            dfs(result, current, nums, j + 1);
            current.pop();
        }
    }
}
