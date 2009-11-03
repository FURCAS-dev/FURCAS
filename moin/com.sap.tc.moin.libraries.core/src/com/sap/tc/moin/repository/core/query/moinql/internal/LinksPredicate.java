/*
 * Created on 16.02.2006
 */
package com.sap.tc.moin.repository.core.query.moinql.internal;

import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.core.query.messages.MQLBugMessages;
import com.sap.tc.moin.repository.core.query.moinql.shared.MQLAuxServices;
import com.sap.tc.moin.repository.core.query.moinql.shared.MQLBugException;
import com.sap.tc.moin.repository.spi.facility.fql.SpiFqlAssociationCategory;
import com.sap.tc.moin.repository.spi.facility.fql.SpiFqlAssociationViaNestedQueryConstraint;
import com.sap.tc.moin.repository.spi.facility.fql.SpiFqlQuery;
import com.sap.tc.moin.repository.spi.facility.fql.SpiFqlQueryResultSet;

/**
 * A LinksPredicate expresses that a model element is linked to the results of a
 * nested query via a provided association.
 */
final public class LinksPredicate extends AssociationWithEntry implements SpiFqlAssociationViaNestedQueryConstraint {

    private NestedQuery nestedQuery;

    private boolean not;

    public LinksPredicate( boolean _not, MRI _assocMRI, SpiFqlAssociationCategory _assocCategory, String _assocName, int _toAssocEnd, boolean _toStored, String _toAssocEndName, AtomicEntryReference _fromType, boolean _fromStored, int _fromAssocEnd, String _fromAssocEndName,
        InternalQuery _nestedQuery ) {

        this.not = _not;
        this.assocMRI = _assocMRI;
        this.assocCategory = _assocCategory;
        this.assocName = _assocName;
        this.toAssocEnd = _toAssocEnd;
        this.toAssocEndName = _toAssocEndName;
        this.fromType = _fromType;
        this.nestedQuery = new NestedQuery( _nestedQuery );
        this.toStorage = _toStored;
        this.fromStorage = _fromStored;
        this.fromAssocEnd = _fromAssocEnd;
        this.fromAssocEndName = _fromAssocEndName;
    }

    public NestedQuery getNestedQuery( ) {

        return this.nestedQuery;
    }

    public boolean isNegated( ) {

        return this.not;
    }

    public void setNestedQuery( NestedQuery nestedQuery ) {

        this.nestedQuery = nestedQuery;
    }

    public void setNot( boolean not ) {

        this.not = not;
    }

    /*
     * Pretty-printing
     */
    @Override
    public String toString( int indent, StringBuilder accumSb ) {

        StringBuilder sb = new StringBuilder( );

        String notStr = ( this.not ? MQLAuxServices.NOT_T + MQLAuxServices.SPACE_T : MQLAuxServices.EMPTYSTR );
        String storedSt = ( this.toStorage ? MQLAuxServices.STORAGE_T : MQLAuxServices.EMPTYSTR );
        String linkedToStoredSt = ( this.fromStorage ? MQLAuxServices.STORAGE_T : MQLAuxServices.EMPTYSTR );
        String resetStr = ( this.nestedQuery.isReset( ) ? MQLAuxServices.RESET_T + MQLAuxServices.SPACE_T : MQLAuxServices.EMPTYSTR );

        this.fromType.toString( indent, sb );
        sb.append( MQLAuxServices.DOT_T + this.toAssocEndName );
        sb.append( MQLAuxServices.OPENBRACKET_T + linkedToStoredSt + MQLAuxServices.SPACE_T + this.assocName + MQLAuxServices.SPACE_T + storedSt + MQLAuxServices.CLOSEBRACKET_T );
        sb.append( MQLAuxServices.SPACE_T + notStr + MQLAuxServices.IN_T + MQLAuxServices.SPACE_T + resetStr );

        int newIndent = indent + 3;
        sb.append( MQLAuxServices.newLine( newIndent ) );
        this.nestedQuery.getInternalQuery( ).toString( newIndent, sb );

        // finalize
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

    public NestedQueryOrResult getNestedQueryOrResult( ) {

        final NestedQuery nested = this.getNestedQuery( );

        if ( !nested.isReset( ) ) {
            // without a reset, we should have a nested leaf query
            return new NestedFqlQuery( ) {

                public SpiFqlQuery getNestedFqlQuery( ) {

                    InternalQuery internalQuery = nested.getInternalQuery( );
                    if ( internalQuery instanceof LeafQuery ) {
                        return (LeafQuery) internalQuery;
                    } else {
                        throw new MQLBugException( MQLBugMessages.FOUND_NON_LEAF_QUERY_IN_FQL );
                    }
                }
            };
        } else {
            // with a reset, we should have a sub result
            return new NestedResult( ) {

                @SuppressWarnings( "null" )
                public MRI[] getNestedResults( ) {

                    SpiFqlQueryResultSet resultSet = nested.getResultSet( );
                    // unwrap the nested result set
                    int resultSetSize = ( resultSet == null ? 0 : resultSet.getSize( ) );
                    MRI[] MRIs = new MRI[resultSetSize];
                    for ( int i = 0; i < resultSetSize; i++ ) {
                        MRIs[i] = resultSet.getMri( i, 0 );
                    }
                    return MRIs;
                }
            };
        }
    }

}
