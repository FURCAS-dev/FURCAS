package com.sap.tc.moin.xm.generation.core.code.cps;

import com.sap.tc.moin.xm.generation.core.code.util.XmGenerationConstants;


public final class XmCpsFactoryTemplate {

    private final String packageName;

    private final String className;

    private final String parserQualifiedClassName;

    private final String serializerQualifiedClassName;



    public XmCpsFactoryTemplate( final String packageName, final String className, final String parserQualifiedClassName, final String serializerQualifiedClassName ) {

        this.packageName = packageName;
        this.className = className;
        this.parserQualifiedClassName = parserQualifiedClassName;
        this.serializerQualifiedClassName = serializerQualifiedClassName;
    }


    public String getPackageName( ) {

        return packageName;
    }


    public String getClassName( ) {

        return className;
    }


    public String getParserQualifiedClassName( ) {

        return parserQualifiedClassName;
    }


    public String getSerializerQualifiedClassName( ) {

        return serializerQualifiedClassName;
    }

    public String getPreamble( ) {

        return XmGenerationConstants.PREAMBLE;
    }



}
