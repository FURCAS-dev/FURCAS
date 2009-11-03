package com.sap.tc.moin.xm.generation.core.code.util;


public enum XsdKind {

    LOCAL_ELEMENT( "local element declaration " ), GLOBAL_ELEMENT( "global element declaration " ), GLOBAL_COMPLEX_TYPE( "global complex type definition " ), DOCUMENT_ROOT( "document root " ); //$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$ //$NON-NLS-4$


    private final String type;

    private XsdKind( final String aType ) {

        if ( aType == null ) {
            throw new NullPointerException( "aType is null" ); //$NON-NLS-1$
        }
        this.type = aType;
    }

    @Override
    public String toString( ) {

        return this.type;
    }

}
