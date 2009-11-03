/*
 * Created on 16.02.2006
 */
package com.sap.tc.moin.repository.mql;

/**
 * A where-relation defines a where-entry which constrains two aliases to be
 * involved in an association relation.
 */
abstract public class WhereRelation extends JoinWhereEntry {

    /*
     * A where relation always refers to an alias on its right-hand side as
     * well.
     */
    protected String rightAlias;

    /**
     * Returns the right-hand side alias of this with relation.
     * 
     * @return the right-hand side alias of this with relation.
     */
    public String getRightAlias( ) {

        return this.rightAlias;
    }
}
