/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.semantics.model.contexts.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.oslo.ocl20.semantics.SemanticsPackage;

import org.oslo.ocl20.semantics.bridge.BridgePackage;

import org.oslo.ocl20.semantics.bridge.impl.BridgePackageImpl;

import org.oslo.ocl20.semantics.impl.SemanticsPackageImpl;

import org.oslo.ocl20.semantics.model.contexts.ClassifierContextDecl;
import org.oslo.ocl20.semantics.model.contexts.Constraint;
import org.oslo.ocl20.semantics.model.contexts.ConstraintKind;
import org.oslo.ocl20.semantics.model.contexts.ContextDeclaration;
import org.oslo.ocl20.semantics.model.contexts.ContextsFactory;
import org.oslo.ocl20.semantics.model.contexts.ContextsPackage;
import org.oslo.ocl20.semantics.model.contexts.DefinedOperation;
import org.oslo.ocl20.semantics.model.contexts.DefinedProperty;
import org.oslo.ocl20.semantics.model.contexts.OperationContextDecl;
import org.oslo.ocl20.semantics.model.contexts.PropertyContextDecl;

import org.oslo.ocl20.semantics.model.expressions.ExpressionsPackage;

import org.oslo.ocl20.semantics.model.expressions.impl.ExpressionsPackageImpl;

import org.oslo.ocl20.semantics.model.types.TypesPackage;

