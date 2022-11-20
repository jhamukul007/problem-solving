package com.utils;

public class TreeUtils {
    public static void inOrder(TreeNode root) {
        System.out.print("[ ");
        inOrderRec(root);
        System.out.println("]");
    }

    static void inOrderRec(TreeNode root) {
        if (root == null)
            return;
        inOrderRec(root.left);
        System.out.print(root.val + ", ");
        inOrderRec(root.right);
    }
}
