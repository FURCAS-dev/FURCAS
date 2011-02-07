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
 * $Id: UML2PivotDeclarationSwitch.java,v 1.4 2011/01/30 11:17:26 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.uml;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreSwitch;
import org.eclipse.ocl.ecore.delegate.OCLDelegateDomain;
import org.eclipse.ocl.examples.pivot.Annotation;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.DataType;
import org.eclipse.ocl.examples.pivot.Detail;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Enumeration;
import org.eclipse.ocl.examples.pivot.EnumerationLiteral;
import org.eclipse.ocl.examples.pivot.OpaqueExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.PivotFactory;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.PrimitiveType;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.TemplateableElement;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypeTemplateParameter;
import org.eclipse.ocl.examples.pivot.utilities.PivotConstants;
import org.eclipse.uml2.uml.util.UMLSwitch;

public class UML2PivotDeclarationSwitch extends UMLSwitch<Object>
{
	public class EcoreUML2PivotDeclarationSwitch extends EcoreSwitch<Object>
	{
		@Override
		public Object caseEAnnotation(EAnnotation eObject) {
			Annotation pivotElement = PivotFactory.eINSTANCE.createAnnotation();
			pivotElement.setName(eObject.getSource());
			converter.setOriginalMapping(pivotElement, eObject);
			doSwitchAll(pivotElement.getOwnedContents(), eObject.getContents(), null);
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
		}

		@Override
		public Element defaultCase(EObject object) {
			converter.error("Unsupported " + object.eClass().getName() + " for EcoreUML2PivotDeclarationSwitch");
			return null;
		}

		public Object doInPackageSwitch(EObject eObject) {
			int classifierID = eObject.eClass().getClassifierID();
			return doSwitch(classifierID, eObject);
		}
	}
	
	protected final EcoreUML2PivotDeclarationSwitch ecoreSwitch = new EcoreUML2PivotDeclarationSwitch();
	protected final UML2Pivot converter;
	
	public UML2PivotDeclarationSwitch(UML2Pivot converter) {
		this.converter = converter;
	}
	
	@Override
	public Object caseAssociation(org.eclipse.uml2.uml.Association umlAssociation) {
		for (org.eclipse.uml2.uml.Property umlProperty : umlAssociation.getOwnedEnds()) {
			Property pivotElement = converter.refreshNamedElement(Property.class, PivotPackage.Literals.PROPERTY, umlProperty);
			converter.copyProperty(pivotElement, umlProperty, null);
			pivotElement.setImplicit(true);
			converter.queueReference(umlAssociation);				// For opposite installation
		}
		return this;
	}

	@Override
	public org.eclipse.ocl.examples.pivot.Class caseClass(org.eclipse.uml2.uml.Class umlClass) {
		org.eclipse.ocl.examples.pivot.Class pivotElement = converter.refreshNamedElement(org.eclipse.ocl.examples.pivot.Class.class, PivotPackage.Literals.CLASS, umlClass);
		copyClassifier(pivotElement, umlClass);
		pivotElement.setIsAbstract(umlClass.isAbstract());			
//		pivotElement.setIsInterface(umlClass.isInterface());			
//		doSwitchAll(umlClass.getSuperClasses());
		doSwitchAll(pivotElement.getOwnedOperations(), umlClass.getOperations(), null);
		doSwitchAll(pivotElement.getOwnedAttributes(), umlClass.getAttributes(), null);
		for (org.eclipse.uml2.uml.Classifier umlType : umlClass.getNestedClassifiers()) {
			doSwitch(umlType);
			Type pivotObject = (Type) doSwitch(umlType);
			if (pivotObject != null) {
				converter.getTypeManager().addOrphanType(pivotObject);
			}
		}
//		doSwitchAll(pivotElement.getOwnedTypes(), umlClass.getOwnedTypes(), null);
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
		doSwitchAll(pivotElement.getOwnedLiterals(), umlEnumeration.getOwnedLiterals(), null);
		return pivotElement;
	}

	@Override
	public EnumerationLiteral caseEnumerationLiteral(org.eclipse.uml2.uml.EnumerationLiteral umlEnumLiteral) {
		EnumerationLiteral pivotElement = converter.refreshNamedElement(EnumerationLiteral.class,
			PivotPackage.Literals.ENUMERATION_LITERAL, umlEnumLiteral);
		converter.copyNamedElement(pivotElement, umlEnumLiteral);
		converter.copyAnnotatedElement(pivotElement, umlEnumLiteral, null);
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
					specification.getLanguages().add(PivotConstants.OCL_LANGUAGE);
					constraint.setSpecification(specification);
//						constraint.setExprString(entry.getValue());
					constraints.add(constraint);
				}
			}				
		}
//		converter.copyTypedElement(pivotElement, umlOperation, excludedAnnotations);
		converter.copyNamedElement(pivotElement, umlOperation);
		converter.copyAnnotatedElement(pivotElement, umlOperation, excludedAnnotations);
//		converter.copyMultiplicityElement(pivotElement, umlOperation);
		doSwitchAll(pivotElement.getOwnedParameters(), umlOperation.getOwnedParameters(), null);
		copyTemplateSignature(pivotElement, umlOperation.getOwnedTemplateSignature());
