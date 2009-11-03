package com.sap.tc.moin.facility.primary.ide.persistence.lfs.ecl;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

import com.sap.tc.moin.facility.primary.ipi.IpiFacilityComponent;
import com.sap.tc.moin.facility.primary.ipi.fs.lfs.IpiLogicalFile;
import com.sap.tc.moin.facility.primary.ipi.fs.lfs.IpiLogicalFolder;
import com.sap.tc.moin.facility.primary.ipi.fs.lfs.IpiLogicalFsFactory;
import com.sap.tc.moin.facility.primary.ipi.fs.lfs.IpiLogicalResource;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;

/**
 * The implementation of the logical filesystem pluggable API
 * {@link com.sap.tc.moin.facility.primary.persistence.lfs.LogicalFSPluggable}
 */
public class EclFsFactoryImpl implements IpiLogicalFsFactory, IpiFacilityComponent {

    private static final MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_PRIMARY_FACILITY, MoinLocationEnum.MOIN_FACILITIES_PRIMARY_PERSISTENCE_FS, EclFsFactoryImpl.class );

    public EclFsFactoryImpl( ) {

    }

    public void initialize( ) {

    }

    public void tearDown( ) {

    }

    public void finalizeStartup( ) {

    }

    IExcludeFromSourceControlHandler getExcludeHandler( ) {

        return null;
//        return new IExcludeFromSourceControlHandler( ) {
//
//            public void excludeFromSourceControl( IResource resource ) {
//
//      IRepositoryService repositoryService = DiiRepositoryService.getRepositoryService( resource );
//      if ( repositoryService == null ) {
//          return;
//      }
//      SourceControlWrapper sourceControl = (SourceControlWrapper) repositoryService.getSourceControl( );
//      if ( sourceControl == null ) {
//          return;
//      }
//      // We explicitly check if included. Otherwise we would allow an exclude below another exclude what we
//      // don't want.
//      try {
//          if ( sourceControl.isMonitorResource( resource ) ) {
//              sourceControl.setMonitorResource( resource, false );
//          }
//      } catch ( CoreException ce ) {
//          if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
//              LOGGER.trace( MoinSeverity.DEBUG, "Unable to remove resource from source control: " + resource.getFullPath( ), ce );
//          }
//          throw new RuntimeException( "Unable to remove resource from source control: " + resource.getFullPath( ), ce );
//      }        
//            }
//        };
    }

    public IpiLogicalResource getResource( String absolutePath ) {

        IPath path = new Path( absolutePath );
        IResource res = EclFolderImpl.getRes( path );
        if ( res == null ) {
            return null;
        }
        return EclFolderImpl.getResource( res, getExcludeHandler( ) );
    }

    public IpiLogicalFile createFile( String absolutePath ) {

        if ( absolutePath == null ) {
            throw new NullPointerException( "Argument absolutePath must not be null." );
        } else if ( absolutePath.length( ) <= 0 ) {
            IllegalArgumentException e = new IllegalArgumentException( "Argument absolutePath must not be empty" );
            if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
                LOGGER.trace( e, MoinSeverity.DEBUG, "Invalid argument " + absolutePath );
            }
            throw e;
        }

        IPath path = new Path( absolutePath );
        return new EclFileImpl( EclFolderImpl.fileCreate( path, false ) );
    }

    public IpiLogicalFolder createFolder( String absolutePath ) {

        if ( absolutePath == null ) {
            NullPointerException e = new NullPointerException( "Argument absolutePath must not be null." );
            if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
                LOGGER.trace( e, MoinSeverity.DEBUG, "Invalid argument " + absolutePath );
            }
            throw e;
        } else if ( absolutePath.length( ) <= 0 ) {
            IllegalArgumentException e = new IllegalArgumentException( "Argument absolutePath must not be empty" );
            if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
                LOGGER.trace( e, MoinSeverity.DEBUG, "Invalid argument " + absolutePath );
            }
            throw e;
        }

        IPath path = new Path( absolutePath );
        return new EclFolderImpl( EclFolderImpl.fileCreate( path, true ), getExcludeHandler( ) );
    }

}
