/*
 * Created on 10.02.2006
 */
package com.sap.tc.moin.repository.mql;

/**
 * A not where clause negates the boolean of its nested-clause.
 */
final public class WhereNot extends WhereClause {

    /*
     * The nested clause of the not-expression
     */
    private WhereClause nestedClause;

    /**
     * This where-clause negates its nested where-clause.
     * 
     * @param _nestedClause the nested clause.
     */
    public WhereNot( WhereClause _nestedClause ) {

        this.nestedClause = _nestedClause;
    }

    /**
     * Returns the nested where-clause of this negating where-clause.
     * 
     * @return the nested where-clause of this negating where-clause.
     */
    public WhereClause getNestedClause( ) {

        return this.nestedClause;
    }

    @Override
    protected void toString( StringBuilder sb, int indent ) {

        sb.append( "not (" ); //$NON-NLS-1$
        this.nestedClause.toString( sb, indent );
        sb.append( ")" ); //$NON-NLS-1$
    }

}
