package com.tree.questions;

import com.utils.TreeNode;

public class InOrderTree {

    public static void inOrder(TreeNode root) {
        if (root == null)
            return;
        inOrder(root.left);
        System.out.println(root.val + "  ");
        inOrder(root.right);
    }
}
