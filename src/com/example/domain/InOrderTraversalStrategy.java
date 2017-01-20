package com.example.domain;

import com.example.support.Constants;
import com.example.support.LogFactory;

import java.util.logging.Level;

public class InOrderTraversalStrategy<T extends Comparable> extends TraversalStrategy<T> implements Constants.LogMessages {

    @Override
    public void visit(final T value, final TreeNode<T> leftNode, final TreeNode<T> rightNode) {
        if (leftNode != null) leftNode.traverse(this);
        LogFactory.getLoggerInstance().log(Level.INFO, String.format(INFO_INORDER_SCANNING, value));
        this.values.add(value);
        if (rightNode != null) rightNode.traverse(this);
    }

}
