package com.example.builder;

import com.example.domain.InOrderTraverser;
import com.example.domain.PostOrderTraverser;
import com.example.domain.PreOrderTraverser;
import com.example.domain.Traverser;
import com.example.io.IOInterface;
import com.example.support.TypeConverter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static com.example.support.Constants.IOMessages.*;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ConsoleTreeBuilderTest {

    @Mock
    private IOInterface ioInterface;
    private ConsoleTreeBuilder<Integer> builder;

    @Before
    public void setUp() throws Exception {
        TypeConverter<Integer> integerTypeConverter = getIntegerTypeConverter();
        this.builder = new ConsoleTreeBuilder<>(ioInterface, integerTypeConverter);
    }

    @Test
    public void testThatConvertedInputIsObtainedFromConsole() {
        when(ioInterface.ask(eq(INPUT_ENTER_TREE_DATA), anyObject(), eq(ERROR_INVALID_INPUT))).thenReturn("10,12,34");
        List<Integer> integers = builder.obtainInput();

        assertEquals(Integer.valueOf(10), integers.get(0));
        assertEquals(Integer.valueOf(12), integers.get(1));
        assertEquals(Integer.valueOf(34), integers.get(2));
    }

    @Test
    public void testThatConvertedInputIsNotObtainedEvenIfOneValueIsIncorrect() {
        when(ioInterface.ask(eq(INPUT_ENTER_TREE_DATA), anyObject(), eq(ERROR_INVALID_INPUT))).thenReturn("10,12,A");
        List<Integer> integers = builder.obtainInput();

        assertNull(integers);
    }

    @Test
    public void testThatPostOrderTypeIsResolvedCorrectly() throws Exception {
        when(ioInterface.ask(eq(INPUT_TRAVERSAL_TYPE), anyObject(), eq(ERROR_INVALID_TRAVERSAL))).thenReturn("PO");
        Traverser<Integer> traverser = builder.selectTraversalType();

        assertTrue(traverser instanceof PostOrderTraverser);
    }

    @Test
    public void testThatPreOrderTypeIsResolvedCorrectly() throws Exception {
        when(ioInterface.ask(eq(INPUT_TRAVERSAL_TYPE), anyObject(), eq(ERROR_INVALID_TRAVERSAL))).thenReturn("PR");
        Traverser<Integer> traverser = builder.selectTraversalType();

        assertTrue(traverser instanceof PreOrderTraverser);
    }

    @Test
    public void testThatInOrderTypeIsResolvedCorrectly() throws Exception {
        when(ioInterface.ask(eq(INPUT_TRAVERSAL_TYPE), anyObject(), eq(ERROR_INVALID_TRAVERSAL))).thenReturn("IN");
        Traverser<Integer> traverser = builder.selectTraversalType();

        assertTrue(traverser instanceof InOrderTraverser);
    }

    @Test
    public void testThatWhenTraverserNameIsIncorrectTraverIsNull() throws Exception {
        when(ioInterface.ask(eq(INPUT_TRAVERSAL_TYPE), anyObject(), eq(ERROR_INVALID_TRAVERSAL))).thenReturn("QQ");
        Traverser<Integer> traverser = builder.selectTraversalType();

        assertNull(traverser);
    }

    @Test
    public void testThatBuildAndTraverseProcessesTheResults() throws Exception {
        when(ioInterface.ask(eq(INPUT_TRAVERSAL_TYPE), anyObject(), eq(ERROR_INVALID_TRAVERSAL))).thenReturn("PO");
        Traverser<Integer> traverser = builder.selectTraversalType();
        builder.buildAndTraverse(Arrays.asList(23, 32), traverser);

        verify(ioInterface).show(OUTPUT_FINAL_LIST);
        verify(ioInterface).show("23");
        verify(ioInterface).show("32");
    }

    private TypeConverter<Integer> getIntegerTypeConverter() {
        return input -> {
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException nfe) {
                return null;
            }
        };
    }

}