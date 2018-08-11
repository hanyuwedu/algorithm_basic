package binarytree;

import java.util.*;

/**
 * https://www.lintcode.com/problem/serialize-and-deserialize-binary-tree/description
 */
public class SerializeandDeserializeBinaryTree {
    /**
     * 6/2/2018
     *
     * This method will be invoked first, you should design your own algorithm
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        List<String> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.remove();
            if (current == null) {
                list.add("#");
            } else {
                queue.add(current.left);
                queue.add(current.right);
                list.add(String.valueOf(current.val));
            }
        }

        int i = list.size() - 1;
        while (i > 0) {
            if (list.get(i) == "#") {
                list.remove(i);
                i--;
            } else {
                break;
            }
        }

        return String.join(",", list);
    }

    /**
     * 6/2/2018
     *
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        if (data.length() == 0) {
            return null;
        }

        String[] input = data.split(",");

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = toTreeNode(input[0]);
        queue.add(root);
        int index = 0;

        while (!queue.isEmpty()) {
            TreeNode current = queue.remove();

            index++;
            if (index >= input.length) {
                break;
            }
            TreeNode left = toTreeNode(input[index]);
            if (left != null) {
                current.left = left;
                queue.add(left);
            }

            index++;
            if (index >= input.length) {
                break;
            }
            TreeNode right = toTreeNode(input[index]);
            if (right != null) {
                current.right = right;
                queue.add(right);
            }
        }

        return root;
    }

    private TreeNode toTreeNode(String str) {
        if (str.equals("#")) {
            return null;
        } else {
            return new TreeNode(Integer.parseInt(str));
        }
    }








    /**
     * 7/31/2018
     *
     * This method will be invoked first, you should design your own algorithm
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize2(TreeNode root) {
        if (root == null) {
            return "";
        }

        Queue<TreeNode> queue = new LinkedList<>();
        List<String> result = new ArrayList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode next = queue.remove();
            if (next == null) {
                result.add("#");
            } else {
                result.add(String.valueOf(next.val));
                queue.add(next.left);
                queue.add(next.right);
            }
        }

        /// Remove tail #s
        int length = result.size() - 1;
        for (int i = length; i >= 0; i--) {
            if (result.get(i).equals("#")) {
                result.remove(i);
            } else {
                break;
            }
        }

        return String.join(",", result);
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in
     * "serialize" method.
     */
    public TreeNode deserialize2(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }

        String[] input = data.split(",");
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        Queue<TreeNode> processing = new LinkedList<>();

        for (String str : input) {
            if (str.equals("#")) {
                treeNodeQueue.add(null);
            } else {
                treeNodeQueue.add(new TreeNode(Integer.valueOf(str)));
            }
        }

        TreeNode current = treeNodeQueue.remove();
        TreeNode root = current;

        while (!treeNodeQueue.isEmpty()) {
            if (!treeNodeQueue.isEmpty()) {
                TreeNode left = treeNodeQueue.remove();
                if (left != null) {
                    current.left = left;
                    processing.add(left);
                }
            }

            if (!treeNodeQueue.isEmpty()) {
                TreeNode right = treeNodeQueue.remove();
                if (right != null) {
                    current.right = right;
                    processing.add(right);
                }
            }

            if (!processing.isEmpty()) {
                current = processing.remove();
            }
        }

        return root;
    }
}
