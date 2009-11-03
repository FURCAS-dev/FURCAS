package com.sap.tc.moin.xm.generation.core.code.serializer.impl;

import javax.xml.XMLConstants;

import com.sap.tc.moin.repository.exception.MoinNullPointerException;
import com.sap.tc.moin.xm.generation.core.code.serializer.template.QualifiedName;
import com.sap.tc.moin.xm.generation.core.code.util.PSUtil;


public class QualifiedNameImpl implements QualifiedName {

    private final String localPart;

    private final String namespace;

    private final String prefix;

    private final String qName;

    private final String javaLocalPart;

    /**
     * Constructor.
     * 
     * @param aLocalPart
     * @param aNamespace
     * @param aPrefix
     * @throws NullPointerException if a parameter except <tt>aNamespace</tt> is
     * <code>null</code>
     */
    public QualifiedNameImpl( final String aLocalPart, final String aNamespace, final String aPrefix ) {

        if ( aLocalPart == null ) {
            throw new MoinNullPointerException( "aLocalPart" ); //$NON-NLS-1$
        }
        if ( aPrefix == null ) {
            throw new MoinNullPointerException( "aPrefix" ); //$NON-NLS-1$
        }
        this.prefix = aPrefix;
        this.localPart = aLocalPart;
        if ( aNamespace == null ) {
            this.namespace = "";//$NON-NLS-1$
        } else {
            this.namespace = aNamespace;
        }
        this.javaLocalPart = PSUtil.replaceNonJavaCharacters( this.localPart );
        this.qName = prefix.length( ) == 0 ? this.localPart : ":" + this.localPart;//$NON-NLS-1$
    }

    public String getLocalPart( ) {

        return this.localPart;
    }

    public String getJavaLocalPart( ) {

        return this.javaLocalPart;
    }

    public String getNamespace( ) {

        return this.namespace;
    }

    public String getPrefix( ) {

        return this.prefix;
    }

    public String getQName( ) {

        return this.qName;
    }

    @Override
    public int hashCode( ) {

        final int prime = 31;
        int result = 1;
        result = prime * result + localPart.hashCode( );
        result = prime * result + namespace.hashCode( );
        return result;
    }

    @Override
    public boolean equals( final Object obj ) {

        if ( this == obj ) {
            return true;
        }
        if ( obj == null ) {
            return false;
        }
        if ( getClass( ) != obj.getClass( ) ) {
            return false;
        }
        final QualifiedNameImpl other = (QualifiedNameImpl) obj;
        if ( localPart == null ) {
            if ( other.localPart != null ) {
                return false;
            }
        } else if ( !localPart.equals( other.localPart ) ) {
            return false;
        }
        if ( namespace == null ) {
            if ( other.namespace != null ) {
                return false;
            }
        } else if ( !namespace.equals( other.namespace ) ) {
            return false;
        }
        return true;
    }

    @Override
    public String toString( ) {

        if ( namespace.equals( XMLConstants.NULL_NS_URI ) ) {
            return localPart;
        } else {
            return "{" + namespace + "}" + localPart; //$NON-NLS-1$//$NON-NLS-2$
        }
    }

}
