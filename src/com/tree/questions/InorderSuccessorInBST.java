package com.tree.questions;

import com.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 285. Inorder Successor in BST
 * https://leetcode.com/problems/inorder-successor-in-bst/
 */
public class InorderSuccessorInBST {

    int index = -1;

    /**
     * Time Complexity: O(n)
     * Space: O(n): because of recursive stack
     *
     * @param root
     * @param p
     * @return
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        List<TreeNode> inOrderData = new ArrayList<>();
        inOrder(root, inOrderData, p);
        if (index > -1 && index < inOrderData.size() - 1)
            return inOrderData.get(index + 1);
        return null;
    }

    void inOrder(TreeNode root, List<TreeNode> inOrderData, TreeNode p) {
        if (root == null)
            return;
        inOrder(root.left, inOrderData, p);
        inOrderData.add(root);
        if (p == root)
            index = inOrderData.size() - 1;
        inOrder(root.right, inOrderData, p);
    }

    TreeNode closestNode = null;
    int minValue;

    public TreeNode inorderSuccessorSec(TreeNode root, TreeNode p) {
        minValue = Integer.MAX_VALUE;
        inOrder(root, p);
        return closestNode;
    }

    void inOrder(TreeNode root, TreeNode p) {
        if (root == null)
            return;
        inOrder(root.left, p);
        if (root.val > p.val) {
            if (root.val - p.val < minValue) {
                closestNode = root;
                minValue = root.val - p.val;
            }
        }
        inOrder(root.right, p);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        InorderSuccessorInBST obj = new InorderSuccessorInBST();
        System.out.println(obj.inorderSuccessorSec(root, root.left));
    }
}
