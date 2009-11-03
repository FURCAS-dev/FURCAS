package com.sap.tc.moin.xm.generation.core.code.util;

import com.sap.tc.moin.repository.exception.MoinNullPointerException;



public final class PrefixAndNamespaceImpl implements PrefixAndNamespace {

    private final String prefix;

    private final String namespace;

    public PrefixAndNamespaceImpl( final String aPrefix, final String aNamespace ) {

        if ( aPrefix == null ) {
            throw new MoinNullPointerException( "aPrefix" ); //$NON-NLS-1$
        }
        if ( aNamespace == null ) {
            throw new MoinNullPointerException( "aNamespace" ); //$NON-NLS-1$
        }
        this.prefix = aPrefix;
        this.namespace = aNamespace;
    }

    public String getNamespace( ) {

        return this.namespace;
    }

    public String getPrefix( ) {

        return this.prefix;
    }

    private String text;

    @Override
    public String toString( ) {

        if ( this.text == null ) {
            this.text = "Prefix: " + this.prefix + " namespace: " + this.namespace; //$NON-NLS-1$ //$NON-NLS-2$
        }
        return this.text;
    }

}
