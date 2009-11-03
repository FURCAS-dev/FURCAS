package com.sap.tc.moin.repository;

import java.util.Collection;

import com.sap.tc.moin.repository.cdam.CompoundClientSpec;
import com.sap.tc.moin.repository.cdam.CompoundDataAreaManager;
import com.sap.tc.moin.repository.metamodels.MetaModelCatalog;

/**
 * MOIN represents a single instance of the Modeling Infrastructure.
 * <p>
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 * @author d024227
 */
@MoinVersion( versionNumber = "01.24.00", versionDate = "2009-02-19", versionComment = "Milestone 24" )
public interface Moin {

    /**
     * Returns the available facilities.
     * 
     * @return the available facilities
     */
    public Collection<Facility> getFacilities( );

    /**
     * Get a {@link Facility} by its {@link Facility#getId() ID}.
     * 
     * @param facilityId the id of the facility
     * @return the Facility or null if the name is not known
     */
    public Facility getFacilityById( String facilityId );

    /**
     * Creates a new {@link Session} for the chosen {@link DataArea} and
     * {@link CompoundClientSpec}.
     * 
     * @param compoundClientSpec the compoundClientSpec for which to create a
     * Session
     * @return the newly created {@link Session}
     */
    public Session createSession( CompoundClientSpec compoundClientSpec );


    /**
     * Returns the {@link CompoundDataAreaManager} for the given scenario.
     * 
     * @return the {@link CompoundDataAreaManager} for the given scenario
     */
    public CompoundDataAreaManager getCompoundDataAreaManager( );

    /**
     * Creates a model element resource identifier ({@link MRI}).
     * 
     * @param mri {@link MRI#toString() String representation} of MRI
     * @return the created MRI instance
     * @throws InvalidResourceIdentifierException if the given String is
     * syntactically incorrect.
     */
    public MRI createMri( String mri ) throws InvalidResourceIdentifierException;

    /**
     * Creates a model element resource identifier ({@link MRI}).
     * 
     * @param facilityId Id of the facility
     * @param dataAreaName Name of the data area
     * @param containerName Name of the container (in case of NWDI, this is the
     * dc vendor and name)
     * @param partitionName Name of the partition
     * @param mofId MOF id of the element the {@link MRI} points to.
     * @return MRI the created MRI instance
     */
    public MRI createMri( String facilityId, String dataAreaName, String containerName, String partitionName, String mofId );

    /**
     * Creates a partition resource identifier ({@link PRI}).
     * 
     * @param pri {@link PRI#toString() String representation} of PRI
     * @return the created PRI instance
     * @throws InvalidResourceIdentifierException if the given String is
     * syntactically incorrect
     */
    public PRI createPri( String pri ) throws InvalidResourceIdentifierException;

    /**
     * Creates a partition resource identifier ({@link PRI}).
     * 
     * @param facilityId Id of the facility
     * @param dataAreaName Name of the data area
     * @param containerName Name of the container (in case of NWDI, this is the
     * dc vendor and name)
     * @param partitionName Name of the partition
     * @return the created PRI instance
     */
    public PRI createPri( String facilityId, String dataAreaName, String containerName, String partitionName );

    /**
     * Creates a container resource identifier ({@link CRI}).
     * 
     * @param cri {@link CRI#toString() String representation} of CRI
     * @return the created CRI instance
     * @throws InvalidResourceIdentifierException if the given String is
     * syntactically incorrect
     */
    public CRI createCri( String cri ) throws InvalidResourceIdentifierException;

    /**
     * Creates a container resource identifier ({link CRI}).
     * 
     * @param facilityId Id of the facility
     * @param dataAreaName Name of the data area
     * @param containerName Name of the container
     * @return the created CRI instance
     */
    public CRI createCri( String facilityId, String dataAreaName, String containerName );

    /**
     * Creates a logical resource identifier ({@link LRI}).
     * 
     * @param lri String representation of {@link LRI}
     * @return the created LRI instance
     * @throws InvalidResourceIdentifierException if the given String is
     * syntactically incorrect
     */
    public LRI createLri( String lri ) throws InvalidResourceIdentifierException;

    /**
     * Creates logical resource identifier ({@link LRI}).
     * 
     * @param facilityId Id of the facility
     * @param dataAreaName Name of the data area
     * @param mofId MOF id of the element the {@link LRI} points to.
     * @return the created LRI instance
     */
    public LRI createLri( String facilityId, String dataAreaName, String mofId );

    /**
     * Gets the catalog of already deployed metamodels.
     * 
     * @return catalog of already deployed metamodels.
     */
    public MetaModelCatalog getMetamodelCatalog( );

    /**
     * Gets the version of the MOIN core.
     * 
     * @return the version of the MOIN core.
     */
    public Version getCoreRuntimeVersion( );
}