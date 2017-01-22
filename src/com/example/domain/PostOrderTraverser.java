package com.example.domain;

public class PostOrderTraverser<T extends Comparable> implements Traverser<T> {

    @Override
    public void traverse(Node<T> node, Visit<Node<T>> visitCallback) {
        if (node.getLeft() != null) traverse(node.getLeft(), visitCallback);
        if (node.getRight() != null) traverse(node.getRight(), visitCallback);
        visitCallback.visited(node);
    }

}
