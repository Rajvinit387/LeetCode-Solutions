package com.Leetcode.leetcodeSolutions.Model;

import java.util.Stack;

public class BSTIterator {
    Stack<TreeNode> treeNodeStack = new Stack<>();

    public BSTIterator(TreeNode root) {
        TreeNode t = root;
        while (t != null) {
            treeNodeStack.push(t);
            t = t.left;

        }

    }

    public int next() {

        TreeNode requiredNode = treeNodeStack.pop();
        if (requiredNode.right != null)
            insertRight(requiredNode.right);
        return requiredNode.data;

    }

    private void insertRight(TreeNode right) {

        while (right != null) {
            treeNodeStack.push(right);
            right = right.left;

        }
    }

    public boolean hasNext() {
        return !treeNodeStack.isEmpty();

    }
}
