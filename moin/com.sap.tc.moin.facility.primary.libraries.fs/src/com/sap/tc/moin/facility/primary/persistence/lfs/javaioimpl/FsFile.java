package com.sap.tc.moin.facility.primary.persistence.lfs.javaioimpl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import com.sap.tc.moin.facility.primary.ipi.fs.lfs.IpiLogicalFile;
import com.sap.tc.moin.repository.exception.MoinLocalizedBaseRuntimeException;

/**
 * The implementation of the logical filesystem file API
 * {@link com.sap.tc.moin.facility.primary.ipi.fs.lfs.IpiLogicalFile}
 */
public class FsFile extends FsResource implements IpiLogicalFile {

    static class InputStreamOfZip extends InputStream {

        InputStream is = null;

        ZipFile zip = null;

        public InputStreamOfZip( InputStream is, ZipFile zip ) {

            this.is = is;
            this.zip = zip;
        }

        /**
         * @see java.io.InputStream#available()
         */
        @Override
        public int available( ) throws IOException {

            return is.available( );
        }

        /**
         * @see java.io.InputStream#close()
         */
        @Override
        public void close( ) throws IOException {

            if ( is != null ) {
                is.close( );
            }
            if ( zip != null ) {
                zip.close( );
            }
        }

        /**
         * @see java.io.InputStream#mark(int)
         */
        @Override
        public void mark( int readlimit ) {

            is.mark( readlimit );
        }

        /**
         * @see java.io.InputStream#markSupported()
         */
        @Override
        public boolean markSupported( ) {

            return is.markSupported( );
        }

        /**
         * @see java.io.InputStream#read()
         */
        @Override
        public int read( ) throws IOException {

            return is.read( );
        }

        /**
         * @see java.io.InputStream#read(byte[], int, int)
         */
        @Override
        public int read( byte[] b, int off, int len ) throws IOException {

            return is.read( b, off, len );
        }

        /**
         * @see java.io.InputStream#read(byte[])
         */
        @Override
        public int read( byte[] b ) throws IOException {

            return is.read( b );
        }

        /**
         * @see java.io.InputStream#reset()
         */
        @Override
        public void reset( ) throws IOException {

            is.reset( );
        }

        /**
         * @see java.io.InputStream#skip(long)
         */
        @Override
        public long skip( long n ) throws IOException {

            return is.skip( n );
        }
    }

    protected FsFile( File file ) {

        super( file );
    }

    @Override
    public boolean isArchive( ) {

        try {
            /*
             * Must be a build result: Currently JAR create a JarFile instance
             * as a test
             */
            ZipFile jarFile = new ZipFile( file );
            jarFile.close( );
        } catch ( IOException e ) {
            return false;
        }
        return true;
    }

    public InputStream getInputStream( ) {

        FileInputStream fis;
        try {
            fis = new FileInputStream( this.file );
        } catch ( FileNotFoundException e ) {
            throw new MoinLocalizedBaseRuntimeException( e, PersistenceLfsJavaioimplMessages.UNABLE_TO_OPEN_INPUTSTREAM_FILE_NOT_FOUND, this.file.getAbsolutePath( ) );
        }
        BufferedInputStream bis = new BufferedInputStream( fis );
        return bis;
    }

    public OutputStream getOutputStream( ) {

        FileOutputStream fos;
        try {
            fos = new FileOutputStream( this.file );
        } catch ( FileNotFoundException e ) {
            throw new MoinLocalizedBaseRuntimeException( e, PersistenceLfsJavaioimplMessages.UNABLE_TO_OPEN_OUTPUTSTREAM_FILE_NOT_FOUND, this.file.getAbsolutePath( ) );
        }
        BufferedOutputStream bos = new BufferedOutputStream( fos );
        return bos;
    }

    public InputStream getArchiveContent( String relativePath ) {

        InputStream is = null;
        ZipFile jar = null;
        try {
            jar = new ZipFile( this.file );
            ZipEntry ze = jar.getEntry( relativePath );
            if ( ze != null ) {
                is = jar.getInputStream( ze );
            }
        } catch ( IOException e ) {
            throw new MoinLocalizedBaseRuntimeException( e, PersistenceLfsJavaioimplMessages.UNABLE_TO_READ_ENTRY, relativePath, this.file.getAbsolutePath( ) );
        }

        if ( is == null ) {
            throw new MoinLocalizedBaseRuntimeException( PersistenceLfsJavaioimplMessages.UNABLE_TO_OPEN_STREAM_FOR_ENTRY, relativePath, this.file.getAbsolutePath( ) );
        } else {
            return new InputStreamOfZip( is, jar );
        }
    }

    public long getArchiveContentLength( String relativePath ) {

        long entryLength = -1;

        ZipEntry ze = null;
        ZipFile jar = null;
        try {
            jar = new ZipFile( this.file );
            ze = jar.getEntry( relativePath );
            if ( ze != null ) {
                entryLength = ze.getSize( );
            }
        } catch ( IOException e ) {
            throw new MoinLocalizedBaseRuntimeException( PersistenceLfsJavaioimplMessages.UNABLE_TO_DETERMINE_ARCHIVE_ENTRY_SIZE, relativePath, this.file.getAbsolutePath( ) );
        } finally {
            if ( jar != null ) {
                try {
                    jar.close( );
                } catch ( IOException e ) {
                    throw new MoinLocalizedBaseRuntimeException( e, PersistenceLfsJavaioimplMessages.UNABLE_TO_CLOSE_ARCHIVE, this.file.getAbsolutePath( ) );
                }
            }
        }
        if ( ze == null ) {
            throw new MoinLocalizedBaseRuntimeException( PersistenceLfsJavaioimplMessages.UNABLE_TO_DETERMINE_ARCHIVE_ENTRY_SIZE, relativePath, this.file.getAbsolutePath( ) );
        }

        return entryLength;
    }

    public boolean delete( ) {

        boolean wasDeleted = false;
        if ( this.isFile( ) ) {
            wasDeleted = this.file.delete( );
        }
        return wasDeleted;
    }

    public long getLength( ) {

        return this.file.length( );
    }

    public boolean existsInArchive( String relativePath ) {

        ZipEntry ze = null;
        ZipFile jar = null;
        try {
            jar = new ZipFile( this.file );
            ze = jar.getEntry( relativePath );
            return ze != null;
        } catch ( IOException e ) {
            throw new MoinLocalizedBaseRuntimeException( e, PersistenceLfsJavaioimplMessages.UNABLE_TO_CHECK_EXISTENCE_OF_ARCHIVE_ENTRY_SIZE, relativePath, this.file.getAbsolutePath( ) );
        } finally {
            if ( jar != null ) {
                try {
                    jar.close( );
                } catch ( IOException e ) {
                    throw new MoinLocalizedBaseRuntimeException( e, PersistenceLfsJavaioimplMessages.UNABLE_TO_CLOSE_ARCHIVE, this.file.getAbsolutePath( ) );
                }
            }
        }
    }

}
