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
 * $Id: OCLinEcore2Ecore.java,v 1.1 2010/04/13 06:44:12 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EGenericType;
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
import org.eclipse.emf.ecore.util.EcoreSwitch;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.ecore.delegate.InvocationBehavior;
import org.eclipse.ocl.ecore.delegate.OCLDelegateDomain;
import org.eclipse.ocl.ecore.delegate.SettingBehavior;
import org.eclipse.ocl.ecore.delegate.ValidationBehavior;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.AnnotationCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.AttributeCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.AttributeCSRef;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.AttributeRef;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ClassCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ClassifierCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ConstraintCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DataTypeCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DataTypeOrEnumCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DetailCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EAttributeRef;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EClassifierCSRef;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EClassifierRef;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EObjectRef;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EReferenceRef;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EnumCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EnumLiteralCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ModelElementCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ModelElementCSRef;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.NamedElementCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreCSTPackage;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ObjectRef;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OperationCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.PackageCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ParameterCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ReferenceCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ReferenceCSRef;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ReferenceRef;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.StructuralFeatureCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.TypeCSRef;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.TypeParameterCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.TypeRef;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.TypeRefCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.TypedElementCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.TypedTypeRefCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.WildcardTypeRefCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.util.OCLinEcoreCSTSwitch;

@SuppressWarnings("serial")
public class OCLinEcore2Ecore
{
	private List<String> errors = null;

	private Map<ModelElementCS, EModelElement> cs2Emap = new HashMap<ModelElementCS, EModelElement>();
	private Map<EObject, ModelElementCS> e2CSmap = new HashMap<EObject, ModelElementCS>();
	
