package com.example.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TreeNodeTest {

    private TreeNode<String> rootNode;
    private MockTraversal<String> traversalStrategy = new MockTraversal<>();

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
        rootNode.traverse(traversalStrategy);

        assertEquals("[Value] ALeftNode", traversalStrategy.leftNode.toString());
    }

    @Test
    public void testValueIsPushedToLeftSubtreeIfChildAlreadyOccupied() throws Exception {
        rootNode.insert("BLeftNode");
        rootNode.insert("ALeftNode");
        rootNode.traverse(traversalStrategy);
        String immediateLeftChild = traversalStrategy.leftNode.toString();
        traversalStrategy.leftNode.traverse(traversalStrategy);

        assertEquals("[Value] BLeftNode", immediateLeftChild);
        assertEquals("[Value] ALeftNode", traversalStrategy.leftNode.toString());
    }

    @Test
    public void testValueIsPushedToRightSubtreeIfChildAlreadyOccupied() throws Exception {
        rootNode.insert("yLeftNode");
        rootNode.insert("zLeftNode");
        rootNode.traverse(traversalStrategy);
        String immediateRightChild = traversalStrategy.rightNode.toString();
        traversalStrategy.rightNode.traverse(traversalStrategy);

        assertEquals("[Value] yLeftNode", immediateRightChild);
        assertEquals("[Value] zLeftNode", traversalStrategy.rightNode.toString());
    }

    @Test
    public void testBiggerValueIsPushedAsRightChild() throws Exception {
        rootNode.insert("zRightNode");
        rootNode.traverse(traversalStrategy);

        assertEquals("[Value] zRightNode", traversalStrategy.rightNode.toString());
    }

    @Test
    public void testEqualValueIsPushedToLeftChild() throws Exception {
        rootNode.insert("Root value");
        rootNode.traverse(traversalStrategy);

        assertEquals("[Value] Root value", traversalStrategy.leftNode.toString());
    }

    @Test
    public void testNodeStringRepresentationPrintsNodeValueForNumericValues() {
        TreeNode<Integer> rootNode = new TreeNode<>(28);

        assertEquals("[Value] 28", rootNode.toString());
    }

    @Test
    public void testTraversalVisitsTheCaller() throws Exception {
        rootNode.insert("rightValue");
        rootNode.traverse(traversalStrategy);

        assertEquals("Root value", traversalStrategy.value);
        assertEquals("[Value] rightValue", traversalStrategy.rightNode.toString());
        assertNull(traversalStrategy.leftNode);
    }

    class MockTraversal<T extends Comparable> extends TraversalStrategy<T> {

        public T value;
        public TreeNode<T> leftNode;
        public TreeNode<T> rightNode;

        @Override
        public void visit(T value, TreeNode<T> leftNode, TreeNode<T> rightNode) {
            this.value = value;
            this.leftNode = leftNode;
            this.rightNode = rightNode;
        }
    }
}
