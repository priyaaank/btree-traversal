package com.example.traverser;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class PreOrderTraverserTest {

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

    private Node<Integer> rootNode;
    private Traverser<Integer> traverser;

    @Before
    public void setUp() throws Exception {
        rootNode = new Node<>(100);
        for (Integer value : Arrays.asList(50, 150, 20, 60, 145, 160)) {
            rootNode.insert(new Node<>(value));
        }
        this.traverser = new PreOrderTraverser<>();
    }

    @Test
    public void testThatNodesAreReturnedInPreOrder() throws Exception {
        List<Node<Integer>> returnedNodes = new ArrayList<>();
        this.traverser.traverse(rootNode, returnedNodes::add);
        String value = getNodeSequenceAsStr(returnedNodes);

        assertEquals("100-50-20-60-150-145-160", value);
    }

    private String getNodeSequenceAsStr(List<Node<Integer>> selectedNodes) {
        StringBuffer value = new StringBuffer("");
        for(Node node :selectedNodes) {
            value.append(node.toString()).append("-");
        }
        return value.substring(0, value.length()-1);
    }


}