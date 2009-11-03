/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.syntax.ast.contexts.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.oslo.ocl20.syntax.ast.AstPackage;

import org.oslo.ocl20.syntax.ast.contexts.ClassifierContextDeclAS;
import org.oslo.ocl20.syntax.ast.contexts.ConstraintAS;
import org.oslo.ocl20.syntax.ast.contexts.ConstraintKindAS;
import org.oslo.ocl20.syntax.ast.contexts.ContextDeclarationAS;
import org.oslo.ocl20.syntax.ast.contexts.ContextsFactory;
import org.oslo.ocl20.syntax.ast.contexts.ContextsPackage;
import org.oslo.ocl20.syntax.ast.contexts.OperationAS;
import org.oslo.ocl20.syntax.ast.contexts.OperationContextDeclAS;
import org.oslo.ocl20.syntax.ast.contexts.PackageDeclarationAS;
import org.oslo.ocl20.syntax.ast.contexts.PropertyContextDeclAS;
import org.oslo.ocl20.syntax.ast.contexts.VariableDeclarationAS;

import org.oslo.ocl20.syntax.ast.expressions.ExpressionsPackage;

import org.oslo.ocl20.syntax.ast.expressions.impl.ExpressionsPackageImpl;

import org.oslo.ocl20.syntax.ast.impl.AstPackageImpl;

import org.oslo.ocl20.syntax.ast.qvt.impl.PackageImpl;
import org.oslo.ocl20.syntax.ast.qvt.QvtPackage;

import org.oslo.ocl20.syntax.ast.qvt.impl.QvtPackageImpl;

import org.oslo.ocl20.syntax.ast.types.TypesPackage;

