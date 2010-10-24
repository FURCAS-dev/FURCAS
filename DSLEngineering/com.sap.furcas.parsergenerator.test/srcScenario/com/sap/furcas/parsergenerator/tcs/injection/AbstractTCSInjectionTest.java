/**
 * 
 */
package com.sap.furcas.parsergenerator.tcs.injection;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

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
    
    static {
        MoinContext.setMoin(MOINTCSMetaConnectionProvider.getBuildMoin());
    }
    
    
    protected static void setup(String tcsSampleDef) throws InvalidParserImplementationException, IOException, UnknownProductionRuleException, ModelAdapterException {
        File sample = new File(tcsSampleDef);
        assertTrue(sample.exists());
        InputStream in = new FileInputStream(sample);

        Connection con = MOINTCSMetaConnectionProvider.getTestConnection();
        modelParsingResult = TCSSpecificEMFModelInjector.parseSyntaxDefinition(in, con, null, null);
        syntax = modelParsingResult.getSyntax();
    }
    
}
