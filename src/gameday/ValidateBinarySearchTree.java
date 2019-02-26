package gameday;
import util.TreeNode;

public class ValidateBinarySearchTree {
    /**
     * 2/21/2019
     * GameDay
     * https://www.lintcode.com/problem/validate-binary-search-tree/description
     *
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isValid(root).isValid;
    }

    private Info isValid(TreeNode root) {
        if (root == null) {
            return null;
        }

        Info left = isValid(root.left);
        Info right = isValid(root.right);

        int max = root.val, min = root.val;
        boolean isValid = true;

        if (left != null) {
            min = left.min;
            isValid = isValid && left.isValid && left.max < root.val;
        }

        if (right != null) {
            max = right.max;
            isValid = isValid && right.isValid && right.min > root.val;
        }

        return new Info(max, min, isValid);
    }


    private class Info {
        int max, min;
        boolean isValid;

        private Info(int max, int min, boolean isValid) {
            this.max = max;
            this.min = min;
            this.isValid = isValid;
        }
    }
}
