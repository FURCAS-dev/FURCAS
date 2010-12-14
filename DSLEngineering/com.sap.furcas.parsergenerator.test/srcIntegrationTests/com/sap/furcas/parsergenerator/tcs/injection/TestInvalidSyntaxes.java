package com.sap.furcas.parsergenerator.tcs.injection;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

import java.io.ByteArrayInputStream;

import org.junit.Test;

import com.sap.furcas.runtime.parser.ParsingError;

public class TestInvalidSyntaxes extends AbstractTCSInjectionTest {

    @Test
    public void testInvalidKeywordSyntax() throws Exception {
        String invalidSample = "symtax invalid{}";
        parseInputStream(new ByteArrayInputStream(invalidSample.getBytes()));
        
        assertNotNull(modelParsingResult);
        assertNotNull(modelParsingResult.getResult().getErrors());
        assertEquals(2, modelParsingResult.getResult().getErrors().size());
        ParsingError e1 = modelParsingResult.getResult().getErrors().get(0);
        assertEquals(1, e1.getLine());
        assertEquals(0, e1.getPosition());
        assertEquals(1, e1.getEndLine());
        assertEquals(6, e1.getEndPosition());
    }

    @Test
    public void testInvalidSymbol() throws Exception {
        String invalidSample = "syntax invalid()";
        parseInputStream(new ByteArrayInputStream(invalidSample.getBytes()));
        
        assertNotNull(modelParsingResult);
        assertNotNull(modelParsingResult.getResult().getErrors());
        assertEquals(1, modelParsingResult.getResult().getErrors().size());
        ParsingError e1 = modelParsingResult.getResult().getErrors().get(0);
        assertEquals(1, e1.getLine());
        assertEquals(15, e1.getPosition());
        assertEquals(1, e1.getEndLine());
        assertEquals(16, e1.getEndPosition());
    }

    @Test
    public void testBadKeyword() throws Exception {
        String invalidSample = "syntax !§${"
            +"template ->Attribute abstract;"
            +"}";
        parseInputStream(new ByteArrayInputStream(invalidSample.getBytes()));

        assertNotNull(modelParsingResult);
        assertNotNull(modelParsingResult.getResult().getErrors());
        assertEquals(2, modelParsingResult.getResult().getErrors().size());
    }

    @Test
    public void testNoAlt() throws Exception {
        String invalidSample = "syntax MyLanguage { \n"
            +"template ->Attribute abstract abstract;\n"
            +"}";
        parseInputStream(new ByteArrayInputStream(invalidSample.getBytes()));

        assertNotNull(modelParsingResult);
        assertNotNull(modelParsingResult.getResult().getErrors());
        assertEquals(1, modelParsingResult.getResult().getErrors().size());
        ParsingError e1 = modelParsingResult.getResult().getErrors().get(0);
        assertEquals(2, e1.getLine());
        assertEquals(30, e1.getPosition());
        assertEquals(2, e1.getEndLine());
        assertEquals(38, e1.getEndPosition());
    }
}
