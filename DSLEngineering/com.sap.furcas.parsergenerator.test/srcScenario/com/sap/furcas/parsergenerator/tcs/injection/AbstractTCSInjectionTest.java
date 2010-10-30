/**
 * 
 */
package com.sap.furcas.parsergenerator.tcs.injection;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import com.sap.furcas.metamodel.FURCAS.FURCASPackage;
import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.parsergenerator.emf.tcs.inject.ModelInjectionResult;
import com.sap.furcas.parsergenerator.emf.tcs.inject.TCSSpecificEMFModelInjector;
import com.sap.furcas.runtime.parser.exceptions.InvalidParserImplementationException;
import com.sap.furcas.runtime.parser.exceptions.UnknownProductionRuleException;

/**
 * Base class for syntax injection tests
 */
public abstract class AbstractTCSInjectionTest {

    // The set of EMF objects returned from parsing to EMF model
    protected static ConcreteSyntax syntax;
    protected static ModelInjectionResult modelParsingResult;

    protected static void setup(String tcsSampleDef) throws InvalidParserImplementationException, IOException, UnknownProductionRuleException {
        File sample = new File(tcsSampleDef);
        assertTrue(sample.exists());
        parseInputStream(new FileInputStream(sample));
        syntax = modelParsingResult.getSyntax();
    }

    protected static void parseInputStream(InputStream in) throws InvalidParserImplementationException, IOException,
            UnknownProductionRuleException {
        ResourceSet resourceSet = new ResourceSetImpl();
        resourceSet.getPackageRegistry().put(FURCASPackage.eNS_URI, FURCASPackage.eINSTANCE);
        resourceSet.getPackageRegistry().put(FURCASPackage.eNAME, FURCASPackage.eINSTANCE);
        Set<URI> referenceScope = Collections.emptySet();

        modelParsingResult = TCSSpecificEMFModelInjector.parseSyntaxDefinition(in, resourceSet, referenceScope,
                /* observer */ null);
    }

}
