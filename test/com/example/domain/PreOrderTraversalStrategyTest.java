package com.example.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class PreOrderTraversalStrategyTest {

    /*
                             100
                            /   \
                           /     \
                          50      150
                         / \      / \
                        /   \    /   \
                       20   60  145  160

       Expected Output: 100 - 50 - 20 - 60 - 150 - 145 - 160

     */

    private TreeNode<Integer> rootNode;
    private PreOrderTraversalStrategy<Integer> preOrderTraversalStrategy;

    @Before
    public void setUp() throws Exception {
        this.preOrderTraversalStrategy = new PreOrderTraversalStrategy<>();
        this.rootNode = new TreeNode<>(100);
        this.rootNode.insert(50);
        this.rootNode.insert(150);
        this.rootNode.insert(20);
        this.rootNode.insert(60);
        this.rootNode.insert(145);
        this.rootNode.insert(160);
    }

    @Test
    public void testPreOrderTraversalPrintsRootNodeValueFirst() throws Exception {
        this.rootNode.traverse(this.preOrderTraversalStrategy);
        List values = this.preOrderTraversalStrategy.traversalOutput();

        assertEquals(100, values.get(0));
    }

    @Test
    public void testLastDigitIsBottomRightElementOfTree() throws Exception {
        this.rootNode.traverse(this.preOrderTraversalStrategy);
        List values = this.preOrderTraversalStrategy.traversalOutput();

        assertEquals(160, values.get(values.size()-1));
    }

    @Test
    public void testAllValuesAreRetrieved() throws Exception {
        this.rootNode.traverse(this.preOrderTraversalStrategy);
        List values = this.preOrderTraversalStrategy.traversalOutput();

        assertEquals(7, values.size());
    }

    @Test
    public void testTheOutputSequenceOfAllValues() throws Exception {
        this.rootNode.traverse(this.preOrderTraversalStrategy);
        List<Integer> values = this.preOrderTraversalStrategy.traversalOutput();

        assertEquals("100-50-20-60-150-145-160", this.preOrderTraversalStrategy.toString());
    }
}