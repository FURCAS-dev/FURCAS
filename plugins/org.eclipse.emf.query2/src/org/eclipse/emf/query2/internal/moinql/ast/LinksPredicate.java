/*******************************************************************************
 * Copyright (c) 2006, 2009 SAP AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     SAP AG - initial API and implementation
 *******************************************************************************/
/*
 * Created on 16.02.2006
 */
package org.eclipse.emf.query2.internal.moinql.ast;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.query2.internal.shared.AuxServices;


/**
 * A LinksPredicate expresses that a model element is linked to the results of a
 * nested query via a provided association.
 */
final public class LinksPredicate extends AssociationWithEntry {

	private NestedQuery nestedQuery;

	private boolean not;

	//    public LinksPredicate( boolean _not, MRI _assocMRI, SpiFqlAssociationCategory _assocCategory, String _assocName, int _toAssocEnd, boolean _toStored, String _toAssocEndName, AtomicEntryReference _fromType, boolean _fromStored, int _fromAssocEnd, String _fromAssocEndName,
	//        InternalQuery _nestedQuery ) {
	//
	//        this.not = _not;
	//        this.assocMRI = _assocMRI;
	//        this.assocCategory = _assocCategory;
	//        this.assocName = _assocName;
	//        this.toAssocEnd = _toAssocEnd;
	//        this.toAssocEndName = _toAssocEndName;
	//        this.fromType = _fromType;
	//        this.nestedQuery = new NestedQuery( _nestedQuery );
	//        this.toStorage = _toStored;
	//        this.fromStorage = _fromStored;
	//        this.fromAssocEnd = _fromAssocEnd;
	//        this.fromAssocEndName = _fromAssocEndName;
	//    }

	public LinksPredicate(boolean _not, URI _assocMRI, String _assocName, AtomicEntryReference _fromType, InternalQuery _nestedQuery) {

		this.not = _not;
		this.assocMRI = _assocMRI;
		this.assocName = _assocName;
		this.fromType = _fromType;
		this.nestedQuery = new NestedQuery(_nestedQuery);
	}

	public NestedQuery getNestedQuery() {

		return this.nestedQuery;
	}

	public boolean isNegated() {

		return this.not;
	}

	public void setNestedQuery(NestedQuery nestedQuery) {

		this.nestedQuery = nestedQuery;
	}

	public void setNot(boolean not) {

		this.not = not;
	}

	/*
	 * Pretty-printing
	 */
	@Override
	public String toString(int indent, StringBuilder accumSb) {

		StringBuilder sb = new StringBuilder();

		String notStr = (this.not ? AuxServices.NOT_T + AuxServices.SPACE_T : AuxServices.EMPTYSTR);
		//        String storedSt = ( this.toStorage ? MQLAuxServices.STORAGE_T : MQLAuxServices.EMPTYSTR );
		//        String linkedToStoredSt = ( this.fromStorage ? MQLAuxServices.STORAGE_T : MQLAuxServices.EMPTYSTR );
		String resetStr = (this.nestedQuery.isReset() ? AuxServices.RESET_T + AuxServices.SPACE_T : AuxServices.EMPTYSTR);

		this.fromType.toString(indent, sb);
		//        sb.append( MQLAuxServices.DOT_T + this.toAssocEndName );
		sb.append(AuxServices.DOT_T);
		//        sb.append( MQLAuxServices.OPENBRACKET_T + linkedToStoredSt + MQLAuxServices.SPACE_T + this.assocName + MQLAuxServices.SPACE_T + storedSt + MQLAuxServices.CLOSEBRACKET_T );
		sb.append(AuxServices.OPENBRACKET_T + AuxServices.SPACE_T + this.assocName + AuxServices.SPACE_T
				+ AuxServices.CLOSEBRACKET_T);
		sb.append(AuxServices.SPACE_T + notStr + AuxServices.IN_T + AuxServices.SPACE_T + resetStr);

		int newIndent = indent + 3;
		sb.append(AuxServices.newLine(newIndent));
		this.nestedQuery.getInternalQuery().toString(newIndent, sb);

		// finalize
		accumSb.append(sb);

		return sb.toString();
	}

	@Override
	public String toString() {

		return toString(0, new StringBuilder());
	}

	/*
	 * FQL
	 */

	//    public NestedQueryOrResult getNestedQueryOrResult( ) {
	//
	//        final NestedQuery nested = this.getNestedQuery( );
	//
	//        if ( !nested.isReset( ) ) {
	//            // without a reset, we should have a nested leaf query
	//            return new NestedFqlQuery( ) {
	//
	//                public SpiFqlQuery getNestedFqlQuery( ) {
	//
	//                    InternalQuery internalQuery = nested.getInternalQuery( );
	//                    if ( internalQuery instanceof LeafQuery ) {
	//                        return (LeafQuery) internalQuery;
	//                    } else {
	//                        throw new MQLBugException( MQLBugMessages.FOUND_NON_LEAF_QUERY_IN_FQL );
	//                    }
	//                }
	//            };
	//        } else {
	//            // with a reset, we should have a sub result
	//            return new NestedResult( ) {
	//
	//                @SuppressWarnings( "null" )
	//                public MRI[] getNestedResults( ) {
	//
	//                    SpiFqlQueryResultSet resultSet = nested.getResultSet( );
	//                    // unwrap the nested result set
	//                    int resultSetSize = ( resultSet == null ? 0 : resultSet.getSize( ) );
	//                    MRI[] MRIs = new MRI[resultSetSize];
	//                    for ( int i = 0; i < resultSetSize; i++ ) {
	//                        MRIs[i] = resultSet.getMri( i, 0 );
	//                    }
	//                    return MRIs;
	//                }
	//            };
	//        }
	//    }
}
