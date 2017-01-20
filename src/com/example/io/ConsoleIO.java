package com.example.io;

import java.io.PrintStream;
import java.util.Scanner;

public class ConsoleIO implements IOInterface {

    private PrintStream printStream;
    private Scanner reader;

    public ConsoleIO() {
        this(System.out, new Scanner(System.in));
    }

    public ConsoleIO(PrintStream printStream, Scanner reader) {
        this.printStream = printStream;
        this.reader = reader;
    }

    @Override
    public String ask(String question, InputValidator validator, String errorMsg) {
        String input;
        Boolean isValid = Boolean.TRUE;
        do {
            if(!isValid) printStream.println(errorMsg);
            printStream.println(question);
            input = reader.nextLine();
        } while(!(isValid = validator.isInputValid(input)));
        return input;
    }

    @Override
    public void show(String text) {
        printStream.println(text);
    }

}
