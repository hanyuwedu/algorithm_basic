package Search.dfs;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    /**
     * 8/13/2018
     *
     * @param n: The number of queens
     * @return: All distinct solutions
     */
    public List<List<String>> solveNQueens(int n) {
        if (n <= 0) {
            return new ArrayList();
        }

        List<List<String>> result = new ArrayList();
        List<Integer> queens = new ArrayList();

        dfs(queens, result, n);
        return result;
    }

    private void dfs(List<Integer> queens, List<List<String>> result, int n) {
        if (queens.size() == n) {
            result.add(getBoard(queens));
            return;
        }

        for (int i = 0; i <= n - 1; i++) {
            if (isValid(queens.size(), i, queens)) {
                queens.add(i);
                dfs(queens, result, n);
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

    private List<String> getBoard(List<Integer> queens) {
        List<String> board = new ArrayList();
        for (int i = 0; i <= queens.size() - 1; i++) {
            char[] chars = new char[queens.size()];
            for (int j = 0; j <= queens.size() - 1; j++) {
                chars[j] = '.';
            }
            chars[queens.get(i)] = 'Q';
            board.add(new String(chars));
        }

        return board;
    }
}
