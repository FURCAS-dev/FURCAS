package com.sap.tc.moin.repository.runtimehost.deployment;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;


/**
 * Archive access wrapper.
 * 
 * @author D026715
 */
public class ZipArchiveAccessImpl implements IpiMetamodelArchiveAccess {

    ZipFile zipFile;

    File file;

    public ZipArchiveAccessImpl( File xmiZipFile ) throws ZipException, IOException {

        this.file = xmiZipFile;
        this.zipFile = new ZipFile( xmiZipFile );
    }

    public String getArchiveId( ) {

        return this.zipFile.getName( );
    }

    public long getLastModified( ) {

        return this.file.lastModified( );
    }

    public InputStream getResourceAsStream( String resourceName ) throws IOException {

        ZipEntry entry = this.zipFile.getEntry( resourceName );
        if ( entry != null ) {
            return this.zipFile.getInputStream( entry );
        } else {
            return null;
        }
    }

    public boolean resourceExists( String resourceName ) {

        return ( this.zipFile.getEntry( resourceName ) != null );

    }

    public void close( ) throws IOException {

        this.zipFile.close( );
    }

    public long getContentLength( String resourceName ) {

        if ( this.resourceExists( resourceName ) ) {
            return this.zipFile.getEntry( resourceName ).getSize( );
        } else {
            return -1;
        }
    }

}