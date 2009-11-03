package com.sap.tc.moin.repository;

/**
 * Logical resource-identifier. Please refer to {@link MRI} for more details.
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 * @author d026715
 */
public interface LRI {

    /**
     * Returns a data area descriptor, consisting of a facility type and data
     * area name.
     * 
     * @return the data area descriptor
     */
    public DataAreaDescriptor getDataAreaDescriptor( );

    /**
     * Returns the MOF id.
     * 
     * @return the MOF id
     */
    public String getMofId( );
}
