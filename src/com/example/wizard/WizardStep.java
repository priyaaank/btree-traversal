package com.example.wizard;

public interface WizardStep {

    void execute();

    Boolean isComplete();

    WizardStep nextStep();

}
