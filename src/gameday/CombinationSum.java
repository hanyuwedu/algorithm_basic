package gameday;

import java.util.*;

public class CombinationSum {
    /**
     * 2/21/2019
     * Gameday
     * https://www.lintcode.com/problem/combination-sum/
     *
     * @param candidates: A list of integers
     * @param target: An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        Arrays.sort(candidates);

        dfs(candidates, target, list, stack, 0, 0);

        return list;
    }

    private void dfs(int[] candidates, int target, List<List<Integer>> list, Stack<Integer> stack, int index, int sum) {
        if (sum == target) {
            list.add(new ArrayList<>(stack));
            return;
        }

        if (sum > target) {
            return;
        }

        if (index == candidates.length) {
            return;
        }

        dfs(candidates, target, list, stack, index + 1, sum);

        if (index > 0 && candidates[index] == candidates[index - 1]) {
            return;
        }

        stack.push(candidates[index]);

        dfs(candidates, target, list, stack, index, sum + candidates[index]);

        stack.pop();
    }
}
