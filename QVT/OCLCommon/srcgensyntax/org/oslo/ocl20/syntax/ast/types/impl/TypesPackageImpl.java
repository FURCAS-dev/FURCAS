/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.syntax.ast.types.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.oslo.ocl20.syntax.ast.AstPackage;

import org.oslo.ocl20.syntax.ast.contexts.ContextsPackage;

import org.oslo.ocl20.syntax.ast.contexts.impl.ContextsPackageImpl;

import org.oslo.ocl20.syntax.ast.expressions.ExpressionsPackage;

import org.oslo.ocl20.syntax.ast.expressions.impl.ExpressionsPackageImpl;

import org.oslo.ocl20.syntax.ast.impl.AstPackageImpl;

import org.oslo.ocl20.syntax.ast.qvt.impl.PackageImpl;
import org.oslo.ocl20.syntax.ast.qvt.QvtPackage;

import org.oslo.ocl20.syntax.ast.qvt.impl.QvtPackageImpl;

import org.oslo.ocl20.syntax.ast.types.BagTypeAS;
import org.oslo.ocl20.syntax.ast.types.ClassifierAS;
import org.oslo.ocl20.syntax.ast.types.CollectionTypeAS;
import org.oslo.ocl20.syntax.ast.types.OrderedSetTypeAS;
import org.oslo.ocl20.syntax.ast.types.SequenceTypeAS;
import org.oslo.ocl20.syntax.ast.types.SetTypeAS;
import org.oslo.ocl20.syntax.ast.types.TupleTypeAS;
import org.oslo.ocl20.syntax.ast.types.TypeAS;
import org.oslo.ocl20.syntax.ast.types.TypesFactory;
import org.oslo.ocl20.syntax.ast.types.TypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TypesPackageImpl extends EPackageImpl implements TypesPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bagTypeASEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classifierASEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass collectionTypeASEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass orderedSetTypeASEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sequenceTypeASEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass setTypeASEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tupleTypeASEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeASEClass = null;

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
	 * @see org.oslo.ocl20.syntax.ast.types.TypesPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private TypesPackageImpl() {
		super(eNS_URI, TypesFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this
	 * model, and for any others upon which it depends.  Simple
	 * dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else.  This method drives
	 * initialization for interdependent packages directly, in parallel
	 * with this package, itself.
	 * <p>Of this package and its interdependencies, all packages which
	 * have not yet been registered by their URI values are first created
	 * and registered.  The packages are then initialized in two steps:
	 * meta-model objects for all of the packages are created before any
	 * are initialized, since one package's meta-model objects may refer to
	 * those of another.
	 * <p>Invocation of this method will not affect any packages that have
	 * already been initialized.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static TypesPackage init() {
		if (isInited) return (TypesPackage)EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);

		// Obtain or create and register package
		TypesPackageImpl theTypesPackage = (TypesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof TypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new TypesPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		AstPackageImpl theAstPackage = (AstPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(AstPackage.eNS_URI) instanceof AstPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(AstPackage.eNS_URI) : AstPackage.eINSTANCE);
		ContextsPackageImpl theContextsPackage = (ContextsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ContextsPackage.eNS_URI) instanceof ContextsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ContextsPackage.eNS_URI) : ContextsPackage.eINSTANCE);
		ExpressionsPackageImpl theExpressionsPackage = (ExpressionsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ExpressionsPackage.eNS_URI) instanceof ExpressionsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ExpressionsPackage.eNS_URI) : ExpressionsPackage.eINSTANCE);
		PackageImpl thePackage = (PackageImpl)(EPackage.Registry.INSTANCE.getEPackage(org.oslo.ocl20.syntax.ast.qvt.Package.eNS_URI) instanceof PackageImpl ? EPackage.Registry.INSTANCE.getEPackage(org.oslo.ocl20.syntax.ast.qvt.Package.eNS_URI) : org.oslo.ocl20.syntax.ast.qvt.Package.eINSTANCE);

		// Create package meta-data objects
		theTypesPackage.createPackageContents();
		theAstPackage.createPackageContents();
		theContextsPackage.createPackageContents();
		theExpressionsPackage.createPackageContents();
		thePackage.createPackageContents();

		// Initialize created meta-data
		theTypesPackage.initializePackageContents();
		theAstPackage.initializePackageContents();
		theContextsPackage.initializePackageContents();
		theExpressionsPackage.initializePackageContents();
		thePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theTypesPackage.freeze();

		return theTypesPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBagTypeAS() {
		return bagTypeASEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassifierAS() {
		return classifierASEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassifierAS_PathName() {
		return (EAttribute)classifierASEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCollectionTypeAS() {
		return collectionTypeASEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollectionTypeAS_ElementType() {
		return (EReference)collectionTypeASEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOrderedSetTypeAS() {
		return orderedSetTypeASEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSequenceTypeAS() {
		return sequenceTypeASEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSetTypeAS() {
		return setTypeASEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTupleTypeAS() {
		return tupleTypeASEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTupleTypeAS_VariableDeclarationList() {
		return (EReference)tupleTypeASEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypeAS() {
		return typeASEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypesFactory getTypesFactory() {
		return (TypesFactory)getEFactoryInstance();
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
		bagTypeASEClass = createEClass(BAG_TYPE_AS);

		classifierASEClass = createEClass(CLASSIFIER_AS);
		createEAttribute(classifierASEClass, CLASSIFIER_AS__PATH_NAME);

		collectionTypeASEClass = createEClass(COLLECTION_TYPE_AS);
		createEReference(collectionTypeASEClass, COLLECTION_TYPE_AS__ELEMENT_TYPE);

		orderedSetTypeASEClass = createEClass(ORDERED_SET_TYPE_AS);

		sequenceTypeASEClass = createEClass(SEQUENCE_TYPE_AS);

		setTypeASEClass = createEClass(SET_TYPE_AS);

		tupleTypeASEClass = createEClass(TUPLE_TYPE_AS);
		createEReference(tupleTypeASEClass, TUPLE_TYPE_AS__VARIABLE_DECLARATION_LIST);

		typeASEClass = createEClass(TYPE_AS);
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
		AstPackage theAstPackage = (AstPackage)EPackage.Registry.INSTANCE.getEPackage(AstPackage.eNS_URI);
		ContextsPackage theContextsPackage = (ContextsPackage)EPackage.Registry.INSTANCE.getEPackage(ContextsPackage.eNS_URI);
		ExpressionsPackage theExpressionsPackage = (ExpressionsPackage)EPackage.Registry.INSTANCE.getEPackage(ExpressionsPackage.eNS_URI);

		// Add supertypes to classes
		bagTypeASEClass.getESuperTypes().add(this.getCollectionTypeAS());
		classifierASEClass.getESuperTypes().add(this.getTypeAS());
		collectionTypeASEClass.getESuperTypes().add(this.getTypeAS());
		orderedSetTypeASEClass.getESuperTypes().add(this.getCollectionTypeAS());
		sequenceTypeASEClass.getESuperTypes().add(this.getCollectionTypeAS());
		setTypeASEClass.getESuperTypes().add(this.getCollectionTypeAS());
		tupleTypeASEClass.getESuperTypes().add(this.getTypeAS());
		typeASEClass.getESuperTypes().add(theExpressionsPackage.getLiteralExpAS());

		// Initialize classes and features; add operations and parameters
		initEClass(bagTypeASEClass, BagTypeAS.class, "BagTypeAS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		EOperation op = addEOperation(bagTypeASEClass, theAstPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theAstPackage.getVisitor(), "visitor", 0, 1);
		addEParameter(op, theAstPackage.getObject(), "data", 0, 1);

		initEClass(classifierASEClass, ClassifierAS.class, "ClassifierAS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getClassifierAS_PathName(), theAstPackage.getList(), "pathName", null, 1, 1, ClassifierAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(classifierASEClass, theAstPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theAstPackage.getVisitor(), "visitor", 0, 1);
		addEParameter(op, theAstPackage.getObject(), "data", 0, 1);

		initEClass(collectionTypeASEClass, CollectionTypeAS.class, "CollectionTypeAS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCollectionTypeAS_ElementType(), this.getTypeAS(), null, "elementType", null, 1, 1, CollectionTypeAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(collectionTypeASEClass, theAstPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theAstPackage.getVisitor(), "visitor", 0, 1);
		addEParameter(op, theAstPackage.getObject(), "data", 0, 1);

		initEClass(orderedSetTypeASEClass, OrderedSetTypeAS.class, "OrderedSetTypeAS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(orderedSetTypeASEClass, theAstPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theAstPackage.getVisitor(), "visitor", 0, 1);
		addEParameter(op, theAstPackage.getObject(), "data", 0, 1);

		initEClass(sequenceTypeASEClass, SequenceTypeAS.class, "SequenceTypeAS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(sequenceTypeASEClass, theAstPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theAstPackage.getVisitor(), "visitor", 0, 1);
		addEParameter(op, theAstPackage.getObject(), "data", 0, 1);

		initEClass(setTypeASEClass, SetTypeAS.class, "SetTypeAS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(setTypeASEClass, theAstPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theAstPackage.getVisitor(), "visitor", 0, 1);
		addEParameter(op, theAstPackage.getObject(), "data", 0, 1);

		initEClass(tupleTypeASEClass, TupleTypeAS.class, "TupleTypeAS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTupleTypeAS_VariableDeclarationList(), theContextsPackage.getVariableDeclarationAS(), null, "variableDeclarationList", null, 0, -1, TupleTypeAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(tupleTypeASEClass, theAstPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theAstPackage.getVisitor(), "visitor", 0, 1);
		addEParameter(op, theAstPackage.getObject(), "data", 0, 1);

		initEClass(typeASEClass, TypeAS.class, "TypeAS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(typeASEClass, theAstPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theAstPackage.getVisitor(), "visitor", 0, 1);
		addEParameter(op, theAstPackage.getObject(), "data", 0, 1);
	}

} //TypesPackageImpl
