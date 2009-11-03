/*
 * Created on 16.02.2006
 */
package com.sap.tc.moin.repository.core.query.moinql.internal;

import com.sap.tc.moin.repository.core.query.moinql.shared.MQLAuxServices;
import com.sap.tc.moin.repository.spi.facility.fql.SpiFqlComparisonOperation;
import com.sap.tc.moin.repository.spi.facility.fql.SpiFqlNumericConstraint;
import com.sap.tc.moin.repository.spi.facility.fql.SpiFqlPrimitiveType;

/**
 * Compares the attribute value with the operand value.
 */
final public class NumericComparison extends ConstantComparison implements SpiFqlNumericConstraint {

    private SpiFqlComparisonOperation operation;

    private Object operandValue;

    public NumericComparison( AtomicEntry _alias, String _attrName, SpiFqlPrimitiveType _attrType, boolean _isMultiValued, SpiFqlComparisonOperation _operation, Object _operand ) {

        this.atomicEntry = _alias;
        this.attrName = _attrName;
        this.operation = _operation;
        this.operandValue = _operand;
        this.isMultiValued = _isMultiValued;
        this.attrType = _attrType;
    }

    public Object getOperandValue( ) {

        return this.operandValue;
    }

    public SpiFqlComparisonOperation getOperation( ) {

        return this.operation;
    }

    public void setOperandValue( Object operand ) {

        this.operandValue = operand;
    }

    public void setOperation( SpiFqlComparisonOperation operation ) {

        this.operation = operation;
    }

    /*
     * Pretty-printing
     */
    @Override
    public String toString( int indent, StringBuilder accumSb ) {

        StringBuilder sb = new StringBuilder( );

        sb.append( this.attrName + MQLAuxServices.OPENPAREN_T + this.attrType.toString( ) + MQLAuxServices.CLOSEPAREN_T );

        if ( this.isMultiValued ) {
            sb.append( MQLAuxServices.OPENPAREN_T + MQLAuxServices.ISMULTIVALUED_T + MQLAuxServices.CLOSEPAREN_T );
        }

        sb.append( MQLAuxServices.SPACE_T );

        if ( this.attrType.equals( SpiFqlPrimitiveType.BOOLEAN ) && this.operandValue != null ) {
            String booleanOperator = ( (Boolean) this.operandValue ? "isTrue" : "isFalse" ); //$NON-NLS-1$ //$NON-NLS-2$
            sb.append( booleanOperator );
        } else {

            switch ( this.operation ) {
                case EQUAL:
                    sb.append( MQLAuxServices.EQUAL_T );
                    break;
                case GREATER:
                    sb.append( MQLAuxServices.GREATER_T );
                    break;
                case GREATER_OR_EQUAL:
                    sb.append( MQLAuxServices.GREATEREQUAL_T );
                    break;
                case LESS:
                    sb.append( MQLAuxServices.LESS_T );
                    break;
                case LESS_OR_EQUAL:
                    sb.append( MQLAuxServices.LESSEQUAL_T );
                    break;
                case NOT_EQUAL:
                    sb.append( MQLAuxServices.NOTEQUAL_T );
                    break;
            }

            if ( this.operandValue == null ) {
                sb.append( MQLAuxServices.SPACE_T + "null" ); //$NON-NLS-1$
            } else if ( this.operandValue instanceof String ) {
                sb.append( MQLAuxServices.OPENQUOTE_T + this.operandValue.toString( ) + MQLAuxServices.CLOSEQUOTE_T );
            } else {
                sb.append( MQLAuxServices.SPACE_T + this.operandValue.toString( ) );
            }

        }

        accumSb.append( sb );

        return sb.toString( );
    }

    @Override
    public String toString( ) {

        return toString( 0, new StringBuilder( ) );
    }

}
