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

import com.sap.furcas.parser.tcs.bootstrapped.TCSLexer;
import com.sap.furcas.parser.tcs.bootstrapped.TCSParser;
import com.sap.furcas.runtime.parser.IParsingObserver;
import com.sap.furcas.runtime.parser.ModelParsingResult;
import com.sap.furcas.runtime.parser.ParserFacade;
import com.sap.furcas.runtime.parser.exceptions.InvalidParserImplementationException;
import com.sap.furcas.runtime.parser.exceptions.UnknownProductionRuleException;
import com.sap.furcas.runtime.parser.impl.DefaultTextAwareModelAdapter;

/**
 * parses TCS file and injects into MOIN runtime model.
 * 
 * @author C5107456
 */
public class TCSSpecificEMFModelInjector {
    // This file is a specific non-generic Injector, as the ModelHandler used
    // can only inject models that are instances of the TCS Syntax definition
    // metamodel.

    /**
     * Parse the syntax definition using the current version of TCSParser and
     * TCSLexer.
     */
    public static ModelInjectionResult parseSyntaxDefinition(InputStream in, ResourceSet resourceSet, Set<URI> metamodelPRIs,
	    IParsingObserver observer) throws InvalidParserImplementationException, IOException, UnknownProductionRuleException {
	return parseSyntaxDefinition(in, resourceSet, metamodelPRIs, observer, null);
    }

    /**
     * Parses the syntax definition.
     * 
     * @param in
     *            the in
     * @param metamodelPRIs
     * @param observer
     * @param alternativeTcsParserFacade
     *            parser facade initialized with a version of TCSParser and
     *            TCSLexer (useful to keep the parser stable for testing) or
     *            null to use the most current version of TCSParser and TCSLexer
     * 
     * @return the model parsing result
     * @throws InvalidParserImplementationException
     * @throws UnknownProductionRuleException
     * @throws IOException
     */
    public static ModelInjectionResult parseSyntaxDefinition(InputStream in, ResourceSet resourceSet, Set<URI> metamodelPRIs,
	    IParsingObserver observer, ParserFacade alternativeTcsParserFacade) throws InvalidParserImplementationException,
	    IOException, UnknownProductionRuleException {
	// use a model Handler that is implemented in EMF and only handles TCS
	// models
	TCSSpecificEMFModelAdapter handler = null;
	ModelParsingResult result;
	try {
	    handler = new TCSSpecificEMFModelAdapter(resourceSet, metamodelPRIs);
	    DefaultTextAwareModelAdapter handlerWrapper = new DefaultTextAwareModelAdapter(handler);

	    if (alternativeTcsParserFacade != null) {
		result = alternativeTcsParserFacade.parseProductionRule(in, handlerWrapper, null, null, observer);

	    } else {
		// use most recent version of TCSParser and Lexer
		ParserFacade tcsParserFacade = new ParserFacade(TCSParser.class, TCSLexer.class);
		result = tcsParserFacade.parseProductionRule(in, handlerWrapper, null, null, observer);
	    }

	} finally {
	    if (handler != null) {

		// handler.close();

	    }
	}

	return new ModelInjectionResult(handler, result);
    }

}