//		doSwitchAll(umlOperation.getEGenericExceptions());
		converter.queueReference(umlOperation);				// For exceptions
		return pivotElement;
	}

	@Override
	public org.eclipse.ocl.examples.pivot.Package casePackage(org.eclipse.uml2.uml.Package umlPackage) {
		org.eclipse.ocl.examples.pivot.Package pivotElement = converter.refreshNamedElement(org.eclipse.ocl.examples.pivot.Package.class, PivotPackage.Literals.PACKAGE, umlPackage);
		EAnnotation eAnnotation = umlPackage.getEAnnotation(EcorePackage.eNS_URI);
		List<EAnnotation> exclusions = eAnnotation == null ? Collections.<EAnnotation>emptyList() : Collections.singletonList(eAnnotation);
		converter.copyNamedElement(pivotElement, umlPackage);
		converter.copyAnnotatedElement(pivotElement, umlPackage, exclusions);
//		if (umlPackage.eIsSet(EcorePackage.Literals.EPACKAGE__NS_PREFIX)) {
//			pivotElement.setNsPrefix(umlPackage.getNsPrefix());
//		}
//		if (umlPackage.eIsSet(EcorePackage.Literals.EPACKAGE__NS_URI)) {
//			pivotElement.setNsURI(umlPackage.getNsURI());
//		}
		doSwitchAll(pivotElement.getNestedPackages(), umlPackage.getNestedPackages(), null);
		doSwitchAll(pivotElement.getOwnedTypes(), umlPackage.getOwnedTypes(), new UML2Pivot.Predicate<org.eclipse.uml2.uml.Type>()
		{
			public boolean filter(org.eclipse.uml2.uml.Type element) {
				return !(element instanceof org.eclipse.uml2.uml.Association);
			}
		});
		return pivotElement;
	}

	@Override
	public Parameter caseParameter(org.eclipse.uml2.uml.Parameter eObject) {
		Parameter pivotElement = converter.refreshNamedElement(Parameter.class, PivotPackage.Literals.PARAMETER, eObject);
		converter.copyTypedElement(pivotElement, eObject, null);
		converter.copyMultiplicityElement(pivotElement, eObject);
		return pivotElement;
	}

	@Override
	public PrimitiveType casePrimitiveType(org.eclipse.uml2.uml.PrimitiveType umlPrimitiveType) {
		PrimitiveType pivotElement = converter.refreshNamedElement(PrimitiveType.class, PivotPackage.Literals.PRIMITIVE_TYPE, umlPrimitiveType);
		copyClassifier(pivotElement, umlPrimitiveType);
		return pivotElement;
	}

	@Override
	public Property caseProperty(org.eclipse.uml2.uml.Property umlProperty) {
		Property pivotElement = converter.refreshNamedElement(Property.class, PivotPackage.Literals.PROPERTY, umlProperty);
		converter.copyProperty(pivotElement, umlProperty, null);
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
				specification.getLanguages().add(PivotConstants.OCL_LANGUAGE);
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
		converter.copyNamedElement(pivotElement, umlClassifier);
		converter.copyAnnotatedElement(pivotElement, umlClassifier, excludedAnnotations);
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

	protected void copyTemplateSignature(TemplateableElement pivotElement, org.eclipse.uml2.uml.TemplateSignature umlTemplateSignature) {
		if (umlTemplateSignature != null) {
			List<org.eclipse.uml2.uml.TemplateParameter> umlTemplateParameters = umlTemplateSignature.getOwnedParameters();
			if (!umlTemplateParameters.isEmpty()) {
				TemplateSignature pivotTemplateSignature = PivotFactory.eINSTANCE.createTemplateSignature();
				pivotElement.setOwnedTemplateSignature(pivotTemplateSignature);
				doSwitchAll(pivotTemplateSignature.getOwnedParameters(), umlTemplateParameters, null);
			}
		}
	}

	@Override
	public Element defaultCase(EObject object) {
		converter.error("Unsupported " + object.eClass().getName() + " for UML2PivotDeclarationSwitch");
		return null;
	}

	public Object doInPackageSwitch(EObject eObject) {
		int classifierID = eObject.eClass().getClassifierID();
		return doSwitch(classifierID, eObject);
	}

	@Override
	public Object doSwitch(EObject eObject) {
		EClass eClass = eObject.eClass();
		EPackage ePackage = eClass.getEPackage();
		if (ePackage == EcorePackage.eINSTANCE) {
			return ecoreSwitch.doInPackageSwitch(eObject);
		}
		else {
			return doInPackageSwitch(eObject);
		}
	}

	public <T extends Element, V extends EObject> void doSwitchAll(Collection<T> pivotObjects, List<V> eObjects, UML2Pivot.Predicate<V> predicate) {
		for (V eObject : eObjects) {
			if ((predicate == null) || predicate.filter(eObject)) {
				@SuppressWarnings("unchecked")
				T pivotObject = (T) doSwitch(eObject);
				if (pivotObject != null) {
					pivotObjects.add(pivotObject);
				}
			}
		}
	}

	public <T extends Element> void doSwitchAll(List<? extends EObject> eObjects) {
		for (EObject eObject : eObjects) {
			doSwitch(eObject);
		}
	}
}