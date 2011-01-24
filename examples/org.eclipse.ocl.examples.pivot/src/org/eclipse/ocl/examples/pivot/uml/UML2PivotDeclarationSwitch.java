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
 * $Id: UML2PivotDeclarationSwitch.java,v 1.2 2011/01/24 20:47:53 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.uml;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.ocl.ecore.delegate.OCLDelegateDomain;
import org.eclipse.ocl.examples.pivot.Annotation;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.DataType;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Enumeration;
import org.eclipse.ocl.examples.pivot.EnumerationLiteral;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.OpaqueExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.TemplateableElement;
import org.eclipse.ocl.examples.pivot.TypeTemplateParameter;
import org.eclipse.ocl.examples.pivot.TypedMultiplicityElement;
import org.eclipse.ocl.examples.pivot.utilities.PivotObjectImpl;
import org.eclipse.uml2.uml.TemplateParameter;
import org.eclipse.uml2.uml.util.UMLSwitch;

public class UML2PivotDeclarationSwitch extends UMLSwitch<Object>
{
	protected final UML2Pivot converter;
	
	public UML2PivotDeclarationSwitch(UML2Pivot converter) {
		this.converter = converter;
	}
	
/*	@Override
	public Annotation caseEAnnotation(EAnnotation eObject) {
		Annotation pivotElement = PivotFactory.eINSTANCE.createAnnotation();
		pivotElement.setName(eObject.getSource());
		setOriginalMapping(pivotElement, eObject);
		doSwitchAll(pivotElement.getOwnedContents(), eObject.getContents());
		EMap<String, String> details = eObject.getDetails();
		for (Map.Entry<String, String> entry : details) {
			String key = entry.getKey();
			Detail pivotDetail = PivotFactory.eINSTANCE.createDetail();
			pivotDetail.setName(key);
			pivotDetail.getValues().add(entry.getValue());
			pivotElement.getOwnedDetails().add(pivotDetail);	// FIXME refreshList
		}
		if (!eObject.getReferences().isEmpty()) {
			converter.queueReference(eObject);
		}
		return pivotElement;
	} */

	@Override
	public org.eclipse.ocl.examples.pivot.Class caseClass(org.eclipse.uml2.uml.Class umlClass) {
		org.eclipse.ocl.examples.pivot.Class pivotElement = converter.refreshNamedElement(org.eclipse.ocl.examples.pivot.Class.class, PivotPackage.Literals.CLASS, umlClass);
		copyClassifier(pivotElement, umlClass);
		pivotElement.setIsAbstract(umlClass.isAbstract());			
//		pivotElement.setIsInterface(umlClass.isInterface());			
		doSwitchAll(umlClass.getSuperClasses());
		doSwitchAll(pivotElement.getOwnedOperations(), umlClass.getOperations());
		doSwitchAll(pivotElement.getOwnedAttributes(), umlClass.getAttributes());
		converter.queueReference(umlClass);				// For superclasses
		return pivotElement;
	}

	@Override
	public Object caseClassifierTemplateParameter(org.eclipse.uml2.uml.ClassifierTemplateParameter umlTemplateParameter) {
		org.eclipse.uml2.uml.Class umlParameterClass = (org.eclipse.uml2.uml.Class) umlTemplateParameter.getParameteredElement();
		org.eclipse.ocl.examples.pivot.Class pivotElement = converter.refreshNamedElement(org.eclipse.ocl.examples.pivot.Class.class, PivotPackage.Literals.CLASS, umlParameterClass);
//		TypeTemplateParameter pivotTemplateParameter = converter.refreshNamedElement(org.eclipse.ocl.examples.pivot.Class.class, PivotPackage.Literals.CLASS, umlTemplateParameter);
//		setOriginalMapping(pivotElement, umlTemplateParameter);
//		String name = umlTemplateParameter.getName();
//		pivotElement.setName(name);
		TypeTemplateParameter typeTemplateParameter = (TypeTemplateParameter) pivotElement.getTemplateParameter();
		if (typeTemplateParameter == null) {
			typeTemplateParameter = PivotFactory.eINSTANCE.createTypeTemplateParameter();
			typeTemplateParameter.setOwnedParameteredElement(pivotElement);
		}
//		List<EGenericType> eBounds = umlTemplateParameter.getEBounds();
//		if (!eBounds.isEmpty()) {
//			doSwitchAll(eBounds);
//			converter.queueReference(umlTemplateParameter);
//		}
		return typeTemplateParameter;
	}

