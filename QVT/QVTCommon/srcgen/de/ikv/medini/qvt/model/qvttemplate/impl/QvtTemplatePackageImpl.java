/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ikv.medini.qvt.model.qvttemplate.impl;

import de.ikv.medini.qvt.model.qvtbase.QvtBasePackage;

import de.ikv.medini.qvt.model.qvtbase.impl.QvtBasePackageImpl;

import de.ikv.medini.qvt.model.qvtrelation.QvtRelationPackage;

import de.ikv.medini.qvt.model.qvtrelation.impl.QvtRelationPackageImpl;

import de.ikv.medini.qvt.model.qvttemplate.ColletionTemplateExp;
import de.ikv.medini.qvt.model.qvttemplate.ObjectTemplateExp;
import de.ikv.medini.qvt.model.qvttemplate.PropertyTemplateItem;
import de.ikv.medini.qvt.model.qvttemplate.QvtTemplateFactory;
import de.ikv.medini.qvt.model.qvttemplate.QvtTemplatePackage;
import de.ikv.medini.qvt.model.qvttemplate.TemplateExp;

import de.ikv.medini.qvt.qvt.QvtPackage;

import de.ikv.medini.qvt.qvt.impl.QvtPackageImpl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.oslo.ocl20.semantics.SemanticsPackage;

import org.oslo.ocl20.semantics.bridge.BridgePackage;

import org.oslo.ocl20.semantics.impl.SemanticsPackageImpl;

import org.oslo.ocl20.semantics.model.expressions.ExpressionsPackage;

