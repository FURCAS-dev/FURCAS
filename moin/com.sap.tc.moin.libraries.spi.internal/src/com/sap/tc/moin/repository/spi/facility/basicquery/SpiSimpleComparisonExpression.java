package com.sap.tc.moin.repository.spi.facility.basicquery;

import com.sap.tc.moin.repository.spi.facility.fql.SpiFqlComparisonOperation;
import com.sap.tc.moin.repository.spi.facility.fql.SpiFqlPrimitiveType;

/**
 * Implements attribute comparisons with simple values.
 */
@Deprecated
public class SpiSimpleComparisonExpression extends SpiLeafExpression {

    private SpiFqlComparisonOperation operator;

    private Object value;

    /**
     * Constructor takes the attribute id and the attribute value.
     * <p>
     * LIMITATION: all strings returned by the facility should cut off any
     * trailing blanks as this is the standard behaviour from OpenSQL (which is
     * the driving implementation) of BQL. All string objects inserted in a
     * comparison are guaranteed to not have any trailing blanks themselves.
     */
    public SpiSimpleComparisonExpression( String anId, SpiFqlPrimitiveType attributeValueType, SpiFqlComparisonOperation operator, Object aValue ) {

        super( anId, attributeValueType );
        this.operator = operator;
        this.value = aValue;
    }

    /**
     * Gets the value
     */
    public Object getValue( ) {

        return this.value;
    }

    /**
     * Gets the SimpleComparisonOperator
     */
    public SpiFqlComparisonOperation getOperator( ) {

        return this.operator;
    }

    /**
     *
     */
    public void toString( StringBuffer sb, int ident, boolean newline ) {

        if ( newline ) {
            SpiUtils.toStringNewLine( sb, ident );
        }
        sb.append( SpiUtils.OPENING_PARENTHESES );
        sb.append( this.getAttributeId( ) );
        sb.append( SpiUtils.simpleComparisonOperatorToString( this.operator ) );
        sb.append( this.getAttributeValueForPrinting( this.value ) );
        sb.append( SpiUtils.CLOSING_PARENTHESES );
    }
}