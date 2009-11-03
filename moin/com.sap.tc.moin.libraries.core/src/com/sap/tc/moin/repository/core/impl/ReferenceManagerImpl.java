package com.sap.tc.moin.repository.core.impl;

import com.sap.tc.moin.repository.LRI;
import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.core.CoreModelPartition;
import com.sap.tc.moin.repository.core.CoreMoin;
import com.sap.tc.moin.repository.core.CorePartitionable;
import com.sap.tc.moin.repository.core.LriReference;
import com.sap.tc.moin.repository.core.MetamodelLriReference;
import com.sap.tc.moin.repository.core.MetamodelMriReference;
import com.sap.tc.moin.repository.core.MriReference;
import com.sap.tc.moin.repository.core.PriReference;
import com.sap.tc.moin.repository.core.ReferenceKeeper;
import com.sap.tc.moin.repository.core.ReferenceManager;
import com.sap.tc.moin.repository.core.SharedWorkspace;
import com.sap.tc.moin.repository.core.Workspace;
import com.sap.tc.moin.repository.exception.MoinIllegalArgumentException;
import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;

public final class ReferenceManagerImpl implements ReferenceManager {

    private CoreMoin moin;

    public ReferenceManagerImpl( CoreMoin moin ) {

        this.moin = moin;
    }

    private void handleIllegalNullArgument( String message ) {

        throw new IllegalArgumentException( message );
    }

    public LriReference getLriReference( LRI lri ) {

        if ( lri == null ) {
            handleIllegalNullArgument( "LRI must not be null" ); //$NON-NLS-1$
        }
        return new LriReferenceImpl( lri, false /* cacheable */);
    }

    private boolean cacheableReferenceAllowed( CorePartitionable partitionable, Workspace requestor ) {

        if ( partitionable != null ) {
            return partitionable.get___Workspace( ) == requestor || partitionable.get___Workspace( ).isShared( );
        }
        return true;
    }

    public PriReference getPriReference( PRI pri, Workspace requestor ) {

        if ( pri == null ) {
            handleIllegalNullArgument( "PRI must not be null" ); //$NON-NLS-1$
        }
        if ( requestor == null ) {
            handleIllegalNullArgument( "Workspace must not be null" ); //$NON-NLS-1$
        }
        return requestor.getPriReference( pri );
    }

    public PriReference getPriReference( CoreModelPartition partition, Workspace requestor ) {

        if ( partition == null ) {
            handleIllegalNullArgument( "Partition must not be null" ); //$NON-NLS-1$
        }
        Workspace workspaceOfPartition = partition.getWorkspace( );
        if ( workspaceOfPartition.isMetamodelWorkspace( ) ) {
            return workspaceOfPartition.getPriReference( partition );
        } else if ( requestor instanceof SharedWorkspace ) {
            throw new MoinIllegalArgumentException( CoreImplMessages.PRIREFERENCEREQUESTEDBYNONMMSHAREDWORKSPACE );
        }
        if ( requestor == null ) {
            handleIllegalNullArgument( "Workspace must not be null" ); //$NON-NLS-1$
        }
        return requestor.getPriReference( partition );
    }

    public MriReference getMriReference( CorePartitionable partitionable, Workspace requestor ) {

        if ( partitionable == null ) {
            handleIllegalNullArgument( "Partitionable must not be null" ); //$NON-NLS-1$
        }
        return getMriReference( partitionable, partitionable.get___Mri( ), requestor );
    }

    public MriReference getMriReference( MRI mri, Workspace requestor ) {

        if ( mri == null ) {
            handleIllegalNullArgument( "MRI must not be null" ); //$NON-NLS-1$
        }
        return getMriReference( null, mri, requestor );
    }

    private MriReference getMriReference( CorePartitionable partitionable, MRI mri, Workspace requestor ) {

        if ( partitionable != null ) {
            Workspace workspaceOfPartitionable = partitionable.get___Workspace( );
            if ( workspaceOfPartitionable.isMetamodelWorkspace( ) ) {
                return workspaceOfPartitionable.getMriReference( partitionable, partitionable.get___Mri( ) );
            }

        } else { // partitionable == null
            if ( mri.getDataAreaDescriptor( ).isMetamodelDataArea( ) ) {
                Workspace metaModelWorkspace = this.moin.getMetamodelWorkspace( );
                return metaModelWorkspace.getMriReference( partitionable, mri );
            }
        }
        if ( requestor == null ) {
            handleIllegalNullArgument( "Hosting workspace for MRI reference to MRI " + mri + " must not be null" ); //$NON-NLS-1$ //$NON-NLS-2$
        }
        assert cacheableReferenceAllowed( partitionable, requestor ) : "Element " + partitionable + " from workspace " + partitionable.get___Workspace( ) + " cannot have a reference at workspace " + requestor; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        return requestor.getMriReference( partitionable, mri );

    }

