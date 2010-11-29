/*******************************************************************************
 * Copyright (c) 2008 SAP
 * see https://research.qkal.sap.corp/mediawiki/index.php/CoMONET
 * 
 * Date: $Date: 2008-09-25 16:24:43 +0200 (Do, 25 Sep 2008) $
 * Revision: $Revision: 1893 $
 * Author: $Author: c5107456 $
 *******************************************************************************/
package com.sap.furcas.runtime.common.interfaces;

import java.util.List;

import com.sap.furcas.runtime.common.exceptions.ModelAdapterException;

/**
 * provides methods to investigate modelElements, abstracts from specific metamodel implementations.
 */
public interface IModelElementInvestigator {

    /**
     * Gets the property of an model element.
     * Returns a Collection for multivalued properties.
     * 
     * @param ame_ the ame_
     * @param propertyName the property name
     * 
     * @return the object
     * 
     * @throws ModelAdapterException the model handler exception
     */
    Object get(Object modelElement, String propertyName) throws ModelAdapterException;

    /**
     * Checks that instance is an instance of the Type.
     * 
     * @param instance the instance
     * @param typeName the type name
     * 
     * @return true, if successful
     * 
     * @throws ModelAdapterException the model handler exception
     */
    boolean instanceOf(Object instance, Object metaType) throws ModelAdapterException;

    Object getMetaType(List<String> typeName) throws ModelAdapterException;

}
