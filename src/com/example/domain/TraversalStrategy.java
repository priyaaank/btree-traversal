package com.example.domain;

import java.util.ArrayList;
import java.util.List;

public abstract class TraversalStrategy<T extends Comparable> {

    protected List<T> values = new ArrayList<T>();

    public List<T> traversalOutput() {
        return values;
    }

    public abstract void visit(T value, TreeNode<T> leftNode, TreeNode<T> rightNode);

    @Override
    public String toString() {
        if (values == null || values.size() == 0) return "No values!";
        StringBuffer toStr = new StringBuffer();
        for (T val : values) toStr.append(val.toString()).append("-");
        int endIndex = toStr.length() >= 2 ? toStr.length() - 2 : 0;
        return toStr.substring(0, endIndex);
    }
}
