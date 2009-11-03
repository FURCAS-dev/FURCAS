package com.sap.tc.moin.repository.core.jmi.model;

import com.sap.tc.moin.repository.mmi.reflect.RefBaseObject;

import com.sap.tc.moin.repository.shared.util.Utilities;

/**
 * Is used to implement derived attributes and modeled operations in MOF
 * 
 * @author d024227
 */
public class ModelElementsImplementation {

    /**
     * member for singleton pattern
     */
    private static ModelElementsImplementation mei = null;

    /**
     * This private no-arg constructor avoids that a default public constructor
     * is generated.
     */
    private ModelElementsImplementation( ) {

        // intentionally does nothing
    }

    /**
     * This methods returns the singleton instance for the
     * ModelElementsImplementation
     * 
     * @return the singleton instance of the ModelElementsImplementation
     */
    public static ModelElementsImplementation getInstance( ) {

        if ( mei == null ) {
            mei = new ModelElementsImplementation( );
        }
        return mei;
    }

    /**
     * This method is used from the text verticalization metamodel. It returns
     * the ID of a translation unit.
     */
    public String getTransUnitId( RefBaseObject refBaseObject ) {

        return Utilities.extractGuidFromMofId( refBaseObject.refMofId( ) );
    }

}
