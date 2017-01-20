package com.example.wizard;

import com.example.io.OutputManager;
import com.example.support.Constants;

import java.util.ArrayList;
import java.util.List;

import static com.example.support.Constants.IOConstants.COMMA_SEPARATED_VALUE_PROMPT;
import static com.example.support.Constants.IOConstants.SKIP_ERROR_PROMPT;

public class CaptureInputStep implements WizardStep, Constants.Defaults {

    private final OutputManager outputManager;
    private String[] capturedStringValues;
    private List<Integer> capturedValuesAsInt;
    private String error = EMPTY_STRING;

    public CaptureInputStep(final OutputManager outputManager) {
        this.outputManager = outputManager;
        this.capturedValuesAsInt = new ArrayList<>();
    }

    @Override
    public void execute() {
        if (this.error != null && this.error.length() > 0) this.outputManager.show(error);
        this.error = EMPTY_STRING;
        String commaSeparatedValues = this.outputManager.ask(COMMA_SEPARATED_VALUE_PROMPT);
        this.capturedStringValues = commaSeparatedValues.split(",");
        for (String value : this.capturedStringValues) convertToIntegers(value);
    }

    @Override
    public Boolean isComplete() {
        return ((this.error == null || this.error.length() == 0) && capturedValuesAsInt.size() > 0);
    }

    @Override
    public WizardStep nextStep() {
        return new CaptureTraversalTypeStep(this.outputManager, this.capturedValuesAsInt);
    }

    private void convertToIntegers(String value) {
        try {
            capturedValuesAsInt.add(Integer.parseInt(value.trim()));
        } catch (NumberFormatException nfe) {
            this.error += String.format(SKIP_ERROR_PROMPT, value);
        }
    }

}
