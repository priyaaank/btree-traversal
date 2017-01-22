package com.example.traverser;

public interface Traverser<T extends Comparable> {

    void traverse(Node<T> node, Visit<Node<T>> visitCallback);

    interface Visit<V extends Comparable> {

        void visited(V visitedNode);

    }

}
