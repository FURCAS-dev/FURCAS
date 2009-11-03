package com.sap.tc.moin.repository.jmigenerator.template;

/**
 * Attributes must be declared
 */
public interface JmiGeneratorAttributeDeclaration extends JmiGeneratorParameter {

    /**
     * @return the value for the attribute declaration
     */
    public String getValue( );

}
