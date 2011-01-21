package com.sap.furcas.parser.tcs;

import com.sap.furcas.parser.tcs.impl.SyntaxConfigurationParserImpl;
import com.sap.furcas.parser.tcs.impl.TCSParserFactoryImpl;
import com.sap.furcas.runtime.parser.ParserFacade;
import com.sap.furcas.runtime.parser.exceptions.InvalidParserImplementationException;

public interface SyntaxConfigurationParserFactory {

	public SyntaxConfigurationParserFactory INSTANCE = new SyntaxConfigurationParserImpl();

	public ParserFacade createSyntaxConfigurationParserFacade()
			throws InvalidParserImplementationException;
}
