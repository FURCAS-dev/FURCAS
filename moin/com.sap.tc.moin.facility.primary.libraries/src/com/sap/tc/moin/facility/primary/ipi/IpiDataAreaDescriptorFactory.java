package com.sap.tc.moin.facility.primary.ipi;

import com.sap.tc.moin.repository.DataAreaDescriptor;

/**
 * Facility internal IPI interface which provides means to create data area
 * descriptors.
 * 
 * @see DataAreaDescriptor
 */
public interface IpiDataAreaDescriptorFactory {

    /**
     * Returns a data area descriptor for the given data area name.
     * <p>
     * If this name equals {@link IpiPrimaryFacility#META_MODEL_DATA_AREA_ID}
     * the returned data area descriptor is the metamodel data area descriptor.
     * 
     * @param dataAreaName The name of the data area for which a descriptor is
     * requested.
     * @return A data area descriptor for the given data area name.
     */
    public DataAreaDescriptor createDataAreaDescriptor( String dataAreaName );

}
