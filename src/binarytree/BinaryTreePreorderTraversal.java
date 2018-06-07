package binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
    /**
     * "BFS"
     * 6/2/2018
     *
     * @param root: A Tree
     * @return: Preorder in ArrayList which contains node values.
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if (root == null) {
            return list;
        }

        stack.add(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            list.add(current.val);

            if (current.right != null) {
                stack.add(current.right);
            }

            if (current.left != null) {
                stack.add(current.left);
            }
        }

        return list;
    }


    /**
     * Recursion
     * 6/2/2018
     *
     * @param root: A Tree
     * @return: Preorder in ArrayList which contains node values.
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traversal(root, list);
        return list;
    }

    private void traversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        list.add(root.val);
        traversal(root.left, list);
        traversal(root.right, list);
    }
}
