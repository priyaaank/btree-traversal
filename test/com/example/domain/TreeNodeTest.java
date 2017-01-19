package com.example.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TreeNodeTest {

    private TreeNode<String> rootNode;

    @Before
    public void setUp() throws Exception {
        rootNode = new TreeNode<>("Root value");
    }

    @Test
    public void testNodeStringRepresentationPrintsNodeValue() {
        assertEquals("[Value] Root value", rootNode.toString());
    }

    @Test
    public void testSmallerValueIsPushedAsLeftChild() {
        rootNode.insert("ALeftNode");

        assertEquals("[Value] ALeftNode", rootNode.leftNode().toString());
    }

    @Test
    public void testValueIsPushedToLeftSubtreeIfChildAlreadyOccupied() throws Exception {
        rootNode.insert("BLeftNode");
        rootNode.insert("ALeftNode");

        assertEquals("[Value] BLeftNode", rootNode.leftNode().toString());
        assertEquals("[Value] ALeftNode", rootNode.leftNode().leftNode().toString());
    }

    @Test
    public void testBiggerValueIsPushedAsRightChild() throws Exception {
        rootNode.insert("zRightNode");

        assertEquals("[Value] zRightNode", rootNode.rightNode().toString());
    }

    @Test
    public void testEqualValueIsPushedToLeftChild() throws Exception {
        rootNode.insert("Root value");

        assertEquals("[Value] Root value", rootNode.leftNode().toString());
    }

    @Test
    public void testNodeStringRepresentationPrintsNodeValueForNumericValues() {
        TreeNode<Integer> rootNode = new TreeNode<>(28);

        assertEquals("[Value] 28", rootNode.toString());
    }

}
