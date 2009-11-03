package com.sap.tc.moin.facility.primary.ipi.fs.lfs;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * File interface for reading and writing file content
 */
public interface IpiLogicalFile extends IpiLogicalResource {


    /**
     * @return true if existing and read only, false else
     */
    public boolean isReadOnly( );

    /**
     * Stream to read content
     * 
     * @return java.io.InputStream
     */
    public InputStream getInputStream( );

    /**
     * Stream to write content
     * 
     * @return java.io.OutputStream
     */
    public OutputStream getOutputStream( );

    /**
     * Returns the length of the logical file.
     * 
     * @return The length of this logical file.
     */
    public long getLength( );

    /**
     * Stream to read content
     * 
     * @return java.io.InputStream
     * @throws RuntimeException if stream could not be retrieved
     */
    public InputStream getArchiveContent( String relativePath );

    /**
     * Returns the length of a file (referenced via a relative path) inside an
     * archive.
     * 
     * @return Length of the file referenced by the given relative path.
     */
    public long getArchiveContentLength( String relativePath );

    /**
     * Remove partition file without checks
     * 
     * @return true if file is deleted
     */
    public boolean delete( );

    /**
     * Returns the if a file (referenced via a relative path) inside an exists.
     * 
     * @return <code>True</code> if the file exist else <code>False</code>.
     */
    public boolean existsInArchive( String relativePath );

}
