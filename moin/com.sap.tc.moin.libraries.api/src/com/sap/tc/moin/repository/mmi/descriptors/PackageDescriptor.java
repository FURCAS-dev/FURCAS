package com.sap.tc.moin.repository.mmi.descriptors;

import com.sap.tc.moin.repository.mmi.reflect.RefPackage;

import com.sap.tc.moin.repository.Connection;

/**
 * A PackageDescriptor is a "handle" for retrieving RefPackages via
 * {@link Connection#getPackage(PackageDescriptor)}.
 * 
 * @param <T> The type of the RefPackage
 */
public class PackageDescriptor<T extends RefPackage> extends ExtentDescriptor {

    /**
     * @param mofIdOfMetaObject The mof-id of the Package
     * @param modelContainerName The container name of the meta-model
     * @param qualifiedName The qualified name of the Package
     */
    public PackageDescriptor( String mofIdOfMetaObject, String modelContainerName, String... qualifiedName ) {

        super( mofIdOfMetaObject, modelContainerName, qualifiedName );
    }
}
