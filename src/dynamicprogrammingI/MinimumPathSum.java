package dynamicprogrammingI;

public class MinimumPathSum {
    /**
     * 6/6/2018
     *
     * @param grid: a list of lists of integers
     * @return: An integer, minimizes the sum of all numbers along its path
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length - 1;
        int n = grid[0].length - 1;

        int[][] sum = new int[m + 1][n + 1];

        sum[0][0] = grid[0][0];

        for (int i = 1; i <= m; i++) {
            sum[i][0] = grid[i][0] + sum[i - 1][0];
        }

        for (int j = 1; j <= n; j++) {
            sum[0][j] = grid[0][j] + sum[0][j - 1];
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = grid[i][j] + Math.min(sum[i - 1][j], sum[i][j - 1]);
            }
        }

        return sum[m][n];
    }
}
