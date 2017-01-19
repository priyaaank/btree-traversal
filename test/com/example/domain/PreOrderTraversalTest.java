package com.example.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class PreOrderTraversalTest {

    private TreeNode<Integer> rootNode;
    private PreOrderTraversalStrategy<Integer> preOrderTraversalStrategy;

    @Before
    public void setUp() throws Exception {
        this.preOrderTraversalStrategy = new PreOrderTraversalStrategy<>();
        this.rootNode = new TreeNode<>(100);
        this.rootNode.insert(150);
        this.rootNode.insert(50);
        this.rootNode.insert(20);
        this.rootNode.insert(200);
    }

    @Test
    public void testPreOrderTraversalPrintsBottomLeftNodeValueFirst() throws Exception {
        this.rootNode.traverse(this.preOrderTraversalStrategy);
        List values = this.preOrderTraversalStrategy.traversalOutput();

        assertEquals(20, values.get(0));
    }

    @Test
    public void testLastDigitIsBottomRightElementOfTree() throws Exception {
        this.rootNode.traverse(this.preOrderTraversalStrategy);
        List values = this.preOrderTraversalStrategy.traversalOutput();

        assertEquals(200, values.get(values.size()-1));
    }

    @Test
    public void testAllValuesAreRetrieved() throws Exception {
        this.rootNode.traverse(this.preOrderTraversalStrategy);
        List values = this.preOrderTraversalStrategy.traversalOutput();

        assertEquals(5, values.size());
    }
}