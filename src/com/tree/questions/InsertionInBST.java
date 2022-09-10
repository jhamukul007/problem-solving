package com.tree.questions;

import com.utils.TreeNode;

public class InsertionInBST {

    public TreeNode insert(TreeNode root, int data) {
        TreeNode current = root;
        if (current == null) {
            current = new TreeNode(data);
            return current;
        }
        if (data < current.val)
            current.left = insert(root.left, data);
        else
            current.right = insert(root.right, data);
        return root;
    }

    public TreeNode insertItr(TreeNode root, int data) {
        TreeNode cur = root;
        TreeNode last = null;
        while (cur != null) {
            last = cur;
            if (data < cur.val)
                cur = cur.left;
            else
                cur = cur.right;
        }
        if (last == null && cur == null) {
            cur = new TreeNode(data);
            return cur;
        } else if (data < last.val)
            last.left = new TreeNode(data);
        else if (data >= last.val)
            last.right = new TreeNode(data);

        return root;
    }

    public static void main(String[] args) {
//        InsertionInBST obj = new InsertionInBST();
//        TreeNode root = obj.insertItr(null, 10 );
//        obj.insertItr(root, 6 );
//        obj.insertItr(root, 8 );
//        obj.insertItr(root, 9 );
//        obj.insertItr(root, 12 );
//        InOrderTree.inOrder(root);
        System.out.println(1994 / 1000);
        int remaining = 1993 / 1000;
        System.out.println();
    }


}



