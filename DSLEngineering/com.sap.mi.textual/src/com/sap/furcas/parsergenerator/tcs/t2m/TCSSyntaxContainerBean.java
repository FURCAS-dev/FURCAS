/*******************************************************************************
 * Copyright (c) 2008 SAP
 * see https://research.qkal.sap.corp/mediawiki/index.php/CoMONET
 * 
 * Date: $Date: 2009-04-23 14:54:43 +0200 (Do, 23 Apr 2009) $
 * @version $Revision: 6272 $
 * @author: $Author: c5106462 $
 *******************************************************************************/
package com.sap.furcas.parsergenerator.tcs.t2m;

import java.util.Map;
import java.util.Set;

import com.sap.furcas.metamodel.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.TCS.Keyword;
import com.sap.furcas.runtime.parser.impl.TextLocation;


/**
 * Data Object to transport a syntax definition and the keywords used in that syntax.
 * 
 * @author C5107456
 */
public class TCSSyntaxContainerBean {
	
	/** The keywords. */
	private Set<Keyword> keywords;
	
	/** The syntax. */
	private ConcreteSyntax syntax;
	
	private Map<Object, TextLocation> elementToLocationMap;
	
	/**
	 * Gets the keywords.
	 * 
	 * @return the keywords
	 */
	public Set<Keyword> getKeywords() {
		return keywords;
	}
	
	/**
	 * Sets the keywords.
	 * 
	 * @param keywords the new keywords
	 */
	public void setKeywords(Set<Keyword> keywords) {
		this.keywords = keywords;
	}
	
	/**
	 * Gets the syntax.
	 * 
	 * @return the syntax
	 */
	public ConcreteSyntax getSyntax() {
		return syntax;
	}
	
	/**
	 * Sets the syntax.
	 * 
	 * @param syntax the new syntax
	 */
	public void setSyntax(ConcreteSyntax syntax) {
		this.syntax = syntax;
	}

    public Map<Object, TextLocation> getElementToLocationMap() {
        return elementToLocationMap;
    }

    public void setElementToLocationMap(
            Map<Object, TextLocation> elementToLocationMap) {
        this.elementToLocationMap = elementToLocationMap;
    }
	

	
}
