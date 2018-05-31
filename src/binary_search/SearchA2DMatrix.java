package binary_search;

public class SearchA2DMatrix {
    /**
     * 5/30/18
     * Find the first position
     *
     * @param matrix: matrix, a list of lists of integers
     * @param target: An integer
     * @return: a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m * n - 1;

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            int midValue = getValue(mid, matrix);
            if (midValue > target) {
                right = mid;
            } else if (midValue < target) {
                left = mid;
            } else {
                right = mid;
            }
        }

        if (getValue(left, matrix) == target || getValue(right, matrix) == target) {
            return true;
        } else {
            return false;
        }
    }

    private int getValue(int pos, int[][] matrix) {
        int n = matrix[0].length;
        return matrix[pos / n][pos % n];
    }
}
