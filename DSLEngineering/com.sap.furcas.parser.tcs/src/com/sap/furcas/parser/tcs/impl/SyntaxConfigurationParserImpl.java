package com.sap.furcas.parser.tcs.impl;

import org.antlr.runtime.Lexer;

import com.sap.furcas.parser.tcs.SyntaxConfigurationParserFactory;
import com.sap.furcas.runtime.parser.ParserFacade;
import com.sap.furcas.runtime.parser.exceptions.InvalidParserImplementationException;
import com.sap.furcas.runtime.parser.impl.ObservableInjectingParser;

public class SyntaxConfigurationParserImpl implements SyntaxConfigurationParserFactory {
	@Override
	 public ParserFacade createSyntaxConfigurationParserFacade() throws InvalidParserImplementationException {
	        if (runUnstableBootstrappedVersion()) {
	            return createBootstrappedFacade();
	        } else {
	            return createStableFacade();
	        }
	    }

	    private boolean runUnstableBootstrappedVersion() {
	        return "true".equals(System.getProperty("useBootstrappedTCSParser"));
	    }

	    @SuppressWarnings("unchecked")
	    private ParserFacade createBootstrappedFacade() throws InvalidParserImplementationException {
	        try {
	            return new ParserFacade(
	                    (Class<? extends ObservableInjectingParser>) Class.forName("generated.SyntaxConfigurationParser"),
	                    (Class<? extends Lexer>) Class.forName("generated.SyntaxConfigurationLexer"));
	        } catch (ClassNotFoundException e) {
	            throw new InvalidParserImplementationException(e);
	        }
	    }

	    private ParserFacade createStableFacade() throws InvalidParserImplementationException {
	        return new ParserFacade(
	                com.sap.furcas.parser.tcs.stable.SyntaxConfigurationParser.class,
	                com.sap.furcas.parser.tcs.stable.SyntaxConfigurationLexer.class);
	    }

}
