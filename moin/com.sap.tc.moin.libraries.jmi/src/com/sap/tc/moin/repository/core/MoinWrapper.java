package com.sap.tc.moin.repository.core;

import java.util.Collection;

import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.Facility;
import com.sap.tc.moin.repository.InvalidResourceIdentifierException;
import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.Moin;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.Session;
import com.sap.tc.moin.repository.Version;
import com.sap.tc.moin.repository.cdam.CompoundClientSpec;
import com.sap.tc.moin.repository.cdam.CompoundDataAreaManager;
import com.sap.tc.moin.repository.metamodels.MetaModelCatalog;
import com.sap.tc.moin.repository.spi.core.Wrapper;

public class MoinWrapper implements Moin, Wrapper<CoreMoin> {

    private final CoreMoin moin;

    public MoinWrapper( CoreMoin moin ) {

        this.moin = moin;
    }

    @Override
    public boolean equals( Object obj ) {

        if ( obj == this ) {
            return true;
        }
        if ( obj instanceof MoinWrapper ) {
            return moin.equals( ( (MoinWrapper) obj ).moin );
        }
        return false;
    }

    @Override
    public int hashCode( ) {

        return moin.hashCode( );
    }

    @Override
    public String toString( ) {

        return moin.toString( );
    }

    public Facility getFacilityById( String facilityId ) {

        return moin.getFacilityById( facilityId );
    }

    public Collection<Facility> getFacilities( ) {

        return moin.getFacilities( );
    }

    public Session createSession( CompoundClientSpec compoundClientSpec ) {

        WorkspaceSet workspaceSet = moin.getWorkspaceSet( compoundClientSpec.getCompoundDataArea( ) );
        if ( workspaceSet != null ) {
            SynchronizationManager synchronizationManager = workspaceSet.getSynchronizationManager( );
            synchronized ( synchronizationManager.getProhibitWriteSyncObject( ) ) {
                synchronizationManager.acquireMicroWriteLock( );
                try {
                    return ( (CoreSession) moin.createSession( compoundClientSpec ) ).getWrapper( );
                } finally {
                    synchronizationManager.releaseMicroWriteLock( );
                }
            }
        }
        return ( (CoreSession) moin.createSession( compoundClientSpec ) ).getWrapper( );
    }

    public PRI createPri( String priString ) throws InvalidResourceIdentifierException {

        return moin.createPri( priString );
    }

    public LRI createLri( String lriString ) throws InvalidResourceIdentifierException {

        return moin.createLri( lriString );
    }

    public MRI createMri( String mriString ) throws InvalidResourceIdentifierException {

        return moin.createMri( mriString );
    }

    public CompoundDataAreaManager getCompoundDataAreaManager( ) {

        return moin.getCompoundDataAreaManager( );
    }

    public CoreMoin unwrap( ) {

        return moin;
    }

    public LRI createLri( String facilityId, String dataAreaName, String mofId ) {

        return moin.createLri( facilityId, dataAreaName, mofId );
    }

    public MRI createMri( String facilityId, String dataAreaName, String containerName, String partitionName, String mofId ) {

        return moin.createMri( facilityId, dataAreaName, containerName, partitionName, mofId );
    }

    public PRI createPri( String facilityId, String dataAreaName, String containerName, String partitionName ) {

        return moin.createPri( facilityId, dataAreaName, containerName, partitionName );
    }

    public CRI createCri( String cri ) throws InvalidResourceIdentifierException {

        return moin.createCri( cri );
    }

    public CRI createCri( String facilityId, String dataAreaName, String containerName ) {

        return moin.createCri( facilityId, dataAreaName, containerName );
    }

    public MetaModelCatalog getMetamodelCatalog( ) {

        return moin.getMetamodelCatalog( );
    }

    public Version getCoreRuntimeVersion( ) {

        return moin.getCoreRuntimeVersion( );
    }

}