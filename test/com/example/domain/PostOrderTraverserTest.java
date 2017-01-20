package com.example.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class PostOrderTraverserTest {

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

    private Node<Integer> rootNode = new Node<>();
    private Traverser<Integer> traverser;

    @Before
    public void setUp() throws Exception {
        rootNode.insert(100);
        rootNode.insert(50);
        rootNode.insert(150);
        rootNode.insert(20);
        rootNode.insert(60);
        rootNode.insert(145);
        rootNode.insert(160);
        this.traverser = new PostOrderTraverser<>();
    }

    @Test
    public void testThatNodesAreReturnedInPostOrder() throws Exception {
        this.traverser.traverse(rootNode, selectedNodes -> {
            String value = getNodeSequenceAsStr(selectedNodes);
            assertEquals("20-60-50-145-160-150-100", value);
        });
    }

    private String getNodeSequenceAsStr(List<Node<Integer>> selectedNodes) {
        StringBuffer value = new StringBuffer("");
        for (Node node : selectedNodes) {
            value.append(node.getData()).append("-");
        }
        return value.substring(0, value.length() - 1);
    }


}