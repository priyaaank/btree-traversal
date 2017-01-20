package com.example.io;

import com.example.support.Constants;
import com.example.support.LogFactory;

import java.io.PrintStream;
import java.util.logging.Level;

public class ConsoleOutputManager implements OutputManager, Constants.IOConstants, Constants.LogMessages {

    private final ConsoleInputManager inputManager;
    private PrintStream printer;

    public ConsoleOutputManager() {
        this(System.out, new ConsoleInputManager());
    }

    public ConsoleOutputManager(PrintStream printStream, ConsoleInputManager inputManager) {
        this.printer = printStream;
        this.inputManager = inputManager;
    }

    @Override
    public String ask(final String question, final String... restrictedOptions) {
        this.printer.println(question);
        String input = null;
        while (!isValidInput(restrictedOptions, input)) {
            input = getResponse(restrictedOptions);
        }
        return input;
    }

    @Override
    public void show(final String text) {
        this.printer.println(text);
    }

    private String getResponse(final String[] restrictedOptions) {
        String input;
        if (restrictedOptions.length > 0) {
            this.printer.println(String.format(POSSIBLE_OPTIONS, printableOptions(restrictedOptions)));
        }
        input = this.inputManager.readResponse();
        return input;
    }

    private String printableOptions(final String[] restrictedOptions) {
        StringBuffer options = new StringBuffer("");
        for (String option : restrictedOptions) {
            options.append(option);
            options.append(", ");
        }
        int endIndex = options.length() >= 2 ? options.length() - 2 : 0;
        return options.substring(0, endIndex);
    }

    private boolean isValidInput(final String[] restrictedOptions, String input) {
        if (input == null || input.trim().length() == 0) return false;
        if (restrictedOptions == null || restrictedOptions.length == 0) return true;
        for (String options : restrictedOptions) {
            if (options.toLowerCase().equals(input.trim().toLowerCase())) return true;
        }
        LogFactory.getLoggerInstance().log(Level.SEVERE, ERROR_INPUT_VALUE_INVALID);
        return false;
    }
}
