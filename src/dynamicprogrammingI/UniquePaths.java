package dynamicprogrammingI;

public class UniquePaths {
    /**
     * 6/6/2018
     *
     * @param m: positive integer (1 <= m <= 100)
     * @param n: positive integer (1 <= n <= 100)
     * @return: An integer
     */
    public int uniquePaths(int m, int n) {
        int[][] path = new int[m][n];
        for (int i = 0; i <= m - 1; i++) {
            path[i][0] = 1;
        }

        for (int j = 0; j <= n - 1; j++) {
            path[0][j] = 1;
        }

        for (int i = 1; i <= m - 1; i++) {
            for (int j = 1; j <= n - 1; j++) {
                path[i][j] = path[i - 1][j] + path[i][j - 1];
            }
        }

        return path[m - 1][n - 1];
    }
}
