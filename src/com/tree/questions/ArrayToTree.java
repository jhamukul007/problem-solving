package com.tree.questions;

import com.utils.TreeNode;

public class ArrayToTree {

    public TreeNode createTree(Integer[] arr) {
        TreeNode node = null;

        for (int i = 0; i < arr.length; i++) {
            Integer data = arr[i];
            if (node == null)
                node = new TreeNode(data);
            else {
                TreeNode current = node;
            }
        }
        return null;
    }

    boolean isLeft(int currIndex, Integer[] arr) {
        int leftIndex = (currIndex - 1);
        return true;
    }

    //left = 2*i+1;
    //right = 2*i+2;
    // Tree with duplicate value

    public static void main(String[] args) {
        Integer[] arr = {1, null, 2, null, null, 6, 7};

    }
}
