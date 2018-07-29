package dynamicprogrammingI;

public class Triangle {
    /**
     * 6/6/2018
     *
     * @param triangle: a list of lists of integers
     * @return: An integer, minimum path sum
     */
    public int minimumTotal(int[][] triangle) {
        if (triangle == null || triangle.length == 0) {
            return 0;
        }

        int n = triangle.length - 1;
        int[][] sum = new int[n + 1][n + 1];

        sum[0][0] = triangle[0][0];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                int current = Integer.MAX_VALUE;
                if (j < i) {
                    current = Math.min(current, sum[i - 1][j] + triangle[i][j]);
                }

                if (j - 1 >= 0) {
                    current = Math.min(current, sum[i - 1][j - 1] + triangle[i][j]);
                }
                sum[i][j] = current;
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            result = Math.min(sum[n][i], result);
        }
        return result;
    }
}
