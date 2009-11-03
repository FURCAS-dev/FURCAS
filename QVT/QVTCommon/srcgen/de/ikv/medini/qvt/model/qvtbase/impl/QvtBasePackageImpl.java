/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ikv.medini.qvt.model.qvtbase.impl;

import de.ikv.medini.qvt.model.qvtbase.Domain;
import de.ikv.medini.qvt.model.qvtbase.Function;
import de.ikv.medini.qvt.model.qvtbase.FunctionParameter;
import de.ikv.medini.qvt.model.qvtbase.Pattern;
import de.ikv.medini.qvt.model.qvtbase.Predicate;
import de.ikv.medini.qvt.model.qvtbase.QvtBaseFactory;
import de.ikv.medini.qvt.model.qvtbase.QvtBasePackage;
import de.ikv.medini.qvt.model.qvtbase.Rule;
import de.ikv.medini.qvt.model.qvtbase.Transformation;
import de.ikv.medini.qvt.model.qvtbase.TypedModel;

import de.ikv.medini.qvt.model.qvtrelation.QvtRelationPackage;

import de.ikv.medini.qvt.model.qvtrelation.impl.QvtRelationPackageImpl;

import de.ikv.medini.qvt.model.qvttemplate.QvtTemplatePackage;

import de.ikv.medini.qvt.model.qvttemplate.impl.QvtTemplatePackageImpl;

import de.ikv.medini.qvt.qvt.QvtPackage;

import de.ikv.medini.qvt.qvt.impl.QvtPackageImpl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.oslo.ocl20.semantics.SemanticsPackage;

import org.oslo.ocl20.semantics.bridge.BridgePackage;

import org.oslo.ocl20.semantics.impl.SemanticsPackageImpl;

