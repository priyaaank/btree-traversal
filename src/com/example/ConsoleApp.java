package com.example;

import com.example.builder.YAMLTreeBuilder;
import com.example.traverser.Node;
import com.example.traverser.TraverserFactory;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class ConsoleApp {

    public static void main(String[] args) {
        try {
            Node<Integer> rootNode = null;
            rootNode = new YAMLTreeBuilder(new FileReader("res/tree_data.yml")).buildTree();
            TraverserFactory.<Integer>inOrder().traverse(rootNode, visitedNode -> System.out.println(visitedNode.getData()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
