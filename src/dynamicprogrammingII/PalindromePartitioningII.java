package dynamicprogrammingII;

public class PalindromePartitioningII {
    /**
     * 6/10/2018
     *
     * Checking palindrome by setting palindrome, time complexity O(n2)
     * @param s: A string
     * @return: An integer
     */
    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int n = s.length();

        boolean[][] isPalindrome = new boolean[n][n + 1];

        for (int i = 0; i <= n - 1; i++) {
            isPalindrome[i][i] = true;
            isPalindrome[i][i + 1] = true;
        }

        for (int l = 2; l <= n; l++) {
            for (int i = 0; i <= n; i++) {
                int j = i + l;
                if (j > n) {
                    break;
                } else {
                    isPalindrome[i][j] = s.charAt(i) == s.charAt(j - 1) && isPalindrome[i + 1][j - 1];
                }
            }
        }

        int[] cut = new int[n + 1];

        cut[0] = -1;

        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j <= i - 1; j++) {
                if (isPalindrome[j][i]) {
                    min = Math.min(cut[j] + 1, min);
                }
            }
            cut[i] = min;
        }

        return cut[n];
    }



    /**
     * 6/10/2018
     *
     * Checking palindrome individually, not passing the test by time complexity O(n3)
     * @param s: A string
     * @return: An integer
     */
    public int minCut2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int n = s.length();
        int[] cut = new int[n + 1];

        cut[0] = -1;

        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j <= i - 1; j++) {
                if (isPalindrome(s.substring(j, i))) {
                    min = Math.min(cut[j] + 1, min);
                }
            }
            cut[i] = min;
        }

        return cut[n];
    }

    private boolean isPalindrome(String input) {
        int left = 0, right = input.length() - 1;
        while (left < right) {
            if (input.charAt(left) == input.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }

        return true;
    }
}
