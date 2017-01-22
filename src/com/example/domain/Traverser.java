package com.example.domain;

public interface Traverser<T extends Comparable> {

    void traverse(Node<T> node, Visit<Node<T>> successCallback);

    interface Visit<V extends Comparable> {

        void visited(V visitedNode);

    }

}
