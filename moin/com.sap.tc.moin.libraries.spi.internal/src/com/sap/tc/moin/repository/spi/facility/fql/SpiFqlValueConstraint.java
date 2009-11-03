package com.sap.tc.moin.repository.spi.facility.fql;

/**
 * An FqlValueConstraint constrains the attribute value of the query entry and
 * has two forms as indicated by its subtypes.
 * 
 * @author D045917
 */
public interface SpiFqlValueConstraint extends SpiFqlLocalConstraint {

    /**
     * The attribute name of the constraint
     */
    String getAttrName( );

    /**
     * Indicates whether the attribute is multi-valued
     */
    boolean isMultiValued( );

    /**
     * The primitive type of the attribute
     */
    SpiFqlPrimitiveType getAttrType( );
}
