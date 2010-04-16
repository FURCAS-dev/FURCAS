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
 * $Id: Ecore2OCLinEcore.java,v 1.2 2010/04/16 18:05:32 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.resource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

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
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreSwitch;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.ecore.delegate.OCLDelegateDomain;
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
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DocumentCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DocumentationCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EAttributeRef;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EClassifierCSRef;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EObjectRef;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EReferenceRef;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EnumCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EnumLiteralCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ImportCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ModelElementCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ModelElementCSRef;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.NamedElementCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreCSTFactory;
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

public class Ecore2OCLinEcore extends AbstractConversion
{
	/**
	 * Convert an (annotated) Ecore resource to an Xtext CST document, reporting
	 * any errors to returnedErrors.
	 * 
	 * @param ecoreResource the annotated Ecore resource
	 * @param returnedErrors list to which errors are added
	 * 
	 * @return the Xtext CST document
	 */
	public static DocumentCS importAsDocumentCS(Resource ecoreResource, List<String> returnedErrors) {
		Ecore2OCLinEcore converter = new Ecore2OCLinEcore();
		List<EObject> csObjects = converter.convertAll(ecoreResource.getContents());
		List<String> conversionErrors = converter.getErrors();
		if ((conversionErrors != null) && (returnedErrors != null)) {
			returnedErrors.addAll(conversionErrors);
		}
		DocumentCS documentCS = OCLinEcoreCSTFactory.eINSTANCE.createDocumentCS();
		List<EPackage> ePackages = new ArrayList<EPackage>(converter.getReferencedEPackages());
		// sort
		List<ImportCS> imports = documentCS.getImports();
		for (EPackage ePackage : ePackages) {
			ImportCS importCS = OCLinEcoreCSTFactory.eINSTANCE.createImportCS();
			importCS.setAlias(ePackage.getNsPrefix());
			importCS.setEPackage(ePackage);
			imports.add(importCS);
		}
		List<PackageCS> packages = documentCS.getPackages();
		for (EObject csObject : csObjects) {
			packages.add((PackageCS) csObject);
		}
		return documentCS;
	}

	/**
	 * Mapping of all created E elements to the resulting CS elements.
	 */
	private Map<EModelElement, ModelElementCS> createMap = new HashMap<EModelElement, ModelElementCS>();

	/**
	 * Mapping of all CS elements created during pass 1 that require further work
	 * with respect to the corresponding E element in pass 2.
	 */
	private Map<ModelElementCS, EObject> deferMap = new HashMap<ModelElementCS, EObject>();

	/**
	 * Set of all targets for EClassifierRef.
	 */
	private Set<EClassifier> allEClassifiers = new HashSet<EClassifier>();
	
