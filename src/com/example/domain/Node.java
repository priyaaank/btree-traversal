package com.example.domain;

public class Node<T extends Comparable> {

    private Node<T> right;
    private Node<T> left;
    private T data;

    public void insert(T value) {
        if (this.data == null) this.data = value;
        else insertInSubtree(value);
    }

    private void insertInSubtree(T value) {
        if (value.compareTo(this.data) > 0) inRightSubtree(value);
        else inLeftSubtree(value);
    }

    private void inLeftSubtree(T value) {
        if (left == null) left = new Node<>();
        left.insert(value);
    }

    private void inRightSubtree(T value) {
        if (right == null) right = new Node<>();
        right.insert(value);
    }

    boolean isPopulated() {
        return this.data != null;
    }

    Node<T> getLeft() {
        return left;
    }

    Node<T> getRight() {
        return right;
    }

    public T getData() {
        return data;
    }
}
