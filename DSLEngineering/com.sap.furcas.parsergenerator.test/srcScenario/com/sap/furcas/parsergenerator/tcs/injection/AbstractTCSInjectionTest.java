/**
 * 
 */
package com.sap.furcas.parsergenerator.tcs.injection;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.parsergenerator.emf.tcs.inject.ModelInjectionResult;
import com.sap.furcas.parsergenerator.emf.tcs.inject.TCSSpecificEMFModelInjector;
import com.sap.furcas.runtime.common.exceptions.ModelAdapterException;
import com.sap.furcas.runtime.parser.exceptions.InvalidParserImplementationException;
import com.sap.furcas.runtime.parser.exceptions.UnknownProductionRuleException;


/**
 * Base class for syntax injection tests
 */
public abstract class AbstractTCSInjectionTest {

    // The set of EMF objects returned from parsing to EMF model
    protected static ConcreteSyntax syntax;
    protected static ModelInjectionResult modelParsingResult;
    
    protected static void setup(String tcsSampleDef) throws InvalidParserImplementationException, IOException, UnknownProductionRuleException, ModelAdapterException {
        File sample = new File(tcsSampleDef);
        assertTrue(sample.exists());
        InputStream in = new FileInputStream(sample);

        ResourceSet resourceSet = new ResourceSetImpl();
        modelParsingResult = TCSSpecificEMFModelInjector.parseSyntaxDefinition(in, resourceSet, null, null);
        syntax = modelParsingResult.getSyntax();
    }
    
}