	protected final OCLinEcoreCSTSwitch<EObject> pass1 = new OCLinEcoreCSTSwitch<EObject>()
	{
		@Override
		public EObject caseAnnotationCS(AnnotationCS csAnnotation) {
			EAnnotation eAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
			copyModelElement(eAnnotation, csAnnotation);
			String source = csAnnotation.getIdSource();
			if (source == null) {
				source = csAnnotation.getStringSource();
			}
			eAnnotation.setSource(source);
			for (DetailCS csDetail : csAnnotation.getDetails()) {
				String name = csDetail.getIdName();
				if (name == null) {
					name = csDetail.getStringName();
				}
				eAnnotation.getDetails().put(name, csDetail.getValue());
			}
			doSwitchAll(eAnnotation.getContents(), csAnnotation.getContents());
			if (!csAnnotation.getReferences().isEmpty()) {
				e2CSmap.put(eAnnotation, csAnnotation);
			}
			return eAnnotation;
		}

		@Override
		public EObject caseAttributeCS(AttributeCS csAttribute) {
			EAttribute eAttribute = EcoreFactory.eINSTANCE.createEAttribute();
			copyStructuralFeature(eAttribute, csAttribute);
			EList<String> qualifiers = csAttribute.getQualifiers();
			setAttribute(eAttribute, EcorePackage.Literals.EATTRIBUTE__ID, qualifiers, "id", "!id");
			return eAttribute;
		}

		@Override
		public EObject caseClassCS(ClassCS csClass) {
			EClass eClass = EcoreFactory.eINSTANCE.createEClass();
			copyClassifier(eClass, csClass);
			EList<String> qualifiers = csClass.getQualifiers();
			setAttribute(eClass, EcorePackage.Literals.ECLASS__ABSTRACT, qualifiers, "abstract", "!abstract");
			setAttribute(eClass, EcorePackage.Literals.ECLASS__INTERFACE, qualifiers, "interface", "!interface");
			e2CSmap.put(eClass, csClass);
			doSwitchAll(eClass.getEGenericSuperTypes(), csClass.getSuperTypes());
			doSwitchAll(eClass.getEOperations(), csClass.getOperations());
			doSwitchAll(eClass.getEStructuralFeatures(), csClass.getStructuralFeatures());
			return eClass;
		}

		@Override
		public EObject caseConstraintCS(ConstraintCS object) {
			// TODO Auto-generated method stub
			return super.caseConstraintCS(object);
		}

		@Override
		public EObject caseDataTypeCS(DataTypeCS csDataType) {
			EDataType eDataType = EcoreFactory.eINSTANCE.createEDataType();
			copyDataTypeOrEnum(eDataType, csDataType);
			return eDataType;
		}

		@Override
		public EObject caseEnumCS(EnumCS csEnum) {
			EEnum eEnum = EcoreFactory.eINSTANCE.createEEnum();
			copyDataTypeOrEnum(eEnum, csEnum);
			doSwitchAll(eEnum.getELiterals(), csEnum.getLiterals());
			return eEnum;
		}

		@Override
		public EObject caseEnumLiteralCS(EnumLiteralCS csEnumLiteral) {
			EEnumLiteral eEnumLiteral = EcoreFactory.eINSTANCE.createEEnumLiteral();
			for (AnnotationCS csAnnotation : csEnumLiteral.getAnnotations()) {
				if (EcorePackage.eNS_URI.equals(csAnnotation.getIdSource())) {
					for (DetailCS csDetail : csAnnotation.getDetails()) {
						String name = csDetail.getIdName();
						if ("literal".equals(name)) {
							eEnumLiteral.setLiteral(csDetail.getValue());
						}
						else {
							error("Unsupported namespace detail " + name + " in pass1");
						}
					}
					
				}
				else {
					EAnnotation eObject = (EAnnotation) doSwitch(csAnnotation);
					eEnumLiteral.getEAnnotations().add(eObject);
				}
			}
			eEnumLiteral.setName(csEnumLiteral.getName());
			eEnumLiteral.setValue(csEnumLiteral.getValue());
			return eEnumLiteral;
		}

		@Override
		public EObject caseOperationCS(OperationCS csOperation) {
			EOperation eOperation = EcoreFactory.eINSTANCE.createEOperation();
			copyTypedElement(eOperation, csOperation);
			doSwitchAll(eOperation.getEParameters(), csOperation.getParameters());
			doSwitchAll(eOperation.getETypeParameters(), csOperation.getTypeParameters());
			doSwitchAll(eOperation.getEGenericExceptions(), csOperation.getExceptions());
			return eOperation;
		}

		@Override
		public EObject casePackageCS(PackageCS csPackage) {
			EPackage ePackage = EcoreFactory.eINSTANCE.createEPackage();
			for (AnnotationCS csAnnotation : csPackage.getAnnotations()) {
				if ("namespace".equals(csAnnotation.getIdSource())) {
					for (DetailCS csDetail : csAnnotation.getDetails()) {
						String name = csDetail.getIdName();
						if ("uri".equals(name)) {
							ePackage.setNsURI(csDetail.getValue());
						}
						else if ("prefix".equals(name)) {
							ePackage.setNsPrefix(csDetail.getValue());
						}
						else {
							error("Unsupported namespace detail " + name + " in pass1");
						}
					}
					
				}
				else {
					EAnnotation eObject = (EAnnotation) doSwitch(csAnnotation);
					ePackage.getEAnnotations().add(eObject);
				}
			}
			ePackage.setName(csPackage.getName());
			doSwitchAll(ePackage.getESubpackages(), csPackage.getSubpackages());
			doSwitchAll(ePackage.getEClassifiers(), csPackage.getClassifiers());
			return ePackage;
		}

		@Override
		public EParameter caseParameterCS(ParameterCS csParameter) {
			EParameter eParameter = EcoreFactory.eINSTANCE.createEParameter();
			copyTypedElement(eParameter, csParameter);
			return eParameter;
		}

		@Override
		public EReference caseReferenceCS(ReferenceCS csReference) {
			EReference eReference = EcoreFactory.eINSTANCE.createEReference();
			copyStructuralFeature(eReference, csReference);
			eReference.setContainment(csReference.isContainment());
			if ((csReference.getOpposite() != null) || !csReference.getKeys().isEmpty()) {
				e2CSmap.put(eReference, csReference);
			}
			EList<String> qualifiers = csReference.getQualifiers();
			setAttribute(eReference, EcorePackage.Literals.EREFERENCE__RESOLVE_PROXIES, qualifiers, "resolve", "!resolve");
			return eReference;
		}

		@Override
		public EObject caseTypeParameterCS(TypeParameterCS csTypeParameter) {
			ETypeParameter eTypeParameter = EcoreFactory.eINSTANCE.createETypeParameter();
			copyNamedElement(eTypeParameter, csTypeParameter);
			// FIXME super ..
			doSwitchAll(eTypeParameter.getEBounds(), csTypeParameter.getExtends());
			return eTypeParameter;
		}

		@Override
		public EGenericType caseTypedTypeRefCS(TypedTypeRefCS csTypeRef) {
			EGenericType eGenericType = EcoreFactory.eINSTANCE.createEGenericType();
			e2CSmap.put(eGenericType, csTypeRef);				// Defer eGenericType.getEType()
			doSwitchAll(eGenericType.getETypeArguments(), csTypeRef.getTypeArguments());
			return eGenericType;
		}

		@Override
		public EGenericType caseWildcardTypeRefCS(WildcardTypeRefCS csTypeRef) {
			EGenericType eGenericType = EcoreFactory.eINSTANCE.createEGenericType();
//			doSwitchAll(eGenericType.getETypeArguments(), csTypeRef.getExtends());
//			doSwitchAll(eGenericType.getETypeArguments(), csTypeRef.getSuper());
			return eGenericType;
		}

		protected void copyClassifier(EClassifier eClassifier, ClassifierCS csClassifier) {
			copyNamedElement(eClassifier, csClassifier);
			if (csClassifier.eIsSet(OCLinEcoreCSTPackage.Literals.CLASSIFIER_CS__INSTANCE_CLASS_NAME)) {
				eClassifier.setInstanceClassName(csClassifier.getInstanceClassName());
			}
			doSwitchAll(eClassifier.getETypeParameters(), csClassifier.getTypeParameters());
		}

		protected void copyDataTypeOrEnum(EDataType eDataType, DataTypeOrEnumCS csDataType) {
			copyClassifier(eDataType, csDataType);
			EList<String> qualifiers = csDataType.getQualifiers();
			setAttribute(eDataType, EcorePackage.Literals.EDATA_TYPE__SERIALIZABLE, qualifiers, "!transient", "transient");
		}

		protected void copyModelElement(EModelElement eModelElement, ModelElementCS csModelElement) {
			cs2Emap.put(csModelElement, eModelElement);
			doSwitchAll(eModelElement.getEAnnotations(), csModelElement.getAnnotations());
		}

		protected void copyNamedElement(ENamedElement eNamedElement, NamedElementCS csNamedElement) {
			copyModelElement(eNamedElement, csNamedElement);
			eNamedElement.setName(csNamedElement.getName());
		}

		protected void copyStructuralFeature(EStructuralFeature eStructuralFeature, StructuralFeatureCS csStructuralFeature) {
			copyTypedElement(eStructuralFeature, csStructuralFeature);
			List<String> qualifiers = csStructuralFeature.getQualifiers();
			setAttribute(eStructuralFeature, EcorePackage.Literals.ESTRUCTURAL_FEATURE__DERIVED, qualifiers, "derived", "!derived");
			setAttribute(eStructuralFeature, EcorePackage.Literals.ESTRUCTURAL_FEATURE__CHANGEABLE, qualifiers, "!readonly", "readonly");
			setAttribute(eStructuralFeature, EcorePackage.Literals.ESTRUCTURAL_FEATURE__TRANSIENT, qualifiers, "transient", "!transient");
			setAttribute(eStructuralFeature, EcorePackage.Literals.ESTRUCTURAL_FEATURE__UNSETTABLE, qualifiers, "unsettable", "!unsettable");
			setAttribute(eStructuralFeature, EcorePackage.Literals.ESTRUCTURAL_FEATURE__VOLATILE, qualifiers, "volatile", "!volatile");
			if (csStructuralFeature.eIsSet(OCLinEcoreCSTPackage.Literals.STRUCTURAL_FEATURE_CS__DEFAULT_VALUE_LITERAL)) {
				eStructuralFeature.setDefaultValueLiteral(csStructuralFeature.getDefaultValueLiteral());
			}
		}
		
		protected void copyTypedElement(ETypedElement eTypedElement, TypedElementCS csTypedElement) {
			copyNamedElement(eTypedElement, csTypedElement);
			TypeRefCS type = csTypedElement.getType();
			if (type != null) {
				eTypedElement.setEGenericType((EGenericType) doSwitch(type));
			}
			String multiplicity = csTypedElement.getMultiplicity();
			if (multiplicity != null) {
				if ("?".equals(multiplicity)) {
					eTypedElement.setLowerBound(0);
					eTypedElement.setUpperBound(1);
				}
				else if ("*".equals(multiplicity)) {
					eTypedElement.setLowerBound(0);
					eTypedElement.setUpperBound(-1);
				}
				else if ("+".equals(multiplicity)) {
					eTypedElement.setLowerBound(1);
					eTypedElement.setUpperBound(-1);
				}
				else {
					error("Unsupported multiplicity " + multiplicity + " in pass1");
				}
			}
			else {
				int lower = csTypedElement.getLower();
				eTypedElement.setLowerBound(lower);
				if (!csTypedElement.eIsSet(OCLinEcoreCSTPackage.Literals.TYPED_ELEMENT_CS__UPPER)) {
					eTypedElement.setUpperBound(lower);
				}
				else {
					eTypedElement.setUpperBound(csTypedElement.getUpper());
				}				
			}
			EList<String> qualifiers = csTypedElement.getQualifiers();
			setAttribute(eTypedElement, EcorePackage.Literals.ETYPED_ELEMENT__ORDERED, qualifiers, "ordered", "!ordered");
			setAttribute(eTypedElement, EcorePackage.Literals.ETYPED_ELEMENT__UNIQUE, qualifiers, "unique", "!unique");
		}

		@Override
		public EObject defaultCase(EObject object) {
			error("Unsupported " + object + " in pass1");
			return null;
		}

		public <T extends EObject> void doSwitchAll(List<T> eObjects, EList<? extends ModelElementCS> csObjects) {
			for (EObject csObject : csObjects) {
				@SuppressWarnings("unchecked")
				T eObject = (T) doSwitch(csObject);
				eObjects.add(eObject);
			}
		}		

		protected void setAttribute(EObject eObject, EAttribute eAttribute, List<String> qualifiers, String trueName, String falseName) {
			boolean isTrue = qualifiers.contains(trueName);
			boolean isFalse = qualifiers.contains(falseName);
			if (isTrue && isFalse) {
				error("Conflicting " + trueName + " and " + falseName);
			}
			else if (isTrue || isFalse) {
				eObject.eSet(eAttribute, isTrue);
			}
		}
	};
	
