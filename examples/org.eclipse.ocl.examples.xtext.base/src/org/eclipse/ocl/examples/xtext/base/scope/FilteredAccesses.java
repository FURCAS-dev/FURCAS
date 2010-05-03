/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: FilteredAccesses.java,v 1.2 2010/05/03 11:12:52 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.scope;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.examples.xtext.base.baseCST.ElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.NamedElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.util.ElementUtil;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;

public class FilteredAccesses
{		
	private Map<String, ElementCS> contentsByName = new HashMap<String, ElementCS>();
	private Map<ElementCS, String> contentsByElement = new HashMap<ElementCS, String>();
	private EStructuralFeature reference;
	private String name;

	public FilteredAccesses(EStructuralFeature reference, String name) {
		this.reference = reference;
		this.name = name;
	}

	public boolean accepts(EClass eClass) {
		return ElementUtil.conformsTo(reference, eClass);
	}

	public void addElement(String elementName, ElementCS element) {
		if ((element != null) && ((name == null) || name.equals(elementName))) {
			contentsByName.put(elementName, element);
			contentsByElement.put(element, elementName);
		}
	}

	public void addElementsOfScope(ElementCS element) {
		AbstractScopeAdapter<?> scopeAdapter = AbstractScopeAdapter.getScopeAdapter(element);
		if (scopeAdapter != null) {
			scopeAdapter.getInclusiveInheritedContents(this);
		}
	}

	public void addNamedElement(NamedElementCS namedElement) {
		if (namedElement != null) {
			addElement(namedElement.getName(), namedElement);
		}
	}

	public void addNamedElement(EClass eClass, NamedElementCS namedElement) {
		if ((namedElement != null) && accepts(eClass)) {
			if (eClass.isSuperTypeOf(namedElement.eClass())) {
				addNamedElement(namedElement);
			}
		}
	}

	public void addNamedElements(List<? extends NamedElementCS> namedElements) {
		for (NamedElementCS namedElement : namedElements) {
			addElement(namedElement.getName(), namedElement);
		}
	}

	public void addNamedElements(EClass eClass, List<? extends NamedElementCS> namedElements) {
		if ((namedElements != null) && accepts(eClass)) {
			for (NamedElementCS namedElement : namedElements) {
				if (eClass.isSuperTypeOf(namedElement.eClass())) {
					addElement(namedElement.getName(), namedElement);
				}
			}
		}
	}

	public IEObjectDescription getContent() {
		assert contentsByName.size() == 1;
		for (Map.Entry<String, ElementCS> entry : contentsByName.entrySet()) {
			return EObjectDescription.create(entry.getKey(), entry.getValue());
		}
		return null;
	}

	public List<IEObjectDescription> getContents() {
		List<IEObjectDescription> contents = new ArrayList<IEObjectDescription>();
		for (Map.Entry<String, ElementCS> entry : contentsByName.entrySet()) {
			contents.add(EObjectDescription.create(entry.getKey(), entry.getValue()));
		}
		return contents;
	}

	public int getSize() {
		return contentsByName.size();
	}
	
	@Override
	public String toString() {
		StringBuffer s = new StringBuffer();
		if (reference != null) {
			s.append(reference.getName());
			s.append(" : ");
			s.append(reference.getEType().eClass().getName());
		}
		s.append(" \"");
		if (name != null) {
			s.append(name);
		}
		s.append("\" {");
		String prefix = "";
		for (String contentName : contentsByName.keySet()) {
			s.append(prefix);
			s.append(contentName);
			prefix = ",";
		}
		s.append("}");
		return s.toString();
	}
}