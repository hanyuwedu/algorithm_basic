package dynamicprogrammingI;

public class UniquePathsII {
    /**
     * 6/6/2018
     * rotated array
     *
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }

        int m = obstacleGrid.length - 1;
        int n = obstacleGrid[0].length - 1;

        int[] steps = new int[n + 1];

        steps[0] = 1 - obstacleGrid[0][0];
        for (int j = 1; j <= n; j++) {
            steps[j] = (1 - obstacleGrid[0][j]) * steps[j - 1];
        }

        for (int i = 1; i <= m; i++) {
            steps[0] = steps[0] * (1 - obstacleGrid[i][0]);
            for (int j = 1; j <= n; j++) {
                steps[j] = (1 - obstacleGrid[i][j]) * (steps[j] + steps[j - 1]);
            }
        }

        return steps[n];
    }


    /**
     * 6/6/2018
     *
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }

        int m = obstacleGrid.length - 1;
        int n = obstacleGrid[0].length - 1;
        int[][] paths = new int[m + 1][n + 1];

        paths[0][0] = 1 - obstacleGrid[0][0];

        for (int i = 1; i <= m; i++) {
            paths[i][0] = (1 - obstacleGrid[i][0]) * paths[i - 1][0];
        }

        for (int j = 1; j <= n; j++) {
            paths[0][j] = (1 - obstacleGrid[0][j]) * paths[0][j - 1];
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                paths[i][j] = (1 - obstacleGrid[i][j]) * (paths[i - 1][j] + paths[i][j - 1]);
            }
        }

        return paths[m][n];
    }
}
