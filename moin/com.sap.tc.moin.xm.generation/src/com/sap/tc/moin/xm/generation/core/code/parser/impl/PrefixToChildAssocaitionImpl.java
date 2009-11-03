package com.sap.tc.moin.xm.generation.core.code.parser.impl;

import java.util.ArrayList;
import java.util.List;

import com.sap.tc.moin.repository.exception.MoinNullPointerException;
import com.sap.tc.moin.xm.generation.core.code.parser.template.ChildAssociation;
import com.sap.tc.moin.xm.generation.core.code.parser.template.PrefixToChildAssociation;


public final class PrefixToChildAssocaitionImpl implements PrefixToChildAssociation {


    private final String prefix;

    private final List<ChildAssociation> elements = new ArrayList<ChildAssociation>( );

    PrefixToChildAssocaitionImpl( final String aPrefix ) {

        if ( aPrefix == null ) {
            throw new MoinNullPointerException( "aPrefix" ); //$NON-NLS-1$
        }
        this.prefix = aPrefix;
    }

    public String getPrefix( ) {

        return this.prefix;
    }

    public List<ChildAssociation> getChildAssociations( ) {

        return this.elements;
    }

}
