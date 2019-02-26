package gameday;

public class WoodCut {
    /**
     * 2/23/2019
     * GameDay
     * https://www.lintcode.com/problem/wood-cut/description
     *
     * @param L: Given n pieces of wood with length L[i]
     * @param k: An integer
     * @return: The maximum length of the small pieces
     */
    public int woodCut(int[] L, int k) {
        if (L == null || L.length == 0) {
            return 0;
        }


        int right = 0;
        for (int l : L) {
            right = Math.max(l, right);
        }

        int left = 0;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (getPieces(L, mid) < k) {
                right = mid;
            } else if (getPieces(L, mid) > k) {
                left = mid;
            } else {
                left = mid;
            }
        }

        if (getPieces(L, right) == k) {
            return right;
        } else {
            return left;
        }
    }

    private int getPieces(int[] L, int length) {
        int pieces = 0;
        for (int l : L) {
            pieces += l / length;
        }

        return pieces;
    }
}
