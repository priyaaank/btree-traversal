package com.example.builder;

import com.esotericsoftware.yamlbeans.YamlException;
import com.esotericsoftware.yamlbeans.YamlReader;
import com.example.traverser.Node;

import java.io.FileReader;
import java.util.List;

public class YAMLTreeBuilder implements TreeBuilder {

    private FileReader fileReader;

    public YAMLTreeBuilder(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    @Override
    public Node<Integer> buildTree() {
        try {
            YamlReader reader = new YamlReader(fileReader);
            YAMLNode node = reader.read(YAMLNode.class);
            return node.asNode();
        } catch (YamlException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static class YAMLNode {
        public Integer value;
        public List<YAMLNode> children;

        Node<Integer> asNode() {
            Node<Integer> treeNode = new Node<>(this.value);
            if (children == null) return treeNode;
            transformSubNodes(treeNode);
            return treeNode;
        }

        private void transformSubNodes(Node<Integer> treeNode) {
            for (YAMLNode yamlNode : children) {
                treeNode.insert(yamlNode.asNode());
            }
        }
    }

}
