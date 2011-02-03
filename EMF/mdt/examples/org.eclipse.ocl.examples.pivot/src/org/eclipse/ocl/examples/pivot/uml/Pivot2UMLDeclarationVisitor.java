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
 * $Id: Pivot2UMLDeclarationVisitor.java,v 1.3 2011/01/27 07:02:06 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.uml;

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.ocl.examples.common.utils.StringUtils;
import org.eclipse.ocl.examples.pivot.Annotation;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.DataType;
import org.eclipse.ocl.examples.pivot.Detail;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Enumeration;
import org.eclipse.ocl.examples.pivot.EnumerationLiteral;
import org.eclipse.ocl.examples.pivot.MonikeredElement;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.OpaqueExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Package;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.PrimitiveType;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypeTemplateParameter;
import org.eclipse.ocl.examples.pivot.TypedMultiplicityElement;
import org.eclipse.ocl.examples.pivot.ValueSpecification;
import org.eclipse.ocl.examples.pivot.util.AbstractExtendingVisitor;
import org.eclipse.ocl.examples.pivot.util.Visitable;
import org.eclipse.uml2.uml.ParameterableElement;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

public class Pivot2UMLDeclarationVisitor
	extends AbstractExtendingVisitor<EModelElement, Pivot2UML>
{
	public static final Logger logger = Logger.getLogger(Pivot2UMLDeclarationVisitor.class);

	public Pivot2UMLDeclarationVisitor(Pivot2UML context) {
		super(context);
	}

	protected void copyClassifier(org.eclipse.uml2.uml.Classifier umlClassifier, Type pivotType) {
		copyNamedElement(umlClassifier, pivotType);
		TemplateSignature pivotTemplateSignature = pivotType.getOwnedTemplateSignature();
		if (pivotTemplateSignature != null) {
			umlClassifier.setOwnedTemplateSignature((org.eclipse.uml2.uml.TemplateSignature)safeVisit(pivotTemplateSignature));
		}
		safeVisitAll(umlClassifier.getEAnnotations(), pivotType.getOwnedAnnotations());
//		if (pivotType.eIsSet(PivotPackage.Literals.TYPE__INSTANCE_CLASS_NAME)) {
//			umlClassifier.setInstanceClassName(pivotType.getInstanceClassName());
//		}
//		else {
//			umlClassifier.eUnset(UMLPackage.Literals.ECLASSIFIER__INSTANCE_CLASS_NAME);
//		}
//		visitAll(eClassifier.getETypeParameters(), pivotType.getTypeParameters());
		StringBuffer s = null;
		for (Constraint pivotConstraint : pivotType.getOwnedRules()) {
			safeVisit(pivotConstraint);		// Results are inserted directly
			if (s == null) {
				s = new StringBuffer();
			}
			else {
				s.append(" ");
			}
			s.append(pivotConstraint.getName());
		}
/*		EAnnotation eAnnotation = umlClassifier.getEAnnotation(UMLPackage.eNS_URI);
		if (s != null) {
			if (eAnnotation == null) {
				eAnnotation = UMLFactory.eINSTANCE.createEAnnotation();
				eAnnotation.setSource(UMLPackage.eNS_URI);
				umlClassifier.getEAnnotations().add(0, eAnnotation);
			}
			eAnnotation.getDetails().put("constraints", s.toString());
		}
		else {
			umlClassifier.getEAnnotations().remove(eAnnotation);
		} */
	}

	protected void copyDataTypeOrEnum(org.eclipse.uml2.uml.DataType umlDataType, DataType pivotDataType) {
		copyClassifier(umlDataType, pivotDataType);
//		umlDataType.setSerializable(pivotDataType.isSerializable());
	}

	protected void copyDetails(EAnnotation umlAnnotation, Annotation pivotAnnotation) {
		copyModelElement(umlAnnotation, pivotAnnotation);
		safeVisitAll(umlAnnotation.getEAnnotations(), pivotAnnotation.getOwnedAnnotations());
		for (Detail pivotDetail : pivotAnnotation.getOwnedDetails()) {
			String name = pivotDetail.getName();
			String value = StringUtils.splice(pivotDetail.getValues(), "");
			umlAnnotation.getDetails().put(name, value);
		}
	}

	protected void copyModelElement(EModelElement umlElement, MonikeredElement pivotModelElement) {
		context.putCreated(pivotModelElement, umlElement);
	}

	protected void copyMultiplicityElement(org.eclipse.uml2.uml.MultiplicityElement umlMultiplicityElement, TypedMultiplicityElement pivotTypedElement) {
		Integer lower = pivotTypedElement.getLower().intValue();
		if (lower.equals(UMLPackage.Literals.MULTIPLICITY_ELEMENT__LOWER.getDefaultValue())) {
//			umlMultiplicityElement.eUnset(UMLPackage.Literals.MULTIPLICITY_ELEMENT__LOWER);
		}
		else {
			umlMultiplicityElement.setLower(lower);
		}
		Integer upper = pivotTypedElement.getUpper().intValue();
		if (upper.equals(UMLPackage.Literals.MULTIPLICITY_ELEMENT__UPPER.getDefaultValue())) {
//			umlMultiplicityElement.eUnset(UMLPackage.Literals.MULTIPLICITY_ELEMENT__UPPER);
		}
		else {
			umlMultiplicityElement.setUpper(upper);
		}
		umlMultiplicityElement.setIsUnique(pivotTypedElement.isUnique());
		umlMultiplicityElement.setIsOrdered(pivotTypedElement.isOrdered());
	}

	protected void copyNamedElement(org.eclipse.uml2.uml.NamedElement umlNamedElement, NamedElement pivotNamedElement) {
		copyModelElement(umlNamedElement, pivotNamedElement);
		umlNamedElement.setName(pivotNamedElement.getName());
	}

	protected void copyTypedElement(org.eclipse.uml2.uml.TypedElement umlTypedElement, TypedMultiplicityElement pivotTypedElement) {
		copyNamedElement(umlTypedElement, pivotTypedElement);
//		safeVisitAll(umlTypedElement.getEAnnotations(), pivotTypedElement.getOwnedAnnotations());
		context.defer(pivotTypedElement);		// Defer type setting
	}

	public <T extends EObject> void safeVisitAll(List<T> eObjects, List<? extends Element> pivotObjects) {
		for (Element pivotObject : pivotObjects) {
			@SuppressWarnings("unchecked")
			T eObject = (T) safeVisit(pivotObject);
			if (eObject != null) {
				eObjects.add(eObject);
			}
			// else error
		}
	}

	public org.eclipse.uml2.uml.Element visiting(Visitable visitable) {
		logger.error("Unsupported " + visitable.eClass().getName() + " for " + getClass().getName());
		return null;
	}

	@Override
	public EAnnotation visitAnnotation(Annotation pivotAnnotation) {
		EAnnotation umlAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
		copyDetails(umlAnnotation, pivotAnnotation);
		umlAnnotation.setSource(pivotAnnotation.getName());
		safeVisitAll(umlAnnotation.getContents(), pivotAnnotation.getOwnedContents());
		if (!pivotAnnotation.getReferences().isEmpty()) {
			context.defer(pivotAnnotation);
		}
		return umlAnnotation;
	}

	@Override
	public org.eclipse.uml2.uml.Class visitClass(org.eclipse.ocl.examples.pivot.Class pivotClass) {
		if (pivotClass.getTemplateBindings().size() > 0) {
			return null;
		}
		org.eclipse.uml2.uml.Class umlClass = UMLFactory.eINSTANCE.createClass();
		copyClassifier(umlClass, pivotClass);
		umlClass.setIsAbstract(pivotClass.isAbstract());
//		umlClass.setIsInterface(pivotClass.isInterface());
		context.defer(pivotClass);		// Defer superclass resolution
		safeVisitAll(umlClass.getOwnedOperations(), pivotClass.getOwnedOperations());
		safeVisitAll(umlClass.getOwnedAttributes(), pivotClass.getOwnedAttributes());
		return umlClass;
	}

	@Override
	public org.eclipse.uml2.uml.Constraint visitConstraint(Constraint pivotConstraint) {
		ValueSpecification specification = pivotConstraint.getSpecification();
		if (!(specification instanceof OpaqueExpression)) {
			return null;
		}
		List<String> bodies = ((OpaqueExpression)specification).getBodies();
		if ((bodies == null) || bodies.isEmpty()) {
			return null;
		}
//		EModelElement eModelElement = context.getCreated(EModelElement.class, (Element)pivotConstraint.eContainer());
//		EAnnotation oclAnnotation = eModelElement.getEAnnotation(OCLDelegateDomain.OCL_DELEGATE_URI);
//		if (oclAnnotation == null) {
//			oclAnnotation = UMLFactory.eINSTANCE.createEAnnotation();
//			oclAnnotation.setSource(OCLDelegateDomain.OCL_DELEGATE_URI);
//			eModelElement.getEAnnotations().add(oclAnnotation);
//		}
		String exprString = StringUtils.splice(bodies, "");
		String stereotype = pivotConstraint.getStereotype();
		String name = pivotConstraint.getName();
/*		if ("invariant".equals(stereotype)) {
			oclAnnotation.getDetails().put(name, exprString);
		}
		else if ("derivation".equals(stereotype)) {
			oclAnnotation.getDetails().put(SettingBehavior.DERIVATION_CONSTRAINT_KEY, exprString);
		}
		else if ("initial".equals(stereotype)) {
			oclAnnotation.getDetails().put(SettingBehavior.INITIAL_CONSTRAINT_KEY, exprString);
		}
		else if ("body".equals(stereotype)) {
			String key = name != null ? "body_" + name : InvocationBehavior.BODY_CONSTRAINT_KEY;
			oclAnnotation.getDetails().put(key, exprString);
		}
		else if ("precondition".equals(stereotype)) {
			oclAnnotation.getDetails().put("pre_" + name, exprString);
		}
		else if ("postcondition".equals(stereotype)) {
			oclAnnotation.getDetails().put("post_" + name, exprString);
		}
		else {
//			error("Unsupported " + pivotConstraint);
		} */
		return null;
	}

	@Override
	public org.eclipse.uml2.uml.DataType visitDataType(DataType pivotDataType) {
		if (pivotDataType.getTemplateBindings().size() > 0) {
			return null;
		}
		org.eclipse.uml2.uml.DataType umlDataType = UMLFactory.eINSTANCE.createDataType();
		copyDataTypeOrEnum(umlDataType, pivotDataType);
		return umlDataType;
	}

//	@Override
//	public EObject visitDetail(Detail object) {
		// TODO Auto-generated method stub
//		return super.visitDetail(object);
//	}

	@Override
	public org.eclipse.uml2.uml.Enumeration visitEnumeration(Enumeration pivotEnumeration) {
		if (pivotEnumeration.getTemplateBindings().size() > 0) {
			return null;
		}
		org.eclipse.uml2.uml.Enumeration umlEnumeration = UMLFactory.eINSTANCE.createEnumeration();
		copyDataTypeOrEnum(umlEnumeration, pivotEnumeration);
		safeVisitAll(umlEnumeration.getOwnedLiterals(), pivotEnumeration.getOwnedLiterals());
		return umlEnumeration;
	}

	@Override
	public org.eclipse.uml2.uml.EnumerationLiteral visitEnumerationLiteral(EnumerationLiteral pivotEnumLiteral) {
		org.eclipse.uml2.uml.EnumerationLiteral umlEnumLiteral = UMLFactory.eINSTANCE.createEnumerationLiteral();
		copyNamedElement(umlEnumLiteral, pivotEnumLiteral);
//		if (pivotEnumLiteral.eIsSet(PivotPackage.Literals.ENUMERATION_LITERAL__VALUE)) {
//			umlEnumLiteral.setValue(pivotEnumLiteral.getValue().intValue());
//		}
//		else {
//			umlEnumLiteral.eUnset(UMLPackage.Literals.EENUM_LITERAL__VALUE);
//		}
		return umlEnumLiteral;
	}

	@Override
	public org.eclipse.uml2.uml.Operation visitOperation(Operation pivotOperation) {
		if (pivotOperation.getTemplateBindings().size() > 0) {
			return null;
		}
		org.eclipse.uml2.uml.Operation umlOperation = UMLFactory.eINSTANCE.createOperation();
		copyNamedElement(umlOperation, pivotOperation);
//		safeVisitAll(umlOperation.getEAnnotations(), pivotOperation.getOwnedAnnotations());
		context.defer(pivotOperation);		// Defer type setting
		TemplateSignature pivotTemplateSignature = pivotOperation.getOwnedTemplateSignature();
		umlOperation.setOwnedTemplateSignature((org.eclipse.uml2.uml.TemplateSignature)safeVisit(pivotTemplateSignature));
//		copyTemplateSignature(pivotOperation.getETypeParameters(), pivotOperation);
		safeVisitAll(umlOperation.getOwnedParameters(), pivotOperation.getOwnedParameters());
		safeVisitAll(umlOperation.getRaisedExceptions(), pivotOperation.getRaisedExceptions());
		for (Constraint pivotConstraint : pivotOperation.getOwnedRules()) {
			safeVisit(pivotConstraint);		// Results are inserted directly
		}
		return umlOperation;
	}

	@Override
	public org.eclipse.uml2.uml.Package visitPackage(Package pivotPackage) {
		org.eclipse.uml2.uml.Package umlPackage = UMLFactory.eINSTANCE.createPackage();
		copyNamedElement(umlPackage, pivotPackage);
//		safeVisitAll(ePackage.getEAnnotations(), pivotPackage.getOwnedAnnotations());
		context.defer(pivotPackage);		// Defer delegate annotation analysis
//		if (pivotPackage.eIsSet(PivotPackage.Literals.PACKAGE__NS_PREFIX)) {
//			umlPackage.setNsPrefix(pivotPackage.getNsPrefix());
//		}
//		if (pivotPackage.eIsSet(PivotPackage.Literals.PACKAGE__NS_URI)) {
//			umlPackage.setNsURI(pivotPackage.getNsURI());
//		}
		safeVisitAll(umlPackage.getNestedPackages(), pivotPackage.getNestedPackages());
		safeVisitAll(umlPackage.getOwnedTypes(), pivotPackage.getOwnedTypes());
		return umlPackage;
	}

	@Override
	public org.eclipse.uml2.uml.Parameter visitParameter(Parameter pivotParameter) {
		org.eclipse.uml2.uml.Parameter umlParameter = UMLFactory.eINSTANCE.createParameter();
		copyTypedElement(umlParameter, pivotParameter);
		copyMultiplicityElement(umlParameter, pivotParameter);
		return umlParameter;
	}

	@Override
	public org.eclipse.uml2.uml.Element visitPrimitiveType(PrimitiveType pivotPrimitiveType) {
		if (pivotPrimitiveType.getTemplateBindings().size() > 0) {
			return null;
		}
		org.eclipse.uml2.uml.PrimitiveType umlPrimitiveType = UMLFactory.eINSTANCE.createPrimitiveType();
		copyDataTypeOrEnum(umlPrimitiveType, pivotPrimitiveType);
		return umlPrimitiveType;
	}

	@Override
	public org.eclipse.uml2.uml.Property visitProperty(Property pivotProperty) {
//		Type type = pivotProperty.getType();
		org.eclipse.uml2.uml.Property umlProperty = UMLFactory.eINSTANCE.createProperty();
		copyTypedElement(umlProperty, pivotProperty);
		copyMultiplicityElement(umlProperty, pivotProperty);
//		umlProperty.setIsID(pivotProperty.isID());
		umlProperty.setIsComposite(pivotProperty.isComposite());
//		umlProperty.setIsResolveProxies(pivotProperty.isResolveProxies());
		umlProperty.setIsReadOnly(pivotProperty.isReadOnly());
		umlProperty.setIsDerived(pivotProperty.isDerived());
//		umlProperty.setIsTransient(pivotProperty.isTransient());
//		umlProperty.setIsUnsettable(pivotProperty.isUnsettable());
//		umlProperty.setIsVolatile(pivotProperty.isVolatile());
		if ((pivotProperty.getOpposite() != null) || !pivotProperty.getKeys().isEmpty()) {
			context.defer(pivotProperty);
		}
//		if (pivotProperty.eIsSet(PivotPackage.Literals.PROPERTY__DEFAULT)) {
//			umlProperty.setDefaultValueLiteral(pivotProperty.getDefault());
//		}
//		else {
//			umlProperty.eUnset(UMLPackage.Literals.ESTRUCTURAL_FEATURE__DEFAULT_VALUE_LITERAL);
//		}
		for (Constraint pivotConstraint : pivotProperty.getOwnedRules()) {
			safeVisit(pivotConstraint);		// Results are inserted directly
		}
		return umlProperty;
	}

	@Override
	public org.eclipse.uml2.uml.TemplateSignature visitTemplateSignature(TemplateSignature pivotTemplateSignature) {
		org.eclipse.uml2.uml.TemplateSignature umlTemplateSignature = UMLFactory.eINSTANCE.createRedefinableTemplateSignature();
		safeVisitAll(umlTemplateSignature.getOwnedParameters(), pivotTemplateSignature.getOwnedParameters());
//		safeVisitAll(umlTemplateSignature.getParameters(), pivotTemplateSignature.getParameters());
		return umlTemplateSignature;
	}


	@Override
	public org.eclipse.uml2.uml.ClassifierTemplateParameter visitTypeTemplateParameter(TypeTemplateParameter pivotTypeTemplateParameter) {
		org.eclipse.uml2.uml.ClassifierTemplateParameter umlTypeParameter = UMLFactory.eINSTANCE.createClassifierTemplateParameter();
		umlTypeParameter.setOwnedParameteredElement((ParameterableElement) safeVisit(pivotTypeTemplateParameter.getOwnedParameteredElement()));
//		umlTypeParameter.setName(((Type) pivotTypeTemplateParameter.getParameteredElement()).getName());
		context.putCreated(pivotTypeTemplateParameter, umlTypeParameter);
		if (!pivotTypeTemplateParameter.getConstrainingTypes().isEmpty()) {
			context.defer(pivotTypeTemplateParameter);
		}
		return umlTypeParameter;
	}
}