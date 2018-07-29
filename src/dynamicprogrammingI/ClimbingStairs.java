package dynamicprogrammingI;

public class ClimbingStairs {
    /**
     * 6/6/2018
     * Rotated array
     *
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        int[] step = new int[2];

        step[0] = step[1] = 1;

        for (int i = 2; i <= n; i++) {
            step[i % 2] = step[0] + step[1];
        }

        return step[n % 2];
    }


    /**
     * 6/6/2018
     *
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs2(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        int[] step = new int[n + 1];
        step[0] = 1;
        step[1] = 1;

        for (int i = 2; i <= n; i++) {
            step[i] = step[i - 1] + step[i - 2];
        }

        return step[n];
    }
}