	protected final EcoreSwitch<Object> pass2 = new EcoreSwitch<Object>()
	{
		@Override
		public Object caseEAnnotation(EAnnotation eAnnotation) {
			AnnotationCS csAnnotation = (AnnotationCS) e2CSmap.get(eAnnotation);
			for (ObjectRef csReference : csAnnotation.getReferences()) {
				EObject eObject = resolveObjectRef(csReference);
				if (eObject != null) {
					eAnnotation.getReferences().add(eObject);
				}
			}
			return null;
		}

		@Override
		public Object caseEGenericType(EGenericType eGenericType) {
			TypedTypeRefCS csTypeRef = (TypedTypeRefCS) e2CSmap.get(eGenericType);
			TypeRef typeRef = csTypeRef.getType();
			if (typeRef != null) {
				EModelElement eType = resolveTypeRef(typeRef);
				if (eType instanceof EClassifier) {
					eGenericType.setEClassifier((EClassifier) eType);
				}
				else if (eType instanceof ETypeParameter) {
					eGenericType.setETypeParameter((ETypeParameter) eType);
				}
			}
			return null;
		}

		@Override
		public Object caseEReference(EReference eReference) {
			ReferenceCS csReference = (ReferenceCS) e2CSmap.get(eReference);
			ReferenceRef csOpposite = csReference.getOpposite();
			if (csOpposite != null) {
				EReference eOpposite = resolveReferenceRef(csOpposite);
				if (eOpposite != null) {
					eReference.setEOpposite(eOpposite);
				}
			}
			for (AttributeRef csKey : csReference.getKeys()) {
				EAttribute eAttribute = resolveAttributeRef(csKey);
				if (eAttribute != null) {
					eReference.getEKeys().add(eAttribute);
				}
			}
			return null;
		}

		@Override
		public Object caseETypeParameter(ETypeParameter eTypeParameter) {
			TypeParameterCS csTypeParameter = (TypeParameterCS) e2CSmap.get(eTypeParameter);
/*			ClassifierRef classifierRef = csTypedElement.getType();
			if (classifierRef != null) {
				EClassifier eClassifier = resolveClassifierRef(classifierRef);
				if (eClassifier != null) {
					eTypedElement.setEType(eClassifier);
				}
			} */
			return null;
		}

		protected EAttribute resolveAttributeRef(AttributeRef csAttributeRef) {
			if (csAttributeRef instanceof EAttributeRef) {
				return ((EAttributeRef)csAttributeRef).getRef();
			}
			else if (csAttributeRef instanceof AttributeCSRef) {
				return (EAttribute) cs2Emap.get(((AttributeCSRef)csAttributeRef).getRef());
			}
			else {
				error("Unresolved " + csAttributeRef + " in pass2");
				return null;
			}
		}

		protected EObject resolveObjectRef(ObjectRef csObjectRef) {
			if (csObjectRef instanceof EObjectRef) {
				return ((EObjectRef)csObjectRef).getRef();
			}
			else if (csObjectRef instanceof ModelElementCSRef) {
				return (EObject) cs2Emap.get(((ModelElementCSRef)csObjectRef).getRef());
			}
			else {
				error("Unresolved " + csObjectRef + " in pass2");
				return null;
			}
		}

		protected EReference resolveReferenceRef(ReferenceRef csReferenceRef) {
			if (csReferenceRef instanceof EReferenceRef) {
				return ((EReferenceRef)csReferenceRef).getRef();
			}
			else if (csReferenceRef instanceof ReferenceCSRef) {
				return (EReference) cs2Emap.get(((ReferenceCSRef)csReferenceRef).getRef());
			}
			else {
				error("Unresolved " + csReferenceRef + " in pass2");
				return null;
			}
		}

		protected EModelElement resolveTypeRef(TypeRef csTypeRef) {
			if (csTypeRef instanceof EClassifierRef) {
				return ((EClassifierRef)csTypeRef).getRef();
			}
			else if (csTypeRef instanceof EClassifierCSRef) {
				return ((EClassifierCSRef)csTypeRef).getRef();
			}
			else if (csTypeRef instanceof TypeCSRef) {
				return cs2Emap.get(((TypeCSRef)csTypeRef).getRef());
			}
			else {
				error("Unresolved " + csTypeRef + " in pass2");
				return null;
			}
		}
	};
	
