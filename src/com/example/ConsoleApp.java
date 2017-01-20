package com.example;

import com.example.builder.ConsoleTreeBuilder;
import com.example.io.ConsoleIO;
import com.example.io.IOInterface;
import com.example.support.TypeConverter;

public class ConsoleApp {

    private IOInterface ioInterface;

    public ConsoleApp(IOInterface ioInterface) {
        this.ioInterface = ioInterface;
    }

    public void run() {
        TypeConverter<Integer> integerTypeConverter = convertToInteger();
        ConsoleTreeBuilder<Integer> builder = new ConsoleTreeBuilder<>(ioInterface, integerTypeConverter);
        builder.buildAndTraverse(builder.obtainInput(), builder.selectTraversalType());
    }

    private TypeConverter<Integer> convertToInteger() {
        return input -> {
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException nfe) {
                return null;
            }
        };
    }

    public static void main(String[] args) {
        new ConsoleApp(new ConsoleIO()).run();
    }

}
