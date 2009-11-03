package com.sap.tc.moin.repository;

/**
 * Factory for MRIs. Each facility provides its own MRI implementation through
 * an MRI factory attached to the facility.
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 * @author d026715
 */
public interface ResourceIdentifierFactory {

    /**
     * Creates MRI.
     * 
     * @param uri String representation of a MRI.
     * @return MRI instance
     * @throws InvalidResourceIdentifierException if the URI is invalid.
     */
    public MRI createMri( String uri ) throws InvalidResourceIdentifierException;

    /**
     * Creates a model element resource identifier ({@link MRI}).
     * 
     * @param dataAreaName Name of the data area
     * @param containerName Name of the container (in case of NWDI, this is the
     * dc vendor and name)
     * @param partitionName Name of the partition
     * @param mofId Mof id of the element the {@link MRI} points to.
     * @return MRI instance.
     */
    public MRI createMri( String dataAreaName, String containerName, String partitionName, String mofId );

    /**
     * Creates parition resource identifier ({@link PRI}).
     * 
     * @param pri String representation of PRI.
     * @return PRI instance.
     * @throws InvalidResourceIdentifierException
     */
    public PRI createPri( String pri ) throws InvalidResourceIdentifierException;

    /**
     * Creates a partition resource identifier ({@link PRI}).
     * 
     * @param dataAreaName Name of the data area
     * @param containerName Name of the container (in case of NWDI, this is the
     * dc vendor and name)
     * @param partitionName Name of the partition
     * @return PRI instance.
     */
    public PRI createPri( String dataAreaName, String containerName, String partitionName );

    /**
     * Creates parition resource identifier ({@link CRI}).
     * 
     * @param cri String representation of PRI.
     * @return CRI instance.
     * @throws InvalidResourceIdentifierException
     */
    public CRI createCri( String cri ) throws InvalidResourceIdentifierException;

    /**
     * Creates a partition resource identifier ({@link CRI}).
     * 
     * @param dataAreaName Name of the data area
     * @param containerName Name of the container (in case of NWDI, this is the
     * dc vendor and name)
     * @return CRI instance.
     */
    public CRI createCri( String dataAreaName, String containerName );

    /**
     * Creates link resource identifier ({@link LRI}).
     * 
     * @param lri String representation of LRI.
     * @return LRI instance.
     * @throws InvalidResourceIdentifierException
     */
    public LRI createLri( String lri ) throws InvalidResourceIdentifierException;

    /**
     * Creates link resource identifier ({@link LRI}).
     * 
     * @param dataAreaName Name of the data area
     * @param mofId Mof id of the element that the {@link LRI} points to.
     * @return LRI
     */
    public LRI createLri( String dataAreaName, String mofId );

}
