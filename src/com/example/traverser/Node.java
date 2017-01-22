package com.example.traverser;

public class Node<T extends Comparable> implements Comparable<Node<T>> {

    private Node<T> right;
    private Node<T> left;
    private T data;

    public Node(T value) {
        this.data = value;
    }

    public void insert(Node<T> newNode) {
        if (this.compareTo(newNode) < 0) inRightSubtree(newNode);
        else inLeftSubTree(newNode);
    }

    private void inLeftSubTree(Node<T> newNode) {
        if (this.left == null) this.left = newNode;
        else this.left.insert(newNode);
    }

    private void inRightSubtree(Node<T> newNode) {
        if (this.right == null) this.right = newNode;
        else this.right.insert(newNode);
    }

    Node<T> getLeft() {
        return left;
    }

    @Override
    public String toString() {
        return this.data.toString();
    }

    Node<T> getRight() {
        return right;
    }

    public T getData() {
        return data;
    }

    @Override
    public int compareTo(Node<T> o) {
        return (this.data).compareTo(o.data);
    }
}
