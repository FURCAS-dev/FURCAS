package com.sap.tc.moin.repository.jmigenerator.template;

import java.util.List;

/**
 * The Exception interface template
 */
public interface JmiGeneratorExceptionInterfaceTemplate extends JmiGeneratorInterfaceTemplate {

    /**
     * @return the parameters
     */
    List<JmiGeneratorClassOperation> getParameters( );
}
