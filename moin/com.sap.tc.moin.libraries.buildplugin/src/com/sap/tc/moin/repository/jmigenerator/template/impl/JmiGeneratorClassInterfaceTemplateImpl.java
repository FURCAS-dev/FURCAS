package com.sap.tc.moin.repository.jmigenerator.template.impl;

import java.util.List;

import com.sap.tc.moin.repository.jmigenerator.JmiGenerationKind;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorClassInterfaceTemplate;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorClassOperation;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorConstant;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorDescriptorConstant;
import com.sap.tc.moin.repository.jmigenerator.wrappers.JmiGeneratorClassWrapper;

/**
 * The Class interface
 */
public class JmiGeneratorClassInterfaceTemplateImpl extends JmiGeneratorBaseTemplateImpl implements JmiGeneratorClassInterfaceTemplate {

    private final JmiGeneratorClassWrapper myClassWrapper;

    /**
     * @param wrapper
     */
    public JmiGeneratorClassInterfaceTemplateImpl( JmiGeneratorClassWrapper wrapper ) {

        super( wrapper, JmiGenerationKind.INTERFACE );
        this.myClassWrapper = wrapper;
    }

    public List<JmiGeneratorClassOperation> getAttributeOperations( ) {

        return this.myClassWrapper.getAttributeOperations( this.genKind, false );
    }

    public List<JmiGeneratorClassOperation> getReferenceOperations( ) {

        return this.myClassWrapper.getReferenceOperations( this.genKind );
    }

    public List<JmiGeneratorClassOperation> getOperations( ) {

        return this.myClassWrapper.getOperations( this.genKind, false );
    }

    public List<JmiGeneratorConstant> getConstants( ) {

        return this.myClassWrapper.getConstants( this.genKind );
    }

    public JmiGeneratorDescriptorConstant getClassExtentDescriptorConstant( ) {

        return this.myClassWrapper.getClassExtentDescriptorConstant( );
    }

    public String getDescriptorsBody( ) {

        return this.myClassWrapper.getDescriptorsBody( );
    }

    public boolean isInterface( ) {

        return true;
    }
}