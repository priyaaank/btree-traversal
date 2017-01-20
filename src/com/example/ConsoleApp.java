package com.example;

import com.example.builder.ConsoleTreeBuilder;
import com.example.io.ConsoleIO;
import com.example.support.TypeConverter;

public class ConsoleApp {

    public static void main(String[] args) {
        ConsoleIO consoleIO = new ConsoleIO();
        TypeConverter<Integer> integerTypeConverter = input -> {
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException nfe) {
                return null;
            }
        };
        ConsoleTreeBuilder<Integer> builder = new ConsoleTreeBuilder<>(consoleIO, integerTypeConverter);
        builder.buildAndTraverse(builder.obtainInput(), builder.selectTraversalType());
    }

}
