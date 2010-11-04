package com.sap.furcas.runtime.common.interfaces;

import com.sap.furcas.runtime.common.exceptions.ParserGeneratorInvocationException;
import com.sap.furcas.runtime.common.implementation.TCSParserGeneratorFactoryImpl;


/**
 * Factory for {@link TCSParserGenerator} instances.
 * 
 * @author Sebastian Schlag (D049672)
 *
 */

public interface TCSParserGeneratorFactory {
    
    public static TCSParserGeneratorFactory INSTANCE = new TCSParserGeneratorFactoryImpl();

    public TCSParserGenerator createTCSParserGenerator() throws ParserGeneratorInvocationException;

}
