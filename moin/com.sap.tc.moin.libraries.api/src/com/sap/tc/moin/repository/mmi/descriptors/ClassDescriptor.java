package com.sap.tc.moin.repository.mmi.descriptors;

import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.Connection;

/**
 * A ClassDescriptor is a "handle" for retrieving RefClasses via
 * {@link Connection#getClass(ClassDescriptor)}.
 * 
 * @param <RC> Type of the RefClass
 * @param <RO> Type of the RefObject
 */
public class ClassDescriptor<RC extends RefClass, RO extends RefObject> extends ExtentDescriptor {

    /**
     * Creates a class descriptor
     * 
     * @param mofIdOfMetaObject The mof-id of the Association
     * @param modelContainerName The container name of the meta-model
     * @param qualifiedName The qualified name of the class
     */
    public ClassDescriptor( String mofIdOfMetaObject, String modelContainerName, String... qualifiedName ) {

        super( mofIdOfMetaObject, modelContainerName, qualifiedName );
    }
}
