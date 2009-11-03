package com.sap.tc.moin.facility.primary.ide.persistence.lfs.ecl;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.core.runtime.jobs.Job;

import com.sap.tc.moin.facility.primary.ipi.fs.lfs.IpiLogicalFile;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;

/**
 * The implementation of the logical filesystem file API
 * {@link com.sap.tc.moin.facility.primary.ipi.fs.lfs.IpiLogicalFile}
 */
public class EclFileImpl extends EclResourceImpl implements IpiLogicalFile {

    private static final MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_PRIMARY_FACILITY, MoinLocationEnum.MOIN_FACILITIES_PRIMARY_PERSISTENCE_FS, EclFileImpl.class );

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

    protected EclFileImpl( IResource file ) {

        super( file );
    }

    /**
     * Returns an {@link InputStream} on the contents of the underlying file.
     * <p>
     * If the underlying file is out-of-sync with the eclipse file system
     * {@link java.io.File} means are used to open a stream. Additionally a
     * separate eclipse job is scheduled which refreshes the resource.
     * 
     * @return {@link InputStream} on the contents of the underlying file
     */
    public InputStream getInputStream( ) {

        IFile file = (IFile) this.resource;
        try {
            return file.getContents( );
        } catch ( CoreException e ) {
            // The exception could reflect that the resource is not in sync with the file-system
            // - Naturally we would refresh the resource and try again, but this would
            // (a) potentially acquire resource locks in the UI thread and could
            // (b) cause deadlocks between eclipse resource and MOIN locks
            // => We directly access the content via java.io.File means and additionally schedule a refresh as separate, asynchronous job to keep the eclipse fs in sync
            try {
                InputStream stream = this.getInputStreamViaJavaIoFile( file );
                // here we could also trigger a refresh for the containing folder -> this.resource.getParent()
                this.scheduleRefreshJob( this.resource );
                return stream;
            } catch ( Exception e1 ) {
                // catch exception from refresh and getContents() since nobody knows why refresh does not work if you call getInputStream().
                if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
                    // TODO externalize message
                    LOGGER.trace( e1, MoinSeverity.DEBUG, "Could not retrieve input stream for resource " + this.resource.getFullPath( ) );
                }
                // TODO use localized message message and exception
                throw new RuntimeException( "Could not retrieve input stream for resource " + this.resource.getFullPath( ), e1 );
            }
        }
    }

    private InputStream getInputStreamViaJavaIoFile( IFile file ) {

        FileInputStream fis;
        try {
            fis = new FileInputStream( file.getLocation( ).toFile( ) );
        } catch ( FileNotFoundException e ) {
            // TODO use localized message message and exception
            throw new RuntimeException( "Could not retrieve input stream for resource " + this.resource.getFullPath( ), e );
        }
        BufferedInputStream bis = new BufferedInputStream( fis );
        return bis;
    }

    /**
     * Schedules a {@link IResource#refreshLocal(int, IProgressMonitor)} in a
     * separate job for a given resource.
     * <p>
     * If the given resource is a folder all contained resources are refreshed
     * as well ({@link IResource#DEPTH_INFINITE}).
     * 
     * @param resourceToRefresh The resource to refresh
     */
    private void scheduleRefreshJob( final IResource resourceToRefresh ) {

        if ( resourceToRefresh != null ) {

            SimpleDateFormat dateFormat = new SimpleDateFormat( "(yyyyMMdd_HHmmss_SSS)" ); //$NON-NLS-1$
            String jobName = "RefreshResource" + dateFormat.format( new Date( ) ) + "_" + resourceToRefresh.getName( ); //$NON-NLS-1$ //$NON-NLS-2$

            // create update job
            Job updateJob = new Job( jobName ) {

                @Override
                protected IStatus run( IProgressMonitor monitor ) {

                    if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
                        // TODO externalize message
                        LOGGER.trace( MoinSeverity.DEBUG, "Started refresh job '" + this.getName( ) + "' [resourcePath=" + resourceToRefresh.getFullPath( ) + "]" );
                    }
                    try {
                        int type = resourceToRefresh.getType( );
                        if ( type == IResource.FILE ) {
                            resourceToRefresh.refreshLocal( IResource.DEPTH_ZERO, NO_PROGRESS_MONITOR );
                        } else if ( type == IResource.FOLDER || type == IResource.PROJECT ) {
                            resourceToRefresh.refreshLocal( IResource.DEPTH_INFINITE, NO_PROGRESS_MONITOR );
                        }
                        return Status.OK_STATUS;
                    } catch ( CoreException e ) {
                        if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
                            // TODO externalize message
                            LOGGER.trace( e, MoinSeverity.DEBUG, "Unable to refresh resource " + resourceToRefresh.getFullPath( ) );
                        }
                        // create and return error status based on exception
                        return new Status( IStatus.ERROR, "com.sap.tc.moin.facility.primary.internal", "Unable to refresh resource " + resourceToRefresh.getFullPath( ), e );
                    }

                }
            };

            // calculate rule required for performing localRefresh()
            ISchedulingRule rule = org.eclipse.core.resources.ResourcesPlugin.getWorkspace( ).getRuleFactory( ).refreshRule( resourceToRefresh );
            updateJob.setRule( rule );

            // schedule job
            if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
                // TODO externalize message
                LOGGER.trace( MoinSeverity.DEBUG, "Scheduled job '" + updateJob.getName( ) + "' [resourcePath=" + resourceToRefresh.getFullPath( ) + "]" );
            }
            updateJob.schedule( );
        }

    }

    public OutputStream getOutputStream( ) {

        return new EclFileOutputStreamImpl( (IFile) this.resource );
    }


    public InputStream getArchiveContent( String relativePath ) {

        InputStream is = null;

        ZipFile zip = null;
        // use local filesystem path
        IPath path = this.resource.getLocation( );
        String local = path.toString( );
        try {
            zip = new ZipFile( local );
            ZipEntry ze = zip.getEntry( relativePath );
            if ( ze != null ) {
                is = zip.getInputStream( ze );
            }
        } catch ( IOException e ) {
            if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
                LOGGER.trace( e, MoinSeverity.DEBUG, "Could not read entry " + relativePath + " from archive " + local );
            }
            throw new RuntimeException( "Could not read entry " + relativePath + " from archive " + local, e );
        }
        if ( is == null ) {
            RuntimeException e = new RuntimeException( "Could not get input stream for entry " + relativePath + " from archive " + local );
            if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
                LOGGER.trace( e, MoinSeverity.DEBUG, "Could not get input stream for entry " + relativePath + " from archive " + local );
            }
            throw e;
        } else {
            return new InputStreamOfZip( is, zip );
        }
    }

    public long getArchiveContentLength( String relativePath ) {

        long entryLength = -1;

        ZipFile zip = null;
        ZipEntry ze = null;
        // use local filesystem path
        IPath path = this.resource.getLocation( );
        String local = path.toString( );
        try {
            zip = new ZipFile( local );
            ze = zip.getEntry( relativePath );
            if ( ze != null ) {
                entryLength = ze.getSize( );
            }
        } catch ( IOException e ) {
            if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
                LOGGER.trace( e, MoinSeverity.DEBUG, "Could not read entry " + relativePath + " from archive " + local );
            }
            throw new RuntimeException( "Could not read entry " + relativePath + " from archive " + local, e );
        } finally {
            if ( zip != null ) {
                try {
                    zip.close( );
                } catch ( IOException e ) {
                    throw new RuntimeException( "Failed to close archive " + local, e );
                }
            }
        }
        if ( ze == null ) {
            RuntimeException e = new RuntimeException( "Could not read entry " + relativePath + " from archive " + local );
            if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
                LOGGER.trace( e, MoinSeverity.DEBUG, "Could not read entry " + relativePath + " from archive " + local );
            }
            throw e;
        }

        return entryLength;
    }

    /*
     * (non-Javadoc)
     * @see com.sap.tc.moin.persistence.lfs.api.LogicalResource#isArchive()
     */
    public boolean isArchive( ) {

        ZipFile zip = null;
        IPath path = this.resource.getLocation( );
        String local = path.toString( );
        try {
            zip = new ZipFile( local );
            Enumeration<? extends ZipEntry> en = zip.entries( );
            if ( en.hasMoreElements( ) ) {
                return true;
            }
        } catch ( IOException e ) {
            return false;
        }
        return false;
    }

    public boolean delete( ) {

        // JB 11.10.2007: check if the file really exists.
        // reason for this workaround: delete versioning operations are currently done before saving.
        // DTR Client performs Eclipse refresh after deletion asynchronously. Thus it might happen
        // that the resource exists here but the file is deleted. In this case deleting the resource
        // can trigger team provider and this can fail.
        if ( this.exists( ) ) {
            String loc = this.getLocation( );
            File file = null;
            if ( loc != null ) {
                file = new File( loc );
            }
            if ( file != null && file.exists( ) ) {
                // partition delete
                try {
                    this.resource.delete( true, null );
                    return true;
                } catch ( CoreException e ) {
                    if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
                        LOGGER.trace( e, MoinSeverity.DEBUG, "Tried to but could not delete file " + file.getAbsolutePath( ) );
                    }
                    return false;
                }
            } else {
                return true; // file already deleted
            }
        }

        return false;
    }

    private String getLocation( ) {

        IPath loc = this.resource.getLocation( );
        if ( loc != null ) {
            return loc.toString( );
        }
        return null;
    }

    public long getLength( ) {

        // we have to use the underlaying java.io.File to determine the file length 
        return this.resource.getLocation( ).toFile( ).length( );
    }

    public boolean existsInArchive( String relativePath ) {

        ZipFile zip = null;
        ZipEntry ze = null;
        // use local filesystem path
        IPath path = this.resource.getLocation( );
        String local = path.toString( );
        try {
            zip = new ZipFile( local );
            ze = zip.getEntry( relativePath );
            return ze != null;
        } catch ( IOException e ) {
            if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
                LOGGER.trace( e, MoinSeverity.DEBUG, "Could not read entry " + relativePath + " from archive " + local );
            }
            throw new RuntimeException( "Could not read entry " + relativePath + " from archive " + local, e );
        } finally {
            if ( zip != null ) {
                try {
                    zip.close( );
                } catch ( IOException e ) {
                    throw new RuntimeException( "Failed to close archive " + local, e );
                }
            }
        }

    }
}
