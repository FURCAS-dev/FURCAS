package com.sap.tc.moin.facility.primary.query.index.memory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.sap.tc.moin.repository.ResourceIdentifierFactory;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;


public class IndexFsDumpHandler extends IndexAbstractDumpHandler {

    private static final MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_PRIMARY_FACILITY, MoinLocationEnum.MOIN_FACILITIES_PRIMARY_INDEX, IndexFsDumpHandler.class );

    private static final int VERSION = 3;

    private final String indexFilePath;

    // ###############################################################
    // ##################### Constructor Section ####################
    // ###############################################################

    public IndexFsDumpHandler( ResourceIdentifierFactory riFactory, String indexFilePath, IndexImpl index ) {

        super( VERSION, riFactory, index );
        this.indexFilePath = indexFilePath;
    }

    /*
     * ######################################################################
     * ######## Dump File Details ##################
     * ################################################
     */
    @Override
    public boolean dump( ) {

        File f = this.getIndexFile( );
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream( f );
            DumpWriteBuffer dumpBuf = new DumpWriteBuffer( fos.getChannel( ), IndexConstants.DUMPMEMORY, true /*
                                                                                                               * direct-
                                                                                                               * buffer
                                                                                                               */);
            this.dumpInternal( dumpBuf );
            dumpBuf.flushBuffer( );

            // close output stream here so that errors concerning this are reported
            fos.close( );
            fos = null;
        } catch ( Exception e ) {
            LOGGER.trace( e, MoinSeverity.WARNING, IndexFsDumpedConstants.COULD_NOT_DUMP_INDEX_TO_FILE, this.indexFilePath );
            return false;
        } finally {
            if ( fos != null ) {
                // will not happen after correct dump (and stream close) 
                try {
                    fos.close( );
                } catch ( IOException e ) {
                    LOGGER.trace( MoinSeverity.PATH, "Impossible to close output stream of dump file " + this.indexFilePath ); //$NON-NLS-1$
                }
            }
        }
        return true;
    }

    @Override
    public boolean load( ) {

        File f = this.getIndexFile( );
        if ( !f.exists( ) ) {
            return false;
        }
        FileInputStream fis = null;
        try {
            fis = new FileInputStream( f );
            DumpReadBuffer dumpBuf = new DumpReadBuffer( fis.getChannel( ), (int) fis.getChannel( ).size( ), IndexConstants.DUMPMEMORY, true /* directBuffer */);
            this.loadInternal( dumpBuf );
        } catch ( Exception e ) {
            LOGGER.trace( e, MoinSeverity.WARNING, IndexFsDumpedConstants.COULD_NOT_LOAD_DUMP_FROM_FILE, this.indexFilePath );
            return false;
        } finally {
            if ( fis != null ) {
                try {
                    fis.close( );
                } catch ( IOException ioe ) {
                    LOGGER.trace( MoinSeverity.PATH, "Impossible to close input stream of dump file " + this.indexFilePath ); //$NON-NLS-1$
                }
            }
        }
        return true;
    }

    private File getIndexFile( ) {

        return new File( this.indexFilePath );
    }
}
