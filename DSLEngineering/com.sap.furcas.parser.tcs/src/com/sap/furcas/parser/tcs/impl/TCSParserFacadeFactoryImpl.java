package com.sap.furcas.parser.tcs.impl;

import org.antlr.runtime.Lexer;

import com.sap.furcas.parser.tcs.TCSParserFacadeFactory;
import com.sap.furcas.runtime.parser.ParserFacade;
import com.sap.furcas.runtime.parser.exceptions.InvalidParserImplementationException;
import com.sap.furcas.runtime.parser.impl.ObservableInjectingParser;

public class TCSParserFacadeFactoryImpl implements TCSParserFacadeFactory {

    @Override
    public ParserFacade createTCSParserFacade() throws InvalidParserImplementationException {
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
                    (Class<? extends ObservableInjectingParser>) Class.forName("generated.TCSParser"),
                    (Class<? extends Lexer>) Class.forName("generated.TCSLexer"), /* language name */ "TCS");
        } catch (ClassNotFoundException e) {
            throw new InvalidParserImplementationException(e);
        }
    }

    private ParserFacade createStableFacade() throws InvalidParserImplementationException {
        return new ParserFacade(
                com.sap.furcas.parser.tcs.stable.TCSParser.class,
                com.sap.furcas.parser.tcs.stable.TCSLexer.class, /* language name */ "TCS");
    }

}
