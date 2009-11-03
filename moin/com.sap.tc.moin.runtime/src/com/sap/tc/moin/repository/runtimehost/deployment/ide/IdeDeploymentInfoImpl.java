package com.sap.tc.moin.repository.runtimehost.deployment.ide;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;
import org.osgi.framework.Constants;

import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.ide.metamodels.MmDeploymentInfo;
import com.sap.tc.moin.repository.ide.metamodels.MmDeploymentStatus;
import com.sap.tc.moin.repository.metamodels.MetaModelVersion;
import com.sap.tc.moin.repository.runtimehost.deployment.IpiMetamodelArchiveAccess;
import com.sap.tc.moin.repository.runtimehost.deployment.MetaModelArchiveDescriptor;
import com.sap.tc.moin.repository.runtimehost.deployment.MmInfoImpl;
import com.sap.tc.moin.repository.runtimehost.deployment.MoinArchiveHeader;
import com.sap.tc.moin.repository.runtimehost.deployment.MoinArchiveInfoImpl;
import com.sap.tc.moin.repository.runtimehost.deployment.MmInfoImpl.StatusListener;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;

/**
 * Deployment info implementation. The class is used for the deployment
 * overview.
 * 
 * @author D026715
 */
public class IdeDeploymentInfoImpl implements MmDeploymentInfo, StatusListener {

