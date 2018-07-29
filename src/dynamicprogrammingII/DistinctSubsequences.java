package dynamicprogrammingII;

public class DistinctSubsequences {
    /*
     * 6/10/2018
     *
     * @param : A string
     * @param : A string
     * @return: Count the number of distinct subsequences
     */
    public int numDistinct(String S, String T) {
        if (S == null || T == null) {
            throw new IllegalArgumentException();
        }

        int m = S.length(), n = T.length();

        int[][] distinct = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            distinct[i][0] = 1;
        }

        for (int j = 1; j <= n; j++) {
            distinct[0][j] = 0;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (S.charAt(i - 1) == T.charAt(j - 1)) {
                    distinct[i][j] = distinct[i - 1][j - 1] + distinct[i - 1][j];
                } else {
                    distinct[i][j] = distinct[i - 1][j];
                }
            }
        }

        return distinct[m][n];
    }
}
