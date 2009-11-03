package com.sap.tc.moin.xm.generation.core.code.parser.impl;

import java.util.ArrayList;
import java.util.List;

import com.sap.tc.moin.repository.exception.MoinNullPointerException;
import com.sap.tc.moin.xm.generation.core.code.parser.template.ElementNameAndHandlerClassName;
import com.sap.tc.moin.xm.generation.core.code.parser.template.PrefixToElementHandlers;


public final class PrefixToElementHandlersImpl implements PrefixToElementHandlers {


    private final String prefix;

    private final List<ElementNameAndHandlerClassName> elements = new ArrayList<ElementNameAndHandlerClassName>( 1 );

    PrefixToElementHandlersImpl( final String aPrefix ) {

        if ( aPrefix == null ) {
            throw new MoinNullPointerException( "aPrefix" ); //$NON-NLS-1$
        }
        this.prefix = aPrefix;
    }

    public String getPrefix( ) {

        return this.prefix;
    }

    public List<ElementNameAndHandlerClassName> getElements( ) {

        return this.elements;
    }

}