    public static MoinLogger log = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_RUNTIME_HOST, MoinLocationEnum.MOIN_METAMODELS, IdeDeploymentInfoImpl.class );


    private static final String PLACEHOLDER = "<not set>"; //$NON-NLS-1$

    private Bundle bundle = null;

    private MmDeploymentStatus mmStatus = MmDeploymentStatus.UNKNOWN;

    public MoinArchiveInfoImpl archiveInfo;

    private String errorMessage;

    private Exception lastException;

    public IdeDeploymentInfoImpl( MoinArchiveInfoImpl archiveInfo, Bundle eclipseBundle ) {

        this.archiveInfo = archiveInfo;
        this.bundle = eclipseBundle;

        // register for status notifications
        if ( this.archiveInfo != null ) {
            this.archiveInfo.registerStatusListener( this );
        }
    }

    /**
     * Returns the bundle ID where the meta-model is located.
     * 
     * @return the bundle ID where the meta-model is located.
     * @see #getBundleName()
     */
    public String getBundleId( ) {

        return this.bundle.getSymbolicName( );
    }

    /**
     * Returns the descriptive name of the meta-model's bundle.
     * 
     * @return the descriptive name of the meta-model's bundle.
     * @see #getBundleId()
     */
    public String getBundleName( ) {

        return (String) this.bundle.getHeaders( ).get( Constants.BUNDLE_NAME );
    }

    /**
     * Returns the location where the metamodel is deployed to.
     * 
     * @return the location where the metamodel is deployed to.
     */
    private String getLocation( ) {

        try {
            URL loc = FileLocator.resolve( bundle.getEntry( "/" ) ); //$NON-NLS-1$
            return removeEclipseFileProtocol( loc ).toString( );
        } catch ( IOException e ) {
            throw new IllegalStateException( e );
        }
    }

    /**
     * Returns the metamodel's bundle.
     * 
     * @return the metamodel's bundle.
     */
    public Bundle getBundle( ) {

        return bundle;
    }

    /**
     * Removes the (wrong ?) "file:/" protocol header that Eclipse prepends in
     * {@link URL}s that are results of calls like
     * {@link Platform#asLocalURL(URL)}. The result is a valid {@link IPath}.
     * 
     * @return the reduced file path. For example "file:/C:/temp/fooBar.jar"
     * goes to "/C:/temp/fooBar.jar".
     */
    private IPath removeEclipseFileProtocol( URL url ) {

        //IPath path = new Path(url.toExternalForm()).makeRelative().setDevice(null);
        //path = path.setDevice(null);
        //return path.toString();
        return ( new Path( url.toExternalForm( ) ).makeRelative( ).setDevice( null ) );
    }

    /**
     * Sets the status of meta-model.
     * <p>
     * The supported status are defined by MmDeploymentStatus class:
     * <p>
     * - DEPLOYED, - NOT_DEPLOYED, - UNKNOWN.
     */
    public void setStatus( MmDeploymentStatus status ) {

        this.mmStatus = status;
        if ( status == MmDeploymentStatus.DEPLOYED ) {
            MmInfoImpl mmInfo = this.archiveInfo.getMmInfo( );
            if ( mmInfo != null ) {
                mmInfo.updateDeployedMetaModelVersion( );
            }
        }
        if ( this.mmStatus == MmDeploymentStatus.VERSION_DIFFER ) {
            this.errorMessage = IdeDeploymentMessages.VERSION_MISMATCH.format( getContainerName( ) );
        }
    }

    /**
     * Returns the status of meta-model.
     * <p>
     * The supported status are defined by MmDeploymentStatus class:
     * <p>
     * - DEPLOYED, - NOT_DEPLOYED, - VERSION_DIFFER, - ERROR_NOT_DEPLOYABLE, -
     * UNKNOWN.
     * 
     * @return the status of meta-model.
     */
    public MmDeploymentStatus getStatus( ) {

        return this.mmStatus;
    }

    public void handleVersionDifference( ) {

        this.setStatus( MmDeploymentStatus.VERSION_DIFFER );
    }

    public void disableDeployment( ) {

        this.setStatus( MmDeploymentStatus.ERROR_NOT_DEPLOYABLE );
    }

    public void disableDeployment( Exception ex ) {

        this.setStatus( MmDeploymentStatus.ERROR_NOT_DEPLOYABLE );
        this.lastException = ex;
        this.errorMessage = ex.getMessage( );
    }

    public void enableDeployment( ) {

        this.setStatus( MmDeploymentStatus.NOT_DEPLOYED );
    }

    public void setDeployed( ) {

        this.setStatus( MmDeploymentStatus.DEPLOYED );
    }

    @Override
    public String toString( ) {

        StringBuffer sb = new StringBuffer( "Name: " ); //$NON-NLS-1$
        sb.append( this.getContainerName( ) );
        sb.append( "\nBundle: " ); //$NON-NLS-1$
        sb.append( this.getBundleId( ) );
        sb.append( "\nLocation: " ); //$NON-NLS-1$
        sb.append( getLocation( ) );
        sb.append( "\nXMI archive: " ); //$NON-NLS-1$
        // sb.append( getXmiArchivePath( ) );
        //        sb.append("\nMain XMI: ");
        //        sb.append(getMainXmiFilePath());

        return sb.toString( );
    }

    private MetaModelArchiveDescriptor getMetamodelArchiveDescriptor( ) {

        return this.archiveInfo.getArchiveDescriptor( ).getMetamodelArchiveDescriptor( );
    }

    /**
     * Returns the version of currently available Moin meta-model. This means
     * Moin meta-model that is available as Eclipse plug-in and used to load JMI
     * classes.
     * 
     * @return the version of currently available meta-model.
     */
    public MetaModelVersion getMetaModelPluginVersion( ) {

        MoinArchiveHeader archiveHeader = this.archiveInfo.getArchiveDescriptor( ).getArchiveHeader( );
        if ( archiveHeader != null ) {
            return archiveHeader.getVersion( );
        }
        return new MetaModelVersion( ) {

            public String getVersionString( ) {

                return PLACEHOLDER;
            }
        };
    }

    private static String createPlaceholder( String field ) {

        if ( field == null ) {
            field = PLACEHOLDER;
        }
        return field;
    }

    public String getFacilityName( ) {

        if ( this.getMetamodelArchiveDescriptor( ) != null ) {
            return createPlaceholder( this.getMetamodelArchiveDescriptor( ).getFacilityName( ) );
        } else {
            return PLACEHOLDER;
        }
    }

    public String getLabel( ) {

        if ( this.archiveInfo != null ) {
            MoinArchiveHeader archiveHeader = this.archiveInfo.getArchiveHeader( );
            if ( archiveHeader != null ) {
                return createPlaceholder( archiveHeader.getLabel( ) );
            }
        }
        return PLACEHOLDER;

    }

    public String getLastReportedErrorMessage( ) {

        return this.errorMessage;
    }

    public Exception getLastReportedException( ) {

        return this.lastException;
    }


    public void setLastErrorMessage( String message ) {

        this.errorMessage = message;
    }

    public Collection<PRI> getPRIs( ) throws IOException {

        if ( this.archiveInfo.getMmInfo( ) != null ) {
            return this.archiveInfo.getMmInfo( ).getPRIs( );
        } else {
            return new ArrayList<PRI>( 0 );
        }

    }

    public InputStream getPartitionStream( PRI pri ) throws IOException {

        if ( this.archiveInfo.getMmInfo( ) != null ) {
            return this.archiveInfo.getMmInfo( ).getPartitionStream( pri );
        } else {
            return null;
        }
    }

    public String getXmiArchivePath( ) {

        if ( this.archiveInfo != null ) {
            return this.archiveInfo.getMmInfo( ).getXmiArchivePath( );
        } else {
            return null;
        }
    }

    public String getContainerName( ) {

        if ( this.archiveInfo != null ) {
            MoinArchiveHeader archiveHeader = this.archiveInfo.getArchiveHeader( );
            if ( archiveHeader != null ) {
                return archiveHeader.getContainerName( );
            }
        }
        return PLACEHOLDER;

    }

    public String getDeployedMetaModelFacilityName( ) {

        if ( this.archiveInfo.getMmInfo( ) != null ) {
            return this.archiveInfo.getMmInfo( ).getDeployedMetaModelFacilityName( );
        } else {
            return PLACEHOLDER;
        }
    }

    public MetaModelVersion getDeployedMetaModelVersion( ) {

        if ( this.archiveInfo.getMmInfo( ) != null ) {
            return this.archiveInfo.getMmInfo( ).getDeployedMetaModelVersion( );
        } else {
            return new MetaModelVersion( ) {

                public String getVersionString( ) {

                    return PLACEHOLDER;
                }
            };
        }
    }

    public String getName( ) {

        if ( this.getMetamodelArchiveDescriptor( ) != null ) {
            return this.getMetamodelArchiveDescriptor( ).getName( );
        } else {
            return null;
        }
    }

    public String getVendor( ) {

        if ( this.archiveInfo != null ) {
            MoinArchiveHeader archiveHeader = this.archiveInfo.getArchiveHeader( );
            if ( archiveHeader != null ) {
                return archiveHeader.getVendor( );
            }
        }
        return PLACEHOLDER;
    }

    public void errorMessage( String message ) {

        this.errorMessage = message;

    }

    public Collection<String> getDeployedRegistrationFiles( ) {

        return Collections.unmodifiableCollection( this.archiveInfo.getArchiveDescriptor( ).getDeployedResources( ) );
    }

    public String getRegistrationFileContent( String resourceName ) throws IOException {

        IpiMetamodelArchiveAccess archiveAccess = this.archiveInfo.getArchiveAccess( );
        InputStream is = archiveAccess.getResourceAsStream( resourceName );
        if ( is != null ) {
            ByteArrayOutputStream out = new ByteArrayOutputStream( );
            while ( is.available( ) > 0 ) {
                byte[] bytes = new byte[is.available( )];
                is.read( bytes );
                out.write( bytes );
            }
            return new String( out.toByteArray( ), "UTF-8" ); //$NON-NLS-1$
        }
        return null;
    }

}
