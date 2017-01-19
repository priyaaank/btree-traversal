package com.example.domain;

import java.util.ArrayList;
import java.util.List;

public abstract class TraversalStrategy<T extends Comparable> {

    protected List<T> values = new ArrayList<T>();

    public List<T> traversalOutput() {
        return values;
    }

    public abstract void visit(T value, TreeNode<T> leftNode, TreeNode<T> rightNode);

}
