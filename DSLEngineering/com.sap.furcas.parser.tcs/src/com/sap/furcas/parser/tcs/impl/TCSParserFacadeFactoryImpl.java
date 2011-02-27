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
    
    private ParserFacade createBootstrappedFacade() throws InvalidParserImplementationException {
        try {
            return new ParserFacade(loadParserClass(), loadLexerClass(), /* language name */ "TCS");
        } catch (ClassNotFoundException e) {
            throw new InvalidParserImplementationException(e);
        }
    }
    
    @SuppressWarnings("unchecked")
    private Class<? extends Lexer> loadLexerClass() throws ClassNotFoundException {
        return (Class<? extends Lexer>) Class.forName("generated.TCSLexer");
    }

    @SuppressWarnings("unchecked")
    private Class<? extends ObservableInjectingParser> loadParserClass() throws ClassNotFoundException {
        return (Class<? extends ObservableInjectingParser>) Class.forName("generated.TCSParser");
    }

    private ParserFacade createStableFacade() throws InvalidParserImplementationException {
        return new ParserFacade(
                com.sap.furcas.parser.tcs.stable.TCSParser.class,
                com.sap.furcas.parser.tcs.stable.TCSLexer.class, /* language name */ "TCS");
    }

}
