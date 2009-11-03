/*
 * Created on Feb 2, 2006
 */
package com.sap.tc.moin.repository.core.impl;

import com.sap.tc.moin.repository.mmi.model.MofPackage;

import com.sap.tc.moin.repository.MRI;

/**
 * This interface is a proxy for a MOF package. The proxy is needed to abstract
 * from e.g. some DC hosting metamodels (MetamodelContainer) and MofPackages
 * itself and to avoid that the Java class MofPackageImpl has to implement the
 * interface MetamodelContent.
 * <p>
 * This interface <i>is</i> intended to be implemented by service providers.
 */
public interface MofPackageProxy {

    /**
     * Gets the {@link MofPackage} for which this interface is a proxy.
     * 
     * @return the {@link MofPackage} for which this interface is a proxy
     */
    public MofPackage getPackage( );

    public MRI getMofPackageMri( );

    /**
     * Gets the name of this container.
     * <p>
     * The name of a model content container has to uniquely identify this
     * container.
     * 
     * @return the name of this container
     */
    public String getName( );

}
