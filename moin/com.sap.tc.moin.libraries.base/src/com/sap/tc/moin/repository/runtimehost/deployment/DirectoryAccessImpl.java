package com.sap.tc.moin.repository.runtimehost.deployment;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;



/**
 * File access wrapper.
 * 
 * @author d031150
 */
public class DirectoryAccessImpl implements IpiMetamodelArchiveAccess {

    File file;

    public DirectoryAccessImpl( File file ) throws IOException {

        this.file = file;
    }

    public String getArchiveId( ) {

        return this.file.getName( );
    }

    public long getLastModified( ) {

        return this.file.lastModified( );
    }

    public InputStream getResourceAsStream( String resourceName ) throws IOException {

        File resFile = new File( this.file, resourceName );
        if ( resFile.exists( ) ) {
            return new FileInputStream( resFile );
        } else {
            return null;
        }
    }

    public boolean resourceExists( String resourceName ) {

        File resFile = new File( this.file, resourceName );
        return resFile.exists( );

    }

    public void close( ) throws IOException {

    }

    public long getContentLength( String resourceName ) {

        File resFile = new File( this.file, resourceName );
        if ( resFile.exists( ) ) {
            return resFile.length( );
        } else {
            return -1;
        }
    }

}