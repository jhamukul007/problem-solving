package com.tree.questions;

import com.utils.TreeNode;

public class BSTCheck {
    /**
     * * Recursion
     * * Time: 0(n)
     * * Space: O(n) -> Stack + O(1) = O(n)
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        TreeNode[] last = new TreeNode[1];
        return isBST(root, last);
    }

    public boolean isBST(TreeNode treeNode, TreeNode[] last) {
        if(treeNode == null)
            return true;

        boolean left = isBST(treeNode.left, last);
        if(last[0] != null){
            if(last[0].val >= treeNode.val)
                return false;
        }

        last[0] = treeNode;
        boolean right = isBST(treeNode.right, last);

        return left && right;
    }

    /**
     * * Recursion
     * * Time: 0(n)
     * * Space: O(n) -> Stack
     * @param root
     * @return
     */

    TreeNode last;
    public boolean isBST1(TreeNode treeNode) {
        return isBST1Rec(treeNode);
    }

    public boolean isBST1Rec(TreeNode treeNode) {
        if(treeNode == null)
            return true;

        boolean left = isBST1Rec(treeNode.left);
        if(last != null){
            if(last.val >= treeNode.val)
                return false;
        }
        last = treeNode;
        boolean right = isBST1Rec(treeNode.right);
        return left && right;
    }

    public static void main(String[] args) {
        BSTCheck obj = new BSTCheck();

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(15);
        root.right = new TreeNode(12);
        root.right.right = new TreeNode(16);
        root.right.left = new TreeNode(9);

        TreeNode root1= new TreeNode(5);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(4);
        root1.right.left = new TreeNode(3);
        root1.right.right = new TreeNode(6);

        TreeNode root2= new TreeNode(5);
        root2.left = new TreeNode(5);

        System.out.println(obj.isBST1(root2));
    }

}
