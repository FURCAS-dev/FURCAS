/**
 * 
 */
package com.sap.tc.moin.repository.core.query.moinql.internal;

import com.sap.tc.moin.repository.core.query.moinql.shared.MQLAuxServices;
import com.sap.tc.moin.repository.spi.facility.fql.SpiFqlQueryResultSet;

/**
 * A nested query is a query used in a links predicate. It refers to an internal
 * query, indicates whether the nested query can be computed in one go with the
 * encompassing query, and keeps possibly a result set. The latter may be set
 * during interpretation.
 */
final public class NestedQuery {

    private InternalQuery internalQuery;

    // this flag is used to indicate if the nested query should be evaluated by itself or be considered part of the larger
    // query that contains it
    private boolean reset;

    private SpiFqlQueryResultSet resultSet = null;

    public NestedQuery( InternalQuery _internalQuery ) {

        this.internalQuery = _internalQuery;
        this.reset = true;
    }

    public InternalQuery getInternalQuery( ) {

        return this.internalQuery;
    }

    public boolean isReset( ) {

        return this.reset;
    }

    public SpiFqlQueryResultSet getResultSet( ) {

        return this.resultSet;
    }

    public void setInternalQuery( InternalQuery internalQuery ) {

        this.internalQuery = internalQuery;
    }

    public void setReset( boolean reset ) {

        this.reset = reset;
    }

    public void setResultSet( SpiFqlQueryResultSet resultSet ) {

        this.resultSet = resultSet;
    }

    /*
     * Pretty-printing
     */
    public String toString( int indent, StringBuilder accumSb ) {

        StringBuilder sb = new StringBuilder( );

        String resetStr = ( this.reset ? MQLAuxServices.RESET_T + MQLAuxServices.SPACE_T : MQLAuxServices.EMPTYSTR );

        sb.append( resetStr );

        this.internalQuery.toString( indent + resetStr.length( ), accumSb );

        accumSb.append( sb );

        return sb.toString( );
    }

    @Override
    public String toString( ) {

        return toString( 0, new StringBuilder( ) );
    }
}
