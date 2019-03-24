package Search.dfs;

import java.util.*;

public class Permutations {
    /*
     * 8/13/2018
     *
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null) {
            return new ArrayList();
        }

        Set<Integer> visited = new HashSet();
        Stack<Integer> stack = new Stack();
        List<List<Integer>> result = new ArrayList();

        dfs(nums, stack, visited, result);
        return result;
    }

    private void dfs(int[] nums, Stack<Integer> stack, Set<Integer> visited, List<List<Integer>> result) {
        if (stack.size() == nums.length) {
            result.add(new ArrayList(stack));
            return;
        }

        for (int i = 0; i <= nums.length - 1; i++) {
            if (visited.contains(i)) {
                continue;
            }

            stack.push(nums[i]);
            visited.add(i);

            dfs(nums, stack, visited, result);

            stack.pop();
            visited.remove(i);
        }
    }
}
