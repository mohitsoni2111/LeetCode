// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

package Binary_Tree;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;

public class Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {

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
    public static @Nullable TreeNode buildTree(int[] preorder, int[] inorder, int psi, int pei, int isi, int iei){
        if (isi > iei) return null;

        TreeNode node = new TreeNode(preorder[psi]);
        int index = isi;
        while (inorder[index] != preorder[psi]) index++;

        node.left = buildTree(preorder, inorder, psi + 1, psi + index - isi, isi, index - 1);
        node.right = buildTree(preorder, inorder, psi + index - isi + 1, pei, index + 1, iei);
        return node;
    }
    public static TreeNode buildTree(int @NotNull [] preorder, int[] inorder) {
        int n = preorder.length;
        return buildTree(preorder, inorder, 0, n -1, 0, n - 1);
    }


    private static @Nullable TreeNode buildTreeMain(int[] preorder, int[] inorder, int psi, int pei, int isi, int iei, HashMap<Integer,Integer> map) {
        if (psi > pei) return null;

        TreeNode root = new TreeNode(preorder[psi]);
        int index = map.get(preorder[psi]);

        root.left = buildTreeMain(preorder, inorder, psi + 1, psi + index - isi, isi, index - 1, map);
        root.right  = buildTreeMain(preorder, inorder, psi + index - isi + 1, pei, index + 1, iei, map);
        return root;
    }
    private static TreeNode buildTreeWrap(int @NotNull [] preorder, int[] inorder) {
        int len = preorder.length;
        HashMap<Integer,Integer> map = new HashMap<>(len);
        for(int i = 0; i < len; i++)
            map.put(inorder[i], i);
        return buildTreeMain(preorder, inorder, 0, len - 1, 0, len - 1, map);
    }

    public static void main(String[] args){
        int[] preorder = {0,1,3,7,8,4,9,10,2,5,11,6};
        int[] inorder = {7,3,8,1,9,4,10,0,11,5,2,6};
        TreeNode obj = buildTree(preorder, inorder);
        TreeNode obj2 = buildTreeWrap(preorder, inorder);
        display(obj);
    }
}
