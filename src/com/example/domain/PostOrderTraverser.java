package com.example.domain;

import java.util.ArrayList;
import java.util.List;

public class PostOrderTraverser<T extends Comparable> implements Traverser<T> {

    @Override
    public void traverse(Node<T> node, Callback<T> successCallback) {
        List<Node<T>> selectedNodes = new ArrayList<>();
        traverseFromNode(node, selectedNodes);
        successCallback.traversalComplete(selectedNodes);
    }

    private void traverseFromNode(Node<T> node, List<Node<T>> selectedNodes) {
        if (node.getLeft() != null) traverseFromNode(node.getLeft(), selectedNodes);
        if (node.getRight() != null) traverseFromNode(node.getRight(), selectedNodes);
        if (node.isPopulated()) selectedNodes.add(node);
    }

}
