// https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
package Binary_Tree;

import org.jetbrains.annotations.Nullable;

public class Construct_Binary_Tree_from_Preorder_Traversal {
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

    public static @Nullable TreeNode buildTree(int[] preorder, int start, int end){
        if(start > end) return null;

        TreeNode node = new TreeNode(preorder[start]);
        int index = 0;
        for(index = start; index <= end; index++){
            if(preorder[index] > node.val)
                break;
        }
        node.left = buildTree(preorder, start + 1, index - 1);
        node.right= buildTree(preorder, index, end);
        return node;
    }

    public static TreeNode bstFromPreorder(int[] preorder) {
        return buildTree(preorder, 0, preorder.length - 1);
    }

    public static void main(String[] args){
        int[] preorder = {0,1,3,7,8,4,9,10,2,5,11,6};
        TreeNode obj = bstFromPreorder(preorder);
        display(obj);
    }
}
