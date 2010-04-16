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
 * $Id: OCLinEcore2Ecore.java,v 1.2 2010/04/16 18:05:32 ewillink Exp $
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
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.AnnotationElementCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.AttributeCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.AttributeCSRef;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.AttributeRef;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ClassCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ClassifierCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ConstraintCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DataTypeCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DataTypeOrEnumCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DetailCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DocumentationCS;
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

public class OCLinEcore2Ecore extends AbstractConversion
{
	/**
	 * Mapping of all created CS elements to the resulting E elements.
	 */
	private Map<ModelElementCS, EModelElement> createMap = new HashMap<ModelElementCS, EModelElement>();

	/**
	 * Mapping of all E elements created during pass 1 that require further work
	 * with respect to the corresponding CS element in pass 2.
	 */
	private Map<EObject, ModelElementCS> deferMap = new HashMap<EObject, ModelElementCS>();
	
	protected final OCLinEcoreCSTSwitch<EObject> pass1 = new OCLinEcoreCSTSwitch<EObject>()
	{
		@Override
		public EObject caseAnnotationCS(AnnotationCS csAnnotation) {
			EAnnotation eAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
			copyDetails(eAnnotation, csAnnotation);
			String source = csAnnotation.getIdSource();
			if (source == null) {
				source = csAnnotation.getStringSource();
			}
			eAnnotation.setSource(source);
			doSwitchAll(eAnnotation.getContents(), csAnnotation.getContents());
			if (!csAnnotation.getReferences().isEmpty()) {
				deferMap.put(eAnnotation, csAnnotation);
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
			deferMap.put(eClass, csClass);
			doSwitchAll(eClass.getEGenericSuperTypes(), csClass.getSuperTypes());
			doSwitchAll(eClass.getEOperations(), csClass.getOperations());
			doSwitchAll(eClass.getEStructuralFeatures(), csClass.getStructuralFeatures());
			return eClass;
		}

		@Override
		public EObject caseConstraintCS(ConstraintCS csConstraint) {
			String exprString = csConstraint.getExprString();
			if (exprString == null) {		// null for a manually coded requirement
				return csConstraint;
			}
			EAnnotation oclAnnotation = getOCLAnnotation(csConstraint);
			String stereotype = csConstraint.getStereotype();
			String name = csConstraint.getName();
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
				error("Unsupported " + csConstraint);
			}
			return csConstraint;		// A non-null value
		}

		@Override
		public EObject caseDataTypeCS(DataTypeCS csDataType) {
			EDataType eDataType = EcoreFactory.eINSTANCE.createEDataType();
			copyDataTypeOrEnum(eDataType, csDataType);
			return eDataType;
		}
		
		@Override
		public EObject caseDocumentationCS(DocumentationCS csDocumentation) {
			EAnnotation eAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
			copyDetails(eAnnotation, csDocumentation);
			eAnnotation.setSource(GEN_MODEL_PACKAGE_NS_URI);
			String documentation = basicGet(csDocumentation, OCLinEcoreCSTPackage.Literals.DOCUMENTATION_CS__VALUE, String.class);
			if (documentation != null) {
				eAnnotation.getDetails().put("documentation", documentation);
			}
			return eAnnotation;
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
			for (AnnotationElementCS csAnnotation : csEnumLiteral.getAnnotations()) {
				if ((csAnnotation instanceof AnnotationCS)
					&& (EcorePackage.eNS_URI.equals(((AnnotationCS)csAnnotation).getIdSource()))) {
					for (DetailCS csDetail : ((AnnotationCS)csAnnotation).getDetails()) {
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
			for (ConstraintCS csConstraint : csOperation.getConstraints()) {
				doSwitch(csConstraint);		// Results are inserted directly
			}
			return eOperation;
		}

		@Override
		public EObject casePackageCS(PackageCS csPackage) {
			EPackage ePackage = EcoreFactory.eINSTANCE.createEPackage();
			copyNamedElement(ePackage, csPackage);
			deferMap.put(ePackage, csPackage);		// Defer delegate annotation analysis
			String prefix = basicGet(csPackage, OCLinEcoreCSTPackage.Literals.PACKAGE_CS__PREFIX, String.class);
			String uri = basicGet(csPackage, OCLinEcoreCSTPackage.Literals.PACKAGE_CS__URI, String.class);
			if ((prefix != null) && (uri != null)) {
				ePackage.setNsPrefix(prefix);
				ePackage.setNsURI(uri);
			}
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
			if ((csReference.getOpposite() != null) || !csReference.getKeys().isEmpty()) {
				deferMap.put(eReference, csReference);
			}
			EList<String> qualifiers = csReference.getQualifiers();
			setAttribute(eReference, EcorePackage.Literals.EREFERENCE__CONTAINMENT, qualifiers, "composes", "!composes");
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
			deferMap.put(eGenericType, csTypeRef);				// Defer eGenericType.getEType()
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
			StringBuffer s = null;
			for (ConstraintCS csConstraint : csClassifier.getConstraints()) {
				doSwitch(csConstraint);		// Results are inserted directly
				if (s == null) {
					s = new StringBuffer();
				}
				else {
					s.append(" ");
				}
				s.append(csConstraint.getName());
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

		protected void copyDataTypeOrEnum(EDataType eDataType, DataTypeOrEnumCS csDataType) {
			copyClassifier(eDataType, csDataType);
			EList<String> qualifiers = csDataType.getQualifiers();
			setAttribute(eDataType, EcorePackage.Literals.EDATA_TYPE__SERIALIZABLE, qualifiers, "serializable", "!serializable");
		}

		protected void copyDetails(EAnnotation eAnnotation, AnnotationElementCS csAnnotationElement) {
			copyModelElement(eAnnotation, csAnnotationElement);
			for (DetailCS csDetail : csAnnotationElement.getDetails()) {
				String name = csDetail.getIdName();
				if (name == null) {
					name = csDetail.getStringName();
				}
				eAnnotation.getDetails().put(name, csDetail.getValue());
			}
		}

		protected void copyModelElement(EModelElement eModelElement, ModelElementCS csModelElement) {
			createMap.put(csModelElement, eModelElement);
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
			for (ConstraintCS csConstraint : csStructuralFeature.getConstraints()) {
				doSwitch(csConstraint);		// Results are inserted directly
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
					eTypedElement.setUpperBound(lower != 0 ? lower : 1);
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

		protected EAnnotation getOCLAnnotation(ConstraintCS csConstraint) {
			ModelElementCS csModelElement = (ModelElementCS) csConstraint.eContainer();
			EModelElement eModelElement = createMap.get(csModelElement);
			EAnnotation oclAnnotation = eModelElement.getEAnnotation(OCLDelegateDomain.OCL_DELEGATE_URI);
			if (oclAnnotation == null) {
				oclAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
				oclAnnotation.setSource(OCLDelegateDomain.OCL_DELEGATE_URI);
				eModelElement.getEAnnotations().add(oclAnnotation);
			}
			return oclAnnotation;
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
			AnnotationCS csAnnotation = (AnnotationCS) deferMap.get(eAnnotation);
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
			TypedTypeRefCS csTypeRef = (TypedTypeRefCS) deferMap.get(eGenericType);
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

		//
		//	Add the EPackage delegate annotations, if any delegates in use
		//
		@Override
		public Object caseEPackage(EPackage ePackage) {
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
			    EAnnotation packageAnnotation = ePackage.getEAnnotation(EcorePackage.eNS_URI);
			    if (packageAnnotation == null) {
			    	packageAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
			    	packageAnnotation.setSource(EcorePackage.eNS_URI);
			    	ePackage.getEAnnotations().add(packageAnnotation);
			    }
			    EMap<String, String> details = packageAnnotation.getDetails();
				details.put(InvocationBehavior.NAME, OCLDelegateDomain.OCL_DELEGATE_URI);
			    details.put(SettingBehavior.NAME, OCLDelegateDomain.OCL_DELEGATE_URI);
			    details.put(ValidationBehavior.NAME, OCLDelegateDomain.OCL_DELEGATE_URI);
			}
			return null;
		}

		@Override
		public Object caseEReference(EReference eReference) {
			ReferenceCS csReference = (ReferenceCS) deferMap.get(eReference);
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
			TypeParameterCS csTypeParameter = (TypeParameterCS) deferMap.get(eTypeParameter);
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
				return (EAttribute) createMap.get(((AttributeCSRef)csAttributeRef).getRef());
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
				return (EObject) createMap.get(((ModelElementCSRef)csObjectRef).getRef());
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
				return (EReference) createMap.get(((ReferenceCSRef)csReferenceRef).getRef());
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
				return createMap.get(((TypeCSRef)csTypeRef).getRef());
			}
			else {
				error("Unresolved " + csTypeRef + " in pass2");
				return null;
			}
		}
	};
	
	public EObject convert(EObject csObject) {
		EObject eObject = pass1.doSwitch(csObject);
		for (EObject eKey : deferMap.keySet()) {
			pass2.doSwitch(eKey);
		}
		return eObject;
	}

	public List<EObject> convertAll(List<? extends EObject> csObjects) {
		List<EObject> eObjects = new ArrayList<EObject>();
		for (EObject csObject : csObjects) {
			eObjects.add(pass1.doSwitch(csObject));
		}
		for (EObject eKey : deferMap.keySet()) {
			pass2.doSwitch(eKey);
		}
		return eObjects;
	}
}