package com.sap.tc.moin.repository.xm;

import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.mmi.descriptors.ClassDescriptor;



/**
 * Handle to a model element.
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface ModelElementHandle {

    /**
     * Returns the MOFID of the model element in HEX format.
     * 
     * @return MOFID in HEX format
     */
    String getMofid( );


    /**
     * Returns the class descriptor of the type of the model element.
     * 
     * @return class descriptor
     */
    ClassDescriptor<? extends RefClass, ? extends RefObject> getType( );
}
