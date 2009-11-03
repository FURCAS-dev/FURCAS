package com.sap.tc.moin.facility.primary.persistence.lfs.javaioimpl;

import java.io.File;
import java.io.IOException;

import com.sap.tc.moin.facility.primary.ipi.fs.lfs.IpiLogicalFile;
import com.sap.tc.moin.facility.primary.ipi.fs.lfs.IpiLogicalFolder;
import com.sap.tc.moin.facility.primary.ipi.fs.lfs.IpiLogicalResource;
import com.sap.tc.moin.repository.exception.MoinIllegalArgumentException;
import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;
import com.sap.tc.moin.repository.exception.MoinNullPointerException;

/**
 * The implementation of the logical filesystem folder API
 * {@link com.sap.tc.moin.facility.primary.ipi.fs.lfs.IpiLogicalFolder}
 */
public class FsFolder extends FsResource implements IpiLogicalFolder {

    protected static IpiLogicalResource getResource( File file ) {

        if ( !file.exists( ) ) {
            return null;
        }

        if ( file.isDirectory( ) ) {
            return new FsFolder( file );
        } else {
            return new FsFile( file );
        }
    }

    protected static File fileCreate( File file, boolean isDir ) {

        if ( file.exists( ) ) {
            if ( isDir ) {
                throw new MoinLocalizedBaseRuntimeException( PersistenceLfsJavaioimplMessages.UNABLE_TO_CREATE_FOLDER_ALREADY_EXISTS, file.getAbsolutePath( ) );
            } else {
                throw new MoinLocalizedBaseRuntimeException( PersistenceLfsJavaioimplMessages.UNABLE_TO_CREATE_FILE_ALREADY_EXISTS, file.getAbsolutePath( ) );
            }
        }
        FsFolder.createDirsOfPath( file.getAbsolutePath( ) );
        if ( isDir ) {
            boolean wasCreated = file.mkdir( );
            if ( !wasCreated ) {
                throw new MoinLocalizedBaseRuntimeException( PersistenceLfsJavaioimplMessages.UNABLE_TO_CREATE_FOLDER_CAUSE_UNKNOWN, file.getAbsolutePath( ) );
            }
        } else {
            boolean wasCreated = false;
            try {
                wasCreated = file.createNewFile( );
            } catch ( IOException ioe ) {
                throw new MoinLocalizedBaseRuntimeException( ioe, PersistenceLfsJavaioimplMessages.UNABLE_TO_CREATE_FILE, file.getAbsolutePath( ) );
            }
            if ( !wasCreated ) {
                throw new MoinLocalizedBaseRuntimeException( PersistenceLfsJavaioimplMessages.UNABLE_TO_CREATE_FILE_CAUSE_UNKNOWN, file.getAbsolutePath( ) );
            }
        }
        return file;
    }

    protected FsFolder( File file ) {

        super( file );
    }

    public IpiLogicalResource[] listResources( ) {

        File[] myFiles = this.file.listFiles( );
        if ( myFiles == null ) {
            return null;
        }
        IpiLogicalResource[] res = new IpiLogicalResource[myFiles.length];
        for ( int i = 0; i < myFiles.length; i++ ) {
            if ( myFiles[i] != null ) {
                if ( myFiles[i].isDirectory( ) ) {
                    res[i] = new FsFolder( myFiles[i] );
                } else {
                    res[i] = new FsFile( myFiles[i] );
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

    @Override
    public boolean isArchive( ) {

        return false;
    }

    public IpiLogicalResource getResource( String relativePath ) {

        File file = new File( this.file, relativePath );
        return FsFolder.getResource( file );
    }

    public IpiLogicalFile createFile( String relativePath ) {

        if ( relativePath == null ) {
            throw new MoinNullPointerException( PersistenceLfsJavaioimplMessages.ARGUMENT_MUST_NOT_BE_NULL, "relativePath" ); //$NON-NLS-1$
        } else if ( relativePath.length( ) <= 0 ) {
            throw new MoinIllegalArgumentException( PersistenceLfsJavaioimplMessages.ARGUMENT_MUST_NOT_BE_EMPTY, "relativePath" ); //$NON-NLS-1$
        }

        File file = new File( this.file, relativePath );

        return new FsFile( FsFolder.fileCreate( file, false ) );
    }

    public static boolean createDirsOfPath( String path ) {

        String p = path.replace( '\\', '/' );
        // check the whole path first
        int n = p.lastIndexOf( '/' );
        File file = new File( p.substring( 0, n ) );
        if ( file.exists( ) ) {
            return true;
        }
        String dir = ""; //$NON-NLS-1$
        String dirTmp;
        n = 0;
        int m = 0;
        while ( n >= 0 && n < p.length( ) ) {
            m = p.indexOf( '/', n );
            if ( m >= 0 ) {
                dirTmp = p.substring( n, m );
                dir = dir + dirTmp + "/"; //$NON-NLS-1$
                file = new File( dir );
                if ( !( file.exists( ) ) ) {
                    file.mkdir( );
                }
                /*
                 * don't return, some dir may be missing if(file.mkdir() ==
                 * false) { return false; }
                 */
                n = m + 1;
            } else {
                break;
            }
        }
        return true;
    }
}
