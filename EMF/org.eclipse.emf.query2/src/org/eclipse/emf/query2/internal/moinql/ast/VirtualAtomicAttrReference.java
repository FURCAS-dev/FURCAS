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
import org.eclipse.emf.query2.internal.messages.BugMessages;
import org.eclipse.emf.query2.internal.shared.BugException;

/**
 * This reference refers to a select entry, which in itself again references a
 * TypeAttrReference.
 */
final public class VirtualAtomicAttrReference extends VirtualAtomicEntryReference implements TypeAttrReference {

	public VirtualAtomicAttrReference(SelectEntry _nestedSelectEntry) {

		super(_nestedSelectEntry);
	}

	public boolean isMultiValued() {

		return getAtomicAttrReference().isMultiValued();
	}

	public String getAttrName() {

		return getAtomicAttrReference().getAttrName();
	}

	public SpiFqlPrimitiveType getAttrType() {

		return getAtomicAttrReference().getAttrType();
	}

	private AtomicAttrReference getAtomicAttrReference() {

		TypeReference elRef = this.nestedSelectEntry.getTypeReference();
		AtomicAttrReference result = null;
		if (elRef instanceof VirtualAtomicAttrReference) {
			result = ((VirtualAtomicAttrReference) elRef).getAtomicAttrReference();
		} else if (elRef instanceof AtomicAttrReference) {
			result = ((AtomicAttrReference) elRef);
		} else {
			throw new BugException(BugMessages.VIRTUAL_ATTOMIC_ATTR_REF_SHOULD_REFER_TO_TYPE_ATTR_REF);
		}
		return result;
	}

	/*
	 * Redefine identity
	 */
	@Override
	public boolean equals(Object otherReference) {

		boolean result = false;
		if (otherReference instanceof TypeAttrReference) {
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
	public String toString() {

		return super.toString();
	}
}
