package com.example.domain;

public class TreeNode<T extends Comparable> {

    private T value;
    private TreeNode<T> right;
    private TreeNode<T> left;

    public TreeNode(final T value) {
        this.value = value;
    }

    public void insert(T value) {
        TreeNode<T> newTreeNode = new TreeNode<>(value);
        if (value.compareTo(this.value) > 0) {
            if (this.right != null && this.right.isSet()) {
                this.right.insert(value);
            } else {
                this.right = newTreeNode;
            }
        } else {
            if (this.left != null && this.left.isSet()) {
                this.left.insert(value);
            } else {
                this.left = newTreeNode;
            }
        }
    }

    private boolean isSet() {
        return this.value != null;
    }

    public TreeNode<T> rightNode() {
        return right;
    }

    public TreeNode<T> leftNode() {
        return this.left;
    }

    public void traverse(TraversalStrategy<T> preOrderTraversalStrategy) {
        preOrderTraversalStrategy.visit(this.value, this.left, this.right);
    }

    @Override
    public String toString() {
        return String.format("[Value] %s", this.value);
    }

}
