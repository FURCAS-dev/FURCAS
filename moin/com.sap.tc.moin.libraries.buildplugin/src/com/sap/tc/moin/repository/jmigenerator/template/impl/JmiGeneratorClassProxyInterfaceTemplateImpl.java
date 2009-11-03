package com.sap.tc.moin.repository.jmigenerator.template.impl;

import java.util.List;

import com.sap.tc.moin.repository.jmigenerator.JmiGenerationKind;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorClassOperation;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorClassProxyInterfaceTemplate;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorDescriptorConstant;
import com.sap.tc.moin.repository.jmigenerator.wrappers.JmiGeneratorClassWrapper;

/**
 * The Class proxy interface
 */
public class JmiGeneratorClassProxyInterfaceTemplateImpl extends JmiGeneratorBaseTemplateImpl implements JmiGeneratorClassProxyInterfaceTemplate {

    protected final JmiGeneratorClassWrapper myClassWrapper;

    /**
     * @param wrapper
     */
    public JmiGeneratorClassProxyInterfaceTemplateImpl( JmiGeneratorClassWrapper wrapper ) {

        super( wrapper, JmiGenerationKind.INTERFACE );
        this.myClassWrapper = wrapper;
    }

    @Override
    public String getJavaName( ) {

        return this.myClassWrapper.getJavaProxyClassName( this.genKind, false );
    }

    public JmiGeneratorDescriptorConstant getClassExtentDescriptorConstant( ) {

        return this.myClassWrapper.getClassExtentDescriptorConstant( );
    }

    public List<JmiGeneratorClassOperation> getConstructors( ) {

        return this.myClassWrapper.getClassConstructors( this.genKind );
    }

    @Override
    public List<String> getExtends( ) {

        return this.myClassWrapper.getExtends( this.genKind, true, true );
    }

    public List<JmiGeneratorClassOperation> getAttributeOperations( ) {

        return this.myClassWrapper.getAttributeOperations( this.genKind, true );
    }

    public List<JmiGeneratorClassOperation> getOperations( ) {

        return this.myClassWrapper.getOperations( this.genKind, true );
    }

    public List<JmiGeneratorClassOperation> getStructureTypes( ) {

        return this.myClassWrapper.getStructureTypes( this.genKind );
    }

    public boolean isInterface( ) {

        return true;
    }
}
