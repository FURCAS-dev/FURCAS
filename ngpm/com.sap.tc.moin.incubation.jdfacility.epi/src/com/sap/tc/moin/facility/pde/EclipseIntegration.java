package com.sap.tc.moin.facility.pde;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;


public class EclipseIntegration {

    private static IWorkspace getWorkspace( ) {

        return org.eclipse.core.resources.ResourcesPlugin.getWorkspace( );
    }

    private static class ResourceChangeListener implements IResourceChangeListener {

        public void resourceChanged( IResourceChangeEvent event ) {

        }
    }

//    private static class FileStreamProvider implements InputStreamProvider {
//
//        private IFile _file = null;
//
//        public FileStreamProvider( IFile file ) {
//
//            super( );
//            this._file = file;
//        }
//
//        public InputStream getInputStream( ) {
//
//            // provider delegates to StorageHandler to obtain streams
//            InputStream stream;
//            try {
//                stream = this._file.getContents( );
//            } catch ( CoreException e ) {
//                throw new RuntimeException( e );
//            }
//            return stream;
//        }
//    };
//
//    private PartitionResourceRecord getResourceRecordForIFile( IFile file ) {
//
//        IProject project = file.getProject( );
//        // we must use toOSString here to make sure that the string compare works (is also used by the project handler before resource registration)
//        String rootPath = project.getFullPath( ).toOSString( );
//
//        // get relative partition name
//        String partitionName = file.getProjectRelativePath( ).toString( );
//
//        // time stamp and stream provider are required only for some operations
//        // set default
//        long timestamp = 0L;
//        InputStreamProvider streamProvider = null;
//        PartitionResourceRecord.Operation operation;
//
//        if ( file.exists( ) ) {
//            // get time stamp
//            timestamp = file.getLocalTimeStamp( );
//
//            // use resource for stream provider
//            streamProvider = new FileStreamProvider( file );
//
//            operation = PartitionResourceRecord.Operation.CHANGED;
//        } else {
//            operation = PartitionResourceRecord.Operation.DELETED;
//        }
//
//        // set up partition resource record
//        PartitionResourceRecord prr = new PartitionResourceRecord( );
//        prr.rootPath = rootPath;
//        prr.partitionName = partitionName;
//        prr.timestamp = timestamp;
//        prr.streamProvider = streamProvider;
//        prr.operation = operation;
//        return prr;
//    }

    private ResourceChangeListener resourceChangeListener = null;

    public synchronized void startListening( ) {

        if ( resourceChangeListener == null ) {
            resourceChangeListener = new ResourceChangeListener( );

            getWorkspace( ).addResourceChangeListener( resourceChangeListener, IResourceChangeEvent.POST_BUILD | IResourceChangeEvent.POST_CHANGE );
        }
    }

    public synchronized void stopListening( ) {

        if ( resourceChangeListener != null ) {
            ResourcesPlugin.getWorkspace( ).removeResourceChangeListener( resourceChangeListener );
            resourceChangeListener = null;
        }

    }

    public static void refreshEclipseResources( final IProject project ) {

        if ( !project.isOpen( ) ) {
            return; // resources in closed Eclipse projects are invisible for Eclipse and therefore those resources do not need to be refreshed 
        }

        // The refresh is performed in a workspace runnable, so that the initiated EclipseResourceChange-Events are bundled and the broadcast after the refresh (IWorkspace.AVOID_UPDATE)
        IWorkspaceRunnable runnable = new IWorkspaceRunnable( ) {

            public void run( IProgressMonitor monitor ) throws CoreException {

                project.refreshLocal( IResource.DEPTH_INFINITE, monitor ); // do not catch CoreException of refreshLocal here but caller will catch it and decide how to handle it.
            }
        };

        try {
            ResourcesPlugin.getWorkspace( ).run( runnable, project, IWorkspace.AVOID_UPDATE, null );
        } catch ( CoreException e ) {
            throw new RuntimeException( "Refresh for Eclipse project [" + project.getName( ) + "] failed: " + e.getMessage( ), e );
        }
    }

    public EclipseIntegration( ) {

        // TODO Auto-generated constructor stub
    }


}
