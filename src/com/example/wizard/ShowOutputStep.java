package com.example.wizard;

import com.example.domain.TraversalStrategy;
import com.example.io.OutputManager;
import com.example.support.Constants;
import com.example.support.LogFactory;

import java.util.logging.Level;

import static com.example.support.Constants.IOConstants.FINAL_OUTPUT_PROMPT;

public class ShowOutputStep implements WizardStep, Constants.LogMessages {
    private final OutputManager outputManager;
    private final TraversalStrategy<Integer> traversalStrategy;
    private Boolean executedOnce = Boolean.FALSE;

    public ShowOutputStep(OutputManager outputManager, TraversalStrategy<Integer> traversalStrategy) {
        this.outputManager = outputManager;
        this.traversalStrategy = traversalStrategy;
    }

    @Override
    public void execute() {
        this.outputManager.show(FINAL_OUTPUT_PROMPT);
        this.outputManager.show(this.traversalStrategy.toString());
        this.executedOnce = Boolean.TRUE;
    }

    @Override
    public Boolean isComplete() {
        return executedOnce;
    }

    @Override
    public WizardStep nextStep() {
        LogFactory.getLoggerInstance().log(Level.INFO, INFO_LAST_STEP_EXECUTED);
        return null;
    }
}
