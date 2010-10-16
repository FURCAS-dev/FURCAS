/*******************************************************************************
 * Copyright (c) 2008 SAP
 * see https://research.qkal.sap.corp/mediawiki/index.php/CoMONET
 * 
 * Date: $Date: 2008-10-30 16:47:01 +0100 (Do, 30 Okt 2008) $
 * Revision: $Revision: 2114 $
 * Author: $Author: c5107456 $
 *******************************************************************************/
package com.sap.furcas.runtime.parser.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.runtime.RecognitionException;

import com.sap.furcas.runtime.parser.IInjectionHelper;
import com.sap.furcas.runtime.parser.IModelAdapter;
import com.sap.furcas.runtime.parser.InjectionOptionsBean;


/**
 * provides basic functionality required in any Modelinjector
 */
public abstract class AbstractModelInjector implements IInjectionHelper {

    

    /** The model handler. */
    private IModelAdapter modelAdapter;


    /** static maintenance of element location mapping. */
    private final Map<Object, TextLocation> locationByElement = new HashMap<Object, TextLocation>();


    /** also relevant to subclasses */
    protected InjectionOptionsBean options;


    /** The error list. */
    private final List<ParsingError> errorList = new ArrayList<ParsingError>();

    /*used for better error messages on mismatchedTokenExceptions*/
    private final String[] parserTokens;


    /**
     * Instantiates a new tCS injector.
     * @param parserTokens 
     * @param newTokenFactory must not be null
     * 
     * @param modelHandler the model handler
     */
    public AbstractModelInjector(String[] parserTokens) {
        this.parserTokens = parserTokens;
    }


    /* (non-Javadoc)
     * @see com.sap.mi.textual.grammar.impl.IModelInjector#reportError(java.lang.Exception)
     */
    @Override
    public void reportError(RecognitionException e) {
        // TCS Handling of problem involves adding a Problem element to some separate "Problems" model
        // relying on ANTLR3 API for getting Exception messages
        RecognitionException re = e;
        ParsingError newError = ErrorMessageGenerator.getParsingError(re, parserTokens);
        addError(newError);
    }

    /**
     * 
     * @param newError
     */
    @Override
    public void addError(ParsingError newError) {
        errorList.add(newError);
    }


    /* (non-Javadoc)
     * @see com.sap.mi.textual.grammar.impl.IModelInjector#getErrorList()
     */
    @Override
    public List<ParsingError> getErrorList() {
        return errorList;
    }
    
    public Map<Object, TextLocation> getLocationsMap() {
        return locationByElement;
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see com.sap.mi.textual.grammar.impl.IModelInjector#setLocation(java.lang.Object,
     *      java.lang.String)
     */
    @Override
    public void setLocation(Object modelElement, TextLocation location) {
      
            locationByElement.put(modelElement, location);
        }



    /**
     * @param bean
     */
    public void setOptions(InjectionOptionsBean optionsBean) {
        this.options = optionsBean;
    }
    
    /**
     * 
     * @return
     */
    public IModelAdapter getModelAdapter() {
        return modelAdapter;
    }

    public void setModelAdapter(IModelAdapter modelAdapter) {
        this.modelAdapter = modelAdapter;
    }
    

 
}
