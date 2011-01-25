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
 * $Id: UML2Moniker.java,v 1.2 2011/01/24 20:47:53 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.uml;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.util.EcoreSwitch;
import org.eclipse.ocl.examples.pivot.utilities.AliasAdapter;
import org.eclipse.ocl.examples.pivot.utilities.PivotConstants;

/**
 * Ecore2Moniker supports generation of a hierarchically derived moniker for
 * an EModelElement. A moniker provides a unique repeatable readable id.
 */
public class UML2Moniker extends EcoreSwitch<Object> implements PivotConstants
{
	public static String toSignature(EModelElement eElement) {
		UML2Moniker moniker = new UML2Moniker(true);
		moniker.appendElement(eElement);
		return moniker.toString();
	}
	
	public static String toString(EModelElement eElement) {
		UML2Moniker moniker = new UML2Moniker(false);
		moniker.appendElement(eElement);
		return moniker.toString();
	}
	
	public static String toString(EGenericType eElement) {
		UML2Moniker moniker = new UML2Moniker(false);
		moniker.appendType(eElement);
		return moniker.toString();
	}
	
	/**
	 * Moiniker detail; false for minimal uniqueness (omit template bounds, template
	 * parameter declarations, parameter names), true to show everything.
	 * <p>
	 * Ecore models (unlike Pivot models) are mutable so the moniker is computed on
	 * demand and may change if a name on the hierarchical path changes.
	 */
	protected boolean fullSignature;	

	private StringBuffer s = new StringBuffer();
	private List<ETypeParameter> emittedParameters = null;
	
	protected UML2Moniker(boolean fullSignature) {
		this.fullSignature = fullSignature;
	}
	
	protected void append(String string) {
		s.append(string != null ? string : "null"); //$NON-NLS-1$
	}
	
	protected void appendBounds(List<? extends EGenericType> bounds) {
		String prefix = "";
		for (EGenericType bound : bounds) {
			s.append(prefix);
			prefix = "|";							// No example available
			EGenericType eLowerBound = bound.getELowerBound();
			if (eLowerBound != null) {
				s.append(" >= ");					// No example available
				appendType(eLowerBound);
			}
			EGenericType eUpperBound = bound.getEUpperBound();
			if (eUpperBound != null) {
				s.append(" <= ");					// No example available
				appendType(eUpperBound);
			}
			EClassifier eClassifier = bound.getEClassifier();
			if (eClassifier != null) {
				s.append(" extends ");
				appendType(bound);
			}
			else {
				assert bound.getETypeArguments().isEmpty();
				assert bound.getERawType() == null;
			}
			assert bound.getETypeParameter() == null;
		}
	}
	
	protected void appendElement(EModelElement eElement) {
		if (eElement != null) {
			int classifierID = eElement.eClass().getClassifierID();
			doSwitch(classifierID, eElement);
		}
	}

	protected Object doInPackageSwitch1(EModelElement theEObject) {
		int classifierID = theEObject.eClass().getClassifierID();
		return doSwitch(classifierID, theEObject);
	}

	protected void appendName(ENamedElement eNamedElement) {
		append(eNamedElement.getName());
	}
	
	protected void appendParameters(List<EParameter> parameters) {
		s.append(PARAMETER_PREFIX);
		String prefix = ""; //$NON-NLS-1$
		for (EParameter eParameter : parameters) {
			s.append(prefix);
			appendType(eParameter.getEGenericType());
			if (fullSignature) {
				s.append(":");
				s.append(eParameter.getName());
			}
			prefix = PARAMETER_SEPARATOR; //$NON-NLS-1$
		}
		s.append(PARAMETER_SUFFIX);
	}

	protected void appendParent(EObject eElement, String parentSeparator) {
		EObject parent = eElement != null ? eElement.eContainer() : null;
		if (parent instanceof EModelElement) {
			boolean wasFullSignature = fullSignature;
			fullSignature = false;
			appendElement((EModelElement) parent);
			fullSignature = wasFullSignature;
		}
		else if (parent instanceof EGenericType) {
			appendParent(parent, parentSeparator);
		}
		append(parentSeparator);
	}

