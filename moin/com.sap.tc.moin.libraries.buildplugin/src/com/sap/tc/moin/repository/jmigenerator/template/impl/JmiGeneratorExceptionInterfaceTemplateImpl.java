package com.sap.tc.moin.repository.jmigenerator.template.impl;

import java.util.List;

import com.sap.tc.moin.repository.jmigenerator.JmiGenerationKind;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorClassOperation;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorExceptionInterfaceTemplate;
import com.sap.tc.moin.repository.jmigenerator.wrappers.JmiGeneratorExceptionWrapper;

/**
 * The Exception interface
 */
public class JmiGeneratorExceptionInterfaceTemplateImpl extends JmiGeneratorBaseTemplateImpl implements JmiGeneratorExceptionInterfaceTemplate {

    private final JmiGeneratorExceptionWrapper myExceptionWrapper;

    /**
     * @param wrapper
     */
    public JmiGeneratorExceptionInterfaceTemplateImpl( JmiGeneratorExceptionWrapper wrapper ) {

        super( wrapper, JmiGenerationKind.INTERFACE );
        this.myExceptionWrapper = wrapper;
    }

    public List<JmiGeneratorClassOperation> getParameters( ) {

        return this.myExceptionWrapper.getParameters( this.genKind );
    }

    public boolean isInterface( ) {

        return false;
    }

}
