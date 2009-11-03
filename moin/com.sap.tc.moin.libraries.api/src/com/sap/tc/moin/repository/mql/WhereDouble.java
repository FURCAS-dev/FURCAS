/*
 * Created on 12.02.2006
 */
package com.sap.tc.moin.repository.mql;

/**
 * Compares a double value with one of the possible operations.
 */
final public class WhereDouble extends WhereComparator {

    /*
     * Comparison value
     */
    private double doubleValue;

    /**
     * The predicate is true if the doubleValue compares to the attribute value
     * in a way determined by the operation. If the multiplicity <> 1, then the
     * predicate is true whenever the comparison holds for one or more elements
     * from the collection. The operation LIKE is not permitted.
     * 
     * @param _attrName the attribute name.
     * @param _operation the operation.
     * @param _doubleValue the double value.
     */
    public WhereDouble( String _attrName, Operation _operation, double _doubleValue ) {

        this.operation = _operation;
        this.attrName = _attrName;
        this.doubleValue = _doubleValue;
    }

    /**
     * Returns the value to which the double-typed attribute is compared.
     * 
     * @return the value to which the double-typed attribute is compared.
     */
    public double getDoubleValue( ) {

        return this.doubleValue;
    }

    @Override
    protected void toString( StringBuilder sb, int indent ) {

        super.toString( sb, indent );
        sb.append( this.doubleValue );
    }

}
