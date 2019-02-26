package gameday;

import java.util.Arrays;
import java.util.Stack;

public class MaximalRectangle {
    /**
     * 2/21/2019
     * Gameday
     * https://www.lintcode.com/problem/maximal-rectangle/description
     *
     * @param matrix: a boolean 2D matrix
     * @return: an integer
     */
    public int maximalRectangle(boolean[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int[][] height = getHeight(matrix);
        int max = 0;

        for (int i = 0; i <= height.length - 1; i++) {
            System.out.println(Arrays.toString(height[i]));
        }

        for (int i = 0; i <= height.length - 1; i++) {
            Stack<Integer> stack = new Stack<>();
            for (int j = 0; j <= height[i].length; j++) {
                int h = j < height[i].length ? height[i][j] : -1;
                while (!stack.isEmpty() && height[i][stack.peek()] > h) {
                    int current = stack.pop();
                    int left = stack.isEmpty() ? -1 : stack.peek();
                    int area = (j - left - 1) * height[i][current];
                    max = Math.max(max, area);
                }

                stack.push(j);
            }
        }

        return max;
    }

    private int[][] getHeight(boolean[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] height = new int[m][n];

        for (int j = 0; j <= n - 1; j++) {
            height[0][j] = matrix[0][j] ? 1 : 0;
        }

        for (int i = 1; i <= m - 1; i++) {
            for (int j = 0; j <= n - 1; j++) {
                height[i][j] = matrix[i][j] ? height[i - 1][j] + 1 : 0;
            }
        }

        return height;
    }


    public static void main(String[] args) {
        boolean[][] input = {{true, true, false, false, true},
                {false, true, false, false, true},
                {false, false, true, true, true},
                {false, false, true, true, true},
                {false, false, false, false, true}};

        System.out.println(new MaximalRectangle().maximalRectangle(input));

    }
}
