package com.example.traverser;

public class TraverserFactory {

    public static <E extends Comparable> Traverser<E> preorder() {
        return new PreOrderTraverser<>();
    }

    public static <E extends Comparable> Traverser<E> postOrder() {
        return new PostOrderTraverser<>();
    }

    public static <E extends Comparable> Traverser<E> inOrder() {
        return new InOrderTraverser<>();
    }

}
