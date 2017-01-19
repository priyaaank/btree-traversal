package com.example.io;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class ConsoleOutputManagerTest {

    @Mock
    private ConsoleInputManager inputManager;
    @Mock
    private PrintStream printStream;
    private ConsoleOutputManager consoleOutputManager;

    @Before
    public void setUp() throws Exception {
        this.consoleOutputManager = new ConsoleOutputManager(printStream, inputManager);
    }

    @Test
    public void testShowInitiatesAPrintOnPrintStream() throws Exception {
        this.consoleOutputManager.show("Abracadabra");

        verify(printStream).println("Abracadabra");
    }

    @Test
    public void testAskWillReturnOnlyRestrictedValueWhenProvided() throws Exception {
        when(inputManager.readResponse()).thenAnswer(new Answer<String>() {
            private int callCount = 0;
            @Override
            public String answer(InvocationOnMock invocation) throws Throwable {
                callCount++;
                return callCount > 1 ? "A" : "Q";
            }
        });
        String response = this.consoleOutputManager.ask("A question", "A", "B");

        assertEquals("A", response);
        verify(printStream).println("A question");
        verify(printStream, atLeast(2)).println("Possible options are A, B :");
    }

    @Test
    public void testAskWillAcceptAnyValueWhenNoRestrictedValuesProvided() throws Exception {
        when(inputManager.readResponse()).thenReturn("a random answer");
        String response = this.consoleOutputManager.ask("A question");

        assertEquals("a random answer", response);
    }
}