package com.example.builder;

import com.example.domain.*;
import com.example.io.IOInterface;
import com.example.support.TypeConverter;

import java.util.*;

import static com.example.support.Constants.IOMessages.*;
import static com.example.support.Constants.TraversalAbbrs.*;

public class ConsoleTreeBuilder<T extends Comparable> implements TreeBuilder<T> {

    private Node<T> rootNode;
    private IOInterface ioInterface;
    private TypeConverter<T> converter;
    private Map<String, Traverser<T>> traverserMap = new HashMap<String, Traverser<T>>() {
        {
            put(PR, new PreOrderTraverser<>());
            put(PO, new PostOrderTraverser<>());
            put(IN, new InOrderTraverser<>());
        }
    };

    public ConsoleTreeBuilder(IOInterface ioInterface, TypeConverter<T> converter) {
        this.ioInterface = ioInterface;
        this.converter = converter;
    }

    @Override
    public List<T> obtainInput() {
        String response = ioInterface.ask(INPUT_ENTER_TREE_DATA, getTreeInputValidator(), ERROR_INVALID_INPUT);
        return buildValueListFromStr(response);
    }

    @Override
    public Traverser<T> selectTraversalType() {
        String traversalType = ioInterface.ask(INPUT_TRAVERSAL_TYPE, getTraversalValidator(), ERROR_INVALID_TRAVERSAL);
        return selectTraversalTypeFromName(traversalType);
    }

    @Override
    public void buildAndTraverse(List<T> values, Traverser<T> traversalStrategy) {
        for (T value : values) {
            Node<T> newNode = new Node<>(value);
            if (rootNode == null) rootNode = newNode;
            else rootNode.insert(newNode);
        }
        traversalStrategy.traverse(rootNode, getSuccessCallback());
    }

    @Override
    public void processResult(Node<T> node) {
        this.ioInterface.show(node.getData().toString());
    }

    private Traverser.Visit<Node<T>> getSuccessCallback() {
        return this::processResult;
    }

    private IOInterface.InputValidator getTreeInputValidator() {
        return input -> buildValueListFromStr(input) != null;
    }

    private IOInterface.InputValidator getTraversalValidator() {
        return input -> selectTraversalTypeFromName(input) != null;
    }

    private List<T> buildValueListFromStr(String input) {
        List<T> valueList = new ArrayList<>();
        if (input == null || input.trim().length() == 0) return null;
        String[] delimitedInput = input.split(",");
        for (String value : delimitedInput) {
            T convertedVal = converter.convertFrom(value.trim());
            if (convertedVal == null) return null;
            else valueList.add(convertedVal);
        }
        return valueList;
    }

    private Traverser<T> selectTraversalTypeFromName(String input) {
        if (input == null || input.trim().length() == 0) return null;
        Iterator<String> keysItr = traverserMap.keySet().iterator();
        while (keysItr.hasNext()) {
            if (keysItr.next().equalsIgnoreCase(input.trim())) {
                return traverserMap.get(input.toUpperCase());
            }
        }
        return null;
    }

}
