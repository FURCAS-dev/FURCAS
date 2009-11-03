package com.sap.tc.moin.xm.kernel.impl.serializer;

import java.io.OutputStream;

import com.sap.tc.moin.repository.exception.MoinNullPointerException;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.xm.XmException;
import com.sap.tc.moin.repository.xm.serializer.XmCustomSerializer;
import com.sap.tc.moin.repository.xm.serializer.XmSerializerConfiguration;
import com.sap.tc.moin.xm.kernel.XmSerializer;
import com.sap.tc.moin.xm.kernel.XmSerializerCallback;
import com.sap.tc.moin.xm.kernel.impl.XmExceptionMessages;
import com.sap.tc.moin.xm.kernel.impl.XmKernelException;
import com.sap.tc.moin.xm.kernel.impl.serializer.sax.XmlOutputHandlerImpl;
import com.sap.tc.moin.xm.kernel.impl.serializer.util.SerializerHelperImpl;



/**
 * Implementation of the XM Serializer.
 */
public final class XmSerializerImpl<TElement, TMofClass, TMofAssociation> extends XmSerializer<TElement, TMofClass, TMofAssociation> {

    private static final MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_XM, MoinLocationEnum.MOIN_XM_RT, XmSerializerImpl.class );

    private final SerializerHelperImpl<TElement, TMofClass, TMofAssociation> helper = new SerializerHelperImpl<TElement, TMofClass, TMofAssociation>( );

    private final XmCustomSerializer customSerializer;

    /**
     * Constructor.
     * 
     * @param configuration configuration
     * @throws NullPointerException if the parameter is <code>null</code>
     */
    public XmSerializerImpl( final XmSerializerConfiguration configuration ) {

        if ( configuration == null ) {
            throw new MoinNullPointerException( "configuration" ); //$NON-NLS-1$
        }
        this.customSerializer = configuration.getCustomSerializer( );
        if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
            LOGGER.trace( MoinSeverity.DEBUG, "Core XM Serializer for Custom XM Serializer {0} created", customSerializer.getClass( ).getName( ) ); //$NON-NLS-1$
        }
    }

    @Override
    public void serialize( final OutputStream outputstream, final XmSerializerCallback<TElement, TMofClass, TMofAssociation> callback ) throws XmException {

        long time;
        if ( LOGGER.isTraced( MoinSeverity.INFO ) ) {
            time = System.currentTimeMillis( );
        } else {
            time = 0;
        }
        try {
            this.helper.setCallback( callback );
            final XmlOutputHandlerImpl handler = new XmlOutputHandlerImpl( outputstream );
            this.helper.setOutputHandler( handler );
            handler.documentStart( );

            // start the serialization
            this.customSerializer.execute( this.helper );

            handler.documentEnd( );
            if ( handler.getException( ) != null ) {
                LOGGER.trace( MoinSeverity.ERROR, XmExceptionMessages.HANDLERRETURNEDEXCEPTION, handler.getException( ).getMessage( ) );
                throw new XmKernelException( handler.getException( ), XmExceptionMessages.HANDLERRETURNEDEXCEPTION, handler.getException( ).getMessage( ) );
            }
        } finally {
            this.helper.reset( );
        }
        if ( LOGGER.isTraced( MoinSeverity.INFO ) ) {
            LOGGER.trace( MoinSeverity.DEBUG, "Serialization took {0} ms for {1} model elements", new Object[] { Long.toString( System.currentTimeMillis( ) - time ), callback.getStoredElements( ).size( ) } ); //$NON-NLS-1$
        }
    }
}