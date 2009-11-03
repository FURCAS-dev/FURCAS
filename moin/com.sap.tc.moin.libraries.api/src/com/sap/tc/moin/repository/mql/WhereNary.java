/*
 * Created on 10.02.2006
 */
package com.sap.tc.moin.repository.mql;

/**
 * A where n-ary operation can be used in a where-entry and embodies boolean AND
 * and OR with multiple operands.
 */
abstract public class WhereNary extends WhereClause {

    /*
     * This list contains the operands of the nested clause
     */
    protected WhereClause[] nestedClauses;

    /**
     * Return the operands of this n-ary operation.
     * 
     * @return the operands of this n-ary operation.
     */
    public WhereClause[] getNestedClauses( ) {

        return this.nestedClauses;
    }
}
