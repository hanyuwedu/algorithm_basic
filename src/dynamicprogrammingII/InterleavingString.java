package dynamicprogrammingII;

import java.util.Arrays;

public class InterleavingString {
    /**
     * 6/10/2018
     *
     * @param s1: A string
     * @param s2: A string
     * @param s3: A string
     * @return: Determine whether s3 is formed by interleaving of s1 and s2
     */
    public static boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null) {
            throw new IllegalArgumentException();
        }

        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        int m = s1.length(), n = s2.length();
        boolean[][] patch = new boolean[m + 1][n + 1];

        patch[0][0] = true;

        for (int i = 1; i <= m; i++) {
            patch[i][0] = s3.substring(0, i).equals(s1.substring(0, i));
        }

        for (int j = 1; j <= n; j++) {
            patch[0][j] = s3.substring(0, j).equals(s2.substring(0, j));
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s3.charAt(i + j - 1) == s2.charAt(j - 1) || s3.charAt(i + j - 1) == s1.charAt(i - 1)) {
                    patch[i][j] = patch[i - 1][j] || patch[i][j - 1];
                } else if (s3.charAt(i + j - 1) == s2.charAt(j - 1)) {
                    patch[i][j] = patch[i][j - 1];
                } else if (s3.charAt(i + j - 1) == s1.charAt(i - 1)) {
                    patch[i][j] = patch[i - 1][j];
                } else {
                    patch[i][j] = false;
                }
                System.out.println(i + ", " + j + " = " + patch[i][j]);
            }
        }

        for (int i = 0; i <= m; i++) {
            System.out.println(Arrays.toString(patch[i]));
        }


        return patch[m][n];
    }

    public static void main(String[] args) {
        System.out.println(isInterleave("aacaac",
                "aacaaeaac",
                "aacaaeaaeaacaac"));
    }
}
