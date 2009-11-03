package com.sap.tc.moin.repository.core;

import java.util.List;

import com.sap.tc.moin.repository.mmi.model.GeneralizableElement;


public interface PackageExtent extends Extent {

    /**
     * Returns the cached list of all supertypes of this package.
     */
    public List<GeneralizableElement> get___AllSupertypes( );

    /**
     * Sets the cached list of all supertypes of this package.
     */
    public void set___AllSupertypes( List<GeneralizableElement> types );
}
