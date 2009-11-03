package com.sap.tc.moin.repository.jmigenerator.template.impl;

import java.util.ArrayList;
import java.util.List;

import com.sap.tc.moin.repository.core.jmi.reflect.RefAssociationWrapperImpl;
import com.sap.tc.moin.repository.jmigenerator.JmiGenerationKind;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorBaseTemplate;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorClassOperation;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorInterfaceTemplate;
import com.sap.tc.moin.repository.jmigenerator.wrappers.JmiGeneratorAssociationWrapper;

/**
 * The Association wrapper
 */
public class JmiGeneratorAssociationWrapperTemplateImpl extends JmiGeneratorBaseWrapperTemplateImpl {

    private final JmiGeneratorAssociationWrapper myAssocWrapper;

    /**
     * @param wrapper
     */
    public JmiGeneratorAssociationWrapperTemplateImpl( JmiGeneratorAssociationWrapper wrapper ) {

        super( wrapper, JmiGenerationKind.WRAPPER );
        this.myAssocWrapper = wrapper;
    }

    public JmiGeneratorInterfaceTemplate getInterface( ) {

        return (JmiGeneratorAssociationInterfaceTemplateImpl) this.myAssocWrapper.getJavaTemplate( JmiGenerationKind.INTERFACE, "AssociationInterface" ); //$NON-NLS-1$
    }

    @Override
    public List<String> getImplements( ) {

        String interfaceType = getInterfaceType( );

        List<String> result = new ArrayList<String>( );
        result.add( interfaceType );
        result.add( "com.sap.tc.moin.repository.Partitionable" ); //$NON-NLS-1$

        return result;
    }

    public List<JmiGeneratorClassOperation> getInternalModeledOperations( ) {

        // not relevat for association wrapper
        return null;
    }

    public List<JmiGeneratorClassOperation> getOperations( ) {

        return this.myAssocWrapper.getOperations( genKind );
    }

    public List<String> getOperationIds( ) {

        // not relevat for association wrapper
        return null;
    }

    @Override
    public List<String> getExtends( ) {

        List<String> result = new ArrayList<String>( );
        result.add( RefAssociationWrapperImpl.class.getName( ) + "<" + getInterfaceType( ) + ">" ); //$NON-NLS-1$//$NON-NLS-2$
        return result;
    }

    public JmiGeneratorBaseTemplate getImplementation( ) {

        return this.myAssocWrapper.getJavaTemplate( JmiGenerationKind.CLASS, "AssociationImpl" ); //$NON-NLS-1$
    }

    public String getMetaObjectToString( ) {

        return myAssocWrapper.getJavaClassName( JmiGenerationKind.INTERFACE, true ) + " (Java Type)\\n" + myAssocWrapper.getQualifiedNameDotSeparated( ) + " (MOF Type)"; //$NON-NLS-1$//$NON-NLS-2$
    }
}
