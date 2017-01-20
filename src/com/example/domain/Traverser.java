package com.example.domain;

import java.util.List;

public interface Traverser<T extends Comparable> {

    void traverse(Node<T> node, Callback<T> successCallback);

    interface Callback<T extends Comparable> {

        void traversalComplete(List<Node<T>> selectedNodes);

    }

}