	@Override
	public DataType caseDataType(org.eclipse.uml2.uml.DataType umlDataType) {
		DataType pivotElement = converter.refreshNamedElement(DataType.class, PivotPackage.Literals.DATA_TYPE, umlDataType);
		copyDataTypeOrEnum(pivotElement, umlDataType);
		return pivotElement;
	}

	@Override
	public Enumeration caseEnumeration(org.eclipse.uml2.uml.Enumeration umlEnumeration) {
		Enumeration pivotElement = converter.refreshNamedElement(Enumeration.class, PivotPackage.Literals.ENUMERATION, umlEnumeration);
		copyDataTypeOrEnum(pivotElement, umlEnumeration);
		doSwitchAll(pivotElement.getOwnedLiterals(), umlEnumeration.getOwnedLiterals());
		return pivotElement;
	}

	@Override
	public EnumerationLiteral caseEnumerationLiteral(org.eclipse.uml2.uml.EnumerationLiteral umlEnumLiteral) {
		EnumerationLiteral pivotElement = converter.refreshNamedElement(EnumerationLiteral.class,
			PivotPackage.Literals.ENUMERATION_LITERAL, umlEnumLiteral);
		copyNamedElement(pivotElement, umlEnumLiteral);
		copyAnnotatedElement(pivotElement, umlEnumLiteral, null);
//		if (eEnumLiteral.eIsSet(EcorePackage.Literals.EENUM_LITERAL__VALUE)) {
//			pivotElement.setValue(BigInteger.valueOf(eEnumLiteral.getValue()));
//		}
//		else {
//			pivotElement.eUnset(PivotPackage.Literals.ENUMERATION_LITERAL__VALUE);
//		}
//			String literal = basicGet(eObject, EcorePackage.Literals.EENUM_LITERAL__LITERAL, String.class);
//			Enumerator instance = eEnumLiteral.getInstance();
//			if (literal != null) {
/*				AnnotationCS csAnnotation = PivotFactory.eINSTANCE.createAnnotationCS();
				csAnnotation.setIdSource(EcorePackage.eNS_URI);
				DetailCS csDetail = PivotFactory.eINSTANCE.createDetailCS();
				csDetail.setIdName("literal");
				copyDetailLines(csDetail.getValue(), literal);
				csAnnotation.getDetails().add(csDetail);
				pivotElement.getAnnotations().add(csAnnotation); */
//			}
		return pivotElement;
	}

	@Override
	public Operation caseOperation(org.eclipse.uml2.uml.Operation umlOperation) {
		Operation pivotElement = converter.refreshNamedElement(Operation.class, PivotPackage.Literals.OPERATION, umlOperation);
		List<EAnnotation> excludedAnnotations =  null;
		EAnnotation oclAnnotation = umlOperation.getEAnnotation(OCLDelegateDomain.OCL_DELEGATE_URI);
		if (oclAnnotation != null) {
			excludedAnnotations = new ArrayList<EAnnotation>();
			excludedAnnotations.add(oclAnnotation);
			List<Constraint> constraints = pivotElement.getOwnedRules();
			for (Map.Entry<String,String> entry : oclAnnotation.getDetails().entrySet()) {
				Constraint constraint = PivotFactory.eINSTANCE.createConstraint();
				String key = entry.getKey();
				if (key.equals("body")) {
					constraint.setStereotype("body");
				}
				else if (key.startsWith("body_")) {
					constraint.setStereotype("body");
					constraint.setName(key.substring(5));
				}
				else if (key.equals("pre")) {
					constraint.setStereotype("precondition");
				}
				else if (key.startsWith("pre_")) {
					constraint.setStereotype("precondition");
					constraint.setName(key.substring(4));
				}
				else if (key.equals("post")) {
					constraint.setStereotype("postcondition");
				}
				else if (key.startsWith("post_")) {
					constraint.setStereotype("postcondition");
					constraint.setName(key.substring(5));
				}
				else
				{
					converter.error("Unsupported operation constraint " + key);
					constraint = null;
				}
				if (constraint != null) {
					String value = entry.getValue();
					OpaqueExpression specification = PivotFactory.eINSTANCE.createOpaqueExpression();	// FIXME ExpressionInOcl
					specification.getBodies().add(value);
					constraint.setSpecification(specification);
//						constraint.setExprString(entry.getValue());
					constraints.add(constraint);
				}
			}				
		}
//		copyTypedElement(pivotElement, umlOperation, excludedAnnotations);
//		copyMultiplicityElement(pivotElement, umlOperation);
		doSwitchAll(pivotElement.getOwnedParameters(), umlOperation.getOwnedParameters());
		copyTemplateSignature(pivotElement, umlOperation.getOwnedTemplateSignature());
//		doSwitchAll(umlOperation.getEGenericExceptions());
		converter.queueReference(umlOperation);				// For superclasses
		return pivotElement;
	}

