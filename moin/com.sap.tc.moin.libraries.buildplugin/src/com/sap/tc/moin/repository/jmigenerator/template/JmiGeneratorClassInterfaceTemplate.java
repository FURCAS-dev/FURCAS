package com.sap.tc.moin.repository.jmigenerator.template;

import java.util.List;

/**
 * The class interface template
 */
public interface JmiGeneratorClassInterfaceTemplate extends JmiGeneratorInterfaceTemplate {

    /**
     * @return the constants defined by this class
     */
    public List<JmiGeneratorConstant> getConstants( );

    /**
     * @return the attributes
     */
    public List<JmiGeneratorClassOperation> getAttributeOperations( );

    /**
     * @return the references
     */
    public List<JmiGeneratorClassOperation> getReferenceOperations( );

    /**
     * @return the operations
     */
    public List<JmiGeneratorClassOperation> getOperations( );

    public JmiGeneratorDescriptorConstant getClassExtentDescriptorConstant( );

    public String getDescriptorsBody( );
}
