package com.sap.tc.moin.facility.pde;


import java.io.File;

import org.eclipse.core.resources.ResourcesPlugin;

import com.sap.tc.moin.facility.filesystem.FileSystemFacility;
import com.sap.tc.moin.facility.primary.ide.persistence.lfs.ecl.EclFsFactoryImpl;
import com.sap.tc.moin.facility.primary.persistence.lfs.javaioimpl.FsFactory;
import com.sap.tc.moin.facility.versioning.eclipse.FsPersistenceVersionedImpl;
import com.sap.tc.moin.facility.versioning.eclipse.TeamProviderVersioningSupport;
import com.sap.tc.moin.repository.spi.core.SpiCore;
import com.sap.tc.moin.repository.spi.runtimehost.context.SpiRuntimeContext;
import com.sap.tc.moin.repository.spi.runtimehost.cp.SpiPartitionSerializationManager;


public class EclipsePDEFacility extends FileSystemFacility {

    static {
        System.setProperty( "com.sap.tc.moin.facility.primary.persistence.fs.AllSourceFoldersAreDirectoryFS", "false" ); //$NON-NLS-1$ //$NON-NLS-2$
    }

    public EclipsePDEFacility( SpiCore core, SpiPartitionSerializationManager serializationManager, SpiRuntimeContext runtimeContext, String indexLocation ) {

        super( core, serializationManager, runtimeContext, indexLocation );
    }

    public EclipsePDEFacility( SpiCore core, SpiPartitionSerializationManager serializationManager, SpiRuntimeContext runtimeContext ) {

        this( core, serializationManager, runtimeContext, getIndexLocation( ) );
    }

    private TeamProviderVersioningSupport versioning;

    private FacilityResourceChangeListenerImpl resourceChangeListener;

    @Override
    public String getId( ) {

        return "EF"; //$NON-NLS-1$
    }

    public SpiCore getCore( ) {

        return core;
    }

    @Override
    protected void configureFacility( ) {

        // Create eclipse specific components
        this.fsFactoryDirectory = new EclFsFactoryImpl( ); // Eclipse FS for sources
        this.fsFactoryArchive = new FsFactory( ); // Java FS for archives
        this.fsPersistence = new FsPersistenceVersionedImpl( this.core.getMoinId( ) + "-" + getId( ), this.core.getReferenceQueue( ) ); //$NON-NLS-1$

        // Versioning
        push( this.versioning = new TeamProviderVersioningSupport( ) );

        // Savelocking
        push( this.saveLocking = new IdeExternalSaveLocking( ) );

        push( this.resourceChangeListener = new FacilityResourceChangeListenerImpl( ) );

        super.configureFacility( );

        // Versioning
        this.versioning.bind( getCMManager( ) );

        ( (FsPersistenceVersionedImpl) this.fsPersistence ).bind( this.versioning );
        ( (IdeExternalSaveLocking) this.saveLocking ).bind( this.getResourceManagement( ) );

        this.resourceChangeListener.bind( super.resourceManagement );
        this.resourceChangeListener.bind( super.partitionSerializationManager );

    }

    protected static void assureDirExists( String tgtDir ) {

        if ( tgtDir.endsWith( File.separator ) ) {
            tgtDir = tgtDir.substring( 0, tgtDir.length( ) - 1 );
        }
        File f = new File( tgtDir );
        if ( f.exists( ) && f.isDirectory( ) ) {
            return; // happy
        }
        if ( f.exists( ) && !f.isDirectory( ) ) {
            throw new IllegalStateException( "Unable to create Dir " + tgtDir + " File exists!" ); //$NON-NLS-1$ //$NON-NLS-2$
        }
        boolean res = f.mkdirs( );
        if ( res == false ) {
            throw new IllegalStateException( "Unable to create directory " + tgtDir ); //$NON-NLS-1$
        }
    }

    protected static String grantIndexBasePath( ) {

        String wsdir = ResourcesPlugin.getWorkspace( ).getRoot( ).getLocation( ).toOSString( );
        wsdir = wsdir + "\\.metadata\\.plugins\\com.sap.tc.moin.facility.primary"; //$NON-NLS-1$
        assureDirExists( wsdir );
        return wsdir;
    }

    private static String getIndexLocation( ) {

        String wsfile = grantIndexBasePath( ) + "\\moin_fsidx.dat"; //$NON-NLS-1$
        return wsfile;
    }
}