	@Override
	public org.eclipse.ocl.examples.pivot.Package casePackage(org.eclipse.uml2.uml.Package umlPackage) {
		org.eclipse.ocl.examples.pivot.Package pivotElement = converter.refreshNamedElement(org.eclipse.ocl.examples.pivot.Package.class, PivotPackage.Literals.PACKAGE, umlPackage);
		EAnnotation eAnnotation = umlPackage.getEAnnotation(EcorePackage.eNS_URI);
		List<EAnnotation> exclusions = eAnnotation == null ? Collections.<EAnnotation>emptyList() : Collections.singletonList(eAnnotation);
		copyNamedElement(pivotElement, umlPackage);
		copyAnnotatedElement(pivotElement, umlPackage, exclusions);
//		if (umlPackage.eIsSet(EcorePackage.Literals.EPACKAGE__NS_PREFIX)) {
//			pivotElement.setNsPrefix(umlPackage.getNsPrefix());
//		}
//		if (umlPackage.eIsSet(EcorePackage.Literals.EPACKAGE__NS_URI)) {
//			pivotElement.setNsURI(umlPackage.getNsURI());
//		}
		doSwitchAll(pivotElement.getNestedPackages(), umlPackage.getNestedPackages());
		doSwitchAll(pivotElement.getOwnedTypes(), umlPackage.getOwnedTypes());
		return pivotElement;
	}

	@Override
	public Parameter caseParameter(org.eclipse.uml2.uml.Parameter eObject) {
		Parameter pivotElement = converter.refreshNamedElement(Parameter.class, PivotPackage.Literals.PARAMETER, eObject);
		copyTypedElement(pivotElement, eObject, null);
		copyMultiplicityElement(pivotElement, eObject);
		return pivotElement;
	}

	@Override
	public Property caseProperty(org.eclipse.uml2.uml.Property umlProperty) {
		Property pivotElement = converter.refreshNamedElement(Property.class, PivotPackage.Literals.PROPERTY, umlProperty);
		copyProperty(pivotElement, umlProperty, null);
		pivotElement.setIsComposite(umlProperty.isComposite());			
//		pivotElement.setIsID(umlProperty.isID());			
//		pivotElement.setIsResolveProxies(umlProperty.isResolveProxies());			
//		if ((umlProperty.getOpposite() != null) || (excludedAnnotations != null) || !umlProperty.getEKeys().isEmpty()) {
		if (umlProperty.getOpposite() != null) {
			converter.queueReference(umlProperty);	// Defer
		}
		return pivotElement;
	}

