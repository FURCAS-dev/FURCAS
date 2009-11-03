package com.sap.tc.moin.repository.core.query.moinql.internal;

import com.sap.tc.moin.repository.core.query.messages.MQLBugMessages;
import com.sap.tc.moin.repository.core.query.moinql.engine.MQLSchedulerImpl;
import com.sap.tc.moin.repository.core.query.moinql.shared.MQLAuxServices;
import com.sap.tc.moin.repository.core.query.moinql.shared.MQLBugException;
import com.sap.tc.moin.repository.shared.logger.MoinCategoryEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLocationEnum;
import com.sap.tc.moin.repository.shared.logger.MoinLogger;
import com.sap.tc.moin.repository.shared.logger.MoinLoggerFactory;
import com.sap.tc.moin.repository.shared.logger.MoinSeverity;

/**
 * This reference refers to a select entry, which in itself refers again to a
 * TypeReference.
 */
public class VirtualAtomicEntryReference implements TypeReference {

    // trace setup
    private static final MoinLogger logger = MoinLoggerFactory.getLogger( MoinCategoryEnum.MOIN_CORE, MoinLocationEnum.MOIN_QUERY_MQL, MQLSchedulerImpl.class );

    protected SelectEntry nestedSelectEntry;

    public VirtualAtomicEntryReference( SelectEntry _nestedSelectEntry ) {

        this.nestedSelectEntry = _nestedSelectEntry;
    }

    public SelectEntry getNestedSelectEntry( ) {

        return this.nestedSelectEntry;
    }

    public AtomicEntry getAtomicEntry( ) {

        return getAtomicEntryReference( ).getAtomicEntry( );
    }

    public AtomicEntryReference getAtomicEntryReference( ) {

        TypeReference elRef = this.nestedSelectEntry.getTypeReference( );
        AtomicEntryReference result = null;
        if ( elRef instanceof VirtualAtomicEntryReference ) {
            result = ( (VirtualAtomicEntryReference) elRef ).getAtomicEntryReference( );
        } else if ( elRef instanceof AtomicEntryReference ) {
            result = ( (AtomicEntryReference) elRef );
        } else {
            throw new MQLBugException( MQLBugMessages.VIRTUAL_ATOMIC_ENTRY_REF_HAS_TO_REFER_TO_TYPE_REF );
        }
        return result;
    }

    public void setNestedSelectEntry( SelectEntry nestedSelectEntry ) {

        this.nestedSelectEntry = nestedSelectEntry;
    }

    /*
     * Redefine identity
     */
    @Override
    public boolean equals( Object otherReference ) {

        boolean result = false;
        if ( otherReference instanceof TypeReference ) {
            TypeReference otherTypeReference = (TypeReference) otherReference;
            result = getAtomicEntry( ).equals( otherTypeReference.getAtomicEntry( ) );
        }
        return result;
    }

    @Override
    public int hashCode( ) {

        return getAtomicEntry( ).hashCode( );
    }

    /*
     * Pretty-printing
     */
    public String toString( int indent, StringBuilder accumSb ) {

        StringBuilder sb = new StringBuilder( );

        if ( logger.isTraced( MoinSeverity.DEBUG ) ) {
            sb.append( this.nestedSelectEntry.getTopAlias( ) + MQLAuxServices.DOT_T );
        }
        this.nestedSelectEntry.toString( indent, sb );

        accumSb.append( sb );

        return sb.toString( );
    }

    @Override
    public String toString( ) {

        return toString( 0, new StringBuilder( ) );
    }
}
