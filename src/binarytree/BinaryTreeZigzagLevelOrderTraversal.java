package binarytree;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {
    /**
     * BFS
     * 6/2/2018
     *
     * @param root: A Tree
     * @return: A list of lists of integer include the zigzag level order traversal of its nodes' values.
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean order = true;

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

            if (order) {
                result.add(list);
            } else {
                Collections.reverse(list);
                result.add(list);
            }

            order = !order;
        }

        return result;
    }
}
