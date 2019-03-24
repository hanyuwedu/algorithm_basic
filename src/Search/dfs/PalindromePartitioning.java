package Search.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class PalindromePartitioning {
    /**
     * 8/13/2018
     *
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList();
        }

        boolean[][] isPalindrome = getPalindrome(s);

        Stack<String> stack = new Stack();
        List<List<String>> result = new ArrayList();

        dfs(s, isPalindrome, stack, result, 0);

        return result;
    }

    private void dfs(String s, boolean[][] isPalindrome, Stack<String> stack, List<List<String>> result, int i) {
        if (i == s.length()) {
            result.add(new ArrayList(stack));
            return;
        }

        for (int j = i + 1; j <= s.length(); j++) {
            if (isPalindrome[i][j]) {
                stack.add(s.substring(i, j));
                dfs(s, isPalindrome, stack, result, j);
                stack.pop();
            }
        }
    }

    private boolean[][] getPalindrome(String s) {
        boolean[][] isPalindrome = new boolean[s.length()][s.length() + 1];

        for (int width = 0; width <= 1; width++) {
            for (int i = 0; i <= s.length() - 1; i++) {
                isPalindrome[i][i + width] = true;
            }
        }

        for (int width = 2; width <= s.length(); width++) {
            for (int i = 0; i <= s.length() - 1; i++) {
                if (i + width > s.length()) {
                    continue;
                }

                isPalindrome[i][i + width] = isPalindrome[i + 1][i + width - 1] && s.charAt(i) == s.charAt(i + width - 1);
            }
        }

        return isPalindrome;
    }
}
