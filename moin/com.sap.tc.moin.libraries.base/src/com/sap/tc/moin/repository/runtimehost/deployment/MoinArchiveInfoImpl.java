package com.sap.tc.moin.repository.runtimehost.deployment;

import com.sap.tc.moin.repository.Moin;
import com.sap.tc.moin.repository.runtimehost.deployment.MmInfoImpl.StatusListener;

/**
 * Class containing all MOIN archive parts.
 * 
 * @author D026715
 */
public class MoinArchiveInfoImpl implements StatusListener {

    protected MoinArchiveDescriptorImpl moinArchiveDescriptor = null;

    private IpiMetamodelArchiveAccess archiveAccess = null;

    private StatusListener statusListener;

    private MmInfoImpl mmInfo;

    private String deploymentId;

    private boolean deployable = false;

    public MoinArchiveInfoImpl( IpiMetamodelArchiveAccess archiveAccess ) {

        this.archiveAccess = archiveAccess;
        this.deploymentId = archiveAccess.getArchiveId( );
    }

    public MoinArchiveInfoImpl( IpiMetamodelArchiveAccess archiveAccess, String deploymentId ) {

        this.archiveAccess = archiveAccess;
        this.deploymentId = deploymentId;
    }

    public void loadArchiveContent( ) {

        this.moinArchiveDescriptor = new MoinArchiveDescriptorImpl( this.archiveAccess );

        this.moinArchiveDescriptor.load( this.archiveAccess );
    }

    public MoinArchiveDescriptorImpl getArchiveDescriptor( ) {

        return moinArchiveDescriptor;
    }

    public IpiMetamodelArchiveAccess getArchiveAccess( ) {

        return archiveAccess;
    }


    public String getDeploymentId( ) {

        return deploymentId;
    }

    public void registerStatusListener( StatusListener listener ) {

        this.statusListener = listener;
    }

    /**
     * Initializes the metamodel info from the moin archive. Returns null if
     * there is no metamodel.
     * 
     * @param moin
     * @param loader
     * @return the meta-model info or <code>null</code>, if the archive does not
     * contain a metamodel
     */
    public MmInfoImpl createMmInfo( Moin moin, IpiCustomSerializationClassLoader loader ) {

        // if there is no metamodel archive descriptor, stop at once
        if ( this.getArchiveDescriptor( ).getMetamodelArchiveDescriptor( ) == null ) {
            return null;
        }

        this.mmInfo = new MmInfoImpl( this.archiveAccess, this.getArchiveDescriptor( ).getMetamodelArchiveDescriptor( ), this.getArchiveDescriptor( ).getArchiveHeader( ) );
        this.mmInfo.registerStatusListener( this );

        this.mmInfo.load( moin, loader );
        return this.mmInfo;
    }

    public MmInfoImpl getMmInfo( ) {

        return this.mmInfo;
    }

    /**
     * Resets the metamodel info. Called in the server scenario.
     */
    public void resetMetamodel( ) {

        this.mmInfo = null;
        this.disableDeployment( );
    }

    public void disableDeployment( ) {

        if ( this.statusListener != null ) {
            this.statusListener.disableDeployment( );
        }
        this.deployable = false;
    }

    public void disableDeployment( Exception ex ) {

        if ( this.statusListener != null ) {
            this.statusListener.disableDeployment( ex );
        }
        this.deployable = false;
    }

    public void enableDeployment( ) {

        if ( this.statusListener != null ) {
            this.statusListener.enableDeployment( );
        }
        this.deployable = true;
    }

    public void errorMessage( String message ) {

        if ( this.statusListener != null ) {
            this.statusListener.errorMessage( message );
        }
    }

    public void handleVersionDifference( ) {

        if ( this.statusListener != null ) {
            this.statusListener.handleVersionDifference( );
        }
    }

    public MoinArchiveHeader getArchiveHeader( ) {

        return this.moinArchiveDescriptor.getArchiveHeader( );
    }

    public boolean deployable( ) {

        return this.deployable;
    }

    public void setDeployed( ) {

        if ( this.statusListener != null ) {
            this.statusListener.setDeployed( );
        }
    }


}
