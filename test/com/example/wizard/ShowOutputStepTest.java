package com.example.wizard;

import com.example.domain.TraversalStrategy;
import com.example.io.OutputManager;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ShowOutputStepTest {

    @Mock
    private OutputManager outputManager;
    @Mock
    private TraversalStrategy<Integer> traversalStrategy;
    private ShowOutputStep showOutputStep;

    @Before
    public void setUp() throws Exception {
        this.showOutputStep = new ShowOutputStep(this.outputManager, this.traversalStrategy);
        when(traversalStrategy.toString()).thenReturn("12, 2, 20");
    }

    @Test
    public void testThatOutputIsRetrievedFromTraversalStrategy() throws Exception {
        this.showOutputStep.execute();

        verify(this.outputManager).show("The output for selected traversal is:");
        verify(this.outputManager).show("12, 2, 20");
    }

    @Test
    public void testIsCompleteIsFalseIfNeverExecuted() throws Exception {
        assertFalse(this.showOutputStep.isComplete());
    }

    @Test
    public void testIsCompleteIsTrueIfExecutedAtleastOnce() throws Exception {
        this.showOutputStep.execute();
        assertTrue(this.showOutputStep.isComplete());
    }

    @Test
    public void testNextStepIsNull() throws Exception {
        assertNull(this.showOutputStep.nextStep());
    }
}