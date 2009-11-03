package com.sap.tc.moin.facility.primary.ide.persistence.lfs.ecl;

import java.io.IOException;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourceAttributes;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;

import com.sap.tc.moin.facility.primary.ipi.fs.lfs.IpiLogicalResource;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;

/**
 * The implementation of the logical filesystem resource API
 * {@link com.sap.tc.moin.facility.primary.ipi.fs.lfs.IpiLogicalResource}
 */
public abstract class EclResourceImpl implements IpiLogicalResource {

    private static final MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_PRIMARY_FACILITY, MoinLocationEnum.MOIN_FACILITIES_PRIMARY_PERSISTENCE_FS, EclResourceImpl.class );

    public static final IProgressMonitor NO_PROGRESS_MONITOR = null;

    protected IResource resource;

    /**
     * @param file
     */
    protected EclResourceImpl( IResource file ) {

        this.resource = file;
    }

    /*
     * (non-Javadoc)
     * @see com.sap.tc.moin.persistence.lfs.api.LogicalResource#exists()
     */
    public boolean exists( ) {

        return this.resource.exists( );
    }

    /*
     * (non-Javadoc)
     * @see com.sap.tc.moin.persistence.lfs.api.LogicalResource#getName()
     */
    public String getName( ) {

        return this.resource.getName( );
    }

    // uh, 2006/11/21: We handle folder under a project and the project folder itself as EclFolderImpl
    // For eclipseResourceType see: IResource.getType()/.FOLDER/.PROJECT/ ... 
    protected static boolean isFolderCategory( int eclipseResourceType ) {

        if ( eclipseResourceType == IResource.FOLDER || eclipseResourceType == IResource.PROJECT ) {
            return true;
        }
        return false;
    }

    /*
     * (non-Javadoc)
     * @see com.sap.tc.moin.persistence.lfs.api.LogicalResource#isFolder()
     */
    public boolean isFolder( ) {

        return isFolderCategory( this.resource.getType( ) );
    }

    /*
     * (non-Javadoc)
     * @see com.sap.tc.moin.persistence.lfs.api.LogicalResource#isFile()
     */
    public boolean isFile( ) {

        return this.resource.getType( ) == IResource.FILE;
    }

    /*
     * (non-Javadoc)
     * @see com.sap.tc.moin.persistence.lfs.api.LogicalResource#isReadOnly()
     */
    public boolean isReadOnly( ) {

        ResourceAttributes att = this.resource.getResourceAttributes( );
        if ( att != null ) {
            return att.isReadOnly( );
        }
        return false;
    }

    /*
     * (non-Javadoc)
     * @see com.sap.tc.moin.persistence.lfs.api.LogicalResource#getPath()
     */
    public String getPath( ) {

        IPath path = this.resource.getFullPath( );
        if ( path != null ) {
            return path.toString( );
        }
        return null;
    }

    /*
     * (non-Javadoc)
     * @see
     * com.sap.tc.moin.persistence.lfs.api.LogicalResource#getCanonicalPath()
     */
    public String getCanonicalPath( ) {

        String canonicalPath = null;

        IPath resourceLocation = this.resource.getLocation( );
        try {
            // convert to Java.io.File to create a canonical path
            canonicalPath = resourceLocation.toFile( ).getCanonicalPath( );
        } catch ( IOException e ) {
            if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
                LOGGER.trace(e,  MoinSeverity.DEBUG, "Cannot determine canonical path for resource " + this.resource.getFullPath( ));
            }
            throw new RuntimeException( "Cannot determine canonical path for resource " + this.resource.getFullPath( ), e );
        }
        return canonicalPath;
    }

    /*
     * (non-Javadoc)
     * @see com.sap.tc.moin.persistence.lfs.api.LogicalResource#lastChangeTime()
     */
    public long lastChangedTime( ) {

        return this.resource.getLocalTimeStamp( );
    }

    protected void refreshEclipseResource( ) {

        try {
            if ( isFolder( ) ) {
                resource.refreshLocal( IResource.DEPTH_INFINITE, NO_PROGRESS_MONITOR );
            } else {
                resource.refreshLocal( IResource.DEPTH_ZERO, NO_PROGRESS_MONITOR );
            }
        } catch ( CoreException e ) {
            if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
                LOGGER.trace(e, MoinSeverity.DEBUG, "nable to refresh " + this.resource.getFullPath( ));
            }
            throw new RuntimeException( "Unable to refresh " + this.resource.getFullPath( ), e );
        }
    }

    public IResource getUnderlyingResource( ) {

        return this.resource;
    }

    public <T> T getUnderlyingResource( Class<T> typeToken ) {

        return typeToken.isInstance( this.resource ) ? typeToken.cast( this.resource ) : null;
    }
}
