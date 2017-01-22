package com.example.traverser;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
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

    private Node<Integer> rootNode;
    private Traverser<Integer> traverser;

    @Before
    public void setUp() throws Exception {
        rootNode = new Node<>(100);
        for (Integer value : Arrays.asList(50, 150, 20, 60, 145, 160)) {
            rootNode.insert(new Node<>(value));
        }
        this.traverser = new PostOrderTraverser<>();
    }

    @Test
    public void testThatNodesAreReturnedInPostOrder() throws Exception {
        List<Node<Integer>> returnedNodes = new ArrayList<>();
        this.traverser.traverse(rootNode, visitedNode -> {
            returnedNodes.add(visitedNode);
        });
        String value = getNodeSequenceAsStr(returnedNodes);

        assertEquals("20-60-50-145-160-150-100", value);
    }

    private String getNodeSequenceAsStr(List<Node<Integer>> selectedNodes) {
        StringBuffer value = new StringBuffer("");
        for (Node node : selectedNodes) {
            value.append(node.getData()).append("-");
        }
        return value.substring(0, value.length() - 1);
    }


}