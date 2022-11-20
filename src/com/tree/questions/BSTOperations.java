package com.tree.questions;

import com.utils.TreeNode;
import com.utils.TreeUtils;
import org.w3c.dom.Node;

/**
 * * Without duplicates
 */
public class BSTOperations {
    private TreeNode root;

    // Add node into BST
    public TreeNode addNode(int data) {
        if (root == null)
            return root = new TreeNode(data);
        TreeNode cur = root;
        return insertRecursive(cur, data);
    }

    TreeNode insertRecursive(TreeNode root, int data) {
        if (root == null)
            return new TreeNode(data);
        if (data > root.val)
            root.right = insertRecursive(root.right, data);
        else
            root.left = insertRecursive(root.left, data);
        return root;
    }


    void insertNode(int data) {
        if (root == null) {
            root = new TreeNode(data);
            return;
        }
        TreeNode current = root;
        TreeNode prev = null;
        while (current != null) {
            prev = current;
            if (data > current.val)
                current = current.right;
            else
                current = current.left;
        }

        if (data > prev.val)
            prev.right = new TreeNode(data);
        else
            prev.left = new TreeNode(data);
    }

    /**
     * * log(n)
     * @param data
     * @return
     */
    boolean isExist(int data){
        TreeNode current = root;
        while(current != null){
            if(current.val == data)
                return true;
            if(data > current.val)
                current = current.right;
            else
                current = current.left;
        }

        return false;
    }

    public void delete(int data){

    }

    public int inorderPrex`

    public static void main(String[] args) {
        BSTOperations bstOperations = new BSTOperations();
//        bstOperations.insertNode(10);
//        bstOperations.insertNode(5);
//        bstOperations.insertNode(15);
//        bstOperations.insertNode(6);
//        bstOperations.insertNode(3);
//        bstOperations.insertNode(14);
//        bstOperations.insertNode(2);
//        bstOperations.insertNode(9);
//        TreeUtils.inOrder(bstOperations.root);
        bstOperations.addNode(10);
        bstOperations.addNode(5);
        bstOperations.addNode(15);
        bstOperations.addNode(6);
        bstOperations.addNode(3);
        bstOperations.addNode(14);
        bstOperations.addNode(2);
        bstOperations.addNode(9);
        TreeUtils.inOrder(bstOperations.root);
        System.out.println(bstOperations.isExist(3));
    }


}
