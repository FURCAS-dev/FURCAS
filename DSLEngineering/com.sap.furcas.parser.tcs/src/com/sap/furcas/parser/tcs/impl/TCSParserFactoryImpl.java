package com.sap.furcas.parser.tcs.impl;

import com.sap.furcas.parser.tcs.TCSParserFactory;
import com.sap.furcas.runtime.parser.ParserFacade;
import com.sap.furcas.runtime.parser.exceptions.InvalidParserImplementationException;

public class TCSParserFactoryImpl implements TCSParserFactory {

    @Override
    public ParserFacade createTCSParserFacade() throws InvalidParserImplementationException {
        // TODO: make it configurable whether a stable or an unstable version is used        
        return new ParserFacade(
                com.sap.furcas.parser.tcs.stable.TCSParser.class,
                com.sap.furcas.parser.tcs.stable.TCSLexer.class, /* syntax */ null); // ConcreteSyntax object not known yet
    }

}