import org.oslo.ocl20.semantics.model.types.impl.TypesPackageImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class ContextsPackageImpl extends EPackageImpl implements ContextsPackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass classifierContextDeclEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass constraintEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass contextDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass definedOperationEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass definedPropertyEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass operationContextDeclEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass propertyContextDeclEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EEnum constraintKindEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package package URI
	 * value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory method {@link #init
	 * init()}, which also performs initialization of the package, or returns the registered
	 * package, if one already exists. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.oslo.ocl20.semantics.model.contexts.ContextsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ContextsPackageImpl() {
		super(eNS_URI, ContextsFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others
	 * upon which it depends. Simple dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else. This method drives initialization for
	 * interdependent packages directly, in parallel with this package, itself.
	 * <p>
	 * Of this package and its interdependencies, all packages which have not yet been registered by
	 * their URI values are first created and registered. The packages are then initialized in two
	 * steps: meta-model objects for all of the packages are created before any are initialized,
	 * since one package's meta-model objects may refer to those of another.
	 * <p>
	 * Invocation of this method will not affect any packages that have already been initialized.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ContextsPackage init() {
		if (isInited)
			return (ContextsPackage) EPackage.Registry.INSTANCE.getEPackage(ContextsPackage.eNS_URI);

		// Obtain or create and register package
		ContextsPackageImpl theContextsPackage = (ContextsPackageImpl) (EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof ContextsPackageImpl
		        ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new ContextsPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		SemanticsPackageImpl theSemanticsPackage = (SemanticsPackageImpl) (EPackage.Registry.INSTANCE
		        .getEPackage(SemanticsPackage.eNS_URI) instanceof SemanticsPackageImpl ? EPackage.Registry.INSTANCE
		        .getEPackage(SemanticsPackage.eNS_URI) : SemanticsPackage.eINSTANCE);
		BridgePackageImpl theBridgePackage = (BridgePackageImpl) (EPackage.Registry.INSTANCE
		        .getEPackage(BridgePackage.eNS_URI) instanceof BridgePackageImpl ? EPackage.Registry.INSTANCE
		        .getEPackage(BridgePackage.eNS_URI) : BridgePackage.eINSTANCE);
		ExpressionsPackageImpl theExpressionsPackage = (ExpressionsPackageImpl) (EPackage.Registry.INSTANCE
		        .getEPackage(ExpressionsPackage.eNS_URI) instanceof ExpressionsPackageImpl ? EPackage.Registry.INSTANCE
		        .getEPackage(ExpressionsPackage.eNS_URI) : ExpressionsPackage.eINSTANCE);
		TypesPackageImpl theTypesPackage = (TypesPackageImpl) (EPackage.Registry.INSTANCE
		        .getEPackage(TypesPackage.eNS_URI) instanceof TypesPackageImpl ? EPackage.Registry.INSTANCE
		        .getEPackage(TypesPackage.eNS_URI) : TypesPackage.eINSTANCE);

		// Create package meta-data objects
		theContextsPackage.createPackageContents();
		theSemanticsPackage.createPackageContents();
		theBridgePackage.createPackageContents();
		theExpressionsPackage.createPackageContents();
		theTypesPackage.createPackageContents();

		// Initialize created meta-data
		theContextsPackage.initializePackageContents();
		theSemanticsPackage.initializePackageContents();
		theBridgePackage.initializePackageContents();
		theExpressionsPackage.initializePackageContents();
		theTypesPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theContextsPackage.freeze();

		return theContextsPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getClassifierContextDecl() {
		return classifierContextDeclEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getClassifierContextDecl_ReferredClassifier() {
		return (EReference) classifierContextDeclEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getConstraint() {
		return constraintEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getConstraint_Name() {
		return (EAttribute) constraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getConstraint_Kind() {
		return (EAttribute) constraintEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getConstraint_DefProperty() {
		return (EReference) constraintEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getConstraint_DefOperation() {
		return (EReference) constraintEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getConstraint_Context() {
		return (EReference) constraintEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getConstraint_BodyExpression() {
		return (EReference) constraintEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getContextDeclaration() {
		return contextDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getContextDeclaration_ReferredNamespace() {
		return (EReference) contextDeclarationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getContextDeclaration_Constraint() {
		return (EReference) contextDeclarationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getDefinedOperation() {
		return definedOperationEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getDefinedOperation_Definition() {
		return (EReference) definedOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getDefinedProperty() {
		return definedPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getDefinedProperty_Definition() {
		return (EReference) definedPropertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getOperationContextDecl() {
		return operationContextDeclEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getOperationContextDecl_ReferredOperation() {
		return (EReference) operationContextDeclEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getPropertyContextDecl() {
		return propertyContextDeclEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getPropertyContextDecl_ReferredProperty() {
		return (EReference) propertyContextDeclEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EEnum getConstraintKind() {
		return constraintKindEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ContextsFactory getContextsFactory() {
		return (ContextsFactory) getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package. This method is guarded to have no affect on
	 * any invocation but its first. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		classifierContextDeclEClass = createEClass(CLASSIFIER_CONTEXT_DECL);
		createEReference(classifierContextDeclEClass, CLASSIFIER_CONTEXT_DECL__REFERRED_CLASSIFIER);

		constraintEClass = createEClass(CONSTRAINT);
		createEAttribute(constraintEClass, CONSTRAINT__NAME);
		createEAttribute(constraintEClass, CONSTRAINT__KIND);
		createEReference(constraintEClass, CONSTRAINT__DEF_PROPERTY);
		createEReference(constraintEClass, CONSTRAINT__DEF_OPERATION);
		createEReference(constraintEClass, CONSTRAINT__CONTEXT);
		createEReference(constraintEClass, CONSTRAINT__BODY_EXPRESSION);

		contextDeclarationEClass = createEClass(CONTEXT_DECLARATION);
		createEReference(contextDeclarationEClass, CONTEXT_DECLARATION__REFERRED_NAMESPACE);
		createEReference(contextDeclarationEClass, CONTEXT_DECLARATION__CONSTRAINT);

		definedOperationEClass = createEClass(DEFINED_OPERATION);
		createEReference(definedOperationEClass, DEFINED_OPERATION__DEFINITION);

		definedPropertyEClass = createEClass(DEFINED_PROPERTY);
		createEReference(definedPropertyEClass, DEFINED_PROPERTY__DEFINITION);

		operationContextDeclEClass = createEClass(OPERATION_CONTEXT_DECL);
		createEReference(operationContextDeclEClass, OPERATION_CONTEXT_DECL__REFERRED_OPERATION);

		propertyContextDeclEClass = createEClass(PROPERTY_CONTEXT_DECL);
		createEReference(propertyContextDeclEClass, PROPERTY_CONTEXT_DECL__REFERRED_PROPERTY);

		// Create enums
		constraintKindEEnum = createEEnum(CONSTRAINT_KIND);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model. This method is guarded to have
	 * no affect on any invocation but its first. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		BridgePackage theBridgePackage = (BridgePackage) EPackage.Registry.INSTANCE.getEPackage(BridgePackage.eNS_URI);
		SemanticsPackage theSemanticsPackage = (SemanticsPackage) EPackage.Registry.INSTANCE
		        .getEPackage(SemanticsPackage.eNS_URI);
		ExpressionsPackage theExpressionsPackage = (ExpressionsPackage) EPackage.Registry.INSTANCE
		        .getEPackage(ExpressionsPackage.eNS_URI);

		// Add supertypes to classes
		classifierContextDeclEClass.getESuperTypes().add(this.getContextDeclaration());
		constraintEClass.getESuperTypes().add(theSemanticsPackage.getSemanticsVisitable());
		contextDeclarationEClass.getESuperTypes().add(theSemanticsPackage.getSemanticsVisitable());
		definedOperationEClass.getESuperTypes().add(theBridgePackage.getOperation());
		definedPropertyEClass.getESuperTypes().add(theBridgePackage.getProperty());
		operationContextDeclEClass.getESuperTypes().add(this.getContextDeclaration());
		propertyContextDeclEClass.getESuperTypes().add(this.getContextDeclaration());

		// Initialize classes and features; add operations and parameters
		initEClass(classifierContextDeclEClass, ClassifierContextDecl.class, "ClassifierContextDecl", !IS_ABSTRACT,
		    !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getClassifierContextDecl_ReferredClassifier(), theBridgePackage.getClassifier(), null,
		    "referredClassifier", null, 1, 1, ClassifierContextDecl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
		    !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(classifierContextDeclEClass, theSemanticsPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theSemanticsPackage.getOclVisitor(), "visitor", 0, 1);
		addEParameter(op, theSemanticsPackage.getObject(), "data", 0, 1);

		initEClass(constraintEClass, Constraint.class, "Constraint", !IS_ABSTRACT, !IS_INTERFACE,
		    IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConstraint_Name(), ecorePackage.getEString(), "name", null, 1, 1, Constraint.class,
		    !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConstraint_Kind(), this.getConstraintKind(), "kind", null, 1, 1, Constraint.class,
		    !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConstraint_DefProperty(), theBridgePackage.getProperty(), null, "defProperty", null, 0, 1,
		    Constraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
		    !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConstraint_DefOperation(), theBridgePackage.getOperation(), null, "defOperation", null, 0, 1,
		    Constraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
		    !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConstraint_Context(), this.getContextDeclaration(), this.getContextDeclaration_Constraint(),
		    "context", null, 1, 1, Constraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
		    !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConstraint_BodyExpression(), theExpressionsPackage.getOclExpression(), null,
		    "bodyExpression", null, 1, 1, Constraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
		    !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(constraintEClass, theSemanticsPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theSemanticsPackage.getOclVisitor(), "visitor", 0, 1);
		addEParameter(op, theSemanticsPackage.getObject(), "data", 0, 1);

		initEClass(contextDeclarationEClass, ContextDeclaration.class, "ContextDeclaration", !IS_ABSTRACT,
		    !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getContextDeclaration_ReferredNamespace(), theBridgePackage.getNamespace(), null,
		    "referredNamespace", null, 1, 1, ContextDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
		    !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getContextDeclaration_Constraint(), this.getConstraint(), this.getConstraint_Context(),
		    "constraint", null, 0, -1, ContextDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
		    IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(contextDeclarationEClass, theSemanticsPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theSemanticsPackage.getOclVisitor(), "visitor", 0, 1);
		addEParameter(op, theSemanticsPackage.getObject(), "data", 0, 1);

		initEClass(definedOperationEClass, DefinedOperation.class, "DefinedOperation", !IS_ABSTRACT, !IS_INTERFACE,
		    IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDefinedOperation_Definition(), this.getConstraint(), null, "definition", null, 1, 1,
		    DefinedOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
		    !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(definedPropertyEClass, DefinedProperty.class, "DefinedProperty", !IS_ABSTRACT, !IS_INTERFACE,
		    IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDefinedProperty_Definition(), this.getConstraint(), null, "definition", null, 1, 1,
		    DefinedProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
		    !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(definedPropertyEClass, theSemanticsPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theSemanticsPackage.getOclVisitor(), "visitor", 0, 1);
		addEParameter(op, theSemanticsPackage.getObject(), "data", 0, 1);

		initEClass(operationContextDeclEClass, OperationContextDecl.class, "OperationContextDecl", !IS_ABSTRACT,
		    !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOperationContextDecl_ReferredOperation(), theBridgePackage.getOperation(), null,
		    "referredOperation", null, 1, 1, OperationContextDecl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
		    !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(operationContextDeclEClass, theSemanticsPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theSemanticsPackage.getOclVisitor(), "visitor", 0, 1);
		addEParameter(op, theSemanticsPackage.getObject(), "data", 0, 1);

		initEClass(propertyContextDeclEClass, PropertyContextDecl.class, "PropertyContextDecl", !IS_ABSTRACT,
		    !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPropertyContextDecl_ReferredProperty(), theBridgePackage.getProperty(), null,
		    "referredProperty", null, 1, 1, PropertyContextDecl.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
		    !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(propertyContextDeclEClass, theSemanticsPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theSemanticsPackage.getOclVisitor(), "visitor", 0, 1);
		addEParameter(op, theSemanticsPackage.getObject(), "data", 0, 1);

		// Initialize enums and add enum literals
		initEEnum(constraintKindEEnum, ConstraintKind.class, "ConstraintKind");
		addEEnumLiteral(constraintKindEEnum, ConstraintKind.INIT_LITERAL);
		addEEnumLiteral(constraintKindEEnum, ConstraintKind.DERIVE_LITERAL);
		addEEnumLiteral(constraintKindEEnum, ConstraintKind.INV_LITERAL);
		addEEnumLiteral(constraintKindEEnum, ConstraintKind.DEF_LITERAL);
		addEEnumLiteral(constraintKindEEnum, ConstraintKind.PRE_LITERAL);
		addEEnumLiteral(constraintKindEEnum, ConstraintKind.POST_LITERAL);
		addEEnumLiteral(constraintKindEEnum, ConstraintKind.BODY_LITERAL);
	}

} // ContextsPackageImpl
