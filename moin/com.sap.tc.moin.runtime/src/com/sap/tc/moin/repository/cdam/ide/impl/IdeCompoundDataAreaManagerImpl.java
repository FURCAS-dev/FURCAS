package com.sap.tc.moin.repository.cdam.ide.impl;

import java.util.Collection;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IStatus;

import com.sap.tc.moin.facility.primary.PrimaryFacility;
import com.sap.tc.moin.facility.primary.ide.IdePrimaryFacility;
import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.ClientSpec;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.cdam.CompoundClientSpec;
import com.sap.tc.moin.repository.cdam.CompoundDataAreaManagerImpl;
import com.sap.tc.moin.repository.cdam.ide.IdeCompoundDataAreaManager;
import com.sap.tc.moin.repository.cdam.ide.internal.IdeFacilityDispatcherInternal;
import com.sap.tc.moin.repository.commands.PartitionOperation;
import com.sap.tc.moin.repository.exception.MoinIllegalArgumentException;
import com.sap.tc.moin.repository.spi.cdam.SpiCompoundDataAreaManager;
import com.sap.tc.moin.repository.spi.core.SpiMoin;
import com.sap.tc.moin.repository.spi.facility.ide.ContainerInitializationState;
import com.sap.tc.moin.repository.spi.facility.ide.SpiIdeFacility;

/**
 * IDE implementation of CompoundDataAreaManager. It creates a compound client
 * spec from a client spec and creates a compound data area containing the data
 * area of this client spec if method
 * {@link #getDefaultCompoundClientSpec(ClientSpec)} is called. <br>
 * TODO The IdeCompoundDataAreaManager currently only supports one facility.
 * 
 * @author d026715
 */
public class IdeCompoundDataAreaManagerImpl extends CompoundDataAreaManagerImpl implements SpiCompoundDataAreaManager, IdeCompoundDataAreaManager, IdeFacilityDispatcherInternal {

    private SpiMoin moin;

    public IdeCompoundDataAreaManagerImpl( SpiMoin moin ) {

        this.moin = moin;
    }

    /*
     * (non-Javadoc)
     * @seecom.sap.tc.moin.repository.cdam.ide.IdeCompoundDataAreaManager#
     * getCompoundClientSpec(org.eclipse.core.resources.IProject)
     */
    public CompoundClientSpec getCompoundClientSpec( IProject project ) {

        // Precondition checks for API method:
        if ( project == null ) {
            throw new MoinIllegalArgumentException( IdeCompoundDataAreaManagerMessages.ARGUMENT_MUST_NOT_BE_NULL, "project" ); //$NON-NLS-1$
        }

        // get ide primary facility
        IdePrimaryFacility ideFacility = (IdePrimaryFacility) this.moin.getFacilityById( PrimaryFacility.FACILITY_ID );

        // get client spec from ide primary facility
        ClientSpec clientSpec = ideFacility.getClientSpec( project );
        if ( clientSpec == null ) {
            // We do no longer perform an implicit initialization --> see IdePrimaryFacility.initializeClientSpec
            return null; // project is not MOIN-relevant or project was not yet registered at MOIN or ...
        }

        // return compound client spec
        return this.getDefaultCompoundClientSpec( clientSpec );
    }

    // Ide dispatcher methods

    private IdePrimaryFacility getIdePF( ) {

        return (IdePrimaryFacility) moin.getFacilityById( PrimaryFacility.FACILITY_ID );
    }

    private SpiIdeFacility getSpiPF( ) {

        return (SpiIdeFacility) moin.getFacilityById( PrimaryFacility.FACILITY_ID );
    }

    public PRI createPri( IProject project, String partitionPath ) {

        // Precondition checks:
        if ( project == null ) {
            throw new MoinIllegalArgumentException( IdeCompoundDataAreaManagerMessages.ARGUMENT_MUST_NOT_BE_NULL, "project" ); //$NON-NLS-1$
        }
        if ( partitionPath == null ) {
            throw new MoinIllegalArgumentException( IdeCompoundDataAreaManagerMessages.ARGUMENT_MUST_NOT_BE_NULL, "partitionPath" ); //$NON-NLS-1$
        }

        CRI container = getContainer( project );
        if ( container == null ) {
            throw new MoinIllegalArgumentException( IdeCompoundDataAreaManagerMessages.NO_CRI_FOR_PROJECT, project.getName( ) );
        }
        return getIdePF( ).getRIFactory( ).createPri( container.getDataAreaDescriptor( ).getDataAreaName( ), container.getContainerName( ), partitionPath );
    }

    public CRI getContainer( IProject project ) {

        return getIdePF( ).getContainer( project );
    }

    public IFile getFile( PRI pri ) {

        return getIdePF( ).getFile( pri );
    }

    public IProject getProject( CRI cri ) {

        return getIdePF( ).getProject( cri );
    }

    public IStatus prepareModification( Collection<PartitionOperation> affectedPartitions ) {

        return getIdePF( ).prepareModification( affectedPartitions );
    }

    public IStatus prepareModificationInProject( IProject project ) {

        return getIdePF( ).prepareModificationInProject( project );
    }

    public IStatus prepareModificationHeadless( Collection<PartitionOperation> affectedPartitions ) {

        return getIdePF( ).prepareModificationHeadless( affectedPartitions );
    }

    public IStatus prepareModificationInProjectHeadless( IProject project ) {

        return getIdePF( ).prepareModificationInProjectHeadless( project );
    }

    public void refreshFromFileSystem( IProject project, boolean forced ) {

        getIdePF( ).refreshFromFileSystem( project, forced );
    }

    public ClientSpec getClientSpec( IProject eclipseProject ) {

        return getIdePF( ).getClientSpec( eclipseProject );
    }

    public ContainerInitializationState getContainerInitializationState( IProject eclipseProject ) {

        return getSpiPF( ).getContainerInitializationState( eclipseProject );
    }

    public ContainerInitializationState getContainerInitializationState( ClientSpec clientSpec, CRI cri ) {

        return getSpiPF( ).getContainerInitializationState( clientSpec, cri );
    }

    public ClientSpec initializeClientSpec( IProject eclipseProject ) {

        return getSpiPF( ).initializeClientSpec( eclipseProject );
    }

    public void refreshClientSpecFromFileSystem( IProject eclipseProject ) {

        getSpiPF( ).refreshClientSpecFromFileSystem( eclipseProject );

    }

}
