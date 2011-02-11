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
 * $Id: Pivot2EcoreDeclarationVisitor.java,v 1.5 2011/02/11 20:00:29 ewillink Exp $
 */
package org.eclipse.ocl.examples.pivot.ecore;

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.ocl.examples.common.utils.StringUtils;
import org.eclipse.ocl.examples.pivot.Annotation;
import org.eclipse.ocl.examples.pivot.Class;
import org.eclipse.ocl.examples.pivot.Constraint;
import org.eclipse.ocl.examples.pivot.DataType;
import org.eclipse.ocl.examples.pivot.Detail;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Enumeration;
import org.eclipse.ocl.examples.pivot.EnumerationLiteral;
import org.eclipse.ocl.examples.pivot.ExpressionInOcl;
import org.eclipse.ocl.examples.pivot.MonikeredElement;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.OpaqueExpression;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Package;
import org.eclipse.ocl.examples.pivot.Parameter;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.TemplateParameter;
import org.eclipse.ocl.examples.pivot.TemplateSignature;
import org.eclipse.ocl.examples.pivot.TemplateableElement;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.TypeTemplateParameter;
import org.eclipse.ocl.examples.pivot.TypedMultiplicityElement;
import org.eclipse.ocl.examples.pivot.ValueSpecification;
import org.eclipse.ocl.examples.pivot.delegate.InvocationBehavior;
import org.eclipse.ocl.examples.pivot.delegate.OCLDelegateDomain;
import org.eclipse.ocl.examples.pivot.delegate.SettingBehavior;
import org.eclipse.ocl.examples.pivot.prettyprint.PrettyPrintExprVisitor;
import org.eclipse.ocl.examples.pivot.util.AbstractExtendingVisitor;
import org.eclipse.ocl.examples.pivot.util.Visitable;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;

