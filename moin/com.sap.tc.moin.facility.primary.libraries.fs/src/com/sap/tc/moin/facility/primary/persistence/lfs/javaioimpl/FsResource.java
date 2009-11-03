package com.sap.tc.moin.facility.primary.persistence.lfs.javaioimpl;

import java.io.File;
import java.io.IOException;

import com.sap.tc.moin.facility.primary.ipi.fs.lfs.IpiLogicalResource;
import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;

/**
 * The implementation of the logical filesystem resource API
 * {@link com.sap.tc.moin.facility.primary.ipi.fs.lfs.IpiLogicalResource}
 */
public abstract class FsResource implements IpiLogicalResource {

    protected File file;

    /**
     * @param file
     */
    protected FsResource( File file ) {

        this.file = file;
    }

    /*
     * (non-Javadoc)
     * @see com.sap.tc.moin.persistence.lfs.api.LogicalResource#exists()
     */
    public boolean exists( ) {

        return this.file.exists( );
    }

    /*
     * (non-Javadoc)
     * @see com.sap.tc.moin.persistence.lfs.api.LogicalResource#getName()
     */
    public String getName( ) {

        return this.file.getName( );
    }

    /*
     * (non-Javadoc)
     * @see com.sap.tc.moin.persistence.lfs.api.LogicalResource#isFolder()
     */
    public boolean isFolder( ) {

        return this.file.isDirectory( );
    }

    /*
     * (non-Javadoc)
     * @see com.sap.tc.moin.persistence.lfs.api.LogicalResource#isFile()
     */
    public boolean isFile( ) {

        return this.file.isFile( );
    }

    /*
     * (non-Javadoc)
     * @see com.sap.tc.moin.persistence.lfs.api.LogicalResource#isArchive()
     */
    public boolean isArchive( ) {

        // false for general resource
        return false;
    }

    /*
     * (non-Javadoc)
     * @see com.sap.tc.moin.persistence.lfs.api.LogicalResource#isReadOnly()
     */
    public boolean isReadOnly( ) {

        return !this.file.canWrite( );
    }

    /*
     * (non-Javadoc)
     * @see com.sap.tc.moin.persistence.lfs.api.LogicalResource#getPath()
     */
    public String getPath( ) {

        return this.file.getPath( );
    }

    /*
     * (non-Javadoc)
     * @see
     * com.sap.tc.moin.persistence.lfs.api.LogicalResource#getCanonicalPath()
     */
    public String getCanonicalPath( ) {

        String canonicalPath = null;

        try {
            canonicalPath = this.file.getCanonicalPath( );
        } catch ( IOException e ) {
            throw new MoinLocalizedBaseRuntimeException( e, PersistenceLfsJavaioimplMessages.UNABLE_TO_DETERMINE_CANONICAL_PATH, this.file.getAbsolutePath( ) );
        }

        return canonicalPath;
    }

    /*
     * (non-Javadoc)
     * @see com.sap.tc.moin.persistence.lfs.api.LogicalResource#lastChangeTime()
     */
    public long lastChangedTime( ) {

        long timeStamp = this.file.lastModified( );
        if ( timeStamp == 0 ) {
            return -1;
        } else {
            return timeStamp;
        }
    }

    public <T> T getUnderlyingResource( Class<T> typeToken ) {

        return typeToken.isInstance( this.file ) ? typeToken.cast( this.file ) : null;
    }
}
