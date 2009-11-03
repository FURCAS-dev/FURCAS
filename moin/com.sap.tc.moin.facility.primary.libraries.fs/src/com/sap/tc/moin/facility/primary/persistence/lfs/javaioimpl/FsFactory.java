package com.sap.tc.moin.facility.primary.persistence.lfs.javaioimpl;

import java.io.File;

import com.sap.tc.moin.facility.primary.ipi.IpiFacilityComponent;
import com.sap.tc.moin.facility.primary.ipi.fs.lfs.IpiLogicalFile;
import com.sap.tc.moin.facility.primary.ipi.fs.lfs.IpiLogicalFolder;
import com.sap.tc.moin.facility.primary.ipi.fs.lfs.IpiLogicalFsFactory;
import com.sap.tc.moin.facility.primary.ipi.fs.lfs.IpiLogicalResource;
import com.sap.tc.moin.repository.exception.MoinIllegalArgumentException;
import com.sap.tc.moin.repository.exception.MoinNullPointerException;

/**
 * The implementation of the logical filesystem pluggable API
 * {@link com.sap.tc.moin.facility.primary.ipi.fs.lfs.IpiLogicalFsFactory}
 */
public class FsFactory implements IpiLogicalFsFactory, IpiFacilityComponent {

    public FsFactory( ) {

    }

    public void initialize( ) {

    }

    public void tearDown( ) {

    }

    public void finalizeStartup( ) {

    }

//    public LogicalResource getDefaultRoot( String configRoot ) {
//
//        LogicalResource res = this.getResource( configRoot );
//        if ( res == null ) {
//            res = this.createFolder( configRoot );
//        }
//        return res;
//    }

    public IpiLogicalResource getResource( String absolutePath ) {

        File file = new File( absolutePath );
        return FsFolder.getResource( file );
    }

    public IpiLogicalFile createFile( String absolutePath ) {

        if ( absolutePath == null ) {
            throw new MoinNullPointerException( PersistenceLfsJavaioimplMessages.ARGUMENT_MUST_NOT_BE_NULL, "absolutePath" ); //$NON-NLS-1$
        } else if ( absolutePath.equals( "" ) ) { //$NON-NLS-1$
            throw new MoinIllegalArgumentException( PersistenceLfsJavaioimplMessages.ARGUMENT_MUST_NOT_BE_EMPTY, "absolutePath" ); //$NON-NLS-1$
        }

        return new FsFile( fileCreate( absolutePath, false ) );
    }

    public IpiLogicalFolder createFolder( String absolutePath ) {

        if ( absolutePath == null ) {
            throw new MoinNullPointerException( PersistenceLfsJavaioimplMessages.ARGUMENT_MUST_NOT_BE_NULL, "absolutePath" ); //$NON-NLS-1$
        } else if ( absolutePath.equals( "" ) ) { //$NON-NLS-1$
            throw new MoinIllegalArgumentException( PersistenceLfsJavaioimplMessages.ARGUMENT_MUST_NOT_BE_EMPTY, "absolutePath" ); //$NON-NLS-1$
        }

        return new FsFolder( fileCreate( absolutePath, true ) );
    }

    private File fileCreate( String absolutePath, boolean isDir ) {

        File file = new File( absolutePath );
        return FsFolder.fileCreate( file, isDir );
    }

}
