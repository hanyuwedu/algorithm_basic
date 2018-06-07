package binarytree;

import java.util.Stack;

public class BSTIterator {
    Stack<TreeNode> stack;
    TreeNode current;

    /*
     * @param root: The root of binary tree.
     */
    public BSTIterator(TreeNode root) {
        this.stack = new Stack<>();
        if (root != null) {
            this.current = root;
        }
    }

    /*
     * @return: True if there has next node, or false
     */
    public boolean hasNext() {
        return !this.stack.isEmpty() || this.current != null;
    }

    /*
     * @return: return next node
     */
    public TreeNode next() {
        while (current != null) {
            stack.add(current);
            current = current.left;
        }

        current = stack.pop();
        TreeNode next = current;
        current = current.right;

        return next;
    }
}