package com.sap.tc.moin.repository.jmigenerator.template.impl;

import java.util.List;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.jmigenerator.JmiGenerationKind;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorClassInterfaceTemplate;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorClassOperation;
import com.sap.tc.moin.repository.jmigenerator.wrappers.JmiGeneratorClassWrapper;

/**
 * The internal Class interface
 */
public class JmiGeneratorClassInterfaceInternalTemplateImpl extends JmiGeneratorClassInterfaceTemplateImpl implements JmiGeneratorClassInterfaceTemplate {

    /**
     * @param wrapper
     */
    public JmiGeneratorClassInterfaceInternalTemplateImpl( JmiGeneratorClassWrapper wrapper ) {

        super( wrapper );
    }

    @Override
    public List<String> getExtends( ) {

        List<String> _extends = myWrapper.getExtends( this.genKind, true );
        for ( int i = 0, n = _extends.size( ); i < n; i++ ) {
            String _extend = _extends.get( i );
            if ( !_extend.startsWith( "com.sap.tc.moin.repository.mmi.reflect" ) ) { //$NON-NLS-1$
                int pos = _extend.lastIndexOf( '.' );
                String pkg = _extend.substring( 0, pos );
                String cls = _extend.substring( pos + 1 );
                _extends.set( i, pkg + ".__impl." + cls + "Internal" ); //$NON-NLS-1$  //$NON-NLS-2$
            }
        }
        return _extends;
    }

    @Override
    public List<JmiGeneratorClassOperation> getAttributeOperations( ) {

        List<JmiGeneratorClassOperation> attributeOps = super.getAttributeOperations( );
        for ( int i = 0, n = attributeOps.size( ); i < n; i++ ) {
            JmiGeneratorClassOperation operation = attributeOps.get( i );
            if ( operation.needsCoreConnectionInInternalInterface( ) ) {
                operation.getParameters( ).add( 0, new JmiGeneratorParameterImpl( "connection", CoreConnection.class.getName( ), null ) ); //$NON-NLS-1$
            }
        }
        return attributeOps;
    }

    @Override
    public List<JmiGeneratorClassOperation> getReferenceOperations( ) {

        List<JmiGeneratorClassOperation> referenceOps = super.getReferenceOperations( );
        for ( int i = 0, n = referenceOps.size( ); i < n; i++ ) {
            JmiGeneratorClassOperation operation = referenceOps.get( i );
            operation.getParameters( ).add( 0, new JmiGeneratorParameterImpl( "connection", CoreConnection.class.getName( ), null ) ); //$NON-NLS-1$
        }
        return referenceOps;
    }

    @Override
    public List<JmiGeneratorClassOperation> getOperations( ) {

        List<JmiGeneratorClassOperation> operationOps = super.getOperations( );
        for ( int i = 0, n = operationOps.size( ); i < n; i++ ) {
            JmiGeneratorClassOperation operation = operationOps.get( i );
            operation.getParameters( ).add( 0, new JmiGeneratorParameterImpl( "connection", CoreConnection.class.getName( ), null ) ); //$NON-NLS-1$
        }
        return operationOps;
    }

    @Override
    public String getJavaName( ) {

        return super.getJavaName( ) + "Internal"; //$NON-NLS-1$
    }

    @Override
    public String getPackageName( ) {

        return myWrapper.getJavaPackageNameQualified( JmiGenerationKind.CLASS );
    }
}
