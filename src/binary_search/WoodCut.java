package binary_search;

public class WoodCut {
    /**
     * 5/30/18
     * Find the last length that could be cut intoo k pieces
     * Notice that the minimum cuttable length is 1 instead of 0
     *
     * @param L: Given n pieces of wood with length L[i]
     * @param k: An integer
     * @return: The maximum length of the small pieces
     */
    public int woodCut(int[] L, int k) {
        if (L == null || L.length == 0) {
            return 0;
        }

        int max = 0;
        for (int i = 0; i <= L.length - 1; i++) {
            max = Math.max(max, L[i]);
        }

        int left = 1, right = max;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            int pieces = getPieces(L, mid);

            if (pieces > k) {
                left = mid;
            } else if (pieces < k) {
                right = mid;
            } else {
                left = mid;
            }
        }

        if (getPieces(L, right) >= k) {
            return right;
        } else if (getPieces(L, left) >= k) {
            return left;
        } else {
            return 0;
        }
    }

    private int getPieces(int[] L, int len) {
        int pieces = 0;
        for (int i = 0; i <= L.length - 1; i++) {
            pieces += L[i] / len;
        }
        return pieces;
    }
}
