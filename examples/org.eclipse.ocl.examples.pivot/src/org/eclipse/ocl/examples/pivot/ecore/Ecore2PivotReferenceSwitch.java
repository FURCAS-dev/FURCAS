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
 * $Id: Ecore2PivotReferenceSwitch.java,v 1.2 2011/01/24 20:47:51 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.ecore;

import java.math.BigInteger;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.util.EcoreSwitch;
import org.eclipse.emf.ecore.xmi.impl.EMOFExtendedMetaData;
import org.eclipse.ocl.examples.pivot.Annotation;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypeTemplateParameter;
import org.eclipse.ocl.examples.pivot.TypedElement;

public class Ecore2PivotReferenceSwitch extends EcoreSwitch<Object>
{				
    /**
     * The key that identifies opposite role names in an annotation
     */
    public static final String PROPERTY_OPPOSITE_ROLE_NAME_KEY = "Property.oppositeRoleName"; //$NON-NLS-1$
    public static final Object PROPERTY_OPPOSITE_ROLE_UNIQUE_KEY = "Property.oppositeUnique"; //$NON-NLS-1$
    public static final Object PROPERTY_OPPOSITE_ROLE_ORDERED_KEY = "Property.oppositeOrdered"; //$NON-NLS-1$
    public static final Object PROPERTY_OPPOSITE_ROLE_LOWER_KEY = "Property.oppositeLower"; //$NON-NLS-1$
    public static final Object PROPERTY_OPPOSITE_ROLE_UPPER_KEY = "Property.oppositeUpper"; //$NON-NLS-1$

    protected final Ecore2Pivot converter;
	
	public Ecore2PivotReferenceSwitch(Ecore2Pivot converter) {
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
		else {
			EAnnotation oppositeRole = eObject.getEAnnotation(EMOFExtendedMetaData.EMOF_PACKAGE_NS_URI_2_0);
			if (oppositeRole != null) {
				EMap<String, String> details = oppositeRole.getDetails();
				String oppositeName = details.get(PROPERTY_OPPOSITE_ROLE_NAME_KEY);
				if (oppositeName != null) {
					Property pivotOpposite = PivotFactory.eINSTANCE.createProperty();
					pivotOpposite.setName(oppositeName);
					org.eclipse.ocl.examples.pivot.Class remoteType = (org.eclipse.ocl.examples.pivot.Class)pivotElement.getType();
					Type localType = pivotElement.getFeaturingClass();
					pivotOpposite.setType(localType);
					String uniqueValue = details.get(PROPERTY_OPPOSITE_ROLE_UNIQUE_KEY);
					if (uniqueValue != null) {
						pivotOpposite.setIsUnique(Boolean.valueOf(uniqueValue));
					}
					String orderedValue = details.get(PROPERTY_OPPOSITE_ROLE_ORDERED_KEY);
					if (orderedValue != null) {
						pivotOpposite.setIsOrdered(Boolean.valueOf(orderedValue));
					}
					String lowerValue = details.get(PROPERTY_OPPOSITE_ROLE_LOWER_KEY);
					if (lowerValue != null) {
						pivotOpposite.setLower(new BigInteger(lowerValue));
					}
					String upperValue = details.get(PROPERTY_OPPOSITE_ROLE_UPPER_KEY);
					if (upperValue != null) {
						pivotOpposite.setUpper(new BigInteger(upperValue));
					}
					remoteType.getOwnedAttributes().add(pivotOpposite);
				}
			}
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