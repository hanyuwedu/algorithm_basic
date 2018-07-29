package dynamicprogrammingI;

public class JumpGame {
    /**
     * 6/6/2018
     *
     * @param A: A list of integers
     * @return: A boolean
     */
    public boolean canJump(int[] A) {
        if (A == null || A.length == 0) {
            return false;
        }

        int n = A.length - 1;
        boolean[] access = new boolean[n + 1];

        access[0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= n - 1; j++) {
                if (access[j] && i - j <= A[j]) {
                    access[i] = true;
                    break;
                }
            }
        }

        return access[n];
    }
}
