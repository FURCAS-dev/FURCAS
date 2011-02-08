/**
 * <copyright>
 *
 * Copyright (c) 2010,2011 E.D.Willink and others.
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
 * $Id: EnvironmentView.java,v 1.8 2011/02/08 17:43:58 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.base.scope;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Iteration;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.util.Nameable;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.pivot.utilities.TypeManager;
import org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCS;
import org.eclipse.ocl.examples.xtext.base.utilities.ElementUtil;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;

/**
 * An EnvironmentView provides a selective view of the environment visible at
 * some CST node.
 * 
 * The selection corresponds to an Environment lookup method as defined by the
 * OCL specification computed in accordance with the the Inherited Attributes.
 * 
 * The selective view is normally for just the single name required by the
 * lookUp, but may be for all names when a Completion Assist is required.
 * 
 * The EnvironmentView is computed on demand, rather than cached, since only
 * small parts of the overall environment are needed and caches may not remain
 * valid for long given the rapid recreation of CST nodes that occurs while
 * editing.
 */
public class EnvironmentView {

	public static interface Filter
	{
		/**
		 * Return -ve if match1 is inferior to match2, +ve if match2 is inferior to match1, or
		 * zero if both matches are of equal validity.
		 */
		int compareMatches(EObject match1, Map<TemplateParameter, ParameterableElement> bindings1, EObject match2, Map<TemplateParameter, ParameterableElement> bindings2);

		/**
		 * Return true if the filter accepts eObject as a candidate for
		 * inclusion in the EnvironmentView.
		 * 
		 * @param eObject
		 */
		boolean matches(EnvironmentView environmentView, EObject eObject);
	}

	protected final TypeManager typeManager;
	protected final EStructuralFeature reference;

	protected final String name;

	private final Map<String, Object> contentsByName = new HashMap<String, Object>(); // Single
																						// EObject
																						// or
																						// List<EObject>
	private Map<EObject, Map<TemplateParameter, ParameterableElement>> templateBindings = null;

	private int contentsSize = 0; // Deep size of contentsByName;

	private List<Filter> matchers = null;	// Prevailing filters for matching
	private Set<Filter> resolvers = null;	// Successful filters for resolving

	public EnvironmentView(TypeManager typeManager, EStructuralFeature reference, String name) {
		this.typeManager = typeManager;
		this.reference = reference;
		this.name = name;
	}

	public boolean accepts(EClass eClass) {
		return PivotUtil.conformsTo(reference, eClass);
	}

	/**
	 * Add an element with an elementName to the view
	 * 
	 * @param elementName
	 *            name of element
	 * @param element
	 *            the element
	 * @return the number of elements added; 1 if added, 0 if not
	 */
	public int addElement(String elementName, EObject element) {
		if (element == null) {
			return 0;
		}
		if ((name != null) && !name.equals(elementName)) {
			return 0;
		}
		if (matchers != null) {
			for (Filter filter : matchers) {
				if (!filter.matches(this, element)) {
					return 0;
				}
			}
		}
		if (reference != null) {
			EClassifier requiredType = reference.getEType();
			if (!requiredType.isInstance(element)) {
				return 0;
			}
		}
		if (matchers != null) {
			if (resolvers == null) {
				resolvers = new HashSet<Filter>();
			}
			resolvers.addAll(matchers);
		}
		Object value = contentsByName.get(elementName);
		if (value == element) {
			;	// Already present
		} else if (value == null) {
			contentsByName.put(elementName, element);
			contentsSize++;
		} else {
			List<EObject> values;
			if (value instanceof EObject) {
				values = new ArrayList<EObject>();
				values.add((EObject) value);
				contentsByName.put(elementName, values);
			} else {
				@SuppressWarnings("unchecked")
				List<EObject> castValue = (List<EObject>) value;
				values = castValue;
			}
			if (!values.contains(element)) {
				values.add(element);
				contentsSize++;
			}
		}
		return 1;
	}

	public int addElements(Collection<? extends EObject> elements) {
		int additions = 0;
		if (elements != null) {
			for (EObject element : elements) {
				if (element instanceof Nameable) {
					Nameable namedElement = (Nameable) element;
					additions += addElement(namedElement.getName(),
						namedElement);
				}
			}
		}
		return additions;
	}

	public void addElementsOfScope(TypeManager typeManager, Element element,
			ScopeView scopeView) {
		ScopeAdapter scopeAdapter = ElementUtil.getScopeAdapter(typeManager, element);
		if (scopeAdapter != null) {
			scopeAdapter.computeLookup(this, scopeView);
		}
	}

	public void addElementsOfScope(ModelElementCS csElement, ScopeView scopeView) {
		ScopeAdapter scopeAdapter = ElementUtil.getScopeAdapter(csElement);
		if (scopeAdapter != null) {
			scopeAdapter.computeLookup(this, scopeView);
		}
	}

	public void addFilter(Filter filter) {
		if (matchers == null) {
			matchers = new ArrayList<Filter>();
		}
		matchers.add(filter);
	}

	public int addNamedElement(Nameable namedElement) {
		if (namedElement != null) {
			return addElement(namedElement.getName(), namedElement);
		}
		return 0;
	}

