/*******************************************************************************
 * Copyright (c) 2008 SAP
 * see https://research.qkal.sap.corp/mediawiki/index.php/CoMONET
 * 
 * Date: $Date: 2009-04-23 14:54:43 +0200 (Do, 23 Apr 2009) $
 * Revision: $Revision: 6272 $
 * Author: $Author: c5106462 $
 *******************************************************************************/
package com.sap.furcas.runtime.parser;


/**
 * stores Options to pass to the ParserFacade for non-default parsing / Injecting.
 */
public class InjectionOptionsBean {

    /**
     * determines if Injector will try to store location String as Model property of a given model element
     */
    private boolean storeLocationsInModel = false;
    
    /**
     * if (storeLocationsInModel) will store location string in property of this name
     */
    private String locationsPropertyNameInModel = null;

    public boolean isStoreLocationsInModel() {
        return storeLocationsInModel;
    }


    public String getLocationsPropertyNameInModel() {
        return locationsPropertyNameInModel;
    }

    public void setLocationsPropertyNameInModel(boolean storeLocationsInModel, String locationsPropertyNameInModel) {
        this.storeLocationsInModel = storeLocationsInModel;
        if (storeLocationsInModel && locationsPropertyNameInModel == null) {
            throw new IllegalArgumentException("Bug: Cannot store location in Model without model property to store in.");
        }
        this.locationsPropertyNameInModel = locationsPropertyNameInModel;
    }

    
    
}
