package com.example.io;

import java.util.Scanner;

public class ConsoleInputManager implements InputManager {

    private final Scanner reader;

    public ConsoleInputManager() {
        this(new Scanner(System.in));
    }

    public ConsoleInputManager(Scanner reader) {
        this.reader = reader;
    }

    @Override
    public String readResponse() {
        return reader.nextLine();
    }
}
