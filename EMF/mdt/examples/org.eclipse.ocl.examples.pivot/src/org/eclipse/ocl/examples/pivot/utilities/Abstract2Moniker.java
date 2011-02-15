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
 * $Id: Abstract2Moniker.java,v 1.4 2011/02/15 10:38:47 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.utilities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.examples.common.utils.TracingOption;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.ExpressionInOcl;
import org.eclipse.ocl.examples.pivot.Iteration;
import org.eclipse.ocl.examples.pivot.MonikeredElement;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.ParameterableElement;
import org.eclipse.ocl.examples.pivot.TemplateBinding;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateParameterSubstitution;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.TemplateableElement;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypedElement;

public abstract class Abstract2Moniker implements PivotConstants
{			
	private static final Logger logger = Logger.getLogger(Abstract2Moniker.class);
	public static final TracingOption TRACE_MONIKERS = new TracingOption("org.eclipse.ocl.examples.pivot", "traceMonikers");  //$NON-NLS-1$//$NON-NLS-2$

	/**
	 * The CS element for which a moniker is required.
	 */
	protected final EObject target;

	/**
	 * The working buffer for the result.
	 */
	private final StringBuffer s = new StringBuffer();
	
	/**
	 * A pivot 2 moniker conversion visitor, if needed.
	 */
	private Pivot2MonikerVisitor pivotVisitor = null;

	/**
	 * TemplateParameters that already appear in the result and do not need re-qualification.
	 */
	private List<TemplateParameter> emittedParameters = null;
	
	protected Abstract2Moniker(EObject target) {
		this.target = target;
	}

	public void append(char c) {
		s.append(c);
	}
	
	public void append(int i) {
		s.append(i);
	}
	
	public void append(String string) {
		s.append(string != null ? string : "null"); //$NON-NLS-1$
	}
	
	public void appendElement(Element element) {
		if (toString().length() >= MONIKER_OVERFLOW_LIMIT) {
			append(OVERFLOW_MARKER);
		}
		else if (element == null) {
			append(NULL_MARKER);	
		}
		else {
			if (pivotVisitor == null) {
				pivotVisitor = new Pivot2MonikerVisitor(this);
			}
			element.accept(pivotVisitor);
		}		
	}
	
	public void appendElement(Element element, Map<TemplateParameter, ParameterableElement> templateBindings) {
		if (toString().length() >= MONIKER_OVERFLOW_LIMIT) {
			append(OVERFLOW_MARKER);
		}
		else if (element == null) {
			append(NULL_MARKER);	
		}
		else if (templateBindings != null) {
			Pivot2MonikerVisitor savedPivotVisitor = pivotVisitor;
			try {
				pivotVisitor = new Pivot2MonikerVisitor(this, templateBindings);
				element.accept(pivotVisitor);
			}
			finally {
				pivotVisitor = savedPivotVisitor;
			}
		}
		else {
			if (pivotVisitor == null) {
				pivotVisitor = new Pivot2MonikerVisitor(this);
			}
			element.accept(pivotVisitor);
		}
	}

	public void appendIndex(EObject eObject) {
		if (eObject != null) {
			EObject parent = eObject.eContainer();
			if (parent != null) {
				Object objects = parent.eGet(eObject.eContainingFeature());
				if (objects instanceof List<?>) {
					append(((List<?>)objects).indexOf(eObject));
					return;
				}
			}
		}
		append(0);
	}

	public void appendLambdaType(Type contextType, List<? extends Type> parameterTypes,
			Type resultType, Map<TemplateParameter, ParameterableElement> bindings) {
		append(MONIKER_OPERATOR_SEPARATOR);
		if (contextType != null) {
			appendElement(contextType, bindings);
		}
		append(PARAMETER_PREFIX);
		String prefix = ""; //$NON-NLS-1$
		for (Type parameterType : parameterTypes) {
			append(prefix);
			appendElement(parameterType, bindings);
			prefix = PARAMETER_SEPARATOR;
		}
		append(PARAMETER_SUFFIX);
		if (resultType != null) {
			appendElement(resultType, bindings);
		}
	}

	public void appendName(MonikeredElement monikeredElement) {
		if (monikeredElement instanceof org.eclipse.ocl.examples.pivot.Package) {
			String alias = AliasAdapter.getAlias(monikeredElement);
			if (alias != null) {
				append(alias);
				return;
			}
		}
		if (monikeredElement instanceof TemplateableElement) {
			List<TemplateBinding> templateBindings = ((TemplateableElement)monikeredElement).getTemplateBindings();
			if (!templateBindings.isEmpty()) {
				appendName(PivotUtil.getUnspecializedTemplateableElement((TemplateableElement)monikeredElement));
				return;
			}
		}
		if (monikeredElement instanceof NamedElement) {
			append(((NamedElement) monikeredElement).getName());
		}
		else if (monikeredElement == null) {
//			logger.warn("null for PivotMoniker.appendName()");
			append("/null/");
		}
		else {
			logger.warn("Unsupported PivotMoniker.appendName() for " + monikeredElement.eClass().getName());
			append("/anon/");
		}
	}
	
	public void appendParameters(Operation operation, Map<TemplateParameter, ParameterableElement> templateBindings) {
		s.append(PARAMETER_PREFIX);
		String prefix = ""; //$NON-NLS-1$
		if (operation instanceof Iteration) {
			Iteration iteration = (Iteration)operation;
			for (Parameter parameter : iteration.getOwnedIterators()) {
				s.append(prefix);
				appendElement(parameter.getType(), templateBindings);
				prefix = PARAMETER_SEPARATOR;
			}
			if (iteration.getOwnedAccumulators().size() > 0) {
				prefix = ITERATOR_SEPARATOR;
				for (Parameter parameter : iteration.getOwnedAccumulators()) {
					s.append(prefix);
					appendElement(parameter.getType(), templateBindings);
					prefix = PARAMETER_SEPARATOR;
				}
			}
			prefix = ACCUMULATOR_SEPARATOR;
		}
		for (Parameter parameter : operation.getOwnedParameters()) {
			s.append(prefix);
			appendElement(parameter.getType(), templateBindings);
			prefix = PARAMETER_SEPARATOR;
		}
		s.append(PARAMETER_SUFFIX);
	}

