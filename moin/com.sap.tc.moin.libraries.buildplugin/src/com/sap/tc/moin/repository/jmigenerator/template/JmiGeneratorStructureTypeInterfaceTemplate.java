package com.sap.tc.moin.repository.jmigenerator.template;

import java.util.List;

/**
 * The StructureType interface template
 */
public interface JmiGeneratorStructureTypeInterfaceTemplate extends JmiGeneratorInterfaceTemplate {

    /**
     * @return the fields
     */
    public List<JmiGeneratorClassOperation> getFields( );

    public String getDescriptorsBody( );
}
