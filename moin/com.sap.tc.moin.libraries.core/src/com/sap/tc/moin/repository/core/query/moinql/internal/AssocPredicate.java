/*
 * Created on 16.02.2006
 */
package com.sap.tc.moin.repository.core.query.moinql.internal;

import com.sap.tc.moin.repository.MRI;
import com.sap.tc.moin.repository.core.query.moinql.shared.MQLAuxServices;
import com.sap.tc.moin.repository.spi.facility.fql.SpiFqlAssociationCategory;
import com.sap.tc.moin.repository.spi.facility.fql.SpiFqlAssociationViaEntriesConstraint;
import com.sap.tc.moin.repository.spi.facility.fql.SpiFqlQueryEntry;

/**
 * An AssocPredicate expresses a join constraint which compares if two model
 * elements exist in an association.
 */
final public class AssocPredicate extends AssociationWithEntry implements SpiFqlAssociationViaEntriesConstraint {

    private AtomicEntryReference toType;

    public AssocPredicate( MRI _assocMRI, SpiFqlAssociationCategory _assocCategory, String _assocName, int _leftAssocEnd, boolean _leftStorage, String _leftAssocEndName, int _rightAssocEnd, boolean _rightStorage, String _rightAssocEndName, AtomicEntryReference _leftType,
        AtomicEntryReference _rightType ) {

        this.assocMRI = _assocMRI;
        this.assocCategory = _assocCategory;
        this.assocName = _assocName;
        this.fromAssocEnd = _leftAssocEnd;
        this.fromAssocEndName = _leftAssocEndName;
        this.toAssocEnd = _rightAssocEnd;
        this.toAssocEndName = _rightAssocEndName;
        this.fromType = _leftType;
        this.toType = _rightType;
        this.fromStorage = _leftStorage;
        this.toStorage = _rightStorage;
    }

    public AtomicEntryReference getToType( ) {

        return this.toType;
    }

    public void setToType( AtomicEntryReference rightType ) {

        this.toType = rightType;
    }

    /*
     * Pretty-printing
     */
    @Override
    public String toString( int indent, StringBuilder accumSb ) {

        StringBuilder sb = new StringBuilder( );

        String leftSt = ( this.fromStorage ? MQLAuxServices.STORAGE_T : MQLAuxServices.EMPTYSTR );
        String rightSt = ( this.toStorage ? MQLAuxServices.STORAGE_T : MQLAuxServices.EMPTYSTR );

        this.fromType.toString( indent, sb );
        sb.append( MQLAuxServices.DOT_T + this.toAssocEndName );
        sb.append( MQLAuxServices.OPENBRACKET_T + leftSt );
        sb.append( MQLAuxServices.SPACE_T + this.assocName + MQLAuxServices.SPACE_T );
        sb.append( rightSt + MQLAuxServices.CLOSEBRACKET_T + MQLAuxServices.SPACE_T + MQLAuxServices.EQUAL_T + MQLAuxServices.SPACE_T );
        this.toType.toString( indent, sb );

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

    @Override
    public SpiFqlQueryEntry getFromEndEntry( ) {

        return this.getFromType( ).getAtomicEntry( );
    }

    public SpiFqlQueryEntry getToEndEntry( ) {

        return this.getToType( ).getAtomicEntry( );
    }

}