	public EObject convert(EObject csObject) {
		EObject eObject = pass1.doSwitch(csObject);
		for (EObject eKey : e2CSmap.keySet()) {
			pass2.doSwitch(eKey);
		}
		return eObject;
	}

	public List<EObject> convertAll(List<? extends EObject> csObjects) {
		List<EObject> eObjects = new ArrayList<EObject>();
		for (EObject csObject : csObjects) {
			eObjects.add(pass1.doSwitch(csObject));
		}
		for (EObject eKey : e2CSmap.keySet()) {
			pass2.doSwitch(eKey);
		}
		return eObjects;
	}

	protected void error(String string) {
		if (errors == null) {
			errors = new ArrayList<String>();
		}
		errors.add(string);
	}

	public List<String> getErrors() {
		return errors;
	}


	//
	//	Add the EClass constraints annotations, if any constraints in use
	//
	private void copiedEClass(EClass eClass) {
		StringBuffer s = null;
		EAnnotation classifierAnnotation = eClass.getEAnnotation(OCLDelegateDomain.OCL_DELEGATE_URI);
		if (classifierAnnotation != null){
			for (String key : classifierAnnotation.getDetails().keySet()) {
				if (s == null) {
					s = new StringBuffer();
				}
				else {
					s.append(" ");
				}
				s.append(key);
			}
		}
		if (s != null) {
			EcoreUtil.setAnnotation(eClass, EcorePackage.eNS_URI, "constraints", s.toString());
		}
	}

