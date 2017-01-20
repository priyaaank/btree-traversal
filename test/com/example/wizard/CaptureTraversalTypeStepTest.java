package com.example.wizard;

import com.example.io.OutputManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.example.support.Constants.IOConstants.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CaptureTraversalTypeStepTest {

    @Mock
    private OutputManager outputManager;
    private List<Integer> capturedValues = new ArrayList<>();
    private CaptureTraversalTypeStep captureTraversalTypeStep;

    @Before
    public void setUp() throws Exception {
        this.capturedValues.addAll(Arrays.asList(20, 300, 21, 34, 55));
        this.captureTraversalTypeStep = new CaptureTraversalTypeStep(outputManager, capturedValues);
    }

    @Test
    public void testStepIsNotCompleteUntilTraversalStrategyIsCaptured() throws Exception {
        assertFalse(this.captureTraversalTypeStep.isComplete());
    }

    @Test
    public void testNextStepIsBuildingAndTraversingTree() throws Exception {
        assertTrue(this.captureTraversalTypeStep.nextStep() instanceof BuildAndTraverseStep);
    }

    @Test
    public void testThatInValidInputIsNotAccepted() throws Exception {
        when(outputManager.ask(TRAVERSAL_OPTIONS, IN, PO, PR)).thenReturn("QQ");
        this.captureTraversalTypeStep.execute();

        assertFalse(this.captureTraversalTypeStep.isComplete());
    }

    @Test
    public void testThatErrorIsShowUponSubsequentExecuteWhenInValidInputIsProvided() throws Exception {
        when(outputManager.ask(TRAVERSAL_OPTIONS, IN, PO, PR)).thenReturn("QQ");
        this.captureTraversalTypeStep.execute();
        this.captureTraversalTypeStep.execute();

        verify(outputManager).show(TRAVERSAL_OPTION_INCORRECT);
    }

    @Test
    public void testStepIsCompleteIfTraversalStrategyIsCaptured() throws Exception {
        when(outputManager.ask(TRAVERSAL_OPTIONS, IN, PO, PR)).thenReturn(IN);
        this.captureTraversalTypeStep.execute();

        assertTrue(this.captureTraversalTypeStep.isComplete());
    }

}