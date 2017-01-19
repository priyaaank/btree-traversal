package com.example.io;

import com.example.domain.*;
import com.example.support.Constants;

import java.util.HashMap;
import java.util.Map;

public class ConsoleApp implements Constants.IOConstants {

    private final OutputManager outputManager;
    private TreeNode<Integer> rootNode;
    private String[] values;
    private TraversalStrategy<Integer> traversalStrategy;
    private Map<String, TraversalStrategy<Integer>> traversalMap = new HashMap<String, TraversalStrategy<Integer>>() {
        {
            put("pr", new PreOrderTraversalStrategy<>());
            put("po", new PostOrderTraversalStrategy<>());
            put("in", new InOrderTraversalStrategy<>());
        }
    };

    public ConsoleApp(OutputManager outputManager) {
        this.outputManager = outputManager;
    }

    public void run() {
        this.askInput();
        this.askTraversalType();
        this.buildAndTraverse();
        this.showOutput();
    }

    private void showOutput() {
        this.outputManager.show(FINAL_OUTPUT_PROMPT);
        this.outputManager.show(this.traversalStrategy.toString());
    }

    private void askInput() {
        String commaSeparatedValues = this.outputManager.ask(COMMA_SEPARATED_VALUE_PROMPT);
        this.values = commaSeparatedValues.split(",");
    }

    private void askTraversalType() {
        String traversalType = this.outputManager.ask(TRAVERSAL_OPTIONS, IN, PO, PR);
        this.traversalStrategy = traversalMap.get(traversalType.toLowerCase());
    }

    private void buildAndTraverse() {
        for (String value : this.values) {
            try {
                populateTree(value);
            } catch (NumberFormatException nfe) {
                outputManager.show(String.format(SKIP_ERROR_PROMPT, value));
            }
        }
        rootNode.traverse(traversalStrategy);
    }

    private void populateTree(String value) {
        Integer val = Integer.parseInt(value.trim());
        if (rootNode == null) {
            rootNode = new TreeNode<>(val);
        } else {
            rootNode.insert(val);
        }
    }

    public static void main(String[] args) {
        ConsoleOutputManager consoleOutputManager = new ConsoleOutputManager(new ConsoleInputManager());
        ConsoleApp bTreeConsole = new ConsoleApp(consoleOutputManager);
        bTreeConsole.run();
    }

}
