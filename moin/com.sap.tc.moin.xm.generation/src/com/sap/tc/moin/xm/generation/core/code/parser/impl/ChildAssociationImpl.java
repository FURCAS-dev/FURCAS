package com.sap.tc.moin.xm.generation.core.code.parser.impl;

import com.sap.tc.moin.repository.exception.MoinNullPointerException;
import com.sap.tc.moin.xm.generation.core.code.parser.template.ChildAssociation;
import com.sap.tc.moin.xm.generation.core.code.util.PSUtil;
import com.sap.tc.moin.xm.generation.core.code.util.XmParserSerializerTemplateImpl;
import com.sap.tc.moin.xm.generation.core.metamodel.om.XmAssociation;


public final class ChildAssociationImpl implements ChildAssociation {


    private final String lName;

    private final XmAssociation assoc;

    private final boolean isForRootElementClosed;

    public ChildAssociationImpl( final String localName, final XmAssociation association, final boolean forRootElementClosed ) {

        if ( localName == null ) {
            throw new MoinNullPointerException( "localName" ); //$NON-NLS-1$
        }

        if ( association == null ) {
            throw new MoinNullPointerException( "association" ); //$NON-NLS-1$
        }
        this.lName = PSUtil.replaceNonJavaCharacters( localName );
        this.assoc = association;
        this.isForRootElementClosed = forRootElementClosed;
    }

    public String getLocalName( ) {

        return this.lName;
    }

    public String getQualifiedJavaClassName( ) {

        return XmParserSerializerTemplateImpl.getQualifiedJmiClassName( this.assoc.getNamespace( ), this.assoc.getMofName( ) );
    }


    public String getReferencedEndName( ) {

        return this.assoc.getReferencedEndName( );
    }

    public boolean isForRootElementClosed( ) {

        return this.isForRootElementClosed;
    }

}
