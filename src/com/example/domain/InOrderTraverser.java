package com.example.domain;

public class InOrderTraverser<T extends Comparable> implements Traverser<T> {

    @Override
    public void traverse(Node<T> node, Visit<Node<T>> visitCallback) {
        traverseFromNode(node, visitCallback);
    }

    private void traverseFromNode(Node<T> node, Visit<Node<T>> visitCallback) {
        if (node.getLeft() != null) traverseFromNode(node.getLeft(), visitCallback);
        visitCallback.visited(node);
        if (node.getRight() != null) traverseFromNode(node.getRight(), visitCallback);
    }

}
