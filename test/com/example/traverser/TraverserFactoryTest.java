package com.example.traverser;

import org.junit.Test;
import org.mockito.InOrder;

import static org.junit.Assert.*;

public class TraverserFactoryTest {

    @Test
    public void testPreOrderTraverserIsReturned() throws Exception {
        assertTrue(TraverserFactory.preorder() instanceof PreOrderTraverser);
    }

    @Test
    public void testPostOrderTraverserIsReturned() throws Exception {
        assertTrue(TraverserFactory.postOrder() instanceof PostOrderTraverser);
    }

    @Test
    public void testInOrderTraverserIsReturned() throws Exception {
        assertTrue(TraverserFactory.inOrder() instanceof InOrderTraverser);
    }
}