    public MetamodelMriReference getMetamodelMriReference( CorePartitionable partitionable ) {

        if ( partitionable == null ) {
            handleIllegalNullArgument( "Partitionable must not be null" ); //$NON-NLS-1$
        }
        Workspace workspace = partitionable.get___Workspace( );
        MetamodelMriReference result = null;
        if ( workspace.isMetamodelWorkspace( ) ) {
            result = (MetamodelMriReference) workspace.getMriReference( partitionable, partitionable.get___Mri( ) );
        } else {
            throw new MoinLocalizedBaseRuntimeException( CoreImplMessages.METAMODELMRIREFERENCECANONLYBEREQUESTEDFORMMWORKSPACE );
        }
        return result;
    }

    public MetamodelLriReference getMetamodelLriReference( LRI lri ) {

        if ( lri == null ) {
            handleIllegalNullArgument( "LRI must not be null" ); //$NON-NLS-1$
        }
        MetamodelLriReference result = null;
        if ( lri.getDataAreaDescriptor( ).isMetamodelDataArea( ) ) {
            result = moin.getMetamodelWorkspace( ).getMetamodelLriReference( lri );
        } else {
            throw new MoinLocalizedBaseRuntimeException( CoreImplMessages.METAMODELLRIREFERENCECANONLYBEREQUESTEDFORMMWORKSPACE );
        }
        return result;
    }

    public void notifyBeforeInstanceEviction( CorePartitionable element ) {

        if ( element == null ) {
            handleIllegalNullArgument( "Element to evict must not be null" ); //$NON-NLS-1$
        }
        Workspace workspace = element.get___Workspace( );
        if ( workspace.isMetamodelWorkspace( ) || !workspace.isShared( ) ) {
            // metamodel or clientspecific workspace
            uncacheReferencesForElement( element, workspace );
        } else {
            // shared, non-metamodel workspace
            for ( Workspace relevantWorkspace : workspace.getWorkspaceSet( ).getClientSpecificWorkspaces( ) ) {
                uncacheReferencesForElement( element, relevantWorkspace );
            }
            for ( Workspace relevantWorkspace : workspace.getWorkspaceSet( ).getSharedWorkspaces( ) ) {
                if ( !relevantWorkspace.isMetamodelWorkspace( ) ) {
                    uncacheReferencesForElement( element, relevantWorkspace );
                }
            }
        }
    }

    private void uncacheReferencesForElement( CorePartitionable element, ReferenceKeeper referenceKeeper ) {

        referenceKeeper.uncacheMriReference( element.get___Mri( ) );
    }

    public void notifyBeforePartitionEviction( CoreModelPartition modelPartition ) {

        Workspace workspace = modelPartition.getWorkspace( );
        if ( workspace.isMetamodelWorkspace( ) || !workspace.isShared( ) ) {
            // metamodel and client-specific workspace cannot be referenced from
            // other workspace
            workspace.uncachePriReference( modelPartition );
        } else if ( workspace.isShared( ) ) {
            // shared, non-metamodel workspace
            for ( Workspace relevantWorkspace : workspace.getWorkspaceSet( ).getSharedWorkspaces( ) ) {
                if ( !relevantWorkspace.isMetamodelWorkspace( ) ) {
                    relevantWorkspace.uncachePriReference( modelPartition );
                }
            }
        }
    }

    public void elementRelocated( CoreConnection connection, CoreModelPartition oldPartition, CoreModelPartition newPartition, String mofId ) {

        // relocation of an element always happens in the context of one session (not more), therefore we can use the
        // current connection in order to get the client specific workspace of this session
        MRI oldMri = oldPartition.getPri( ).createMri( mofId );
        connection.getSession( ).getWorkspace( ).elementRelocated( connection, newPartition, oldMri );
    }
}