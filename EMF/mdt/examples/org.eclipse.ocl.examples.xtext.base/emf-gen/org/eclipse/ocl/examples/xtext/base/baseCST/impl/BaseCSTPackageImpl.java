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
 * $Id: BaseCSTPackageImpl.java,v 1.7 2010/08/17 18:53:39 ewillink Exp $
 */

package org.eclipse.ocl.examples.xtext.base.baseCST.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.ocl.examples.xtext.base.baseCST.AnnotationElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.AttributeCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.AttributeCSRef;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTFactory;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.base.baseCST.BoundClassCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.BoundClassifierCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.BoundDocumentCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.BoundElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.BoundOperationCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ClassCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ClassCSRef;
import org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.CollectionTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.DetailCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.DocumentCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.EnumLiteralCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.FeatureCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ImportCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.LibraryCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCSRef;
import org.eclipse.ocl.examples.xtext.base.baseCST.NamedElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.NamespaceCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.OperationCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.OperationRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.PackageCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.PackageRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ParameterCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ParameterizedTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.PrimitiveTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.QualifiedClassifierRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.QualifiedOperationRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.QualifiedPackageRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.QualifiedRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.QualifiedStructuralFeatureRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.QualifiedTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ReferenceCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ReferenceCSRef;
import org.eclipse.ocl.examples.xtext.base.baseCST.SimpleClassifierRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.SimpleOperationRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.SimplePackageRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.SimpleStructuralFeatureRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.StructuralFeatureCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.StructuralFeatureRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeBindingCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeBindingsCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeParameterCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.WildcardTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.util.Signature;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class BaseCSTPackageImpl extends EPackageImpl implements BaseCSTPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass annotationElementCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeCSRefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass boundClassCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass boundClassifierCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass boundDocumentCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass boundElementCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass boundOperationCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classCSRefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classifierCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classifierRefCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass collectionTypeRefCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass detailCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass documentCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass elementCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enumLiteralCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass importCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass libraryCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelElementCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelElementCSRefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass namedElementCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass namespaceCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operationCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operationRefCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass packageCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass packageRefCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterizedTypeRefCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass primitiveTypeRefCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass qualifiedClassifierRefCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass qualifiedOperationRefCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass qualifiedPackageRefCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass qualifiedRefCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass qualifiedStructuralFeatureRefCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass qualifiedTypeRefCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass referenceCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass referenceCSRefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass simpleClassifierRefCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass simpleOperationRefCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass simplePackageRefCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass simpleStructuralFeatureRefCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass structuralFeatureCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass structuralFeatureRefCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeBindingCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeBindingsCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeParameterCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeRefCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typedElementCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typedRefCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typedTypeRefCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass wildcardTypeRefCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType signatureEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private BaseCSTPackageImpl() {
		super(eNS_URI, BaseCSTFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link BaseCSTPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static BaseCSTPackage init() {
		if (isInited) return (BaseCSTPackage)EPackage.Registry.INSTANCE.getEPackage(BaseCSTPackage.eNS_URI);

		// Obtain or create and register package
		BaseCSTPackageImpl theBaseCSTPackage = (BaseCSTPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof BaseCSTPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new BaseCSTPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theBaseCSTPackage.createPackageContents();

		// Initialize created meta-data
		theBaseCSTPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theBaseCSTPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(BaseCSTPackage.eNS_URI, theBaseCSTPackage);
		return theBaseCSTPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAnnotationElementCS() {
		return annotationElementCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnnotationElementCS_Details() {
		return (EReference)annotationElementCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttributeCS() {
		return attributeCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttributeCSRef() {
		return attributeCSRefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAttributeCSRef_Ref() {
		return (EReference)attributeCSRefEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBoundClassCS() {
		return boundClassCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBoundClassifierCS() {
		return boundClassifierCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBoundDocumentCS() {
		return boundDocumentCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBoundElementCS() {
		return boundElementCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBoundElementCS_Bindings() {
		return (EReference)boundElementCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBoundElementCS_Binds() {
		return (EReference)boundElementCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBoundOperationCS() {
		return boundOperationCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassCS() {
		return classCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassCS_SuperTypes() {
		return (EReference)classCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassCS_Operations() {
		return (EReference)classCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassCS_StructuralFeatures() {
		return (EReference)classCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassCSRef() {
		return classCSRefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassCSRef_Ref() {
		return (EReference)classCSRefEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassifierCS() {
		return classifierCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassifierCS_TypeParameters() {
		return (EReference)classifierCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassifierCS_Owner() {
		return (EReference)classifierCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassifierRefCS() {
		return classifierRefCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCollectionTypeRefCS() {
		return collectionTypeRefCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollectionTypeRefCS_TypeArguments() {
		return (EReference)collectionTypeRefCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDetailCS() {
		return detailCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDetailCS_IdName() {
		return (EAttribute)detailCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDetailCS_StringName() {
		return (EAttribute)detailCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDetailCS_Value() {
		return (EAttribute)detailCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDocumentCS() {
		return documentCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentCS_Imports() {
		return (EReference)documentCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDocumentCS_Libraries() {
		return (EReference)documentCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getElementCS() {
		return elementCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnumLiteralCS() {
		return enumLiteralCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnumLiteralCS_Value() {
		return (EAttribute)enumLiteralCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFeatureCS() {
		return featureCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeatureCS_IsStatic() {
		return (EAttribute)featureCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFeatureCS_IsDefinition() {
		return (EAttribute)featureCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getImportCS() {
		return importCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getImportCS_Uri() {
		return (EAttribute)importCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getImportCS_Namespace() {
		return (EReference)importCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLibraryCS() {
		return libraryCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLibraryCS_Package() {
		return (EReference)libraryCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModelElementCS() {
		return modelElementCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelElementCS_Annotations() {
		return (EReference)modelElementCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelElementCS_OriginalObject() {
		return (EReference)modelElementCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getModelElementCS_OriginalXmiId() {
		return (EAttribute)modelElementCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModelElementCSRef() {
		return modelElementCSRefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelElementCSRef_Ref() {
		return (EReference)modelElementCSRefEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNamedElementCS() {
		return namedElementCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNamedElementCS_Name() {
		return (EAttribute)namedElementCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNamespaceCS() {
		return namespaceCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOperationCS() {
		return operationCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperationCS_Parameters() {
		return (EReference)operationCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperationCS_TypeParameters() {
		return (EReference)operationCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperationCS_Owner() {
		return (EReference)operationCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOperationRefCS() {
		return operationRefCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPackageCS() {
		return packageCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPackageCS_Classifiers() {
		return (EReference)packageCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPackageCS_Subpackages() {
		return (EReference)packageCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPackageCS_Prefix() {
		return (EAttribute)packageCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPackageCS_Uri() {
		return (EAttribute)packageCSEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPackageRefCS() {
		return packageRefCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParameterCS() {
		return parameterCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParameterCS_Owner() {
		return (EReference)parameterCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParameterizedTypeRefCS() {
		return parameterizedTypeRefCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParameterizedTypeRefCS_TypeArguments() {
		return (EReference)parameterizedTypeRefCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPrimitiveTypeRefCS() {
		return primitiveTypeRefCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getQualifiedClassifierRefCS() {
		return qualifiedClassifierRefCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getQualifiedOperationRefCS() {
		return qualifiedOperationRefCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getQualifiedPackageRefCS() {
		return qualifiedPackageRefCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getQualifiedRefCS() {
		return qualifiedRefCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getQualifiedRefCS_Namespace() {
		return (EReference)qualifiedRefCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getQualifiedRefCS_Element() {
		return (EReference)qualifiedRefCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getQualifiedStructuralFeatureRefCS() {
		return qualifiedStructuralFeatureRefCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getQualifiedTypeRefCS() {
		return qualifiedTypeRefCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReferenceCS() {
		return referenceCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReferenceCS_Opposite() {
		return (EReference)referenceCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReferenceCSRef() {
		return referenceCSRefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReferenceCSRef_Ref() {
		return (EReference)referenceCSRefEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSimpleClassifierRefCS() {
		return simpleClassifierRefCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSimpleClassifierRefCS_Classifier() {
		return (EReference)simpleClassifierRefCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSimpleOperationRefCS() {
		return simpleOperationRefCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSimpleOperationRefCS_Operation() {
		return (EReference)simpleOperationRefCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSimplePackageRefCS() {
		return simplePackageRefCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSimplePackageRefCS_Package() {
		return (EReference)simplePackageRefCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSimpleStructuralFeatureRefCS() {
		return simpleStructuralFeatureRefCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSimpleStructuralFeatureRefCS_Feature() {
		return (EReference)simpleStructuralFeatureRefCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStructuralFeatureCS() {
		return structuralFeatureCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStructuralFeatureCS_Owner() {
		return (EReference)structuralFeatureCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStructuralFeatureRefCS() {
		return structuralFeatureRefCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypeBindingCS() {
		return typeBindingCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTypeBindingCS_TypeParameter() {
		return (EReference)typeBindingCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTypeBindingCS_TypeArgument() {
		return (EReference)typeBindingCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypeBindingsCS() {
		return typeBindingsCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTypeBindingsCS_BoundDocument() {
		return (EReference)typeBindingsCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTypeBindingsCS_Bindings() {
		return (EReference)typeBindingsCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTypeBindingsCS_Nested() {
		return (EReference)typeBindingsCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypeCS() {
		return typeCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypeParameterCS() {
		return typeParameterCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTypeParameterCS_Extends() {
		return (EReference)typeParameterCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTypeParameterCS_Super() {
		return (EReference)typeParameterCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypeRefCS() {
		return typeRefCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypedElementCS() {
		return typedElementCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTypedElementCS_Lower() {
		return (EAttribute)typedElementCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTypedElementCS_Multiplicity() {
		return (EAttribute)typedElementCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTypedElementCS_Qualifiers() {
		return (EAttribute)typedElementCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTypedElementCS_Type() {
		return (EReference)typedElementCSEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTypedElementCS_Upper() {
		return (EAttribute)typedElementCSEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypedRefCS() {
		return typedRefCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypedTypeRefCS() {
		return typedTypeRefCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTypedTypeRefCS_Type() {
		return (EReference)typedTypeRefCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWildcardTypeRefCS() {
		return wildcardTypeRefCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWildcardTypeRefCS_Extends() {
		return (EReference)wildcardTypeRefCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWildcardTypeRefCS_Super() {
		return (EReference)wildcardTypeRefCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getSignature() {
		return signatureEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BaseCSTFactory getBaseCSTFactory() {
		return (BaseCSTFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		annotationElementCSEClass = createEClass(ANNOTATION_ELEMENT_CS);
		createEReference(annotationElementCSEClass, ANNOTATION_ELEMENT_CS__DETAILS);

		attributeCSEClass = createEClass(ATTRIBUTE_CS);

		attributeCSRefEClass = createEClass(ATTRIBUTE_CS_REF);
		createEReference(attributeCSRefEClass, ATTRIBUTE_CS_REF__REF);

		boundClassCSEClass = createEClass(BOUND_CLASS_CS);

		boundClassifierCSEClass = createEClass(BOUND_CLASSIFIER_CS);

		boundDocumentCSEClass = createEClass(BOUND_DOCUMENT_CS);

		boundElementCSEClass = createEClass(BOUND_ELEMENT_CS);
		createEReference(boundElementCSEClass, BOUND_ELEMENT_CS__BINDINGS);
		createEReference(boundElementCSEClass, BOUND_ELEMENT_CS__BINDS);

		boundOperationCSEClass = createEClass(BOUND_OPERATION_CS);

		classCSEClass = createEClass(CLASS_CS);
		createEReference(classCSEClass, CLASS_CS__SUPER_TYPES);
		createEReference(classCSEClass, CLASS_CS__OPERATIONS);
		createEReference(classCSEClass, CLASS_CS__STRUCTURAL_FEATURES);

		classCSRefEClass = createEClass(CLASS_CS_REF);
		createEReference(classCSRefEClass, CLASS_CS_REF__REF);

		classifierCSEClass = createEClass(CLASSIFIER_CS);
		createEReference(classifierCSEClass, CLASSIFIER_CS__TYPE_PARAMETERS);
		createEReference(classifierCSEClass, CLASSIFIER_CS__OWNER);

		classifierRefCSEClass = createEClass(CLASSIFIER_REF_CS);

		collectionTypeRefCSEClass = createEClass(COLLECTION_TYPE_REF_CS);
		createEReference(collectionTypeRefCSEClass, COLLECTION_TYPE_REF_CS__TYPE_ARGUMENTS);

		detailCSEClass = createEClass(DETAIL_CS);
		createEAttribute(detailCSEClass, DETAIL_CS__ID_NAME);
		createEAttribute(detailCSEClass, DETAIL_CS__STRING_NAME);
		createEAttribute(detailCSEClass, DETAIL_CS__VALUE);

		documentCSEClass = createEClass(DOCUMENT_CS);
		createEReference(documentCSEClass, DOCUMENT_CS__IMPORTS);
		createEReference(documentCSEClass, DOCUMENT_CS__LIBRARIES);

		elementCSEClass = createEClass(ELEMENT_CS);

		enumLiteralCSEClass = createEClass(ENUM_LITERAL_CS);
		createEAttribute(enumLiteralCSEClass, ENUM_LITERAL_CS__VALUE);

		featureCSEClass = createEClass(FEATURE_CS);
		createEAttribute(featureCSEClass, FEATURE_CS__IS_STATIC);
		createEAttribute(featureCSEClass, FEATURE_CS__IS_DEFINITION);

		importCSEClass = createEClass(IMPORT_CS);
		createEAttribute(importCSEClass, IMPORT_CS__URI);
		createEReference(importCSEClass, IMPORT_CS__NAMESPACE);

		libraryCSEClass = createEClass(LIBRARY_CS);
		createEReference(libraryCSEClass, LIBRARY_CS__PACKAGE);

		modelElementCSEClass = createEClass(MODEL_ELEMENT_CS);
		createEReference(modelElementCSEClass, MODEL_ELEMENT_CS__ANNOTATIONS);
		createEReference(modelElementCSEClass, MODEL_ELEMENT_CS__ORIGINAL_OBJECT);
		createEAttribute(modelElementCSEClass, MODEL_ELEMENT_CS__ORIGINAL_XMI_ID);

		modelElementCSRefEClass = createEClass(MODEL_ELEMENT_CS_REF);
		createEReference(modelElementCSRefEClass, MODEL_ELEMENT_CS_REF__REF);

		namedElementCSEClass = createEClass(NAMED_ELEMENT_CS);
		createEAttribute(namedElementCSEClass, NAMED_ELEMENT_CS__NAME);

		namespaceCSEClass = createEClass(NAMESPACE_CS);

		operationCSEClass = createEClass(OPERATION_CS);
		createEReference(operationCSEClass, OPERATION_CS__PARAMETERS);
		createEReference(operationCSEClass, OPERATION_CS__TYPE_PARAMETERS);
		createEReference(operationCSEClass, OPERATION_CS__OWNER);

		operationRefCSEClass = createEClass(OPERATION_REF_CS);

		packageCSEClass = createEClass(PACKAGE_CS);
		createEReference(packageCSEClass, PACKAGE_CS__CLASSIFIERS);
		createEReference(packageCSEClass, PACKAGE_CS__SUBPACKAGES);
		createEAttribute(packageCSEClass, PACKAGE_CS__PREFIX);
		createEAttribute(packageCSEClass, PACKAGE_CS__URI);

		packageRefCSEClass = createEClass(PACKAGE_REF_CS);

		parameterCSEClass = createEClass(PARAMETER_CS);
		createEReference(parameterCSEClass, PARAMETER_CS__OWNER);

		parameterizedTypeRefCSEClass = createEClass(PARAMETERIZED_TYPE_REF_CS);
		createEReference(parameterizedTypeRefCSEClass, PARAMETERIZED_TYPE_REF_CS__TYPE_ARGUMENTS);

		primitiveTypeRefCSEClass = createEClass(PRIMITIVE_TYPE_REF_CS);

		qualifiedClassifierRefCSEClass = createEClass(QUALIFIED_CLASSIFIER_REF_CS);

		qualifiedOperationRefCSEClass = createEClass(QUALIFIED_OPERATION_REF_CS);

		qualifiedPackageRefCSEClass = createEClass(QUALIFIED_PACKAGE_REF_CS);

		qualifiedRefCSEClass = createEClass(QUALIFIED_REF_CS);
		createEReference(qualifiedRefCSEClass, QUALIFIED_REF_CS__NAMESPACE);
		createEReference(qualifiedRefCSEClass, QUALIFIED_REF_CS__ELEMENT);

		qualifiedStructuralFeatureRefCSEClass = createEClass(QUALIFIED_STRUCTURAL_FEATURE_REF_CS);

		qualifiedTypeRefCSEClass = createEClass(QUALIFIED_TYPE_REF_CS);

		referenceCSEClass = createEClass(REFERENCE_CS);
		createEReference(referenceCSEClass, REFERENCE_CS__OPPOSITE);

		referenceCSRefEClass = createEClass(REFERENCE_CS_REF);
		createEReference(referenceCSRefEClass, REFERENCE_CS_REF__REF);

		simpleClassifierRefCSEClass = createEClass(SIMPLE_CLASSIFIER_REF_CS);
		createEReference(simpleClassifierRefCSEClass, SIMPLE_CLASSIFIER_REF_CS__CLASSIFIER);

		simpleOperationRefCSEClass = createEClass(SIMPLE_OPERATION_REF_CS);
		createEReference(simpleOperationRefCSEClass, SIMPLE_OPERATION_REF_CS__OPERATION);

		simplePackageRefCSEClass = createEClass(SIMPLE_PACKAGE_REF_CS);
		createEReference(simplePackageRefCSEClass, SIMPLE_PACKAGE_REF_CS__PACKAGE);

		simpleStructuralFeatureRefCSEClass = createEClass(SIMPLE_STRUCTURAL_FEATURE_REF_CS);
		createEReference(simpleStructuralFeatureRefCSEClass, SIMPLE_STRUCTURAL_FEATURE_REF_CS__FEATURE);

		structuralFeatureCSEClass = createEClass(STRUCTURAL_FEATURE_CS);
		createEReference(structuralFeatureCSEClass, STRUCTURAL_FEATURE_CS__OWNER);

		structuralFeatureRefCSEClass = createEClass(STRUCTURAL_FEATURE_REF_CS);

		typeBindingCSEClass = createEClass(TYPE_BINDING_CS);
		createEReference(typeBindingCSEClass, TYPE_BINDING_CS__TYPE_PARAMETER);
		createEReference(typeBindingCSEClass, TYPE_BINDING_CS__TYPE_ARGUMENT);

		typeBindingsCSEClass = createEClass(TYPE_BINDINGS_CS);
		createEReference(typeBindingsCSEClass, TYPE_BINDINGS_CS__BOUND_DOCUMENT);
		createEReference(typeBindingsCSEClass, TYPE_BINDINGS_CS__BINDINGS);
		createEReference(typeBindingsCSEClass, TYPE_BINDINGS_CS__NESTED);

		typeCSEClass = createEClass(TYPE_CS);

		typeParameterCSEClass = createEClass(TYPE_PARAMETER_CS);
		createEReference(typeParameterCSEClass, TYPE_PARAMETER_CS__EXTENDS);
		createEReference(typeParameterCSEClass, TYPE_PARAMETER_CS__SUPER);

		typeRefCSEClass = createEClass(TYPE_REF_CS);

		typedElementCSEClass = createEClass(TYPED_ELEMENT_CS);
		createEAttribute(typedElementCSEClass, TYPED_ELEMENT_CS__LOWER);
		createEAttribute(typedElementCSEClass, TYPED_ELEMENT_CS__MULTIPLICITY);
		createEAttribute(typedElementCSEClass, TYPED_ELEMENT_CS__QUALIFIERS);
		createEReference(typedElementCSEClass, TYPED_ELEMENT_CS__TYPE);
		createEAttribute(typedElementCSEClass, TYPED_ELEMENT_CS__UPPER);

		typedRefCSEClass = createEClass(TYPED_REF_CS);

		typedTypeRefCSEClass = createEClass(TYPED_TYPE_REF_CS);
		createEReference(typedTypeRefCSEClass, TYPED_TYPE_REF_CS__TYPE);

		wildcardTypeRefCSEClass = createEClass(WILDCARD_TYPE_REF_CS);
		createEReference(wildcardTypeRefCSEClass, WILDCARD_TYPE_REF_CS__EXTENDS);
		createEReference(wildcardTypeRefCSEClass, WILDCARD_TYPE_REF_CS__SUPER);

		// Create data types
		signatureEDataType = createEDataType(SIGNATURE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters
		ETypeParameter boundElementCSEClass_T = addETypeParameter(boundElementCSEClass, "T"); //$NON-NLS-1$
		ETypeParameter qualifiedRefCSEClass_E = addETypeParameter(qualifiedRefCSEClass, "E"); //$NON-NLS-1$

		// Set bounds for type parameters
		EGenericType g1 = createEGenericType(this.getNamedElementCS());
		boundElementCSEClass_T.getEBounds().add(g1);
		g1 = createEGenericType(this.getElementCS());
		qualifiedRefCSEClass_E.getEBounds().add(g1);

		// Add supertypes to classes
		annotationElementCSEClass.getESuperTypes().add(this.getModelElementCS());
		attributeCSEClass.getESuperTypes().add(this.getStructuralFeatureCS());
		attributeCSRefEClass.getESuperTypes().add(this.getElementCS());
		boundClassCSEClass.getESuperTypes().add(this.getClassCS());
		boundClassCSEClass.getESuperTypes().add(this.getBoundClassifierCS());
		g1 = createEGenericType(this.getClassifierCS());
		boundClassifierCSEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getBoundElementCS());
		EGenericType g2 = createEGenericType(this.getClassifierCS());
		g1.getETypeArguments().add(g2);
		boundClassifierCSEClass.getEGenericSuperTypes().add(g1);
		boundDocumentCSEClass.getESuperTypes().add(this.getPackageCS());
		boundElementCSEClass.getESuperTypes().add(this.getNamedElementCS());
		g1 = createEGenericType(this.getOperationCS());
		boundOperationCSEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getBoundElementCS());
		g2 = createEGenericType(this.getOperationCS());
		g1.getETypeArguments().add(g2);
		boundOperationCSEClass.getEGenericSuperTypes().add(g1);
		classCSEClass.getESuperTypes().add(this.getClassifierCS());
		classCSEClass.getESuperTypes().add(this.getNamespaceCS());
		classCSRefEClass.getESuperTypes().add(this.getElementCS());
		classifierCSEClass.getESuperTypes().add(this.getNamedElementCS());
		classifierCSEClass.getESuperTypes().add(this.getTypeCS());
		classifierRefCSEClass.getESuperTypes().add(this.getModelElementCS());
		collectionTypeRefCSEClass.getESuperTypes().add(this.getTypedRefCS());
		collectionTypeRefCSEClass.getESuperTypes().add(this.getNamedElementCS());
		detailCSEClass.getESuperTypes().add(this.getElementCS());
		documentCSEClass.getESuperTypes().add(this.getNamespaceCS());
		enumLiteralCSEClass.getESuperTypes().add(this.getNamedElementCS());
		featureCSEClass.getESuperTypes().add(this.getTypedElementCS());
		importCSEClass.getESuperTypes().add(this.getNamespaceCS());
		libraryCSEClass.getESuperTypes().add(this.getNamespaceCS());
		modelElementCSEClass.getESuperTypes().add(this.getElementCS());
		modelElementCSRefEClass.getESuperTypes().add(this.getElementCS());
		namedElementCSEClass.getESuperTypes().add(this.getModelElementCS());
		namespaceCSEClass.getESuperTypes().add(this.getNamedElementCS());
		operationCSEClass.getESuperTypes().add(this.getFeatureCS());
		operationRefCSEClass.getESuperTypes().add(this.getModelElementCS());
		packageCSEClass.getESuperTypes().add(this.getNamespaceCS());
		packageRefCSEClass.getESuperTypes().add(this.getModelElementCS());
		parameterCSEClass.getESuperTypes().add(this.getTypedElementCS());
		parameterizedTypeRefCSEClass.getESuperTypes().add(this.getTypedRefCS());
		primitiveTypeRefCSEClass.getESuperTypes().add(this.getTypedRefCS());
		primitiveTypeRefCSEClass.getESuperTypes().add(this.getNamedElementCS());
		g1 = createEGenericType(this.getClassifierRefCS());
		qualifiedClassifierRefCSEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getQualifiedRefCS());
		g2 = createEGenericType(this.getClassifierRefCS());
		g1.getETypeArguments().add(g2);
		qualifiedClassifierRefCSEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getOperationRefCS());
		qualifiedOperationRefCSEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getQualifiedRefCS());
		g2 = createEGenericType(this.getOperationRefCS());
		g1.getETypeArguments().add(g2);
		qualifiedOperationRefCSEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getPackageRefCS());
		qualifiedPackageRefCSEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getQualifiedRefCS());
		g2 = createEGenericType(this.getPackageRefCS());
		g1.getETypeArguments().add(g2);
		qualifiedPackageRefCSEClass.getEGenericSuperTypes().add(g1);
		qualifiedRefCSEClass.getESuperTypes().add(this.getModelElementCS());
		g1 = createEGenericType(this.getStructuralFeatureRefCS());
		qualifiedStructuralFeatureRefCSEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getQualifiedRefCS());
		g2 = createEGenericType(this.getStructuralFeatureRefCS());
		g1.getETypeArguments().add(g2);
		qualifiedStructuralFeatureRefCSEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getParameterizedTypeRefCS());
		qualifiedTypeRefCSEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getQualifiedRefCS());
		g2 = createEGenericType(this.getParameterizedTypeRefCS());
		g1.getETypeArguments().add(g2);
		qualifiedTypeRefCSEClass.getEGenericSuperTypes().add(g1);
		referenceCSEClass.getESuperTypes().add(this.getStructuralFeatureCS());
		referenceCSRefEClass.getESuperTypes().add(this.getElementCS());
		simpleClassifierRefCSEClass.getESuperTypes().add(this.getClassifierRefCS());
		simpleOperationRefCSEClass.getESuperTypes().add(this.getOperationRefCS());
		simplePackageRefCSEClass.getESuperTypes().add(this.getPackageRefCS());
		simpleStructuralFeatureRefCSEClass.getESuperTypes().add(this.getStructuralFeatureRefCS());
		structuralFeatureCSEClass.getESuperTypes().add(this.getFeatureCS());
		structuralFeatureRefCSEClass.getESuperTypes().add(this.getModelElementCS());
		typeBindingCSEClass.getESuperTypes().add(this.getElementCS());
		typeBindingsCSEClass.getESuperTypes().add(this.getElementCS());
		typeCSEClass.getESuperTypes().add(this.getElementCS());
		typeParameterCSEClass.getESuperTypes().add(this.getNamedElementCS());
		typeParameterCSEClass.getESuperTypes().add(this.getTypeCS());
		typeRefCSEClass.getESuperTypes().add(this.getModelElementCS());
		typedElementCSEClass.getESuperTypes().add(this.getNamedElementCS());
		typedRefCSEClass.getESuperTypes().add(this.getTypeRefCS());
		typedTypeRefCSEClass.getESuperTypes().add(this.getParameterizedTypeRefCS());
		wildcardTypeRefCSEClass.getESuperTypes().add(this.getTypeRefCS());

		// Initialize classes and features; add operations and parameters
		initEClass(annotationElementCSEClass, AnnotationElementCS.class, "AnnotationElementCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getAnnotationElementCS_Details(), this.getDetailCS(), null, "details", null, 0, -1, AnnotationElementCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(attributeCSEClass, AttributeCS.class, "AttributeCS", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(attributeCSRefEClass, AttributeCSRef.class, "AttributeCSRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getAttributeCSRef_Ref(), this.getAttributeCS(), null, "ref", null, 0, 1, AttributeCSRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(boundClassCSEClass, BoundClassCS.class, "BoundClassCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(boundClassifierCSEClass, BoundClassifierCS.class, "BoundClassifierCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(boundDocumentCSEClass, BoundDocumentCS.class, "BoundDocumentCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(boundElementCSEClass, BoundElementCS.class, "BoundElementCS", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getBoundElementCS_Bindings(), this.getTypeBindingsCS(), null, "bindings", null, 0, 1, BoundElementCS.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(boundElementCSEClass_T);
		initEReference(getBoundElementCS_Binds(), g1, null, "binds", null, 0, 1, BoundElementCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(boundOperationCSEClass, BoundOperationCS.class, "BoundOperationCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(classCSEClass, ClassCS.class, "ClassCS", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getClassCS_SuperTypes(), this.getTypedRefCS(), null, "superTypes", null, 0, -1, ClassCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getClassCS_Operations(), this.getOperationCS(), this.getOperationCS_Owner(), "operations", null, 0, -1, ClassCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getClassCS_StructuralFeatures(), this.getStructuralFeatureCS(), this.getStructuralFeatureCS_Owner(), "structuralFeatures", null, 0, -1, ClassCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(classCSRefEClass, ClassCSRef.class, "ClassCSRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getClassCSRef_Ref(), this.getClassCS(), null, "ref", null, 0, 1, ClassCSRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(classifierCSEClass, ClassifierCS.class, "ClassifierCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getClassifierCS_TypeParameters(), this.getTypeParameterCS(), null, "typeParameters", null, 0, -1, ClassifierCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getClassifierCS_Owner(), this.getPackageCS(), this.getPackageCS_Classifiers(), "owner", null, 0, 1, ClassifierCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(classifierRefCSEClass, ClassifierRefCS.class, "ClassifierRefCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		addEOperation(classifierRefCSEClass, this.getClassifierCS(), "getClassifier", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		initEClass(collectionTypeRefCSEClass, CollectionTypeRefCS.class, "CollectionTypeRefCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getCollectionTypeRefCS_TypeArguments(), this.getTypeRefCS(), null, "typeArguments", null, 0, 1, CollectionTypeRefCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(detailCSEClass, DetailCS.class, "DetailCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getDetailCS_IdName(), ecorePackage.getEString(), "idName", null, 0, 1, DetailCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDetailCS_StringName(), ecorePackage.getEString(), "stringName", null, 0, 1, DetailCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getDetailCS_Value(), ecorePackage.getEString(), "value", null, 0, -1, DetailCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(documentCSEClass, DocumentCS.class, "DocumentCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getDocumentCS_Imports(), this.getImportCS(), null, "imports", null, 0, -1, DocumentCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getDocumentCS_Libraries(), this.getLibraryCS(), null, "libraries", null, 0, -1, DocumentCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(elementCSEClass, ElementCS.class, "ElementCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		addEOperation(elementCSEClass, ecorePackage.getEString(), "getSignature", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		EOperation op = addEOperation(elementCSEClass, null, "getSignature", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getSignature(), "s", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, this.getTypeBindingsCS(), "bindings", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		initEClass(enumLiteralCSEClass, EnumLiteralCS.class, "EnumLiteralCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getEnumLiteralCS_Value(), ecorePackage.getEInt(), "value", null, 0, 1, EnumLiteralCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(featureCSEClass, FeatureCS.class, "FeatureCS", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getFeatureCS_IsStatic(), ecorePackage.getEBoolean(), "isStatic", "false", 0, 1, FeatureCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getFeatureCS_IsDefinition(), ecorePackage.getEBoolean(), "isDefinition", "false", 0, 1, FeatureCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(importCSEClass, ImportCS.class, "ImportCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getImportCS_Uri(), ecorePackage.getEString(), "uri", null, 0, 1, ImportCS.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getImportCS_Namespace(), this.getNamespaceCS(), null, "namespace", null, 0, 1, ImportCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(libraryCSEClass, LibraryCS.class, "LibraryCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getLibraryCS_Package(), this.getPackageCS(), null, "package", null, 0, 1, LibraryCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(modelElementCSEClass, ModelElementCS.class, "ModelElementCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getModelElementCS_Annotations(), this.getAnnotationElementCS(), null, "annotations", null, 0, -1, ModelElementCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getModelElementCS_OriginalObject(), ecorePackage.getEObject(), null, "originalObject", null, 0, 1, ModelElementCS.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getModelElementCS_OriginalXmiId(), ecorePackage.getEString(), "originalXmiId", null, 0, 1, ModelElementCS.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(modelElementCSRefEClass, ModelElementCSRef.class, "ModelElementCSRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getModelElementCSRef_Ref(), this.getModelElementCS(), null, "ref", null, 0, 1, ModelElementCSRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(namedElementCSEClass, NamedElementCS.class, "NamedElementCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getNamedElementCS_Name(), ecorePackage.getEString(), "name", null, 0, 1, NamedElementCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(namespaceCSEClass, NamespaceCS.class, "NamespaceCS", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(operationCSEClass, OperationCS.class, "OperationCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getOperationCS_Parameters(), this.getParameterCS(), this.getParameterCS_Owner(), "parameters", null, 0, -1, OperationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getOperationCS_TypeParameters(), this.getTypeParameterCS(), null, "typeParameters", null, 0, -1, OperationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getOperationCS_Owner(), this.getClassCS(), this.getClassCS_Operations(), "owner", null, 0, 1, OperationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(operationRefCSEClass, OperationRefCS.class, "OperationRefCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		addEOperation(operationRefCSEClass, this.getOperationCS(), "getOperation", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		initEClass(packageCSEClass, PackageCS.class, "PackageCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getPackageCS_Classifiers(), this.getClassifierCS(), this.getClassifierCS_Owner(), "classifiers", null, 0, -1, PackageCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getPackageCS_Subpackages(), this.getPackageCS(), null, "subpackages", null, 0, -1, PackageCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getPackageCS_Prefix(), ecorePackage.getEString(), "prefix", null, 0, 1, PackageCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getPackageCS_Uri(), ecorePackage.getEString(), "uri", null, 0, 1, PackageCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		op = addEOperation(packageCSEClass, this.getClassifierCS(), "getClassifier", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		initEClass(packageRefCSEClass, PackageRefCS.class, "PackageRefCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		addEOperation(packageRefCSEClass, this.getPackageCS(), "getPackage", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		initEClass(parameterCSEClass, ParameterCS.class, "ParameterCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getParameterCS_Owner(), this.getOperationCS(), this.getOperationCS_Parameters(), "owner", null, 0, 1, ParameterCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(parameterizedTypeRefCSEClass, ParameterizedTypeRefCS.class, "ParameterizedTypeRefCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getParameterizedTypeRefCS_TypeArguments(), this.getTypeRefCS(), null, "typeArguments", null, 0, -1, ParameterizedTypeRefCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		addEOperation(parameterizedTypeRefCSEClass, this.getTypeCS(), "getType", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		initEClass(primitiveTypeRefCSEClass, PrimitiveTypeRefCS.class, "PrimitiveTypeRefCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(qualifiedClassifierRefCSEClass, QualifiedClassifierRefCS.class, "QualifiedClassifierRefCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(qualifiedOperationRefCSEClass, QualifiedOperationRefCS.class, "QualifiedOperationRefCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(qualifiedPackageRefCSEClass, QualifiedPackageRefCS.class, "QualifiedPackageRefCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(qualifiedRefCSEClass, QualifiedRefCS.class, "QualifiedRefCS", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getQualifiedRefCS_Namespace(), this.getNamespaceCS(), null, "namespace", null, 0, 1, QualifiedRefCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(qualifiedRefCSEClass_E);
		initEReference(getQualifiedRefCS_Element(), g1, null, "element", null, 0, 1, QualifiedRefCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(qualifiedStructuralFeatureRefCSEClass, QualifiedStructuralFeatureRefCS.class, "QualifiedStructuralFeatureRefCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(qualifiedTypeRefCSEClass, QualifiedTypeRefCS.class, "QualifiedTypeRefCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(referenceCSEClass, ReferenceCS.class, "ReferenceCS", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getReferenceCS_Opposite(), this.getReferenceCSRef(), null, "opposite", null, 0, 1, ReferenceCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(referenceCSRefEClass, ReferenceCSRef.class, "ReferenceCSRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getReferenceCSRef_Ref(), this.getReferenceCS(), null, "ref", null, 0, 1, ReferenceCSRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(simpleClassifierRefCSEClass, SimpleClassifierRefCS.class, "SimpleClassifierRefCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getSimpleClassifierRefCS_Classifier(), this.getClassifierCS(), null, "classifier", null, 0, 1, SimpleClassifierRefCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(simpleOperationRefCSEClass, SimpleOperationRefCS.class, "SimpleOperationRefCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getSimpleOperationRefCS_Operation(), this.getOperationCS(), null, "operation", null, 0, 1, SimpleOperationRefCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(simplePackageRefCSEClass, SimplePackageRefCS.class, "SimplePackageRefCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getSimplePackageRefCS_Package(), this.getPackageCS(), null, "package", null, 0, 1, SimplePackageRefCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(simpleStructuralFeatureRefCSEClass, SimpleStructuralFeatureRefCS.class, "SimpleStructuralFeatureRefCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getSimpleStructuralFeatureRefCS_Feature(), this.getStructuralFeatureCS(), null, "feature", null, 0, 1, SimpleStructuralFeatureRefCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(structuralFeatureCSEClass, StructuralFeatureCS.class, "StructuralFeatureCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getStructuralFeatureCS_Owner(), this.getClassCS(), this.getClassCS_StructuralFeatures(), "owner", null, 0, 1, StructuralFeatureCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(structuralFeatureRefCSEClass, StructuralFeatureRefCS.class, "StructuralFeatureRefCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		addEOperation(structuralFeatureRefCSEClass, this.getStructuralFeatureCS(), "getFeature", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		initEClass(typeBindingCSEClass, TypeBindingCS.class, "TypeBindingCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getTypeBindingCS_TypeParameter(), this.getTypeParameterCS(), null, "typeParameter", null, 0, 1, TypeBindingCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getTypeBindingCS_TypeArgument(), this.getClassifierCS(), null, "typeArgument", null, 0, 1, TypeBindingCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(typeBindingsCSEClass, TypeBindingsCS.class, "TypeBindingsCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getTypeBindingsCS_BoundDocument(), this.getBoundDocumentCS(), null, "boundDocument", null, 0, 1, TypeBindingsCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getTypeBindingsCS_Bindings(), this.getTypeBindingCS(), null, "bindings", null, 0, -1, TypeBindingsCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getTypeBindingsCS_Nested(), this.getTypeBindingsCS(), null, "nested", null, 0, -1, TypeBindingsCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(typeCSEClass, TypeCS.class, "TypeCS", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		addEOperation(typeCSEClass, ecorePackage.getEString(), "getSignature", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		initEClass(typeParameterCSEClass, TypeParameterCS.class, "TypeParameterCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getTypeParameterCS_Extends(), this.getTypedRefCS(), null, "extends", null, 0, -1, TypeParameterCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getTypeParameterCS_Super(), this.getTypedRefCS(), null, "super", null, 0, 1, TypeParameterCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(typeRefCSEClass, TypeRefCS.class, "TypeRefCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(typedElementCSEClass, TypedElementCS.class, "TypedElementCS", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getTypedElementCS_Lower(), ecorePackage.getEInt(), "lower", "0", 0, 1, TypedElementCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getTypedElementCS_Multiplicity(), ecorePackage.getEString(), "multiplicity", null, 0, 1, TypedElementCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getTypedElementCS_Qualifiers(), ecorePackage.getEString(), "qualifiers", null, 0, -1, TypedElementCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED); //$NON-NLS-1$
		initEReference(getTypedElementCS_Type(), this.getTypedRefCS(), null, "type", null, 0, 1, TypedElementCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getTypedElementCS_Upper(), ecorePackage.getEInt(), "upper", "1", 0, 1, TypedElementCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(typedRefCSEClass, TypedRefCS.class, "TypedRefCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(typedTypeRefCSEClass, TypedTypeRefCS.class, "TypedTypeRefCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getTypedTypeRefCS_Type(), this.getTypeCS(), null, "type", null, 0, 1, TypedTypeRefCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(wildcardTypeRefCSEClass, WildcardTypeRefCS.class, "WildcardTypeRefCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getWildcardTypeRefCS_Extends(), this.getTypedRefCS(), null, "extends", null, 0, 1, WildcardTypeRefCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWildcardTypeRefCS_Super(), this.getTypedRefCS(), null, "super", null, 0, 1, WildcardTypeRefCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		// Initialize data types
		initEDataType(signatureEDataType, Signature.class, "Signature", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		// Create resource
		createResource(eNS_URI);
	}

} //BaseCSTPackageImpl
