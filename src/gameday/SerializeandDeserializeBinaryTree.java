package gameday;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://www.lintcode.com/problem/serialize-and-deserialize-binary-tree/description
 */
public class SerializeandDeserializeBinaryTree {
    /**
     * 11/24
     *
     * Update:
     * 将ArrayList减去末端"#", 以及序列化成String的工作应该单独抽离
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
            TreeNode next = queue.remove();
            if (next == null) {
                list.add("#");
            } else {
                list.add(String.valueOf(next.val));
                queue.add(next.left);
                queue.add(next.right);
            }
        }

        return serializeString(list);
    }

    private String serializeString(List<String> list) {
        int end = list.size() - 1;
        while (list.get(end).equals("#")) {
            end--;
        }

        return String.join(",", list.subList(0, end + 1));
    }

    /**
     * 11/24
     *
     * Update:
     * 这种改变输入格式的方法应该使用polymorphism
     *
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }

        return deserialize(data.split(","));
    }

    private TreeNode deserialize(String[] data) {
        if (data == null || data.length == 0) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = getNode(data[0]);
        queue.add(root);
        int pointer = 1;

        while (!queue.isEmpty()) {
            TreeNode current = queue.remove();
            if (pointer < data.length) {
                TreeNode left = getNode(data[pointer++]);
                if (left != null) {
                    current.left = left;
                    queue.add(left);
                }
            }

            if (pointer < data.length) {
                TreeNode right = getNode(data[pointer++]);
                if (right != null) {
                    current.right = right;
                    queue.add(right);
                }
            }
        }

        return root;
    }

    private TreeNode getNode(String str) {
        if (str.equals("#")) {
            return null;
        } else {
            return new TreeNode(Integer.parseInt(str));
        }
    }



    /**
     * 6/2/2018
     *
     * This method will be invoked first, you should design your own algorithm
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize2(TreeNode root) {
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
    public TreeNode deserialize2(String data) {
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
}