	//
	//	Add the EPackage delegate annotations, if any delegates in use
	//
	private void copiedEPackage(EPackage ePackage) {
		boolean needsDelegates = false;
		for (EClassifier eClassifier : ePackage.getEClassifiers()) {
			EAnnotation classifierAnnotation = eClassifier.getEAnnotation(OCLDelegateDomain.OCL_DELEGATE_URI);
			if ((classifierAnnotation != null) && !classifierAnnotation.getDetails().isEmpty()) {
				needsDelegates = true;
				break;
			}
			if (eClassifier instanceof EClass) {
				EClass eClass = (EClass) eClassifier;
				for (EStructuralFeature eFeature : eClass.getEStructuralFeatures()) {
					EAnnotation featureAnnotation = eFeature.getEAnnotation(OCLDelegateDomain.OCL_DELEGATE_URI);
					if ((featureAnnotation != null) && !featureAnnotation.getDetails().isEmpty()) {
						needsDelegates = true;
						break;
					}
				}
				if (needsDelegates) {
					break;
				}
				for (EOperation eOperation : eClass.getEOperations()) {
					EAnnotation operationAnnotation = eOperation.getEAnnotation(OCLDelegateDomain.OCL_DELEGATE_URI);
					if ((operationAnnotation != null) && !operationAnnotation.getDetails().isEmpty()) {
						needsDelegates = true;
						break;
					}
				}
				if (needsDelegates) {
					break;
				}
			}
		}
		if (needsDelegates) {
		    EAnnotation packageAnnotation = ePackage.getEAnnotation(org.eclipse.emf.ecore.EcorePackage.eNS_URI);
		    if (packageAnnotation == null) {
		    	packageAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
		    	packageAnnotation.setSource(org.eclipse.emf.ecore.EcorePackage.eNS_URI);
		    	ePackage.getEAnnotations().add(packageAnnotation);
		    }
		    EMap<String, String> details = packageAnnotation.getDetails();
			details.put(InvocationBehavior.NAME, OCLDelegateDomain.OCL_DELEGATE_URI);
		    details.put(SettingBehavior.NAME, OCLDelegateDomain.OCL_DELEGATE_URI);
		    details.put(ValidationBehavior.NAME, OCLDelegateDomain.OCL_DELEGATE_URI);
		}
	}

/*	@Override
	protected void copyContainment(EReference eReference, EObject eObject, EObject copyEObject) {
		if (!eReference.isTransient()) {
			if (eReference.getEType() == OCLinEcoreCSTPackage.Literals.CONSTRAINT_CS) {
				@SuppressWarnings("unchecked")
				List<ConstraintCS> constraints = (List<ConstraintCS>)eObject.eGet(eReference);
				for (ConstraintCS constraintCS : constraints) {
					OclExpressionCS expr = constraintCS.getExpr();
					NodeAdapter node = (NodeAdapter) EcoreUtil.getAdapter(expr.eAdapters(), AbstractNode.class);
					CompositeNode parserNode = node.getParserNode();
					String value = parserNode.serialize();
					String name = constraintCS.getName();
					String stereotype = constraintCS.getStereotype();
					String key;
					if (name == null) {
						key = stereotype;					// e.g. init or der
					}
					else if (stereotype == null) {
						key = name;							// e.g. inv
					}
					else {
						key = stereotype + '_' + name;		// e.g. body, pre, post
					}
					EcoreUtil.setAnnotation((EModelElement) copyEObject, OCLDelegateDomain.OCL_DELEGATE_URI, key, value);
				}
			}
			else {
				super.copyContainment(eReference, eObject, copyEObject);
			}
		}
	} */
}