	protected final EcoreSwitch<ModelElementCS> pass1 = new EcoreSwitch<ModelElementCS>()
	{
		@Override
		public AnnotationElementCS caseEAnnotation(EAnnotation eAnnotation) {
			String source = eAnnotation.getSource();
			if (source.equals(GEN_MODEL_PACKAGE_NS_URI)) {
				DocumentationCS csDocumentation = OCLinEcoreCSTFactory.eINSTANCE.createDocumentationCS();
				copyDetails(csDocumentation, eAnnotation, Collections.singletonList("documentation"));
				String documentation = eAnnotation.getDetails().get("documentation");
				if (documentation != null) {
					csDocumentation.setValue(documentation);
				}
				return csDocumentation;
			}
			AnnotationCS csAnnotation = OCLinEcoreCSTFactory.eINSTANCE.createAnnotationCS();
			copyDetails(csAnnotation, eAnnotation, null);
			if (isId(source)) {
				csAnnotation.setIdSource(source);
			}
			else {
				csAnnotation.setStringSource(source);
			}
			doSwitchAll(csAnnotation.getContents(), eAnnotation.getContents());
			if (!eAnnotation.getReferences().isEmpty()) {
				deferMap.put(csAnnotation, eAnnotation);
			}
			return csAnnotation;
		}

		@Override
		public AttributeCS caseEAttribute(EAttribute eAttribute) {
			AttributeCS csAttribute = OCLinEcoreCSTFactory.eINSTANCE.createAttributeCS();
			copyStructuralFeature(csAttribute, eAttribute);
			EList<String> qualifiers = csAttribute.getQualifiers();
			setAttribute(qualifiers, "id", "!id", eAttribute, EcorePackage.Literals.EATTRIBUTE__ID);
			return csAttribute;
		}

		@Override
		public ClassCS caseEClass(EClass eClass) {
			ClassCS csClass = OCLinEcoreCSTFactory.eINSTANCE.createClassCS();
			copyClassifier(csClass, eClass);
			EList<String> qualifiers = csClass.getQualifiers();
			setAttribute(qualifiers, "abstract", "!abstract", eClass, EcorePackage.Literals.ECLASS__ABSTRACT);
			setAttribute(qualifiers, "interface", "!interface", eClass, EcorePackage.Literals.ECLASS__INTERFACE);
			doSwitchAll(csClass.getSuperTypes(), eClass.getEGenericSuperTypes());
			doSwitchAll(csClass.getOperations(), eClass.getEOperations());
			doSwitchAll(csClass.getStructuralFeatures(), eClass.getEStructuralFeatures());
			return csClass;
		}

		@Override
		public DataTypeCS caseEDataType(EDataType eDataType) {
			DataTypeCS csDataType = OCLinEcoreCSTFactory.eINSTANCE.createDataTypeCS();
			copyDataTypeOrEnum(csDataType, eDataType);
			return csDataType;
		}

		@Override
		public EnumCS caseEEnum(EEnum eEnum) {
			EnumCS csEnum = OCLinEcoreCSTFactory.eINSTANCE.createEnumCS();
			copyDataTypeOrEnum(csEnum, eEnum);
			doSwitchAll(csEnum.getLiterals(), eEnum.getELiterals());
			return csEnum;
		}

		@Override
		public EnumLiteralCS caseEEnumLiteral(EEnumLiteral eEnumLiteral) {
			EnumLiteralCS csEnumLiteral = OCLinEcoreCSTFactory.eINSTANCE.createEnumLiteralCS();
			copyNamedElement(csEnumLiteral, eEnumLiteral, null);
			csEnumLiteral.setValue(eEnumLiteral.getValue());
			String literal = basicGet(eEnumLiteral, EcorePackage.Literals.EENUM_LITERAL__LITERAL, String.class);
//			Enumerator instance = eEnumLiteral.getInstance();
			if (literal != null) {
				AnnotationCS csAnnotation = OCLinEcoreCSTFactory.eINSTANCE.createAnnotationCS();
				csAnnotation.setIdSource(EcorePackage.eNS_URI);
				if (literal != null) {
					DetailCS csDetail = OCLinEcoreCSTFactory.eINSTANCE.createDetailCS();
					csDetail.setIdName("literal");
					csDetail.setValue(literal);
					csAnnotation.getDetails().add(csDetail);
				}
//				if (instance != null) {
//					DetailCS csDetail = OCLinEcoreCSTFactory.eINSTANCE.createDetailCS();
//					csDetail.setIdName("instance");
//					csDetail.setValue(instance);
//					csAnnotation.getDetails().add(csDetail);
//				}
				csEnumLiteral.getAnnotations().add(csAnnotation);
			}
			return csEnumLiteral;
		}

		@Override
		public TypeRefCS caseEGenericType(EGenericType eGenericType) {
			EClassifier eClassifier = eGenericType.getEClassifier();
			if (eClassifier != null) {
				TypedTypeRefCS csTypeRef = OCLinEcoreCSTFactory.eINSTANCE.createTypedTypeRefCS();
				deferMap.put(csTypeRef, eGenericType);		// defer eGenericType.getETypeParameter()
				doSwitchAll(csTypeRef.getTypeArguments(), eGenericType.getETypeArguments());
				return csTypeRef;
			}
			else {
				ETypeParameter eTypeParameter = eGenericType.getETypeParameter();
				if (eTypeParameter != null) {
					TypedTypeRefCS csTypeRef = OCLinEcoreCSTFactory.eINSTANCE.createTypedTypeRefCS();
					deferMap.put(csTypeRef, eGenericType);		// defer eGenericType.getETypeParameter()
					return csTypeRef;				
				}
				else {
					WildcardTypeRefCS csTypeRef = OCLinEcoreCSTFactory.eINSTANCE.createWildcardTypeRefCS();
//					csTypeRef.setExtends(doSwitchAll(eGenericType.getExtends()));
//					csTypeRef.setSuper(doSwitchAll(eGenericType.getSuper()));
					return csTypeRef;
				}
			}
		}

		@Override
		public OperationCS caseEOperation(EOperation eOperation) {
			OperationCS csOperation = OCLinEcoreCSTFactory.eINSTANCE.createOperationCS();
			List<EAnnotation> excludedAnnotations =  null;
			EAnnotation oclAnnotation = eOperation.getEAnnotation(OCLDelegateDomain.OCL_DELEGATE_URI);
			if (oclAnnotation != null) {
				excludedAnnotations = new ArrayList<EAnnotation>();
				excludedAnnotations.add(oclAnnotation);
				List<ConstraintCS> csConstraints = csOperation.getConstraints();
				for (Map.Entry<String,String> entry : oclAnnotation.getDetails().entrySet()) {
					ConstraintCS csConstraint = OCLinEcoreCSTFactory.eINSTANCE.createConstraintCS();
					String key = entry.getKey();
					if (key.equals("body")) {
						csConstraint.setStereotype("body");
					}
					else if (key.startsWith("body_")) {
						csConstraint.setStereotype("body");
						csConstraint.setName(key.substring(5));
					}
					else if (key.equals("pre")) {
						csConstraint.setStereotype("precondition");
					}
					else if (key.startsWith("pre_")) {
						csConstraint.setStereotype("precondition");
						csConstraint.setName(key.substring(4));
					}
					else if (key.equals("post")) {
						csConstraint.setStereotype("postcondition");
					}
					else if (key.startsWith("post_")) {
						csConstraint.setStereotype("postcondition");
						csConstraint.setName(key.substring(5));
					}
					else
					{
						error("Unsupported operation constraint " + key);
						csConstraint = null;
					}
					if (csConstraint != null) {
						csConstraint.setExprString(entry.getValue());
						csConstraints.add(csConstraint);
					}
				}				
			}
			copyTypedElement(csOperation, eOperation, excludedAnnotations);
			doSwitchAll(csOperation.getParameters(), eOperation.getEParameters());
			doSwitchAll(csOperation.getTypeParameters(), eOperation.getETypeParameters());
			doSwitchAll(csOperation.getExceptions(), eOperation.getEGenericExceptions());
			return csOperation;
		}

		@Override
		public PackageCS caseEPackage(EPackage ePackage) {
			PackageCS csPackage = OCLinEcoreCSTFactory.eINSTANCE.createPackageCS();
			EAnnotation eAnnotation = ePackage.getEAnnotation(EcorePackage.eNS_URI);
			List<EAnnotation> exclusions = eAnnotation == null ? Collections.<EAnnotation>emptyList() : Collections.singletonList(eAnnotation);
			copyNamedElement(csPackage, ePackage, exclusions);
			String prefix = basicGet(ePackage, EcorePackage.Literals.EPACKAGE__NS_PREFIX, String.class);
			String uri = basicGet(ePackage, EcorePackage.Literals.EPACKAGE__NS_URI, String.class);
			if ((prefix != null) && (uri != null)) {
				csPackage.setPrefix(prefix);
				csPackage.setUri(uri);
			}
			doSwitchAll(csPackage.getSubpackages(), ePackage.getESubpackages());
			doSwitchAll(csPackage.getClassifiers(), ePackage.getEClassifiers());
			return csPackage;
		}

		@Override
		public ParameterCS caseEParameter(EParameter eParameter) {
			ParameterCS csParameter = OCLinEcoreCSTFactory.eINSTANCE.createParameterCS();
			copyTypedElement(csParameter, eParameter, null);
			return csParameter;
		}

		@Override
		public ReferenceCS caseEReference(EReference eReference) {
			ReferenceCS csReference = OCLinEcoreCSTFactory.eINSTANCE.createReferenceCS();
			copyStructuralFeature(csReference, eReference);
			if ((eReference.getEOpposite() != null) || !eReference.getEKeys().isEmpty()) {
				deferMap.put(csReference, eReference);	// Defer
			}
			EList<String> qualifiers = csReference.getQualifiers();
			setAttribute(qualifiers, "composes", "!composes", eReference, EcorePackage.Literals.EREFERENCE__CONTAINMENT);
			setAttribute(qualifiers, "resolve", "!resolve", eReference, EcorePackage.Literals.EREFERENCE__RESOLVE_PROXIES);
			return csReference;
		}

		@Override
		public ModelElementCS caseETypeParameter(ETypeParameter eTypeParameter) {
			TypeParameterCS csTypeParameter = OCLinEcoreCSTFactory.eINSTANCE.createTypeParameterCS();
			copyNamedElement(csTypeParameter, eTypeParameter, null);
			// FIXME super/... Bounds
			doSwitchAll(csTypeParameter.getExtends(), eTypeParameter.getEBounds());
			return csTypeParameter;
		}

		protected void copyClassifier(ClassifierCS csClassifier, EClassifier eClassifier) {
			List<EAnnotation> excludedAnnotations =  null;
			EMap<String, String> oclAnnotationDetails = null;
			EAnnotation oclAnnotation = eClassifier.getEAnnotation(OCLDelegateDomain.OCL_DELEGATE_URI);
			if (oclAnnotation != null) {
				excludedAnnotations = new ArrayList<EAnnotation>();
				excludedAnnotations.add(oclAnnotation);
				List<ConstraintCS> csConstraints = csClassifier.getConstraints();
				oclAnnotationDetails = oclAnnotation.getDetails();
				for (Map.Entry<String,String> entry : oclAnnotationDetails.entrySet()) {
					ConstraintCS csConstraint = OCLinEcoreCSTFactory.eINSTANCE.createConstraintCS();
					csConstraint.setStereotype("invariant");
					csConstraint.setName(entry.getKey());
					csConstraint.setExprString(entry.getValue());
					csConstraints.add(csConstraint);
				}				
			}
			EAnnotation ecoreAnnotation = eClassifier.getEAnnotation(EcorePackage.eNS_URI);
			if (ecoreAnnotation != null) {
				if (excludedAnnotations == null) {
					excludedAnnotations = new ArrayList<EAnnotation>();
				}
				excludedAnnotations.add(ecoreAnnotation);
				String constraintNameList = ecoreAnnotation.getDetails().get("constraints");
				if (constraintNameList != null) {
					List<ConstraintCS> csConstraints = csClassifier.getConstraints();
					String[] constraintNames = constraintNameList.split(" ");
					for (String constraintName : constraintNames) {
						if ((oclAnnotationDetails == null) || (oclAnnotationDetails.get(constraintName) == null)) {
							ConstraintCS csConstraint = OCLinEcoreCSTFactory.eINSTANCE.createConstraintCS();
							csConstraint.setStereotype("invariant");
							csConstraint.setName(constraintName);
							csConstraints.add(csConstraint);
						}
					}
				}
			}
			copyNamedElement(csClassifier, eClassifier, excludedAnnotations);
			String instanceClassName = basicGet(eClassifier, EcorePackage.Literals.ECLASSIFIER__INSTANCE_CLASS_NAME, String.class);
			if (instanceClassName != null)
				csClassifier.setInstanceClassName(instanceClassName);
			doSwitchAll(csClassifier.getTypeParameters(), eClassifier.getETypeParameters());
		}

		protected void copyDataTypeOrEnum(DataTypeOrEnumCS csDataType, EDataType eDataType) {
			copyClassifier(csDataType, eDataType);
			EList<String> qualifiers = csDataType.getQualifiers();
			setAttribute(qualifiers, "serializable", "!serializable", eDataType, EcorePackage.Literals.EDATA_TYPE__SERIALIZABLE);
		}

		protected void copyDetails(AnnotationElementCS csAnnotation, EAnnotation eAnnotation, List<String> excludedKeys) {
			copyModelElement(csAnnotation, eAnnotation, null);
			for (ListIterator<Map.Entry<String,String>> it = eAnnotation.getDetails().listIterator(); it.hasNext(); ) {
				Map.Entry<String,String> eDetail = it.next();
				String name = eDetail.getKey();
				if ((excludedKeys == null) || !excludedKeys.contains(name)) {
					DetailCS csDetail = OCLinEcoreCSTFactory.eINSTANCE.createDetailCS();
					if (isId(name)) {
						csDetail.setIdName(name);
					}
					else {
						csDetail.setStringName(name);
					}
					csDetail.setValue(eDetail.getValue());
					csAnnotation.getDetails().add(csDetail);
				}
			}
		}

		protected void copyModelElement(ModelElementCS csModelElement, EModelElement eModelElement, List<EAnnotation> excludedAnnotations) {
			createMap.put(eModelElement, csModelElement);
			List<AnnotationElementCS> csAnnotations = csModelElement.getAnnotations();
			for (EAnnotation eAnnotation : eModelElement.getEAnnotations()) {
				if ((excludedAnnotations == null) || !excludedAnnotations.contains(eAnnotation)) {
					AnnotationElementCS csAnnotation = (AnnotationElementCS) doSwitch(eAnnotation);
					csAnnotations.add(csAnnotation);
				}
			}
		}

		protected void copyNamedElement(NamedElementCS csNamedElement, ENamedElement eNamedElement, List<EAnnotation> excludedAnnotations) {
			copyModelElement(csNamedElement, eNamedElement, excludedAnnotations);
			csNamedElement.setName(eNamedElement.getName());
		}

		protected void copyStructuralFeature(StructuralFeatureCS csStructuralFeature, EStructuralFeature eStructuralFeature) {
			List<EAnnotation> excludedAnnotations =  null;
			EAnnotation oclAnnotation = eStructuralFeature.getEAnnotation(OCLDelegateDomain.OCL_DELEGATE_URI);
			if (oclAnnotation != null) {
				excludedAnnotations = new ArrayList<EAnnotation>();
				excludedAnnotations.add(oclAnnotation);
				List<ConstraintCS> csConstraints = csStructuralFeature.getConstraints();
				for (Map.Entry<String,String> entry : oclAnnotation.getDetails().entrySet()) {
					ConstraintCS csConstraint = OCLinEcoreCSTFactory.eINSTANCE.createConstraintCS();
					String key = entry.getKey();
					if (key.equals("derivation")) {
						csConstraint.setStereotype("derivation");
					}
					else if (key.equals("initial")) {
						csConstraint.setStereotype("initial");
					}
					else
					{
						error("Unsupported feature constraint " + key);
						csConstraint = null;
					}
					if (csConstraint != null) {
						csConstraint.setExprString(entry.getValue());
						csConstraints.add(csConstraint);
					}
				}				
			}
			copyTypedElement(csStructuralFeature, eStructuralFeature, excludedAnnotations);
			EList<String> qualifiers = csStructuralFeature.getQualifiers();
			setAttribute(qualifiers, "!readonly", "readonly", eStructuralFeature, EcorePackage.Literals.ESTRUCTURAL_FEATURE__CHANGEABLE);
			setAttribute(qualifiers, "derived", "!derived", eStructuralFeature, EcorePackage.Literals.ESTRUCTURAL_FEATURE__DERIVED);
			setAttribute(qualifiers, "transient", "!transient", eStructuralFeature, EcorePackage.Literals.ESTRUCTURAL_FEATURE__TRANSIENT);
			setAttribute(qualifiers, "unsettable", "!unsettable", eStructuralFeature, EcorePackage.Literals.ESTRUCTURAL_FEATURE__UNSETTABLE);
			setAttribute(qualifiers, "volatile", "!volatile", eStructuralFeature, EcorePackage.Literals.ESTRUCTURAL_FEATURE__VOLATILE);
			String defaultValueLiteral = basicGet(eStructuralFeature, EcorePackage.Literals.ESTRUCTURAL_FEATURE__DEFAULT_VALUE_LITERAL, String.class);
			if (defaultValueLiteral != null) {
				csStructuralFeature.setDefaultValueLiteral(defaultValueLiteral);
			}
		}

		protected void copyTypedElement(TypedElementCS csTypedElement, ETypedElement eTypedElement, List<EAnnotation> excludedAnnotations) {
			copyNamedElement(csTypedElement, eTypedElement, excludedAnnotations);
			EGenericType eGenericType = eTypedElement.getEGenericType();
			if (eGenericType != null) {
				ModelElementCS csType = doSwitch(eGenericType);
				csTypedElement.setType((TypeRefCS) csType);
			}
			int lower = eTypedElement.getLowerBound();
			int upper = eTypedElement.getUpperBound();
			if (upper == -1) {
				if (lower == 0) {
					csTypedElement.setMultiplicity("*");
				}
				else if (lower == 1) {
					csTypedElement.setMultiplicity("+");
				}
				else {
					csTypedElement.setLower(lower);
					csTypedElement.setUpper(upper);
				}
			}
			else if ((lower == 0) && (upper == 1)) {
				csTypedElement.setMultiplicity("?");	// Doesn't seem possible to leave this as default
//				csTypedElement.setLower(0);
//				csTypedElement.setUpper(1);
			}
			else {
				csTypedElement.setLower(lower);
				if (upper != lower) {
					csTypedElement.setUpper(upper);
				}
			}
			EList<String> qualifiers = csTypedElement.getQualifiers();
			setAttribute(qualifiers, "ordered", "!ordered", eTypedElement, EcorePackage.Literals.ETYPED_ELEMENT__ORDERED);
			setAttribute(qualifiers, "unique", "!unique", eTypedElement, EcorePackage.Literals.ETYPED_ELEMENT__UNIQUE);
		}

		@Override
		public ModelElementCS defaultCase(EObject object) {
			error("Unsupported " + object + " in pass1");
			return null;
		}

		public <T extends ModelElementCS> void doSwitchAll(List<T> csObjects, List<? extends EObject> eObjects) {
			for (EObject eObject : eObjects) {
				@SuppressWarnings("unchecked")
				T csObject = (T) doSwitch(eObject);
				csObjects.add(csObject);
			}
		}		

		protected void setAttribute(EList<String> qualifiers, String trueName, String falseName,
				EObject eObject, EAttribute eAttribute) {
			if (eObject.eIsSet(eAttribute)) {
				boolean isTrue = eObject.eGet(eAttribute) == Boolean.TRUE;
				qualifiers.add(isTrue ? trueName : falseName);
			}
		}
	};
	