	public int addNamedElements(Collection<? extends Nameable> namedElements) {
		int additions = 0;
		if (namedElements != null) {
			for (Nameable namedElement : namedElements) {
				additions += addElement(namedElement.getName(), namedElement);
			}
		}
		return additions;
	}

	public EObject getContent() {
		assert contentsSize == 1;
		for (Map.Entry<String, Object> entry : contentsByName.entrySet()) {
			Object value = entry.getValue();
			if (value instanceof List<?>) {
				List<?> values = (List<?>) value;
				value = values.get(values.size() - 1);
			}
			if (value instanceof EObject) {
				return (EObject) value;
			}
		}
		return null;
	}

	public IEObjectDescription getDescription() {
		assert contentsSize == 1;
		for (Map.Entry<String, Object> entry : contentsByName.entrySet()) {
			Object value = entry.getValue();
			if (value instanceof List<?>) {
				List<?> values = (List<?>) value;
				value = values.get(values.size() - 1);
			}
			if (value instanceof EObject) {
				EObject eObject = (EObject) value;
				if (templateBindings != null) {
					Map<TemplateParameter, ParameterableElement> map = templateBindings.get(eObject);
					if (map != null) {
						if (eObject instanceof Iteration) {
							Iteration unspecializedIteration = (Iteration) eObject;
							Iteration specializedIteration = typeManager.getSpecializedOperation(unspecializedIteration, map);
							eObject = specializedIteration;
						}
						else if (eObject instanceof Operation) {
							Operation unspecializedOperation = (Operation) eObject;
							Operation specializedOperation = typeManager.getSpecializedOperation(unspecializedOperation, map);
							eObject = specializedOperation;
						}
					}
				}
				return EObjectDescription.create(entry.getKey(), eObject);
			}
		}
		return null;
	}

	public List<IEObjectDescription> getDescriptions() {
		List<IEObjectDescription> contents = new ArrayList<IEObjectDescription>();
		for (Map.Entry<String, Object> entry : contentsByName.entrySet()) {
			Object values = entry.getValue();
			if (values instanceof EObject) {
				contents.add(EObjectDescription.create(entry.getKey(),
					(EObject) values));
			} else if (values instanceof List<?>) {
				for (Object value : (List<?>) values) {
					contents.add(EObjectDescription.create(entry.getKey(),
						(EObject) value));
				}
			}
		}
		return contents;
	}

	public String getName() {
		return name;
	}

	// public EStructuralFeature getReference() {
	// return reference;
	// }

	public EClassifier getRequiredType() {
		return reference != null
			? reference.getEType()
			: null;
	}

	public int getSize() {
		return contentsSize;
	}

	/**
	 * Return true once the EnvironmentView has accumulated sufficient results
	 * to satisfy the lookup criterion for which it was created. i.e. any result
	 * for a non-null name, all results for a null name.
	 */
	public boolean hasFinalResult() {
		if (contentsSize == 0) {
			return false; // Not thing found is not a final result
		}
		if (getName() == null) {
			return false; // No name means search full hierarchy
		}
		return true;
	}

	public void removeFilter(Filter filter) {
		if (matchers != null) {
			matchers.remove(filter);
		}
	}

	public int resolveDuplicates() {
		if ((contentsSize > 1) && (resolvers != null) && (getName() != null)) {
			int newSize = 0;
			for (Map.Entry<String, Object> entry : contentsByName.entrySet()) {
				Object value = entry.getValue();
				if (value instanceof List<?>) {
					@SuppressWarnings("unchecked")
					List<EObject> values = (List<EObject>) value;
					for (Filter filter : resolvers) {
						for (int i = 0; i < values.size()-1;) {
							EObject reference = values.get(i);
							Map<TemplateParameter, ParameterableElement> referenceBindings = templateBindings != null ? templateBindings.get(reference) : null;
							for (int j = i + 1; j < values.size();) {
								EObject candidate = values.get(j);
								Map<TemplateParameter, ParameterableElement> candidateBindings = templateBindings != null ? templateBindings.get(candidate) : null;
								int verdict = filter.compareMatches(reference, referenceBindings, candidate, candidateBindings);
								if (verdict == 0) {
									j++;
								} else if (verdict < 0) {
									values.remove(i);
									reference = null;
									break;
								} else {
									values.remove(j);
									candidate = null;
								}
							}
							if (reference != null) {
								i++;
							}
						}
					}
					newSize += values.size();
				} else {
					newSize++;
				}
			}
			contentsSize = newSize;
		}
		return getSize();
	}

	public void setBindings(EObject eObject, Map<TemplateParameter, ParameterableElement> bindings) {
		if (templateBindings == null) {
			templateBindings = new HashMap<EObject, Map<TemplateParameter, ParameterableElement>>();
		}
		templateBindings.put(eObject, bindings);
	}

	@Override
	public String toString() {
		StringBuffer s = new StringBuffer();
		if (reference != null) {
			s.append(reference.getName());
			s.append(" : "); //$NON-NLS-1$
			s.append(reference.getEType().getName());
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
			Object content = contentsByName.get(contentName);
			if (content instanceof List<?>) {
				s.append("*");
				s.append(((List<?>) content).size());
			}
			prefix = ","; //$NON-NLS-1$
		}
		s.append("}"); //$NON-NLS-1$
		return s.toString();
	}
}