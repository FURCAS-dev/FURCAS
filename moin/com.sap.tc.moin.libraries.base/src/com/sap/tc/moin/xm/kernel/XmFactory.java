package com.sap.tc.moin.xm.kernel;

import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;
import com.sap.tc.moin.repository.xm.parser.XmParserConfiguration;
import com.sap.tc.moin.repository.xm.serializer.XmSerializerConfiguration;

/**
 * Factory for the parser and serializer of the XM kernel.
 * 
 * @param <TElement> either a RefObject representing a MOF class instance in the
 * Import/Export integration strategy or a SpiElement in the CPS integration
 * strategy
 * @param <TMofClass> either RefClass in the Import/Export integration strategy
 * or SpiClass in the CPS integration strategy
 * @param <TMofAssociation> either a RefAssociation in the Import/Export
 * integration strategy or a SpiAssociation in the CPS integration strategy
 */
public abstract class XmFactory<TElement, TMofClass, TMofAssociation> {

    private static final MoinLogger LOGGER = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_XM, MoinLocationEnum.MOIN_XM_RT, XmFactory.class );

    private static final String className = "com.sap.tc.moin.xm.kernel.impl.XmFactoryImpl"; //$NON-NLS-1$

    private static final String error = "The class " + className + " does not exist."; //$NON-NLS-1$ //$NON-NLS-2$

    protected XmFactory( ) {

    }

    /**
     * Returns a factory instance.
     * 
     * @param <TElement> either a RefObject representing a MOF class instance in
     * the Import/Export integration strategy or a SpiElement in the CPS
     * integration strategy
     * @param <TMofClass> either RefClass in the Import/Export integration
     * strategy or SpiClass in the CPS integration strategy
     * @param <TMofAssociation> either a RefAssociation in the Import/Export
     * integration strategy or a SpiAssociation in the CPS integration strategy
     */
    @SuppressWarnings( "unchecked" )
    public static <TElement, TMofClass, TMofAssociation> XmFactory<TElement, TMofClass, TMofAssociation> getInstance( ) {

        try {
            return (XmFactory<TElement, TMofClass, TMofAssociation>) Class.forName( className ).newInstance( );
        } catch ( final InstantiationException e ) {
            LOGGER.trace( e, MoinSeverity.FATAL, error );
            throw new IllegalStateException( error, e );
        } catch ( final IllegalAccessException e ) {
            LOGGER.trace( e, MoinSeverity.FATAL, error );
            throw new IllegalStateException( error, e );
        } catch ( final ClassNotFoundException e ) {
            LOGGER.trace( e, MoinSeverity.FATAL, error );
            throw new IllegalStateException( error, e );
        }
    }

    /**
     * Returns a parser instance.
     * <p>
     * The returned instance allocates memory. It is in the responsibility of
     * the user to release the instance to the garbage collector to free the
     * memory when the instance is no longer needed.
     * <p>
     * <strong>The parser implementation is not thread save. See
     * {@link XmParser}.</strong>
     * 
     * @param configuration parser configuration
     * @return XM parser
     * @throws NullPointerException if a parameter is <tt>null</tt>
     */
    public abstract XmParser<TElement, TMofClass, TMofAssociation> getParser( XmParserConfiguration configuration );

    /**
     * Returns a serializer instance.
     * <p>
     * The returned instance allocates memory. It is in the responsibility of
     * the user to release the instance to the garbage collector to free the
     * memory when the instance is no longer needed.
     * <p>
     * <strong>The serializer implementation is not thread save. See
     * {@link XmSerializer}.</strong>
     * 
     * @param configuration serializer configuration
     * @return XM serializer
     * @throws NullPointerException if a parameter is <tt>null</tt>
     */
    public abstract XmSerializer<TElement, TMofClass, TMofAssociation> getSerializer( XmSerializerConfiguration configuration );


}
