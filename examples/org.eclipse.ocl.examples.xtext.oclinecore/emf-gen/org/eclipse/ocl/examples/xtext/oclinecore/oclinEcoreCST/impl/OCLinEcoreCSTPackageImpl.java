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
 * $Id: OCLinEcoreCSTPackageImpl.java,v 1.2 2010/04/16 18:05:31 ewillink Exp $
 */
package org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.EssentialOCLCSTPackage;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.AnnotationCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.AnnotationElementCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.AttributeCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.AttributeCSRef;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.AttributeRef;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ClassCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ClassCSRef;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ClassRef;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ClassifierCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.ConstraintCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DataTypeCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DataTypeCSRef;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DataTypeOrEnumCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DataTypeRef;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DetailCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DocumentCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.DocumentationCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EAttributeRef;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EClassRef;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EClassifierCSRef;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EClassifierRef;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.EDataTypeRef;
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
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.TypeCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.TypeCSRef;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.TypeParameterCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.TypeRef;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.TypeRefCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.TypedElementCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.TypedTypeRefCS;
import org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.WildcardTypeRefCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class OCLinEcoreCSTPackageImpl extends EPackageImpl implements OCLinEcoreCSTPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass annotationCSEClass = null;

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
	private EClass attributeRefEClass = null;

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
	private EClass classRefEClass = null;

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
	private EClass documentCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass documentationCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eAttributeRefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eClassRefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eClassifierCSRefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eClassifierRefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eDataTypeRefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eObjectRefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass eReferenceRefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enumCSEClass = null;

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
	private EClass importCSEClass = null;

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
	private EClass objectRefEClass = null;

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
	private EClass packageCSEClass = null;

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
	private EClass referenceRefEClass = null;

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
	private EClass typeCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeCSRefEClass = null;

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
	private EClass typeParameterCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeRefEClass = null;

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
	private EClass constraintCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataTypeRefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataTypeCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataTypeOrEnumCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataTypeCSRefEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass detailCSEClass = null;

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
	 * @see org.eclipse.ocl.examples.xtext.oclinecore.oclinEcoreCST.OCLinEcoreCSTPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private OCLinEcoreCSTPackageImpl() {
		super(eNS_URI, OCLinEcoreCSTFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link OCLinEcoreCSTPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static OCLinEcoreCSTPackage init() {
		if (isInited) return (OCLinEcoreCSTPackage)EPackage.Registry.INSTANCE.getEPackage(OCLinEcoreCSTPackage.eNS_URI);

		// Obtain or create and register package
		OCLinEcoreCSTPackageImpl theOCLinEcoreCSTPackage = (OCLinEcoreCSTPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof OCLinEcoreCSTPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new OCLinEcoreCSTPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();
		EssentialOCLCSTPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theOCLinEcoreCSTPackage.createPackageContents();

		// Initialize created meta-data
		theOCLinEcoreCSTPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theOCLinEcoreCSTPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(OCLinEcoreCSTPackage.eNS_URI, theOCLinEcoreCSTPackage);
		return theOCLinEcoreCSTPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAnnotationCS() {
		return annotationCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnnotationCS_IdSource() {
		return (EAttribute)annotationCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnnotationCS_StringSource() {
		return (EAttribute)annotationCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnnotationCS_Contents() {
		return (EReference)annotationCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnnotationCS_References() {
		return (EReference)annotationCSEClass.getEStructuralFeatures().get(3);
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
	public EClass getAttributeRef() {
		return attributeRefEClass;
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
	public EClass getClassRef() {
		return classRefEClass;
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
	public EReference getClassifierCS_Constraints() {
		return (EReference)classifierCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassifierCS_InstanceClassName() {
		return (EAttribute)classifierCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassifierCS_Qualifiers() {
		return (EAttribute)classifierCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassifierCS_TypeParameters() {
		return (EReference)classifierCSEClass.getEStructuralFeatures().get(3);
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
	public EReference getDocumentCS_Packages() {
		return (EReference)documentCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDocumentationCS() {
		return documentationCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentationCS_Value() {
		return (EAttribute)documentationCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEAttributeRef() {
		return eAttributeRefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEAttributeRef_Ref() {
		return (EReference)eAttributeRefEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEClassRef() {
		return eClassRefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEClassRef_Ref() {
		return (EReference)eClassRefEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEClassifierCSRef() {
		return eClassifierCSRefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEClassifierCSRef_Ref() {
		return (EReference)eClassifierCSRefEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEClassifierCSRef_ModelName() {
		return (EAttribute)eClassifierCSRefEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEClassifierRef() {
		return eClassifierRefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEClassifierRef_Ref() {
		return (EReference)eClassifierRefEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEDataTypeRef() {
		return eDataTypeRefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEDataTypeRef_Ref() {
		return (EReference)eDataTypeRefEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEObjectRef() {
		return eObjectRefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEObjectRef_Ref() {
		return (EReference)eObjectRefEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEReferenceRef() {
		return eReferenceRefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEReferenceRef_Ref() {
		return (EReference)eReferenceRefEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnumCS() {
		return enumCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnumCS_Literals() {
		return (EReference)enumCSEClass.getEStructuralFeatures().get(0);
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
	public EClass getImportCS() {
		return importCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getImportCS_Alias() {
		return (EAttribute)importCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getImportCS_EPackage() {
		return (EReference)importCSEClass.getEStructuralFeatures().get(1);
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
	public EClass getObjectRef() {
		return objectRefEClass;
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
	public EReference getOperationCS_Constraints() {
		return (EReference)operationCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperationCS_Parameters() {
		return (EReference)operationCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperationCS_TypeParameters() {
		return (EReference)operationCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperationCS_Exceptions() {
		return (EReference)operationCSEClass.getEStructuralFeatures().get(3);
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
	public EClass getParameterCS() {
		return parameterCSEClass;
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
	public EReference getReferenceCS_Keys() {
		return (EReference)referenceCSEClass.getEStructuralFeatures().get(1);
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
	public EClass getReferenceRef() {
		return referenceRefEClass;
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
	public EReference getStructuralFeatureCS_Constraints() {
		return (EReference)structuralFeatureCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStructuralFeatureCS_DefaultValueLiteral() {
		return (EAttribute)structuralFeatureCSEClass.getEStructuralFeatures().get(1);
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
	public EClass getTypeCSRef() {
		return typeCSRefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTypeCSRef_Ref() {
		return (EReference)typeCSRefEClass.getEStructuralFeatures().get(0);
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
	public EReference getTypedTypeRefCS_TypeArguments() {
		return (EReference)typedTypeRefCSEClass.getEStructuralFeatures().get(1);
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
	public EClass getTypeRef() {
		return typeRefEClass;
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
	public EClass getConstraintCS() {
		return constraintCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConstraintCS_Stereotype() {
		return (EAttribute)constraintCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConstraintCS_ExprString() {
		return (EAttribute)constraintCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConstraintCS_ExprValue() {
		return (EReference)constraintCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataTypeRef() {
		return dataTypeRefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataTypeCS() {
		return dataTypeCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataTypeOrEnumCS() {
		return dataTypeOrEnumCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataTypeCSRef() {
		return dataTypeCSRefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataTypeCSRef_Ref() {
		return (EReference)dataTypeCSRefEClass.getEStructuralFeatures().get(0);
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
	public OCLinEcoreCSTFactory getOCLinEcoreCSTFactory() {
		return (OCLinEcoreCSTFactory)getEFactoryInstance();
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
		annotationCSEClass = createEClass(ANNOTATION_CS);
		createEAttribute(annotationCSEClass, ANNOTATION_CS__ID_SOURCE);
		createEAttribute(annotationCSEClass, ANNOTATION_CS__STRING_SOURCE);
		createEReference(annotationCSEClass, ANNOTATION_CS__CONTENTS);
		createEReference(annotationCSEClass, ANNOTATION_CS__REFERENCES);

		annotationElementCSEClass = createEClass(ANNOTATION_ELEMENT_CS);
		createEReference(annotationElementCSEClass, ANNOTATION_ELEMENT_CS__DETAILS);

		attributeCSEClass = createEClass(ATTRIBUTE_CS);

		attributeCSRefEClass = createEClass(ATTRIBUTE_CS_REF);
		createEReference(attributeCSRefEClass, ATTRIBUTE_CS_REF__REF);

		attributeRefEClass = createEClass(ATTRIBUTE_REF);

		classCSEClass = createEClass(CLASS_CS);
		createEReference(classCSEClass, CLASS_CS__SUPER_TYPES);
		createEReference(classCSEClass, CLASS_CS__OPERATIONS);
		createEReference(classCSEClass, CLASS_CS__STRUCTURAL_FEATURES);

		classCSRefEClass = createEClass(CLASS_CS_REF);
		createEReference(classCSRefEClass, CLASS_CS_REF__REF);

		classRefEClass = createEClass(CLASS_REF);

		classifierCSEClass = createEClass(CLASSIFIER_CS);
		createEReference(classifierCSEClass, CLASSIFIER_CS__CONSTRAINTS);
		createEAttribute(classifierCSEClass, CLASSIFIER_CS__INSTANCE_CLASS_NAME);
		createEAttribute(classifierCSEClass, CLASSIFIER_CS__QUALIFIERS);
		createEReference(classifierCSEClass, CLASSIFIER_CS__TYPE_PARAMETERS);

		constraintCSEClass = createEClass(CONSTRAINT_CS);
		createEAttribute(constraintCSEClass, CONSTRAINT_CS__STEREOTYPE);
		createEAttribute(constraintCSEClass, CONSTRAINT_CS__EXPR_STRING);
		createEReference(constraintCSEClass, CONSTRAINT_CS__EXPR_VALUE);

		dataTypeRefEClass = createEClass(DATA_TYPE_REF);

		dataTypeCSEClass = createEClass(DATA_TYPE_CS);

		dataTypeOrEnumCSEClass = createEClass(DATA_TYPE_OR_ENUM_CS);

		dataTypeCSRefEClass = createEClass(DATA_TYPE_CS_REF);
		createEReference(dataTypeCSRefEClass, DATA_TYPE_CS_REF__REF);

		detailCSEClass = createEClass(DETAIL_CS);
		createEAttribute(detailCSEClass, DETAIL_CS__ID_NAME);
		createEAttribute(detailCSEClass, DETAIL_CS__STRING_NAME);
		createEAttribute(detailCSEClass, DETAIL_CS__VALUE);

		documentCSEClass = createEClass(DOCUMENT_CS);
		createEReference(documentCSEClass, DOCUMENT_CS__IMPORTS);
		createEReference(documentCSEClass, DOCUMENT_CS__PACKAGES);

		documentationCSEClass = createEClass(DOCUMENTATION_CS);
		createEAttribute(documentationCSEClass, DOCUMENTATION_CS__VALUE);

		eAttributeRefEClass = createEClass(EATTRIBUTE_REF);
		createEReference(eAttributeRefEClass, EATTRIBUTE_REF__REF);

		eClassRefEClass = createEClass(ECLASS_REF);
		createEReference(eClassRefEClass, ECLASS_REF__REF);

		eClassifierCSRefEClass = createEClass(ECLASSIFIER_CS_REF);
		createEReference(eClassifierCSRefEClass, ECLASSIFIER_CS_REF__REF);
		createEAttribute(eClassifierCSRefEClass, ECLASSIFIER_CS_REF__MODEL_NAME);

		eClassifierRefEClass = createEClass(ECLASSIFIER_REF);
		createEReference(eClassifierRefEClass, ECLASSIFIER_REF__REF);

		eDataTypeRefEClass = createEClass(EDATA_TYPE_REF);
		createEReference(eDataTypeRefEClass, EDATA_TYPE_REF__REF);

		eObjectRefEClass = createEClass(EOBJECT_REF);
		createEReference(eObjectRefEClass, EOBJECT_REF__REF);

		eReferenceRefEClass = createEClass(EREFERENCE_REF);
		createEReference(eReferenceRefEClass, EREFERENCE_REF__REF);

		enumCSEClass = createEClass(ENUM_CS);
		createEReference(enumCSEClass, ENUM_CS__LITERALS);

		enumLiteralCSEClass = createEClass(ENUM_LITERAL_CS);
		createEAttribute(enumLiteralCSEClass, ENUM_LITERAL_CS__VALUE);

		importCSEClass = createEClass(IMPORT_CS);
		createEAttribute(importCSEClass, IMPORT_CS__ALIAS);
		createEReference(importCSEClass, IMPORT_CS__EPACKAGE);

		modelElementCSEClass = createEClass(MODEL_ELEMENT_CS);
		createEReference(modelElementCSEClass, MODEL_ELEMENT_CS__ANNOTATIONS);

		modelElementCSRefEClass = createEClass(MODEL_ELEMENT_CS_REF);
		createEReference(modelElementCSRefEClass, MODEL_ELEMENT_CS_REF__REF);

		namedElementCSEClass = createEClass(NAMED_ELEMENT_CS);
		createEAttribute(namedElementCSEClass, NAMED_ELEMENT_CS__NAME);

		objectRefEClass = createEClass(OBJECT_REF);

		operationCSEClass = createEClass(OPERATION_CS);
		createEReference(operationCSEClass, OPERATION_CS__CONSTRAINTS);
		createEReference(operationCSEClass, OPERATION_CS__PARAMETERS);
		createEReference(operationCSEClass, OPERATION_CS__TYPE_PARAMETERS);
		createEReference(operationCSEClass, OPERATION_CS__EXCEPTIONS);

		packageCSEClass = createEClass(PACKAGE_CS);
		createEReference(packageCSEClass, PACKAGE_CS__CLASSIFIERS);
		createEReference(packageCSEClass, PACKAGE_CS__SUBPACKAGES);
		createEAttribute(packageCSEClass, PACKAGE_CS__PREFIX);
		createEAttribute(packageCSEClass, PACKAGE_CS__URI);

		parameterCSEClass = createEClass(PARAMETER_CS);

		referenceCSEClass = createEClass(REFERENCE_CS);
		createEReference(referenceCSEClass, REFERENCE_CS__OPPOSITE);
		createEReference(referenceCSEClass, REFERENCE_CS__KEYS);

		referenceCSRefEClass = createEClass(REFERENCE_CS_REF);
		createEReference(referenceCSRefEClass, REFERENCE_CS_REF__REF);

		referenceRefEClass = createEClass(REFERENCE_REF);

		structuralFeatureCSEClass = createEClass(STRUCTURAL_FEATURE_CS);
		createEReference(structuralFeatureCSEClass, STRUCTURAL_FEATURE_CS__CONSTRAINTS);
		createEAttribute(structuralFeatureCSEClass, STRUCTURAL_FEATURE_CS__DEFAULT_VALUE_LITERAL);

		typeCSEClass = createEClass(TYPE_CS);

		typeCSRefEClass = createEClass(TYPE_CS_REF);
		createEReference(typeCSRefEClass, TYPE_CS_REF__REF);

		typeParameterCSEClass = createEClass(TYPE_PARAMETER_CS);
		createEReference(typeParameterCSEClass, TYPE_PARAMETER_CS__EXTENDS);
		createEReference(typeParameterCSEClass, TYPE_PARAMETER_CS__SUPER);

		typeRefEClass = createEClass(TYPE_REF);

		typeRefCSEClass = createEClass(TYPE_REF_CS);

		typedElementCSEClass = createEClass(TYPED_ELEMENT_CS);
		createEAttribute(typedElementCSEClass, TYPED_ELEMENT_CS__LOWER);
		createEAttribute(typedElementCSEClass, TYPED_ELEMENT_CS__MULTIPLICITY);
		createEAttribute(typedElementCSEClass, TYPED_ELEMENT_CS__QUALIFIERS);
		createEReference(typedElementCSEClass, TYPED_ELEMENT_CS__TYPE);
		createEAttribute(typedElementCSEClass, TYPED_ELEMENT_CS__UPPER);

		typedTypeRefCSEClass = createEClass(TYPED_TYPE_REF_CS);
		createEReference(typedTypeRefCSEClass, TYPED_TYPE_REF_CS__TYPE);
		createEReference(typedTypeRefCSEClass, TYPED_TYPE_REF_CS__TYPE_ARGUMENTS);

		wildcardTypeRefCSEClass = createEClass(WILDCARD_TYPE_REF_CS);
		createEReference(wildcardTypeRefCSEClass, WILDCARD_TYPE_REF_CS__EXTENDS);
		createEReference(wildcardTypeRefCSEClass, WILDCARD_TYPE_REF_CS__SUPER);
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

		// Obtain other dependent packages
		EssentialOCLCSTPackage theEssentialOCLCSTPackage = (EssentialOCLCSTPackage)EPackage.Registry.INSTANCE.getEPackage(EssentialOCLCSTPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		annotationCSEClass.getESuperTypes().add(this.getAnnotationElementCS());
		annotationElementCSEClass.getESuperTypes().add(this.getModelElementCS());
		attributeCSEClass.getESuperTypes().add(this.getStructuralFeatureCS());
		attributeCSRefEClass.getESuperTypes().add(this.getAttributeRef());
		attributeRefEClass.getESuperTypes().add(this.getObjectRef());
		classCSEClass.getESuperTypes().add(this.getClassifierCS());
		classCSRefEClass.getESuperTypes().add(this.getClassRef());
		classRefEClass.getESuperTypes().add(this.getTypeRef());
		classifierCSEClass.getESuperTypes().add(this.getTypeCS());
		constraintCSEClass.getESuperTypes().add(this.getNamedElementCS());
		dataTypeRefEClass.getESuperTypes().add(this.getTypeRef());
		dataTypeCSEClass.getESuperTypes().add(this.getDataTypeOrEnumCS());
		dataTypeOrEnumCSEClass.getESuperTypes().add(this.getClassifierCS());
		dataTypeCSRefEClass.getESuperTypes().add(this.getDataTypeRef());
		documentationCSEClass.getESuperTypes().add(this.getAnnotationElementCS());
		eAttributeRefEClass.getESuperTypes().add(this.getAttributeRef());
		eClassRefEClass.getESuperTypes().add(this.getClassRef());
		eClassifierCSRefEClass.getESuperTypes().add(this.getTypeRef());
		eClassifierRefEClass.getESuperTypes().add(this.getTypeRef());
		eDataTypeRefEClass.getESuperTypes().add(this.getDataTypeRef());
		eObjectRefEClass.getESuperTypes().add(this.getObjectRef());
		eReferenceRefEClass.getESuperTypes().add(this.getReferenceRef());
		enumCSEClass.getESuperTypes().add(this.getDataTypeOrEnumCS());
		enumLiteralCSEClass.getESuperTypes().add(this.getNamedElementCS());
		modelElementCSRefEClass.getESuperTypes().add(this.getObjectRef());
		namedElementCSEClass.getESuperTypes().add(this.getModelElementCS());
		operationCSEClass.getESuperTypes().add(this.getTypedElementCS());
		packageCSEClass.getESuperTypes().add(this.getNamedElementCS());
		parameterCSEClass.getESuperTypes().add(this.getTypedElementCS());
		referenceCSEClass.getESuperTypes().add(this.getStructuralFeatureCS());
		referenceCSRefEClass.getESuperTypes().add(this.getReferenceRef());
		referenceRefEClass.getESuperTypes().add(this.getObjectRef());
		structuralFeatureCSEClass.getESuperTypes().add(this.getTypedElementCS());
		typeCSEClass.getESuperTypes().add(this.getNamedElementCS());
		typeCSRefEClass.getESuperTypes().add(this.getTypeRef());
		typeParameterCSEClass.getESuperTypes().add(this.getTypeCS());
		typeRefEClass.getESuperTypes().add(this.getObjectRef());
		typeRefCSEClass.getESuperTypes().add(this.getModelElementCS());
		typedElementCSEClass.getESuperTypes().add(this.getNamedElementCS());
		typedTypeRefCSEClass.getESuperTypes().add(this.getTypeRefCS());
		wildcardTypeRefCSEClass.getESuperTypes().add(this.getTypeRefCS());

		// Initialize classes and features; add operations and parameters
		initEClass(annotationCSEClass, AnnotationCS.class, "AnnotationCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAnnotationCS_IdSource(), ecorePackage.getEString(), "idSource", null, 0, 1, AnnotationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnnotationCS_StringSource(), ecorePackage.getEString(), "stringSource", null, 0, 1, AnnotationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAnnotationCS_Contents(), this.getModelElementCS(), null, "contents", null, 0, -1, AnnotationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAnnotationCS_References(), this.getObjectRef(), null, "references", null, 0, -1, AnnotationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(annotationElementCSEClass, AnnotationElementCS.class, "AnnotationElementCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAnnotationElementCS_Details(), this.getDetailCS(), null, "details", null, 0, -1, AnnotationElementCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(attributeCSEClass, AttributeCS.class, "AttributeCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(attributeCSRefEClass, AttributeCSRef.class, "AttributeCSRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAttributeCSRef_Ref(), this.getAttributeCS(), null, "ref", null, 0, 1, AttributeCSRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(attributeRefEClass, AttributeRef.class, "AttributeRef", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(classCSEClass, ClassCS.class, "ClassCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getClassCS_SuperTypes(), this.getTypeRefCS(), null, "superTypes", null, 0, -1, ClassCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClassCS_Operations(), this.getOperationCS(), null, "operations", null, 0, -1, ClassCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClassCS_StructuralFeatures(), this.getStructuralFeatureCS(), null, "structuralFeatures", null, 0, -1, ClassCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(classCSRefEClass, ClassCSRef.class, "ClassCSRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getClassCSRef_Ref(), this.getClassCS(), null, "ref", null, 0, 1, ClassCSRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(classRefEClass, ClassRef.class, "ClassRef", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(classifierCSEClass, ClassifierCS.class, "ClassifierCS", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getClassifierCS_Constraints(), this.getConstraintCS(), null, "constraints", null, 0, -1, ClassifierCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getClassifierCS_InstanceClassName(), ecorePackage.getEString(), "instanceClassName", null, 0, 1, ClassifierCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getClassifierCS_Qualifiers(), ecorePackage.getEString(), "qualifiers", null, 0, -1, ClassifierCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getClassifierCS_TypeParameters(), this.getTypeParameterCS(), null, "typeParameters", null, 0, -1, ClassifierCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(constraintCSEClass, ConstraintCS.class, "ConstraintCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConstraintCS_Stereotype(), ecorePackage.getEString(), "stereotype", null, 0, 1, ConstraintCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConstraintCS_ExprString(), ecorePackage.getEString(), "exprString", null, 0, 1, ConstraintCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConstraintCS_ExprValue(), theEssentialOCLCSTPackage.getOclExpressionCS(), null, "exprValue", null, 0, 1, ConstraintCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dataTypeRefEClass, DataTypeRef.class, "DataTypeRef", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dataTypeCSEClass, DataTypeCS.class, "DataTypeCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dataTypeOrEnumCSEClass, DataTypeOrEnumCS.class, "DataTypeOrEnumCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dataTypeCSRefEClass, DataTypeCSRef.class, "DataTypeCSRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataTypeCSRef_Ref(), this.getDataTypeOrEnumCS(), null, "ref", null, 0, 1, DataTypeCSRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(detailCSEClass, DetailCS.class, "DetailCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDetailCS_IdName(), ecorePackage.getEString(), "idName", null, 0, 1, DetailCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDetailCS_StringName(), ecorePackage.getEString(), "stringName", null, 0, 1, DetailCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDetailCS_Value(), ecorePackage.getEString(), "value", null, 0, 1, DetailCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(documentCSEClass, DocumentCS.class, "DocumentCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDocumentCS_Imports(), this.getImportCS(), null, "imports", null, 0, -1, DocumentCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentCS_Packages(), this.getPackageCS(), null, "packages", null, 0, -1, DocumentCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(documentationCSEClass, DocumentationCS.class, "DocumentationCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDocumentationCS_Value(), ecorePackage.getEString(), "value", null, 0, 1, DocumentationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eAttributeRefEClass, EAttributeRef.class, "EAttributeRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEAttributeRef_Ref(), ecorePackage.getEAttribute(), null, "ref", null, 0, 1, EAttributeRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eClassRefEClass, EClassRef.class, "EClassRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEClassRef_Ref(), ecorePackage.getEClass(), null, "ref", null, 0, 1, EClassRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eClassifierCSRefEClass, EClassifierCSRef.class, "EClassifierCSRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEClassifierCSRef_Ref(), ecorePackage.getEClassifier(), null, "ref", null, 0, 1, EClassifierCSRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEClassifierCSRef_ModelName(), ecorePackage.getEString(), "modelName", null, 0, 1, EClassifierCSRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eClassifierRefEClass, EClassifierRef.class, "EClassifierRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEClassifierRef_Ref(), ecorePackage.getEClassifier(), null, "ref", null, 0, 1, EClassifierRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eDataTypeRefEClass, EDataTypeRef.class, "EDataTypeRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEDataTypeRef_Ref(), ecorePackage.getEDataType(), null, "ref", null, 0, 1, EDataTypeRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eObjectRefEClass, EObjectRef.class, "EObjectRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEObjectRef_Ref(), ecorePackage.getEObject(), null, "ref", null, 0, 1, EObjectRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(eReferenceRefEClass, EReferenceRef.class, "EReferenceRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEReferenceRef_Ref(), ecorePackage.getEReference(), null, "ref", null, 0, 1, EReferenceRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(enumCSEClass, EnumCS.class, "EnumCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEnumCS_Literals(), this.getEnumLiteralCS(), null, "literals", null, 0, -1, EnumCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(enumLiteralCSEClass, EnumLiteralCS.class, "EnumLiteralCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEnumLiteralCS_Value(), ecorePackage.getEInt(), "value", null, 0, 1, EnumLiteralCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(importCSEClass, ImportCS.class, "ImportCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getImportCS_Alias(), ecorePackage.getEString(), "alias", null, 0, 1, ImportCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getImportCS_EPackage(), ecorePackage.getEPackage(), null, "ePackage", null, 0, 1, ImportCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(modelElementCSEClass, ModelElementCS.class, "ModelElementCS", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModelElementCS_Annotations(), this.getAnnotationElementCS(), null, "annotations", null, 0, -1, ModelElementCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(modelElementCSRefEClass, ModelElementCSRef.class, "ModelElementCSRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModelElementCSRef_Ref(), this.getModelElementCS(), null, "ref", null, 0, 1, ModelElementCSRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(namedElementCSEClass, NamedElementCS.class, "NamedElementCS", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNamedElementCS_Name(), ecorePackage.getEString(), "name", null, 0, 1, NamedElementCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(objectRefEClass, ObjectRef.class, "ObjectRef", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(operationCSEClass, OperationCS.class, "OperationCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOperationCS_Constraints(), this.getConstraintCS(), null, "constraints", null, 0, -1, OperationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOperationCS_Parameters(), this.getParameterCS(), null, "parameters", null, 0, -1, OperationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOperationCS_TypeParameters(), this.getTypeParameterCS(), null, "typeParameters", null, 0, -1, OperationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOperationCS_Exceptions(), this.getTypeRefCS(), null, "exceptions", null, 0, -1, OperationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(packageCSEClass, PackageCS.class, "PackageCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPackageCS_Classifiers(), this.getClassifierCS(), null, "classifiers", null, 0, -1, PackageCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPackageCS_Subpackages(), this.getPackageCS(), null, "subpackages", null, 0, -1, PackageCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPackageCS_Prefix(), ecorePackage.getEString(), "prefix", null, 0, 1, PackageCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPackageCS_Uri(), ecorePackage.getEString(), "uri", null, 0, 1, PackageCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(parameterCSEClass, ParameterCS.class, "ParameterCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(referenceCSEClass, ReferenceCS.class, "ReferenceCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReferenceCS_Opposite(), this.getReferenceRef(), null, "opposite", null, 0, 1, ReferenceCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getReferenceCS_Keys(), this.getAttributeRef(), null, "keys", null, 0, -1, ReferenceCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(referenceCSRefEClass, ReferenceCSRef.class, "ReferenceCSRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReferenceCSRef_Ref(), this.getReferenceCS(), null, "ref", null, 0, 1, ReferenceCSRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(referenceRefEClass, ReferenceRef.class, "ReferenceRef", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(structuralFeatureCSEClass, StructuralFeatureCS.class, "StructuralFeatureCS", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStructuralFeatureCS_Constraints(), this.getConstraintCS(), null, "constraints", null, 0, -1, StructuralFeatureCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStructuralFeatureCS_DefaultValueLiteral(), ecorePackage.getEString(), "defaultValueLiteral", null, 0, 1, StructuralFeatureCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(typeCSEClass, TypeCS.class, "TypeCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(typeCSRefEClass, TypeCSRef.class, "TypeCSRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTypeCSRef_Ref(), this.getTypeCS(), null, "ref", null, 0, 1, TypeCSRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(typeParameterCSEClass, TypeParameterCS.class, "TypeParameterCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTypeParameterCS_Extends(), this.getTypeRefCS(), null, "extends", null, 0, -1, TypeParameterCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTypeParameterCS_Super(), this.getTypeRefCS(), null, "super", null, 0, 1, TypeParameterCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(typeRefEClass, TypeRef.class, "TypeRef", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(typeRefCSEClass, TypeRefCS.class, "TypeRefCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(typedElementCSEClass, TypedElementCS.class, "TypedElementCS", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTypedElementCS_Lower(), ecorePackage.getEInt(), "lower", "0", 0, 1, TypedElementCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTypedElementCS_Multiplicity(), ecorePackage.getEString(), "multiplicity", null, 0, 1, TypedElementCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTypedElementCS_Qualifiers(), ecorePackage.getEString(), "qualifiers", null, 0, -1, TypedElementCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getTypedElementCS_Type(), this.getTypeRefCS(), null, "type", null, 0, 1, TypedElementCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTypedElementCS_Upper(), ecorePackage.getEInt(), "upper", "1", 0, 1, TypedElementCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(typedTypeRefCSEClass, TypedTypeRefCS.class, "TypedTypeRefCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTypedTypeRefCS_Type(), this.getTypeRef(), null, "type", null, 0, 1, TypedTypeRefCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTypedTypeRefCS_TypeArguments(), this.getTypeRefCS(), null, "typeArguments", null, 0, -1, TypedTypeRefCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(wildcardTypeRefCSEClass, WildcardTypeRefCS.class, "WildcardTypeRefCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getWildcardTypeRefCS_Extends(), this.getTypeRefCS(), null, "extends", null, 0, 1, WildcardTypeRefCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getWildcardTypeRefCS_Super(), this.getTypeRefCS(), null, "super", null, 0, 1, WildcardTypeRefCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //OCLinEcoreCSTPackageImpl
