package binarytree;

public class LowestCommonAncestor {
    /**
     * 6/2/2018
     *
     * @param root: The root of the binary search tree.
     * @param A: A TreeNode in a Binary.
     * @param B: A TreeNode in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null) {
            return null;
        }

        TreeNode left = lowestCommonAncestor(root.left, A, B);
        TreeNode right = lowestCommonAncestor(root.right, A, B);

        if (root == A || root == B) {
            return root;
        }

        if (left != null && right != null) {
            return root;
        }

        if (left != null) {
            return left;
        }

        if (right!= null) {
            return right;
        }

        return null;
    }
}
