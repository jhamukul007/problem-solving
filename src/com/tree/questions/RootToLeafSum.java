package com.tree.questions;


import com.utils.TreeNode;

public class RootToLeafSum {
    boolean isFound = false;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        rootToLeaf(root, 0, targetSum);
        return isFound;
    }

    void rootToLeaf(TreeNode root, int totalSum, int targetSum) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            if (totalSum + root.val == targetSum) {
                isFound = true;
                return;
            }
        }
        totalSum += root.val;
        rootToLeaf(root.left, totalSum, targetSum);
        rootToLeaf(root.right, totalSum, targetSum);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);
        RootToLeafSum obj = new RootToLeafSum();
        System.out.println(obj.hasPathSum(root, 22));
    }
}
