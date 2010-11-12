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
 * $Id: Ecore2OCLinEcore.java,v 1.10 2010/08/17 18:55:40 ewillink Exp $
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

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.URI;
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
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreSwitch;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMIException;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.EMOFExtendedMetaData;
import org.eclipse.ocl.ecore.delegate.OCLDelegateDomain;
import org.eclipse.ocl.examples.xtext.base.baseCST.AnnotationElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.AttributeCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.AttributeCSRef;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTFactory;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.DetailCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.EnumLiteralCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ImportCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCSRef;
import org.eclipse.ocl.examples.xtext.base.baseCST.NamedElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.PackageCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ParameterCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.PrimitiveTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ReferenceCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ReferenceCSRef;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeParameterCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.WildcardTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.util.BaseCSTSwitch;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.AnnotationCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ConstraintCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DataTypeCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DataTypeOrEnumCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DocumentationCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EnumCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreAttributeCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreCSTFactory;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreCSTPackage;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreClassCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreClassifierCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreDocumentCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreOperationCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcorePackageCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreReferenceCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreStructuralFeatureCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.util.OCLinEcoreCSTSwitch;

public class Ecore2OCLinEcore extends AbstractConversion implements Adapter
{
	/**
	 * Convert an (annotated) Ecore resource to an Xtext CST document.
	 * @param alias 
	 * 
	 * @param ecoreResource the annotated Ecore resource
	 * 
	 * @return the Xtext CST document
	 */
	public static OCLinEcoreDocumentCS importFromEcore(ResourceSet resourceSet, String alias, Resource ecoreResource) {
		if (ecoreResource == null) {
			return null;
		}
		Ecore2OCLinEcore conversion = importDocument(resourceSet, ecoreResource);
		return conversion.getDocument();
	}

	public static Ecore2OCLinEcore importDocument(ResourceSet resourceSet, Resource ecoreResource) {
		EList<Adapter> eAdapters = ecoreResource.eAdapters();
		Ecore2OCLinEcore conversion = (Ecore2OCLinEcore) EcoreUtil.getAdapter(eAdapters, Ecore2OCLinEcore.class);
		if (conversion == null) {
			conversion = new Ecore2OCLinEcore(resourceSet);
			eAdapters.add(conversion);
		}
		return conversion;
	}

	/**
	 * Convert an (annotated) Ecore object to an Xtext CST element. 
	 * 
	 * @param eObject the annotated Ecore object
	 * 
	 * @return the Xtext CST element
	 */
	public static ModelElementCS importFromEcore(ResourceSet resourceSet, String alias, EObject eObject) {
		if (eObject == null) {
			return null;
		}
		Resource ecoreResource = eObject.eResource();
		Ecore2OCLinEcore conversion = importDocument(resourceSet, ecoreResource);
		OCLinEcoreDocumentCS documentCS = conversion.getDocument();
		if (documentCS == null) {
			return null;
		}
		return conversion.createMap.get(eObject);
	}

	/**
	 * Mapping of all created E elements to the resulting CS elements.
	 */
	private Map<EObject, ModelElementCS> createMap = new HashMap<EObject, ModelElementCS>();

	/**
	 * Set of all CS elements created during pass 1 that require further work in pass 2.
	 */
	private Set<ModelElementCS> deferred = new HashSet<ModelElementCS>();
	/**
	 * Set of all targets for EClassifierRef during session.
	 */
	private Set<EClassifier> allEClassifiers = new HashSet<EClassifier>();
	/**
	 * Set of all names during session.
	 */
	private Set<String> allNames = new HashSet<String>();

	/**
	 * Set of all aliases.
	 */
	private Map<String, EPackage> alias2ePackage = new HashMap<String, EPackage>();
	private Map<EPackage, String> ePackage2alias = new HashMap<EPackage, String>();
	
	private List<Resource.Diagnostic> errors = null;
	
	protected Resource ecoreResource;					// Set via eAdapters.add()
	
