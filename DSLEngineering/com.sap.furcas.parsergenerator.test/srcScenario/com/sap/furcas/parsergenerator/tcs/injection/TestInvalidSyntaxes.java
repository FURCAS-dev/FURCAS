package com.sap.furcas.parsergenerator.tcs.injection;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.junit.Test;

import com.sap.furcas.parsergenerator.emf.tcs.inject.ModelInjectionResult;
import com.sap.furcas.parsergenerator.emf.tcs.inject.TCSSpecificEMFModelInjector;
import com.sap.furcas.runtime.parser.impl.ParsingError;

;


public class TestInvalidSyntaxes  extends AbstractTCSInjectionTest {

    @Test
    public void testInvalidKeywordSyntax() throws Exception {
        String invalidSample = "symtax invalid{}";
        InputStream in = new ByteArrayInputStream(invalidSample.getBytes());
        TCSSpecificEMFModelInjector injector = new TCSSpecificEMFModelInjector();// By choosing this injector, we establish the dependency to EMF.
        ResourceSet resourceSet = new ResourceSetImpl();
        ModelInjectionResult modelParsingResult = injector.parseSyntaxDefinition(in, resourceSet, null, null);
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
        
        ResourceSet resourceSet = new ResourceSetImpl();
        ModelInjectionResult modelParsingResult = TCSSpecificEMFModelInjector.parseSyntaxDefinition(in, resourceSet, null, null);
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

        ResourceSet resourceSet = new ResourceSetImpl();
        ModelInjectionResult modelParsingResult = TCSSpecificEMFModelInjector.parseSyntaxDefinition(in, resourceSet, null, null);
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

        ResourceSet resourceSet = new ResourceSetImpl();
        ModelInjectionResult modelParsingResult = TCSSpecificEMFModelInjector.parseSyntaxDefinition(in, resourceSet, null, null);
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
