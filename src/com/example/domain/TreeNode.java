package com.example.domain;

public class TreeNode<T extends Comparable> {

    private T value;
    private TreeNode<T> right;
    private TreeNode<T> left;

    public TreeNode(final T value) {
        this.value = value;
    }

    public void insert(final T value) {
        TreeNode<T> newTreeNode = new TreeNode<>(value);
        if(value.compareTo(this.value) > 0) addToRight(value, newTreeNode);
        else addToLeft(value, newTreeNode);
    }

    private void addToLeft(final T value, final TreeNode<T> newTreeNode) {
        if (this.left == null) this.left = newTreeNode;
        else this.left.insert(value);
    }

    private void addToRight(final T value, final TreeNode<T> newTreeNode) {
        if(this.right == null) this.right = newTreeNode;
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
