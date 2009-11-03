package com.sap.tc.moin.repository.jmigenerator.template.impl;

import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorConstant;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorJavadoc;

public class JmiGeneratorConstantImpl implements JmiGeneratorConstant {

    private String visibility = ""; //$NON-NLS-1$

    private String type = ""; //$NON-NLS-1$

    private String name = ""; //$NON-NLS-1$

    private String value = ""; //$NON-NLS-1$

    private JmiGeneratorJavadoc javadoc = null;

    public JmiGeneratorConstantImpl( String aVisibility, String aType, String aName, String aValue ) {

        visibility = aVisibility;
        type = aType;
        name = aName;
        value = aValue;
    }

    public String getVisibility( ) {

        return visibility;
    }

    public String getType( ) {

        return type;
    }

    public String getName( ) {

        return name;
    }

    public String getValue( ) {

        return value;
    }

    public JmiGeneratorJavadoc getJavadoc( ) {

        return javadoc;
    }

    public void setAnnotation( String annotation ) {

        if ( annotation != null && annotation.length( ) != 0 ) {
            this.javadoc = new JmiGeneratorJavadocImpl( annotation );
        }
    }

    public boolean isString( ) {

        return getType( ).equals( "java.lang.String" ); //$NON-NLS-1$
    }
}
