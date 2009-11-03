package com.sap.tc.moin.repository.jmigenerator.template.impl;

import java.util.List;

import com.sap.tc.moin.repository.jmigenerator.JmiGenerationKind;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorAssociationInterfaceTemplate;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorClassOperation;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorDescriptorConstant;
import com.sap.tc.moin.repository.jmigenerator.wrappers.JmiGeneratorAssociationWrapper;

/**
 * The Association interface
 */
public class JmiGeneratorAssociationInterfaceTemplateImpl extends JmiGeneratorBaseTemplateImpl implements JmiGeneratorAssociationInterfaceTemplate {

    protected final JmiGeneratorAssociationWrapper myAssocWrapper;

    /**
     * @param wrapper
     */
    public JmiGeneratorAssociationInterfaceTemplateImpl( JmiGeneratorAssociationWrapper wrapper ) {

        super( wrapper, JmiGenerationKind.INTERFACE );
        this.myAssocWrapper = wrapper;
    }

    public JmiGeneratorDescriptorConstant getAssociationExtentDescriptorConstant( ) {

        return this.myAssocWrapper.getAssociationExtentDescriptorConstant( );
    }

    public List<JmiGeneratorClassOperation> getOperations( ) {

        return this.myAssocWrapper.getOperations( this.genKind );
    }

    public boolean isInterface( ) {

        return true;
    }

}
