package com.example.domain;

public class PreOrderTraversalStrategy<T extends Comparable> extends TraversalStrategy<T> {

    @Override
    public void visit(T value, TreeNode<T> leftNode, TreeNode<T> rightNode) {
        this.values.add(value);
        if (leftNode != null) leftNode.traverse(this);
        if (rightNode != null) rightNode.traverse(this);
    }

}
