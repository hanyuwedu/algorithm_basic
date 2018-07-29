package dynamicprogrammingII;

public class EditDistance {
    /**
     * 6/10/2018
     *
     * @param word1: A string
     * @param word2: A string
     * @return: The minimum number of steps.
     */
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) {
            throw new IllegalArgumentException();
        }

        int m = word1.length(), n = word2.length();
        int[][] edit = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            edit[i][0] = i;
        }

        for (int j = 0; j <= n; j++) {

            edit[0][j] = j;
        }

        for (int i = 1; i <= m ;i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    edit[i][j] = Math.min(edit[i - 1][j - 1], Math.min(edit[i - 1][j] + 1, edit[i][j - 1] + 1));
                } else {
                    edit[i][j] = Math.min(edit[i - 1][j - 1] + 1, Math.min(edit[i - 1][j] + 1, edit[i][j - 1] + 1));
                }
            }
        }

        return edit[m][n];
    }
}
