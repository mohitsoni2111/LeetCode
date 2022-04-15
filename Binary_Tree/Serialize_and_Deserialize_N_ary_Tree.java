package Binary_Tree;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Serialize_and_Deserialize_N_ary_Tree {
    public static Scanner scn = new Scanner(System.in);
    static class TreeNode {
        public int val;
        public ArrayList<TreeNode> children;
        public TreeNode() {
            children = new ArrayList<>();
        }
        public TreeNode(int val) {
            this.val = val;
            children = new ArrayList<>();
        }
        public TreeNode(int _val, ArrayList<TreeNode> children) {
            this.val = _val;
            this.children = children;
        }
    }


    static StringBuilder sb = new StringBuilder();
    static void preorderTraversal(TreeNode root){
        if (root == null) {
            sb.append("null ");
            return;
        }
        sb.append(root.val).append(",");
        for (TreeNode child : root.children)
            preorderTraversal(child);

        sb.append("null ");
    }

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if (root == null) return "";

        preorderTraversal(root);
        return sb.toString();
    }


    static TreeNode prebuild(String[] arr){
        if (arr.length == 0) return null;

        LinkedList<TreeNode> stack = new LinkedList<>();
        for (int i = 0; i < arr.length - 1; i++){
            String s = arr[i];
            if (s.equals("null")){
                TreeNode node = stack.removeFirst();
                stack.getFirst().children.add(node);
            }
            else {
                TreeNode node = new TreeNode(Integer.parseInt(s));
                stack.addFirst(node);
            }
        }
        return stack.removeFirst();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        String[] arr = data.split(" ");
        return prebuild(arr);
    }

    // input_Section=================================================
    public static void display(TreeNode node) {
        if (node == null)
            return;

        StringBuilder sb = new StringBuilder();
        sb.append(node.val).append(" -> ");
        for (TreeNode child : node.children) {
            sb.append(child.val).append(" ");
        }
        System.out.println(sb.toString());

        for (TreeNode child : node.children) {
            display(child);
        }
    }
    public static TreeNode createTree(String[] arr) {
        Stack<TreeNode> st = new Stack<>();
        for (int i = 0; i < arr.length - 1; i++) {
            String s = arr[i];
            if (s.equals("null")) {
                TreeNode node = st.pop();
                st.peek().children.add(node);
            } else {
                TreeNode node = new TreeNode(Integer.parseInt(s));
                st.push(node);
            }
        }
        return st.size() != 0 ? st.pop() : null;
    }
    public static void solve() {
        String str = scn.nextLine();
        String[] arr = str.split(" ");

        TreeNode root = createTree(arr);
        String s = serialize(root);
        display(deserialize(s));
    }
    public static void main(String[] args) {
        solve();
    }
}
