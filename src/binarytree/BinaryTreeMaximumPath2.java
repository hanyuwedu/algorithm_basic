package binarytree;

public class BinaryTreeMaximumPath2 {
    /**
     * 6/2/2018
     *
     * @param root: the root of binary tree.
     * @return: An integer
     */
    public int maxPathSum2(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        int left = maxPathSum2(root.left);
        int right = maxPathSum2(root.right);

        return Math.max(0, Math.max(left, right)) + root.val;
    }
}
