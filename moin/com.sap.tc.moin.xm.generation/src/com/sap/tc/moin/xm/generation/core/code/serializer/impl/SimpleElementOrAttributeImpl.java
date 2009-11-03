package com.sap.tc.moin.xm.generation.core.code.serializer.impl;

import java.util.Locale;

import com.sap.tc.moin.repository.exception.MoinNullPointerException;
import com.sap.tc.moin.xm.generation.core.code.serializer.template.QualifiedName;
import com.sap.tc.moin.xm.generation.core.code.serializer.template.SimpleElementOrAttribute;
import com.sap.tc.moin.xm.generation.core.code.util.PSUtil;


public final class SimpleElementOrAttributeImpl implements SimpleElementOrAttribute {

    private final QualifiedName qName;

    private final String qualifiedModelElementClassName;

    private final String attributeName;

    /**
     * Constructor.
     * 
     * @param aQName
     * @param aQualifiedModelElementClassName
     * @param aAttributeName
     * @throws NullPointerException if a parameter is <code>null</code>
     */
    SimpleElementOrAttributeImpl( final QualifiedName aQName, final String aQualifiedModelElementClassName, final String aAttributeName ) {

        if ( aQName == null ) {
            throw new MoinNullPointerException( "aQName" ); //$NON-NLS-1$
        }
        if ( aQualifiedModelElementClassName == null ) {
            throw new MoinNullPointerException( "aQualifiedModelElementClassName" ); //$NON-NLS-1$
        }
        if ( aAttributeName == null ) {
            throw new MoinNullPointerException( "aAttributeName" ); //$NON-NLS-1$
        }
        this.qName = aQName;
        this.qualifiedModelElementClassName = aQualifiedModelElementClassName;
        this.attributeName = aAttributeName;
    }


    public QualifiedName getQName( ) {

        return this.qName;
    }

    public String getQualifiedModelElementClassName( ) {

        return this.qualifiedModelElementClassName;
    }

    public String getUpperCaseAttributeName( ) {

        return PSUtil.unCamelize( this.attributeName, "_" ).toUpperCase( Locale.ENGLISH ); //$NON-NLS-1$
    }

    public boolean isSimpleElement( ) {

        return true;
    }

}
