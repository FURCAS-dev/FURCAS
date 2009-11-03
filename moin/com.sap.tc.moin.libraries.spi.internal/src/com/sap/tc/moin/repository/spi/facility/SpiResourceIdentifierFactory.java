package com.sap.tc.moin.repository.spi.facility;

import com.sap.tc.moin.repository.DataAreaDescriptor;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.ResourceIdentifierFactory;

/**
 * Factory for MRIs. Each facility provides its own MRI implementation through
 * an MRI factory attached to the facility.
 * <p>
 * This interface <i>is</i> intended to be implemented by service providers.
 * 
 * @author d026715
 */
public interface SpiResourceIdentifierFactory extends ResourceIdentifierFactory {

    /**
     * Creates a NullPartition {@link PRI}.
     * 
     * @param descriptor The descriptor of the data area.
     * @param partitionName The partition name.
     * @return {@link PRI} instance.
     */
    public PRI createNullPri( DataAreaDescriptor descriptor, String partitionName );

    /**
     * Creates a volatile partition {@link PRI}.
     * 
     * @param descriptor The descriptor of the data area.
     * @param partitionName The partition name.
     * @return {@link PRI} instance.
     */
    public PRI createVolatilePri( DataAreaDescriptor descriptor, String partitionName );

}
