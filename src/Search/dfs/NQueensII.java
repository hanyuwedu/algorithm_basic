package Search.dfs;

import java.util.ArrayList;
import java.util.List;

public class NQueensII {
    /**
     * 8/13/2018
     *
     * @param n: The number of queens.
     * @return: The total number of distinct solutions.
     */
    public int totalNQueens(int n) {
        if (n <= 0) {
            return 0;
        }

        List<List<String>> result = new ArrayList();
        List<Integer> queens = new ArrayList();
        int[] solutions = {0};

        dfs(queens, solutions, n);
        return solutions[0];
    }

    private void dfs(List<Integer> queens, int[] solutions, int n) {
        if (queens.size() == n) {
            solutions[0]++;
            return;
        }

        for (int i = 0; i <= n - 1; i++) {
            if (isValid(queens.size(), i, queens)) {
                queens.add(i);
                dfs(queens, solutions, n);
                queens.remove(queens.size() - 1);
            }
        }
    }

    private boolean isValid(int col, int row, List<Integer> queens) {
        if (queens.contains(row)) {
            return false;
        }

        for (int i = 0; i <= queens.size() - 1; i++) {
            if (col + row == i + queens.get(i)) {
                return false;
            }

            if (col - row == i - queens.get(i)) {
                return false;
            }
        }

        return true;
    }
}
