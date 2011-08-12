/**
 * 
 */
package com.sap.furcas.parsergenerator.tcs.injection;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.sap.furcas.metamodel.FURCAS.TCS.ConcreteSyntax;
import com.sap.furcas.parsergenerator.emf.tcs.inject.TCSSpecificEMFModelInjector;
import com.sap.furcas.runtime.common.exceptions.MetaModelLookupException;
import com.sap.furcas.runtime.common.util.FileResourceHelper;
import com.sap.furcas.runtime.parser.ModelParsingResult;
import com.sap.furcas.runtime.parser.exceptions.InvalidParserImplementationException;
import com.sap.furcas.runtime.parser.exceptions.UnknownProductionRuleException;
import com.sap.furcas.test.testutils.ResourceTestHelper;

/**
 * Base class for syntax injection tests
 */
public abstract class AbstractTCSInjectionTest {

    // The set of EMF objects returned from parsing to EMF model
    protected static ConcreteSyntax syntax;
    protected static ModelParsingResult modelParsingResult;

    protected static void setup(File tcs, File... metamodel) throws InvalidParserImplementationException, IOException, UnknownProductionRuleException, MetaModelLookupException {
        ResourceSet resourceSet = FileResourceHelper.loadResourceSet(metamodel);
        Set<URI> referenceScope = ResourceTestHelper.createEcoreReferenceScope();

        modelParsingResult = TCSSpecificEMFModelInjector.parseSyntaxDefinition(new FileInputStream(tcs),
                resourceSet, referenceScope, /*observer*/ null);
        
        syntax = (ConcreteSyntax) modelParsingResult.getParsedModelElement();
    }
    
    protected void parseInputStream(InputStream in) throws InvalidParserImplementationException, IOException, UnknownProductionRuleException {
        ResourceSet resourceSet = ResourceTestHelper.createResourceSet();
        Set<URI> referenceScope = ResourceTestHelper.createFURCASReferenceScope();
        
        modelParsingResult = TCSSpecificEMFModelInjector.parseSyntaxDefinition(in,
                resourceSet, referenceScope, /*observer*/ null);
        
    }


}
