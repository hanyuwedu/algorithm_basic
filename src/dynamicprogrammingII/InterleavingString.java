package dynamicprogrammingII;

import java.util.Arrays;

public class InterleavingString {
    /**
     * 7/31/2018
     *
     * @param s1: A string
     * @param s2: A string
     * @param s3: A string
     * @return: Determine whether s3 is formed by interleaving of s1 and s2
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        int m = s1.length();
        int n = s2.length();

        boolean[][] interleave = new boolean[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            interleave[i][0] = s3.substring(0, i).equals(s1.substring(0, i));
        }

        for (int j = 0; j <= n; j++) {
            interleave[0][j] = s3.substring(0, j).equals(s2.substring(0, j));
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s3.charAt(i + j - 1) == s1.charAt(i - 1) && interleave[i - 1][j]) {
                    interleave[i][j] = true;
                } else if (s3.charAt(i + j - 1) == s2.charAt(j - 1) && interleave[i][j - 1]) {
                    interleave[i][j] = true;
                } else {
                    interleave[i][j] = false;
                }
            }
        }

        return interleave[m][n];
    }
}
