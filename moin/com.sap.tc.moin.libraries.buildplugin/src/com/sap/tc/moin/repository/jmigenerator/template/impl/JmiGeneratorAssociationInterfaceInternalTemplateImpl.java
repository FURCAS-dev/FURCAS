package com.sap.tc.moin.repository.jmigenerator.template.impl;

import java.util.List;

import com.sap.tc.moin.repository.core.CoreConnection;
import com.sap.tc.moin.repository.jmigenerator.JmiGenerationKind;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorAssociationInterfaceTemplate;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorClassOperation;
import com.sap.tc.moin.repository.jmigenerator.wrappers.JmiGeneratorAssociationWrapper;

/**
 * The Association interface
 */
public class JmiGeneratorAssociationInterfaceInternalTemplateImpl extends JmiGeneratorAssociationInterfaceTemplateImpl implements JmiGeneratorAssociationInterfaceTemplate {

    /**
     * @param wrapper
     */
    public JmiGeneratorAssociationInterfaceInternalTemplateImpl( JmiGeneratorAssociationWrapper wrapper ) {

        super( wrapper );
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

        return myAssocWrapper.getJavaPackageNameQualified( JmiGenerationKind.CLASS );
    }
}
