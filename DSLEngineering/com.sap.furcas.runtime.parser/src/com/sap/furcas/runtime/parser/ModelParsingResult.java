/*******************************************************************************
 * Copyright (c) 2008 SAP
 * see https://research.qkal.sap.corp/mediawiki/index.php/CoMONET
 * 
 * Date: $Date: 2009-08-30 09:59:50 +0200 (So, 30 Aug 2009) $
 * Revision: $Revision: 7772 $
 * Author: $Author: c5127705 $
 *******************************************************************************/
package com.sap.furcas.runtime.parser;

import java.util.List;
import java.util.Map;

import com.sap.furcas.runtime.parser.impl.ParsingError;
import com.sap.furcas.runtime.parser.impl.TextLocation;



/**
 * wraps different results from parsing (i.e. errors, hyperlinks, locations, warnings).
 * 
 * @author C5107456
 */
public class ModelParsingResult {

	
	/** The errors. */
	private final List<ParsingError> errors;

	/** The locations map. */
    private final Map<Object, TextLocation> locationMap;

    private Object parsedModelElement;
	

	/**
     * @return the parsedModelElement
     */
    public Object getParsedModelElement() {
        return parsedModelElement;
    }

    /**
     * @param parsedModelElement the parsedModelElement to set
     */
    public void setParsedModelElement(Object parsedModelElement) {
        this.parsedModelElement = parsedModelElement;
    }

    /**
     * @param parsedModelElement 
	 * @param errors2
     * @param locationMap
     */
    public ModelParsingResult(Object parsedModelElement, List<ParsingError> parsingErrors,
            Map<Object, TextLocation> locationMap) {
        this.parsedModelElement = parsedModelElement;
        this.errors = parsingErrors;
        this.locationMap = locationMap;
    }

    /**
	 * Gets the errors.
	 * 
	 * @return the errors
	 */
	public List<ParsingError> getErrors() {
		return errors;
	}
	
	public Map<Object, TextLocation> getLocationMap() {
	    return locationMap;
	}
}
