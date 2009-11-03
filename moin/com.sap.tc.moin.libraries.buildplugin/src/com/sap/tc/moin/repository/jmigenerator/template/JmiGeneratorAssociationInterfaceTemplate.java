package com.sap.tc.moin.repository.jmigenerator.template;

import java.util.List;

/**
 * The Association interface template
 */
public interface JmiGeneratorAssociationInterfaceTemplate extends JmiGeneratorInterfaceTemplate {

    /**
     * @return the constant for the association extent descriptor
     */
    public JmiGeneratorDescriptorConstant getAssociationExtentDescriptorConstant( );

    /**
     * @return the operations
     */
    public List<JmiGeneratorClassOperation> getOperations( );

}
