/*******************************************************************************
 * Copyright (c) 2008 SAP
 * see https://research.qkal.sap.corp/mediawiki/index.php/CoMONET
 * 
 * Date: $Date: 2008-09-25 16:24:43 +0200 (Do, 25 Sep 2008) $
 * Revision: $Revision: 1893 $
 * Author: $Author: c5107456 $
 *******************************************************************************/
package com.sap.furcas.runtime.parser;

import java.util.List;

import org.antlr.runtime.RecognitionException;




/**
 * A parsing helper supports the process of parsing a DSL sample 
 * by providing error reporting and a token factory.
 */
public interface IInjectionHelper {

	/**
	 * reports an error during the injection process (adds to the list which is returned by getErrorList).
	 * @param e
	 */
	void reportError(RecognitionException e);

	 void addError(ParsingError newError);
	
	/**
	 * returns parsing errors collected so far, that the parser found recoverable (else would have been thrown).
	 * @return
	 */
	List<ParsingError> getErrorList();

    /**
     * tells the injector to associate the model element to that text location
     * @param ro
     * @param location
     */
    void setLocation(Object modelElement, TextLocation location);
    

}

