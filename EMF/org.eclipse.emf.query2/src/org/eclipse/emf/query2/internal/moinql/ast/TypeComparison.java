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
package org.eclipse.emf.query2.internal.moinql.ast;

import org.eclipse.emf.query2.internal.shared.AuxServices;

/**
 * A TypeComparision expresses a join constraint which compares two type
 * references for equality.
 */
final public class TypeComparison extends ComparisonWithEntry {

	private TypeReference leftType;

	private TypeReference rightType;

	public TypeComparison(TypeReference _leftType, TypeReference _rightType) {

		this.leftType = _leftType;
		this.rightType = _rightType;
	}

	public TypeReference getLeftType() {

		return this.leftType;
	}

	public TypeReference getRightType() {

		return this.rightType;
	}

	@Override
	public AtomicEntry getLeftAtomicEntry() {

		return getLeftType().getAtomicEntry();
	}

	@Override
	public AtomicEntry getRightAtomicEntry() {

		return getRightType().getAtomicEntry();
	}

	@Override
	public TypeReference getLeftTypeReference() {

		return getLeftType();
	}

	@Override
	public TypeReference getRightTypeReference() {

		return getRightType();
	}

	@Override
	public void setLeftType(TypeReference leftType) {

		this.leftType = leftType;
	}

	@Override
	public void setRightType(TypeReference rightType) {

		this.rightType = rightType;
	}

	/*
	 * Pretty-printing
	 */
	@Override
	public String toString(int indent, StringBuilder accumSb) {

		StringBuilder sb = new StringBuilder();

		this.leftType.toString(indent, sb);

		sb.append(AuxServices.SPACE_T + AuxServices.EQUAL_T + AuxServices.SPACE_T);
		this.rightType.toString(indent, sb);

		accumSb.append(sb);

		return sb.toString();
	}

	@Override
	public String toString() {

		return toString(0, new StringBuilder());
	}

}
