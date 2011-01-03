package com.sap.furcas.parser.tcs;

import com.sap.furcas.parser.tcs.impl.TCSParserFacadeFactoryImpl;
import com.sap.furcas.runtime.parser.ParserFacade;
import com.sap.furcas.runtime.parser.exceptions.InvalidParserImplementationException;

public interface TCSParserFacadeFactory {

    public TCSParserFacadeFactory INSTANCE = new TCSParserFacadeFactoryImpl();
    
    public ParserFacade createTCSParserFacade() throws InvalidParserImplementationException;
    
}
