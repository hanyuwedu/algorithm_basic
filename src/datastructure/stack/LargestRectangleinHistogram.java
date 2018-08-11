package datastructure.stack;

import java.util.Stack;

public class LargestRectangleinHistogram {
    private class Column {
        int x, y;

        public Column(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    /**
     * 8/8/2018
     *
     * @param height: A list of integer
     * @return: The area of largest rectangle in the histogram
     */
    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        Stack<Column> mono = new Stack<>();
        int max = 0;

        for (int i = 0; i <= height.length; i++) {
            int next = i == height.length ? 0 : height[i];

            while (!mono.isEmpty() && mono.peek().y > next) {
                Column top = mono.pop();
                int right = i;
                int left = mono.isEmpty() ? -1 : mono.peek().x;
                int h = top.y;
                int area = (right - left - 1) * h;
                max = Math.max(area, max);
            }

            mono.push(new Column(i, next));
        }

        return max;
    }
}
