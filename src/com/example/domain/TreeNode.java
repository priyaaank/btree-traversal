package com.example.domain;

public class TreeNode<T> {

    private T value;
    private TreeNode<T> right;
    private TreeNode<T> left;

    public TreeNode(final T value) {
        this.value = value;
    }

    public void setRight(final TreeNode<T> right) {
        this.right = right;
    }

    public void setLeft(final TreeNode<T> left) {
        this.left = left;
    }

    public TreeNode<T> rightNode() {
        return right;
    }

    public TreeNode<T> leftNode() {
        return this.left;
    }

    @Override
    public String toString() {
        return String.format("[Value] %s", this.value);
    }
}
