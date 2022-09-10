package com.tree.questions;

import com.utils.TreeNode;

public class ClosetRootBST {

    double minDiff;
    int closestNode;

    public int closestValue(TreeNode root, double target) {
        minDiff = Integer.MAX_VALUE;
        closestValueU(root, target);
        return closestNode;
    }

    void closestValueU(TreeNode root, double target) {
        if (root == null)
            return;
        double diff = Math.abs(root.val - target);
        if (diff < minDiff) {
            minDiff = diff;
            closestNode = root.val;
        }
        if (target > root.val)
            closestValueU(root.right, target);
        if (target < root.val)
            closestValueU(root.left, target);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        ClosetRootBST obj = new ClosetRootBST();
        System.out.println(obj.closestValue(root, 3.714286));
    }

//    void search(TreeNode root, TreeNode node, String type){
//        if(root == null)
//            return;
//        if(root == node){
//            if("p".equals(type))
//            pFound = true;
//            else
//            qFound = true;
//            return;
//        }
//        search(root.left, node, type);
//        search(root.right, node, type);
//    }
}
