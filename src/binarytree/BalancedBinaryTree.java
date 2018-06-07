package binarytree;

public class BalancedBinaryTree {
    /**
     * 6/2/2018
     *
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    private class Info {
        int height;
        boolean isBalanced;

        private Info(int height, boolean isBalanced) {
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        return divideAndConquer(root).isBalanced;
    }


    private Info divideAndConquer(TreeNode root) {
        if (root == null) {
            return new Info(0, true);
        }

        Info left = divideAndConquer(root.left);
        Info right = divideAndConquer(root.right);

        Info current = new Info(Math.max(left.height, right.height) + 1,
                left.isBalanced && right.isBalanced && Math.abs(left.height - right.height) <= 1);
        return current;
    }
}
