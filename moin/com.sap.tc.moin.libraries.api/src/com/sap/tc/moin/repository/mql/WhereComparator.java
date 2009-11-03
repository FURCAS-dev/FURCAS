/*
 * Created on 10.02.2006
 */
package com.sap.tc.moin.repository.mql;

/**
 * A where-comparator embodies comparisons as they may occur in a where-entry.
 * Such a comparator always refers to an attribute and has a defined comparison
 * operation.
 */
abstract public class WhereComparator extends WhereClause {

    /*
     * The attribute on the left of the comparison.
     */
    protected String attrName;

    /*
     * The comparison operation
     */
    protected Operation operation;

    /**
     * Return the attribute name of the left operand of the operation.
     * 
     * @return the attribute name of the left operand of the operation.
     */
    public String getAttrName( ) {

        return this.attrName;
    }

    /**
     * Return the comparison operation.
     * 
     * @return the comparison operation.
     */
    public Operation getOperation( ) {

        return this.operation;
    }

    @Override
    protected void toString( StringBuilder sb, int indent ) {

        sb.append( this.attrName );
        sb.append( " " ); //$NON-NLS-1$
        sb.append( this.operation.toString( ) );
        sb.append( " " ); //$NON-NLS-1$
    }
}
