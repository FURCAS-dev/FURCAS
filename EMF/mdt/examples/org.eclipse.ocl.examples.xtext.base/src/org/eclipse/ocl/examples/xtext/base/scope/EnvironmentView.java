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
 * $Id: EnvironmentView.java,v 1.4 2010/05/29 15:31:41 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.scope;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.examples.xtext.base.baseCST.NamedElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.OperationCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeBindingsCS;
import org.eclipse.ocl.examples.xtext.base.util.ElementUtil;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;

/**
 * An EnvironmentView provides a selective view of the environment visible at some CST node.
 * 
 * The selection corresponds to an Environment lookup method as defined by the OCL specification
 * computed in accordance with the the Inherited Attributes.
 * 
 * The selective view is normally for just the single name required by the lookUp, but may be
 * for all names when a Completion Assist is required.
 * 
 * The EnvironmentView is computed on demand, rather than cached, since only small parts of
 * the overall environment are needed and caches may not remain valid for long given the rapid
 * recreation of CST nodes that occurs while editing.
 */
public class EnvironmentView
{		
	private final Map<String, Object> contentsByName = new HashMap<String, Object>();		// Single EObject or List<EObject>
	private final EStructuralFeature reference;
	private List<EClass> requiredAlternatives = null;
	private final String name;

	public EnvironmentView(EStructuralFeature reference, String name) {
		this.reference = reference;
		this.name = name;
	}

	public boolean accepts(EClass eClass) {
		return ElementUtil.conformsTo(reference, eClass);
	}

	/**
	 * Add an element with an elementName to the view
	 * 
	 * @param elementName name of element
	 * @param element the element
	 * @return the number of elements added; 1 if added, 0 if not
	 */
	public int addElement(String elementName, EObject element, TypeBindingsCS bindings) {
		if ((element != null) && ((name == null) || name.equals(elementName))) {
//			if (bindings == null) {
//				bindings = rootBindings;
//			}
			if (!bindings.getBindings().isEmpty()) {
				if (element instanceof OperationCS) {
					element = ElementUtil.specializeOperation((OperationCS) element, bindings);
				}
			}
			Object value = contentsByName.get(elementName);
			if (value == null) {
				contentsByName.put(elementName, element);
			}
			else {
				List<EObject> values;
				if (value instanceof EObject) {
					values = new ArrayList<EObject>();
					values.add((EObject) value);
				}
				else {
					@SuppressWarnings("unchecked")
					List<EObject> castValue = (List<EObject>)value;
					values = castValue;
				}
				values.add(element);
			}
			return 1;
		}
		return 0;
	}

	public void addElementsOfScope(EObject element, ScopeView scopeView) {
		ScopeAdapter scopeAdapter = ElementUtil.getScopeAdapter(element);
		if (scopeAdapter != null) {
			scopeAdapter.computeLookup(this, scopeView);
		}
	}

	public int addNamedElement(NamedElementCS namedElement, TypeBindingsCS bindings) {
		if (namedElement != null) {
			return addElement(namedElement.getName(), namedElement, bindings);
		}
		return 0;
	}

	public int addNamedElement(EClass eClass, NamedElementCS namedElement, TypeBindingsCS bindings) {
		if ((namedElement != null) && accepts(eClass)) {
			if (eClass.isSuperTypeOf(namedElement.eClass())) {
				if (requiredAlternatives != null) {
					for (EClass requiredAlternative : requiredAlternatives) {
						if (requiredAlternative.isSuperTypeOf(namedElement.eClass())) {
							return addNamedElement(namedElement, bindings);
						}
					}
				}
				else {				
					return addNamedElement(namedElement, bindings);
				}
			}
		}
		return 0;
	}

	public int addNamedElements(List<? extends NamedElementCS> namedElements, TypeBindingsCS bindings) {
		int additions = 0;
		for (NamedElementCS namedElement : namedElements) {
			additions += addElement(namedElement.getName(), namedElement, bindings);
		}
		return additions;
	}

	public int addNamedElements(EClass eClass, List<? extends NamedElementCS> namedElements, TypeBindingsCS bindings) {
		int additions = 0;
		if ((namedElements != null) && accepts(eClass)) {
			for (NamedElementCS namedElement : namedElements) {
				if (eClass.isSuperTypeOf(namedElement.eClass())) {
					if (requiredAlternatives != null) {
						for (EClass requiredAlternative : requiredAlternatives) {
							if (requiredAlternative.isSuperTypeOf(namedElement.eClass())) {
								additions += addElement(namedElement.getName(), namedElement, bindings);
							}
						}
					}
					else {				
						additions += addElement(namedElement.getName(), namedElement, bindings);
					}
				}
			}
		}
		return additions;
	}

	public IEObjectDescription getContent() {
		assert contentsByName.size() == 1;
		for (Map.Entry<String, Object> entry : contentsByName.entrySet()) {
			Object value = entry.getValue();
			if (value instanceof List<?>) {
				List<?> values = (List<?>)value;
				value = values.get(values.size()-1);
			}
			if (value instanceof EObject) {
				return EObjectDescription.create(entry.getKey(), (EObject) value);
			}
		}
		return null;
	}

	public List<IEObjectDescription> getContents() {
		List<IEObjectDescription> contents = new ArrayList<IEObjectDescription>();
		for (Map.Entry<String, Object> entry : contentsByName.entrySet()) {
			Object values = entry.getValue();
			if (values instanceof EObject) {
				contents.add(EObjectDescription.create(entry.getKey(), (EObject) values));
			}
			else if (values instanceof List<?>) {
				for (Object value : (List<?>)values) {
					contents.add(EObjectDescription.create(entry.getKey(), (EObject) value));
				}
			}
		}
		return contents;
	}

	public Object getName() {
		return name;
	}

	public EClassifier getRequiredType() {
		return reference != null ? reference.getEType() : null;
	}

	public int getSize() {
		return contentsByName.size();
	}

	public void require(EClass... requiredClasses) {
		if (requiredClasses != null) {
			if (requiredAlternatives == null) {
				requiredAlternatives = new ArrayList<EClass>();
			}
			for (EClass requiredClass : requiredClasses) {
				requiredAlternatives.add(requiredClass);
			}
		}	
	}

	@Override
	public String toString() {
		StringBuffer s = new StringBuffer();
		if (reference != null) {
			s.append(reference.getName());
			s.append(" : "); //$NON-NLS-1$
			s.append(reference.getEType().getName());
			if (requiredAlternatives != null) {
				s.append(" && ("); //$NON-NLS-1$
				String prefix = ""; //$NON-NLS-1$
				for (EClass requiredAlternative : requiredAlternatives) {
					s.append(prefix);
					s.append(requiredAlternative.getName());
					prefix = " || "; //$NON-NLS-1$
				}
				s.append(")"); //$NON-NLS-1$
			}
		}
		s.append(" \""); //$NON-NLS-1$
		if (name != null) {
			s.append(name);
		}
		s.append("\" {"); //$NON-NLS-1$
		String prefix = ""; //$NON-NLS-1$
		for (String contentName : contentsByName.keySet()) {
			s.append(prefix);
			s.append(contentName);
			prefix = ","; //$NON-NLS-1$
		}
		s.append("}"); //$NON-NLS-1$
		return s.toString();
	}
}