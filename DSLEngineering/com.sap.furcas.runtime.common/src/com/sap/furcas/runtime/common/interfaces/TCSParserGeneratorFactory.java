package com.sap.furcas.runtime.common.interfaces;

import com.sap.furcas.runtime.common.exceptions.ParserGeneratorInvocationException;
import com.sap.furcas.runtime.common.implementation.TCSParserGeneratorFactoryImpl;


/**
 * Used to create a TCSParserGenerator.
 * 
 * @author Sebastian Schlag (D049672)
 *
 */

public interface TCSParserGeneratorFactory {
    static TCSParserGeneratorFactory INSTANCE = new TCSParserGeneratorFactoryImpl();

    TCSParserGenerator createTCSParserGenerator() throws ParserGeneratorInvocationException;

}
