package com.sap.mi.textual.test.tcf2emf;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Test;

import com.sap.mi.textual.grammar.impl.ParsingError;
import com.sap.mi.textual.moin.standalone.MOINTCSMetaConnectionProvider;
import com.sap.mi.textual.syntaxmodel.emfadapter.ModelInjectionResult;
import com.sap.mi.textual.syntaxmodel.emfadapter.TCS2MOINInjectorFacade;
import com.sap.tc.moin.repository.Connection;


public class TestInvalidSyntaxes  extends AbstractTCSInjectionTest {

    @Test
    public void testInvalidKeywordSyntax() throws Exception {
        String invalidSample = "symtax invalid{}";
        InputStream in = new ByteArrayInputStream(invalidSample.getBytes());
        TCS2MOINInjectorFacade injector = new TCS2MOINInjectorFacade();// By choosing this injector, we establish the dependency to EMF.
        Connection con = MOINTCSMetaConnectionProvider.getTestConnection();
        ModelInjectionResult modelParsingResult = injector.parseSyntaxDefinition(in, con, null, null);
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
        InputStream in = new ByteArrayInputStream(invalidSample.getBytes());
        
        Connection con = MOINTCSMetaConnectionProvider.getTestConnection();
        ModelInjectionResult modelParsingResult = TCS2MOINInjectorFacade.parseSyntaxDefinition(in, con, null, null);
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
            +"template Attribute abstract;"
            +"}";
        InputStream in = new ByteArrayInputStream(invalidSample.getBytes());

        Connection con = MOINTCSMetaConnectionProvider.getTestConnection();
        ModelInjectionResult modelParsingResult = TCS2MOINInjectorFacade.parseSyntaxDefinition(in, con, null, null);
        assertNotNull(modelParsingResult);
        assertNotNull(modelParsingResult.getResult().getErrors());
        assertEquals(2, modelParsingResult.getResult().getErrors().size());
    }

    @Test
    public void testNoAlt() throws Exception {
        String invalidSample = "syntax MyLanguage { \n"
            +"template ->Attribute abstract abstract;\n"
            +"}";
        InputStream in = new ByteArrayInputStream(invalidSample.getBytes());

        Connection con = MOINTCSMetaConnectionProvider.getTestConnection();
        ModelInjectionResult modelParsingResult = TCS2MOINInjectorFacade.parseSyntaxDefinition(in, con, null, null);
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