public class Pivot2EcoreDeclarationVisitor
	extends AbstractExtendingVisitor<EObject, Pivot2Ecore>
{
	public static final Logger logger = Logger.getLogger(Pivot2EcoreDeclarationVisitor.class);

	public Pivot2EcoreDeclarationVisitor(Pivot2Ecore context) {
		super(context);
	}

	protected void copyClassifier(EClassifier eClassifier, Type pivotType) {
		copyNamedElement(eClassifier, pivotType);
		copyTemplateSignature(eClassifier.getETypeParameters(), pivotType);
		safeVisitAll(eClassifier.getEAnnotations(), pivotType.getOwnedAnnotations());
		if (pivotType.eIsSet(PivotPackage.Literals.TYPE__INSTANCE_CLASS_NAME)) {
			eClassifier.setInstanceClassName(pivotType.getInstanceClassName());
		}
		else {
			eClassifier.eUnset(EcorePackage.Literals.ECLASSIFIER__INSTANCE_CLASS_NAME);
		}
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
		EAnnotation eAnnotation = eClassifier.getEAnnotation(EcorePackage.eNS_URI);
		if (s != null) {
			if (eAnnotation == null) {
				eAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
				eAnnotation.setSource(EcorePackage.eNS_URI);
				eClassifier.getEAnnotations().add(0, eAnnotation);
			}
			eAnnotation.getDetails().put("constraints", s.toString());
		}
		else {
			eClassifier.getEAnnotations().remove(eAnnotation);
		}
	}

	protected void copyDataTypeOrEnum(EDataType eDataType, DataType pivotDataType) {
		copyClassifier(eDataType, pivotDataType);
		eDataType.setSerializable(pivotDataType.isSerializable());
	}

	protected void copyDetails(EAnnotation eAnnotation, Annotation pivotAnnotation) {
		copyModelElement(eAnnotation, pivotAnnotation);
		safeVisitAll(eAnnotation.getEAnnotations(), pivotAnnotation.getOwnedAnnotations());
		for (Detail pivotDetail : pivotAnnotation.getOwnedDetails()) {
			String name = pivotDetail.getName();
			String value = StringUtils.splice(pivotDetail.getValues(), "");
			eAnnotation.getDetails().put(name, value);
		}
	}

	protected void copyModelElement(EModelElement eModelElement, MonikeredElement pivotModelElement) {
		context.putCreated(pivotModelElement, eModelElement);
	}

	protected void copyNamedElement(ENamedElement eNamedElement, NamedElement pivotNamedElement) {
		copyModelElement(eNamedElement, pivotNamedElement);
		eNamedElement.setName(pivotNamedElement.getName());
	}

	protected void copyTemplateSignature(List<ETypeParameter> eTypeParameters, TemplateableElement pivotElement) {
		TemplateSignature templateSignature = pivotElement.getOwnedTemplateSignature();
		if (templateSignature != null) {
			List<TemplateParameter> parameters = templateSignature.getParameters();
			safeVisitAll(eTypeParameters, parameters);
		}
	}

	protected void copyTypedElement(ETypedElement eTypedElement, TypedMultiplicityElement pivotTypedElement) {
		copyNamedElement(eTypedElement, pivotTypedElement);
		safeVisitAll(eTypedElement.getEAnnotations(), pivotTypedElement.getOwnedAnnotations());
		context.defer(pivotTypedElement);		// Defer type setting
		eTypedElement.setLowerBound(pivotTypedElement.getLower().intValue());
		eTypedElement.setUpperBound(pivotTypedElement.getUpper().intValue());
		eTypedElement.setUnique(pivotTypedElement.isUnique());
		eTypedElement.setOrdered(pivotTypedElement.isOrdered());
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

	public EObject visiting(Visitable visitable) {
		logger.error("Unsupported " + visitable.eClass().getName() + " for " + getClass().getName());
		return null;
	}

	@Override
	public EObject visitAnnotation(Annotation pivotAnnotation) {
		EAnnotation eAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
		copyDetails(eAnnotation, pivotAnnotation);
		eAnnotation.setSource(pivotAnnotation.getName());
		safeVisitAll(eAnnotation.getContents(), pivotAnnotation.getOwnedContents());
		if (!pivotAnnotation.getReferences().isEmpty()) {
			context.defer(pivotAnnotation);
		}
		return eAnnotation;
	}

	@Override
	public EObject visitClass(Class pivotClass) {
		if (pivotClass.getTemplateBindings().size() > 0) {
			return null;
		}
		EClass eClass = EcoreFactory.eINSTANCE.createEClass();
		copyClassifier(eClass, pivotClass);
		eClass.setAbstract(pivotClass.isAbstract());
		eClass.setInterface(pivotClass.isInterface());
		context.defer(pivotClass);		// Defer superclass resolution
		safeVisitAll(eClass.getEOperations(), pivotClass.getOwnedOperations());
		safeVisitAll(eClass.getEStructuralFeatures(), pivotClass.getOwnedAttributes());
		return eClass;
	}

	@Override
	public EObject visitConstraint(Constraint pivotConstraint) {
		ValueSpecification specification = pivotConstraint.getSpecification();
		if (!(specification instanceof OpaqueExpression)) {
			return null;
		}
		String exprString = PivotUtil.getBody((OpaqueExpression) specification);
		if ((exprString == null) && (specification instanceof ExpressionInOcl)) {
			exprString = PrettyPrintExprVisitor.prettyPrint(((ExpressionInOcl)specification).getBodyExpression(), PrettyPrintExprVisitor.getNamespace(specification));
		}
		if (exprString == null) {
			return null;
		}
		EModelElement eModelElement = context.getCreated(EModelElement.class, (Element)pivotConstraint.eContainer());
		EAnnotation oclAnnotation = eModelElement.getEAnnotation(OCLDelegateDomain.OCL_DELEGATE_URI_PIVOT);
		if (oclAnnotation == null) {
			oclAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
			oclAnnotation.setSource(OCLDelegateDomain.OCL_DELEGATE_URI_PIVOT);
			eModelElement.getEAnnotations().add(oclAnnotation);
		}
		String stereotype = pivotConstraint.getStereotype();
		String name = pivotConstraint.getName();
		if ("invariant".equals(stereotype)) {
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
		}
		return null;
	}

	@Override
	public EObject visitDataType(DataType pivotDataType) {
		if (pivotDataType.getTemplateBindings().size() > 0) {
			return null;
		}
		EDataType eDataType = EcoreFactory.eINSTANCE.createEDataType();
		copyDataTypeOrEnum(eDataType, pivotDataType);
		return eDataType;
	}

	@Override
	public EObject visitDetail(Detail object) {
		// TODO Auto-generated method stub
		return super.visitDetail(object);
	}

	@Override
	public EObject visitEnumeration(Enumeration pivotEnumeration) {
		if (pivotEnumeration.getTemplateBindings().size() > 0) {
			return null;
		}
		EEnum eEnum = EcoreFactory.eINSTANCE.createEEnum();
		copyDataTypeOrEnum(eEnum, pivotEnumeration);
		safeVisitAll(eEnum.getELiterals(), pivotEnumeration.getOwnedLiterals());
		return eEnum;
	}

	@Override
	public EObject visitEnumerationLiteral(EnumerationLiteral pivotEnumLiteral) {
		EEnumLiteral eEnumLiteral = EcoreFactory.eINSTANCE.createEEnumLiteral();
		copyNamedElement(eEnumLiteral, pivotEnumLiteral);
		if (pivotEnumLiteral.eIsSet(PivotPackage.Literals.ENUMERATION_LITERAL__VALUE)) {
			eEnumLiteral.setValue(pivotEnumLiteral.getValue().intValue());
		}
		else {
			eEnumLiteral.eUnset(EcorePackage.Literals.EENUM_LITERAL__VALUE);
		}
		return eEnumLiteral;
	}

	@Override
	public EObject visitOperation(Operation pivotOperation) {
		if (pivotOperation.getTemplateBindings().size() > 0) {
			return null;
		}
		EOperation eOperation = EcoreFactory.eINSTANCE.createEOperation();
		copyTypedElement(eOperation, pivotOperation);
		copyTemplateSignature(eOperation.getETypeParameters(), pivotOperation);
		safeVisitAll(eOperation.getEParameters(), pivotOperation.getOwnedParameters());
//		safeVisitAll(eOperation.getEGenericExceptions(), pivotOperation.getRaisedExceptions());
		for (Constraint pivotConstraint : pivotOperation.getOwnedRules()) {
			safeVisit(pivotConstraint);		// Results are inserted directly
		}
		return eOperation;
	}

	@Override
	public EObject visitPackage(Package pivotPackage) {
		EPackage ePackage = EcoreFactory.eINSTANCE.createEPackage();
		copyNamedElement(ePackage, pivotPackage);
		safeVisitAll(ePackage.getEAnnotations(), pivotPackage.getOwnedAnnotations());
		context.defer(pivotPackage);		// Defer delegate annotation analysis
		if (pivotPackage.eIsSet(PivotPackage.Literals.PACKAGE__NS_PREFIX)) {
			ePackage.setNsPrefix(pivotPackage.getNsPrefix());
		}
		if (pivotPackage.eIsSet(PivotPackage.Literals.PACKAGE__NS_URI)) {
			ePackage.setNsURI(pivotPackage.getNsURI());
		}
		safeVisitAll(ePackage.getESubpackages(), pivotPackage.getNestedPackages());
		safeVisitAll(ePackage.getEClassifiers(), pivotPackage.getOwnedTypes());
		return ePackage;
	}

	@Override
	public EObject visitParameter(Parameter pivotParameter) {
		EParameter eParameter = EcoreFactory.eINSTANCE.createEParameter();
		copyTypedElement(eParameter, pivotParameter);
		return eParameter;
	}

	@Override
	public EObject visitProperty(Property pivotProperty) {
		EStructuralFeature eStructuralFeature;
		Type type = pivotProperty.getType();
		if (type instanceof DataType) {
			EAttribute eAttribute = EcoreFactory.eINSTANCE.createEAttribute();
			eAttribute.setID(pivotProperty.isID());
			eStructuralFeature = eAttribute;
		}
		else {
			EReference eReference = EcoreFactory.eINSTANCE.createEReference();
			if ((pivotProperty.getOpposite() != null) || !pivotProperty.getKeys().isEmpty()) {
				context.defer(pivotProperty);
			}
			eReference.setContainment(pivotProperty.isComposite());
			eReference.setResolveProxies(pivotProperty.isResolveProxies());
			eStructuralFeature = eReference;
		}
		copyTypedElement(eStructuralFeature, pivotProperty);
		eStructuralFeature.setChangeable(!pivotProperty.isReadOnly());
		eStructuralFeature.setDerived(pivotProperty.isDerived());
		eStructuralFeature.setTransient(pivotProperty.isTransient());
		eStructuralFeature.setUnsettable(pivotProperty.isUnsettable());
		eStructuralFeature.setVolatile(pivotProperty.isVolatile());
		if (pivotProperty.eIsSet(PivotPackage.Literals.PROPERTY__DEFAULT)) {
			eStructuralFeature.setDefaultValueLiteral(pivotProperty.getDefault());
		}
		else {
			eStructuralFeature.eUnset(EcorePackage.Literals.ESTRUCTURAL_FEATURE__DEFAULT_VALUE_LITERAL);
		}
		for (Constraint pivotConstraint : pivotProperty.getOwnedRules()) {
			safeVisit(pivotConstraint);		// Results are inserted directly
		}
		return eStructuralFeature;
	}

	@Override
	public EObject visitTypeTemplateParameter(TypeTemplateParameter pivotTypeTemplateParameter) {
		ETypeParameter eTypeParameter = EcoreFactory.eINSTANCE.createETypeParameter();
		eTypeParameter.setName(((Type) pivotTypeTemplateParameter.getParameteredElement()).getName());
		context.putCreated(pivotTypeTemplateParameter, eTypeParameter);
		if (!pivotTypeTemplateParameter.getConstrainingTypes().isEmpty()) {
			context.defer(pivotTypeTemplateParameter);
		}
		return eTypeParameter;
	}
}