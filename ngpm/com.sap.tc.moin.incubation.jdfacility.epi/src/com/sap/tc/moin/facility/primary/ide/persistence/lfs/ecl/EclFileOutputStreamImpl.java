package com.sap.tc.moin.facility.primary.ide.persistence.lfs.ecl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;

import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;

/**
 * OutputStream implementation needed for the implementation of the logical
 * filesystem file API
 * {@link  com.sap.tc.moin.facility.primary.ipi.fs.lfs.IpiLogicalFile}.
 * Content is stored when stream is flushed or closed.
 */
public class EclFileOutputStreamImpl extends ByteArrayOutputStream {

    private static final MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_PRIMARY_FACILITY, MoinLocationEnum.MOIN_FACILITIES_PRIMARY_PERSISTENCE_FS, EclFileOutputStreamImpl.class );

    private IFile file;

    private boolean stored = false;

    public EclFileOutputStreamImpl( IFile file ) {

        super( );
        this.file = file;
    }

    /*
     * Store content and close stream
     * 
     * @see java.io.Closeable#close()
     */
    @Override
    public void close( ) throws IOException {

        super.close( );
        this.storeContent( );
    }

    /*
     * Store content
     * 
     * @see java.io.Flushable#flush()
     */
    @Override
    public void flush( ) throws IOException {

        super.flush( );
        this.storeContent( );
    }

    private void storeContent( ) throws IOException {

        if ( this.stored ) {
            // store only once
            return;
        }
        this.stored = true;
        InputStream is = new ByteArrayInputStream( this.toByteArray( ) );
        try {
            file.setContents( is, IResource.FORCE, null );
        } catch ( CoreException e ) {
            // [uh,28.12.2006]
            // The exception could reflect that the resource is not in sync with the file-system
            // --> We refresh the resource and try again.
            // Remark: If we face performance problems with this behavior then we have to think about a critereon (e.g.
            // 100 partition in the project or resource folder)
            // for the decision to refresh the project folder or resource folder instead of refreshing many partitions
            // below ...
            try {
                file.refreshLocal( IResource.DEPTH_ZERO, EclResourceImpl.NO_PROGRESS_MONITOR );
                file.setContents( is, IResource.FORCE, null );
            } catch ( CoreException e1 ) {
                if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
                    LOGGER.trace( e1, MoinSeverity.DEBUG, "Unable to store content in file " + file.getFullPath( ) );
                }
                IOException ioe = new IOException( "Unable to store content in file " + file.getFullPath( ) );
                try {
                    ioe.initCause( e1 );
                } catch ( Exception neverHappensException ) {
                }
                throw ioe;
            }
        }
    }
}
