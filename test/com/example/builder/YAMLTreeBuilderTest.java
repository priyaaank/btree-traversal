package com.example.builder;

import com.example.traverser.Node;
import org.junit.Before;
import org.junit.Test;

import java.io.FileReader;

import static org.junit.Assert.assertEquals;

public class YAMLTreeBuilderTest {

    private FileReader fileReader;
    private YAMLTreeBuilder builder;

    @Before
    public void setUp() throws Exception {
        this.fileReader = new FileReader("res/tree_data.yml");
        this.builder = new YAMLTreeBuilder(this.fileReader);
    }

    @Test
    public void testThatRootNodeIsReturnedWhenTreeIsBuilt() throws Exception {
        Node<Integer> rootNode = this.builder.buildTree();

        assertEquals("100", rootNode.toString());
    }

}