package com.example.io;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static com.example.support.Constants.IOConstants.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ConsoleAppTest {

    @Mock
    private OutputManager outputManager;
    private ConsoleApp consoleApp;

    @Test
    public void testThatConsoleAppRunsSelectedTraversal() throws Exception {
        when(outputManager.ask(COMMA_SEPARATED_VALUE_PROMPT)).thenReturn("100,50,150,20,60,145,160");
        when(outputManager.ask(TRAVERSAL_OPTIONS, IN, PO, PR)).thenReturn("IN");
        this.consoleApp = new ConsoleApp(this.outputManager);
        this.consoleApp.run();

        verify(outputManager).show("The output for selected traversal is:");
        verify(outputManager).show("20-50-60-100-145-150-16");
    }

    @Test
    public void testThatConsoleAppSkipsNonIntegerValues() throws Exception {
        when(outputManager.ask(COMMA_SEPARATED_VALUE_PROMPT)).thenReturn("AA,50,150,20,60,145,160");
        when(outputManager.ask(TRAVERSAL_OPTIONS, IN, PO, PR)).thenReturn("IN");
        this.consoleApp = new ConsoleApp(this.outputManager);
        this.consoleApp.run();

        verify(outputManager).show("Skipping input AA. It doesn't look like an integer.");
        verify(outputManager).show("The output for selected traversal is:");
        verify(outputManager).show( "20-50-60-145-150-16");
    }
}