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
    public void testNodeStringRepresentationPrintsNodeValueForNumericValues() {
        TreeNode<Integer> rootNode = new TreeNode<>(28);

        assertEquals("[Value] 28", rootNode.toString());
    }

    @Test
    public void testRightNodeCanBeRetrieved() throws Exception {
        TreeNode<String> rightNode = new TreeNode<>("Right node");
        rootNode.setRight(rightNode);

        assertEquals(rightNode, rootNode.rightNode());
    }

    @Test
    public void testThatLeftNodeCanBeRetrieved() throws Exception {
        TreeNode<String> leftNode = new TreeNode<>("Right node");
        rootNode.setLeft(leftNode);

        assertEquals(leftNode, rootNode.leftNode());
    }
}
