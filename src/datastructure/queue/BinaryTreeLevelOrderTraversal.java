package datastructure.queue;

import binarytree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    /**
     * 8/10/2018
     *
     * @param root: A Tree
     * @return: Level order a list of lists of integer
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> current = new LinkedList<>();
            for (int i = 1; i <= size; i++) {
                TreeNode next = queue.remove();
                current.add(next.val);

                if (next.left != null) {
                    queue.add(next.left);
                }

                if (next.right != null) {
                    queue.add(next.right);
                }
            }

            result.add(current);
        }

        return result;
    }
}
