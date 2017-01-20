package com.example.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class InOrderTraversalStrategyTest {

        /*
                             100
                            /   \
                           /     \
                          50      150
                         / \      / \
                        /   \    /   \
                       20   60  145  160

       Expected Output: 20 - 50 - 60 - 100 - 145 - 150 - 160

     */

    private TreeNode<Integer> rootNode;
    private InOrderTraversalStrategy<Integer> inOrderTraversalStrategy;

    @Before
    public void setUp() throws Exception {
        this.inOrderTraversalStrategy = new InOrderTraversalStrategy<>();
        this.rootNode = new TreeNode<>(100);
        this.rootNode.insert(50);
        this.rootNode.insert(150);
        this.rootNode.insert(20);
        this.rootNode.insert(60);
        this.rootNode.insert(145);
        this.rootNode.insert(160);
    }

    @Test
    public void testInOrderTraversalPrintsBottomLeftNodeValueFirst() throws Exception {
        this.rootNode.traverse(this.inOrderTraversalStrategy);
        List values = this.inOrderTraversalStrategy.traversalOutput();

        assertEquals(20, values.get(0));
    }

    @Test
    public void testLastDigitIsRootNodeElementOfTree() throws Exception {
        this.rootNode.traverse(this.inOrderTraversalStrategy);
        List values = this.inOrderTraversalStrategy.traversalOutput();

        assertEquals(160, values.get(values.size()-1));
    }

    @Test
    public void testAllValuesAreRetrieved() throws Exception {
        this.rootNode.traverse(this.inOrderTraversalStrategy);
        List values = this.inOrderTraversalStrategy.traversalOutput();

        assertEquals(7, values.size());
    }

    @Test
    public void testTheOutputSequenceOfAllValues() throws Exception {
        this.rootNode.traverse(this.inOrderTraversalStrategy);
        List<Integer> values = this.inOrderTraversalStrategy.traversalOutput();

        assertEquals("20-50-60-100-145-150-160", this.inOrderTraversalStrategy.toString());
    }
}
