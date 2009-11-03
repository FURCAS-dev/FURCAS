package com.sap.tc.moin.xm.adapter.cps;

import java.io.IOException;
import java.io.OutputStream;

import com.sap.tc.moin.repository.exception.MoinNullPointerException;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.spi.ps.SpiAssociation;
import com.sap.tc.moin.repository.spi.ps.SpiClass;
import com.sap.tc.moin.repository.spi.ps.serializer.SpiCustomSerializer;
import com.sap.tc.moin.repository.spi.ps.serializer.SpiElement;
import com.sap.tc.moin.repository.spi.ps.serializer.SpiSerializerCallback;
import com.sap.tc.moin.xm.kernel.XmSerializer;

/**
 * CPS Serializer which delegates the serialization to a XM Serializer.
 */
public class XmCpsSerializer implements SpiCustomSerializer {

    private static final MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_XM, MoinLocationEnum.MOIN_XM_RT, XmCpsSerializer.class );

    private final XmSerializer<SpiElement, SpiClass, SpiAssociation> xmSerializer;

    /**
     * Constructor.
     * 
     * @param aXmSerializer XM Serializer
     * @throws NullPointerException if the parameter is null
     */
    XmCpsSerializer( final XmSerializer<SpiElement, SpiClass, SpiAssociation> aXmSerializer ) {

        if ( aXmSerializer == null ) {
            throw new MoinNullPointerException( "aXmSerializer" ); //$NON-NLS-1$
        }
        this.xmSerializer = aXmSerializer;
    }

    public void serialize( final OutputStream stream, final SpiSerializerCallback callback ) throws IOException {

        if ( LOGGER.isTraced( MoinSeverity.INFO ) ) {
            LOGGER.trace( MoinSeverity.INFO, "Serializing of model partition {0} started", callback.getPri( ) ); //$NON-NLS-1$
        }

        this.xmSerializer.serialize( stream, new XmCpsSerializerCallback( callback ) );

        if ( LOGGER.isTraced( MoinSeverity.INFO ) ) {
            LOGGER.trace( MoinSeverity.INFO, "Serializing of model partition {0} finished", callback.getPri( ) ); //$NON-NLS-1$
        }
    }

}
