/*
 * Created on 12.02.2006
 */
package com.sap.tc.moin.repository.mql;

/**
 * Compares a boolean-typed attribute for being true or false.
 */
final public class WhereBool extends WhereComparator {

    /*
     * Comparison value
     */
    private boolean boolValue;

    /**
     * Predicate returns true if the boolValue equals the attribute value. If
     * the multiplicity <> 1, then the predicate is true whenever the equality
     * holds for one or more elements in the collection.
     * 
     * @param _attrName the attribute name for the comparison
     * @param _boolValue the bool value to be compared with
     */
    public WhereBool( String _attrName, boolean _boolValue ) {

        this.attrName = _attrName;
        this.boolValue = _boolValue;
        this.operation = Operation.EQUAL;
    }

    /**
     * Returns the value to which the boolean-typed attribute is compared.
     * 
     * @return the bool value to be compared with
     */
    public boolean getBoolValue( ) {

        return this.boolValue;
    }

    @Override
    protected void toString( StringBuilder sb, int indent ) {

        super.toString( sb, indent );
        sb.append( this.boolValue );
    }

}
