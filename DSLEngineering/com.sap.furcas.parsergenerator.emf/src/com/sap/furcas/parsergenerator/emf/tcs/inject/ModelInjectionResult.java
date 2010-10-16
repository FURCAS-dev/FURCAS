/*******************************************************************************
 * Copyright (c) 2008 SAP
 * see https://research.qkal.sap.corp/mediawiki/index.php/CoMONET
 * 
 * Date: $Date: 2008-04-10 13:55:39 +0200 (Do, 10 Apr 2008) $
 * @version $Revision: 858 $
 * @author: $Author: c5107456 $
 *******************************************************************************/
package com.sap.furcas.parsergenerator.emf.tcs.inject;

import java.util.Set;

import com.sap.furcas.metamodel.TCS.ConcreteSyntax;
import com.sap.furcas.metamodel.TCS.Keyword;
import com.sap.furcas.runtime.parser.ModelParsingResult;

/**
 *
 */
public class ModelInjectionResult {

    private final ModelParsingResult result;
    private final TCSSpecificEMFModelAdapter handler;

    /**
     * @param handler
     * @param result
     */
    ModelInjectionResult(TCSSpecificEMFModelAdapter handler, ModelParsingResult result) {
	this.handler = handler;
	this.result = result;
    }

    public ModelParsingResult getResult() {
	return result;
    }

    public ConcreteSyntax getSyntax() {
	ConcreteSyntax syntax = null;
	Set<Object> set = handler.getElementsByType("TCS::ConcreteSyntax");
	if (set != null) {
	    if (set.size() != 1) {
		System.out.println("Warning: More than one syntax in ModelInjectionResult (" + set.size() + " present)");
	    }
	    syntax = (ConcreteSyntax) set.iterator().next();
	}
	return syntax;
    }

    @SuppressWarnings("unchecked")
    public Set<Keyword> getKeywords() {
	Set<?> set = handler.getElementsByType("TCS::Keyword");
	return (Set<Keyword>) set;
    }

}
