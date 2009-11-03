package com.sap.tc.moin.facility.pde;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;

import com.sap.tc.moin.facility.componentmodel.CMContainer;
import com.sap.tc.moin.facility.componentmodel.CMDataArea;
import com.sap.tc.moin.facility.componentmodel.adapter.CMFSFolder;
import com.sap.tc.moin.facility.componentmodel.adapter.PDEContentTypeRegistry;
import com.sap.tc.moin.facility.componentmodel.adapter.ProjectContentTypeRegistry;
import com.sap.tc.moin.facility.filesystem.FileSystemFacility;
import com.sap.tc.moin.facility.filesystem.componentmodel.CMFSDataArea;
import com.sap.tc.moin.facility.primary.ide.IdePrimaryFacility;
import com.sap.tc.moin.facility.versioning.eclipse.TeamProviderVersioningSupport;
import com.sap.tc.moin.repository.CRI;
import com.sap.tc.moin.repository.ClientSpec;
import com.sap.tc.moin.repository.DataArea;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.commands.PartitionOperation;
import com.sap.tc.moin.repository.spi.facility.ide.ContainerInitializationState;
import com.sap.tc.moin.repository.spi.facility.ide.SpiIdeFacility;

public class JazzUpFileSystemFacilityWithIdePrimaryFacility extends FileSystemFacilityDelegator implements IdePrimaryFacility, SpiIdeFacility {

//    private final BidirectionalMap<IProject, CRI> projectMap = new BidirectionalMap<IProject, CRI>( );

    public static boolean usePDERegistry = true;

    private CMDataArea ideDataArea = null;

    final static String DAName = "IDE"; //$NON-NLS-1$

    private ProjectContentTypeRegistry ctRegistry = null;

    private final synchronized ProjectContentTypeRegistry getRegistry( ) {

        if ( ideDataArea == null ) {
            DataArea da = getDelegatedInstance( ).grantDataArea( DAName );
            ideDataArea = getDelegatedInstance( ).getCMManager( ).putDataArea( new CMFSDataArea( da.getDescriptor( ), false, dismantleInstance( ) ) );

            if ( usePDERegistry ) {
                ctRegistry = new PDEContentTypeRegistry( ideDataArea );
            } else {
                ctRegistry = new ProjectContentTypeRegistry( ideDataArea );
                HashSet<CMFSFolder> folders = new HashSet<CMFSFolder>( );
                folders.add( new CMFSFolder( "src/", false ) ); //$NON-NLS-1$
                ctRegistry.registerNatureDefinition( null, "com.sap.tc.moin.nwdi.dctype.MoinNature", folders, null ); //$NON-NLS-1$
            }

            ctRegistry.initialize( );
        }
        return ctRegistry;
    }

    public JazzUpFileSystemFacilityWithIdePrimaryFacility( FileSystemFacility facility ) {

        super( facility );
    }

//    private final CRI grantProjectCRI( IProject project ) {
//
//        grantIdeDataArea( );
//        return getDelegatedInstance( ).getRIFactory( ).createCri( DAName, pdeContent.getModelContainerName( project ) );
//    }

//    private final CMContainer getProjectCMContainer( IProject project ) {
//
//        return getDelegatedInstance( ).getCMManager( ).getContainer( projectMap.getK1( project ) );
//    }



//    private CMContainer grantContainer( IProject eclipseProject, boolean initContainer ) {
//
//        initContainer = true;
//        CMContainer container = null;
//        if ( eclipseProject.isAccessible( ) ) {
//            container = pdeContent.getContainer( eclipseProject );
//
//            if ( container == null ) {
//                final CRI cri = grantProjectCRI( eclipseProject );
//                container = getDelegatedInstance( ).getCMManager( ).getContainer( cri );
//                if ( container == null ) {
//                    container = pdeContent.createProjectContainer_PDE( cri, getDelegatedInstance( ).getCMManager( ), eclipseProject );
//                }
//                projectMap.put( eclipseProject, cri );
//            }
//        }
//
//        if ( initContainer && container != null ) {
//            CMServices.updateContainerRecursively( container, false );
//        }
//        return container;
//    }

    public ClientSpec getClientSpec( IProject eclipseProject ) {

        if ( ideDataArea == null ) {
            return null;
        }
//        getRegistry( );
        return getDelegatedInstance( ).grantDataArea( DAName ).getClientSpec( DAName );
    }

    public CRI getContainer( IProject project ) {

        return getRegistry( ).getContainerCri( project );
    }

