/**
 * 
 */
package com.sap.furcas.runtime.common.exceptions;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sap.furcas.parsergenerator.GrammarGenerationException;

/**
 * Tests Exceptions in common, mainly tests constructors.
 */
public class TestExceptions {

    @Test
    public void testAbstractToolGenerationException() throws Exception {
        String message = "message";
        Exception cause = new Exception("Cause");

        AbstractToolGenerationException ex = new AbstractToolGenerationException(message) {};
        assertEquals(message, ex.getMessage());

        AbstractToolGenerationException ex2 = new AbstractToolGenerationException(message, cause) {};
        assertEquals(message, ex2.getMessage());
        assertEquals(cause, ex2.getCause());
    }

    @Test
    public void testGrammarGenerationException() throws Exception {
        String message = "message";
        Exception cause = new Exception("Cause");

        GrammarGenerationException ex = new GrammarGenerationException(message);
        assertEquals(message, ex.getMessage());

        GrammarGenerationException ex2 = new GrammarGenerationException(message, cause);
        assertEquals(message, ex2.getMessage());
        assertEquals(cause, ex2.getCause());
    }

    @Test
    public void testMetaModelLookupException() throws Exception {
        String message = "message";
        MetaModelLookupException ex = new MetaModelLookupException(message);
        assertEquals(message, ex.getMessage());
    }

    @Test
    public void testParserInvokationException() throws Exception {
        Exception cause = new Exception("Cause");
        ParserInvokationException ex2 = new ParserInvokationException(cause);

        assertEquals(cause, ex2.getCause());
    }

    @Test
    public void testWrappedException() throws Exception {
        String message = "message";
        Exception cause = new Exception("Cause");

        WrappedException ex2 = new WrappedException(message, cause);
        assertEquals(message, ex2.getMessage());
        assertEquals(cause, ex2.getCause());
    }

}
