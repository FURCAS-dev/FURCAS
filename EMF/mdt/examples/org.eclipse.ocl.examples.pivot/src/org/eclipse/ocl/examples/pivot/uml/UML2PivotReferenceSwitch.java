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
 * $Id: UML2PivotReferenceSwitch.java,v 1.2 2011/01/24 20:47:53 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.uml;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.util.EcoreSwitch;
import org.eclipse.ocl.examples.pivot.Annotation;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypeTemplateParameter;
import org.eclipse.ocl.examples.pivot.TypedElement;

public class UML2PivotReferenceSwitch extends EcoreSwitch<Object>
{				
	protected final UML2Pivot converter;
	
	public UML2PivotReferenceSwitch(UML2Pivot converter) {
		this.converter = converter;
	}
	
	@Override
	public Object caseEAnnotation(EAnnotation eObject) {
		Annotation pivotElement = converter.getCreated(Annotation.class, eObject);
		doSwitchAll(Element.class, pivotElement.getReferences(), eObject.getReferences());
		return null;
	}

	@Override
	public Object caseEClass(EClass eObject) {
		org.eclipse.ocl.examples.pivot.Class pivotElement = converter.getCreated(org.eclipse.ocl.examples.pivot.Class.class, eObject);
		doSwitchAll(org.eclipse.ocl.examples.pivot.Class.class, pivotElement.getSuperClasses(), eObject.getEGenericSuperTypes());
		return null;
	}

	@Override
	public Object caseEOperation(EOperation eObject) {
		Operation pivotElement = converter.getCreated(Operation.class, eObject);
		doSwitchAll(Type.class, pivotElement.getRaisedExceptions(), eObject.getEGenericExceptions());
		return null;
	}

	@Override
	public Object caseEReference(EReference eObject) {
		Property pivotElement = converter.getCreated(Property.class, eObject);
		Property oppositeProperty = null;
		EReference eOpposite = eObject.getEOpposite();
		if (eOpposite != null) {
			oppositeProperty = converter.getCreated(Property.class, eOpposite);
		}
		pivotElement.setOpposite(oppositeProperty);
		doSwitchAll(Property.class, pivotElement.getKeys(), eObject.getEKeys());
		return super.caseETypedElement(eObject);
	}

	@Override
	public EObject caseETypedElement(ETypedElement eObject) {
		TypedElement pivotElement = converter.getCreated(TypedElement.class, eObject);
		EGenericType eType = eObject.getEGenericType();
		if (eType != null) {
			Type pivotType = converter.getPivotType(eType);
			pivotElement.setType(pivotType);
		}
		else {
			// FIXME Void ???
		}
/*		EClassifier eClassifier = eGenericType.getEClassifier();
			if (eClassifier != null) {
				allEClassifiers.add(eClassifier);
				ClassifierCS csClassifier = getCS(eClassifier, ClassifierCS.class);
				csTypeRef.setType(csClassifier);
			}
			else {
				ETypeParameter eTypeParameter = eGenericType.getETypeParameter();
				if (eTypeParameter != null) {
					TypeParameterCS csTypeParameter = (TypeParameterCS) createMap.get(eTypeParameter);
					csTypeRef.setType(csTypeParameter);
				}
//				else {
//					error("Unresolved " + eGenericType + " in pass2");
//				}
			} */
		return null;
	}

	@Override
	public Object caseETypeParameter(ETypeParameter eObject) {
		org.eclipse.ocl.examples.pivot.Class pivotElement = converter.getCreated(org.eclipse.ocl.examples.pivot.Class.class, eObject);
		TypeTemplateParameter typeTemplateParameter = (TypeTemplateParameter) pivotElement.getTemplateParameter();
		doSwitchAll(Type.class, typeTemplateParameter.getConstrainingTypes(), eObject.getEBounds());
		return null;
	}

	public Object doInPackageSwitch(EObject eObject) {
		int classifierID = eObject.eClass().getClassifierID();
		return doSwitch(classifierID, eObject);
	}

	public <T extends Element> void doSwitchAll(Class<T> pivotClass, Collection<T> pivotElements, List<? extends EObject> eObjects) {
		for (EObject eObject : eObjects) {
			T pivotElement = converter.getCreated(pivotClass, eObject);
			pivotElements.add(pivotElement);
		}
	}
}