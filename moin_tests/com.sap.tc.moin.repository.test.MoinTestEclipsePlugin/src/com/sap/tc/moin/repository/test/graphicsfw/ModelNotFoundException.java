/*
 * Created on 30.01.2006
 *
 */
package com.sap.tc.moin.repository.test.graphicsfw;

/**
 * This exception is thrown when a model wasn't found on the persistece
 * 
 * @author d043982
 *
 */
public class ModelNotFoundException extends Exception {

    /**
     * @param mofId MofId of the element that wasn't found on persistence
     * @param elementType Type of the element that wasn't found
     */
    public ModelNotFoundException( String elementType, String mofId ) {

        super( "The " + elementType + " with the mofId " + mofId + " wasn't found on persistence." );
    }
}
