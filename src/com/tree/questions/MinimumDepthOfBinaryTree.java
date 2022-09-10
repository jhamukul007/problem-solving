package com.tree.questions;

import com.utils.TreeNode;

/**
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 * 111. Minimum Depth of Binary Tree
 */
public class MinimumDepthOfBinaryTree {
    /**
     * DFS
     * Time : O(n)
     * Space: O(n)
     */
    int minDepth = Integer.MAX_VALUE;
    public int minDepthDFS(TreeNode root) {
        if(root == null )
            return 0;
        minDepth(root, 1);
        return minDepth;
    }

    private void minDepth(TreeNode root, int totalCount){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            minDepth = Math.min(minDepth, totalCount);
        }
        minDepth(root.left, totalCount+1);
        minDepth(root.right, totalCount+1);
    }
}
