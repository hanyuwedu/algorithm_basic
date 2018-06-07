package binarytree;

public class ValidBinarySearchTree {
    /**
     * Use node instead of value to better keep track of null situation
     * 6/2/2018
     *
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    private class Info {
        TreeNode min;
        TreeNode max;
        boolean isValid;

        private Info() {
            this.min = null;
            this.max = null;
            this.isValid = true;
        }
    }

    public boolean isValidBST(TreeNode root) {
        return divideAndConquer(root).isValid;
    }

    private Info divideAndConquer(TreeNode root) {
        if (root == null) {
            return new Info();
        }

        Info left = divideAndConquer(root.left);
        Info right = divideAndConquer(root.right);

        Info current = new Info();
        if (right.max == null) {
            current.max = root;
        } else {
            current.max = right.max;
        }

        if (left.min == null) {
            current.min = root;
        } else {
            current.min = left.min;
        }

        current.isValid = left.isValid && right.isValid
                && (left.max == null || root.val > left.max.val)
                && (right.min == null || root.val < right.min.val);

        return current;
    }
}
