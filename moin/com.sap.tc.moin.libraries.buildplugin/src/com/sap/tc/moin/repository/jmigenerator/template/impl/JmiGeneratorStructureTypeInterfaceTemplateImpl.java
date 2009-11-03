package com.sap.tc.moin.repository.jmigenerator.template.impl;

import java.util.List;

import com.sap.tc.moin.repository.jmigenerator.JmiGenerationKind;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorClassOperation;
import com.sap.tc.moin.repository.jmigenerator.template.JmiGeneratorStructureTypeInterfaceTemplate;
import com.sap.tc.moin.repository.jmigenerator.wrappers.JmiGeneratorStructureTypeWrapper;

/**
 * The Structure type interface
 */
public class JmiGeneratorStructureTypeInterfaceTemplateImpl extends JmiGeneratorBaseTemplateImpl implements JmiGeneratorStructureTypeInterfaceTemplate {

    private final JmiGeneratorStructureTypeWrapper myStructureTypeWrapper;

    /**
     * @param wrapper
     */
    public JmiGeneratorStructureTypeInterfaceTemplateImpl( JmiGeneratorStructureTypeWrapper wrapper ) {

        super( wrapper, JmiGenerationKind.INTERFACE );
        this.myStructureTypeWrapper = wrapper;
    }

    public List<JmiGeneratorClassOperation> getFields( ) {

        return this.myStructureTypeWrapper.getFields( this.genKind );
    }

    public String getDescriptorsBody( ) {

        return this.myStructureTypeWrapper.getDescriptorsBody( );
    }

    public boolean isInterface( ) {

        return true;
    }
}