	protected final OCLinEcoreCSTSwitch<Object> pass2 = new OCLinEcoreCSTSwitch<Object>()
	{
		@Override
		public Object caseAnnotationCS(AnnotationCS csAnnotation) {
			EAnnotation eAnnotation = (EAnnotation) deferMap.get(csAnnotation);
			for (EObject eReference : eAnnotation.getReferences()) {
				ObjectRef objectRef = copyObjectRef(eReference);
				if (objectRef != null) {
					csAnnotation.getReferences().add(objectRef);
				}
			}
			return null;
		}

		@Override
		public EObject caseReferenceCS(ReferenceCS csReference) {
			EReference eReference = (EReference) deferMap.get(csReference);
			ReferenceRef referenceRef = copyReferenceRef(eReference.getEOpposite());
			if (referenceRef != null) {
				csReference.setOpposite(referenceRef);
			}
			for (EAttribute eKey : eReference.getEKeys()) {
				AttributeRef attributeRef = copyAttributeRef(eKey);
				if (attributeRef != null) {
					csReference.getKeys().add(attributeRef);
				}
			}
			return null;
		}

		@Override
		public EObject caseTypedTypeRefCS(TypedTypeRefCS csTypeRef) {
			EGenericType eGenericType = (EGenericType) deferMap.get(csTypeRef);
			TypeRef typeRef = null;
			EClassifier eClassifier = eGenericType.getEClassifier();
			if (eClassifier != null) {
				ModelElementCS csObject = createMap.get(eClassifier);
				if (csObject instanceof ClassifierCS) {
					TypeCSRef typeCSRef = OCLinEcoreCSTFactory.eINSTANCE.createTypeCSRef();
					typeCSRef.setRef((ClassifierCS) csObject);
					typeRef = typeCSRef;
				}
				else if (csObject == null) {
					EClassifierCSRef eClassifierCSRef = OCLinEcoreCSTFactory.eINSTANCE.createEClassifierCSRef();
					eClassifierCSRef.setRef(eClassifier);
					eClassifierCSRef.setModelName(eClassifier.getEPackage().getNsPrefix());
					allEClassifiers.add(eClassifier);
					typeRef = eClassifierCSRef;
				}
				else {
					error("Unresolved " + eClassifier + " in pass2");
				}
			}
			else {
				ETypeParameter eTypeParameter = eGenericType.getETypeParameter();
				if (eTypeParameter != null) {
					TypeParameterCS csTypeParameter = (TypeParameterCS) createMap.get(eTypeParameter);
					TypeCSRef typeCSRef = OCLinEcoreCSTFactory.eINSTANCE.createTypeCSRef();
					typeCSRef.setRef(csTypeParameter);
					typeRef = typeCSRef;
				}
//				else {
//					error("Unresolved " + eGenericType + " in pass2");
//				}
			}
			if (typeRef != null) {
				csTypeRef.setType(typeRef);
			}
			return null;
		}

		protected AttributeRef copyAttributeRef(EAttribute eKey) {
			AttributeRef attributeRef = null;
			ModelElementCS csObject = createMap.get(eKey);
			if (csObject instanceof AttributeCS) {
				AttributeCSRef AttributeCSRef = OCLinEcoreCSTFactory.eINSTANCE.createAttributeCSRef();
				AttributeCSRef.setRef((AttributeCS) csObject);
				attributeRef = AttributeCSRef;
			}
			else if (csObject == null) {
				EAttributeRef eAttributeRef = OCLinEcoreCSTFactory.eINSTANCE.createEAttributeRef();
				eAttributeRef.setRef(eKey);
				attributeRef = eAttributeRef;
			}
			else {
				error("Unresolved " + eKey + " in pass2");
			}
			return attributeRef;
		}

		protected ObjectRef copyObjectRef(EObject eObject) {
			ObjectRef objectRef = null;
			ModelElementCS csObject = createMap.get(eObject);
			if (csObject != null) {
				ModelElementCSRef modelElementCSRef = OCLinEcoreCSTFactory.eINSTANCE.createModelElementCSRef();
				modelElementCSRef.setRef(csObject);
				objectRef = modelElementCSRef;
			}
			else {
				EObjectRef eObjectRef = OCLinEcoreCSTFactory.eINSTANCE.createEObjectRef();
				eObjectRef.setRef(eObject);
				objectRef = eObjectRef;
			}
			return objectRef;
		}

		protected ReferenceRef copyReferenceRef(EReference eOpposite) {
			ReferenceRef referenceRef = null;
			ModelElementCS csObject = createMap.get(eOpposite);
			if (csObject instanceof ReferenceCS) {
				ReferenceCSRef referenceCSRef = OCLinEcoreCSTFactory.eINSTANCE.createReferenceCSRef();
				referenceCSRef.setRef((ReferenceCS) csObject);
				referenceRef = referenceCSRef;
			}
			else if (csObject == null) {
				EReferenceRef eReferenceRef = OCLinEcoreCSTFactory.eINSTANCE.createEReferenceRef();
				eReferenceRef.setRef(eOpposite);
				referenceRef = eReferenceRef;
			}
			else {
				error("Unresolved " + eOpposite + " in pass2");
			}
			return referenceRef;
		}
	};
	
	public EObject convert(EObject eObject) {
		EObject csObject = pass1.doSwitch(eObject);
		for (EObject csKey : deferMap.keySet()) {
			pass2.doSwitch(csKey);
		}
		return csObject;
	}

	public List<EObject> convertAll(List<? extends EObject> eObjects) {
		List<EObject> csObjects = new ArrayList<EObject>();
		for (EObject eObject : eObjects) {
			csObjects.add(pass1.doSwitch(eObject));
		}
		for (ModelElementCS csKey : deferMap.keySet()) {
			pass2.doSwitch(csKey);
		}
		return csObjects;
	}
	
	public Collection<EPackage> getReferencedEPackages() {
		Set<EPackage> ePackages = new HashSet<EPackage>();
		for (EClassifier eClassifier : allEClassifiers) {
			ePackages.add(eClassifier.getEPackage());
		}
		return ePackages;
	}
}