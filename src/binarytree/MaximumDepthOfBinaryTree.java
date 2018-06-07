package binarytree;

public class MaximumDepthOfBinaryTree {
    /**
     * 6/2/2018
     *
     * @param root: The root of binary tree.
     * @return: An integer
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftMaxHeight = maxDepth(root.left);
        int rightMaxHeight = maxDepth(root.right);

        return Math.max(leftMaxHeight, rightMaxHeight) + 1;
    }
}
