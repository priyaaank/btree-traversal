package com.example.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class PostOrderTraversalStrategyTest {


    /*
                             100
                            /   \
                           /     \
                          50      150
                         / \      / \
                        /   \    /   \
                       20   60  145  160

       Expected Output: 20 - 60 - 50 - 145 - 160 - 150 - 100

     */

    private TreeNode<Integer> rootNode;
    private PostOrderTraversalStrategy<Integer> postOrderTraversalStrategy;

    @Before
    public void setUp() throws Exception {
        this.postOrderTraversalStrategy = new PostOrderTraversalStrategy<>();
        this.rootNode = new TreeNode<>(100);
        this.rootNode.insert(50);
        this.rootNode.insert(150);
        this.rootNode.insert(20);
        this.rootNode.insert(60);
        this.rootNode.insert(145);
        this.rootNode.insert(160);
    }

    @Test
    public void testPostOrderTraversalPrintsBottomLeftNodeValueFirst() throws Exception {
        this.rootNode.traverse(this.postOrderTraversalStrategy);
        List values = this.postOrderTraversalStrategy.traversalOutput();

        assertEquals(20, values.get(0));
    }

    @Test
    public void testLastDigitIsRootNodeElementOfTree() throws Exception {
        this.rootNode.traverse(this.postOrderTraversalStrategy);
        List values = this.postOrderTraversalStrategy.traversalOutput();

        assertEquals(100, values.get(values.size()-1));
    }

    @Test
    public void testAllValuesAreRetrieved() throws Exception {
        this.rootNode.traverse(this.postOrderTraversalStrategy);
        List values = this.postOrderTraversalStrategy.traversalOutput();

        assertEquals(7, values.size());
    }

    @Test
    public void testTheOutputSequenceOfAllValues() throws Exception {
        this.rootNode.traverse(this.postOrderTraversalStrategy);
        List<Integer> values = this.postOrderTraversalStrategy.traversalOutput();
        StringBuffer valAsString = new StringBuffer("");
        for(Integer val : values) {
            valAsString.append(val.toString());
            valAsString.append("-");
        }

        assertEquals("20-60-50-145-160-150-100-", valAsString.toString());
    }
}
