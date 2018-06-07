package binarytree;

import java.util.*;

public class BinaryTreeLevelOrderTraversalII {
    /**
     * BFS
     * 6/2/2018
     *
     * @param root: A tree
     * @return: buttom-up level order a list of lists of integer
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<List<Integer>> stack = new Stack<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();

            for (int i = 1; i <= size; i++) {
                TreeNode current = queue.remove();
                list.add(current.val);

                if (current.left != null) {
                    queue.add(current.left);
                }

                if (current.right != null) {
                    queue.add(current.right);
                }
            }

            stack.add(list);
        }

        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }

        return result;
    }
}
