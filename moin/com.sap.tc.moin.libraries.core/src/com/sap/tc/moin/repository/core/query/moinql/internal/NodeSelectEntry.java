package com.sap.tc.moin.repository.core.query.moinql.internal;

import com.sap.tc.moin.repository.core.query.messages.MQLBugMessages;
import com.sap.tc.moin.repository.core.query.moinql.shared.MQLBugException;
import com.sap.tc.moin.repository.mql.MQLColumnType;

/**
 * A node select entry represents a selection on a node query.
 */
final public class NodeSelectEntry extends SelectEntry {

    private VirtualAtomicEntryReference virtualAtomicEntryReference;

    private NodeQuery owningQuery;

    public NodeSelectEntry( VirtualAtomicEntryReference _virtualAtomicEntryReference ) {

        this.virtualAtomicEntryReference = _virtualAtomicEntryReference;
    }

    @Override
    public AliasName getTopAlias( ) {

        if ( this.owningQuery == null ) {
            throw new MQLBugException( MQLBugMessages.TOP_ALIAS_NOT_SET_FOR_NODESELECTENTRY );
        } else {
            return this.owningQuery.getAliasName( );
        }
    }

    @Override
    public TypeReference getTypeReference( ) {

        return this.virtualAtomicEntryReference;
    }

    @Override
    public MQLColumnType getColumnType( ) {

        return this.virtualAtomicEntryReference.getNestedSelectEntry( ).getColumnType( );
    }

    @Override
    public LeafSelectEntry getLeafSelectEntry( ) {

        SelectEntry nestedSelectEntry = getVirtualAtomicEntryReference( ).getNestedSelectEntry( );
        return nestedSelectEntry.getLeafSelectEntry( );
    }

    @Override
    public NodeQuery getOwningQuery( ) {

        return this.owningQuery;
    }

    public void setOwningQuery( NodeQuery owningQuery ) {

        this.owningQuery = owningQuery;
    }

    public VirtualAtomicEntryReference getVirtualAtomicEntryReference( ) {

        return this.virtualAtomicEntryReference;
    }

    public void setVirtualAtomicEntryReference( VirtualAtomicEntryReference virtualAtomicEntryReference ) {

        this.virtualAtomicEntryReference = virtualAtomicEntryReference;
    }

    /*
     * Pretty-printing
     */
    @Override
    public String toString( int indent, StringBuilder accumSb ) {

        return this.virtualAtomicEntryReference.toString( indent, accumSb );
    }
}
