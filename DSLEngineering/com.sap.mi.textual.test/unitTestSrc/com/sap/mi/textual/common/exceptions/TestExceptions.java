/**
 * 
 */
package com.sap.mi.textual.common.exceptions;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sap.furcas.textual.common.exceptions.AbstractToolGenerationException;
import com.sap.furcas.textual.common.exceptions.GrammarGenerationException;
import com.sap.furcas.textual.common.exceptions.MetaModelLookupException;
import com.sap.furcas.textual.common.exceptions.ParserInvokationException;
import com.sap.furcas.textual.common.exceptions.WrappedException;
import com.sap.mi.textual.grammar.impl.tcs.t2m.validation.SyntaxDefValidationException;

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
        
        GrammarGenerationException ex2 = new GrammarGenerationException(message, cause) ;
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

        ParserInvokationException ex2 = new ParserInvokationException( cause) ;

        assertEquals(cause, ex2.getCause());
    }
    
    @Test
    public void testSyntaxDefValidationException() throws Exception {
        String message = "message";
        String object = "testObject";

        SyntaxDefValidationException ex = new SyntaxDefValidationException(message, object);
        assertEquals(message, ex.getMessage());    
        assertEquals(object, ex.getSyntaxModelElement());    
    }

    @Test
    public void testWrappedException() throws Exception {
        String message = "message";
        Exception cause = new Exception("Cause");
        
        
        WrappedException ex2 = new WrappedException(message, cause) ;
        assertEquals(message, ex2.getMessage());
        assertEquals(cause, ex2.getCause());
    }
    
}
