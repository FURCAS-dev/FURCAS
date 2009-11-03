package com.sap.tc.moin.xm.generation.core.code.parser.impl;

import java.util.Locale;

import com.sap.tc.moin.repository.exception.MoinNullPointerException;
import com.sap.tc.moin.xm.generation.core.code.parser.template.XmlElementOrAttributeNameToMoinAttributeName;
import com.sap.tc.moin.xm.generation.core.code.util.PSUtil;


public final class XmlElementOrAttributeNameToMoinAttributeNameImpl implements XmlElementOrAttributeNameToMoinAttributeName {

    private final String lName;

    private final String moinName;

    private final String qualifiedJmiClassName;

    private final boolean isForRootElement;

    /**
     * Constructor.
     * 
     * @param localName
     * @param moinAttributeName
     * @param aQualifiedJmiClassName JMI class name of the MOF class to which
     * the attribute belongs
     * @throws NullPointerException if a parameter is <code>null</code>
     */
    XmlElementOrAttributeNameToMoinAttributeNameImpl( final String localName, final String moinAttributeName, final String aQualifiedJmiClassName, final boolean forRootElement ) {

        if ( localName == null ) {
            throw new MoinNullPointerException( "localName" ); //$NON-NLS-1$
        }
        if ( moinAttributeName == null ) {
            throw new MoinNullPointerException( "moinAttributeName" ); //$NON-NLS-1$
        }
        if ( aQualifiedJmiClassName == null ) {
            throw new MoinNullPointerException( "aQualifiedJmiClassName" ); //$NON-NLS-1$
        }
        this.lName = PSUtil.replaceNonJavaCharacters( localName );
        this.moinName = moinAttributeName;
        this.qualifiedJmiClassName = aQualifiedJmiClassName;
        this.isForRootElement = forRootElement;

    }


    public String getLocalXmlElementOrAttributeName( ) {

        return this.lName;
    }

    public String getUpperCaseMoinAttributeName( ) {

        return PSUtil.unCamelize( this.moinName, "_" ).toUpperCase( Locale.ENGLISH ); //$NON-NLS-1$
    }

    public String getQualifiedJavaClassName( ) {

        return this.qualifiedJmiClassName;
    }

    public boolean isForRootElement( ) {

        return this.isForRootElement;
    }

}
