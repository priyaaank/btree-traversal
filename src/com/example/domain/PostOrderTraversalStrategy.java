package com.example.domain;

public class PostOrderTraversalStrategy<T extends Comparable> extends TraversalStrategy<T> {

    @Override
    public void visit(T value, TreeNode<T> leftNode, TreeNode<T> rightNode) {
        if (leftNode != null) leftNode.traverse(this);
        if (rightNode != null) rightNode.traverse(this);
        this.values.add(value);
    }

}
