package com.example.wizard;

import com.example.domain.TraversalStrategy;
import com.example.io.OutputManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BuildAndTraverseStepTest {

    @Mock
    private OutputManager outputManager;
    @Mock
    private TraversalStrategy<Integer> traversalStrategy;
    private BuildAndTraverseStep buildAndTraverseStep;
    private List<Integer> capturedValues = new ArrayList<>();


    @Before
    public void setUp() throws Exception {
        this.capturedValues.addAll(Arrays.asList(100, 150, 200, 30, 20));
        this.buildAndTraverseStep = new BuildAndTraverseStep(this.outputManager, this.capturedValues, this.traversalStrategy);
    }

    @Test
    public void testThatNextStepIsShowingOutput() throws Exception {
        assertTrue(this.buildAndTraverseStep.nextStep() instanceof ShowOutputStep);
    }

    @Test
    public void testThatIsCompleteIsTrueIfExecutedOnceAtleast() throws Exception {
        this.buildAndTraverseStep.execute();
        assertTrue(this.buildAndTraverseStep.isComplete());
    }

    @Test
    public void testIsCompleteIsFalseIfNeverExecuted() throws Exception {
        assertFalse(this.buildAndTraverseStep.isComplete());
    }

    @Test
    public void testThatBinaryTreeCanBeTraversed() throws Exception {
        this.buildAndTraverseStep.execute();

        verify(this.traversalStrategy, atLeast(1)).visit(eq(100), anyObject(), anyObject());
    }
}