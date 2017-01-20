package com.example;

import com.example.io.IOInterface;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static com.example.support.Constants.IOMessages.*;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ConsoleAppTest {

    @Mock
    private IOInterface ioInterface;
    private ConsoleApp consoleApp;

    @Before
    public void setUp() throws Exception {
        this.consoleApp = new ConsoleApp(ioInterface);
        when(ioInterface.ask(eq(INPUT_TRAVERSAL_TYPE), anyObject(), eq(ERROR_INVALID_TRAVERSAL))).thenReturn("PO");
    }

    @Test
    public void testThatConsoleAppExecutesTreeTraversalForCorrectInput() throws Exception {
        when(ioInterface.ask(eq(INPUT_ENTER_TREE_DATA), anyObject(), eq(ERROR_INVALID_INPUT))).thenReturn("10,50,1,22");
        this.consoleApp.run();

        verify(ioInterface).show(OUTPUT_FINAL_LIST);
        verify(ioInterface).show("1");
        verify(ioInterface).show("22");
        verify(ioInterface).show("50");
        verify(ioInterface).show("10");
    }

}