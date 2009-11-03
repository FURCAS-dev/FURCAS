package com.sap.tc.moin.facility.primary;

import com.sap.tc.moin.repository.Facility;

/**
 * The interface provides the functionality of the primary facility in MOIN.
 * <p>
 * 
 * @noimplement The interface is not intended to be implemented or extended by
 * clients.
 * </p>
 * @author d021091
 */
public interface PrimaryFacility extends Facility {

    /**
     * Constant denoting the id of the primary facility. The id is used e.g. for
     * identifiying MRIs that address objects stored in the primary facility.
     */
    public static final String FACILITY_ID = "PF"; //$NON-NLS-1$

}