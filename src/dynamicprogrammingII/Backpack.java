package dynamicprogrammingII;

public class Backpack {
    /**
     * 6/10/2018
     *
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        if (m <= 0 || A == null || A.length == 0) {
            return 0;
        }

        int n = A.length;
        int[][] value = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            value[i][0] = 0;
        }

        for (int j = 0; j <= n; j++) {
            value[0][j] = 0;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i >= A[j - 1]) {
                    value[i][j] = Math.max(value[i - A[j - 1]][j - 1] + A[j - 1], value[i][j - 1]);
                } else {
                    value[i][j] = value[i][j - 1];
                }
            }
        }

        return value[m][n];
    }
}
