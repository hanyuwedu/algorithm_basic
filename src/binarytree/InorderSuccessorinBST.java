package binarytree;

public class InorderSuccessorinBST {
    /**
     * 6/2/2018
     *
     * @param root: The root of the BST.
     * @param p: You need find the successor node of p.
     * @return: Successor of p.
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return null;
        }

        TreeNode up = root, down = root;

        while (down != null && down != p) {
            if (down.val > p.val) {
                up = down;
                down = down.left;
            } else if (down.val < p.val) {
                down = down.right;
            }
        }

        if (down == null) {
            return null;
        }

        if (down.right != null) {
            down = down.right;
            while (down.left != null) {
                down = down.left;
            }
            return down;
        }


        if (down.val < up.val) {
            return up;
        }

        return null;
    }
}
