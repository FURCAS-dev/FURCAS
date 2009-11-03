package com.sap.tc.moin.xm.generation.core.code.cps;


public final class XmCpsModelstorageTemplate {



    private final String qualifiedFactoryClassName;

    private final String suffix;

    private final String serializationId;


    public XmCpsModelstorageTemplate( final String qualifiedFactoryClassName, final String suffix, final String serializationId ) {

        super( );
        this.qualifiedFactoryClassName = qualifiedFactoryClassName;
        this.suffix = suffix;
        this.serializationId = serializationId;
    }


    /**
     * Returns the qualified factory java class name. Separator is ".".
     * 
     * @return qualified class name
     */
    public String getQualifiedFactoryClassName( ) {

        return qualifiedFactoryClassName;
    }

    public String getSuffix( ) {

        return suffix;
    }



    public String getSerializationId( ) {

        return serializationId;
    }



}
