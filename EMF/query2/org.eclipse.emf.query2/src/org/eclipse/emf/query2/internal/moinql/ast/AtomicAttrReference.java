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

import org.eclipse.emf.query2.internal.fql.SpiFqlPrimitiveType;
import org.eclipse.emf.query2.internal.shared.AuxServices;

/**
 * An atomic attribute reference refers to an atomic entry and a particular
 * attribute (of primitive type) of the corresponding MOF type.
 */
final public class AtomicAttrReference extends AtomicEntryReference implements TypeAttrReference {

	private String attrName;

	private boolean isMultiValued;

	private boolean isOrdered;

	private boolean isUnique;

	private SpiFqlPrimitiveType attrType;

	public AtomicAttrReference(AtomicEntry _atomicEntry, String _attrName, SpiFqlPrimitiveType _attrType, boolean _isMultiValued,
			boolean _isOrdered, boolean _isUnique) {

		super(_atomicEntry);
		this.attrName = _attrName;
		this.isMultiValued = _isMultiValued;
		this.isOrdered = _isOrdered;
		this.isUnique = _isUnique;
		this.attrType = _attrType;
	}

	public String getAttrName() {

		return this.attrName;
	}

	public boolean isMultiValued() {

		return this.isMultiValued;
	}

	public boolean isOrdered() {

		return this.isOrdered;
	}

	public boolean isUnique() {

		return this.isUnique;
	}

	public SpiFqlPrimitiveType getAttrType() {

		return this.attrType;
	}

	public void setAttrName(String attrName) {

		this.attrName = attrName;
	}

	public void setMultiValued(boolean isMultiValued) {

		this.isMultiValued = isMultiValued;
	}

	public void setAttrType(SpiFqlPrimitiveType attrType) {

		this.attrType = attrType;
	}

	/*
	 * Redefine identity
	 */
	@Override
	public boolean equals(Object otherReference) {

		boolean result = otherReference instanceof TypeAttrReference;
		if (result) {
			TypeAttrReference otherTypeAttrReference = (TypeAttrReference) otherReference;
			result = getAtomicEntry().equals(otherTypeAttrReference.getAtomicEntry())
					&& getAttrName().equals(otherTypeAttrReference.getAttrName());
		}
		return result;
	}

	@Override
	public int hashCode() {

		int result = 17;
		result = 37 * result + super.hashCode();
		result = 37 * result + getAttrName().hashCode();
		return result;
	}

	/*
	 * Pretty-printing
	 */
	@Override
	public String toString(int indent, StringBuilder accumSb) {

		StringBuilder sb = new StringBuilder();

		sb.append(this.atomicEntry.getAliasName() + AuxServices.DOT_T + this.attrName + AuxServices.OPENPAREN_T
				+ this.attrType.toString() + AuxServices.CLOSEPAREN_T);

		if (this.isMultiValued) {
			sb.append(AuxServices.OPENPAREN_T + AuxServices.ISMULTIVALUED_T + AuxServices.CLOSEPAREN_T);
		}

		// finalize
		accumSb.append(sb);

		return sb.toString();
	}

	@Override
	public String toString() {

		return toString(0, new StringBuilder());
	}

}
