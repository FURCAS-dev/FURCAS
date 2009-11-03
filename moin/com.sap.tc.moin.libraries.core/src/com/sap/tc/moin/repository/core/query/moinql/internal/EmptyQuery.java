package com.sap.tc.moin.repository.core.query.moinql.internal;

import java.util.List;

import com.sap.tc.moin.repository.core.query.moinql.shared.MQLAuxServices;

/**
 * The empty query represents a query which has been optimized away, i.e. it was
 * statically determined that no elements would satisfy the query (typically
 * caused by incompatible scopes).
 */
final public class EmptyQuery extends InternalQuery {

    private List<SelectEntry> selectEntries;

    public EmptyQuery( AliasName _aliasName, List<SelectEntry> _selectEntries ) {

        this.selectEntries = _selectEntries;
        this.aliasName = _aliasName;
    }

    public List<SelectEntry> getSelectEntries( ) {

        return this.selectEntries;
    }

    public void setSelectEntries( List<SelectEntry> selectEntries ) {

        this.selectEntries = selectEntries;
    }

    public boolean isEmpty( ) {

        return true;
    }

    /*
     * Pretty-printing
     */
    @Override
    public String toString( int indent, StringBuilder accumSb ) {

        StringBuilder sb = new StringBuilder( );

        // end of select query
        sb.append( MQLAuxServices.EMPTY_T + MQLAuxServices.SPACE_T + MQLAuxServices.AS_T + MQLAuxServices.SPACE_T );

        // show the alias
        sb.append( getAliasName( ).toString( ) );

        // finalize
        accumSb.append( sb );

        return sb.toString( );
    }

}
