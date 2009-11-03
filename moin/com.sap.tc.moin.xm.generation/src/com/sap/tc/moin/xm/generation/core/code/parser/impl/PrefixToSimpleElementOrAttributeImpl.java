package com.sap.tc.moin.xm.generation.core.code.parser.impl;

import java.util.ArrayList;
import java.util.List;

import com.sap.tc.moin.repository.exception.MoinNullPointerException;
import com.sap.tc.moin.xm.generation.core.code.parser.template.PrefixToSimpleElementOrAttribute;
import com.sap.tc.moin.xm.generation.core.code.parser.template.XmlElementOrAttributeNameToMoinAttributeName;


public final class PrefixToSimpleElementOrAttributeImpl implements PrefixToSimpleElementOrAttribute {


    private final String prefix;

    private final List<XmlElementOrAttributeNameToMoinAttributeName> moinAttributes = new ArrayList<XmlElementOrAttributeNameToMoinAttributeName>( 4 );

    PrefixToSimpleElementOrAttributeImpl( final String aPrefix ) {

        if ( aPrefix == null ) {
            throw new MoinNullPointerException( "aPrefix" ); //$NON-NLS-1$
        }
        this.prefix = aPrefix;
    }

    public String getPrefix( ) {

        return this.prefix;
    }


    public List<XmlElementOrAttributeNameToMoinAttributeName> getMoinAttributes( ) {

        return this.moinAttributes;
    }
}
