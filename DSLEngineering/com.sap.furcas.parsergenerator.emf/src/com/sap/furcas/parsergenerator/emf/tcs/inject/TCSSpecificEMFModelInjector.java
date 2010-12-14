/*******************************************************************************
 * Copyright (c) 2008 SAP
 * see https://research.qkal.sap.corp/mediawiki/index.php/CoMONET
 * 
 * Date: $Date: 2008-04-07 18:17:27 +0200 (Mo, 07 Apr 2008) $
 * @version $Revision: 810 $
 * @author: $Author: c5107456 $
 *******************************************************************************/
package com.sap.furcas.parsergenerator.emf.tcs.inject;

import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.sap.furcas.parser.tcs.TCSParserFactory;
import com.sap.furcas.runtime.parser.IParsingObserver;
import com.sap.furcas.runtime.parser.ModelParsingResult;
import com.sap.furcas.runtime.parser.ParserFacade;
import com.sap.furcas.runtime.parser.exceptions.InvalidParserImplementationException;
import com.sap.furcas.runtime.parser.exceptions.UnknownProductionRuleException;
import com.sap.furcas.runtime.parser.impl.DefaultTextAwareModelAdapter;

/**
 * Parses a TCS file and injects the syntax definition into an EMF runtime model.
 * 
 * @author C5107456
 */
public class TCSSpecificEMFModelInjector {
    // This file is a specific non-generic Injector, as the ModelHandler used
    // can only inject models that are instances of the TCS Syntax definition
    // metamodel.

    /**
     * Parse the syntax definition using the stable version of the TCSParser and TCSLexer.
     */
    public static ModelInjectionResult parseSyntaxDefinition(InputStream in, ResourceSet resourceSet, Set<URI> referenceScope,
	    IParsingObserver observer) throws InvalidParserImplementationException, IOException, UnknownProductionRuleException {
        
        ParserFacade tcsParserFacade = TCSParserFactory.INSTANCE.createTCSParserFacade();
	return parseSyntaxDefinition(in, resourceSet, referenceScope, observer, tcsParserFacade);
    }

    /**
     * Parse the syntax definition using the given version of the TCSParser and TCSLexer.
     */
    public static ModelInjectionResult parseSyntaxDefinition(InputStream in, ResourceSet resourceSet, Set<URI> referenceScope,
	    IParsingObserver observer, ParserFacade tcsParserFacade) throws IOException, UnknownProductionRuleException {
        
	// use a model Handler that is implemented in EMF and only handles TCS models
	TCSSpecificEMFModelAdapter handler = new TCSSpecificEMFModelAdapter(resourceSet, referenceScope);
	
	try {
	    DefaultTextAwareModelAdapter handlerWrapper = new DefaultTextAwareModelAdapter(handler);
	    ModelParsingResult result = tcsParserFacade.parseProductionRule(in, handlerWrapper, null, null, observer);
	    return new ModelInjectionResult(handler, result);
	} finally {
	    handler.close();
	}

    }

}
