package binarytree;

public class BinaryTreeMaximumPath {
    /**
     * 6/2/2018
     *
     * @param root: The root of binary tree.
     * @return: An integer
     */
    private class Info {
        int rootToAny;
        int anyToAny;

        private Info() {
            this.rootToAny = Integer.MIN_VALUE;
            this.anyToAny = Integer.MIN_VALUE;
        }
    }

    public int maxPathSum(TreeNode root) {
        return divideAndConquer(root).anyToAny;
    }

    private Info divideAndConquer(TreeNode root) {
        if (root == null) {
            return new Info();
        }

        Info left = divideAndConquer(root.left);
        Info right = divideAndConquer(root.right);

        int rootToAny = Math.max(0, Math.max(left.rootToAny, right.rootToAny)) + root.val;
        int anyToAny = Math.max(Math.max(left.anyToAny, right.anyToAny),
                Math.max(0, left.rootToAny) + root.val + Math.max(0, right.rootToAny));
        Info current = new Info();
        current.rootToAny = rootToAny;
        current.anyToAny = anyToAny;
        return current;
    }
}
