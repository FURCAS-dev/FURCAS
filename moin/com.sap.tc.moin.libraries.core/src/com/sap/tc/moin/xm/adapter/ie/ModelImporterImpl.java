package com.sap.tc.moin.xm.adapter.ie;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;

import com.sap.tc.moin.repository.mmi.reflect.RefAssociation;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.Connection;
import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.commands.Command;
import com.sap.tc.moin.repository.commands.PartitionOperation;
import com.sap.tc.moin.repository.exception.MoinNullPointerException;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.xm.XmException;
import com.sap.tc.moin.repository.xm.ie.ModelImporter;
import com.sap.tc.moin.xm.kernel.XmParser;

/**
 * Implementation of the Model Importer.
 */
final class ModelImporterImpl extends ModelImporter {

    private static final MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_XM, MoinLocationEnum.MOIN_XM_RT, ModelImporterImpl.class );

    private final ImportCommand command;

    ModelImporterImpl( final XmParser<RefObject, RefClass, RefAssociation> aParser, final ImportCallback aCallback ) {

        this.command = new ImportCommand( aCallback.getConnection( ), aCallback, aParser );
    }


    @Override
    public synchronized void doImport( final InputStream is, final PRI pri ) throws XmException {

        if ( LOGGER.isTraced( MoinSeverity.INFO ) ) {
            LOGGER.trace( MoinSeverity.INFO, "Import of model partition {0} started", pri ); //$NON-NLS-1$
        }

        try {
            this.command.setPri( pri );
            this.command.setXmlDocument( is );
            this.command.execute( );
        } catch ( final RuntimeException e ) {
            // see ImportCommand.doExecute()
            if ( e.getCause( ) instanceof XmException ) {
                throw (XmException) e.getCause( );
            } else {
                throw e;
            }
        }
        if ( LOGGER.isTraced( MoinSeverity.INFO ) ) {
            LOGGER.trace( MoinSeverity.INFO, "Import of model partition {0} finished", pri ); //$NON-NLS-1$
        }
    }

    @Override
    public Connection getConnection( ) {

        return this.command.getConnection( );
    }

    final static class ImportCommand extends Command {


        private final Collection<PartitionOperation> partions = new ArrayList<PartitionOperation>( 1 );


        private final ImportCallback callback;

        private final XmParser<RefObject, RefClass, RefAssociation> parser;

        private InputStream inputStream;

        ImportCommand( final Connection connection, final ImportCallback aCallBack, final XmParser<RefObject, RefClass, RefAssociation> aParser ) {

            super( connection, "Import XML Document" ); //$NON-NLS-1$
            if ( aParser == null ) {
                throw new MoinNullPointerException( "aParser" ); //$NON-NLS-1$
            }
            if ( aCallBack == null ) {
                throw new MoinNullPointerException( "aCallback" ); //$NON-NLS-1$
            }
            this.callback = aCallBack;
            this.parser = aParser;
        }


        @Override
        public void doExecute( ) {

            try {
                this.callback.clearPartition( );
                this.parser.parse( this.inputStream, this.callback );
            } catch ( final XmException e ) {
                throw new RuntimeException( e );
            } finally {
                this.partions.clear( );
                this.inputStream = null;
            }
        }


        @Override
        public boolean canExecute( ) {

            return !this.partions.isEmpty( ) && this.inputStream != null;
        }

        @Override
        public Collection<PartitionOperation> getAffectedPartitions( ) {

            return this.partions;
        }

        void setPri( final PRI pri ) {

            this.callback.setPri( pri );
            this.partions.clear( );
            this.partions.add( new PartitionOperation( PartitionOperation.Operation.EDIT, pri ) );
        }

        void setXmlDocument( final InputStream is ) {

            if ( is == null ) {
                throw new MoinNullPointerException( "is" ); //$NON-NLS-1$
            }
            this.inputStream = is;
        }
    }

}
