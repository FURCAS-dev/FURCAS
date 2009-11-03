/*
 * Created on 20.02.2006
 */
package com.sap.tc.moin.repository.core.query.moinql.internal;

import java.util.List;

import com.sap.tc.moin.repository.core.query.messages.MQLBugMessages;
import com.sap.tc.moin.repository.core.query.moinql.shared.MQLAuxServices;
import com.sap.tc.moin.repository.core.query.moinql.shared.MQLBugException;

/**
 * A ResultUnion is simply the union over the result sets of its operands. It is
 * required that the operands have type-compatible select entries.
 */
final public class ResultUnion extends InternalQuery {

    private List<InternalQuery> operands;

    public ResultUnion( AliasName _aliasName, List<InternalQuery> _operands ) {

        this.aliasName = _aliasName;
        if ( _operands == null || _operands.size( ) < 2 ) {
            throw new MQLBugException( MQLBugMessages.RESULT_UNION_EXPECTS_AT_LEAST_TWO_OPERANDS );
        }
        this.operands = _operands;
    }

    public boolean isEmpty( ) {

        return false;
    }

    public List<InternalQuery> getOperands( ) {

        return this.operands;
    }

    public void setOperands( List<InternalQuery> operands ) {

        if ( operands == null || operands.size( ) < 2 ) {
            throw new MQLBugException( MQLBugMessages.RESULT_UNION_EXPECTS_AT_LEAST_TWO_OPERANDS );
        }
        this.operands = operands;
    }

    /*
     * Pretty-printing
     */
    @Override
    public String toString( int indent, StringBuilder accumSb ) {

        StringBuilder sb = new StringBuilder( );

        sb.append( MQLAuxServices.OPENPAREN_T );

        this.operands.get( 0 ).toString( indent + 1, sb );
        for ( int i = 1; i < this.operands.size( ); i++ ) {
            sb.append( MQLAuxServices.newLine( indent + 1 ) + MQLAuxServices.UNION_T + MQLAuxServices.newLine( indent + 1 ) );
            this.operands.get( i ).toString( indent + 1, sb );
        }

        sb.append( MQLAuxServices.CLOSEPAREN_T + MQLAuxServices.SPACE_T + MQLAuxServices.AS_T + MQLAuxServices.SPACE_T );
        sb.append( getAliasName( ).toString( ) );

        accumSb.append( sb );

        return sb.toString( );
    }

}
