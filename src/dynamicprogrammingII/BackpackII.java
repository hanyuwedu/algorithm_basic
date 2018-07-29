package dynamicprogrammingII;

public class BackpackII {
    /**
     * 6/10/2018
     * Optimized by rotated array
     *
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @param V: Given n items with value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int[] V) {
        if (m <= 0 || A == null || V == null) {
            return 0;
        }

        int n = A.length;

        int[][] value = new int[m + 1][2];

        for (int i = 0; i <= m; i++) {
            value[i][0] = 0;
        }

        for (int j = 1; j <= n; j++) {
            value[0][j % 2] = 0;
        }

        for (int j = 1; j <= n; j++) {
            for (int i = 1; i <= m; i++) {
                if (i >= A[j - 1]) {
                    value[i][j % 2] = Math.max(value[i - A[j - 1]][(j - 1) % 2] + V[j - 1], value[i][(j - 1) % 2]);
                } else {
                    value[i][j % 2] = value[i][(j - 1) % 2];
                }
            }
        }

        return value[m][n % 2];
    }


    /**
     * 6/10/2018
     *
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @param V: Given n items with value V[i]
     * @return: The maximum value
     */
    public int backPackII2(int m, int[] A, int[] V) {
        if (m <= 0 || A == null || V == null) {
            return 0;
        }

        int n = A.length;

        int[][] value = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            value[i][0] = 0;
        }

        for (int j = 1; j <= n; j++) {
            value[0][j] = 0;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i >= A[j - 1]) {
                    value[i][j] = Math.max(value[i - A[j - 1]][j - 1] + V[j - 1], value[i][j - 1]);
                } else {
                    value[i][j] = value[i][j - 1];
                }
            }
        }

        return value[m][n];
    }
}
