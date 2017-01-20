package com.example.wizard;

import com.example.domain.TraversalStrategy;
import com.example.domain.TreeNode;
import com.example.io.OutputManager;
import com.example.support.Constants;
import com.example.support.LogFactory;

import java.util.List;
import java.util.logging.Level;

public class BuildAndTraverseStep implements WizardStep, Constants.LogMessages {

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
        buildTree();
        traverse();
        this.executedOnce = Boolean.TRUE;
    }

    @Override
    public Boolean isComplete() {
        return this.executedOnce;
    }

    @Override
    public WizardStep nextStep() {
        LogFactory.getLoggerInstance().log(Level.INFO, INFO_NEXT_STEP_TRAVERSAL_TYPE);
        return new ShowOutputStep(this.outputManager, this.traversalStrategy);
    }

    private void buildTree() {
        LogFactory.getLoggerInstance().log(Level.INFO, INFO_BUILDING_TREE);
        for (Integer value : this.capturedValues) {
            if (this.rootNode == null) {
                this.rootNode = new TreeNode<>(value);
            } else {
                this.rootNode.insert(value);
            }
        }
    }

    private void traverse() {
        LogFactory.getLoggerInstance().log(Level.INFO, INFO_TRAVERSING_TREE);
        rootNode.traverse(this.traversalStrategy);
    }
}
