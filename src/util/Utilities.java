package util;

import java.util.Arrays;
import java.util.TreeMap;

public class Utilities {
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i <= matrix.length - 1; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    public static char[][] stringToCharMatrix(String[] strs) {
        char[][] chars = new char[strs.length][strs[0].length()];

        for (int i = 0; i <= chars.length - 1; i++) {
            for (int j = 0; j <= chars[i].length - 1; j++) {
                chars[i][j] = strs[i].charAt(j);
            }
        }

        return chars;
    }
}
