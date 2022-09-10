package com.tree.questions;

import com.utils.TreeNode;
import com.utils.Utils;

/**
 * https://leetcode.com/problems/invert-binary-tree/
 * 226. Invert Binary Tree
 */
public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        return mirrorImage(root);
    }

    public TreeNode mirrorImage(TreeNode root){
        if(root == null)
            return null;
        TreeNode left = mirrorImage(root.left);
        TreeNode right = mirrorImage(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    public static void main(String[] args) {
        InvertBinaryTree obj = new InvertBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        Utils.print(obj.invertTree(root));
    }
}

