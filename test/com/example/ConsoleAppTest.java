package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.PrintStream;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ConsoleAppTest {

    @Mock
    private PrintStream printStream;
    private ConsoleApp consoleApp;
    private String inputFilename;

    @Before
    public void setUp() throws Exception {
        this.inputFilename = "res/tree_data.yml";
    }

    @Test
    public void testThatTreeIsBuiltAndTraveresed() throws Exception {
        this.consoleApp = new ConsoleApp(printStream, inputFilename);
        this.consoleApp.run();

        verify(printStream, atMost(1)).println(20);
        verify(printStream, atMost(1)).println(50);
        verify(printStream, atMost(1)).println(60);
        verify(printStream, atMost(1)).println(100);
        verify(printStream, atMost(1)).println(140);
        verify(printStream, atMost(1)).println(150);
        verify(printStream, atMost(1)).println(160);
    }

    @Test
    public void testWhenFileDoesNotExistNoOutputIsPrinted() throws Exception {
        this.consoleApp = new ConsoleApp(printStream, "res/non_existent_file.yml");
        this.consoleApp.run();

        verify(printStream, never()).println();
    }
}