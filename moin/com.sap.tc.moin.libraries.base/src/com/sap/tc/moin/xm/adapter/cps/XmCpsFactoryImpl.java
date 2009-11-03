package com.sap.tc.moin.xm.adapter.cps;

import java.lang.ref.SoftReference;
import java.util.concurrent.locks.ReentrantLock;

import com.sap.tc.moin.repository.exception.MoinNullPointerException;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.spi.ps.SpiAssociation;
import com.sap.tc.moin.repository.spi.ps.SpiClass;
import com.sap.tc.moin.repository.spi.ps.SpiXmParserSerializerConfiguration;
import com.sap.tc.moin.repository.spi.ps.parser.SpiCustomParser;
import com.sap.tc.moin.repository.spi.ps.parser.SpiElement;
import com.sap.tc.moin.repository.spi.ps.serializer.SpiCustomSerializer;
import com.sap.tc.moin.repository.spi.s2x.serializer.SpiS2XSerializerCustomCallback;
import com.sap.tc.moin.xm.cps.XmCpsFactory;
import com.sap.tc.moin.xm.kernel.XmFactory;

/**
 * Implementation of the XM CPS Factory.
 * <p>
 * A Parser/Serializer is created per thread via thread locals which holds soft
 * references to the Parser/Serializer.
 */
public final class XmCpsFactoryImpl extends XmCpsFactory {

    private static final MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_XM, MoinLocationEnum.MOIN_XM_RT, XmCpsFactoryImpl.class );

    private final XmFactory<SpiElement, SpiClass, SpiAssociation> xmParserFactory = XmFactory.getInstance( );

    private final XmFactory<com.sap.tc.moin.repository.spi.ps.serializer.SpiElement, SpiClass, SpiAssociation> xmSerializerFactory = XmFactory.getInstance( );

    private final SpiXmParserSerializerConfiguration configuration;

    private final ReentrantLock parserLock = new ReentrantLock( true );

    private final ReentrantLock serializerLock = new ReentrantLock( true );

    private final ThreadLocal<SoftReference<SpiCustomParser>> parserLocal = new ThreadLocal<SoftReference<SpiCustomParser>>( );;

    private final ThreadLocal<SoftReference<SpiCustomSerializer>> serializerLocal = new ThreadLocal<SoftReference<SpiCustomSerializer>>( );

    public XmCpsFactoryImpl( final SpiXmParserSerializerConfiguration config ) {

        if ( config == null ) {
            throw new MoinNullPointerException( "config" ); //$NON-NLS-1$
        }
        this.configuration = config;
    }

    public SpiCustomParser getParser( ) {

        if ( LOGGER.isTraced( MoinSeverity.INFO ) ) {
            LOGGER.trace( MoinSeverity.INFO, "Fetching XM CPS Parser for Custom XM Parser Handler {0}", configuration.getParserConfiguration( ) == null ? "" : configuration.getParserConfiguration( ).getHandler( ).getClass( ).getName( ) ); //$NON-NLS-1$ //$NON-NLS-2$
        }
        this.parserLock.lock( );
        try {
            SoftReference<SpiCustomParser> result = this.parserLocal.get( );
            if ( result == null || result.get( ) == null ) {
                result = new SoftReference<SpiCustomParser>( new XmCpsParser( xmParserFactory.getParser( configuration.getParserConfiguration( ) ) ) );
                this.parserLocal.set( result );
                if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
                    LOGGER.trace( MoinSeverity.DEBUG, "XM CPS Parser for Custom XM Parser Handler {0} created", configuration.getParserConfiguration( ) == null ? "" : configuration.getParserConfiguration( ).getHandler( ).getClass( ).getName( ) ); //$NON-NLS-1$ //$NON-NLS-2$
                }
            }
            return result.get( );
        } finally {
            this.parserLock.unlock( );
        }
    }

    public SpiCustomSerializer getSerializer( ) {

        if ( LOGGER.isTraced( MoinSeverity.INFO ) ) {
            LOGGER.trace( MoinSeverity.INFO, "Fetching XM CPS Serializer for Custom XM Serializer {0}", configuration.getSerializerConfiguration( ) == null ? "" : configuration.getSerializerConfiguration( ).getCustomSerializer( ).getClass( ).getName( ) ); //$NON-NLS-1$ //$NON-NLS-2$
        }
        this.serializerLock.lock( );
        try {
            SoftReference<SpiCustomSerializer> result = this.serializerLocal.get( );
            if ( result == null || result.get( ) == null ) {
                if ( configuration.getSerializerConfiguration( ) == null ) {
                    // no serializer configured
                    if ( LOGGER.isTraced( MoinSeverity.WARNING ) ) {
                        LOGGER.trace( MoinSeverity.WARNING, "XM CPS Serializer not created because a custom serializer is not configured for the corresponding XM Parser {0}", configuration.getParserConfiguration( ).getHandler( ).getClass( ).getName( ) ); //$NON-NLS-1$
                    }
                    return null;
                } else {
                    result = new SoftReference<SpiCustomSerializer>( new XmCpsSerializer( xmSerializerFactory.getSerializer( configuration.getSerializerConfiguration( ) ) ) );
                    this.serializerLocal.set( result );
                    if ( LOGGER.isTraced( MoinSeverity.DEBUG ) ) {
                        LOGGER.trace( MoinSeverity.DEBUG, "XM CPS Serializer for Custom XM Serializer {0} created", configuration.getSerializerConfiguration( ).getCustomSerializer( ).getClass( ).getName( ) ); //$NON-NLS-1$
                    }
                }
            }
            return result.get( );
        } finally {
            this.serializerLock.unlock( );
        }

    }


    public SpiS2XSerializerCustomCallback getS2XSerializerCallback( ) {

        return null;
    }
}