import org.oslo.ocl20.syntax.ast.types.impl.TypesPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ContextsPackageImpl extends EPackageImpl implements ContextsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classifierContextDeclASEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constraintASEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass contextDeclarationASEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operationASEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operationContextDeclASEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass packageDeclarationASEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyContextDeclASEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variableDeclarationASEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum constraintKindASEEnum = null;

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
	 * @see org.oslo.ocl20.syntax.ast.contexts.ContextsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ContextsPackageImpl() {
		super(eNS_URI, ContextsFactory.eINSTANCE);
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
	public static ContextsPackage init() {
		if (isInited) return (ContextsPackage)EPackage.Registry.INSTANCE.getEPackage(ContextsPackage.eNS_URI);

		// Obtain or create and register package
		ContextsPackageImpl theContextsPackage = (ContextsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof ContextsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new ContextsPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		AstPackageImpl theAstPackage = (AstPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(AstPackage.eNS_URI) instanceof AstPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(AstPackage.eNS_URI) : AstPackage.eINSTANCE);
		ExpressionsPackageImpl theExpressionsPackage = (ExpressionsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ExpressionsPackage.eNS_URI) instanceof ExpressionsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ExpressionsPackage.eNS_URI) : ExpressionsPackage.eINSTANCE);
		PackageImpl thePackage = (PackageImpl)(EPackage.Registry.INSTANCE.getEPackage(org.oslo.ocl20.syntax.ast.qvt.Package.eNS_URI) instanceof PackageImpl ? EPackage.Registry.INSTANCE.getEPackage(org.oslo.ocl20.syntax.ast.qvt.Package.eNS_URI) : org.oslo.ocl20.syntax.ast.qvt.Package.eINSTANCE);
		TypesPackageImpl theTypesPackage = (TypesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI) instanceof TypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI) : TypesPackage.eINSTANCE);

		// Create package meta-data objects
		theContextsPackage.createPackageContents();
		theAstPackage.createPackageContents();
		theExpressionsPackage.createPackageContents();
		thePackage.createPackageContents();
		theTypesPackage.createPackageContents();

		// Initialize created meta-data
		theContextsPackage.initializePackageContents();
		theAstPackage.initializePackageContents();
		theExpressionsPackage.initializePackageContents();
		thePackage.initializePackageContents();
		theTypesPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theContextsPackage.freeze();

		return theContextsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassifierContextDeclAS() {
		return classifierContextDeclASEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getClassifierContextDeclAS_PathName() {
		return (EAttribute)classifierContextDeclASEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassifierContextDeclAS_Type() {
		return (EReference)classifierContextDeclASEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConstraintAS() {
		return constraintASEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConstraintAS_Name() {
		return (EAttribute)constraintASEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConstraintAS_Kind() {
		return (EAttribute)constraintASEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConstraintAS_BodyExpression() {
		return (EReference)constraintASEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConstraintAS_DefOperation() {
		return (EReference)constraintASEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConstraintAS_DefVariable() {
		return (EReference)constraintASEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContextDeclarationAS() {
		return contextDeclarationASEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContextDeclarationAS_Constraints() {
		return (EReference)contextDeclarationASEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOperationAS() {
		return operationASEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOperationAS_PathName() {
		return (EAttribute)operationASEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOperationAS_Name() {
		return (EAttribute)operationASEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperationAS_Parameters() {
		return (EReference)operationASEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperationAS_Type() {
		return (EReference)operationASEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOperationContextDeclAS() {
		return operationContextDeclASEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperationContextDeclAS_Operation() {
		return (EReference)operationContextDeclASEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPackageDeclarationAS() {
		return packageDeclarationASEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPackageDeclarationAS_PathName() {
		return (EAttribute)packageDeclarationASEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPackageDeclarationAS_ContextDecls() {
		return (EReference)packageDeclarationASEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPropertyContextDeclAS() {
		return propertyContextDeclASEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertyContextDeclAS_PathName() {
		return (EAttribute)propertyContextDeclASEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPropertyContextDeclAS_Name() {
		return (EAttribute)propertyContextDeclASEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertyContextDeclAS_Type() {
		return (EReference)propertyContextDeclASEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVariableDeclarationAS() {
		return variableDeclarationASEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVariableDeclarationAS_Name() {
		return (EAttribute)variableDeclarationASEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariableDeclarationAS_InitExp() {
		return (EReference)variableDeclarationASEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariableDeclarationAS_Type() {
		return (EReference)variableDeclarationASEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getConstraintKindAS() {
		return constraintKindASEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContextsFactory getContextsFactory() {
		return (ContextsFactory)getEFactoryInstance();
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
		classifierContextDeclASEClass = createEClass(CLASSIFIER_CONTEXT_DECL_AS);
		createEAttribute(classifierContextDeclASEClass, CLASSIFIER_CONTEXT_DECL_AS__PATH_NAME);
		createEReference(classifierContextDeclASEClass, CLASSIFIER_CONTEXT_DECL_AS__TYPE);

		constraintASEClass = createEClass(CONSTRAINT_AS);
		createEAttribute(constraintASEClass, CONSTRAINT_AS__NAME);
		createEAttribute(constraintASEClass, CONSTRAINT_AS__KIND);
		createEReference(constraintASEClass, CONSTRAINT_AS__DEF_OPERATION);
		createEReference(constraintASEClass, CONSTRAINT_AS__BODY_EXPRESSION);
		createEReference(constraintASEClass, CONSTRAINT_AS__DEF_VARIABLE);

		contextDeclarationASEClass = createEClass(CONTEXT_DECLARATION_AS);
		createEReference(contextDeclarationASEClass, CONTEXT_DECLARATION_AS__CONSTRAINTS);

		operationASEClass = createEClass(OPERATION_AS);
		createEAttribute(operationASEClass, OPERATION_AS__PATH_NAME);
		createEAttribute(operationASEClass, OPERATION_AS__NAME);
		createEReference(operationASEClass, OPERATION_AS__PARAMETERS);
		createEReference(operationASEClass, OPERATION_AS__TYPE);

		operationContextDeclASEClass = createEClass(OPERATION_CONTEXT_DECL_AS);
		createEReference(operationContextDeclASEClass, OPERATION_CONTEXT_DECL_AS__OPERATION);

		packageDeclarationASEClass = createEClass(PACKAGE_DECLARATION_AS);
		createEAttribute(packageDeclarationASEClass, PACKAGE_DECLARATION_AS__PATH_NAME);
		createEReference(packageDeclarationASEClass, PACKAGE_DECLARATION_AS__CONTEXT_DECLS);

		propertyContextDeclASEClass = createEClass(PROPERTY_CONTEXT_DECL_AS);
		createEAttribute(propertyContextDeclASEClass, PROPERTY_CONTEXT_DECL_AS__PATH_NAME);
		createEAttribute(propertyContextDeclASEClass, PROPERTY_CONTEXT_DECL_AS__NAME);
		createEReference(propertyContextDeclASEClass, PROPERTY_CONTEXT_DECL_AS__TYPE);

		variableDeclarationASEClass = createEClass(VARIABLE_DECLARATION_AS);
		createEAttribute(variableDeclarationASEClass, VARIABLE_DECLARATION_AS__NAME);
		createEReference(variableDeclarationASEClass, VARIABLE_DECLARATION_AS__INIT_EXP);
		createEReference(variableDeclarationASEClass, VARIABLE_DECLARATION_AS__TYPE);

		// Create enums
		constraintKindASEEnum = createEEnum(CONSTRAINT_KIND_AS);
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
		TypesPackage theTypesPackage = (TypesPackage)EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);
		AstPackage theAstPackage = (AstPackage)EPackage.Registry.INSTANCE.getEPackage(AstPackage.eNS_URI);
		ExpressionsPackage theExpressionsPackage = (ExpressionsPackage)EPackage.Registry.INSTANCE.getEPackage(ExpressionsPackage.eNS_URI);

		// Add supertypes to classes
		classifierContextDeclASEClass.getESuperTypes().add(this.getContextDeclarationAS());
		constraintASEClass.getESuperTypes().add(theAstPackage.getVisitable());
		contextDeclarationASEClass.getESuperTypes().add(theAstPackage.getVisitable());
		operationASEClass.getESuperTypes().add(theAstPackage.getVisitable());
		operationContextDeclASEClass.getESuperTypes().add(this.getContextDeclarationAS());
		packageDeclarationASEClass.getESuperTypes().add(theAstPackage.getVisitable());
		propertyContextDeclASEClass.getESuperTypes().add(this.getContextDeclarationAS());
		variableDeclarationASEClass.getESuperTypes().add(theAstPackage.getVisitable());

		// Initialize classes and features; add operations and parameters
		initEClass(classifierContextDeclASEClass, ClassifierContextDeclAS.class, "ClassifierContextDeclAS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getClassifierContextDeclAS_PathName(), ecorePackage.getEString(), "pathName", null, 0, -1, ClassifierContextDeclAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClassifierContextDeclAS_Type(), theTypesPackage.getTypeAS(), null, "type", null, 1, 1, ClassifierContextDeclAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(classifierContextDeclASEClass, theAstPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theAstPackage.getVisitor(), "visitor", 0, 1);
		addEParameter(op, theAstPackage.getObject(), "data", 0, 1);

		initEClass(constraintASEClass, ConstraintAS.class, "ConstraintAS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConstraintAS_Name(), ecorePackage.getEString(), "name", null, 1, 1, ConstraintAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConstraintAS_Kind(), this.getConstraintKindAS(), "kind", null, 1, 1, ConstraintAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConstraintAS_DefOperation(), this.getOperationAS(), null, "defOperation", null, 0, 1, ConstraintAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConstraintAS_BodyExpression(), theExpressionsPackage.getOclExpressionAS(), null, "bodyExpression", null, 1, 1, ConstraintAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConstraintAS_DefVariable(), this.getVariableDeclarationAS(), null, "defVariable", null, 0, 1, ConstraintAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(constraintASEClass, theAstPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theAstPackage.getVisitor(), "visitor", 0, 1);
		addEParameter(op, theAstPackage.getObject(), "data", 0, 1);

		initEClass(contextDeclarationASEClass, ContextDeclarationAS.class, "ContextDeclarationAS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getContextDeclarationAS_Constraints(), this.getConstraintAS(), null, "constraints", null, 0, -1, ContextDeclarationAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(contextDeclarationASEClass, theAstPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theAstPackage.getVisitor(), "visitor", 0, 1);
		addEParameter(op, theAstPackage.getObject(), "data", 0, 1);

		initEClass(operationASEClass, OperationAS.class, "OperationAS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOperationAS_PathName(), ecorePackage.getEString(), "pathName", null, 0, -1, OperationAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOperationAS_Name(), ecorePackage.getEString(), "name", null, 1, 1, OperationAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOperationAS_Parameters(), this.getVariableDeclarationAS(), null, "parameters", null, 0, -1, OperationAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOperationAS_Type(), theTypesPackage.getTypeAS(), null, "type", null, 1, 1, OperationAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(operationASEClass, theAstPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theAstPackage.getVisitor(), "visitor", 0, 1);
		addEParameter(op, theAstPackage.getObject(), "data", 0, 1);

		initEClass(operationContextDeclASEClass, OperationContextDeclAS.class, "OperationContextDeclAS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOperationContextDeclAS_Operation(), this.getOperationAS(), null, "operation", null, 1, 1, OperationContextDeclAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(operationContextDeclASEClass, theAstPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theAstPackage.getVisitor(), "visitor", 0, 1);
		addEParameter(op, theAstPackage.getObject(), "data", 0, 1);

		initEClass(packageDeclarationASEClass, PackageDeclarationAS.class, "PackageDeclarationAS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPackageDeclarationAS_PathName(), ecorePackage.getEString(), "pathName", null, 0, -1, PackageDeclarationAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPackageDeclarationAS_ContextDecls(), this.getContextDeclarationAS(), null, "contextDecls", null, 0, -1, PackageDeclarationAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(packageDeclarationASEClass, theAstPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theAstPackage.getVisitor(), "visitor", 0, 1);
		addEParameter(op, theAstPackage.getObject(), "data", 0, 1);

		initEClass(propertyContextDeclASEClass, PropertyContextDeclAS.class, "PropertyContextDeclAS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPropertyContextDeclAS_PathName(), ecorePackage.getEString(), "pathName", null, 0, -1, PropertyContextDeclAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPropertyContextDeclAS_Name(), ecorePackage.getEString(), "name", null, 1, 1, PropertyContextDeclAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPropertyContextDeclAS_Type(), theTypesPackage.getTypeAS(), null, "type", null, 1, 1, PropertyContextDeclAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(propertyContextDeclASEClass, theAstPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theAstPackage.getVisitor(), "visitor", 0, 1);
		addEParameter(op, theAstPackage.getObject(), "data", 0, 1);

		initEClass(variableDeclarationASEClass, VariableDeclarationAS.class, "VariableDeclarationAS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVariableDeclarationAS_Name(), ecorePackage.getEString(), "name", null, 1, 1, VariableDeclarationAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVariableDeclarationAS_InitExp(), theExpressionsPackage.getOclExpressionAS(), null, "initExp", null, 0, 1, VariableDeclarationAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVariableDeclarationAS_Type(), theTypesPackage.getTypeAS(), null, "type", null, 1, 1, VariableDeclarationAS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(variableDeclarationASEClass, theAstPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theAstPackage.getVisitor(), "visitor", 0, 1);
		addEParameter(op, theAstPackage.getObject(), "data", 0, 1);

		// Initialize enums and add enum literals
		initEEnum(constraintKindASEEnum, ConstraintKindAS.class, "ConstraintKindAS");
		addEEnumLiteral(constraintKindASEEnum, ConstraintKindAS.INIT_LITERAL);
		addEEnumLiteral(constraintKindASEEnum, ConstraintKindAS.DERIVE_LITERAL);
		addEEnumLiteral(constraintKindASEEnum, ConstraintKindAS.INV_LITERAL);
		addEEnumLiteral(constraintKindASEEnum, ConstraintKindAS.DEF_LITERAL);
		addEEnumLiteral(constraintKindASEEnum, ConstraintKindAS.PRE_LITERAL);
		addEEnumLiteral(constraintKindASEEnum, ConstraintKindAS.POST_LITERAL);
		addEEnumLiteral(constraintKindASEEnum, ConstraintKindAS.BODY_LITERAL);
	}

} //ContextsPackageImpl
