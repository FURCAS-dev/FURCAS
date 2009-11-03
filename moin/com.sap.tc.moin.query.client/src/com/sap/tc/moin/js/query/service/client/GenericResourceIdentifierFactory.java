package com.sap.tc.moin.js.query.service.client;

import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.DataAreaDescriptor;
import com.sap.tc.moin.repository.InvalidResourceIdentifierException;
import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.ResourceIdentifierFactory;

/**
 * A generic extension of {@link ResourceIdentifierFactory} allowing to create
 * {@link DataAreaDescriptor}s as well as {@link CRI}, {@link LRI}, {@link MRI},
 * and {@link PRI} for specified <tt>facilityId</tt>s.
 * 
 * @author D044522
 */
public interface GenericResourceIdentifierFactory extends ResourceIdentifierFactory {

    /**
     * Creates a CRI for a specified Facility.
     * 
     * @param facilityId
     * @param dataAreaName
     * @param containerName
     * @return
     */
    public abstract CRI createCri( String facilityId, String dataAreaName, String containerName );

    /**
     * Creates a LRI for a specified Facility.
     * 
     * @param facilityId
     * @param dataAreaName
     * @param mofId
     * @return
     */
    public abstract LRI createLri( String facilityId, String dataAreaName, String mofId );

    /**
     * Creates a MRI for a specified Facility.
     * 
     * @param facilityId
     * @param dataAreaName
     * @param containerName
     * @param partitionName
     * @param mofId
     * @return
     */
    public abstract MRI createMri( String facilityId, String dataAreaName, String containerName, String partitionName, String mofId );

    /**
     * Creates a PRI for a specified Facility.
     * 
     * @param facilityId
     * @param dataAreaName
     * @param containerName
     * @param partitionName
     * @return
     */
    public abstract PRI createPri( String facilityId, String dataAreaName, String containerName, String partitionName );

    /**
     * Creates a DataAreaDescriptor for a specified Facility.
     * 
     * @param facilityId
     * @param dataAreaName
     * @return
     */
    public abstract DataAreaDescriptor createDataAreaDescriptor( String facilityId, String dataAreaName );

    /**
     * Creates a DataAreaDescriptor from its String representation.
     * 
     * @param dad
     * @return
     * @throws InvalidResourceIdentifierException if the String is not
     * interpretable.
     */
    public abstract DataAreaDescriptor createDataAreaDescriptor( String dad ) throws InvalidResourceIdentifierException;


}
