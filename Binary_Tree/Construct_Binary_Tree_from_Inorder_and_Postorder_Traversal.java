// https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/

package Binary_Tree;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;

public class Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {this.val = val;}
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static void display(TreeNode node){
        if (node == null) return;

        String str = (node.left == null ? "." : node.left.val + "") +
                "->" + node.val + "<-" +
                (node.right == null ? "." : node.right.val + "");

        System.out.println(str);

        display(node.left);
        display(node.right);
    }
    /*
    isi - inOrder Starting Index
    iei - inOrder Ending Index
    psi - postOrder Starting Index
    pei - postOrder Ending Index
    tnel - totalNoOfElements
     */
    public static @Nullable TreeNode buildTree(int[] inorder, int[] postorder, int isi, int iei, int psi, int pei){
        if (isi > iei) return null;

        TreeNode node = new TreeNode(postorder[pei]);
        int index = isi;
        while (inorder[index] != postorder[pei]) index++;

        node.left = buildTree(inorder, postorder, isi, index - 1, psi, psi + index - isi - 1);
        node.right = buildTree(inorder, postorder, index + 1, iei, psi + index - isi, pei - 1);
        return node;
    }
    public static TreeNode buildTree(int @NotNull [] inorder, int[] postorder) {
        int n = inorder.length;
        return buildTree(inorder, postorder, 0, n - 1, 0 , n - 1);
    }

    private static @Nullable TreeNode buildTreeMain(int[] inorder, int[] postorder, int isi, int iei, int psi, int pei, HashMap<Integer,Integer> map){
        if (psi > pei) return null;

        TreeNode root = new TreeNode(postorder[pei]);
        int index = map.get(postorder[pei]);

        root.left = buildTreeMain(inorder, postorder, isi, index - 1, psi, psi + index - isi - 1, map);
        root.right  = buildTreeMain(inorder, postorder, index + 1, iei, psi + index - isi, pei - 1,  map);
        return root;

    }
    public static TreeNode buildTreeWrap(int @NotNull [] inorder, int[] postorder) {
        int len = inorder.length;
        HashMap<Integer, Integer> map = new HashMap<>(len);
        for (int i = 0 ; i < len; i++)
            map.put(inorder[i], i);
        return buildTreeMain(inorder, postorder,  0, len - 1, 0, len - 1, map);
    }

    public static void main(String[] args){
        int[] postorder = {7,8,3,9,10,4,1,11,5,6,2,0};
        int[] inorder = {7,3,8,1,9,4,10,0,11,5,2,6};
        TreeNode obj = buildTree(inorder, postorder);
        TreeNode obj2 = buildTreeWrap(inorder, postorder);
        display(obj);
    }
}