	protected void copyClassifier(org.eclipse.ocl.examples.pivot.Class pivotElement, org.eclipse.uml2.uml.Classifier umlClassifier) {
		List<EAnnotation> excludedAnnotations =  null;
		EMap<String, String> oclAnnotationDetails = null;
		EAnnotation oclAnnotation = umlClassifier.getEAnnotation(OCLDelegateDomain.OCL_DELEGATE_URI);
		if (oclAnnotation != null) {
			excludedAnnotations = new ArrayList<EAnnotation>();
			excludedAnnotations.add(oclAnnotation);
			List<Constraint> constraints = pivotElement.getOwnedRules();
			oclAnnotationDetails = oclAnnotation.getDetails();
			for (Map.Entry<String,String> entry : oclAnnotationDetails.entrySet()) {
				Constraint constraint = PivotFactory.eINSTANCE.createConstraint();
				constraint.setStereotype("invariant");
				constraint.setName(entry.getKey());
				String value = entry.getValue();
				OpaqueExpression specification = PivotFactory.eINSTANCE.createOpaqueExpression();	// FIXME ExpressionInOcl
				specification.getBodies().add(value);
				constraint.setSpecification(specification);
				constraints.add(constraint);
			}				
		}
		EAnnotation ecoreAnnotation = umlClassifier.getEAnnotation(EcorePackage.eNS_URI);
		if (ecoreAnnotation != null) {
			if (excludedAnnotations == null) {
				excludedAnnotations = new ArrayList<EAnnotation>();
			}
			excludedAnnotations.add(ecoreAnnotation);
			String constraintNameList = ecoreAnnotation.getDetails().get("constraints");
			if (constraintNameList != null) {
				List<Constraint> constraints = pivotElement.getOwnedRules();
				String[] constraintNames = constraintNameList.split(" ");
				for (String constraintName : constraintNames) {
					if ((oclAnnotationDetails == null) || (oclAnnotationDetails.get(constraintName) == null)) {
						Constraint constraint = PivotFactory.eINSTANCE.createConstraint();
						constraint.setStereotype("invariant");
						constraint.setName(constraintName);
						OpaqueExpression specification = PivotFactory.eINSTANCE.createOpaqueExpression();
						constraint.setSpecification(specification);
						constraints.add(constraint);
					}
				}
			}
		}
		copyNamedElement(pivotElement, umlClassifier);
		copyAnnotatedElement(pivotElement, umlClassifier, excludedAnnotations);
//		if (umlClassifier.eIsSet(EcorePackage.Literals.ECLASSIFIER__INSTANCE_CLASS_NAME)) {
//			pivotElement.setInstanceClassName(umlClassifier.getInstanceClassName());
//		}
//		else {
//			pivotElement.eUnset(PivotPackage.Literals.TYPE__INSTANCE_CLASS_NAME);
//		}
		copyTemplateSignature(pivotElement, umlClassifier.getOwnedTemplateSignature());
	}

	protected void copyDataTypeOrEnum(DataType pivotElement, org.eclipse.uml2.uml.DataType umlDataType) {
		copyClassifier(pivotElement, umlDataType);
//		pivotElement.setIsSerializable(umlDataType.isSerializable());
	}

/*		public void copyDetailLines(List<String> lines, String value) {
			String[] splitLines = value.split("\n");
			for (int i = 0; i < splitLines.length-1; i++) {
				lines.add(splitLines[i] + '\n');
			}
			if (splitLines.length > 0) {
				lines.add(splitLines[splitLines.length-1]);
			}
		} */

	protected void copyModelElement(Element pivotElement, EModelElement eModelElement) {
		setOriginalMapping(pivotElement, eModelElement);
	}

	protected void copyTemplateSignature(TemplateableElement pivotElement, org.eclipse.uml2.uml.TemplateSignature umlTemplateSignature) {
		EList<TemplateParameter> umlTemplateParameters = umlTemplateSignature.getOwnedParameters();
		if (!umlTemplateParameters.isEmpty()) {
			TemplateSignature pivotTemplateSignature = PivotFactory.eINSTANCE.createTemplateSignature();
			pivotElement.setOwnedTemplateSignature(pivotTemplateSignature);
			doSwitchAll(pivotTemplateSignature.getOwnedParameters(), umlTemplateParameters);
		}
	}

	protected void copyAnnotatedElement(NamedElement pivotElement,
			EModelElement eModelElement, List<EAnnotation> excludedAnnotations) {
		List<Annotation> pivotAnnotations = pivotElement.getOwnedAnnotations();
		for (EAnnotation eAnnotation : eModelElement.getEAnnotations()) {
			if ((excludedAnnotations == null) || !excludedAnnotations.contains(eAnnotation)) {
				Annotation pivotAnnotation = (Annotation) doSwitch(eAnnotation);
				pivotAnnotations.add(pivotAnnotation);
			}
		}
	}

	protected void copyMultiplicityElement(TypedMultiplicityElement pivotElement, org.eclipse.uml2.uml.MultiplicityElement umlMultiplicityElement) {
		int lower = umlMultiplicityElement.getLower();
		int upper = umlMultiplicityElement.getUpper();
		pivotElement.setLower(BigInteger.valueOf(lower));
		pivotElement.setUpper(BigInteger.valueOf(upper));
		pivotElement.setIsOrdered(umlMultiplicityElement.isOrdered());			
		pivotElement.setIsUnique(umlMultiplicityElement.isUnique());			
	}

