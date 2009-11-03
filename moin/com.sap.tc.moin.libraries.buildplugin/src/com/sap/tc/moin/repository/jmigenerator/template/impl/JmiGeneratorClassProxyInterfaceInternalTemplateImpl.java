package com.sap.tc.moin.repository.jmigenerator.template.impl;

import java.util.List;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.jmigenerator.JmiGenerationKind;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorClassOperation;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorClassProxyInterfaceTemplate;
import com.sap.tc.moin.repository.jmigenerator.wrappers.JmiGeneratorClassWrapper;

/**
 * The internal Class proxy interface
 */
public class JmiGeneratorClassProxyInterfaceInternalTemplateImpl extends JmiGeneratorClassProxyInterfaceTemplateImpl implements JmiGeneratorClassProxyInterfaceTemplate {

    /**
     * @param wrapper
     */
    public JmiGeneratorClassProxyInterfaceInternalTemplateImpl( JmiGeneratorClassWrapper wrapper ) {

        super( wrapper );
    }

    @Override
    public List<JmiGeneratorClassOperation> getConstructors( ) {

        List<JmiGeneratorClassOperation> constructors = super.getConstructors( );
        for ( int i = 0, n = constructors.size( ); i < n; i++ ) {
            JmiGeneratorClassOperation operation = constructors.get( i );
            if ( operation.needsCoreConnectionInInternalInterface( ) ) {
                operation.getParameters( ).add( 0, new JmiGeneratorParameterImpl( "connection", CoreConnection.class.getName( ), null ) ); //$NON-NLS-1$
            }
        }
        return constructors;
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
    public List<JmiGeneratorClassOperation> getOperations( ) {

        List<JmiGeneratorClassOperation> operationOps = super.getOperations( );
        for ( int i = 0, n = operationOps.size( ); i < n; i++ ) {
            JmiGeneratorClassOperation operation = operationOps.get( i );
            operation.getParameters( ).add( 0, new JmiGeneratorParameterImpl( "connection", CoreConnection.class.getName( ), null ) ); //$NON-NLS-1$
        }
        return operationOps;
    }

    @Override
    public List<JmiGeneratorClassOperation> getStructureTypes( ) {

        List<JmiGeneratorClassOperation> structureTypes = super.getStructureTypes( );
        for ( int i = 0, n = structureTypes.size( ); i < n; i++ ) {
            JmiGeneratorClassOperation operation = structureTypes.get( i );
            operation.getParameters( ).add( 0, new JmiGeneratorParameterImpl( "connection", CoreConnection.class.getName( ), null ) ); //$NON-NLS-1$
        }
        return structureTypes;
    }

    @Override
    public String getJavaName( ) {

        return super.getJavaName( ) + "Internal"; //$NON-NLS-1$
    }

    @Override
    public String getPackageName( ) {

        return myClassWrapper.getJavaPackageNameQualified( JmiGenerationKind.CLASS );
    }
}