    private static ContainerInitializationState getContainerState( CMContainer container ) {

        if ( container == null ) {
            return ContainerInitializationState.NOT_MOIN_RELEVANT;
        } else {
            return container.isInitialized( ) ? ContainerInitializationState.INITIALIZED : ContainerInitializationState.CLIENT_SPEC_ONLY_INITIALIZED;
        }
    }

    public ContainerInitializationState getContainerInitializationState( IProject eclipseProject ) {

        if ( !eclipseProject.isAccessible( ) ) {
            return ContainerInitializationState.NOT_MOIN_RELEVANT;
        }

        CMContainer container = getRegistry( ).getContainer( eclipseProject );


        // As long as we have no eventing ....
        if ( container == null ) {
            container = getRegistry( ).createProjectContainer( eclipseProject );
        }
        return getContainerState( container );
    }

    public ContainerInitializationState getContainerInitializationState( ClientSpec clientSpec, CRI cri ) {

        if ( getRegistry( ).getProject( cri ) == null ) {
            return ContainerInitializationState.NOT_MOIN_RELEVANT;
        }

        CMContainer container = getDelegatedInstance( ).getCMManager( ).getContainer( cri );
        return getContainerState( container );
    }

    public IFile getFile( PRI pri ) {

        IProject project = getProject( pri.getCri( ) );
        if ( project == null ) {
            return null; // PRI out-dated --> DC out-dated / deleted / invisible ...
        }

        IPath path = new Path( pri.getPartitionName( ) );
        // In opposition to IProject#findMember() this also returns an instance
        // for files not available in file system. Necessary to support lookup
        // for not yet persisted partitions.
        IFile file = project.getFile( path );
        return file;
    }

    public IProject getProject( CRI cri ) {

        IProject project = getRegistry( ).getProject( cri );
        if ( project != null && !project.isAccessible( ) ) {
            project = null;
        }
        return project;
    }

    public ClientSpec initializeClientSpec( IProject eclipseProject ) {

        getRegistry( );
        return getClientSpec( eclipseProject );
    }

    public IStatus prepareModification( Collection<PartitionOperation> affectedPartitions ) {

        ArrayList<PRI> partionPRIs = new ArrayList<PRI>( affectedPartitions.size( ) );
        for ( PartitionOperation pop : affectedPartitions ) {
            if ( pop.getOperation( ) == PartitionOperation.Operation.EDIT ) {
                partionPRIs.add( pop.getPartitionPri( ) );
            }
        }

        IFile[] files = TeamProviderVersioningSupport.getIFilesByPRI( getDelegatedInstance( ).getCMManager( ), partionPRIs );
        IStatus status = ResourcesPlugin.getWorkspace( ).validateEdit( files, null );
        return status;
    }

    public IStatus prepareModificationInProject( IProject project ) {

        CMContainer container = getRegistry( ).getContainer( project );
        if ( container != null ) {
            Collection<PRI> partitions = container.getPartitionsInContainer( );
            if ( partitions != null && partitions.size( ) > 0 ) {
                IFile[] files = TeamProviderVersioningSupport.getIFilesByPRI( getDelegatedInstance( ).getCMManager( ), partitions );
                IStatus status = ResourcesPlugin.getWorkspace( ).validateEdit( files, null );
                return status;
            }
        }
        return Status.OK_STATUS;
    }

    public IStatus prepareModificationHeadless( Collection<PartitionOperation> affectedPartitions ) {

        if ( affectedPartitions != null && affectedPartitions.size( ) > 0 ) {
            IFile[] files = TeamProviderVersioningSupport.getIFilesByPOperation( getDelegatedInstance( ).getCMManager( ), affectedPartitions );
            IStatus status = ResourcesPlugin.getWorkspace( ).validateEdit( files, null );
            return status;
        }
        return Status.OK_STATUS;
    }

    public IStatus prepareModificationInProjectHeadless( IProject project ) {

        return prepareModificationInProject( project );
    }

    public void refreshFromFileSystem( IProject project, boolean forced ) {

        if ( project == null ) {
            return;
        }

        CMContainer container = getRegistry( ).getContainer( project );
        if ( container != null ) {
            if ( forced ) {
                container = getRegistry( ).createProjectContainer( project );
                if ( container == null ) {
                    return;
                }
            }
            container.updateContainer( forced );
        }
    }


    public void refreshClientSpecFromFileSystem( IProject eclipseProject ) {

        getRegistry( ).initialize( );
    }

    public ProjectContentTypeRegistry getCtRegistry( ) {

        return ctRegistry;
    }
}
