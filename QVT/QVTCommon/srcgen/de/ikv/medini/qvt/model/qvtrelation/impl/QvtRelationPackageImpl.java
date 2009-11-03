/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ikv.medini.qvt.model.qvtrelation.impl;

import de.ikv.medini.qvt.model.qvtbase.QvtBasePackage;

import de.ikv.medini.qvt.model.qvtbase.impl.QvtBasePackageImpl;

import de.ikv.medini.qvt.model.qvtrelation.DomainPattern;
import de.ikv.medini.qvt.model.qvtrelation.Key;
import de.ikv.medini.qvt.model.qvtrelation.QvtRelationFactory;
import de.ikv.medini.qvt.model.qvtrelation.QvtRelationPackage;
import de.ikv.medini.qvt.model.qvtrelation.Relation;
import de.ikv.medini.qvt.model.qvtrelation.RelationCallExp;
import de.ikv.medini.qvt.model.qvtrelation.RelationDomain;
import de.ikv.medini.qvt.model.qvtrelation.RelationImplementation;
import de.ikv.medini.qvt.model.qvtrelation.RelationalTransformation;

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
public class QvtRelationPackageImpl extends EPackageImpl implements QvtRelationPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass domainPatternEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass keyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass relationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass relationCallExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass relationDomainEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass relationImplementationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass relationalTransformationEClass = null;

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
	 * @see de.ikv.medini.qvt.model.qvtrelation.QvtRelationPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private QvtRelationPackageImpl() {
		super(eNS_URI, QvtRelationFactory.eINSTANCE);
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
	public static QvtRelationPackage init() {
		if (isInited) return (QvtRelationPackage)EPackage.Registry.INSTANCE.getEPackage(QvtRelationPackage.eNS_URI);

		// Obtain or create and register package
		QvtRelationPackageImpl theQvtRelationPackage = (QvtRelationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof QvtRelationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new QvtRelationPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		SemanticsPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		SemanticsPackageImpl theSemanticsPackage_1 = (SemanticsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SemanticsPackage.eNS_URI) instanceof SemanticsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SemanticsPackage.eNS_URI) : SemanticsPackage.eINSTANCE);
		QvtBasePackageImpl theQvtBasePackage = (QvtBasePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(QvtBasePackage.eNS_URI) instanceof QvtBasePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(QvtBasePackage.eNS_URI) : QvtBasePackage.eINSTANCE);
		QvtTemplatePackageImpl theQvtTemplatePackage = (QvtTemplatePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(QvtTemplatePackage.eNS_URI) instanceof QvtTemplatePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(QvtTemplatePackage.eNS_URI) : QvtTemplatePackage.eINSTANCE);
		QvtPackageImpl theQvtPackage = (QvtPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(QvtPackage.eNS_URI) instanceof QvtPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(QvtPackage.eNS_URI) : QvtPackage.eINSTANCE);

		// Create package meta-data objects
		theQvtRelationPackage.createPackageContents();
		theSemanticsPackage_1.createPackageContents();
		theQvtBasePackage.createPackageContents();
		theQvtTemplatePackage.createPackageContents();
		theQvtPackage.createPackageContents();

		// Initialize created meta-data
		theQvtRelationPackage.initializePackageContents();
		theSemanticsPackage_1.initializePackageContents();
		theQvtBasePackage.initializePackageContents();
		theQvtTemplatePackage.initializePackageContents();
		theQvtPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theQvtRelationPackage.freeze();

		return theQvtRelationPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDomainPattern() {
		return domainPatternEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDomainPattern_TemplateExpression() {
		return (EReference)domainPatternEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getKey() {
		return keyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getKey_Identifies() {
		return (EReference)keyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getKey_Transformation() {
		return (EReference)keyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getKey_Part() {
		return (EReference)keyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRelation() {
		return relationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRelation_IsTopLevel() {
		return (EAttribute)relationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRelation_Where() {
		return (EReference)relationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRelation_Variable() {
		return (EReference)relationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRelation_OperationalImpl() {
		return (EReference)relationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRelation_When() {
		return (EReference)relationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRelationCallExp() {
		return relationCallExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRelationCallExp_ReferredRelation() {
		return (EReference)relationCallExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRelationCallExp_Argument() {
		return (EReference)relationCallExpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRelationDomain() {
		return relationDomainEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRelationDomain_RootVariable() {
		return (EReference)relationDomainEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRelationDomain_Pattern() {
		return (EReference)relationDomainEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRelationImplementation() {
		return relationImplementationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRelationImplementation_Relation() {
		return (EReference)relationImplementationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRelationImplementation_Impl() {
		return (EReference)relationImplementationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRelationImplementation_InDirectionOf() {
		return (EReference)relationImplementationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRelationalTransformation() {
		return relationalTransformationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRelationalTransformation_OwnedKey() {
		return (EReference)relationalTransformationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QvtRelationFactory getQvtRelationFactory() {
		return (QvtRelationFactory)getEFactoryInstance();
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
		domainPatternEClass = createEClass(DOMAIN_PATTERN);
		createEReference(domainPatternEClass, DOMAIN_PATTERN__TEMPLATE_EXPRESSION);

		keyEClass = createEClass(KEY);
		createEReference(keyEClass, KEY__IDENTIFIES);
		createEReference(keyEClass, KEY__TRANSFORMATION);
		createEReference(keyEClass, KEY__PART);

		relationEClass = createEClass(RELATION);
		createEAttribute(relationEClass, RELATION__IS_TOP_LEVEL);
		createEReference(relationEClass, RELATION__WHERE);
		createEReference(relationEClass, RELATION__VARIABLE);
		createEReference(relationEClass, RELATION__OPERATIONAL_IMPL);
		createEReference(relationEClass, RELATION__WHEN);

		relationCallExpEClass = createEClass(RELATION_CALL_EXP);
		createEReference(relationCallExpEClass, RELATION_CALL_EXP__REFERRED_RELATION);
		createEReference(relationCallExpEClass, RELATION_CALL_EXP__ARGUMENT);

		relationDomainEClass = createEClass(RELATION_DOMAIN);
		createEReference(relationDomainEClass, RELATION_DOMAIN__ROOT_VARIABLE);
		createEReference(relationDomainEClass, RELATION_DOMAIN__PATTERN);

		relationImplementationEClass = createEClass(RELATION_IMPLEMENTATION);
		createEReference(relationImplementationEClass, RELATION_IMPLEMENTATION__RELATION);
		createEReference(relationImplementationEClass, RELATION_IMPLEMENTATION__IMPL);
		createEReference(relationImplementationEClass, RELATION_IMPLEMENTATION__IN_DIRECTION_OF);

		relationalTransformationEClass = createEClass(RELATIONAL_TRANSFORMATION);
		createEReference(relationalTransformationEClass, RELATIONAL_TRANSFORMATION__OWNED_KEY);
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
		QvtBasePackage theQvtBasePackage = (QvtBasePackage)EPackage.Registry.INSTANCE.getEPackage(QvtBasePackage.eNS_URI);
		QvtTemplatePackage theQvtTemplatePackage = (QvtTemplatePackage)EPackage.Registry.INSTANCE.getEPackage(QvtTemplatePackage.eNS_URI);
		SemanticsPackage theSemanticsPackage_1 = (SemanticsPackage)EPackage.Registry.INSTANCE.getEPackage(SemanticsPackage.eNS_URI);
		SemanticsPackage theSemanticsPackage = (SemanticsPackage)EPackage.Registry.INSTANCE.getEPackage(SemanticsPackage.eNS_URI);
		BridgePackage theBridgePackage = (BridgePackage)EPackage.Registry.INSTANCE.getEPackage(BridgePackage.eNS_URI);
		ExpressionsPackage theExpressionsPackage = (ExpressionsPackage)EPackage.Registry.INSTANCE.getEPackage(ExpressionsPackage.eNS_URI);

		// Add supertypes to classes
		domainPatternEClass.getESuperTypes().add(theQvtBasePackage.getPattern());
		keyEClass.getESuperTypes().add(theBridgePackage.getElement());
		relationEClass.getESuperTypes().add(theQvtBasePackage.getRule());
		relationCallExpEClass.getESuperTypes().add(theExpressionsPackage.getOclExpression());
		relationDomainEClass.getESuperTypes().add(theQvtBasePackage.getDomain());
		relationImplementationEClass.getESuperTypes().add(theBridgePackage.getElement());
		relationalTransformationEClass.getESuperTypes().add(theQvtBasePackage.getTransformation());

		// Initialize classes and features; add operations and parameters
		initEClass(domainPatternEClass, DomainPattern.class, "DomainPattern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDomainPattern_TemplateExpression(), theQvtTemplatePackage.getTemplateExp(), null, "templateExpression", null, 0, 1, DomainPattern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(domainPatternEClass, theSemanticsPackage_1.getObject(), "accept", 0, 1);
		addEParameter(op, theSemanticsPackage.getOclVisitor(), "visitor", 0, 1);
		addEParameter(op, theSemanticsPackage_1.getObject(), "data", 0, 1);

		initEClass(keyEClass, Key.class, "Key", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getKey_Identifies(), theBridgePackage.getClassifier(), null, "identifies", null, 1, 1, Key.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getKey_Transformation(), this.getRelationalTransformation(), this.getRelationalTransformation_OwnedKey(), "transformation", null, 0, 1, Key.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getKey_Part(), theBridgePackage.getProperty(), null, "part", null, 1, -1, Key.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(keyEClass, theSemanticsPackage_1.getObject(), "accept", 0, 1);
		addEParameter(op, theSemanticsPackage.getOclVisitor(), "visitor", 0, 1);
		addEParameter(op, theSemanticsPackage_1.getObject(), "data", 0, 1);

		initEClass(relationEClass, Relation.class, "Relation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRelation_IsTopLevel(), ecorePackage.getEBoolean(), "isTopLevel", null, 1, 1, Relation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelation_Where(), theQvtBasePackage.getPattern(), theQvtBasePackage.getPattern_WhereOwner(), "where", null, 0, 1, Relation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelation_Variable(), theExpressionsPackage.getVariableDeclaration(), null, "variable", null, 0, -1, Relation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelation_OperationalImpl(), this.getRelationImplementation(), this.getRelationImplementation_Relation(), "operationalImpl", null, 0, -1, Relation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelation_When(), theQvtBasePackage.getPattern(), theQvtBasePackage.getPattern_WhenOwner(), "when", null, 0, 1, Relation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(relationEClass, theSemanticsPackage_1.getObject(), "accept", 0, 1);
		addEParameter(op, theSemanticsPackage.getOclVisitor(), "visitor", 0, 1);
		addEParameter(op, theSemanticsPackage_1.getObject(), "data", 0, 1);

		initEClass(relationCallExpEClass, RelationCallExp.class, "RelationCallExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRelationCallExp_ReferredRelation(), this.getRelation(), null, "referredRelation", null, 0, 1, RelationCallExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelationCallExp_Argument(), theExpressionsPackage.getOclExpression(), null, "argument", null, 0, -1, RelationCallExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(relationCallExpEClass, theSemanticsPackage_1.getObject(), "accept", 0, 1);
		addEParameter(op, theSemanticsPackage.getOclVisitor(), "visitor", 0, 1);
		addEParameter(op, theSemanticsPackage_1.getObject(), "data", 0, 1);

		initEClass(relationDomainEClass, RelationDomain.class, "RelationDomain", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRelationDomain_RootVariable(), theExpressionsPackage.getVariableDeclaration(), null, "rootVariable", null, 1, 1, RelationDomain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelationDomain_Pattern(), this.getDomainPattern(), null, "pattern", null, 0, 1, RelationDomain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(relationDomainEClass, theSemanticsPackage_1.getObject(), "accept", 0, 1);
		addEParameter(op, theSemanticsPackage.getOclVisitor(), "visitor", 0, 1);
		addEParameter(op, theSemanticsPackage_1.getObject(), "data", 0, 1);

		initEClass(relationImplementationEClass, RelationImplementation.class, "RelationImplementation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRelationImplementation_Relation(), this.getRelation(), this.getRelation_OperationalImpl(), "relation", null, 0, 1, RelationImplementation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelationImplementation_Impl(), theBridgePackage.getOperation(), null, "impl", null, 1, 1, RelationImplementation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelationImplementation_InDirectionOf(), theQvtBasePackage.getTypedModel(), null, "inDirectionOf", null, 1, 1, RelationImplementation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(relationImplementationEClass, theSemanticsPackage_1.getObject(), "accept", 0, 1);
		addEParameter(op, theSemanticsPackage.getOclVisitor(), "visitor", 0, 1);
		addEParameter(op, theSemanticsPackage_1.getObject(), "data", 0, 1);

		initEClass(relationalTransformationEClass, RelationalTransformation.class, "RelationalTransformation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRelationalTransformation_OwnedKey(), this.getKey(), this.getKey_Transformation(), "ownedKey", null, 0, -1, RelationalTransformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(relationalTransformationEClass, theSemanticsPackage_1.getObject(), "accept", 0, 1);
		addEParameter(op, theSemanticsPackage.getOclVisitor(), "visitor", 0, 1);
		addEParameter(op, theSemanticsPackage_1.getObject(), "data", 0, 1);
	}

} //QvtRelationPackageImpl
