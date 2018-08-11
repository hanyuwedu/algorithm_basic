package gameday;

import java.util.Stack;

public class MaximalRectangle {
    /**
     * 8/8/2018
     *
     * @param matrix: a boolean 2D matrix
     * @return: an integer
     */
    public int maximalRectangle(boolean[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int m = matrix.length, n = matrix[0].length;
        int[][] height = new int[m][n];

        for (int i = 0; i <= n - 1; i++) {
            height[0][i] = matrix[0][i] ? 1 : 0;
        }

        for (int j = 1; j <= m - 1; j++) {
            for (int i = 0; i <= n - 1; i++) {
                height[j][i] = matrix[j][i] ? 1 + height[j - 1][i] : 0;
            }
        }

        int max = 0;
        for (int j = 0; j <= m - 1; j++) {
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i <= n; i++) {
                int next = i == n ? -1 : height[j][i];

                while (!stack.isEmpty() && next < height[j][stack.peek()]) {
                    int current = stack.pop();
                    int h = height[j][current];
                    int left = stack.isEmpty() ? -1 : stack.peek();
                    int right = i;
                    int area = (right - left - 1) * h;
                    max = Math.max(area, max);
                }

                stack.push(i);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        boolean[][] input = {{true,true,false,false,true},
                {false,true,false,false,true},
                {false,false,true,true,true},
                {false,false,true,true,true},
                {false,false,false,false,true}};
        MaximalRectangle mr = new MaximalRectangle();
        System.out.println(mr.maximalRectangle(input));
    }
}
