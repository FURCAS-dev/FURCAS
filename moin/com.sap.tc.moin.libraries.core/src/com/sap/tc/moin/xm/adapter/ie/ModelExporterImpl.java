package com.sap.tc.moin.xm.adapter.ie;

import java.io.OutputStream;

import com.sap.tc.moin.repository.mmi.reflect.RefAssociation;
import com.sap.tc.moin.repository.mmi.reflect.RefClass;
import com.sap.tc.moin.repository.mmi.reflect.RefObject;

import com.sap.tc.moin.repository.PRI;
import com.sap.tc.moin.repository.core.ConnectionWrapper;
import com.sap.tc.moin.repository.exception.MoinNullPointerException;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.xm.XmException;
import com.sap.tc.moin.repository.xm.ie.ModelExporter;
import com.sap.tc.moin.xm.kernel.XmSerializer;


final class ModelExporterImpl extends ModelExporter {

    private static final MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_XM, MoinLocationEnum.MOIN_XM_RT, ModelExporterImpl.class );

    private final XmSerializer<RefObject, RefClass, RefAssociation> serializer;

    private final ExportCallback callback;

    /**
     * Constructor.
     * 
     * @param aSerializer
     * @param callback
     * @throws NullPointerException if a parameter is <code>null</code>
     */
    public ModelExporterImpl( final XmSerializer<RefObject, RefClass, RefAssociation> aSerializer, final ExportCallback aCallback ) {

        if ( aSerializer == null ) {
            throw new MoinNullPointerException( "aSerializer" ); //$NON-NLS-1$
        }
        if ( aCallback == null ) {
            throw new MoinNullPointerException( "aCallback" ); //$NON-NLS-1$
        }
        this.serializer = aSerializer;
        this.callback = aCallback;
    }


    @Override
    public synchronized void doExport( final OutputStream outputstream, final PRI pri ) throws XmException {

        if ( LOGGER.isTraced( MoinSeverity.INFO ) ) {
            LOGGER.trace( MoinSeverity.INFO, "Export of model partition {0} started", pri ); //$NON-NLS-1$
        }

        final ConnectionWrapper cw = (ConnectionWrapper) this.callback.getConnection( );
        cw.getSynchronizationManager( ).acquireReadLock( );
        try {
            this.callback.setPri( pri );
            this.serializer.serialize( outputstream, this.callback );
        } finally {
            cw.getSynchronizationManager( ).releaseReadLock( );
        }

        if ( LOGGER.isTraced( MoinSeverity.INFO ) ) {
            LOGGER.trace( MoinSeverity.INFO, "Export of model partition {0} finished", pri ); //$NON-NLS-1$
        }
    }

}
