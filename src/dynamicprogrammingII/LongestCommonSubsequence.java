package dynamicprogrammingII;

public class LongestCommonSubsequence {
    /**
     * 6/10/2018
     *
     * @param A: A string
     * @param B: A string
     * @return: The length of longest common subsequence of A and B
     */
    public int longestCommonSubsequence(String A, String B) {
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
                    common[i][j] = Math.max(common[i - 1][j - 1] + 1, Math.max(common[i - 1][j], common[i][j - 1]));
                } else {
                    common[i][j] = Math.max(common[i - 1][j], common[i][j - 1]);
                }
            }
        }

        return common[m][n];
    }
}
