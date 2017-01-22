package com.example;

import com.example.builder.YAMLTreeBuilder;
import com.example.traverser.Node;
import com.example.traverser.TraverserFactory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;

public class ConsoleApp {

    private PrintStream printStream;
    private String inputFile;

    public ConsoleApp(PrintStream printStream, String inputFile) {
        this.printStream = printStream;
        this.inputFile = inputFile;
    }

    public ConsoleApp() {
        this(System.out, "res/tree_data.yml");
    }

    public void run() {
        try {
            Node<Integer> rootNode = new YAMLTreeBuilder(new FileReader(this.inputFile)).buildTree();
            TraverserFactory.<Integer>inOrder().traverse(rootNode, visitedNode -> printStream.println(visitedNode.toString()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ConsoleApp().run();
    }

}