import org.oslo.ocl20.semantics.model.expressions.ExpressionsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class QvtBasePackageImpl extends EPackageImpl implements QvtBasePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass domainEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass functionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass functionParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass patternEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass predicateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ruleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass transformationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typedModelEClass = null;

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
	 * @see de.ikv.medini.qvt.model.qvtbase.QvtBasePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private QvtBasePackageImpl() {
		super(eNS_URI, QvtBaseFactory.eINSTANCE);
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
	public static QvtBasePackage init() {
		if (isInited) return (QvtBasePackage)EPackage.Registry.INSTANCE.getEPackage(QvtBasePackage.eNS_URI);

		// Obtain or create and register package
		QvtBasePackageImpl theQvtBasePackage = (QvtBasePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof QvtBasePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new QvtBasePackageImpl());

		isInited = true;

		// Initialize simple dependencies
		SemanticsPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		SemanticsPackageImpl theSemanticsPackage_1 = (SemanticsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SemanticsPackage.eNS_URI) instanceof SemanticsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SemanticsPackage.eNS_URI) : SemanticsPackage.eINSTANCE);
		QvtRelationPackageImpl theQvtRelationPackage = (QvtRelationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(QvtRelationPackage.eNS_URI) instanceof QvtRelationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(QvtRelationPackage.eNS_URI) : QvtRelationPackage.eINSTANCE);
		QvtTemplatePackageImpl theQvtTemplatePackage = (QvtTemplatePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(QvtTemplatePackage.eNS_URI) instanceof QvtTemplatePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(QvtTemplatePackage.eNS_URI) : QvtTemplatePackage.eINSTANCE);
		QvtPackageImpl theQvtPackage = (QvtPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(QvtPackage.eNS_URI) instanceof QvtPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(QvtPackage.eNS_URI) : QvtPackage.eINSTANCE);

		// Create package meta-data objects
		theQvtBasePackage.createPackageContents();
		theSemanticsPackage_1.createPackageContents();
		theQvtRelationPackage.createPackageContents();
		theQvtTemplatePackage.createPackageContents();
		theQvtPackage.createPackageContents();

		// Initialize created meta-data
		theQvtBasePackage.initializePackageContents();
		theSemanticsPackage_1.initializePackageContents();
		theQvtRelationPackage.initializePackageContents();
		theQvtTemplatePackage.initializePackageContents();
		theQvtPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theQvtBasePackage.freeze();

		return theQvtBasePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDomain() {
		return domainEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDomain_IsCheckable() {
		return (EAttribute)domainEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDomain_IsEnforcable() {
		return (EAttribute)domainEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDomain_TypedModel() {
		return (EReference)domainEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFunction() {
		return functionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunction_QueryExpression() {
		return (EReference)functionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFunctionParameter() {
		return functionParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPattern() {
		return patternEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPattern_WhereOwner() {
		return (EReference)patternEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPattern_WhenOwner() {
		return (EReference)patternEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPattern_Predicate() {
		return (EReference)patternEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPattern_BindsTo() {
		return (EReference)patternEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPredicate() {
		return predicateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPredicate_ContitionExpression() {
		return (EReference)predicateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPredicate_Pattern() {
		return (EReference)predicateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRule() {
		return ruleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRule_Domain() {
		return (EReference)ruleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRule_Overrides() {
		return (EReference)ruleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRule_Overriden() {
		return (EReference)ruleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRule_Transformation() {
		return (EReference)ruleEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTransformation() {
		return transformationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransformation_OwnedTag() {
		return (EReference)transformationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransformation_ModelParameter() {
		return (EReference)transformationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransformation_Extends() {
		return (EReference)transformationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTransformation_Rule() {
		return (EReference)transformationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypedModel() {
		return typedModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTypedModel_DependsOn() {
		return (EReference)typedModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTypedModel_UsedPackage() {
		return (EReference)typedModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QvtBaseFactory getQvtBaseFactory() {
		return (QvtBaseFactory)getEFactoryInstance();
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
		domainEClass = createEClass(DOMAIN);
		createEAttribute(domainEClass, DOMAIN__IS_CHECKABLE);
		createEAttribute(domainEClass, DOMAIN__IS_ENFORCABLE);
		createEReference(domainEClass, DOMAIN__TYPED_MODEL);

		functionEClass = createEClass(FUNCTION);
		createEReference(functionEClass, FUNCTION__QUERY_EXPRESSION);

		functionParameterEClass = createEClass(FUNCTION_PARAMETER);

		patternEClass = createEClass(PATTERN);
		createEReference(patternEClass, PATTERN__WHERE_OWNER);
		createEReference(patternEClass, PATTERN__WHEN_OWNER);
		createEReference(patternEClass, PATTERN__PREDICATE);
		createEReference(patternEClass, PATTERN__BINDS_TO);

		predicateEClass = createEClass(PREDICATE);
		createEReference(predicateEClass, PREDICATE__CONTITION_EXPRESSION);
		createEReference(predicateEClass, PREDICATE__PATTERN);

		ruleEClass = createEClass(RULE);
		createEReference(ruleEClass, RULE__DOMAIN);
		createEReference(ruleEClass, RULE__OVERRIDES);
		createEReference(ruleEClass, RULE__OVERRIDEN);
		createEReference(ruleEClass, RULE__TRANSFORMATION);

		transformationEClass = createEClass(TRANSFORMATION);
		createEReference(transformationEClass, TRANSFORMATION__OWNED_TAG);
		createEReference(transformationEClass, TRANSFORMATION__MODEL_PARAMETER);
		createEReference(transformationEClass, TRANSFORMATION__EXTENDS);
		createEReference(transformationEClass, TRANSFORMATION__RULE);

		typedModelEClass = createEClass(TYPED_MODEL);
		createEReference(typedModelEClass, TYPED_MODEL__DEPENDS_ON);
		createEReference(typedModelEClass, TYPED_MODEL__USED_PACKAGE);
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
		BridgePackage theBridgePackage = (BridgePackage)EPackage.Registry.INSTANCE.getEPackage(BridgePackage.eNS_URI);
		ExpressionsPackage theExpressionsPackage = (ExpressionsPackage)EPackage.Registry.INSTANCE.getEPackage(ExpressionsPackage.eNS_URI);
		SemanticsPackage theSemanticsPackage_1 = (SemanticsPackage)EPackage.Registry.INSTANCE.getEPackage(SemanticsPackage.eNS_URI);
		SemanticsPackage theSemanticsPackage = (SemanticsPackage)EPackage.Registry.INSTANCE.getEPackage(SemanticsPackage.eNS_URI);
		QvtRelationPackage theQvtRelationPackage = (QvtRelationPackage)EPackage.Registry.INSTANCE.getEPackage(QvtRelationPackage.eNS_URI);

		// Add supertypes to classes
		domainEClass.getESuperTypes().add(theBridgePackage.getNamedElement());
		functionEClass.getESuperTypes().add(theBridgePackage.getDefinedOperation());
		functionParameterEClass.getESuperTypes().add(theBridgePackage.getParameter());
		functionParameterEClass.getESuperTypes().add(theExpressionsPackage.getVariableDeclaration());
		patternEClass.getESuperTypes().add(theBridgePackage.getElement());
		predicateEClass.getESuperTypes().add(theBridgePackage.getElement());
		ruleEClass.getESuperTypes().add(theBridgePackage.getNamedElement());
		transformationEClass.getESuperTypes().add(theBridgePackage.getDefinedClass());
		transformationEClass.getESuperTypes().add(theBridgePackage.getDefinedPackage());
		typedModelEClass.getESuperTypes().add(theBridgePackage.getNamedElement());
		typedModelEClass.getESuperTypes().add(theSemanticsPackage.getSemanticsVisitable());

		// Initialize classes and features; add operations and parameters
		initEClass(domainEClass, Domain.class, "Domain", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDomain_IsCheckable(), ecorePackage.getEBoolean(), "isCheckable", null, 1, 1, Domain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDomain_IsEnforcable(), ecorePackage.getEBoolean(), "isEnforcable", null, 1, 1, Domain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDomain_TypedModel(), this.getTypedModel(), null, "typedModel", null, 0, 1, Domain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(functionEClass, Function.class, "Function", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFunction_QueryExpression(), theExpressionsPackage.getOclExpression(), null, "queryExpression", null, 0, 1, Function.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(functionEClass, theSemanticsPackage_1.getObject(), "accept", 0, 1);
		addEParameter(op, theSemanticsPackage.getOclVisitor(), "visitor", 0, 1);
		addEParameter(op, theSemanticsPackage_1.getObject(), "data", 0, 1);

		initEClass(functionParameterEClass, FunctionParameter.class, "FunctionParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(functionParameterEClass, theSemanticsPackage_1.getObject(), "accept", 0, 1);
		addEParameter(op, theSemanticsPackage.getOclVisitor(), "visitor", 0, 1);
		addEParameter(op, theSemanticsPackage_1.getObject(), "data", 0, 1);

		initEClass(patternEClass, Pattern.class, "Pattern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPattern_WhereOwner(), theQvtRelationPackage.getRelation(), theQvtRelationPackage.getRelation_Where(), "whereOwner", null, 1, 1, Pattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPattern_WhenOwner(), theQvtRelationPackage.getRelation(), theQvtRelationPackage.getRelation_When(), "whenOwner", null, 0, 1, Pattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPattern_Predicate(), this.getPredicate(), this.getPredicate_Pattern(), "predicate", null, 0, -1, Pattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPattern_BindsTo(), theExpressionsPackage.getVariableDeclaration(), null, "bindsTo", null, 0, -1, Pattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(patternEClass, theSemanticsPackage_1.getObject(), "accept", 0, 1);
		addEParameter(op, theSemanticsPackage.getOclVisitor(), "visitor", 0, 1);
		addEParameter(op, theSemanticsPackage_1.getObject(), "data", 0, 1);

		initEClass(predicateEClass, Predicate.class, "Predicate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPredicate_ContitionExpression(), theExpressionsPackage.getOclExpression(), null, "contitionExpression", null, 1, 1, Predicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPredicate_Pattern(), this.getPattern(), this.getPattern_Predicate(), "pattern", null, 1, 1, Predicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(predicateEClass, theSemanticsPackage_1.getObject(), "accept", 0, 1);
		addEParameter(op, theSemanticsPackage.getOclVisitor(), "visitor", 0, 1);
		addEParameter(op, theSemanticsPackage_1.getObject(), "data", 0, 1);

		initEClass(ruleEClass, Rule.class, "Rule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRule_Domain(), this.getDomain(), null, "domain", null, 0, -1, Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRule_Overrides(), this.getRule(), this.getRule_Overriden(), "overrides", null, 0, 1, Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRule_Overriden(), this.getRule(), this.getRule_Overrides(), "overriden", null, 0, -1, Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRule_Transformation(), this.getTransformation(), this.getTransformation_Rule(), "transformation", null, 1, 1, Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(transformationEClass, Transformation.class, "Transformation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTransformation_OwnedTag(), theBridgePackage.getTag(), null, "ownedTag", null, 0, -1, Transformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransformation_ModelParameter(), this.getTypedModel(), null, "modelParameter", null, 0, -1, Transformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransformation_Extends(), this.getTransformation(), null, "extends", null, 0, 1, Transformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTransformation_Rule(), this.getRule(), this.getRule_Transformation(), "rule", null, 0, -1, Transformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(transformationEClass, theSemanticsPackage_1.getObject(), "accept", 0, 1);
		addEParameter(op, theSemanticsPackage.getOclVisitor(), "visitor", 0, 1);
		addEParameter(op, theSemanticsPackage_1.getObject(), "data", 0, 1);

		initEClass(typedModelEClass, TypedModel.class, "TypedModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTypedModel_DependsOn(), this.getTypedModel(), null, "dependsOn", null, 0, -1, TypedModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTypedModel_UsedPackage(), theBridgePackage.getNamespace(), null, "usedPackage", null, 1, -1, TypedModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(typedModelEClass, theSemanticsPackage_1.getObject(), "accept", 0, 1);
		addEParameter(op, theSemanticsPackage.getOclVisitor(), "visitor", 0, 1);
		addEParameter(op, theSemanticsPackage_1.getObject(), "data", 0, 1);
	}

} //QvtBasePackageImpl
