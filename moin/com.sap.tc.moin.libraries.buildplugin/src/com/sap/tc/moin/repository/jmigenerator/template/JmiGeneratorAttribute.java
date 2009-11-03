package com.sap.tc.moin.repository.jmigenerator.template;

/**
 * The Attribute abstraction
 */
public interface JmiGeneratorAttribute {

    /**
     * Derived attributes are never persisted
     * 
     * @return <code>true</code> if the attribute is derived
     */
    public Boolean isDerived( );

    /**
     * @return the variable name to which this attribute relates
     */
    public String getVariableName( );

}
