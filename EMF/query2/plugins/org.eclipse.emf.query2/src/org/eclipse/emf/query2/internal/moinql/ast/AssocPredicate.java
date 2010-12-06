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
 * An AssocPredicate expresses a join constraint which compares if two model
 * elements exist in an association.
 */
final public class AssocPredicate extends AssociationWithEntry {

	private AtomicEntryReference toType;

	//    public AssocPredicate( URI _assocMRI, SpiFqlAssociationCategory _assocCategory, String _assocName, int _leftAssocEnd, boolean _leftStorage, String _leftAssocEndName, int _rightAssocEnd, boolean _rightStorage, String _rightAssocEndName, AtomicEntryReference _leftType,
	//        AtomicEntryReference _rightType ) {
	//
	//        this.assocMRI = _assocMRI;
	//        this.assocCategory = _assocCategory;
	//        this.assocName = _assocName;
	//        this.fromAssocEnd = _leftAssocEnd;
	//        this.fromAssocEndName = _leftAssocEndName;
	//        this.toAssocEnd = _rightAssocEnd;
	//        this.toAssocEndName = _rightAssocEndName;
	//        this.fromType = _leftType;
	//        this.toType = _rightType;
	//        this.fromStorage = _leftStorage;
	//        this.toStorage = _rightStorage;
	//    }

	public AssocPredicate(URI _assocMRI, String _assocName, AtomicEntryReference _leftType, AtomicEntryReference _rightType) {

		this.assocMRI = _assocMRI;
		//        this.assocCategory = _assocCategory;
		this.assocName = _assocName;
		this.fromType = _leftType;
		this.toType = _rightType;
	}

	public AtomicEntryReference getToType() {

		return this.toType;
	}

	public void setToType(AtomicEntryReference rightType) {

		this.toType = rightType;
	}

	/*
	 * Pretty-printing
	 */
	@Override
	public String toString(int indent, StringBuilder accumSb) {

		StringBuilder sb = new StringBuilder();

		//        String leftSt = ( this.fromStorage ? MQLAuxServices.STORAGE_T : MQLAuxServices.EMPTYSTR );
		//        String rightSt = ( this.toStorage ? MQLAuxServices.STORAGE_T : MQLAuxServices.EMPTYSTR );

		this.fromType.toString(indent, sb);
		//      sb.append( MQLAuxServices.DOT_T + this.toAssocEndName );
		sb.append(AuxServices.DOT_T);
		//        sb.append( MQLAuxServices.OPENBRACKET_T + leftSt );
		sb.append(AuxServices.OPENBRACKET_T);
		sb.append(AuxServices.SPACE_T + this.assocName + AuxServices.SPACE_T);
		//        sb.append( rightSt + MQLAuxServices.CLOSEBRACKET_T + MQLAuxServices.SPACE_T + MQLAuxServices.EQUAL_T + MQLAuxServices.SPACE_T );
		sb.append(AuxServices.CLOSEBRACKET_T + AuxServices.SPACE_T + AuxServices.EQUAL_T + AuxServices.SPACE_T);
		this.toType.toString(indent, sb);

		accumSb.append(sb);

		return sb.toString();
	}

	@Override
	public String toString() {

		return toString(0, new StringBuilder());
	}

	public boolean hasStorageAtFromEnd() {

		return true;
	}

}
