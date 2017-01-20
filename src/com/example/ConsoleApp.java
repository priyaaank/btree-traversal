package com.example;

import com.example.io.ConsoleOutputManager;
import com.example.support.Constants;
import com.example.wizard.CaptureInputStep;
import com.example.wizard.WizardStep;

public class ConsoleApp implements Constants.IOConstants {

    public static void main(String[] args) {
        ConsoleOutputManager outputManager = new ConsoleOutputManager();
        WizardStep wizardStep = new CaptureInputStep(outputManager);
        while (wizardStep != null) {
            wizardStep.execute();
            if (wizardStep.isComplete()) wizardStep = wizardStep.nextStep();
        }
    }

}
