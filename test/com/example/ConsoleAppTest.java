package com.example;

import com.example.io.OutputManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static com.example.support.Constants.IOConstants.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ConsoleAppTest {

    @Mock
    private OutputManager outputManager;
    private ConsoleApp consoleApp;

    @Before
    public void setUp() throws Exception {
        this.consoleApp = new ConsoleApp();
        when(outputManager.ask(COMMA_SEPARATED_VALUE_PROMPT)).thenReturn("12, 334, 44, 22");
        when(outputManager.ask(TRAVERSAL_OPTIONS, IN, PO, PR)).thenReturn(IN);
    }

    @Test
    public void testThatWizardIsRunEndToEnd() throws Exception {
        this.consoleApp.execute(this.outputManager);

        verify(outputManager).show(FINAL_OUTPUT_PROMPT);
        verify(outputManager).show("12-22-44-334");
    }
}