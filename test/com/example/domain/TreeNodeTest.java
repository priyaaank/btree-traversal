package com.example.domain;

import org.junit.Test;

import static org.junit.Assert.assertNull;

public class TreeNodeTest {

    @Test
    public void testNodeValuesCanBeSet() {
        TreeNode<String> rootNode = new TreeNode<>("Root value");
        assertNull(rootNode.right());
    }

}
