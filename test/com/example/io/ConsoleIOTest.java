package com.example.io;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.PrintStream;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ConsoleIOTest {

    @Mock
    private PrintStream printStream;
    @Mock
    private IOInterface.InputValidator validator;
    private ConsoleIO consoleInterface;

    @Before
    public void setUp() throws Exception {
        this.consoleInterface = new ConsoleIO(printStream);
    }

    @Test
    public void testThatShowMethodInvokesAPrintOnPrintStream() throws Exception {
        this.consoleInterface.show("abracadabra");

        verify(printStream).println("abracadabra");
    }
}