package com.example.traverser;

public class PreOrderTraverser<T extends Comparable> implements Traverser<T> {

    @Override
    public void traverse(Node<T> node, Visit<Node<T>> visitCallback) {
        visitCallback.visited(node);
        if (node.getLeft() != null) traverse(node.getLeft(), visitCallback);
        if (node.getRight() != null) traverse(node.getRight(), visitCallback);
    }

}
