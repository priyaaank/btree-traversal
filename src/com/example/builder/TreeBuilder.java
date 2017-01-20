package com.example.builder;

import com.example.domain.Node;
import com.example.domain.Traverser;

import java.util.List;

public interface TreeBuilder<T extends Comparable> {

    List<T> obtainInput();

    Traverser<T> selectTraversalType();

    void buildAndTraverse(List<T> values, Traverser<T> traversalStrategy);

    void processResult(List<Node<T>> nodes);

}
