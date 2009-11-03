package com.sap.tc.moin.repository.core.generator.jmi.javamodel;

public class PropertySource extends JavaSource {

    public PropertySource( String aQualifiedName ) {

        super( aQualifiedName );
    }

    @Override
    public String getExtension( ) {

        return "properties"; //$NON-NLS-1$
    }
}
