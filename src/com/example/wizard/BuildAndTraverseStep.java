package com.example.wizard;

import com.example.domain.TraversalStrategy;
import com.example.domain.TreeNode;
import com.example.io.OutputManager;

import java.util.List;

public class BuildAndTraverseStep implements WizardStep {

    private final OutputManager outputManager;
    private final List<Integer> capturedValues;
    private final TraversalStrategy<Integer> traversalStrategy;
    private TreeNode<Integer> rootNode;
    private Boolean executedOnce;

    public BuildAndTraverseStep(final OutputManager outputManager, final List<Integer> capturedValues, final TraversalStrategy<Integer> traversalStrategy) {
        this.outputManager = outputManager;
        this.capturedValues = capturedValues;
        this.traversalStrategy = traversalStrategy;
        this.executedOnce = Boolean.FALSE;
    }

    @Override
    public void execute() {
        for (Integer value : this.capturedValues) {
            if (this.rootNode == null) {
                this.rootNode = new TreeNode<>(value);
            } else {
                this.rootNode.insert(value);
            }
        }
        rootNode.traverse(this.traversalStrategy);
        this.executedOnce = Boolean.TRUE;
    }

    @Override
    public Boolean isComplete() {
        return this.executedOnce;
    }

    @Override
    public WizardStep nextStep() {
        return new ShowOutputStep(this.outputManager, this.traversalStrategy);
    }
}
