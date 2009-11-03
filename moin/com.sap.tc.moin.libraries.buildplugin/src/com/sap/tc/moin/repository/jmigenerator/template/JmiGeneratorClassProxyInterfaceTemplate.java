package com.sap.tc.moin.repository.jmigenerator.template;

import java.util.List;

/**
 * The class proxy interface template
 */
public interface JmiGeneratorClassProxyInterfaceTemplate extends JmiGeneratorInterfaceTemplate {

    /**
     * @return the constant for the class extent descriptor
     */
    public JmiGeneratorDescriptorConstant getClassExtentDescriptorConstant( );

    /**
     * @return the constructors
     */
    public List<JmiGeneratorClassOperation> getConstructors( );

    /**
     * @return the attributes
     */
    public List<JmiGeneratorClassOperation> getAttributeOperations( );

    /**
     * @return the operations
     */
    public List<JmiGeneratorClassOperation> getOperations( );

    /**
     * @return the structure types
     */
    public List<JmiGeneratorClassOperation> getStructureTypes( );

}
