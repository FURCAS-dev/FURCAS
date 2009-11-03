package com.sap.tc.moin.facility.primary.ide.persistence.lfs.ecl;

import java.io.ByteArrayInputStream;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;

import com.sap.tc.moin.facility.primary.ipi.fs.lfs.IpiLogicalFile;
import com.sap.tc.moin.facility.primary.ipi.fs.lfs.IpiLogicalFolder;
import com.sap.tc.moin.facility.primary.ipi.fs.lfs.IpiLogicalResource;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;

/**
 * The implementation of the logical filesystem folder API
 * {@link com.sap.tc.moin.facility.primary.ipi.fs.lfs.IpiLogicalFolder}
 */
public class EclFolderImpl extends EclResourceImpl implements IpiLogicalFolder {

    private static final MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_PRIMARY_FACILITY, MoinLocationEnum.MOIN_FACILITIES_PRIMARY_PERSISTENCE_FS, EclFolderImpl.class );

    private final IExcludeFromSourceControlHandler efscHandler;

    protected static IpiLogicalResource getResource( IResource file, IExcludeFromSourceControlHandler excludeHandler ) {

        if ( file == null ) {
            return null;
        }
        if ( !file.exists( ) ) {
            // file does not exist
            return null;
        }

        if ( isFolderCategory( file.getType( ) ) ) {
            return new EclFolderImpl( file, excludeHandler );

        } else {
            /*
             * if(file.getName().endsWith(".jar")){ / Must be a build result:
             * Currently JAR create a JarFile instance as a test
             */
            /*
             * JarFile jarFile = new JarFile(file); jarFile.close(); return new
             * EclArchive(file); }
             */
            return new EclFileImpl( file );
        }
    }

    protected static IResource fileCreate( IPath resPath, boolean isDir ) {

        IResource res = EclFolderImpl.getResHandle( resPath, isDir );
        if ( res.exists( ) ) {
            RuntimeException e = new RuntimeException( "Could not create File! Reason: File already exists: " + res.getFullPath( ) );
            if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
                LOGGER.trace( e, MoinSeverity.DEBUG, "Could not create File! Reason: File already exists:  " + res.getFullPath( ) );
            }
            throw e;
        }
        if ( isDir ) {
            IFolder folder = (IFolder) res;
            createFolder( folder );
        } else {
            IFile file = (IFile) res;
            IContainer parent = file.getParent( );
            if ( !parent.exists( ) ) {
                IFolder parf = (IFolder) parent;
                createFolder( parf );
            }
            try {
                file.create( new ByteArrayInputStream( new byte[] {} ), IResource.FORCE, null );
                // exclude file from workspace monitor handling
            } catch ( CoreException e ) {
                if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
                    LOGGER.trace( e, MoinSeverity.DEBUG, "Could not create File: " + res.getFullPath( ));
                }
                throw new RuntimeException( "Could not create File: " + res.getFullPath( ), e );
            }
            excludeFromSourceControl( file );
        }
        return res;
    }

    /**
     * The method excludes a MOIN model partiton from DTR client's workspace
     * monitor. workspace monitor has a resource change listener and shows an
     * Add To DTR dialog for newly created resources. MOIN DII integration adds
     * new model partitions to source control using DII API without showing a
     * dialog.
     * 
     * @param resource
     * @throws CoreException
     */
    private static void excludeFromSourceControl( IResource resource ) {

//        IRepositoryService repositoryService = DiiRepositoryService.getRepositoryService( resource );
//        if ( repositoryService == null ) {
//            return;
//        }
//        SourceControlWrapper sourceControl = (SourceControlWrapper) repositoryService.getSourceControl( );
//        if ( sourceControl == null ) {
//            return;
//        }
//        // We explicitly check if included. Otherwise we would allow an exclude below another exclude what we
//        // don't want.
//        try {
//            if ( sourceControl.isMonitorResource( resource ) ) {
//                sourceControl.setMonitorResource( resource, false );
//            }
//        } catch ( CoreException ce ) {
//            if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
//                LOGGER.trace( MoinSeverity.DEBUG, "Unable to remove resource from source control: " + resource.getFullPath( ), ce );
//            }
//            throw new RuntimeException( "Unable to remove resource from source control: " + resource.getFullPath( ), ce );
//        }
    }

    private static void createFolder( IFolder folder ) {

        // ensure parent exists
        IContainer parent = folder.getParent( );
        if ( !parent.exists( ) ) {
            IFolder parf = (IFolder) parent;
            createFolder( parf );
        }
        try {
            folder.create( IResource.FORCE, true, null );
        } catch ( CoreException e ) {
            if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
                LOGGER.trace( e, MoinSeverity.DEBUG, "Could not create local folder " + folder.getFullPath( ) );
            }
            throw new RuntimeException( "Could not create local folder " + folder.getFullPath( ), e );
        }
    }

    private static IResource getResHandle( IPath path, boolean isDir ) {

        IWorkspace workspace = org.eclipse.core.resources.ResourcesPlugin.getWorkspace( );
        IContainer root = workspace.getRoot( );
        IResource res = null;
        if ( isDir ) {
            res = root.getFolder( path );
        } else {
            res = root.getFile( path );
        }
        return res;
    }

    protected static IResource getRes( IPath path ) {

        IWorkspace workspace = org.eclipse.core.resources.ResourcesPlugin.getWorkspace( );
        IContainer root = workspace.getRoot( );
        IResource res = root.findMember( path );
        return res;
    }

    protected EclFolderImpl( IResource file, IExcludeFromSourceControlHandler excludeHandler ) {

        super( file );
        efscHandler = excludeHandler;

    }

    public IpiLogicalResource[] listResources( ) {

        IResource[] myFiles;
        try {
            myFiles = ( (IContainer) this.resource ).members( );
        } catch ( CoreException e ) {
            if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
                LOGGER.trace( e, MoinSeverity.DEBUG, "No children found: " + resource.getFullPath( ) );
            }
            // no members
            return null;
        }

        IpiLogicalResource[] res = new IpiLogicalResource[myFiles.length];
        for ( int i = 0; i < myFiles.length; i++ ) {
            if ( myFiles[i] != null ) {
                if ( isFolderCategory( myFiles[i].getType( ) ) ) {
                    res[i] = new EclFolderImpl( myFiles[i], efscHandler );
                } else {
                    res[i] = new EclFileImpl( myFiles[i] );
                }
            }
        }
        return res;
    }

    @Override
    public boolean isFolder( ) {

        return true;
    }

    @Override
    public boolean isFile( ) {

        return false;
    }

    public boolean isArchive( ) {

        return false;
    }

    public IpiLogicalResource getResource( String relativePath ) {

        IPath path = this.resource.getFullPath( ).append( relativePath );
        IResource res = EclFolderImpl.getRes( path );
        return EclFolderImpl.getResource( res, efscHandler );
    }

    public IpiLogicalFile createFile( String relativePath ) {

        if ( relativePath == null ) {
            throw new NullPointerException( "Argument relativePath must not be null." );
        } else if ( relativePath.length( ) <= 0 ) {
            IllegalArgumentException e = new IllegalArgumentException( "Argument relativePath must not be empty" );
            if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
                LOGGER.trace( e, MoinSeverity.DEBUG, "Invalid argument " + relativePath );
            }

            throw e;
        }

        IPath path = this.resource.getFullPath( ).append( relativePath );
        return new EclFileImpl( EclFolderImpl.fileCreate( path, false ) );
    }
}
