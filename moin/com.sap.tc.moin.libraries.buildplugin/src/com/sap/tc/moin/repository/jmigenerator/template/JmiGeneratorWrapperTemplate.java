package com.sap.tc.moin.repository.jmigenerator.template;

import java.util.List;

/**
 * The Wrapper base template
 */
public interface JmiGeneratorWrapperTemplate extends JmiGeneratorImplTemplate {

    /**
     * @return the implementation template
     */
    public JmiGeneratorBaseTemplate getImplementation( );

    /**
     * @return the internal modeled operations
     */
    public List<JmiGeneratorClassOperation> getInternalModeledOperations( );

    /**
     * @return the operations
     */
    public List<JmiGeneratorClassOperation> getOperations( );

    /**
     * @return the operation IDs
     */
    public List<String> getOperationIds( );

    public String getMetaObjectToString( );
}
