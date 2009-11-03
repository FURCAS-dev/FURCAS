package com.sap.tc.moin.facility.versioning.eclipse;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

import com.sap.tc.moin.facility.componentmodel.CMContainer;
import com.sap.tc.moin.facility.componentmodel.CMManager;
import com.sap.tc.moin.facility.versioning.IpiAbstractVersioningSupport;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.commands.PartitionOperation;
import com.sap.tc.moin.repository.spi.facility.SpiPersistence.SpiPartitionSaveContext;
import com.sap.tc.moin.repository.spi.facility.SpiPersistence.SpiSaveOperation;


public class TeamProviderVersioningSupport extends IpiAbstractVersioningSupport {

    protected CMManager cmManager;

    public void bind( CMManager manager ) {

        this.cmManager = manager;
    }

    private static IFile[] EMPTY_FILE_LIST = new IFile[0];

    public static IFile[] getIFilesByPOperation( CMManager cmManager, Collection<PartitionOperation> partitions ) {

        if ( partitions == null || partitions.size( ) == 0 ) {
            return EMPTY_FILE_LIST;
        }

        List<IFile> files = new ArrayList<IFile>( partitions.size( ) );
        for ( PartitionOperation pOp : partitions ) {
            PRI pri = pOp.getPartitionPri( );

            CMContainer container = cmManager.getContainer( pri.getCri( ) );
            IProject project = (IProject) container.getResponsible( );
            if ( project == null ) {
                continue;
            }

            IPath path = new Path( pri.getPartitionName( ) );
            IFile file = project.getFile( path );
            files.add( file );
        }
        return files.toArray( new IFile[files.size( )] );
    }

    public static IFile[] getIFilesByPRI( CMManager cmManager, Collection<PRI> partitions ) {

        if ( partitions == null || partitions.size( ) == 0 ) {
            return EMPTY_FILE_LIST;
        }

        List<IFile> files = new ArrayList<IFile>( partitions.size( ) );
        for ( PRI pri : partitions ) {
            CMContainer container = cmManager.getContainer( pri.getCri( ) );
            IProject project = (IProject) container.getResponsible( );
            if ( project == null ) {
                continue;
            }

            IPath path = new Path( pri.getPartitionName( ) );
            IFile file = project.getFile( path );
            files.add( file );
        }
        return files.toArray( new IFile[files.size( )] );
    }

    public static IFile[] getIFilesByPartitionSaveContext( CMManager cmManager, Collection<SpiPartitionSaveContext> partitions ) {

        if ( partitions == null || partitions.size( ) == 0 ) {
            return EMPTY_FILE_LIST;
        }

        List<IFile> files = new ArrayList<IFile>( partitions.size( ) );
        for ( SpiPartitionSaveContext context : partitions ) {
            PRI pri = context.getPri( );

            CMContainer container = cmManager.getContainer( pri.getCri( ) );
            IProject project = (IProject) container.getResponsible( );
            if ( project == null ) {
                continue;
            }

            IPath path = new Path( pri.getPartitionName( ) );
            IFile file = project.getFile( path );
            files.add( file );
        }
        return files.toArray( new IFile[files.size( )] );
    }

    @Override
    public void processPartitions( Collection<SpiPartitionSaveContext> partitions, SpiSaveOperation spiSaveOperation ) {

        if ( spiSaveOperation == SpiSaveOperation.EDIT && partitions != null && partitions.size( ) > 0 ) {
            IFile[] files = getIFilesByPartitionSaveContext( cmManager, partitions );
            /* IStatus status = */ ResourcesPlugin.getWorkspace( ).validateEdit( files, null );
            //TODO Map status to partitions.signalFail( Throwable ) in case of errors.
        }
    }
}
