package Search.dfs;

import java.util.*;

public class CombinationSum {
    /**
     * 8/13/2018
     *
     * @param candidates: A list of integers
     * @param target: An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return new ArrayList();
        }

        Arrays.sort(candidates);
        Stack<Integer> stack = new Stack();
        List<List<Integer>> result = new ArrayList();
        Set<Integer> visited = new HashSet();

        dfs(candidates, target, result, visited, stack, 0, 0);

        return result;
    }

    private void dfs(int[] candidates, int target, List<List<Integer>> result, Set<Integer> visited, Stack<Integer> stack, int sum, int i) {
        if (sum == target) {
            result.add(new ArrayList(stack));
            return;
        }

        if (sum > target) {
            return;
        }

        for (int j = i; j <= candidates.length - 1; j++) {
            if (j != 0 && candidates[j] == candidates[j - 1] && !visited.contains(j - 1)) {
                continue;
            }
            stack.add(candidates[j]);
            visited.add(j);
            dfs(candidates, target, result, visited, stack, sum + candidates[j], j);
            stack.pop();
            visited.remove(j);
        }
    }
}
