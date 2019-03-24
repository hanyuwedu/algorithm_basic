package Search.dfs;

import java.util.*;

public class ThreeSum {
    /**
     * 8/13/2018
     *
     * @param numbers: Give an array numbers of n integer
     * @return: Find all unique triplets in the array which gives the sum of zero.
     */
    public List<List<Integer>> threeSum(int[] numbers) {
        if (numbers == null || numbers.length < 3) {
            return new ArrayList();
        }

        Arrays.sort(numbers);
        Stack<Integer> stack = new Stack();
        Set<Integer> visited = new HashSet();
        List<List<Integer>> result = new ArrayList();

        dfs(numbers, visited, stack, result, 0, 0);

        return result;
    }

    private void dfs(int[] numbers, Set<Integer> visited, Stack<Integer> stack, List<List<Integer>> result, int sum, int i) {
        if (stack.size() == 3) {
            if (sum == 0) {
                result.add(new ArrayList(stack));
            }
            return;
        }

        for (int j = i; j <= numbers.length - 1; j++) {
            if (j != 0 && numbers[j] == numbers[j - 1] && !visited.contains(j - 1)) {
                continue;
            }
            stack.add(numbers[j]);
            visited.add(j);

            dfs(numbers, visited, stack, result, sum + numbers[j], j + 1);

            stack.pop();
            visited.remove(j);

        }
    }
}