	protected void appendType(EGenericType eGenericType) {
		ETypeParameter eTypeParameter = eGenericType.getETypeParameter();
		EClassifier eClassifier = eGenericType.getEClassifier();
		if (eClassifier != null) {
			append(eClassifier.getName());
			appendTypeArguments(eGenericType.getETypeArguments(), eClassifier.getETypeParameters());
		}
		else if (eTypeParameter != null){
			appendElement(eTypeParameter);
			assert eGenericType.getETypeArguments().size() == 0;
		}
		else {
			if (s.length() == 0) {
				appendParent(eGenericType, MONIKER_SCOPE_SEPARATOR);
			}
			append(WILDCARD_INDICATOR);
			assert eGenericType.getETypeArguments().size() == 0;
		}
	}

	protected void appendTypeArguments(List<EGenericType> eTypeArguments, List<ETypeParameter> eTypeParameters) {
		assert eTypeArguments.size() == eTypeParameters.size();
		if (!eTypeArguments.isEmpty()) {
			s.append(TEMPLATE_BINDING_PREFIX);
			String prefix = ""; //$NON-NLS-1$
			for (int i = 0; i < eTypeArguments.size(); i++) {
				s.append(prefix);
				appendType(eTypeArguments.get(i));
				if (fullSignature) {
					s.append(":");
					appendTypeParameter(eTypeParameters.get(i));
				}
				prefix = TEMPLATE_BINDING_SEPARATOR;
			}
			s.append(TEMPLATE_BINDING_SUFFIX);
		}
	}

	protected void appendTypeParameter(ETypeParameter eTypeParameter) {
		if (emittedParameters == null) {
			emittedParameters = new ArrayList<ETypeParameter>();
		}
		emittedParameters.add(eTypeParameter);
		appendName(eTypeParameter);
		if (fullSignature) {
			appendBounds(eTypeParameter.getEBounds());
		}
	}

	protected void appendTypeParameters(List<ETypeParameter> eTypeParameters) {
		if (!eTypeParameters.isEmpty()) {
			s.append(TEMPLATE_SIGNATURE_PREFIX);
			String prefix = ""; //$NON-NLS-1$
			for (ETypeParameter eTypeParameter : eTypeParameters) {
				s.append(prefix);
				appendTypeParameter(eTypeParameter);
				prefix = TEMPLATE_SIGNATURE_SEPARATOR;
			}
			s.append(TEMPLATE_SIGNATURE_SUFFIX);
		}
	}

	protected void appendTypes(List<EGenericType> eTypes) {
		String prefix = ""; //$NON-NLS-1$
		for (EGenericType eType : eTypes) {
			s.append(prefix);
			appendType(eType);
			prefix = TEMPLATE_SIGNATURE_SEPARATOR;
		}
	}

	@Override
	public Object caseEAnnotation(EAnnotation eElement) {
		appendParent(eElement, MONIKER_SCOPE_SEPARATOR);
		s.append("'");
		append(eElement.getSource());
		s.append("'");
		return true;
	}

	@Override
	public Object caseEClass(EClass eElement) {
		caseENamedElement(eElement);
		appendTypeParameters(eElement.getETypeParameters());
		return true;
	}

	@Override
	public Object caseENamedElement(ENamedElement eElement) {
		appendParent(eElement, MONIKER_SCOPE_SEPARATOR);
		appendName(eElement);
		return true;
	}

	@Override
	public Object caseEOperation(EOperation eElement) {
		caseENamedElement(eElement);
		appendTypeParameters(eElement.getETypeParameters());
		appendParameters(eElement.getEParameters());
		if (fullSignature) {
			List<EGenericType> eGenericExceptions = eElement.getEGenericExceptions();
			if (eGenericExceptions.size() > 0) {
				append(" throws ");
				appendTypes(eGenericExceptions);
			}
		}
		return true;
	}
	
	@Override
	public Object caseEPackage(EPackage eElement) {
		String alias = AliasAdapter.getAlias(eElement);
		if (alias != null) {
			append(alias);
			return true;
		}
		return caseENamedElement(eElement);
	}

	@Override
	public Object caseETypeParameter(ETypeParameter eElement) {
		if (!hasEmitted(eElement)) {
			if (toString().length() < MONIKER_OVERFLOW_LIMIT) {
				appendParent(eElement, MONIKER_SCOPE_SEPARATOR);
			}
			else {
				append(OVERFLOW_MARKER);
			}
		}
		appendName(eElement);
		return true;
	}

	protected boolean hasEmitted(ETypeParameter eTypeParameter) {
		return (emittedParameters != null) && emittedParameters.contains(eTypeParameter);
	}

	@Override
	public String toString() {
		return s.toString();
	}
}