package com.example.io;

import com.example.support.Constants;

import java.io.PrintStream;

public class ConsoleOutputManager implements OutputManager, Constants.IOConstants {

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
    public String ask(String question, String... restrictedOptions) {
        this.printer.println(question);
        String input = null;
        while (!isValidInput(restrictedOptions, input)) {
            input = getResponse(restrictedOptions);
        }
        return input;
    }

    @Override
    public void show(String text) {
        this.printer.println(text);
    }

    private String getResponse(String[] restrictedOptions) {
        String input;
        if (restrictedOptions.length > 0) {
            this.printer.println(String.format(POSSIBLE_OPTIONS, printableOptions(restrictedOptions)));
        }
        input = this.inputManager.readResponse();
        return input;
    }

    private String printableOptions(String[] restrictedOptions) {
        StringBuffer options = new StringBuffer("");
        for (String option : restrictedOptions) {
            options.append(option);
            options.append(", ");
        }
        int endIndex = options.length() >= 2 ? options.length() - 2 : 0;
        return options.substring(0, endIndex);
    }

    private boolean isValidInput(String[] restrictedOptions, String input) {
        if (input == null || input.trim().length() == 0) return false;
        if (restrictedOptions == null || restrictedOptions.length == 0) return true;
        for (String options : restrictedOptions) {
            if (options.toLowerCase().equals(input.trim().toLowerCase())) return true;
        }
        return false;
    }
}
