package com.sap.tc.moin.repository.xm.serializer;

import com.sap.tc.moin.repository.exception.MoinNullPointerException;


/**
 * Configuration of the XM Serializer.
 */
public final class XmSerializerConfiguration {

    private final XmCustomSerializer serializer;

    /**
     * Constructor.
     * 
     * @param customSerializer custom serializer
     * @throws NullPointerException if the parameter <tt>null</tt>
     */
    private XmSerializerConfiguration( final XmCustomSerializer customSerializer ) {

        if ( customSerializer == null ) {
            throw new MoinNullPointerException( "customSerializer" ); //$NON-NLS-1$
        }
        this.serializer = customSerializer;
    }

    /**
     * Returns an instance.
     * 
     * @param customSerializer custom serializer
     * @return parser configuration
     * @throws NullPointerException if the parameter is <tt>null</tt>
     */
    public static XmSerializerConfiguration getInstance( final XmCustomSerializer customSerializer ) {

        return new XmSerializerConfiguration( customSerializer );
    }

    /**
     * Returns the custom serializer instance.
     * 
     * @return custom serializer instance, cannot be <code>null</code>
     */
    public XmCustomSerializer getCustomSerializer( ) {

        return this.serializer;
    }
}
