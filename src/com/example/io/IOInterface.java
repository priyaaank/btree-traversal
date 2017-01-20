package com.example.io;

public interface IOInterface {

    String ask(String question, InputValidator validator, String errorMsg);

    void show(String text);

    interface InputValidator {

        boolean isInputValid(String input);

    }
}
