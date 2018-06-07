package gameday;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://www.lintcode.com/problem/binary-tree-inorder-traversal/description
 */
public class BinaryTreeInorderTraversal {
    /**
     * Stacking
     * 6/2/2018
     *
     * @param root: A Tree
     * @return: Inorder in ArrayList which contains node values.
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (!stack.isEmpty() || current != null) {
            while (current != null) {
                stack.add(current);
                current = current.left;
            }

            current = stack.pop();
            result.add(current.val);
            current = current.right;
        }

        return result;
    }


    /**
     * Recursion
     * 6/2/2018
     *
     * @param root: A Tree
     * @return: Inorder in ArrayList which contains node values.
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traversal(root, list);
        return list;
    }

    private void traversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        traversal(root.left, list);
        list.add(root.val);
        traversal(root.right, list);
    }
}
