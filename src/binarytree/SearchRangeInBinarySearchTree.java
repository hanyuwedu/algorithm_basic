package binarytree;

import java.util.ArrayList;
import java.util.List;

public class SearchRangeInBinarySearchTree {
    /**
     * 6/2/2018
     *
     * @param root: param root: The root of the binary search tree
     * @param k1: An integer
     * @param k2: An integer
     * @return: return: Return all keys that k1<=key<=k2 in ascending order
     */
    public List<Integer> searchRange(TreeNode root, int k1, int k2) {
        if (root == null) {
            return new ArrayList<Integer>();
        }

        List<Integer> result = new ArrayList<Integer>();

        if (root.val >= k1) {
            result.addAll(searchRange(root.left, k1, k2));
        }

        if (root.val <= k2 && root.val >= k1) {
            result.add(root.val);
        }

        if (root.val <= k2) {
            result.addAll(searchRange(root.right, k1, k2));
        }

        return result;
    }
}
