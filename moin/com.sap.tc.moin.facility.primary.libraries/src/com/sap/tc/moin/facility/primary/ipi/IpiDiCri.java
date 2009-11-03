package com.sap.tc.moin.facility.primary.ipi;

import com.sap.tc.moin.repository.CRI;

/**
 * Facility internal IPI interface for a {@link CRI}.
 * <p>
 * Adds getters for development component name and vendor.
 * 
 * @see CRI
 */
public interface IpiDiCri extends CRI {

    /**
     * @return the name of the NWDI development component
     */
    String getDevComponentName( );

    /**
     * @return the vendor of the NWDI development component
     */
    String getDevComponentVendor( );
}
