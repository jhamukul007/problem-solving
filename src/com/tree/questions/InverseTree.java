package com.tree.questions;

import com.utils.TreeNode;
import com.utils.Utils;

/**
 * * https://leetcode.com/problems/invert-binary-tree/
 * * 226. Invert Binary Tree
 */
public class InverseTree {

    /**
     * @param treeNode
     * @return
     */
    public TreeNode inverseTree(TreeNode treeNode) {

        if (treeNode == null)
            return null;
        TreeNode left = inverseTree(treeNode.left);
        TreeNode right = inverseTree(treeNode.right);
        treeNode.left = right;
        treeNode.right = left;
        return treeNode;
    }

    public static void main(String[] args) {
        InverseTree obj = new InverseTree();

        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(-1);
        treeNode.right = new TreeNode(2);


        TreeNode invertedNode = obj.inverseTree(treeNode);
        System.out.println(invertedNode);
    }

}
