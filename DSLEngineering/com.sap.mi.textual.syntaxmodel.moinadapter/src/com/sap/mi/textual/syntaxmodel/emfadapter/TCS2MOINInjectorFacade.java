/*******************************************************************************
 * Copyright (c) 2008 SAP
 * see https://research.qkal.sap.corp/mediawiki/index.php/CoMONET
 * 
 * Date: $Date: 2008-04-07 18:17:27 +0200 (Mo, 07 Apr 2008) $
 * @version $Revision: 810 $
 * @author: $Author: c5107456 $
 *******************************************************************************/
package com.sap.mi.textual.syntaxmodel.emfadapter;

import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.sap.mi.textual.grammar.ModelParsingResult;
import com.sap.mi.textual.grammar.ParserFacade;
import com.sap.mi.textual.grammar.exceptions.InvalidParserImplementationException;
import com.sap.mi.textual.grammar.exceptions.UnknownProductionRuleException;
import com.sap.mi.textual.grammar.impl.DefaultTextAwareModelAdapter;
import com.sap.mi.textual.grammar.impl.IParsingObserver;
import com.sap.mi.textual.grammar.parser.TCSLexer;
import com.sap.mi.textual.grammar.parser.TCSParser;


/**
 * parses TCS file and injects into MOIN runtime model.
 * 
 * @author C5107456
 */
public class TCS2MOINInjectorFacade {
	// This file is a specific non-generic Injector, as the ModelHandler used
	// can only inject models that are instances of the TCS Syntax definition
	// metamodel.

	/**
	 * Parse the syntax definition using the current versino of TCSParser and
	 * TCSLexer.
	 */
	public static ModelInjectionResult parseSyntaxDefinition(InputStream in,
			ResourceSet connection, Set<URI> metamodelPRIs,
			IParsingObserver observer)
			throws InvalidParserImplementationException, IOException,
			UnknownProductionRuleException {
		return parseSyntaxDefinition(in, connection, metamodelPRIs, observer,
				null);
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
	public static ModelInjectionResult parseSyntaxDefinition(InputStream in,
			ResourceSet connection, Set<URI> metamodelPRIs,
			IParsingObserver observer, ParserFacade alternativeTcsParserFacade)
			throws InvalidParserImplementationException, IOException,
			UnknownProductionRuleException {
		// use a model Handler that is implemented in EMF and only handles TCS
		// models
		EMFTCSAdapter handler = null;
		ModelParsingResult result;
		try {
			DefaultTextAwareModelAdapter handlerWrapper;
			if (connection != null) {
				if (true /*connection.isAlive()*/) {
					handler = new EMFTCSAdapter(connection, metamodelPRIs);
					handlerWrapper = new DefaultTextAwareModelAdapter(handler);
				} else {
					throw new IllegalArgumentException(
							"Connection is not alive.");
				}
			} else {
				throw new IllegalArgumentException("Connection is null.");
				// handler = new MOINTCSAdapter();
			}
			if (alternativeTcsParserFacade != null) {
				result = alternativeTcsParserFacade.parseProductionRule(in,
						handlerWrapper, null, null, observer);

			} else {
				// use most recent version of TCSParser and Lexer
				ParserFacade tcsParserFacade = new ParserFacade(
						TCSParser.class, TCSLexer.class);
				result = tcsParserFacade.parseProductionRule(in,
						handlerWrapper, null, null, observer);
			}

		} finally {
			if (handler != null) {

				// handler.close();

			}
		}

		return new ModelInjectionResult(handler, result);
	}

}
