package gameday;

import util.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 2/22/2019
 * GameDay
 *
 * https://www.lintcode.com/problem/serialize-and-deserialize-binary-tree/description
 */
public class SerializeandDeserializeBinaryTree {
    /**
     * This method will be invoked first, you should design your own algorithm
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        Stack<String> stack = new Stack<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.remove();
            if (current == null) {
                stack.push("#");
            } else {
                stack.push("" + current.val);
                queue.add(current.left);
                queue.add(current.right);
            }
        }

        while (stack.peek().equals("#")) {
            stack.pop();
        }

        return stack.toString();
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        if (data == "") {
            return null;
        }

        String[] input = data.substring(1, data.length() - 1).split(", ");

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = toTreeNode(input[0]);
        queue.add(root);

        for (int i = 1; i <= input.length - 1;) {
            TreeNode current = queue.remove();

            TreeNode left = toTreeNode(input[i++]);
            if (left != null) {
                current.left = left;
                queue.add(left);
            }

            if (i <= input.length - 1) {
                TreeNode right = toTreeNode(input[i++]);
                if (right != null) {
                    current.right = right;
                    queue.add(right);
                }
            }
        }

        return root;
    }

    private TreeNode toTreeNode(String val) {
        if (val.equals("#")) {
            return null;
        } else {
            return new TreeNode(Integer.valueOf(val));
        }
    }


    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);

        node3.left = node9;
        node3.right = node20;
        node20.left = node15;
        node20.right = node7;

        String serialization = new SerializeandDeserializeBinaryTree().serialize(node3);
        System.out.println(serialization);
        TreeNode deserialization = new SerializeandDeserializeBinaryTree().deserialize(serialization);

    }
}
