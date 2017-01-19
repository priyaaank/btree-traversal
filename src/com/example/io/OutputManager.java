package com.example.io;

public interface OutputManager {

    String ask(String question, String... restrictedOptions);

    void show(String text);
}
