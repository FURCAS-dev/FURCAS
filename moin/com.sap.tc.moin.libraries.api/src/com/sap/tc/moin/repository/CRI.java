package com.sap.tc.moin.repository;

/**
 * Container resource-identifier. Please refer to {@link MRI} for more details.
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface CRI {

    /**
     * Returns a data area descriptor, consisting of a facility type and data
     * area name.
     * 
     * @return the data area descriptor
     */
    public DataAreaDescriptor getDataAreaDescriptor( );

    /**
     * Returns the name of the container.
     * 
     * @return the name of the container
     */
    public String getContainerName( );


    /**
     * The method returns <code>true</code> if the CRI identifies a volatile
     * container (i.e. a container which hosts {@link PRI#isVolatilePartition()
     * volatile partitions}.
     * 
     * @return <code>true</code> if the CRI identifies a volatile container,
     * <code>false</code> otherwise.
     */
    public boolean isVolatileContainer( );

    public int hashCode( );

    public boolean equals( Object obj );

}
