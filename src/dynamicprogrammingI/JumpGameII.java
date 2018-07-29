package dynamicprogrammingI;

public class JumpGameII {
    /**
     * 6/6/2018
     *
     * @param A: A list of integers
     * @return: An integer
     */
    public int jump(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int n = A.length - 1;
        int[] step = new int[n + 1];
        step[0] = 0;

        boolean[] access = new boolean[n + 1];
        access[0] = true;


        for (int i = 1; i <= n; i++) {
            int steps = Integer.MAX_VALUE;

            for (int j = 0; j <= i - 1; j++) {
                if (i - j <= A[j] && access[j]) {
                    access[i] = true;
                    steps = Math.min(steps, step[j] + 1);
                }
            }

            if (access[i]) {
                step[i] = steps;
            } else {
                step[i] = -1;
            }
        }

        if (access[n]) {
            return step[n];
        } else {
            return -1;
        }
    }
}
