package binarytree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {
    /**
     * "Anti preorder"
     * "BFS"
     * 6/2/2018
     *
     * @param root: A Tree
     * @return: Postorder in ArrayList which contains node values.
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if (root == null) {
            return list;
        }

        stack.add(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            list.add(current.val);

            if (current.left != null) {
                stack.add(current.left);
            }

            if (current.right != null) {
                stack.add(current.right);
            }
        }

        Collections.reverse(list);
        return list;
    }


    /**
     * Recursion
     * 6/2/2018
     *
     * @param root: A Tree
     * @return: Postorder in ArrayList which contains node values.
     */
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traversal(root, list);
        return list;
    }

    private void traversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        traversal(root.left, list);
        traversal(root.right, list);
        list.add(root.val);
    }
}
