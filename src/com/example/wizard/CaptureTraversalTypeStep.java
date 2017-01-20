package com.example.wizard;

import com.example.domain.InOrderTraversalStrategy;
import com.example.domain.PostOrderTraversalStrategy;
import com.example.domain.PreOrderTraversalStrategy;
import com.example.domain.TraversalStrategy;
import com.example.io.OutputManager;
import com.example.support.Constants;
import com.example.support.LogFactory;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

import static com.example.support.Constants.IOConstants.*;

public class CaptureTraversalTypeStep implements WizardStep, Constants.Defaults, Constants.LogMessages {
    private OutputManager outputManager;
    private List<Integer> capturedValues;
    private TraversalStrategy<Integer> traversalStrategy;
    private String error = EMPTY_STRING;
    private final Map<String, TraversalStrategy<Integer>> traversalMap = new HashMap<String, TraversalStrategy<Integer>>() {
        {
            put(PR, new PreOrderTraversalStrategy<>());
            put(PO, new PostOrderTraversalStrategy<>());
            put(IN, new InOrderTraversalStrategy<>());
        }
    };

    public CaptureTraversalTypeStep(OutputManager outputManager, List<Integer> capturedValues) {
        this.outputManager = outputManager;
        this.capturedValues = capturedValues;
    }

    @Override
    public void execute() {
        if (error != null && error.length() > 0) this.outputManager.show(error);
        error = EMPTY_STRING;
        String traversalType = this.outputManager.ask(TRAVERSAL_OPTIONS, IN, PO, PR);
        assignTraversalStrategy(traversalType);
        setErrorIfApplicable();
    }

    private void setErrorIfApplicable() {
        if (traversalStrategy == null) {
            LogFactory.getLoggerInstance().log(Level.SEVERE, ERROR_INCORRECT_TRAVERSAL_OPTION);
            error = TRAVERSAL_OPTION_INCORRECT;
        }
    }

    @Override
    public Boolean isComplete() {
        return traversalStrategy != null;
    }

    @Override
    public WizardStep nextStep() {
        LogFactory.getLoggerInstance().log(Level.INFO, INFO_NEXT_STEP_TRAVERSE_TREE);
        return new BuildAndTraverseStep(this.outputManager, this.capturedValues, this.traversalStrategy);
    }

    private void assignTraversalStrategy(String traversalType) {
        Iterator<String> traversalTypeItr = traversalMap.keySet().iterator();
        while (traversalTypeItr.hasNext()) {
            if (traversalTypeItr.next().equalsIgnoreCase(traversalType)) {
                this.traversalStrategy = traversalMap.get(traversalType.toUpperCase());
            }
        }
    }
}
