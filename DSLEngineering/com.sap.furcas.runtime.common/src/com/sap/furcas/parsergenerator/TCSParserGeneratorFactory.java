package com.sap.furcas.parsergenerator;

import com.sap.furcas.parsergenerator.impl.TCSParserGeneratorFactoryImpl;
import com.sap.furcas.runtime.common.exceptions.ParserGeneratorInvocationException;


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
