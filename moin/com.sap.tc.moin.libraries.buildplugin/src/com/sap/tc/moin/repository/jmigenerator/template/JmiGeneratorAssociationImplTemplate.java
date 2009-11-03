package com.sap.tc.moin.repository.jmigenerator.template;

import java.util.List;

/**
 * The Association implementation template
 */
public interface JmiGeneratorAssociationImplTemplate extends JmiGeneratorImplTemplate {

    /**
     * @return the operations
     */
    public List<JmiGeneratorClassOperation> getOperations( );

    //    public String getEnd0Type();
    //
    //    public String getEnd1Type();

    /**
     * @return the Wrapper template
     */
    public JmiGeneratorBaseTemplate getWrapper( );
}
