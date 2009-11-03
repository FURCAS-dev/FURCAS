package com.sap.tc.moin.repository;

/**
 * Partition resource-identifier. Please refer to {@link MRI} for more details.
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 * @author d026715
 */
public interface PRI {

    /**
     * Returns the descriptor of the data area to which this PRI belongs.
     * 
     * @return the data area descriptor
     */
    public DataAreaDescriptor getDataAreaDescriptor( );

    /**
     * @return the name of the container to which this partition belongs.
     */
    public String getContainerName( );

    /**
     * @return the name of the partition relative to the containing container.
     */
    public String getPartitionName( );

    /**
     * Returns a resource identifier for the container to which this PRI
     * belongs.
     * 
     * @return a resource identifier for the container to which this PRI
     * belongs.
     */
    public CRI getCri( );

    /**
     * The method returns <code>true</code> if this PRI identifies a partition
     * of a deployed meta model,<code>false</code> otherwise.
     * <p>
     * I.e. it is a partition which contains model elements of meta model MOF,
     * i.e. it belongs to a MOF model, and the respective MOF model is deployed
     * as meta model in MOIN.
     * 
     * @return <code>true</code> if this PRI identifies a partition of a
     * deployed meta model, <code>false</code> otherwise.
     */
    public boolean isMetaModelPartition( );

    /**
     * The method returns <code>true</code> if the PRI identifies a
     * {@link Connection#getNullPartition() NullPartition} .
     * <p>
     * Remark: The NullPartition is a volatile partition (cannot be stored). It
     * hosts newly created model elements before they are assigned to a regular
     * partition (partition which can be stored). Before changes are saved, the
     * NullPartition must be empty.
     * 
     * @see Connection#save
     * @see Connection#getNullPartition
     * @return <code>true</code> if the PRI identifies a
     * {@link Connection#getNullPartition() NullPartition}, <code>false</code>
     * otherwise .
     */
    public boolean isNullPartition( );


    /**
     * The method returns <code>true</code> if the PRI identifies a volatile
     * partition (i.e. a partition which only exists in memory and cannot be
     * saved). If a PRI returns <code>true</code> for
     * {@link PRI#isNullPartition()}, {@link #isVolatilePartition()} must also
     * return <code>true</code>. Other volatile partitions for example are the
     * ones created via {@link Connection#getOrCreateTransientPartition(String)}
     * .
     * 
     * @return <code>true</code> if the PRI identifies a volatile partition,
     * <code>false</code> otherwise.
     */
    public boolean isVolatilePartition( );


    /**
     * Creates a {@link MRI} from the PRI and the given mofId.
     * 
     * @param mofId MOF id identifying an element inside the partition PRI.
     * @return MRI
     */
    public MRI createMri( String mofId );



}
