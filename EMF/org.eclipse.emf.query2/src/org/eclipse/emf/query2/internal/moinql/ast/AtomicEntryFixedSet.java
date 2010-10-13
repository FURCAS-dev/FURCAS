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

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.query2.internal.fql.SpiFqlEntryElements;
import org.eclipse.emf.query2.internal.fql.SpiFqlFromTypeCategory;
import org.eclipse.emf.query2.internal.messages.BugMessages;
import org.eclipse.emf.query2.internal.shared.AuxServices;
import org.eclipse.emf.query2.internal.shared.BugException;


/**
 * An AtomicEntryFixedSet is a special atomic entry, where the set of elements
 * to consider is fixed. All its elements have to be of the types provided in
 * the type-list. Moreover, an atomic entry with fixed elements always has an
 * implicit scope based on its elements, which is inclusive!
 */
final public class AtomicEntryFixedSet extends AtomicEntry implements SpiFqlEntryElements {

	private Set<URI> elements;

	/**
	 * This constructor sets the element set and determines the scope. The
	 * provided scope may delimit the elements in the set
	 */
	public AtomicEntryFixedSet(AliasName _aliasName, List<URI> _classMRIs, List<String> _classNames, Set<URI> _elements,
			boolean _isReflectElement, Set<URI> _scope, Set<URI> _containerScope, boolean isIncluded) {

		// first set the aspects of a normal atomic entry
		super(_aliasName, _classMRIs, _classNames, SpiFqlFromTypeCategory.CLASS, _isReflectElement, null, null, false);

		// the set the fixed elements
		this.elements = (_elements == null ? new HashSet<URI>(0) : _elements);

		// set the scope, which destructively adapts elements
		this.setScope(_scope, _containerScope, isIncluded);
	}

	@SuppressWarnings("unchecked")
	static public AtomicEntryFixedSet newAtomicEntryFixedSetWithClonedElements(AliasName _aliasName, List<URI> _classMRIs,
			List<String> _classNames, Set<URI> _elements, boolean _isReflectElement, Set<URI> _scope, Set<URI> _containerScope,
			boolean isIncluded) {

		Set<URI> clonedElements = null;
		if (_elements instanceof HashSet) {
			clonedElements = (Set<URI>) ((HashSet<URI>) _elements).clone();
		} else if (_elements != null) {
			throw new BugException(BugMessages.FIXED_ELEMENT_SET_IN_CLONING_CONSTRUCTOR_HAS_TO_BE_HASHSET);
		}

		return new AtomicEntryFixedSet(_aliasName, _classMRIs, _classNames, clonedElements, _isReflectElement, _scope, _containerScope,
				isIncluded);
	}

	public Set<URI> getElements() {

		return this.elements;
	}

	@Override
	public void setScope(Set<URI> scope, Set<URI> containerScope, boolean included) {

		scope = (scope == null ? new HashSet<URI>(0) : scope);
		containerScope = (containerScope == null ? new HashSet<URI>(0) : containerScope);

		Set<URI> pris = new HashSet<URI>();
		Set<URI> cris = new HashSet<URI>();

		if (included) {
			for (Iterator<URI> elementIter = this.elements.iterator(); elementIter.hasNext();) {
				URI element = elementIter.next();
				URI priOfMri = element.trimFragment();
				//                CRI criOfMri = priOfMri.getCri( );

				if (scope.contains(priOfMri)) {
					pris.add(priOfMri);
					//                    cris.add( criOfMri );
				} else {
					// not in scope, remove element
					elementIter.remove();
				}
			}
		} else {
			for (Iterator<URI> elementIter = this.elements.iterator(); elementIter.hasNext();) {
				URI element = elementIter.next();
				URI priOfMri = element.trimFragment();
				//                CRI criOfMri = priOfMri.getCri( );

				if (!scope.contains(priOfMri)) {
					pris.add(priOfMri);
					//                    cris.add( criOfMri );
				} else {
					// not in scope, remove element
					elementIter.remove();
				}
			}
		}
		super.setScope(pris, cris, true);
	}

	/**
	 * the scope of a fixed set is always inclusive as it cannot be larger than
	 * the implicit scope of the fixed set of elements.
	 */
	@Override
	public boolean isScopeInclusive() {

		return true;
	}

	@Override
	protected void printScope(StringBuilder mainEntryString, int indent) {

		Set<URI> els = getElements();

		els = (els == null ? new HashSet<URI>(0) : els);

		String prefix = AuxServices.SPACE_T + AuxServices.IN_T + AuxServices.SPACE_T + AuxServices.ELEMENTS_T
				+ AuxServices.OPENCURLY_T;

		Iterator<URI> elsIterator = els.iterator();

		if (elsIterator.hasNext()) {
			mainEntryString.append(AuxServices.newLine(indent) + prefix + elsIterator.next().toString());

			for (; elsIterator.hasNext();) {
				URI elMRI = elsIterator.next();
				mainEntryString.append(AuxServices.COMMA_T + AuxServices.newLine(indent + prefix.length()));
				mainEntryString.append(elMRI.toString());
			}
		}
		mainEntryString.append(AuxServices.CLOSECURLY_T);
	}

	/*
	 * FQL
	 */

	public URI[] getFixedElements() {

		Set<URI> scopedMris = getElements();
		return scopedMris.toArray(new URI[scopedMris.size()]);
	}

}
