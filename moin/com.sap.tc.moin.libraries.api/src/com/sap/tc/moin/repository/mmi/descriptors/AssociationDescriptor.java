package com.sap.tc.moin.repository.mmi.descriptors;

import com.sap.tc.moin.repository.mmi.reflect.RefAssociation;

import com.sap.tc.moin.repository.Connection;

/**
 * An AssociationDescriptor is a "handle" for retrieving Associations via
 * {@link Connection#getAssociation(AssociationDescriptor)}.
 * 
 * @param <T> The concrete type of the association
 */
public class AssociationDescriptor<T extends RefAssociation> extends ExtentDescriptor {

    /**
     * Creates an Association descriptor
     * 
     * @param mofIdOfMetaObject The mof-id of the Association
     * @param modelContainerName The container name of the meta-model
     * @param qualifiedName The qualified name of the Association
     */
    public AssociationDescriptor( String mofIdOfMetaObject, String modelContainerName, String... qualifiedName ) {

        super( mofIdOfMetaObject, modelContainerName, qualifiedName );
    }
}
