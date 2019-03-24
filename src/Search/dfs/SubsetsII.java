package Search.dfs;

import java.util.*;

public class SubsetsII {
    /**
     * 8/13/2018
     *
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null) {
            return new ArrayList();
        }

        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList();
        Stack<Integer> stack = new Stack();
        Set<Integer> visited = new HashSet();

        dfs(nums, stack, visited, result, 0);

        return result;
    }

    private void dfs(int[] nums, Stack<Integer> stack, Set<Integer> visited, List<List<Integer>> result, int i) {
        result.add(new ArrayList(stack));

        if (i == nums.length) {
            return;
        }

        for (int j = i; j <= nums.length - 1; j++) {
            if (j != 0 && nums[j] == nums[j - 1] && !visited.contains(j - 1)) {
                continue;
            }

            stack.add(nums[j]);
            visited.add(j);

            dfs(nums, stack, visited, result, j + 1);

            stack.pop();
            visited.remove(j);
        }
    }
}
