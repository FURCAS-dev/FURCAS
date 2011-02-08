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
 * $Id: BaseCSTPackageImpl.java,v 1.9 2011/02/08 17:43:58 ewillink Exp $
 */

package org.eclipse.ocl.examples.xtext.base.baseCST.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.xtext.base.baseCST.AnnotationCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.AnnotationElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.AttributeCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.AttributeCSRef;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTFactory;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.base.baseCST.BoundDocumentCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ClassCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ClassCSRef;
import org.eclipse.ocl.examples.xtext.base.baseCST.ClassifierCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.CollectionTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ConstraintCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.DataTypeCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.DetailCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.DocumentationCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.EnumerationCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.EnumerationLiteralCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.FeatureCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ImportCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.IteratorKind;
import org.eclipse.ocl.examples.xtext.base.baseCST.LibraryCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ModelElementCSRef;
import org.eclipse.ocl.examples.xtext.base.baseCST.MonikeredElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.NamedElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.NamespaceCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.OperationCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.PackageCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ParameterCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ParameterableElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ParameterizedTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.PrimitiveTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.QualifiedRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.QualifiedTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ReferenceCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.ReferenceCSRef;
import org.eclipse.ocl.examples.xtext.base.baseCST.RootCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.RootPackageCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.StructuralFeatureCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TemplateBindingCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TemplateParameterCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TemplateParameterSubstitutionCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TemplateSignatureCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TemplateableElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TuplePartCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TupleTypeCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeParameterCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypeRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedElementCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.WildcardTypeRefCS;
import org.eclipse.ocl.examples.xtext.base.baseCST.util.BaseCSTValidator;
import org.eclipse.ocl.examples.xtext.base.util.VisitableCS;

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
	private EClass boundDocumentCSEClass = null;

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
	private EClass collectionTypeRefCSEClass = null;

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
	private EClass dataTypeCSEClass = null;

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
	private EClass documentationCSEClass = null;

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
	private EClass enumerationCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enumerationLiteralCSEClass = null;

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
	private EClass monikeredElementCSEClass = null;

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
	private EClass parameterableElementCSEClass = null;

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
	private EClass qualifiedRefCSEClass = null;

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
	private EClass rootCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rootPackageCSEClass = null;

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
	private EClass templateBindingCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass templateParameterCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass templateParameterSubstitutionCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass templateSignatureCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass templateableElementCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tuplePartCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tupleTypeCSEClass = null;

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
	private EClass visitableCSEClass = null;

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
	private EEnum iteratorKindEEnum = null;

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

		// Initialize simple dependencies
		PivotPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theBaseCSTPackage.createPackageContents();

		// Initialize created meta-data
		theBaseCSTPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theBaseCSTPackage, 
			 new EValidator.Descriptor()
			 {
				 public EValidator getEValidator()
				 {
					 return BaseCSTValidator.INSTANCE;
				 }
			 });

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
	public EClass getAnnotationCS()
	{
		return annotationCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnnotationCS_OwnedContent()
	{
		return (EReference)annotationCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnnotationCS_Reference()
	{
		return (EReference)annotationCSEClass.getEStructuralFeatures().get(1);
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
	public EReference getAnnotationElementCS_OwnedDetail()
	{
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
	public EClass getBoundDocumentCS() {
		return boundDocumentCSEClass;
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
	public EReference getClassCS_OwnedSuperType() {
		return (EReference)classCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassCS_OwnedOperation() {
		return (EReference)classCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassCS_OwnedProperty() {
		return (EReference)classCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassCS_OwnedMetaType()
	{
		return (EReference)classCSEClass.getEStructuralFeatures().get(3);
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
	public EReference getClassifierCS_Owner() {
		return (EReference)classifierCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassifierCS_InstanceClassName()
	{
		return (EAttribute)classifierCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassifierCS_OwnedConstraint()
	{
		return (EReference)classifierCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassifierCS_Qualifier()
	{
		return (EAttribute)classifierCSEClass.getEStructuralFeatures().get(3);
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
	public EClass getConstraintCS()
	{
		return constraintCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConstraintCS_Stereotype()
	{
		return (EAttribute)constraintCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConstraintCS_ExprString()
	{
		return (EAttribute)constraintCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataTypeCS()
	{
		return dataTypeCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataTypeCS_Literals()
	{
		return (EReference)dataTypeCSEClass.getEStructuralFeatures().get(0);
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
	public EAttribute getDetailCS_Value() {
		return (EAttribute)detailCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDocumentationCS()
	{
		return documentationCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDocumentationCS_Value()
	{
		return (EAttribute)documentationCSEClass.getEStructuralFeatures().get(0);
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
	public EClass getEnumerationCS()
	{
		return enumerationCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnumerationCS_OwnedLiterals()
	{
		return (EReference)enumerationCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnumerationLiteralCS()
	{
		return enumerationLiteralCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEnumerationLiteralCS_Value()
	{
		return (EAttribute)enumerationLiteralCSEClass.getEStructuralFeatures().get(0);
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
	public EReference getModelElementCS_OwnedAnnotation()
	{
		return (EReference)modelElementCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModelElementCS_Pivot()
	{
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
	public EAttribute getModelElementCS_Error()
	{
		return (EAttribute)modelElementCSEClass.getEStructuralFeatures().get(3);
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
	public EClass getMonikeredElementCS()
	{
		return monikeredElementCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMonikeredElementCS_Moniker()
	{
		return (EAttribute)monikeredElementCSEClass.getEStructuralFeatures().get(0);
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
	public EReference getOperationCS_OwnedParameter() {
		return (EReference)operationCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperationCS_OwnedException()
	{
		return (EReference)operationCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperationCS_OwningClass() {
		return (EReference)operationCSEClass.getEStructuralFeatures().get(0);
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
	public EReference getPackageCS_OwnedType() {
		return (EReference)packageCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPackageCS_OwnedNestedPackage()
	{
		return (EReference)packageCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPackageCS_NsPrefix()
	{
		return (EAttribute)packageCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPackageCS_NsURI()
	{
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
	public EReference getParameterCS_Owner() {
		return (EReference)parameterCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParameterableElementCS() {
		return parameterableElementCSEClass;
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
	public EReference getParameterizedTypeRefCS_OwnedTemplateBinding()
	{
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
	public EReference getReferenceCS_Keys()
	{
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
	public EClass getRootCS()
	{
		return rootCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRootCS_OwnedImport()
	{
		return (EReference)rootCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRootCS_OwnedLibrary()
	{
		return (EReference)rootCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRootPackageCS()
	{
		return rootPackageCSEClass;
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
	public EAttribute getStructuralFeatureCS_Default()
	{
		return (EAttribute)structuralFeatureCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTemplateBindingCS() {
		return templateBindingCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTemplateBindingCS_OwningTemplateBindableElement() {
		return (EReference)templateBindingCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTemplateBindingCS_OwnedParameterSubstitution() {
		return (EReference)templateBindingCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTemplateParameterCS() {
		return templateParameterCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTemplateParameterCS_OwningTemplateSignature() {
		return (EReference)templateParameterCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTemplateParameterSubstitutionCS() {
		return templateParameterSubstitutionCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTemplateParameterSubstitutionCS_OwningTemplateBinding() {
		return (EReference)templateParameterSubstitutionCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTemplateParameterSubstitutionCS_OwnedActualParameter() {
		return (EReference)templateParameterSubstitutionCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTemplateSignatureCS() {
		return templateSignatureCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTemplateSignatureCS_OwningTemplateElement() {
		return (EReference)templateSignatureCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTemplateSignatureCS_OwnedTemplateParameter() {
		return (EReference)templateSignatureCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTemplateableElementCS() {
		return templateableElementCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTemplateableElementCS_OwnedTemplateSignature() {
		return (EReference)templateableElementCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTuplePartCS()
	{
		return tuplePartCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTupleTypeCS()
	{
		return tupleTypeCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTupleTypeCS_OwnedParts()
	{
		return (EReference)tupleTypeCSEClass.getEStructuralFeatures().get(0);
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
	public EReference getTypeParameterCS_OwnedExtends() {
		return (EReference)typeParameterCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTypeParameterCS_OwnedSuper() {
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
	public EReference getTypedElementCS_OwnedType() {
		return (EReference)typedElementCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTypedElementCS_Upper() {
		return (EAttribute)typedElementCSEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTypedElementCS_OwnedConstraint()
	{
		return (EReference)typedElementCSEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTypedElementCS_Qualifier()
	{
		return (EAttribute)typedElementCSEClass.getEStructuralFeatures().get(5);
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
	public EClass getVisitableCS()
	{
		return visitableCSEClass;
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
	public EEnum getIteratorKind()
	{
		return iteratorKindEEnum;
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
		annotationCSEClass = createEClass(ANNOTATION_CS);
		createEReference(annotationCSEClass, ANNOTATION_CS__OWNED_CONTENT);
		createEReference(annotationCSEClass, ANNOTATION_CS__REFERENCE);

		annotationElementCSEClass = createEClass(ANNOTATION_ELEMENT_CS);
		createEReference(annotationElementCSEClass, ANNOTATION_ELEMENT_CS__OWNED_DETAIL);

		attributeCSEClass = createEClass(ATTRIBUTE_CS);

		attributeCSRefEClass = createEClass(ATTRIBUTE_CS_REF);
		createEReference(attributeCSRefEClass, ATTRIBUTE_CS_REF__REF);

		boundDocumentCSEClass = createEClass(BOUND_DOCUMENT_CS);

		classCSEClass = createEClass(CLASS_CS);
		createEReference(classCSEClass, CLASS_CS__OWNED_SUPER_TYPE);
		createEReference(classCSEClass, CLASS_CS__OWNED_OPERATION);
		createEReference(classCSEClass, CLASS_CS__OWNED_PROPERTY);
		createEReference(classCSEClass, CLASS_CS__OWNED_META_TYPE);

		classCSRefEClass = createEClass(CLASS_CS_REF);
		createEReference(classCSRefEClass, CLASS_CS_REF__REF);

		classifierCSEClass = createEClass(CLASSIFIER_CS);
		createEReference(classifierCSEClass, CLASSIFIER_CS__OWNER);
		createEAttribute(classifierCSEClass, CLASSIFIER_CS__INSTANCE_CLASS_NAME);
		createEReference(classifierCSEClass, CLASSIFIER_CS__OWNED_CONSTRAINT);
		createEAttribute(classifierCSEClass, CLASSIFIER_CS__QUALIFIER);

		collectionTypeRefCSEClass = createEClass(COLLECTION_TYPE_REF_CS);

		constraintCSEClass = createEClass(CONSTRAINT_CS);
		createEAttribute(constraintCSEClass, CONSTRAINT_CS__STEREOTYPE);
		createEAttribute(constraintCSEClass, CONSTRAINT_CS__EXPR_STRING);

		dataTypeCSEClass = createEClass(DATA_TYPE_CS);
		createEReference(dataTypeCSEClass, DATA_TYPE_CS__LITERALS);

		detailCSEClass = createEClass(DETAIL_CS);
		createEAttribute(detailCSEClass, DETAIL_CS__VALUE);

		documentationCSEClass = createEClass(DOCUMENTATION_CS);
		createEAttribute(documentationCSEClass, DOCUMENTATION_CS__VALUE);

		elementCSEClass = createEClass(ELEMENT_CS);

		enumerationCSEClass = createEClass(ENUMERATION_CS);
		createEReference(enumerationCSEClass, ENUMERATION_CS__OWNED_LITERALS);

		enumerationLiteralCSEClass = createEClass(ENUMERATION_LITERAL_CS);
		createEAttribute(enumerationLiteralCSEClass, ENUMERATION_LITERAL_CS__VALUE);

		featureCSEClass = createEClass(FEATURE_CS);

		importCSEClass = createEClass(IMPORT_CS);
		createEAttribute(importCSEClass, IMPORT_CS__URI);
		createEReference(importCSEClass, IMPORT_CS__NAMESPACE);

		libraryCSEClass = createEClass(LIBRARY_CS);
		createEReference(libraryCSEClass, LIBRARY_CS__PACKAGE);

		modelElementCSEClass = createEClass(MODEL_ELEMENT_CS);
		createEReference(modelElementCSEClass, MODEL_ELEMENT_CS__OWNED_ANNOTATION);
		createEReference(modelElementCSEClass, MODEL_ELEMENT_CS__PIVOT);
		createEAttribute(modelElementCSEClass, MODEL_ELEMENT_CS__ORIGINAL_XMI_ID);
		createEAttribute(modelElementCSEClass, MODEL_ELEMENT_CS__ERROR);

		modelElementCSRefEClass = createEClass(MODEL_ELEMENT_CS_REF);
		createEReference(modelElementCSRefEClass, MODEL_ELEMENT_CS_REF__REF);

		monikeredElementCSEClass = createEClass(MONIKERED_ELEMENT_CS);
		createEAttribute(monikeredElementCSEClass, MONIKERED_ELEMENT_CS__MONIKER);

		namedElementCSEClass = createEClass(NAMED_ELEMENT_CS);
		createEAttribute(namedElementCSEClass, NAMED_ELEMENT_CS__NAME);

		namespaceCSEClass = createEClass(NAMESPACE_CS);

		operationCSEClass = createEClass(OPERATION_CS);
		createEReference(operationCSEClass, OPERATION_CS__OWNING_CLASS);
		createEReference(operationCSEClass, OPERATION_CS__OWNED_PARAMETER);
		createEReference(operationCSEClass, OPERATION_CS__OWNED_EXCEPTION);

		packageCSEClass = createEClass(PACKAGE_CS);
		createEReference(packageCSEClass, PACKAGE_CS__OWNED_TYPE);
		createEReference(packageCSEClass, PACKAGE_CS__OWNED_NESTED_PACKAGE);
		createEAttribute(packageCSEClass, PACKAGE_CS__NS_PREFIX);
		createEAttribute(packageCSEClass, PACKAGE_CS__NS_URI);

		parameterCSEClass = createEClass(PARAMETER_CS);
		createEReference(parameterCSEClass, PARAMETER_CS__OWNER);

		parameterableElementCSEClass = createEClass(PARAMETERABLE_ELEMENT_CS);

		parameterizedTypeRefCSEClass = createEClass(PARAMETERIZED_TYPE_REF_CS);
		createEReference(parameterizedTypeRefCSEClass, PARAMETERIZED_TYPE_REF_CS__OWNED_TEMPLATE_BINDING);

		primitiveTypeRefCSEClass = createEClass(PRIMITIVE_TYPE_REF_CS);

		qualifiedRefCSEClass = createEClass(QUALIFIED_REF_CS);
		createEReference(qualifiedRefCSEClass, QUALIFIED_REF_CS__NAMESPACE);
		createEReference(qualifiedRefCSEClass, QUALIFIED_REF_CS__ELEMENT);

		qualifiedTypeRefCSEClass = createEClass(QUALIFIED_TYPE_REF_CS);

		referenceCSEClass = createEClass(REFERENCE_CS);
		createEReference(referenceCSEClass, REFERENCE_CS__OPPOSITE);
		createEReference(referenceCSEClass, REFERENCE_CS__KEYS);

		referenceCSRefEClass = createEClass(REFERENCE_CS_REF);
		createEReference(referenceCSRefEClass, REFERENCE_CS_REF__REF);

		rootCSEClass = createEClass(ROOT_CS);
		createEReference(rootCSEClass, ROOT_CS__OWNED_IMPORT);
		createEReference(rootCSEClass, ROOT_CS__OWNED_LIBRARY);

		rootPackageCSEClass = createEClass(ROOT_PACKAGE_CS);

		structuralFeatureCSEClass = createEClass(STRUCTURAL_FEATURE_CS);
		createEReference(structuralFeatureCSEClass, STRUCTURAL_FEATURE_CS__OWNER);
		createEAttribute(structuralFeatureCSEClass, STRUCTURAL_FEATURE_CS__DEFAULT);

		templateBindingCSEClass = createEClass(TEMPLATE_BINDING_CS);
		createEReference(templateBindingCSEClass, TEMPLATE_BINDING_CS__OWNING_TEMPLATE_BINDABLE_ELEMENT);
		createEReference(templateBindingCSEClass, TEMPLATE_BINDING_CS__OWNED_PARAMETER_SUBSTITUTION);

		templateParameterCSEClass = createEClass(TEMPLATE_PARAMETER_CS);
		createEReference(templateParameterCSEClass, TEMPLATE_PARAMETER_CS__OWNING_TEMPLATE_SIGNATURE);

		templateParameterSubstitutionCSEClass = createEClass(TEMPLATE_PARAMETER_SUBSTITUTION_CS);
		createEReference(templateParameterSubstitutionCSEClass, TEMPLATE_PARAMETER_SUBSTITUTION_CS__OWNING_TEMPLATE_BINDING);
		createEReference(templateParameterSubstitutionCSEClass, TEMPLATE_PARAMETER_SUBSTITUTION_CS__OWNED_ACTUAL_PARAMETER);

		templateSignatureCSEClass = createEClass(TEMPLATE_SIGNATURE_CS);
		createEReference(templateSignatureCSEClass, TEMPLATE_SIGNATURE_CS__OWNING_TEMPLATE_ELEMENT);
		createEReference(templateSignatureCSEClass, TEMPLATE_SIGNATURE_CS__OWNED_TEMPLATE_PARAMETER);

		templateableElementCSEClass = createEClass(TEMPLATEABLE_ELEMENT_CS);
		createEReference(templateableElementCSEClass, TEMPLATEABLE_ELEMENT_CS__OWNED_TEMPLATE_SIGNATURE);

		tuplePartCSEClass = createEClass(TUPLE_PART_CS);

		tupleTypeCSEClass = createEClass(TUPLE_TYPE_CS);
		createEReference(tupleTypeCSEClass, TUPLE_TYPE_CS__OWNED_PARTS);

		typeCSEClass = createEClass(TYPE_CS);

		typeParameterCSEClass = createEClass(TYPE_PARAMETER_CS);
		createEReference(typeParameterCSEClass, TYPE_PARAMETER_CS__OWNED_EXTENDS);
		createEReference(typeParameterCSEClass, TYPE_PARAMETER_CS__OWNED_SUPER);

		typeRefCSEClass = createEClass(TYPE_REF_CS);

		typedElementCSEClass = createEClass(TYPED_ELEMENT_CS);
		createEAttribute(typedElementCSEClass, TYPED_ELEMENT_CS__LOWER);
		createEAttribute(typedElementCSEClass, TYPED_ELEMENT_CS__MULTIPLICITY);
		createEReference(typedElementCSEClass, TYPED_ELEMENT_CS__OWNED_TYPE);
		createEAttribute(typedElementCSEClass, TYPED_ELEMENT_CS__UPPER);
		createEReference(typedElementCSEClass, TYPED_ELEMENT_CS__OWNED_CONSTRAINT);
		createEAttribute(typedElementCSEClass, TYPED_ELEMENT_CS__QUALIFIER);

		typedRefCSEClass = createEClass(TYPED_REF_CS);

		typedTypeRefCSEClass = createEClass(TYPED_TYPE_REF_CS);
		createEReference(typedTypeRefCSEClass, TYPED_TYPE_REF_CS__TYPE);

		visitableCSEClass = createEClass(VISITABLE_CS);

		wildcardTypeRefCSEClass = createEClass(WILDCARD_TYPE_REF_CS);
		createEReference(wildcardTypeRefCSEClass, WILDCARD_TYPE_REF_CS__EXTENDS);
		createEReference(wildcardTypeRefCSEClass, WILDCARD_TYPE_REF_CS__SUPER);

		// Create enums
		iteratorKindEEnum = createEEnum(ITERATOR_KIND);
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
		PivotPackage thePivotPackage = (PivotPackage)EPackage.Registry.INSTANCE.getEPackage(PivotPackage.eNS_URI);

		// Create type parameters
		ETypeParameter qualifiedRefCSEClass_E = addETypeParameter(qualifiedRefCSEClass, "E"); //$NON-NLS-1$

		// Set bounds for type parameters
		EGenericType g1 = createEGenericType(this.getElementCS());
		qualifiedRefCSEClass_E.getEBounds().add(g1);

		// Add supertypes to classes
		annotationCSEClass.getESuperTypes().add(this.getAnnotationElementCS());
		annotationElementCSEClass.getESuperTypes().add(this.getNamedElementCS());
		attributeCSEClass.getESuperTypes().add(this.getStructuralFeatureCS());
		attributeCSRefEClass.getESuperTypes().add(this.getElementCS());
		boundDocumentCSEClass.getESuperTypes().add(this.getPackageCS());
		classCSEClass.getESuperTypes().add(this.getClassifierCS());
		classCSEClass.getESuperTypes().add(this.getNamespaceCS());
		classCSRefEClass.getESuperTypes().add(this.getElementCS());
		classifierCSEClass.getESuperTypes().add(this.getNamedElementCS());
		classifierCSEClass.getESuperTypes().add(this.getTypeCS());
		classifierCSEClass.getESuperTypes().add(this.getTemplateableElementCS());
		classifierCSEClass.getESuperTypes().add(this.getParameterableElementCS());
		collectionTypeRefCSEClass.getESuperTypes().add(this.getTypedTypeRefCS());
		constraintCSEClass.getESuperTypes().add(this.getNamedElementCS());
		dataTypeCSEClass.getESuperTypes().add(this.getClassifierCS());
		dataTypeCSEClass.getESuperTypes().add(this.getNamespaceCS());
		detailCSEClass.getESuperTypes().add(this.getNamedElementCS());
		documentationCSEClass.getESuperTypes().add(this.getAnnotationElementCS());
		elementCSEClass.getESuperTypes().add(this.getVisitableCS());
		enumerationCSEClass.getESuperTypes().add(this.getClassifierCS());
		enumerationCSEClass.getESuperTypes().add(this.getNamespaceCS());
		enumerationLiteralCSEClass.getESuperTypes().add(this.getNamedElementCS());
		featureCSEClass.getESuperTypes().add(this.getTypedElementCS());
		importCSEClass.getESuperTypes().add(this.getNamespaceCS());
		libraryCSEClass.getESuperTypes().add(this.getNamespaceCS());
		modelElementCSEClass.getESuperTypes().add(this.getElementCS());
		modelElementCSEClass.getESuperTypes().add(thePivotPackage.getPivotable());
		modelElementCSRefEClass.getESuperTypes().add(this.getElementCS());
		monikeredElementCSEClass.getESuperTypes().add(this.getModelElementCS());
		namedElementCSEClass.getESuperTypes().add(this.getMonikeredElementCS());
		namedElementCSEClass.getESuperTypes().add(thePivotPackage.getNameable());
		namespaceCSEClass.getESuperTypes().add(this.getNamedElementCS());
		operationCSEClass.getESuperTypes().add(this.getFeatureCS());
		operationCSEClass.getESuperTypes().add(this.getTemplateableElementCS());
		packageCSEClass.getESuperTypes().add(this.getNamespaceCS());
		parameterCSEClass.getESuperTypes().add(this.getTypedElementCS());
		parameterableElementCSEClass.getESuperTypes().add(this.getMonikeredElementCS());
		parameterizedTypeRefCSEClass.getESuperTypes().add(this.getTypedRefCS());
		primitiveTypeRefCSEClass.getESuperTypes().add(this.getTypedRefCS());
		primitiveTypeRefCSEClass.getESuperTypes().add(this.getNamedElementCS());
		qualifiedRefCSEClass.getESuperTypes().add(this.getModelElementCS());
		g1 = createEGenericType(this.getParameterizedTypeRefCS());
		qualifiedTypeRefCSEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(this.getQualifiedRefCS());
		EGenericType g2 = createEGenericType(this.getParameterizedTypeRefCS());
		g1.getETypeArguments().add(g2);
		qualifiedTypeRefCSEClass.getEGenericSuperTypes().add(g1);
		referenceCSEClass.getESuperTypes().add(this.getStructuralFeatureCS());
		referenceCSRefEClass.getESuperTypes().add(this.getElementCS());
		rootCSEClass.getESuperTypes().add(this.getModelElementCS());
		rootPackageCSEClass.getESuperTypes().add(this.getPackageCS());
		rootPackageCSEClass.getESuperTypes().add(this.getRootCS());
		structuralFeatureCSEClass.getESuperTypes().add(this.getFeatureCS());
		templateBindingCSEClass.getESuperTypes().add(this.getModelElementCS());
		templateParameterCSEClass.getESuperTypes().add(this.getNamedElementCS());
		templateParameterSubstitutionCSEClass.getESuperTypes().add(this.getModelElementCS());
		templateSignatureCSEClass.getESuperTypes().add(this.getMonikeredElementCS());
		templateableElementCSEClass.getESuperTypes().add(this.getMonikeredElementCS());
		tuplePartCSEClass.getESuperTypes().add(this.getTypedElementCS());
		tupleTypeCSEClass.getESuperTypes().add(this.getNamedElementCS());
		tupleTypeCSEClass.getESuperTypes().add(this.getTypedRefCS());
		typeCSEClass.getESuperTypes().add(this.getMonikeredElementCS());
		typeParameterCSEClass.getESuperTypes().add(this.getTemplateParameterCS());
		typeParameterCSEClass.getESuperTypes().add(this.getTypeCS());
		typeRefCSEClass.getESuperTypes().add(this.getMonikeredElementCS());
		typeRefCSEClass.getESuperTypes().add(this.getParameterableElementCS());
		typedElementCSEClass.getESuperTypes().add(this.getNamedElementCS());
		typedRefCSEClass.getESuperTypes().add(this.getTypeRefCS());
		typedTypeRefCSEClass.getESuperTypes().add(this.getParameterizedTypeRefCS());
		wildcardTypeRefCSEClass.getESuperTypes().add(this.getTypeRefCS());

		// Initialize classes and features; add operations and parameters
		initEClass(annotationCSEClass, AnnotationCS.class, "AnnotationCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getAnnotationCS_OwnedContent(), this.getModelElementCS(), null, "ownedContent", null, 0, -1, AnnotationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getAnnotationCS_Reference(), this.getModelElementCSRef(), null, "reference", null, 0, -1, AnnotationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(annotationElementCSEClass, AnnotationElementCS.class, "AnnotationElementCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getAnnotationElementCS_OwnedDetail(), this.getDetailCS(), null, "ownedDetail", null, 0, -1, AnnotationElementCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(attributeCSEClass, AttributeCS.class, "AttributeCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(attributeCSRefEClass, AttributeCSRef.class, "AttributeCSRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getAttributeCSRef_Ref(), this.getAttributeCS(), null, "ref", null, 0, 1, AttributeCSRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(boundDocumentCSEClass, BoundDocumentCS.class, "BoundDocumentCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(classCSEClass, ClassCS.class, "ClassCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getClassCS_OwnedSuperType(), this.getTypedRefCS(), null, "ownedSuperType", null, 0, -1, ClassCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getClassCS_OwnedOperation(), this.getOperationCS(), this.getOperationCS_OwningClass(), "ownedOperation", null, 0, -1, ClassCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getClassCS_OwnedProperty(), this.getStructuralFeatureCS(), this.getStructuralFeatureCS_Owner(), "ownedProperty", null, 0, -1, ClassCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getClassCS_OwnedMetaType(), this.getTypedRefCS(), null, "ownedMetaType", null, 0, 1, ClassCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(classCSRefEClass, ClassCSRef.class, "ClassCSRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getClassCSRef_Ref(), this.getClassCS(), null, "ref", null, 0, 1, ClassCSRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(classifierCSEClass, ClassifierCS.class, "ClassifierCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getClassifierCS_Owner(), this.getPackageCS(), this.getPackageCS_OwnedType(), "owner", null, 0, 1, ClassifierCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getClassifierCS_InstanceClassName(), ecorePackage.getEString(), "instanceClassName", null, 0, 1, ClassifierCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getClassifierCS_OwnedConstraint(), this.getConstraintCS(), null, "ownedConstraint", null, 0, -1, ClassifierCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getClassifierCS_Qualifier(), ecorePackage.getEString(), "qualifier", null, 0, -1, ClassifierCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(collectionTypeRefCSEClass, CollectionTypeRefCS.class, "CollectionTypeRefCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(constraintCSEClass, ConstraintCS.class, "ConstraintCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getConstraintCS_Stereotype(), ecorePackage.getEString(), "stereotype", null, 0, 1, ConstraintCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getConstraintCS_ExprString(), ecorePackage.getEString(), "exprString", null, 0, 1, ConstraintCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(dataTypeCSEClass, DataTypeCS.class, "DataTypeCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getDataTypeCS_Literals(), this.getEnumerationLiteralCS(), null, "literals", null, 0, -1, DataTypeCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(detailCSEClass, DetailCS.class, "DetailCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getDetailCS_Value(), ecorePackage.getEString(), "value", null, 0, -1, DetailCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(documentationCSEClass, DocumentationCS.class, "DocumentationCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getDocumentationCS_Value(), ecorePackage.getEString(), "value", null, 0, 1, DocumentationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(elementCSEClass, ElementCS.class, "ElementCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		addEOperation(elementCSEClass, ecorePackage.getEString(), "getDescription", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		initEClass(enumerationCSEClass, EnumerationCS.class, "EnumerationCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getEnumerationCS_OwnedLiterals(), this.getEnumerationLiteralCS(), null, "ownedLiterals", null, 0, -1, EnumerationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(enumerationLiteralCSEClass, EnumerationLiteralCS.class, "EnumerationLiteralCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getEnumerationLiteralCS_Value(), ecorePackage.getEInt(), "value", null, 0, 1, EnumerationLiteralCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(featureCSEClass, FeatureCS.class, "FeatureCS", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(importCSEClass, ImportCS.class, "ImportCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getImportCS_Uri(), ecorePackage.getEString(), "uri", null, 0, 1, ImportCS.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getImportCS_Namespace(), thePivotPackage.getNamespace(), null, "namespace", null, 0, 1, ImportCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(libraryCSEClass, LibraryCS.class, "LibraryCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getLibraryCS_Package(), thePivotPackage.getPackage(), null, "package", null, 0, 1, LibraryCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(modelElementCSEClass, ModelElementCS.class, "ModelElementCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getModelElementCS_OwnedAnnotation(), this.getAnnotationElementCS(), null, "ownedAnnotation", null, 0, -1, ModelElementCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getModelElementCS_Pivot(), thePivotPackage.getElement(), null, "pivot", null, 0, 1, ModelElementCS.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getModelElementCS_OriginalXmiId(), ecorePackage.getEString(), "originalXmiId", null, 0, 1, ModelElementCS.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getModelElementCS_Error(), ecorePackage.getEString(), "error", null, 0, -1, ModelElementCS.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(modelElementCSRefEClass, ModelElementCSRef.class, "ModelElementCSRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getModelElementCSRef_Ref(), this.getModelElementCS(), null, "ref", null, 0, 1, ModelElementCSRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(monikeredElementCSEClass, MonikeredElementCS.class, "MonikeredElementCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getMonikeredElementCS_Moniker(), ecorePackage.getEString(), "moniker", null, 0, 1, MonikeredElementCS.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		addEOperation(monikeredElementCSEClass, ecorePackage.getEBoolean(), "hasMoniker", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		initEClass(namedElementCSEClass, NamedElementCS.class, "NamedElementCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getNamedElementCS_Name(), ecorePackage.getEString(), "name", null, 0, 1, NamedElementCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(namespaceCSEClass, NamespaceCS.class, "NamespaceCS", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(operationCSEClass, OperationCS.class, "OperationCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getOperationCS_OwningClass(), this.getClassCS(), this.getClassCS_OwnedOperation(), "owningClass", null, 0, 1, OperationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getOperationCS_OwnedParameter(), this.getParameterCS(), this.getParameterCS_Owner(), "ownedParameter", null, 0, -1, OperationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getOperationCS_OwnedException(), this.getTypedRefCS(), null, "ownedException", null, 0, -1, OperationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(packageCSEClass, PackageCS.class, "PackageCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getPackageCS_OwnedType(), this.getClassifierCS(), this.getClassifierCS_Owner(), "ownedType", null, 0, -1, PackageCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getPackageCS_OwnedNestedPackage(), this.getPackageCS(), null, "ownedNestedPackage", null, 0, -1, PackageCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getPackageCS_NsPrefix(), ecorePackage.getEString(), "nsPrefix", null, 0, 1, PackageCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getPackageCS_NsURI(), ecorePackage.getEString(), "nsURI", null, 0, 1, PackageCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		EOperation op = addEOperation(packageCSEClass, this.getClassifierCS(), "getClassifier", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		initEClass(parameterCSEClass, ParameterCS.class, "ParameterCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getParameterCS_Owner(), this.getOperationCS(), this.getOperationCS_OwnedParameter(), "owner", null, 0, 1, ParameterCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(parameterableElementCSEClass, ParameterableElementCS.class, "ParameterableElementCS", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(parameterizedTypeRefCSEClass, ParameterizedTypeRefCS.class, "ParameterizedTypeRefCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getParameterizedTypeRefCS_OwnedTemplateBinding(), this.getTemplateBindingCS(), this.getTemplateBindingCS_OwningTemplateBindableElement(), "ownedTemplateBinding", null, 0, 1, ParameterizedTypeRefCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		addEOperation(parameterizedTypeRefCSEClass, thePivotPackage.getType(), "getType", 0, 1, IS_UNIQUE, IS_ORDERED); //$NON-NLS-1$

		initEClass(primitiveTypeRefCSEClass, PrimitiveTypeRefCS.class, "PrimitiveTypeRefCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(qualifiedRefCSEClass, QualifiedRefCS.class, "QualifiedRefCS", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getQualifiedRefCS_Namespace(), thePivotPackage.getNamespace(), null, "namespace", null, 0, 1, QualifiedRefCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		g1 = createEGenericType(qualifiedRefCSEClass_E);
		initEReference(getQualifiedRefCS_Element(), g1, null, "element", null, 0, 1, QualifiedRefCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(qualifiedTypeRefCSEClass, QualifiedTypeRefCS.class, "QualifiedTypeRefCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(referenceCSEClass, ReferenceCS.class, "ReferenceCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getReferenceCS_Opposite(), this.getReferenceCSRef(), null, "opposite", null, 0, 1, ReferenceCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getReferenceCS_Keys(), this.getAttributeCSRef(), null, "keys", null, 0, -1, ReferenceCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(referenceCSRefEClass, ReferenceCSRef.class, "ReferenceCSRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getReferenceCSRef_Ref(), thePivotPackage.getProperty(), null, "ref", null, 0, 1, ReferenceCSRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(rootCSEClass, RootCS.class, "RootCS", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getRootCS_OwnedImport(), this.getImportCS(), null, "ownedImport", null, 0, -1, RootCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getRootCS_OwnedLibrary(), this.getLibraryCS(), null, "ownedLibrary", null, 0, -1, RootCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(rootPackageCSEClass, RootPackageCS.class, "RootPackageCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(structuralFeatureCSEClass, StructuralFeatureCS.class, "StructuralFeatureCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getStructuralFeatureCS_Owner(), this.getClassCS(), this.getClassCS_OwnedProperty(), "owner", null, 0, 1, StructuralFeatureCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getStructuralFeatureCS_Default(), ecorePackage.getEString(), "default", null, 0, 1, StructuralFeatureCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(templateBindingCSEClass, TemplateBindingCS.class, "TemplateBindingCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getTemplateBindingCS_OwningTemplateBindableElement(), this.getParameterizedTypeRefCS(), this.getParameterizedTypeRefCS_OwnedTemplateBinding(), "owningTemplateBindableElement", null, 0, 1, TemplateBindingCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getTemplateBindingCS_OwnedParameterSubstitution(), this.getTemplateParameterSubstitutionCS(), this.getTemplateParameterSubstitutionCS_OwningTemplateBinding(), "ownedParameterSubstitution", null, 0, -1, TemplateBindingCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(templateParameterCSEClass, TemplateParameterCS.class, "TemplateParameterCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getTemplateParameterCS_OwningTemplateSignature(), this.getTemplateSignatureCS(), this.getTemplateSignatureCS_OwnedTemplateParameter(), "owningTemplateSignature", null, 1, 1, TemplateParameterCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(templateParameterSubstitutionCSEClass, TemplateParameterSubstitutionCS.class, "TemplateParameterSubstitutionCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getTemplateParameterSubstitutionCS_OwningTemplateBinding(), this.getTemplateBindingCS(), this.getTemplateBindingCS_OwnedParameterSubstitution(), "owningTemplateBinding", null, 0, 1, TemplateParameterSubstitutionCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getTemplateParameterSubstitutionCS_OwnedActualParameter(), this.getParameterableElementCS(), null, "ownedActualParameter", null, 0, 1, TemplateParameterSubstitutionCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(templateSignatureCSEClass, TemplateSignatureCS.class, "TemplateSignatureCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getTemplateSignatureCS_OwningTemplateElement(), this.getTemplateableElementCS(), this.getTemplateableElementCS_OwnedTemplateSignature(), "owningTemplateElement", null, 0, 1, TemplateSignatureCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getTemplateSignatureCS_OwnedTemplateParameter(), this.getTemplateParameterCS(), this.getTemplateParameterCS_OwningTemplateSignature(), "ownedTemplateParameter", null, 0, -1, TemplateSignatureCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(templateableElementCSEClass, TemplateableElementCS.class, "TemplateableElementCS", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getTemplateableElementCS_OwnedTemplateSignature(), this.getTemplateSignatureCS(), this.getTemplateSignatureCS_OwningTemplateElement(), "ownedTemplateSignature", null, 0, 1, TemplateableElementCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(tuplePartCSEClass, TuplePartCS.class, "TuplePartCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(tupleTypeCSEClass, TupleTypeCS.class, "TupleTypeCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getTupleTypeCS_OwnedParts(), this.getTuplePartCS(), null, "ownedParts", null, 0, -1, TupleTypeCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(typeCSEClass, TypeCS.class, "TypeCS", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(typeParameterCSEClass, TypeParameterCS.class, "TypeParameterCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getTypeParameterCS_OwnedExtends(), this.getTypedRefCS(), null, "ownedExtends", null, 0, -1, TypeParameterCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getTypeParameterCS_OwnedSuper(), this.getTypedRefCS(), null, "ownedSuper", null, 0, 1, TypeParameterCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(typeRefCSEClass, TypeRefCS.class, "TypeRefCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(typedElementCSEClass, TypedElementCS.class, "TypedElementCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEAttribute(getTypedElementCS_Lower(), ecorePackage.getEInt(), "lower", "0", 0, 1, TypedElementCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEAttribute(getTypedElementCS_Multiplicity(), ecorePackage.getEString(), "multiplicity", null, 0, 1, TypedElementCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getTypedElementCS_OwnedType(), this.getTypedRefCS(), null, "ownedType", null, 0, 1, TypedElementCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getTypedElementCS_Upper(), ecorePackage.getEInt(), "upper", "1", 0, 1, TypedElementCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$
		initEReference(getTypedElementCS_OwnedConstraint(), this.getConstraintCS(), null, "ownedConstraint", null, 0, -1, TypedElementCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getTypedElementCS_Qualifier(), ecorePackage.getEString(), "qualifier", null, 0, -1, TypedElementCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(typedRefCSEClass, TypedRefCS.class, "TypedRefCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(typedTypeRefCSEClass, TypedTypeRefCS.class, "TypedTypeRefCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getTypedTypeRefCS_Type(), thePivotPackage.getType(), null, "type", null, 0, 1, TypedTypeRefCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(visitableCSEClass, VisitableCS.class, "VisitableCS", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$

		initEClass(wildcardTypeRefCSEClass, WildcardTypeRefCS.class, "WildcardTypeRefCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getWildcardTypeRefCS_Extends(), this.getTypedRefCS(), null, "extends", null, 0, 1, WildcardTypeRefCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEReference(getWildcardTypeRefCS_Super(), this.getTypedRefCS(), null, "super", null, 0, 1, WildcardTypeRefCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		// Initialize enums and add enum literals
		initEEnum(iteratorKindEEnum, IteratorKind.class, "IteratorKind"); //$NON-NLS-1$
		addEEnumLiteral(iteratorKindEEnum, IteratorKind.PARAMETER);
		addEEnumLiteral(iteratorKindEEnum, IteratorKind.ITERATOR);
		addEEnumLiteral(iteratorKindEEnum, IteratorKind.ACCUMULATOR);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/emf/2002/Ecore
		createEcoreAnnotations();
		// http://www.eclipse.org/emf/2002/Ecore/OCL
		createOCLAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createEcoreAnnotations()
	{
		String source = "http://www.eclipse.org/emf/2002/Ecore"; //$NON-NLS-1$		
		addAnnotation
		  (this, 
		   source, 
		   new String[] 
		   {
			 "invocationDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL", //$NON-NLS-1$ //$NON-NLS-2$
			 "settingDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL", //$NON-NLS-1$ //$NON-NLS-2$
			 "validationDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (rootCSEClass, 
		   source, 
		   new String[] 
		   {
			 "constraints", "TestConstraint" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (rootPackageCSEClass, 
		   source, 
		   new String[] 
		   {
			 "constraints", "TestConstraint" //$NON-NLS-1$ //$NON-NLS-2$
		   });	
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore/OCL</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createOCLAnnotations()
	{
		String source = "http://www.eclipse.org/emf/2002/Ecore/OCL"; //$NON-NLS-1$					
		addAnnotation
		  (rootCSEClass, 
		   source, 
		   new String[] 
		   {
			 "TestConstraint", "true" //$NON-NLS-1$ //$NON-NLS-2$
		   });			
		addAnnotation
		  (rootPackageCSEClass, 
		   source, 
		   new String[] 
		   {
			 "TestConstraint", "true" //$NON-NLS-1$ //$NON-NLS-2$
		   });
	}

} //BaseCSTPackageImpl
