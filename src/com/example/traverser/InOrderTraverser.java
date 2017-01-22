package com.example.traverser;

public class InOrderTraverser<T extends Comparable> implements Traverser<T> {

    @Override
    public void traverse(Node<T> node, Visit<Node<T>> visitCallback) {
        if (node.getLeft() != null) traverse(node.getLeft(), visitCallback);
        visitCallback.visited(node);
        if (node.getRight() != null) traverse(node.getRight(), visitCallback);
    }

}
