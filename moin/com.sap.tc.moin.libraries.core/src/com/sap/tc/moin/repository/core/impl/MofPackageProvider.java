package com.sap.tc.moin.repository.core.impl;

import com.sap.tc.moin.repository.mmi.model.MofPackage;

/**
 * This interface has to be implemented in order to function as a provider for MofPackages
 * <p>
 * This interface <i>is</i> intended to be implemented by service providers.
 * 
 * @author d024227
 */
public interface MofPackageProvider {

    /**
     * Resolve into a MofPackage
     * 
     * @return the MofPackage to be resolved
     */
    public MofPackage resolveMofPackage( );

}