	public void appendParent(Element element, String parentSeparator) {
		if (toString().length() >= MONIKER_OVERFLOW_LIMIT) {
			append(OVERFLOW_MARKER);
		}
		else if (element == null) {
			append("<<null-element>>");	
		}
		else {
			EObject parent = element.eContainer();
			if (parent instanceof MonikeredElement) {
				append(((MonikeredElement) parent).getMoniker());	
			}
			else if (parent instanceof Element) {
				appendElement((Element) parent);	
			}
			else if (element.eIsProxy()) {
				append("<<unresolved-proxy>>");	
			}
			else {
				assert element instanceof org.eclipse.ocl.examples.pivot.Package || element instanceof ExpressionInOcl : element.eClass().getName() + " has no parent";	
			}
		}
		append(parentSeparator);
	}

	public void appendRole(Element object) {
		EStructuralFeature eFeature = object.eContainmentFeature();
		if (eFeature != null) {
			String roleName = roleNames.get(eFeature);
			if (roleName == null) {
				roleName = eFeature.getName();
			}
			append(roleName);
			if (eFeature.isMany()) {
				int index = ((List<?>)object.eContainer().eGet(object.eContainingFeature())).indexOf(object);
				if (index != 0) {
					append(index);
				}
			}
		}
	}
	
	public void appendTemplateBindings(TemplateableElement templateableElement, Map<TemplateParameter, ParameterableElement> bindings) {
		List<TemplateBinding> templateBindings = templateableElement.getTemplateBindings();
		if (!templateBindings.isEmpty()) {
			s.append(TEMPLATE_BINDING_PREFIX);
			String prefix = ""; //$NON-NLS-1$
			for (TemplateBinding templateBinding : templateBindings) {
				templateBinding.getSignature();
				List<TemplateParameterSubstitution> parameterSubstitutions = templateBinding.getParameterSubstitutions();
				if (parameterSubstitutions.size() > 1) {
					parameterSubstitutions = new ArrayList<TemplateParameterSubstitution>(parameterSubstitutions);
					Collections.sort(parameterSubstitutions, PivotUtil.TemplateParameterSubstitutionComparator.INSTANCE);
				}
				for (TemplateParameterSubstitution templateParameterSubstitution : parameterSubstitutions) {
					s.append(prefix);
					appendElement(templateParameterSubstitution.getActual(), bindings);
					prefix = TEMPLATE_BINDING_SEPARATOR;
				}
			}
			s.append(TEMPLATE_BINDING_SUFFIX);
		}
	}

	public void appendTemplateParameters(TemplateableElement templateableElement) {
		TemplateSignature templateSignature = templateableElement.getOwnedTemplateSignature();
		if (templateSignature != null) {
			List<TemplateParameter> templateParameters = templateSignature.getOwnedParameters();
			if (!templateParameters.isEmpty()) {
				s.append(TEMPLATE_SIGNATURE_PREFIX);
				String prefix = ""; //$NON-NLS-1$
				for (TemplateParameter templateParameter : templateParameters) {
					s.append(prefix);
					emittedTemplateParameter(templateParameter);
					appendName(templateParameter.getParameteredElement());
					prefix = TEMPLATE_SIGNATURE_SEPARATOR;
				}
				s.append(TEMPLATE_SIGNATURE_SUFFIX);
			}
		}
	}

	public void appendTupleType(Collection<? extends TypedElement> tupleParts) {
		List<TypedElement> parts = new ArrayList<TypedElement>(tupleParts);
		Collections.sort(parts, new Comparator<TypedElement>()
		{
			public int compare(TypedElement o1, TypedElement o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		append(TUPLE_SIGNATURE_PREFIX);
		String prefix = "";
		for (TypedElement part : parts) {
			append(prefix);
			appendName(part);
			append(TUPLE_SIGNATURE_TYPE_SEPARATOR);
			Type type = part.getType();
			if (type != null) {
				appendElement(type);
			}
			prefix = TUPLE_SIGNATURE_PART_SEPARATOR;
		}
		append(TUPLE_SIGNATURE_SUFFIX);
	}

	protected void emittedTemplateParameter(TemplateParameter templateParameter) {
		if (emittedParameters == null) {
			emittedParameters = new ArrayList<TemplateParameter>();
		}
		emittedParameters.add(templateParameter);
	}
	
	public boolean hasEmitted(TemplateParameter templateParameter) {
		return (emittedParameters != null) && emittedParameters.contains(templateParameter);
	}

/*	public boolean isTemplateParameter(TemplateParameter templateParameter) {
		for (EObject eObject = target; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof TemplateableElement) {
				TemplateSignature templateSignature = ((TemplateableElement)eObject).getOwnedTemplateSignature();
				if (templateSignature != null) {
					for (TemplateParameter targetTemplateParameter : templateSignature.getParameters()) {
						if (templateParameter == targetTemplateParameter) {
							return true;
						}
					}
				}
			}
		}
		return false;
	} */

	/**
	 * Return the length of the moniker so far.
	 */
	protected int length() {
		return s.length();
	}

	@Override
	public String toString() {
		return s.toString();
	}
}