	protected void copyNamedElement(NamedElement pivotElement, org.eclipse.uml2.uml.NamedElement umlNamedElement) {
		copyModelElement(pivotElement, umlNamedElement);
		String name = umlNamedElement.getName();
		pivotElement.setName(name);
	}

	protected void copyProperty(Property pivotElement, org.eclipse.uml2.uml.Property umlProperty, List<EAnnotation> excludedAnnotations) {
		EAnnotation oclAnnotation = umlProperty.getEAnnotation(OCLDelegateDomain.OCL_DELEGATE_URI);
		if (oclAnnotation != null) {
			excludedAnnotations = new ArrayList<EAnnotation>();
			excludedAnnotations.add(oclAnnotation);
			List<Constraint> constraints = pivotElement.getOwnedRules();
			for (Map.Entry<String,String> entry : oclAnnotation.getDetails().entrySet()) {
				Constraint constraint = PivotFactory.eINSTANCE.createConstraint();
				String key = entry.getKey();
				if (key.equals("derivation")) {
					constraint.setStereotype("derivation");
				}
				else if (key.equals("initial")) {
					constraint.setStereotype("initial");
				}
				else
				{
					converter.error("Unsupported feature constraint " + key);
					constraint = null;
				}
				if (constraint != null) {
					String value = entry.getValue();
					OpaqueExpression specification = PivotFactory.eINSTANCE.createOpaqueExpression();	// FIXME ExpressionInOcl
					specification.getBodies().add(value);
					constraint.setSpecification(specification);
//						constraint.setExprString(entry.getValue());
					constraints.add(constraint);
				}
			}				
		}
		copyTypedElement(pivotElement, umlProperty, excludedAnnotations);
		copyMultiplicityElement(pivotElement, umlProperty);
		pivotElement.setIsReadOnly(umlProperty.isReadOnly());			
		pivotElement.setIsDerived(umlProperty.isDerived());			
//		pivotElement.setIsTransient(umlProperty.isTransient());			
//		pivotElement.setIsUnsettable(umlProperty.isUnsettable());			
//		pivotElement.setIsVolatile(umlProperty.isVolatile());			
//		if (umlProperty.eIsSet(EcorePackage.Literals.ESTRUCTURAL_FEATURE__DEFAULT_VALUE_LITERAL)) {
//			pivotElement.setDefault(eObject.getDefaultValueLiteral());
//		}
//		else {
//			pivotElement.eUnset(PivotPackage.Literals.PROPERTY__DEFAULT);
//		}
	}

	protected void copyTypedElement(TypedMultiplicityElement pivotElement, org.eclipse.uml2.uml.TypedElement umlTypedElement, List<EAnnotation> excludedAnnotations) {
		copyNamedElement(pivotElement, umlTypedElement);
		copyAnnotatedElement(pivotElement, umlTypedElement, excludedAnnotations);
		org.eclipse.uml2.uml.Type umlType = umlTypedElement.getType();
		if (umlType != null) {
			doInPackageSwitch(umlType);
			converter.queueReference(umlTypedElement);
		}
	}

	@Override
	public Element defaultCase(EObject object) {
		converter.error("Unsupported " + object + " in pass1");
		return null;
	}

	public Object doInPackageSwitch(EObject eObject) {
		int classifierID = eObject.eClass().getClassifierID();
		return doSwitch(classifierID, eObject);
	}

	public <T extends Element> void doSwitchAll(Collection<T> csObjects, List<? extends EObject> eObjects) {
		for (EObject eObject : eObjects) {
			@SuppressWarnings("unchecked")
			T csObject = (T) doSwitch(eObject);
			csObjects.add(csObject);
		}
	}

	public <T extends Element> void doSwitchAll(List<? extends EObject> eObjects) {
		for (EObject eObject : eObjects) {
			doSwitch(eObject);
		}
	}

	protected void setOriginalMapping(Element pivotElement, EObject eObject) {
		((PivotObjectImpl)pivotElement).setTarget(eObject);
/*			csModelElement.setOriginalObject(eModelElement);
			if (ecoreResource instanceof XMLResource) {
				String xmiId = ((XMLResource)ecoreResource).getID(eModelElement);
				if (xmiId != null) {
					csModelElement.setOriginalXmiId(xmiId);
				}
			} */
		converter.addCreated(eObject, pivotElement);
	}
}