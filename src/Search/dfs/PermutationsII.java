package Search.dfs;

import java.util.*;

public class PermutationsII {
    /**
     * 8/13/2018
     *
     * @param :  A list of integers
     * @return: A list of unique permutations
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null) {
            return new ArrayList();
        }

        Arrays.sort(nums);
        Set<Integer> visited = new HashSet();
        List<List<Integer>> result = new ArrayList();
        Stack<Integer> stack = new Stack();

        dfs(nums, stack, visited, result);

        return result;
    }

    private void dfs(int[] nums, Stack<Integer> stack, Set<Integer> visited, List<List<Integer>> result) {
        if (stack.size() == nums.length) {
            result.add(new ArrayList(stack));
            return;
        }

        for (int i = 0; i <= nums.length - 1; i++) {
            if (i != 0 && nums[i] == nums[i - 1] && !visited.contains(i - 1)) {
                continue;
            }

            if (visited.contains(i)) {
                continue;
            }

            stack.add(nums[i]);
            visited.add(i);

            dfs(nums, stack, visited, result);

            stack.pop();
            visited.remove(i);
        }
    }
}
