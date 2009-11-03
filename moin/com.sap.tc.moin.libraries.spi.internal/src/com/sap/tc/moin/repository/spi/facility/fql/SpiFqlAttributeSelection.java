package com.sap.tc.moin.repository.spi.facility.fql;


/**
 * An attribute selection belongs to a selection and indicates an additionally
 * retrieved attribute.
 * 
 * @author D045917
 */
public interface SpiFqlAttributeSelection {

    /**
     * The name of the retrieved attribute
     */
    String getAttributeName( );

    /**
     * Indicates whether the attribute is multi-valued
     */
    boolean isMultiValued( );

    /**
     * The primitive type of the retrieved attribute
     */
    SpiFqlPrimitiveType getPrimitiveType( );

}