import org.oslo.ocl20.semantics.model.types.TypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class QvtTemplatePackageImpl extends EPackageImpl implements QvtTemplatePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass colletionTemplateExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass objectTemplateExpEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyTemplateItemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass templateExpEClass = null;

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
	 * @see de.ikv.medini.qvt.model.qvttemplate.QvtTemplatePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private QvtTemplatePackageImpl() {
		super(eNS_URI, QvtTemplateFactory.eINSTANCE);
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
	public static QvtTemplatePackage init() {
		if (isInited) return (QvtTemplatePackage)EPackage.Registry.INSTANCE.getEPackage(QvtTemplatePackage.eNS_URI);

		// Obtain or create and register package
		QvtTemplatePackageImpl theQvtTemplatePackage = (QvtTemplatePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof QvtTemplatePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new QvtTemplatePackageImpl());

		isInited = true;

		// Initialize simple dependencies
		SemanticsPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		SemanticsPackageImpl theSemanticsPackage_1 = (SemanticsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SemanticsPackage.eNS_URI) instanceof SemanticsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SemanticsPackage.eNS_URI) : SemanticsPackage.eINSTANCE);
		QvtBasePackageImpl theQvtBasePackage = (QvtBasePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(QvtBasePackage.eNS_URI) instanceof QvtBasePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(QvtBasePackage.eNS_URI) : QvtBasePackage.eINSTANCE);
		QvtRelationPackageImpl theQvtRelationPackage = (QvtRelationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(QvtRelationPackage.eNS_URI) instanceof QvtRelationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(QvtRelationPackage.eNS_URI) : QvtRelationPackage.eINSTANCE);
		QvtPackageImpl theQvtPackage = (QvtPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(QvtPackage.eNS_URI) instanceof QvtPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(QvtPackage.eNS_URI) : QvtPackage.eINSTANCE);

		// Create package meta-data objects
		theQvtTemplatePackage.createPackageContents();
		theSemanticsPackage_1.createPackageContents();
		theQvtBasePackage.createPackageContents();
		theQvtRelationPackage.createPackageContents();
		theQvtPackage.createPackageContents();

		// Initialize created meta-data
		theQvtTemplatePackage.initializePackageContents();
		theSemanticsPackage_1.initializePackageContents();
		theQvtBasePackage.initializePackageContents();
		theQvtRelationPackage.initializePackageContents();
		theQvtPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theQvtTemplatePackage.freeze();

		return theQvtTemplatePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getColletionTemplateExp() {
		return colletionTemplateExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getColletionTemplateExp_Match() {
		return (EReference)colletionTemplateExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getColletionTemplateExp_Part() {
		return (EReference)colletionTemplateExpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getColletionTemplateExp_RefferedCollectionType() {
		return (EReference)colletionTemplateExpEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getObjectTemplateExp() {
		return objectTemplateExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getObjectTemplateExp_RefferedClass() {
		return (EReference)objectTemplateExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getObjectTemplateExp_Part() {
		return (EReference)objectTemplateExpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPropertyTemplateItem() {
		return propertyTemplateItemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertyTemplateItem_Value() {
		return (EReference)propertyTemplateItemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertyTemplateItem_ReferredProperty() {
		return (EReference)propertyTemplateItemEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertyTemplateItem_ObjContainer() {
		return (EReference)propertyTemplateItemEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTemplateExp() {
		return templateExpEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTemplateExp_BindsTo() {
		return (EReference)templateExpEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTemplateExp_Where() {
		return (EReference)templateExpEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QvtTemplateFactory getQvtTemplateFactory() {
		return (QvtTemplateFactory)getEFactoryInstance();
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
		colletionTemplateExpEClass = createEClass(COLLETION_TEMPLATE_EXP);
		createEReference(colletionTemplateExpEClass, COLLETION_TEMPLATE_EXP__MATCH);
		createEReference(colletionTemplateExpEClass, COLLETION_TEMPLATE_EXP__PART);
		createEReference(colletionTemplateExpEClass, COLLETION_TEMPLATE_EXP__REFFERED_COLLECTION_TYPE);

		objectTemplateExpEClass = createEClass(OBJECT_TEMPLATE_EXP);
		createEReference(objectTemplateExpEClass, OBJECT_TEMPLATE_EXP__REFFERED_CLASS);
		createEReference(objectTemplateExpEClass, OBJECT_TEMPLATE_EXP__PART);

		propertyTemplateItemEClass = createEClass(PROPERTY_TEMPLATE_ITEM);
		createEReference(propertyTemplateItemEClass, PROPERTY_TEMPLATE_ITEM__VALUE);
		createEReference(propertyTemplateItemEClass, PROPERTY_TEMPLATE_ITEM__REFERRED_PROPERTY);
		createEReference(propertyTemplateItemEClass, PROPERTY_TEMPLATE_ITEM__OBJ_CONTAINER);

		templateExpEClass = createEClass(TEMPLATE_EXP);
		createEReference(templateExpEClass, TEMPLATE_EXP__BINDS_TO);
		createEReference(templateExpEClass, TEMPLATE_EXP__WHERE);
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
		ExpressionsPackage theExpressionsPackage = (ExpressionsPackage)EPackage.Registry.INSTANCE.getEPackage(ExpressionsPackage.eNS_URI);
		TypesPackage theTypesPackage = (TypesPackage)EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);
		BridgePackage theBridgePackage = (BridgePackage)EPackage.Registry.INSTANCE.getEPackage(BridgePackage.eNS_URI);
		SemanticsPackage theSemanticsPackage_1 = (SemanticsPackage)EPackage.Registry.INSTANCE.getEPackage(SemanticsPackage.eNS_URI);
		SemanticsPackage theSemanticsPackage = (SemanticsPackage)EPackage.Registry.INSTANCE.getEPackage(SemanticsPackage.eNS_URI);

		// Add supertypes to classes
		colletionTemplateExpEClass.getESuperTypes().add(this.getTemplateExp());
		objectTemplateExpEClass.getESuperTypes().add(this.getTemplateExp());
		propertyTemplateItemEClass.getESuperTypes().add(theBridgePackage.getElement());
		templateExpEClass.getESuperTypes().add(theExpressionsPackage.getLiteralExp());

		// Initialize classes and features; add operations and parameters
		initEClass(colletionTemplateExpEClass, ColletionTemplateExp.class, "ColletionTemplateExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getColletionTemplateExp_Match(), theExpressionsPackage.getOclExpression(), null, "match", null, 0, 1, ColletionTemplateExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getColletionTemplateExp_Part(), theExpressionsPackage.getOclExpression(), null, "part", null, 0, -1, ColletionTemplateExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getColletionTemplateExp_RefferedCollectionType(), theTypesPackage.getCollectionType(), null, "refferedCollectionType", null, 0, 1, ColletionTemplateExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(objectTemplateExpEClass, ObjectTemplateExp.class, "ObjectTemplateExp", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getObjectTemplateExp_RefferedClass(), theBridgePackage.getClassifier(), null, "refferedClass", null, 1, 1, ObjectTemplateExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getObjectTemplateExp_Part(), this.getPropertyTemplateItem(), this.getPropertyTemplateItem_ObjContainer(), "part", null, 0, -1, ObjectTemplateExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(objectTemplateExpEClass, theSemanticsPackage_1.getObject(), "accept", 0, 1);
		addEParameter(op, theSemanticsPackage.getOclVisitor(), "visitor", 0, 1);
		addEParameter(op, theSemanticsPackage_1.getObject(), "data", 0, 1);

		initEClass(propertyTemplateItemEClass, PropertyTemplateItem.class, "PropertyTemplateItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPropertyTemplateItem_Value(), theExpressionsPackage.getOclExpression(), null, "value", null, 1, 1, PropertyTemplateItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPropertyTemplateItem_ReferredProperty(), theBridgePackage.getProperty(), null, "referredProperty", null, 1, 1, PropertyTemplateItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPropertyTemplateItem_ObjContainer(), this.getObjectTemplateExp(), this.getObjectTemplateExp_Part(), "objContainer", null, 1, 1, PropertyTemplateItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(propertyTemplateItemEClass, theSemanticsPackage_1.getObject(), "accept", 0, 1);
		addEParameter(op, theSemanticsPackage.getOclVisitor(), "visitor", 0, 1);
		addEParameter(op, theSemanticsPackage_1.getObject(), "data", 0, 1);

		initEClass(templateExpEClass, TemplateExp.class, "TemplateExp", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTemplateExp_BindsTo(), theExpressionsPackage.getVariableDeclaration(), null, "bindsTo", null, 0, 1, TemplateExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTemplateExp_Where(), theExpressionsPackage.getOclExpression(), null, "where", null, 0, 1, TemplateExp.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
	}

} //QvtTemplatePackageImpl
