/**
 * 
 */
package com.sap.mi.textual.test.tcf2emf;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import tcs.ConcreteSyntax;

import com.sap.furcas.textual.common.exceptions.ModelAdapterException;
import com.sap.mi.textual.grammar.exceptions.InvalidParserImplementationException;
import com.sap.mi.textual.grammar.exceptions.UnknownProductionRuleException;
import com.sap.mi.textual.moin.standalone.MOINTCSMetaConnectionProvider;
import com.sap.mi.textual.syntaxmodel.emfadapter.ModelInjectionResult;
import com.sap.mi.textual.syntaxmodel.emfadapter.MoinContext;
import com.sap.mi.textual.syntaxmodel.emfadapter.TCS2MOINInjectorFacade;
import com.sap.tc.moin.repository.Connection;

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
        modelParsingResult = TCS2MOINInjectorFacade.parseSyntaxDefinition(in, con, null, null);
        syntax = modelParsingResult.getSyntax();
    }
    
}