	protected OCLinEcoreDocumentCS documentCS = null;	// Set by importResource
	
	public Ecore2OCLinEcore(ResourceSet resourceSet) {
		super(resourceSet);
	}

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
				deferred.add(csAnnotation);
			}
			return csAnnotation;
		}

		@Override
		public OCLinEcoreAttributeCS caseEAttribute(EAttribute eAttribute) {
			OCLinEcoreAttributeCS csAttribute = OCLinEcoreCSTFactory.eINSTANCE.createOCLinEcoreAttributeCS();
			copyStructuralFeature(csAttribute, eAttribute, null);
			EList<String> qualifiers = csAttribute.getQualifiers();
			setAttribute(qualifiers, "id", "!id", eAttribute, EcorePackage.Literals.EATTRIBUTE__ID);
			return csAttribute;
		}

		@Override
		public OCLinEcoreClassCS caseEClass(EClass eClass) {
			OCLinEcoreClassCS csClass = OCLinEcoreCSTFactory.eINSTANCE.createOCLinEcoreClassCS();
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
			EnumLiteralCS csEnumLiteral = BaseCSTFactory.eINSTANCE.createEnumLiteralCS();
			copyNamedElement(csEnumLiteral, eEnumLiteral);
			copyAnnotatedElement(csEnumLiteral, eEnumLiteral, null);
			csEnumLiteral.setValue(eEnumLiteral.getValue());
			String literal = basicGet(eEnumLiteral, EcorePackage.Literals.EENUM_LITERAL__LITERAL, String.class);
//			Enumerator instance = eEnumLiteral.getInstance();
			if (literal != null) {
				AnnotationCS csAnnotation = OCLinEcoreCSTFactory.eINSTANCE.createAnnotationCS();
				csAnnotation.setIdSource(EcorePackage.eNS_URI);
				DetailCS csDetail = BaseCSTFactory.eINSTANCE.createDetailCS();
				csDetail.setIdName("literal");
				copyDetailLines(csDetail.getValue(), literal);
				csAnnotation.getDetails().add(csDetail);
				csEnumLiteral.getAnnotations().add(csAnnotation);
			}
			return csEnumLiteral;
		}

		@Override
		public TypeRefCS caseEGenericType(EGenericType eGenericType) {
			EClassifier eClassifier = eGenericType.getEClassifier();
			if ((eClassifier instanceof EDataType) && (eClassifier.getEPackage() == EcorePackage.eINSTANCE)) {
				String primitiveTypeName = null;
				if (eClassifier == EcorePackage.Literals.EBOOLEAN) {
					primitiveTypeName = "Boolean";
				}
				else if (eClassifier == EcorePackage.Literals.EBIG_INTEGER) {
					primitiveTypeName = "Integer";
				}
				else if (eClassifier == EcorePackage.Literals.EBIG_DECIMAL) {
					primitiveTypeName = "Real";
				}
				else if (eClassifier == EcorePackage.Literals.ESTRING) {
					primitiveTypeName = "String";
				}
				if (primitiveTypeName != null) {
					PrimitiveTypeRefCS csTypeRef = BaseCSTFactory.eINSTANCE.createPrimitiveTypeRefCS();
					csTypeRef.setName(primitiveTypeName);
					setOriginalMapping(csTypeRef, eGenericType);
					return csTypeRef;
				}
			}
			if (eClassifier != null) {
				TypedTypeRefCS csTypeRef = BaseCSTFactory.eINSTANCE.createTypedTypeRefCS();
				setOriginalMapping(csTypeRef, eGenericType);
				deferred.add(csTypeRef);		// defer eGenericType.getETypeParameter()
				doSwitchAll(csTypeRef.getTypeArguments(), eGenericType.getETypeArguments());
				return csTypeRef;
			}
			else {
				ETypeParameter eTypeParameter = eGenericType.getETypeParameter();
				if (eTypeParameter != null) {
					TypedTypeRefCS csTypeRef = BaseCSTFactory.eINSTANCE.createTypedTypeRefCS();
					setOriginalMapping(csTypeRef, eGenericType);
					deferred.add(csTypeRef);		// defer eGenericType.getETypeParameter()
					return csTypeRef;				
				}
				else {
					WildcardTypeRefCS csTypeRef = BaseCSTFactory.eINSTANCE.createWildcardTypeRefCS();
					setOriginalMapping(csTypeRef, eGenericType);
//					csTypeRef.setExtends(doSwitchAll(eGenericType.getExtends()));
//					csTypeRef.setSuper(doSwitchAll(eGenericType.getSuper()));
					return csTypeRef;
				}
			}
		}

		@Override
		public OCLinEcoreOperationCS caseEOperation(EOperation eOperation) {
			OCLinEcoreOperationCS csOperation = OCLinEcoreCSTFactory.eINSTANCE.createOCLinEcoreOperationCS();
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
			OCLinEcorePackageCS csPackage = OCLinEcoreCSTFactory.eINSTANCE.createOCLinEcorePackageCS();
			EAnnotation eAnnotation = ePackage.getEAnnotation(EcorePackage.eNS_URI);
			List<EAnnotation> exclusions = eAnnotation == null ? Collections.<EAnnotation>emptyList() : Collections.singletonList(eAnnotation);
			copyNamedElement(csPackage, ePackage);
			copyAnnotatedElement(csPackage, ePackage, exclusions);
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
			ParameterCS csParameter = BaseCSTFactory.eINSTANCE.createParameterCS();
			copyTypedElement(csParameter, eParameter, null);
			return csParameter;
		}

		@Override
		public OCLinEcoreReferenceCS caseEReference(EReference eReference) {
			OCLinEcoreReferenceCS csReference = OCLinEcoreCSTFactory.eINSTANCE.createOCLinEcoreReferenceCS();
			EAnnotation oppositeRole = null; // FIXME eReference.getEAnnotation(EMOFExtendedMetaData.EMOF_PROPERTY_OPPOSITE_ROLE_NAME_ANNOTATION_SOURCE);
			List<EAnnotation> excludedAnnotations = oppositeRole != null ? Collections.singletonList(oppositeRole) : null;
			copyStructuralFeature(csReference, eReference, excludedAnnotations);
			if ((eReference.getEOpposite() != null) || (excludedAnnotations != null) || !eReference.getEKeys().isEmpty()) {
				deferred.add(csReference);	// Defer
			}
			EList<String> qualifiers = csReference.getQualifiers();
			setAttribute(qualifiers, "composes", "!composes", eReference, EcorePackage.Literals.EREFERENCE__CONTAINMENT);
			setAttribute(qualifiers, "resolve", "!resolve", eReference, EcorePackage.Literals.EREFERENCE__RESOLVE_PROXIES);
			return csReference;
		}

		@Override
		public ModelElementCS caseETypeParameter(ETypeParameter eTypeParameter) {
			TypeParameterCS csTypeParameter = BaseCSTFactory.eINSTANCE.createTypeParameterCS();
			copyNamedElement(csTypeParameter, eTypeParameter);
			copyAnnotatedElement(csTypeParameter, eTypeParameter, null);
			// FIXME super/... Bounds
			doSwitchAll(csTypeParameter.getExtends(), eTypeParameter.getEBounds());
			return csTypeParameter;
		}

		protected void copyClassifier(OCLinEcoreClassifierCS csClassifier, EClassifier eClassifier) {
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
			copyNamedElement(csClassifier, eClassifier);
			copyAnnotatedElement(csClassifier, eClassifier, excludedAnnotations);
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


		public void copyDetailLines(List<String> lines, String value) {
			String[] splitLines = value.split("\n");
			for (int i = 0; i < splitLines.length-1; i++) {
				lines.add(splitLines[i] + '\n');
			}
			if (splitLines.length > 0) {
				lines.add(splitLines[splitLines.length-1]);
			}
		}

		protected void copyDetails(AnnotationElementCS csAnnotation, EAnnotation eAnnotation, List<String> excludedKeys) {
			copyModelElement(csAnnotation, eAnnotation);
			copyAnnotatedElement(csAnnotation, eAnnotation, null);
			for (ListIterator<Map.Entry<String,String>> it = eAnnotation.getDetails().listIterator(); it.hasNext(); ) {
				Map.Entry<String,String> eDetail = it.next();
				String name = eDetail.getKey();
				if ((excludedKeys == null) || !excludedKeys.contains(name)) {
					DetailCS csDetail = BaseCSTFactory.eINSTANCE.createDetailCS();
					if (isId(name)) {
						csDetail.setIdName(name);
					}
					else {
						csDetail.setStringName(name);
					}
					copyDetailLines(csDetail.getValue(), eDetail.getValue());
					csAnnotation.getDetails().add(csDetail);
				}
			}
		}

		protected void copyModelElement(ModelElementCS csModelElement, EModelElement eModelElement) {
			setOriginalMapping(csModelElement, eModelElement);
		}

		protected void copyAnnotatedElement(
				ModelElementCS csModelElement,
				EModelElement eModelElement,
				List<EAnnotation> excludedAnnotations) {
			List<AnnotationElementCS> csAnnotations = csModelElement.getAnnotations();
			for (EAnnotation eAnnotation : eModelElement.getEAnnotations()) {
				if ((excludedAnnotations == null) || !excludedAnnotations.contains(eAnnotation)) {
					AnnotationElementCS csAnnotation = (AnnotationElementCS) doSwitch(eAnnotation);
					csAnnotations.add(csAnnotation);
				}
			}
		}

		public void setOriginalMapping(ModelElementCS csModelElement, EObject eModelElement) {
			csModelElement.setOriginalObject(eModelElement);
			if (ecoreResource instanceof XMLResource) {
				String xmiId = ((XMLResource)ecoreResource).getID(eModelElement);
				if (xmiId != null) {
					csModelElement.setOriginalXmiId(xmiId);
				}
			}
			createMap.put(eModelElement, csModelElement);
		}

		protected void copyNamedElement(NamedElementCS csNamedElement, ENamedElement eNamedElement) {
			copyModelElement(csNamedElement, eNamedElement);
			String name = eNamedElement.getName();
			csNamedElement.setName(name);
			allNames.add(name);
		}

		protected void copyStructuralFeature(OCLinEcoreStructuralFeatureCS csStructuralFeature, EStructuralFeature eStructuralFeature, List<EAnnotation> excludedAnnotations) {
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
			copyNamedElement(csTypedElement, eTypedElement);
			copyAnnotatedElement(csTypedElement, eTypedElement, excludedAnnotations);
			EGenericType eGenericType = eTypedElement.getEGenericType();
			if (eGenericType != null) {
				EClassifier eClassifier = eGenericType.getEClassifier();
				if (eClassifier != null) {
					allEClassifiers.add(eClassifier);
				}
				ModelElementCS csType = doSwitch(eGenericType);
				csTypedElement.setType((TypedRefCS) csType);
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
		protected final BaseCSTSwitch<EObject> emofPass2 = new BaseCSTSwitch<EObject>()
		{				
			@Override
			public EObject caseTypedTypeRefCS(TypedTypeRefCS csTypeRef) {
				EGenericType eGenericType = (EGenericType) csTypeRef.getOriginalObject();
				EClassifier eClassifier = eGenericType.getEClassifier();
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
				}
				return null;
			}
		};
		
		@Override
		public Object caseAnnotationCS(AnnotationCS csAnnotation) {
			EAnnotation eAnnotation = (EAnnotation) csAnnotation.getOriginalObject();
			for (EObject eReference : eAnnotation.getReferences()) {
				ModelElementCSRef objectRef = copyObjectRef(eReference);
				if (objectRef != null) {
					csAnnotation.getReferences().add(objectRef);
				}
			}
			return null;
		}

		@Override
		public EObject caseOCLinEcoreReferenceCS(OCLinEcoreReferenceCS csReference) {
			EReference eReference = (EReference) csReference.getOriginalObject();
			EReference eOpposite = eReference.getEOpposite();
			if (eOpposite == null) {
				EAnnotation oppositeRole = eReference.getEAnnotation(EMOFExtendedMetaData.EMOF_PROPERTY_OPPOSITE_ROLE_NAME_ANNOTATION_SOURCE);
				if (oppositeRole != null) {
					String oppositeName = oppositeRole.getDetails().get(EMOFExtendedMetaData.EMOF_COMMENT_BODY);
					EClass eReferenceType = eReference.getEReferenceType();
					eOpposite = (EReference) eReferenceType.getEStructuralFeature(oppositeName);	// FIXME Always null
				}
			}
			if (eOpposite != null) {
				ReferenceCSRef referenceRef = copyReferenceRef(eOpposite);
				if (referenceRef != null) {
					csReference.setOpposite(referenceRef);
				}
			}
			for (EAttribute eKey : eReference.getEKeys()) {
				AttributeCSRef attributeRef = copyAttributeRef(eKey);
				if (attributeRef != null) {
					csReference.getKeys().add(attributeRef);
				}
			}
			return null;
		}

		protected AttributeCSRef copyAttributeRef(EAttribute eKey) {
			AttributeCSRef attributeRef = null;
			ModelElementCS csObject = createMap.get(eKey);
			if (csObject instanceof OCLinEcoreAttributeCS) {
				AttributeCSRef AttributeCSRef = BaseCSTFactory.eINSTANCE.createAttributeCSRef();
				AttributeCSRef.setRef((AttributeCS) csObject);
				attributeRef = AttributeCSRef;
			}
			else {
				error("Unresolved " + eKey + " in pass2");
			}
			return attributeRef;
		}

		protected ModelElementCSRef copyObjectRef(EObject eObject) {
			ModelElementCSRef objectRef = null;
			ModelElementCS csObject = createMap.get(eObject);
			if (csObject != null) {
				ModelElementCSRef modelElementCSRef = BaseCSTFactory.eINSTANCE.createModelElementCSRef();
				modelElementCSRef.setRef(csObject);
				objectRef = modelElementCSRef;
			}
			else {
				error("Unresolved " + eObject + " in pass2");
			}
			return objectRef;
		}

		protected ReferenceCSRef copyReferenceRef(EReference eOpposite) {
			ReferenceCSRef referenceRef = null;
			ModelElementCS csObject = createMap.get(eOpposite);
			if (csObject instanceof OCLinEcoreReferenceCS) {
				ReferenceCSRef referenceCSRef = BaseCSTFactory.eINSTANCE.createReferenceCSRef();
				referenceCSRef.setRef((ReferenceCS) csObject);
				referenceRef = referenceCSRef;
			}
			else {
				error("Unresolved " + eOpposite + " in pass2");
			}
			return referenceRef;
		}

		@Override
		public EObject doSwitch(EObject eObject) {
			EPackage ePackage = eObject.eClass().getEPackage();
			if (ePackage == BaseCSTPackage.eINSTANCE) {
				return emofPass2.doSwitch(eObject);
			}
			else {
				return (EObject) super.doSwitch(eObject);
			}
		}
	};

	protected void error(String message) {
		if (errors == null) {
			errors = new ArrayList<Resource.Diagnostic>();
		}
		errors.add(new XMIException(message));
	}
	
	public <T extends ModelElementCS> T getCS(EObject eObject, Class<T> csClass) {
		ModelElementCS csModelElement = createMap.get(eObject);
		if (csModelElement == null) {
			Resource resource = eObject.eResource();
			if (resource != null) {
				Ecore2OCLinEcore conversion = importDocument(resourceSet, resource);
				OCLinEcoreDocumentCS importResource = conversion.getDocument();
				allEClassifiers.addAll(conversion.allEClassifiers);
				allNames.addAll(conversion.allNames);
				for (Map.Entry<EObject, ModelElementCS> entry : conversion.createMap.entrySet()) {
					createMap.put(entry.getKey(), entry.getValue());
				}
				URI uri = resource.getURI();
				if (uri != null) {
					importResource.setName(uri.lastSegment());
				}
			}
		}
		csModelElement = createMap.get(eObject);
		if (csModelElement == null) {
			error("Unresolved " + eObject);
		}
		else if (!csClass.isAssignableFrom(csModelElement.getClass())) {
			error("Incompatible " + eObject);
		}
		else {
			@SuppressWarnings("unchecked")
			T castModelElement = (T) csModelElement;
			return castModelElement;
		}
		return null;
	}
	
	public Collection<EPackage> getReferencedEPackages() {
		Set<EPackage> ePackages = new HashSet<EPackage>();
		for (EClassifier eClassifier : allEClassifiers) {
			EPackage ePackage = eClassifier.getEPackage();
			if (ePackage != null)
				ePackages.add(ePackage);
		}
		return ePackages;
	}
	
	public OCLinEcoreDocumentCS getDocument() {
		if (documentCS == null) {
			importResource();
		}
		return documentCS;
	}

	protected void importResource() {
		URI oclinecoreURI = ecoreResource.getURI().appendFileExtension("oclinecore");
		Resource xtextResource = resourceSet.createResource(oclinecoreURI, OCLinEcoreCSTPackage.eCONTENT_TYPE);
		documentCS = OCLinEcoreCSTFactory.eINSTANCE.createOCLinEcoreDocumentCS();
		xtextResource.getContents().add(documentCS);
		List<OCLinEcorePackageCS> packages = documentCS.getPackages();
		for (EObject eObject : ecoreResource.getContents()) {
			packages.add((OCLinEcorePackageCS) pass1.doSwitch(eObject));
		}
		for (ModelElementCS csModelElement : deferred) {
			pass2.doSwitch(csModelElement);
		}
		List<EPackage> ePackages = new ArrayList<EPackage>(getReferencedEPackages());
		// sort
		List<ImportCS> imports = documentCS.getImports();
		for (EPackage ePackage : ePackages) {
			ModelElementCS csElement = createMap.get(ePackage);
			if ((csElement != null) && (csElement.eResource() == xtextResource)) {
				continue;		// Don't import defined packages
			}
			ImportCS importCS = BaseCSTFactory.eINSTANCE.createImportCS();
			String alias = ePackage2alias.get(ePackage);
			if (alias == null) {
				alias = ePackage.getNsPrefix();
				String suffixedAlias = alias;
				for (int i = 0; alias2ePackage.containsKey(suffixedAlias) || allNames.contains(suffixedAlias); i++) {
					suffixedAlias = alias + "_" + i;
				}
				alias = suffixedAlias;
				alias2ePackage.put(alias, ePackage);
				ePackage2alias.put(ePackage, alias);
			}
			importCS.setName(alias);
			URI fullURI = EcoreUtil.getURI(ePackage);
			URI deresolvedURI = fullURI.deresolve(oclinecoreURI);
			importCS.setUri(deresolvedURI.toString());
			PackageCS csPackage = getCS(ePackage, PackageCS.class);
			importCS.setNamespace(csPackage);
			imports.add(importCS);
		}
		if (errors != null) {
			xtextResource.getErrors().addAll(errors);
		}
	}

	public boolean isAdapterForType(Object type) {
		return type == Ecore2OCLinEcore.class;
	}

	public void notifyChanged(Notification notification) {}

	public Notifier getTarget() {
		return ecoreResource;
	}

	public void setTarget(Notifier newTarget) {
		ecoreResource = (Resource) newTarget;
	}
}