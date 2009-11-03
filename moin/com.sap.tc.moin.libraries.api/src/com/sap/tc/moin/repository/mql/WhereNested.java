/*
 * Created on 10.02.2006
 */
package com.sap.tc.moin.repository.mql;

/**
 * A nested where-entry defines a where-entry which constrains an alias by
 * connecting it via an association to the results of a nested query. Nested
 * where-entries can be negated.
 */
abstract public class WhereNested extends JoinWhereEntry {

    /*
     * By default, a nested where entry predicate is not negated
     */
    protected boolean not = false;

    /**
     * Returns whether this nested where entry was negated.
     * 
     * @return true if the nested where entry is negated
     */
    public boolean isNot( ) {

        return this.not;
    }

    /*
     * A nested where entry needs a nested query
     */
    protected MQLQuery nestedQuery;

    /**
     * Returns the nested query used in this nested where-constraint.
     * 
     * @return the nested query used in this nested where-constraint.
     */
    public MQLQuery getNestedQuery( ) {

        return this.nestedQuery;
    }
}
