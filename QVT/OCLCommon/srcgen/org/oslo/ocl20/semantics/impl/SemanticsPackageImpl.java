/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.semantics.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.oslo.ocl20.OclProcessor;

import org.oslo.ocl20.semantics.OclVisitor;
import org.oslo.ocl20.semantics.SemanticsFactory;
import org.oslo.ocl20.semantics.SemanticsPackage;
import org.oslo.ocl20.semantics.SemanticsVisitable;
import org.oslo.ocl20.semantics.SemanticsVisitor;

import org.oslo.ocl20.semantics.bridge.BridgePackage;

import org.oslo.ocl20.semantics.bridge.impl.BridgePackageImpl;

import org.oslo.ocl20.semantics.factories.BridgeFactory;
import org.oslo.ocl20.semantics.factories.TypeFactory;

import org.oslo.ocl20.semantics.model.contexts.ContextsPackage;

import org.oslo.ocl20.semantics.model.contexts.impl.ContextsPackageImpl;

import org.oslo.ocl20.semantics.model.expressions.ExpressionsPackage;

import org.oslo.ocl20.semantics.model.expressions.impl.ExpressionsPackageImpl;

import org.oslo.ocl20.semantics.model.types.TypesPackage;

import org.oslo.ocl20.semantics.model.types.impl.TypesPackageImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class SemanticsPackageImpl extends EPackageImpl implements SemanticsPackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass semanticsVisitableEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass semanticsVisitorEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass oclVisitorEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EDataType booleanEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EDataType bridgeFactoryEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EDataType classEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EDataType integerEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EDataType listEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EDataType mapEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EDataType objectEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EDataType oclProcessorEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EDataType realEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EDataType setEDataType = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EDataType typeFactoryEDataType = null;

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
	 * @see org.oslo.ocl20.semantics.SemanticsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SemanticsPackageImpl() {
		super(eNS_URI, SemanticsFactory.eINSTANCE);
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
	public static SemanticsPackage init() {
		if (isInited)
			return (SemanticsPackage) EPackage.Registry.INSTANCE.getEPackage(SemanticsPackage.eNS_URI);

		// Obtain or create and register package
		SemanticsPackageImpl theSemanticsPackage = (SemanticsPackageImpl) (EPackage.Registry.INSTANCE
		        .getEPackage(eNS_URI) instanceof SemanticsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI)
		        : new SemanticsPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		BridgePackageImpl theBridgePackage = (BridgePackageImpl) (EPackage.Registry.INSTANCE
		        .getEPackage(BridgePackage.eNS_URI) instanceof BridgePackageImpl ? EPackage.Registry.INSTANCE
		        .getEPackage(BridgePackage.eNS_URI) : BridgePackage.eINSTANCE);
		ContextsPackageImpl theContextsPackage = (ContextsPackageImpl) (EPackage.Registry.INSTANCE
		        .getEPackage(ContextsPackage.eNS_URI) instanceof ContextsPackageImpl ? EPackage.Registry.INSTANCE
		        .getEPackage(ContextsPackage.eNS_URI) : ContextsPackage.eINSTANCE);
		ExpressionsPackageImpl theExpressionsPackage = (ExpressionsPackageImpl) (EPackage.Registry.INSTANCE
		        .getEPackage(ExpressionsPackage.eNS_URI) instanceof ExpressionsPackageImpl ? EPackage.Registry.INSTANCE
		        .getEPackage(ExpressionsPackage.eNS_URI) : ExpressionsPackage.eINSTANCE);
		TypesPackageImpl theTypesPackage = (TypesPackageImpl) (EPackage.Registry.INSTANCE
		        .getEPackage(TypesPackage.eNS_URI) instanceof TypesPackageImpl ? EPackage.Registry.INSTANCE
		        .getEPackage(TypesPackage.eNS_URI) : TypesPackage.eINSTANCE);

		// Create package meta-data objects
		theSemanticsPackage.createPackageContents();
		theBridgePackage.createPackageContents();
		theContextsPackage.createPackageContents();
		theExpressionsPackage.createPackageContents();
		theTypesPackage.createPackageContents();

		// Initialize created meta-data
		theSemanticsPackage.initializePackageContents();
		theBridgePackage.initializePackageContents();
		theContextsPackage.initializePackageContents();
		theExpressionsPackage.initializePackageContents();
		theTypesPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSemanticsPackage.freeze();

		return theSemanticsPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getSemanticsVisitable() {
		return semanticsVisitableEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getSemanticsVisitor() {
		return semanticsVisitorEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getOclVisitor() {
		return oclVisitorEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EDataType getBoolean() {
		return booleanEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EDataType getBridgeFactory() {
		return bridgeFactoryEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EDataType getClass_() {
		return classEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EDataType getInteger() {
		return integerEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EDataType getList() {
		return listEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EDataType getMap() {
		return mapEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EDataType getObject() {
		return objectEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EDataType getOclProcessor() {
		return oclProcessorEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EDataType getReal() {
		return realEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EDataType getSet() {
		return setEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EDataType getTypeFactory() {
		return typeFactoryEDataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public SemanticsFactory getSemanticsFactory() {
		return (SemanticsFactory) getEFactoryInstance();
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
		semanticsVisitableEClass = createEClass(SEMANTICS_VISITABLE);

		semanticsVisitorEClass = createEClass(SEMANTICS_VISITOR);

		oclVisitorEClass = createEClass(OCL_VISITOR);

		// Create data types
		booleanEDataType = createEDataType(BOOLEAN);
		bridgeFactoryEDataType = createEDataType(BRIDGE_FACTORY);
		classEDataType = createEDataType(CLASS);
		integerEDataType = createEDataType(INTEGER);
		listEDataType = createEDataType(LIST);
		mapEDataType = createEDataType(MAP);
		objectEDataType = createEDataType(OBJECT);
		oclProcessorEDataType = createEDataType(OCL_PROCESSOR);
		realEDataType = createEDataType(REAL);
		setEDataType = createEDataType(SET);
		typeFactoryEDataType = createEDataType(TYPE_FACTORY);
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
		ContextsPackage theContextsPackage = (ContextsPackage) EPackage.Registry.INSTANCE
		        .getEPackage(ContextsPackage.eNS_URI);
		ExpressionsPackage theExpressionsPackage = (ExpressionsPackage) EPackage.Registry.INSTANCE
		        .getEPackage(ExpressionsPackage.eNS_URI);
		TypesPackage theTypesPackage = (TypesPackage) EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theBridgePackage);
		getESubpackages().add(theContextsPackage);
		getESubpackages().add(theExpressionsPackage);
		getESubpackages().add(theTypesPackage);

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(semanticsVisitableEClass, SemanticsVisitable.class, "SemanticsVisitable", !IS_ABSTRACT,
		    !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		EOperation op = addEOperation(semanticsVisitableEClass, this.getObject(), "accept", 0, 1);
		addEParameter(op, this.getOclVisitor(), "visitor", 0, 1);
		addEParameter(op, this.getObject(), "data", 0, 1);

		initEClass(semanticsVisitorEClass, SemanticsVisitor.class, "SemanticsVisitor", !IS_ABSTRACT, !IS_INTERFACE,
		    IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(semanticsVisitorEClass, this.getObject(), "visit", 0, 1);
		addEParameter(op, this.getSemanticsVisitable(), "visitable", 0, 1);
		addEParameter(op, this.getObject(), "data", 0, 1);

		initEClass(oclVisitorEClass, OclVisitor.class, "OclVisitor", IS_ABSTRACT, !IS_INTERFACE,
		    IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(oclVisitorEClass, this.getObject(), "visit", 0, 1);
		addEParameter(op, theBridgePackage.getTag(), "host", 0, 1);
		addEParameter(op, this.getObject(), "data", 0, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(oclVisitorEClass, this.getObject(), "visit", 0, 1);
		addEParameter(op, theContextsPackage.getConstraint(), "host", 0, 1);
		addEParameter(op, this.getObject(), "data", 0, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(oclVisitorEClass, this.getObject(), "visit", 0, 1);
		addEParameter(op, theExpressionsPackage.getVariableDeclaration(), "host", 0, 1);
		addEParameter(op, this.getObject(), "data", 0, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(oclVisitorEClass, this.getObject(), "visit", 0, 1);
		addEParameter(op, theExpressionsPackage.getBooleanLiteralExp(), "host", 0, 1);
		addEParameter(op, this.getObject(), "data", 0, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(oclVisitorEClass, this.getObject(), "visit", 0, 1);
		addEParameter(op, theExpressionsPackage.getUndefinedLiteralExp(), "host", 0, 1);
		addEParameter(op, this.getObject(), "data", 0, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(oclVisitorEClass, this.getObject(), "visit", 0, 1);
		addEParameter(op, theExpressionsPackage.getTypeLiteralExp(), "host", 0, 1);
		addEParameter(op, this.getObject(), "data", 0, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(oclVisitorEClass, this.getObject(), "visit", 0, 1);
		addEParameter(op, theExpressionsPackage.getIntegerLiteralExp(), "host", 0, 1);
		addEParameter(op, this.getObject(), "data", 0, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(oclVisitorEClass, this.getObject(), "visit", 0, 1);
		addEParameter(op, theExpressionsPackage.getRealLiteralExp(), "host", 0, 1);
		addEParameter(op, this.getObject(), "data", 0, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(oclVisitorEClass, this.getObject(), "visit", 0, 1);
		addEParameter(op, theExpressionsPackage.getStringLiteralExp(), "host", 0, 1);
		addEParameter(op, this.getObject(), "data", 0, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(oclVisitorEClass, this.getObject(), "visit", 0, 1);
		addEParameter(op, theExpressionsPackage.getEnumLiteralExp(), "host", 0, 1);
		addEParameter(op, this.getObject(), "data", 0, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(oclVisitorEClass, this.getObject(), "visit", 0, 1);
		addEParameter(op, theExpressionsPackage.getCollectionLiteralExp(), "host", 0, 1);
		addEParameter(op, this.getObject(), "data", 0, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(oclVisitorEClass, this.getObject(), "visit", 0, 1);
		addEParameter(op, theExpressionsPackage.getTupleLiteralExp(), "host", 0, 1);
		addEParameter(op, this.getObject(), "data", 0, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(oclVisitorEClass, this.getObject(), "visit", 0, 1);
		addEParameter(op, theExpressionsPackage.getOperationCallExp(), "host", 0, 1);
		addEParameter(op, this.getObject(), "data", 0, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(oclVisitorEClass, this.getObject(), "visit", 0, 1);
		addEParameter(op, theExpressionsPackage.getPropertyCallExp(), "host", 0, 1);
		addEParameter(op, this.getObject(), "data", 0, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(oclVisitorEClass, this.getObject(), "visit", 0, 1);
		addEParameter(op, theExpressionsPackage.getIteratorExp(), "host", 0, 1);
		addEParameter(op, this.getObject(), "data", 0, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(oclVisitorEClass, this.getObject(), "visit", 0, 1);
		addEParameter(op, theExpressionsPackage.getIterateExp(), "host", 0, 1);
		addEParameter(op, this.getObject(), "data", 0, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(oclVisitorEClass, this.getObject(), "visit", 0, 1);
		addEParameter(op, theExpressionsPackage.getVariableExp(), "host", 0, 1);
		addEParameter(op, this.getObject(), "data", 0, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(oclVisitorEClass, this.getObject(), "visit", 0, 1);
		addEParameter(op, theExpressionsPackage.getIfExp(), "host", 0, 1);
		addEParameter(op, this.getObject(), "data", 0, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(oclVisitorEClass, this.getObject(), "visit", 0, 1);
		addEParameter(op, theExpressionsPackage.getLetExp(), "host", 0, 1);
		addEParameter(op, this.getObject(), "data", 0, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(oclVisitorEClass, this.getObject(), "visit", 0, 1);
		addEParameter(op, theExpressionsPackage.getOclMessageExp(), "host", 0, 1);
		addEParameter(op, this.getObject(), "data", 0, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(oclVisitorEClass, this.getObject(), "visit", 0, 1);
		addEParameter(op, theExpressionsPackage.getOclMessageArg(), "host", 0, 1);
		addEParameter(op, this.getObject(), "data", 0, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(oclVisitorEClass, this.getObject(), "visit", 0, 1);
		addEParameter(op, theExpressionsPackage.getUnspecifiedValueExp(), "host", 0, 1);
		addEParameter(op, this.getObject(), "data", 0, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(oclVisitorEClass, this.getObject(), "visit", 0, 1);
		addEParameter(op, theTypesPackage.getOclAnyType(), "host", 0, 1);
		addEParameter(op, this.getObject(), "data", 0, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(oclVisitorEClass, this.getObject(), "visit", 0, 1);
		addEParameter(op, theBridgePackage.getDataType(), "host", 0, 1);
		addEParameter(op, this.getObject(), "data", 0, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(oclVisitorEClass, this.getObject(), "visit", 0, 1);
		addEParameter(op, theBridgePackage.getPrimitive(), "host", 0, 1);
		addEParameter(op, this.getObject(), "data", 0, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(oclVisitorEClass, this.getObject(), "visit", 0, 1);
		addEParameter(op, theTypesPackage.getBooleanType(), "host", 0, 1);
		addEParameter(op, this.getObject(), "data", 0, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(oclVisitorEClass, this.getObject(), "visit", 0, 1);
		addEParameter(op, theTypesPackage.getIntegerType(), "host", 0, 1);
		addEParameter(op, this.getObject(), "data", 0, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(oclVisitorEClass, this.getObject(), "visit", 0, 1);
		addEParameter(op, theTypesPackage.getRealType(), "host", 0, 1);
		addEParameter(op, this.getObject(), "data", 0, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(oclVisitorEClass, this.getObject(), "visit", 0, 1);
		addEParameter(op, theTypesPackage.getStringType(), "host", 0, 1);
		addEParameter(op, this.getObject(), "data", 0, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(oclVisitorEClass, this.getObject(), "visit", 0, 1);
		addEParameter(op, theTypesPackage.getTupleType(), "host", 0, 1);
		addEParameter(op, this.getObject(), "data", 0, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(oclVisitorEClass, this.getObject(), "visit", 0, 1);
		addEParameter(op, theTypesPackage.getCollectionType(), "host", 0, 1);
		addEParameter(op, this.getObject(), "data", 0, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(oclVisitorEClass, this.getObject(), "visit", 0, 1);
		addEParameter(op, theTypesPackage.getSequenceType(), "host", 0, 1);
		addEParameter(op, this.getObject(), "data", 0, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(oclVisitorEClass, this.getObject(), "visit", 0, 1);
		addEParameter(op, theTypesPackage.getOrderedSetType(), "host", 0, 1);
		addEParameter(op, this.getObject(), "data", 0, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(oclVisitorEClass, this.getObject(), "visit", 0, 1);
		addEParameter(op, theTypesPackage.getSetType(), "host", 0, 1);
		addEParameter(op, this.getObject(), "data", 0, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(oclVisitorEClass, this.getObject(), "visit", 0, 1);
		addEParameter(op, theTypesPackage.getBagType(), "host", 0, 1);
		addEParameter(op, this.getObject(), "data", 0, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(oclVisitorEClass, this.getObject(), "visit", 0, 1);
		addEParameter(op, theBridgePackage.getOclModelElementType(), "host", 0, 1);
		addEParameter(op, this.getObject(), "data", 0, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(oclVisitorEClass, this.getObject(), "visit", 0, 1);
		addEParameter(op, theTypesPackage.getOclMessageType(), "host", 0, 1);
		addEParameter(op, this.getObject(), "data", 0, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(oclVisitorEClass, this.getObject(), "visit", 0, 1);
		addEParameter(op, theTypesPackage.getVoidType(), "host", 0, 1);
		addEParameter(op, this.getObject(), "data", 0, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(oclVisitorEClass, this.getObject(), "visit", 0, 1);
		addEParameter(op, theBridgePackage.getProperty(), "host", 0, 1);
		addEParameter(op, this.getObject(), "data", 0, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(oclVisitorEClass, this.getObject(), "visit", 0, 1);
		addEParameter(op, theExpressionsPackage.getCollectionKind(), "host", 0, 1);
		addEParameter(op, this.getObject(), "data", 0, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(oclVisitorEClass, this.getObject(), "visit", 0, 1);
		addEParameter(op, theExpressionsPackage.getCollectionRange(), "host", 0, 1);
		addEParameter(op, this.getObject(), "data", 0, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(oclVisitorEClass, this.getObject(), "visit", 0, 1);
		addEParameter(op, theExpressionsPackage.getCollectionLiteralPart(), "host", 0, 1);
		addEParameter(op, this.getObject(), "data", 0, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(oclVisitorEClass, this.getObject(), "visit", 0, 1);
		addEParameter(op, theExpressionsPackage.getCollectionItem(), "host", 0, 1);
		addEParameter(op, this.getObject(), "data", 0, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(oclVisitorEClass, this.getObject(), "visit", 0, 1);
		addEParameter(op, theContextsPackage.getContextDeclaration(), "host", 0, 1);
		addEParameter(op, this.getObject(), "data", 0, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(oclVisitorEClass, this.getObject(), "visit", 0, 1);
		addEParameter(op, theContextsPackage.getOperationContextDecl(), "host", 0, 1);
		addEParameter(op, this.getObject(), "data", 0, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(oclVisitorEClass, this.getObject(), "visit", 0, 1);
		addEParameter(op, theContextsPackage.getPropertyContextDecl(), "host", 0, 1);
		addEParameter(op, this.getObject(), "data", 0, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(oclVisitorEClass, this.getObject(), "visit", 0, 1);
		addEParameter(op, theContextsPackage.getClassifierContextDecl(), "host", 0, 1);
		addEParameter(op, this.getObject(), "data", 0, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(oclVisitorEClass, this.getObject(), "visit", 0, 1);
		addEParameter(op, theBridgePackage.getSendAction(), "host", 0, 1);
		addEParameter(op, this.getObject(), "data", 0, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(oclVisitorEClass, this.getObject(), "visit", 0, 1);
		addEParameter(op, theBridgePackage.getEnumLiteral(), "host", 0, 1);
		addEParameter(op, this.getObject(), "data", 0, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(oclVisitorEClass, this.getObject(), "visit", 0, 1);
		addEParameter(op, theBridgePackage.getCallAction(), "host", 0, 1);
		addEParameter(op, this.getObject(), "data", 0, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(oclVisitorEClass, this.getObject(), "visit", 0, 1);
		addEParameter(op, theBridgePackage.getSignal(), "host", 0, 1);
		addEParameter(op, this.getObject(), "data", 0, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(oclVisitorEClass, this.getObject(), "visit", 0, 1);
		addEParameter(op, theBridgePackage.getNamespace(), "host", 0, 1);
		addEParameter(op, this.getObject(), "data", 0, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(oclVisitorEClass, this.getObject(), "visit", 0, 1);
		addEParameter(op, theBridgePackage.getEnvironment(), "host", 0, 1);
		addEParameter(op, this.getObject(), "data", 0, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(oclVisitorEClass, this.getObject(), "visit", 0, 1);
		addEParameter(op, theBridgePackage.getClassifier(), "host", 0, 1);
		addEParameter(op, this.getObject(), "data", 0, 1, IS_UNIQUE, !IS_ORDERED);

		op = addEOperation(oclVisitorEClass, this.getObject(), "visit", 0, 1);
		addEParameter(op, theBridgePackage.getEnumeration(), "host", 0, 1);
		addEParameter(op, this.getObject(), "data", 0, 1, IS_UNIQUE, !IS_ORDERED);

		// Initialize data types
		initEDataType(booleanEDataType, Boolean.class, "Boolean", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(bridgeFactoryEDataType, BridgeFactory.class, "BridgeFactory", !IS_SERIALIZABLE,
		    !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(classEDataType, Class.class, "Class", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(integerEDataType, Integer.class, "Integer", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(listEDataType, List.class, "List", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(mapEDataType, Map.class, "Map", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(objectEDataType, Object.class, "Object", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(oclProcessorEDataType, OclProcessor.class, "OclProcessor", !IS_SERIALIZABLE,
		    !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(realEDataType, Double.class, "Real", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(setEDataType, Set.class, "Set", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(typeFactoryEDataType, TypeFactory.class, "TypeFactory", !IS_SERIALIZABLE,
		    !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// instance
		createInstanceAnnotations();
		// body
		createBodyAnnotations();
	}

	/**
	 * Initializes the annotations for <b>instance</b>. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 */
	protected void createInstanceAnnotations() {
		String source = "instance";
		addAnnotation(booleanEDataType, source, new String[] { "instance", "java.lang.Boolean" });
		addAnnotation(bridgeFactoryEDataType, source, new String[] { "instance",
		        "org.oslo.ocl20.semantics.factories.BridgeFactory" });
		addAnnotation(classEDataType, source, new String[] { "instance", "java.lang.Class" });
		addAnnotation(integerEDataType, source, new String[] { "instance", "java.lang.Integer" });
		addAnnotation(listEDataType, source, new String[] { "instance", "java.util.List" });
		addAnnotation(mapEDataType, source, new String[] { "instance", "java.util.Map" });
		addAnnotation(oclProcessorEDataType, source, new String[] { "instance", "org.oslo.ocl20.OclProcessor" });
		addAnnotation(realEDataType, source, new String[] { "instance", "java.lang.Double" });
		addAnnotation(setEDataType, source, new String[] { "instance", "java.util.Set" });
		addAnnotation(typeFactoryEDataType, source, new String[] { "instance",
		        "org.oslo.ocl20.semantics.factories.TypeFactory" });
	}

	/**
	 * Initializes the annotations for <b>body</b>. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void createBodyAnnotations() {
		String source = "body";
		addAnnotation((EOperation) semanticsVisitableEClass.getEOperations().get(0), source, new String[] { "body",
		        "return ((OclVisitor)visitor).visit(this,data);" });
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected EParameter addEParameter(EOperation owner, EClassifier type, String name, int lowerBound, int upperBound,
	        boolean isUnique, boolean isOrdered) {
		EParameter p = ecoreFactory.createEParameter();
		p.setEType(type);
		p.setName(name);
		p.setLowerBound(lowerBound);
		p.setUpperBound(upperBound);
		p.setUnique(isUnique);
		p.setOrdered(isOrdered);
		owner.getEParameters().add(p);
		return p;
	}

} // SemanticsPackageImpl
