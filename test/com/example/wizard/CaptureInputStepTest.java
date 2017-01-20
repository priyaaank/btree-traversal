package com.example.wizard;

import com.example.io.OutputManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static com.example.support.Constants.IOConstants.COMMA_SEPARATED_VALUE_PROMPT;
import static com.example.support.Constants.IOConstants.SKIP_ERROR_PROMPT;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CaptureInputStepTest {

    @Mock
    private OutputManager outputManager;
    private CaptureInputStep captureInputStep;

    @Before
    public void setUp() throws Exception {
        this.captureInputStep = new CaptureInputStep(outputManager);
    }

    @Test
    public void testThatNextStepIsCaptureTraversalType() throws Exception {
        assertTrue(this.captureInputStep.nextStep() instanceof CaptureTraversalTypeStep);
    }

    @Test
    public void testThatInputWithInvalidValuesIsRejected() throws Exception {
        when(this.outputManager.ask(COMMA_SEPARATED_VALUE_PROMPT)).thenReturn("AA, 23, 22");
        this.captureInputStep.execute();
        this.captureInputStep.execute();

        verify(this.outputManager).show(String.format(SKIP_ERROR_PROMPT, "AA"));
    }

    @Test
    public void testThatInputIsInvalidIfNotDelimitedByComma() throws Exception {
        when(this.outputManager.ask(COMMA_SEPARATED_VALUE_PROMPT)).thenReturn("21 - 23 - 22");
        this.captureInputStep.execute();
        this.captureInputStep.execute();

        verify(this.outputManager).show(String.format(SKIP_ERROR_PROMPT, "21 - 23 - 22"));
    }

    @Test
    public void testThatInputStepIsNotCompleteUnlessAtleastOneValueIsProvided() throws Exception {
        when(this.outputManager.ask(COMMA_SEPARATED_VALUE_PROMPT)).thenReturn("");
        this.captureInputStep.execute();

        assertFalse(this.captureInputStep.isComplete());
    }

    @Test
    public void testThatInputStepIsNotCompleteIsInvalidValueWasProvided() throws Exception {
        when(this.outputManager.ask(COMMA_SEPARATED_VALUE_PROMPT)).thenReturn("2, 34, 22, A");
        this.captureInputStep.execute();

        assertFalse(this.captureInputStep.isComplete());
    }

    @Test
    public void testThatExecutionIsMarkedCompleteIfValidInputIsProvided() throws Exception {
        when(this.outputManager.ask(COMMA_SEPARATED_VALUE_PROMPT)).thenReturn("2,34,55, 33");
        this.captureInputStep.execute();

        assertTrue(this.captureInputStep.isComplete());
    }
}