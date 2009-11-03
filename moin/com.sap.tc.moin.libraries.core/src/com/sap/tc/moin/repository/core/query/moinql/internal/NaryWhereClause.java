/*
 * Created on 16.02.2006
 */
package com.sap.tc.moin.repository.core.query.moinql.internal;

import java.util.List;

import com.sap.tc.moin.repository.core.query.moinql.shared.MQLAuxServices;
import com.sap.tc.moin.repository.spi.facility.fql.SpiFqlConnectedConstraint;
import com.sap.tc.moin.repository.spi.facility.fql.SpiFqlLocalConstraint;

/**
 * Provides a logical connection between a set of where-clauses. The logical
 * connection is either conjunctive or disjunctive.
 */
final public class NaryWhereClause extends WhereClause implements SpiFqlConnectedConstraint {

    private boolean withOr;

    private List<WhereClause> nestedClauses;

    public NaryWhereClause( AtomicEntry _alias, boolean _withOr, List<WhereClause> _nestedClauses ) {

        this.atomicEntry = _alias;
        this.withOr = _withOr;
        this.nestedClauses = _nestedClauses;
    }

    public List<WhereClause> getNestedClauses( ) {

        return this.nestedClauses;
    }

    public boolean isOrConnected( ) {

        return this.withOr;
    }

    public void setNestedClauses( List<WhereClause> nestedClauses ) {

        this.nestedClauses = nestedClauses;
    }

    public void setWithOr( boolean withOr ) {

        this.withOr = withOr;
    }

    /*
     * Pretty-printing
     */
    @Override
    public String toString( int indent, StringBuilder accumSb ) {

        StringBuilder sb = new StringBuilder( );

        String connector = MQLAuxServices.EMPTYSTR;
        if ( this.withOr ) {
            connector = MQLAuxServices.OR_T;
        } else {
            connector = MQLAuxServices.AND_T;
        }

        if ( this.nestedClauses.size( ) < 2 ) {
            sb.append( ">>MQL Internal Format Error: less than 2 where-conditions for " + connector + "-clause <<" ); //$NON-NLS-1$ //$NON-NLS-2$
        } else {
            sb.append( MQLAuxServices.OPENPAREN_T );
            int newIndent = indent + 1;
            this.nestedClauses.get( 0 ).toString( newIndent, sb );
            for ( int i = 1; i < this.nestedClauses.size( ); i++ ) {
                sb.append( MQLAuxServices.CLOSEPAREN_T + MQLAuxServices.SPACE_T + connector + MQLAuxServices.newLine( indent ) + MQLAuxServices.OPENPAREN_T );
                this.nestedClauses.get( i ).toString( newIndent, sb );
            }
            sb.append( MQLAuxServices.CLOSEPAREN_T );
        }

        accumSb.append( sb );

        return sb.toString( );
    }

    @Override
    public String toString( ) {

        return toString( 0, new StringBuilder( ) );
    }

    /*
     * FQL
     */

    public SpiFqlLocalConstraint[] getNestedConstraint( ) {

        List<WhereClause> clauses = this.getNestedClauses( );
        return clauses.toArray( new SpiFqlLocalConstraint[clauses.size( )] );
    }

}
