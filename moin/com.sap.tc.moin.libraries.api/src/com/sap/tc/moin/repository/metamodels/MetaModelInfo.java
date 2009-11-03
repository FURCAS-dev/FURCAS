package com.sap.tc.moin.repository.metamodels;


/**
 * Information about deployed in MOIN metamodels.
 * <p>
 * The MetaModelInfo interface describes the platform independent metamodel
 * properties, e.g the container name, vendor name, metamodel version.
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface MetaModelInfo {

    /**
     * Returns the name of the MOIN metamodel (metamodel ID - DC name).
     * 
     * @return the name of the MOIN metamodel.
     * @deprecated The {@link #getName()} method is replaced by the
     * {@link #getContainerName()} method.
     */
    @Deprecated
    public String getName( );

    /**
     * Returns the name of MOIN metamodel (container name).
     * 
     * @return the MOIN metamodel container name.
     */
    public String getContainerName( );

    /**
     * Returns name of the metamodel vendor.
     * 
     * @return name of the metamodel vendor.
     */
    public String getVendor( );

    /**
     * Returns the facility name of currently deployed MOIN metamodel (metamodel
     * stored in MOIN repository).
     * 
     * @return the facility name of currently deployed MOIN metamodel.
     * @deprecated The {@link #getDeployedMetaModelFacilityName()} method is
     * replaced by the getFacilityName() method (see
     * com.sap.tc.moin.repository.ide.metamodels.MmDeploymentInfo).
     */
    @Deprecated
    public String getDeployedMetaModelFacilityName( );

    /**
     * Returns the version of currently deployed MOIN metamodel (metamodel
     * stored in MOIN repository).
     * 
     * @return the version of currently deployed MOIN metamodel.
     */
    public MetaModelVersion getDeployedMetaModelVersion( );

}
