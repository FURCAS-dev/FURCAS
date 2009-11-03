package com.sap.tc.moin.repository.core.generator.jmi.javamodel;

public class JavaSource {

    private String qualifiedName;

    private String code;

    public JavaSource( String aQualifiedName ) {

        qualifiedName = aQualifiedName;
    }

    public void setCode( String aCode ) {

        code = aCode;
    }

    public String getCode( ) {

        return code;
    }

    public String getQualifiedName( ) {

        return qualifiedName;
    }

    public String getExtension( ) {

        return "java"; //$NON-NLS-1$
    }
}