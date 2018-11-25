package gameday;

public class ValidBinarySearchTree {
    /**
     * Apply isNull information
     * 11/24/2018
     *
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        return divideConquer(root).isValid;
    }

    private class Info {
        boolean isValid;
        int max, min;
        boolean isNull;

        private Info(boolean isValid, int max, int min, boolean isNull) {
            this.isValid = isValid;
            this.max = max;
            this.min = min;
            this.isNull = isNull;
        }
    }

    private Info divideConquer(TreeNode root) {
        if (root == null) {
            return new Info(true, 0, 0, true);
        }

        Info left = divideConquer(root.left);
        Info right = divideConquer(root.right);

        boolean isValid = true;
        int min = root.val, max = root.val;

        if (!left.isNull) {
            isValid = isValid && left.isValid && left.max < root.val;
            min = left.min;
        }

        if (!right.isNull) {
            isValid = isValid && right.isValid && right.min > root.val;
            max = right.max;
        }

        return new Info(isValid, max, min, false);
    }


    /**
     * Use node instead of value to better keep track of null situation
     * 6/2/2018
     *
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    private class Info2 {
        TreeNode min;
        TreeNode max;
        boolean isValid;

        private Info2() {
            this.min = null;
            this.max = null;
            this.isValid = true;
        }
    }

    public boolean isValidBST(TreeNode root) {
        return divideAndConquer(root).isValid;
    }

    private Info2 divideAndConquer(TreeNode root) {
        if (root == null) {
            return new Info2();
        }

        Info2 left = divideAndConquer(root.left);
        Info2 right = divideAndConquer(root.right);

        Info2 current = new Info2();
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
