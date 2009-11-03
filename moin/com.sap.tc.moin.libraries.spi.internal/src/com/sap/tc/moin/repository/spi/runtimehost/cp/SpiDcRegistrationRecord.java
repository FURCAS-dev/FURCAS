package com.sap.tc.moin.repository.spi.runtimehost.cp;

import java.util.Collection;

/**
 * Record for custom dc type registrations. The record contains the name and
 * vendor of the dc type and a collection of the MOIN relevant folders.
 * 
 * @author d026715
 */
public interface SpiDcRegistrationRecord {

    /**
     * Returns the name of the dc type.
     * 
     * @return
     */
    String getDcTypeName( );

    /**
     * Returns the vendor of the dc type.
     * 
     * @return
     */
    String getDcTypeVendor( );

    /**
     * Returns the collection of MOIN relevant folders.
     * 
     * @return
     */
    Collection<String> getMoinRelevantFolders( );
}
