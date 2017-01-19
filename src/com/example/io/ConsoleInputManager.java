package com.example.io;

import java.util.Scanner;

public class ConsoleInputManager implements InputManager {

    private final Scanner reader;

    public ConsoleInputManager() {
        this.reader = new Scanner(System.in);
    }

    @Override
    public String readResponse() {
        return reader.nextLine();
    }
}
