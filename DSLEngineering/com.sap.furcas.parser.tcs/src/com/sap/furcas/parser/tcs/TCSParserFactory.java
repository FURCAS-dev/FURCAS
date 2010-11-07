package com.sap.furcas.parser.tcs;

import com.sap.furcas.parser.tcs.impl.TCSParserFactoryImpl;
import com.sap.furcas.runtime.parser.ParserFacade;
import com.sap.furcas.runtime.parser.exceptions.InvalidParserImplementationException;

public interface TCSParserFactory {

    public TCSParserFactory INSTANCE = new TCSParserFactoryImpl();
    
    public ParserFacade createTCSParserFacade() throws InvalidParserImplementationException;
    
}
