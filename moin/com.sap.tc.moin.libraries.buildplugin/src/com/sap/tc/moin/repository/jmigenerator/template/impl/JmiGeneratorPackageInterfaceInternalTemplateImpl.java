package com.sap.tc.moin.repository.jmigenerator.template.impl;

import java.util.List;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.jmigenerator.JmiGenerationKind;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorClassOperation;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorPackageInterfaceTemplate;
import com.sap.tc.moin.repository.jmigenerator.wrappers.JmiGeneratorPackageWrapper;

/**
 * The internal package interface
 */
public class JmiGeneratorPackageInterfaceInternalTemplateImpl extends JmiGeneratorPackageInterfaceTemplateImpl implements JmiGeneratorPackageInterfaceTemplate {

    /**
     * @param wrapper
     */
    public JmiGeneratorPackageInterfaceInternalTemplateImpl( JmiGeneratorPackageWrapper wrapper ) {

        super( wrapper );
    }

    @Override
    public List<String> getExtends( ) {

        List<String> _extends = myPackageWrapper.getExtends( this.genKind, true );
        for ( int i = 0, n = _extends.size( ); i < n; i++ ) {
            String _extend = _extends.get( i );
            if ( !_extend.startsWith( "com.sap.tc.moin.repository.mmi.reflect" ) ) { //$NON-NLS-1$
                int pos = _extend.lastIndexOf( '.' );
                String pkg = _extend.substring( 0, pos );
                String cls = _extend.substring( pos + 1 );
                _extends.set( i, pkg + ".__impl." + cls + "Internal" ); //$NON-NLS-1$ //$NON-NLS-2$
            }
        }
        return _extends;
    }

    @Override
    public List<JmiGeneratorClassOperation> getStructureTypes( ) {

        List<JmiGeneratorClassOperation> structureTypeOps = super.getStructureTypes( );
        for ( int i = 0, n = structureTypeOps.size( ); i < n; i++ ) {
            JmiGeneratorClassOperation operation = structureTypeOps.get( i );
            operation.setHasCoreConnection( true );
            operation.getParameters( ).add( 0, new JmiGeneratorParameterImpl( "connection", CoreConnection.class.getName( ), null ) ); //$NON-NLS-1$
        }
        return structureTypeOps;
    }

    @Override
    public String getJavaName( ) {

        return super.getJavaName( ) + "Internal"; //$NON-NLS-1$
    }

    @Override
    public String getPackageName( ) {

        return myPackageWrapper.getJavaPackageNameQualified( JmiGenerationKind.CLASS );
    }
}