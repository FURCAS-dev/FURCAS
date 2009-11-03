package com.sap.tc.moin.xm.kernel.impl.parser.sax;

import com.sap.tc.moin.repository.exception.MoinNullPointerException;
import com.sap.tc.moin.repository.xm.parser.XmlAttribute;


/**
 * Immutable XML attribute.
 */
public class XmlAttributeImpl implements XmlAttribute {


    private final String localName;

    private final String namespace;

    private final String value;

    /**
     * Constructor.
     * 
     * @param aLocalName
     * @param aNamespace
     * @param aValue
     * @throws NullPointerException if a parameter is <code>null</code>
     */
    XmlAttributeImpl( final String aLocalName, final String aNamespace, final String aValue ) {

        if ( aLocalName == null ) {
            throw new MoinNullPointerException( "aLocalName" ); //$NON-NLS-1$
        }
        if ( aLocalName == null ) {
            throw new MoinNullPointerException( "aNamespace" ); //$NON-NLS-1$
        }
        if ( aLocalName == null ) {
            throw new MoinNullPointerException( "aValue" ); //$NON-NLS-1$
        }

        this.localName = aLocalName;
        this.namespace = aNamespace;
        this.value = aValue;
    }

    public String getLocalName( ) {

        return this.localName;
    }

    public String getNamespace( ) {

        return this.namespace;
    }

    public String getValue( ) {

        return this.value;
    }

}
