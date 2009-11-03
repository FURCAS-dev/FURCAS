package com.sap.tc.moin.xm.cps;

import java.lang.reflect.InvocationTargetException;

import com.sap.tc.moin.repository.exception.MoinNullPointerException;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.spi.ps.SpiCustomParserSerializerFactory;
import com.sap.tc.moin.repository.spi.ps.SpiXmParserSerializerConfiguration;

/**
 * XM Custom Parser/Serializer Factory.
 */
public abstract class XmCpsFactory implements SpiCustomParserSerializerFactory {

    private static final MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_XM, MoinLocationEnum.MOIN_XM_RT, XmCpsFactory.class );

    private static final String className = "com.sap.tc.moin.xm.adapter.cps.XmCpsFactoryImpl"; //$NON-NLS-1$

    private static final String error = "Class " + className + " does not exist"; //$NON-NLS-1$  //$NON-NLS-2$


    /**
     * Creates a XM custom parser serializer factory for a certain
     * configuration.
     * 
     * @return factory
     * @throws NullPointerException if <tt>configuration</tt> is
     * <code>null</code>
     */
    public static SpiCustomParserSerializerFactory createXmCpsFactory( final SpiXmParserSerializerConfiguration configuration ) {

        if ( configuration == null ) {
            throw new MoinNullPointerException( "configuration" ); //$NON-NLS-1$
        }
        try {
            return (SpiCustomParserSerializerFactory) Class.forName( className ).getConstructor( SpiXmParserSerializerConfiguration.class ).newInstance( configuration );
        } catch ( final InstantiationException e ) {
            LOGGER.trace( e, MoinSeverity.FATAL, error );
            throw new IllegalStateException( error, e );
        } catch ( final IllegalAccessException e ) {
            LOGGER.trace( e, MoinSeverity.FATAL, error );
            throw new IllegalStateException( error, e );
        } catch ( final ClassNotFoundException e ) {
            LOGGER.trace( e, MoinSeverity.FATAL, error );
            throw new IllegalStateException( error, e );
        } catch ( final InvocationTargetException e ) {
            LOGGER.trace( e, MoinSeverity.FATAL, error );
            throw new IllegalStateException( error, e );
        } catch ( final NoSuchMethodException e ) {
            LOGGER.trace( e, MoinSeverity.FATAL, error );
            throw new IllegalStateException( error, e );
        }
    }

}
