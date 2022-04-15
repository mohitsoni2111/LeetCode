// https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
package Binary_Tree;

import java.util.Scanner;

public class Serialize_and_Deserialize_Binary_Tree {
    public static Scanner scn = new Scanner(System.in);
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
    public static void display(TreeNode node) {
        if (node == null)
            return;

        StringBuilder sb = new StringBuilder();
        sb.append((node.left != null ? node.left.val : "."));
        sb.append(" -> " + node.val + " <- ");
        sb.append((node.right != null ? node.right.val : "."));

        System.out.println(sb.toString());

        display(node.left);
        display(node.right);

    }

    static StringBuilder sb = new StringBuilder();
    static void preorderTraversal(TreeNode root){
        if (root == null) {
            sb.append("null,");
            return;
        }
        sb.append(root.val).append(",");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        preorderTraversal(root);
        return sb.toString();
    }

    static int index = 0;
    static TreeNode prebuild(String[] arr){
        if (index > arr.length || arr[index].equals("null")) return null;

        TreeNode node = new TreeNode(Integer.parseInt(arr[index]));
        index++;
        node.left = prebuild(arr);
        index++;
        node.right = prebuild(arr);
        return node;
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        return prebuild(arr);
    }

    // input_section=================================================
    public static TreeNode createTree(int[] arr, int[] IDX) {
        if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
            IDX[0]++;
            return null;
        }
        TreeNode node = new TreeNode(arr[IDX[0]++]);
        node.left = createTree(arr, IDX);
        node.right = createTree(arr, IDX);

        return node;
    }
    public static void solve() {
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        int[] IDX = new int[1];
        TreeNode root = createTree(arr, IDX);

        String s = serialize(root);
        display(deserialize(s));
    }
    public static void main(String[] args) {
        solve();
    }
}
