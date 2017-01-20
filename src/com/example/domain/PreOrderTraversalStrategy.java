package com.example.domain;

import com.example.support.Constants;
import com.example.support.LogFactory;

import java.util.logging.Level;

public class PreOrderTraversalStrategy<T extends Comparable> extends TraversalStrategy<T> implements Constants.LogMessages {

    @Override
    public void visit(final T value, final TreeNode<T> leftNode, final TreeNode<T> rightNode) {
        LogFactory.getLoggerInstance().log(Level.INFO, String.format(INFO_PRE_ORDER_SCANNING, value));
        this.values.add(value);
        if (leftNode != null) leftNode.traverse(this);
        if (rightNode != null) rightNode.traverse(this);
    }

}
