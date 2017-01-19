package com.example.domain;

public class InOrderTraversalStrategy<T extends Comparable> extends TraversalStrategy<T> {

    @Override
    public void visit(T value, TreeNode<T> leftNode, TreeNode<T> rightNode) {
        if (leftNode != null) leftNode.traverse(this);
        this.values.add(value);
        if (rightNode != null) rightNode.traverse(this);
    }

}
