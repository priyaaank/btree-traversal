package com.example.domain;

import com.example.support.Constants;
import com.example.support.LogFactory;

import java.util.logging.Level;

public class TreeNode<T extends Comparable> implements Constants.LogMessages {

    private T value;
    private TreeNode<T> right;
    private TreeNode<T> left;

    public TreeNode(final T value) {
        this.value = value;
    }

    public void insert(final T value) {
        LogFactory.getLoggerInstance().log(Level.INFO, String.format(INFO_INSERTING_INTO_TREE, value));
        TreeNode<T> newTreeNode = new TreeNode<>(value);
        if (value.compareTo(this.value) > 0) addToRight(value, newTreeNode);
        else addToLeft(value, newTreeNode);
    }

    private void addToLeft(final T value, final TreeNode<T> newTreeNode) {
        if (this.left == null) this.left = newTreeNode;
        else this.left.insert(value);
    }

    private void addToRight(final T value, final TreeNode<T> newTreeNode) {
        if (this.right == null) this.right = newTreeNode;
        else this.right.insert(value);
    }

    public void traverse(final TraversalStrategy<T> preOrderTraversalStrategy) {
        preOrderTraversalStrategy.visit(this.value, this.left, this.right);
    }

    @Override
    public String toString() {
        return String.format("[Value] %s", this.value);
    }

}
