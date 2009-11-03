package com.sap.tc.moin.repository.spi.facility.basicquery;

import com.sap.tc.moin.repository.spi.facility.fql.SpiFqlPrimitiveType;


/**
 * Implements the handling of a single attribute id
 */
@Deprecated
public abstract class SpiLeafExpression implements SpiAttributeExpression {

    private String attributeId;

    private SpiFqlPrimitiveType attributeValueType;

    /**
     * Constructs a leaf expression by the attribute id.
     */
    public SpiLeafExpression( String attributeId, SpiFqlPrimitiveType attributeValueType ) {

        this.attributeId = attributeId;
        this.attributeValueType = attributeValueType;
    }

    /**
     * Introspection
     */
    public String getAttributeId( ) {

        return this.attributeId;
    }

    public SpiFqlPrimitiveType getAttributeValueType( ) {

        return this.attributeValueType;
    }

    public String getAttributeValueForPrinting( Object value ) {

        return ( value == null ? "null" : value.toString( ) ); //$NON-NLS-1$
    }
}
