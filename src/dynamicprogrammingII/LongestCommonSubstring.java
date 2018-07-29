package dynamicprogrammingII;

public class LongestCommonSubstring {
    /**
     * 6/10/2018
     *
     * @param A: A string
     * @param B: A string
     * @return: the length of the longest common substring.
     */
    public int longestCommonSubstring(String A, String B) {
        if (A == null || B == null || A.length() == 0 || B.length() == 0) {
            return 0;
        }

        int m = A.length(), n = B.length();

        int[][] common = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            common[i][0] = 0;
        }

        for (int j = 0; j <= n; j++) {
            common[0][j] = 0;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    common[i][j] = common[i - 1][j - 1] + 1;
                } else {
                    common[i][j] = 0;
                }
            }
        }

        int max = 0;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                max = Math.max(max, common[i][j]);
            }
        }

        return max;
    }
}
