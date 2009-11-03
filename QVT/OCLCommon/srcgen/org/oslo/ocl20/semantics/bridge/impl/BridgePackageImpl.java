/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.semantics.bridge.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.oslo.ocl20.semantics.SemanticsPackage;

import org.oslo.ocl20.semantics.bridge.BridgeFactory;
import org.oslo.ocl20.semantics.bridge.BridgePackage;
import org.oslo.ocl20.semantics.bridge.CallAction;
import org.oslo.ocl20.semantics.bridge.Classifier;
import org.oslo.ocl20.semantics.bridge.DataType;
import org.oslo.ocl20.semantics.bridge.DefinedClass;
import org.oslo.ocl20.semantics.bridge.DefinedOperation;
import org.oslo.ocl20.semantics.bridge.DefinedPackage;
import org.oslo.ocl20.semantics.bridge.Element;
import org.oslo.ocl20.semantics.bridge.EnumLiteral;
import org.oslo.ocl20.semantics.bridge.Enumeration;
import org.oslo.ocl20.semantics.bridge.Environment;
import org.oslo.ocl20.semantics.bridge.ModelElement;
import org.oslo.ocl20.semantics.bridge.NamedElement;
import org.oslo.ocl20.semantics.bridge.Namespace;
import org.oslo.ocl20.semantics.bridge.OclModelElementType;
import org.oslo.ocl20.semantics.bridge.Operation;
import org.oslo.ocl20.semantics.bridge.Parameter;
import org.oslo.ocl20.semantics.bridge.Primitive;
import org.oslo.ocl20.semantics.bridge.Property;
import org.oslo.ocl20.semantics.bridge.SendAction;
import org.oslo.ocl20.semantics.bridge.Signal;
import org.oslo.ocl20.semantics.bridge.Tag;

import org.oslo.ocl20.semantics.impl.SemanticsPackageImpl;

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
public class BridgePackageImpl extends EPackageImpl implements BridgePackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass callActionEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass classifierEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass dataTypeEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass definedClassEClass = null;

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
	private EClass definedPackageEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass elementEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass enumLiteralEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass enumerationEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass environmentEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass modelElementEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass namedElementEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass namespaceEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass oclModelElementTypeEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass operationEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass parameterEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass primitiveEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass propertyEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass sendActionEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass signalEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass tagEClass = null;

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
	 * @see org.oslo.ocl20.semantics.bridge.BridgePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private BridgePackageImpl() {
		super(eNS_URI, BridgeFactory.eINSTANCE);
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
	public static BridgePackage init() {
		if (isInited)
			return (BridgePackage) EPackage.Registry.INSTANCE.getEPackage(BridgePackage.eNS_URI);

		// Obtain or create and register package
		BridgePackageImpl theBridgePackage = (BridgePackageImpl) (EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof BridgePackageImpl
		        ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new BridgePackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		SemanticsPackageImpl theSemanticsPackage = (SemanticsPackageImpl) (EPackage.Registry.INSTANCE
		        .getEPackage(SemanticsPackage.eNS_URI) instanceof SemanticsPackageImpl ? EPackage.Registry.INSTANCE
		        .getEPackage(SemanticsPackage.eNS_URI) : SemanticsPackage.eINSTANCE);
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
		theBridgePackage.createPackageContents();
		theSemanticsPackage.createPackageContents();
		theContextsPackage.createPackageContents();
		theExpressionsPackage.createPackageContents();
		theTypesPackage.createPackageContents();

		// Initialize created meta-data
		theBridgePackage.initializePackageContents();
		theSemanticsPackage.initializePackageContents();
		theContextsPackage.initializePackageContents();
		theExpressionsPackage.initializePackageContents();
		theTypesPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theBridgePackage.freeze();

		return theBridgePackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getCallAction() {
		return callActionEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getCallAction_Operation() {
		return (EReference) callActionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getClassifier() {
		return classifierEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getClassifier_Operations() {
		return (EAttribute) classifierEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getClassifier_Processor() {
		return (EAttribute) classifierEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getClassifier_Properties() {
		return (EReference) classifierEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getDataType() {
		return dataTypeEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getDefinedClass() {
		return definedClassEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getDefinedClass_OwnedOperation() {
		return (EReference) definedClassEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getDefinedClass_Package() {
		return (EReference) definedClassEClass.getEStructuralFeatures().get(1);
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
	public EReference getDefinedOperation_Class() {
		return (EReference) definedOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getDefinedOperation_RaisedException() {
		return (EReference) definedOperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getDefinedPackage() {
		return definedPackageEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getDefinedPackage_OwnedType() {
		return (EReference) definedPackageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getElement() {
		return elementEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getElement_Tag() {
		return (EReference) elementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getEnumLiteral() {
		return enumLiteralEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getEnumLiteral_Enumeration() {
		return (EReference) enumLiteralEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getEnumeration() {
		return enumerationEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getEnumeration_Literal() {
		return (EReference) enumerationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getEnvironment() {
		return environmentEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getEnvironment_BridgeFactory() {
		return (EAttribute) environmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getEnvironment_NamedElementEntrys() {
		return (EAttribute) environmentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getEnvironment_Namespaces() {
		return (EReference) environmentEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getEnvironment_Parent() {
		return (EReference) environmentEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getModelElement() {
		return modelElementEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getModelElement_Name() {
		return (EAttribute) modelElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getNamedElement() {
		return namedElementEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getNamedElement_MayBeImplicit() {
		return (EAttribute) namedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getNamedElement_Name() {
		return (EAttribute) namedElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getNamedElement_ReferredElement() {
		return (EReference) namedElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getNamespace() {
		return namespaceEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getNamespace_Namespace() {
		return (EReference) namespaceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getOclModelElementType() {
		return oclModelElementTypeEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getOperation() {
		return operationEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getOperation_OwnedParameter() {
		return (EReference) operationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getOperation_ReturnType() {
		return (EReference) operationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getParameter() {
		return parameterEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getParameter_Type() {
		return (EReference) parameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getParameter_Operation() {
		return (EReference) parameterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getPrimitive() {
		return primitiveEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getProperty() {
		return propertyEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getProperty_Type() {
		return (EReference) propertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getSendAction() {
		return sendActionEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getSendAction_Signal() {
		return (EReference) sendActionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getSignal() {
		return signalEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getSignal_ParameterNames() {
		return (EAttribute) signalEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getSignal_ParameterTypes() {
		return (EReference) signalEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getTag() {
		return tagEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getTag_Name() {
		return (EAttribute) tagEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EAttribute getTag_Value() {
		return (EAttribute) tagEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getTag_Element() {
		return (EReference) tagEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public BridgeFactory getBridgeFactory() {
		return (BridgeFactory) getEFactoryInstance();
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
		callActionEClass = createEClass(CALL_ACTION);
		createEReference(callActionEClass, CALL_ACTION__OPERATION);

		classifierEClass = createEClass(CLASSIFIER);
		createEAttribute(classifierEClass, CLASSIFIER__OPERATIONS);
		createEAttribute(classifierEClass, CLASSIFIER__PROCESSOR);
		createEReference(classifierEClass, CLASSIFIER__PROPERTIES);

		dataTypeEClass = createEClass(DATA_TYPE);

		definedClassEClass = createEClass(DEFINED_CLASS);
		createEReference(definedClassEClass, DEFINED_CLASS__OWNED_OPERATION);
		createEReference(definedClassEClass, DEFINED_CLASS__PACKAGE);

		definedOperationEClass = createEClass(DEFINED_OPERATION);
		createEReference(definedOperationEClass, DEFINED_OPERATION__CLASS);
		createEReference(definedOperationEClass, DEFINED_OPERATION__RAISED_EXCEPTION);

		definedPackageEClass = createEClass(DEFINED_PACKAGE);
		createEReference(definedPackageEClass, DEFINED_PACKAGE__OWNED_TYPE);

		elementEClass = createEClass(ELEMENT);
		createEReference(elementEClass, ELEMENT__TAG);

		enumLiteralEClass = createEClass(ENUM_LITERAL);
		createEReference(enumLiteralEClass, ENUM_LITERAL__ENUMERATION);

		enumerationEClass = createEClass(ENUMERATION);
		createEReference(enumerationEClass, ENUMERATION__LITERAL);

		environmentEClass = createEClass(ENVIRONMENT);
		createEAttribute(environmentEClass, ENVIRONMENT__BRIDGE_FACTORY);
		createEAttribute(environmentEClass, ENVIRONMENT__NAMED_ELEMENT_ENTRYS);
		createEReference(environmentEClass, ENVIRONMENT__NAMESPACES);
		createEReference(environmentEClass, ENVIRONMENT__PARENT);

		modelElementEClass = createEClass(MODEL_ELEMENT);
		createEAttribute(modelElementEClass, MODEL_ELEMENT__NAME);

		namedElementEClass = createEClass(NAMED_ELEMENT);
		createEAttribute(namedElementEClass, NAMED_ELEMENT__MAY_BE_IMPLICIT);
		createEAttribute(namedElementEClass, NAMED_ELEMENT__NAME);
		createEReference(namedElementEClass, NAMED_ELEMENT__REFERRED_ELEMENT);

		namespaceEClass = createEClass(NAMESPACE);
		createEReference(namespaceEClass, NAMESPACE__NAMESPACE);

		oclModelElementTypeEClass = createEClass(OCL_MODEL_ELEMENT_TYPE);

		operationEClass = createEClass(OPERATION);
		createEReference(operationEClass, OPERATION__OWNED_PARAMETER);
		createEReference(operationEClass, OPERATION__RETURN_TYPE);

		parameterEClass = createEClass(PARAMETER);
		createEReference(parameterEClass, PARAMETER__TYPE);
		createEReference(parameterEClass, PARAMETER__OPERATION);

		primitiveEClass = createEClass(PRIMITIVE);

		propertyEClass = createEClass(PROPERTY);
		createEReference(propertyEClass, PROPERTY__TYPE);

		sendActionEClass = createEClass(SEND_ACTION);
		createEReference(sendActionEClass, SEND_ACTION__SIGNAL);

		signalEClass = createEClass(SIGNAL);
		createEAttribute(signalEClass, SIGNAL__PARAMETER_NAMES);
		createEReference(signalEClass, SIGNAL__PARAMETER_TYPES);

		tagEClass = createEClass(TAG);
		createEAttribute(tagEClass, TAG__NAME);
		createEAttribute(tagEClass, TAG__VALUE);
		createEReference(tagEClass, TAG__ELEMENT);
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
		SemanticsPackage theSemanticsPackage = (SemanticsPackage) EPackage.Registry.INSTANCE
		        .getEPackage(SemanticsPackage.eNS_URI);
		ExpressionsPackage theExpressionsPackage = (ExpressionsPackage) EPackage.Registry.INSTANCE
		        .getEPackage(ExpressionsPackage.eNS_URI);
		TypesPackage theTypesPackage = (TypesPackage) EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);

		// Add supertypes to classes
		callActionEClass.getESuperTypes().add(this.getModelElement());
		classifierEClass.getESuperTypes().add(this.getNamespace());
		dataTypeEClass.getESuperTypes().add(this.getClassifier());
		definedClassEClass.getESuperTypes().add(this.getClassifier());
		definedOperationEClass.getESuperTypes().add(this.getOperation());
		definedPackageEClass.getESuperTypes().add(this.getNamespace());
		elementEClass.getESuperTypes().add(theSemanticsPackage.getSemanticsVisitable());
		enumLiteralEClass.getESuperTypes().add(this.getProperty());
		enumLiteralEClass.getESuperTypes().add(this.getModelElement());
		enumerationEClass.getESuperTypes().add(this.getDataType());
		modelElementEClass.getESuperTypes().add(theSemanticsPackage.getSemanticsVisitable());
		modelElementEClass.getESuperTypes().add(this.getElement());
		namedElementEClass.getESuperTypes().add(this.getElement());
		namespaceEClass.getESuperTypes().add(this.getModelElement());
		oclModelElementTypeEClass.getESuperTypes().add(theTypesPackage.getOclAnyType());
		operationEClass.getESuperTypes().add(this.getModelElement());
		parameterEClass.getESuperTypes().add(this.getModelElement());
		primitiveEClass.getESuperTypes().add(theTypesPackage.getOclAnyType());
		propertyEClass.getESuperTypes().add(this.getModelElement());
		sendActionEClass.getESuperTypes().add(this.getModelElement());
		signalEClass.getESuperTypes().add(this.getModelElement());
		tagEClass.getESuperTypes().add(this.getElement());

		// Initialize classes and features; add operations and parameters
		initEClass(callActionEClass, CallAction.class, "CallAction", !IS_ABSTRACT, !IS_INTERFACE,
		    IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCallAction_Operation(), this.getOperation(), null, "operation", null, 1, 1, CallAction.class,
		    !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
		    !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(callActionEClass, theSemanticsPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theSemanticsPackage.getOclVisitor(), "visitor", 0, 1);
		addEParameter(op, theSemanticsPackage.getObject(), "data", 0, 1);

		initEClass(classifierEClass, Classifier.class, "Classifier", !IS_ABSTRACT, !IS_INTERFACE,
		    IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getClassifier_Operations(), theSemanticsPackage.getObject(), "operations", null, 0, -1,
		    Classifier.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
		    !IS_DERIVED, IS_ORDERED);
		initEAttribute(getClassifier_Processor(), theSemanticsPackage.getOclProcessor(), "processor", null, 1, 1,
		    Classifier.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
		    !IS_DERIVED, IS_ORDERED);
		initEReference(getClassifier_Properties(), this.getProperty(), null, "properties", null, 0, -1,
		    Classifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
		    !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(classifierEClass, this.getProperty(), "lookupProperty", 0, 1);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1);

		op = addEOperation(classifierEClass, this.getOperation(), "lookupOperation", 0, 1);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1);
		addEParameter(op, theSemanticsPackage.getList(), "types", 0, 1);

		op = addEOperation(classifierEClass, this.getSignal(), "lookupSignal", 0, 1);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1);
		addEParameter(op, theSemanticsPackage.getList(), "types", 0, 1);

		op = addEOperation(classifierEClass, theSemanticsPackage.getBoolean(), "conformsTo", 0, 1);
		addEParameter(op, this.getClassifier(), "c", 0, 1);

		addEOperation(classifierEClass, theSemanticsPackage.getObject(), "getDelegate", 0, 1);

		addEOperation(classifierEClass, theSemanticsPackage.getClass_(), "getImplClass", 0, 1);

		op = addEOperation(classifierEClass, this.getProperty(), "localLookupProperty", 0, 1);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1);

		addEOperation(classifierEClass, theSemanticsPackage.getList(), "getAllSuperTypes", 0, 1);

		op = addEOperation(classifierEClass, null, "createOperations");
		addEParameter(op, theSemanticsPackage.getTypeFactory(), "typeFactory", 0, 1);

		op = addEOperation(classifierEClass, null, "addProperty");
		addEParameter(op, this.getProperty(), "prop", 0, 1);

		op = addEOperation(classifierEClass, null, "addOperation");
		addEParameter(op, this.getOperation(), "operation", 0, 1);

		op = addEOperation(classifierEClass, this.getModelElement(), "lookupOwnedElement", 0, 1);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1);

		op = addEOperation(classifierEClass, this.getOperation(), "lookupCachedOp", 0, 1);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1);
		addEParameter(op, theSemanticsPackage.getList(), "types", 0, 1);

		addEOperation(classifierEClass, theSemanticsPackage.getList(), "getSuperTypes", 0, 1);

		op = addEOperation(classifierEClass, ecorePackage.getEBoolean(), "typesConform", 0, 1);
		addEParameter(op, theSemanticsPackage.getList(), "paramTypes", 0, 1);
		addEParameter(op, theSemanticsPackage.getList(), "argTypes", 0, 1);

		addEOperation(classifierEClass, this.getEnvironment(), "getEnvironmentWithoutParents", 0, 1);

		addEOperation(classifierEClass, this.getEnvironment(), "getEnvironmentWithParents", 0, 1);

		op = addEOperation(classifierEClass, theSemanticsPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theSemanticsPackage.getOclVisitor(), "visitor", 0, 1);
		addEParameter(op, theSemanticsPackage.getObject(), "data", 0, 1);

		initEClass(dataTypeEClass, DataType.class, "DataType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(dataTypeEClass, theSemanticsPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theSemanticsPackage.getOclVisitor(), "visitor", 0, 1);
		addEParameter(op, theSemanticsPackage.getObject(), "data", 0, 1);

		initEClass(definedClassEClass, DefinedClass.class, "DefinedClass", !IS_ABSTRACT, !IS_INTERFACE,
		    IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDefinedClass_OwnedOperation(), this.getDefinedOperation(), this.getDefinedOperation_Class(),
		    "ownedOperation", null, 0, -1, DefinedClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
		    IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDefinedClass_Package(), this.getDefinedPackage(), this.getDefinedPackage_OwnedType(),
		    "package", null, 1, 1, DefinedClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
		    !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(definedClassEClass, theSemanticsPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theSemanticsPackage.getOclVisitor(), "visitor", 0, 1);
		addEParameter(op, theSemanticsPackage.getObject(), "data", 0, 1);

		initEClass(definedOperationEClass, DefinedOperation.class, "DefinedOperation", !IS_ABSTRACT, !IS_INTERFACE,
		    IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDefinedOperation_Class(), this.getDefinedClass(), this.getDefinedClass_OwnedOperation(),
		    "class", null, 1, 1, DefinedOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
		    !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDefinedOperation_RaisedException(), this.getClassifier(), null, "raisedException", null, 0,
		    -1, DefinedOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
		    !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(definedPackageEClass, DefinedPackage.class, "DefinedPackage", !IS_ABSTRACT, !IS_INTERFACE,
		    IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDefinedPackage_OwnedType(), this.getDefinedClass(), this.getDefinedClass_Package(),
		    "ownedType", null, 0, -1, DefinedPackage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
		    !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(definedPackageEClass, theSemanticsPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theSemanticsPackage.getOclVisitor(), "visitor", 0, 1);
		addEParameter(op, theSemanticsPackage.getObject(), "data", 0, 1);

		initEClass(elementEClass, Element.class, "Element", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getElement_Tag(), this.getTag(), this.getTag_Element(), "tag", null, 0, -1, Element.class,
		    !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
		    !IS_DERIVED, IS_ORDERED);

		initEClass(enumLiteralEClass, EnumLiteral.class, "EnumLiteral", !IS_ABSTRACT, !IS_INTERFACE,
		    IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEnumLiteral_Enumeration(), this.getEnumeration(), this.getEnumeration_Literal(),
		    "enumeration", null, 1, 1, EnumLiteral.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
		    !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(enumLiteralEClass, theSemanticsPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theSemanticsPackage.getOclVisitor(), "visitor", 0, 1);
		addEParameter(op, theSemanticsPackage.getObject(), "data", 0, 1);

		initEClass(enumerationEClass, Enumeration.class, "Enumeration", !IS_ABSTRACT, !IS_INTERFACE,
		    IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEnumeration_Literal(), this.getEnumLiteral(), this.getEnumLiteral_Enumeration(), "literal",
		    null, 1, -1, Enumeration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
		    !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(enumerationEClass, this.getEnumLiteral(), "lookupEnumLiteral", 0, 1);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1);

		op = addEOperation(enumerationEClass, theSemanticsPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theSemanticsPackage.getOclVisitor(), "visitor", 0, 1);
		addEParameter(op, theSemanticsPackage.getObject(), "data", 0, 1);

		initEClass(environmentEClass, Environment.class, "Environment", !IS_ABSTRACT, !IS_INTERFACE,
		    IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEnvironment_BridgeFactory(), theSemanticsPackage.getBridgeFactory(), "bridgeFactory", null,
		    1, 1, Environment.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
		    !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEnvironment_NamedElementEntrys(), theSemanticsPackage.getMap(), "namedElementEntrys", null,
		    1, 1, Environment.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
		    !IS_DERIVED, IS_ORDERED);
		initEReference(getEnvironment_Namespaces(), this.getNamespace(), null, "namespaces", null, 0, -1,
		    Environment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
		    !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEnvironment_Parent(), this.getEnvironment(), null, "parent", null, 1, 1, Environment.class,
		    !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
		    !IS_DERIVED, IS_ORDERED);

		op = addEOperation(environmentEClass, this.getNamedElement(), "lookupLocal", 0, 1);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1);

		op = addEOperation(environmentEClass, this.getModelElement(), "lookup", 0, 1);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1);

		op = addEOperation(environmentEClass, this.getModelElement(), "lookupPathName", 0, 1);
		addEParameter(op, theSemanticsPackage.getList(), "names", 0, 1);

		op = addEOperation(environmentEClass, this.getEnvironment(), "addElement", 0, 1);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1);
		addEParameter(op, this.getModelElement(), "elem", 0, 1);
		addEParameter(op, theSemanticsPackage.getBoolean(), "imp", 0, 1);

		op = addEOperation(environmentEClass, this.getEnvironment(), "addEnvironment", 0, 1);
		addEParameter(op, this.getEnvironment(), "env", 0, 1);

		op = addEOperation(environmentEClass, this.getEnvironment(), "addNamespace", 0, 1);
		addEParameter(op, this.getNamespace(), "ns", 0, 1);

		op = addEOperation(environmentEClass, this.getProperty(), "lookupImplicitProperty", 0, 1);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1);

		op = addEOperation(environmentEClass, this.getNamedElement(), "lookupImplicitSourceForProperty", 0, 1);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1);

		op = addEOperation(environmentEClass, this.getOperation(), "lookupImplicitOperation", 0, 1);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1);
		addEParameter(op, theSemanticsPackage.getList(), "types", 0, 1);

		addEOperation(environmentEClass, this.getEnvironment(), "nestedEnvironment", 0, 1);

		op = addEOperation(environmentEClass, this.getOperation(), "lookupPathName", 0, 1);
		addEParameter(op, theSemanticsPackage.getList(), "names", 0, 1);
		addEParameter(op, theSemanticsPackage.getList(), "types", 0, 1);

		op = addEOperation(environmentEClass, this.getNamedElement(), "lookupImplicitSourceForOperation", 0, 1);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1);
		addEParameter(op, theSemanticsPackage.getList(), "types", 0, 1);

		op = addEOperation(environmentEClass, this.getEnvironment(), "addVariableDeclaration", 0, 1);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1);
		addEParameter(op, this.getClassifier(), "type", 0, 1);
		addEParameter(op, theSemanticsPackage.getBoolean(), "clash", 0, 1);

		addEOperation(environmentEClass, theSemanticsPackage.getObject(), "clone", 0, 1);

		addEOperation(environmentEClass, theSemanticsPackage.getOclProcessor(), "getProcessor", 0, 1);

		addEOperation(environmentEClass, this.getEnvironment(), "getEMPTY_ENV", 0, 1);

		addEOperation(environmentEClass, theSemanticsPackage.getSet(), "getNamedElements", 0, 1);

		op = addEOperation(environmentEClass, null, "setNamedElements");
		addEParameter(op, theSemanticsPackage.getSet(), "namedElements", 0, 1);

		op = addEOperation(environmentEClass, this.getEnvironment(), "addVariableDeclaration", 0, 1);
		addEParameter(op, theExpressionsPackage.getVariableDeclaration(), "variableDeclaration", 0, 1);
		addEParameter(op, theSemanticsPackage.getBoolean(), "clash", 0, 1);

		initEClass(modelElementEClass, ModelElement.class, "ModelElement", !IS_ABSTRACT, !IS_INTERFACE,
		    IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getModelElement_Name(), ecorePackage.getEString(), "name", null, 1, 1, ModelElement.class,
		    !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(modelElementEClass, theSemanticsPackage.getObject(), "getDelegate", 0, 1);

		initEClass(namedElementEClass, NamedElement.class, "NamedElement", !IS_ABSTRACT, !IS_INTERFACE,
		    IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNamedElement_MayBeImplicit(), theSemanticsPackage.getBoolean(), "mayBeImplicit", null, 1, 1,
		    NamedElement.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
		    !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNamedElement_Name(), ecorePackage.getEString(), "name", null, 1, 1, NamedElement.class,
		    !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNamedElement_ReferredElement(), this.getModelElement(), null, "referredElement", null, 1, 1,
		    NamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
		    !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(namedElementEClass, this.getClassifier(), "getType", 0, 1);

		initEClass(namespaceEClass, Namespace.class, "Namespace", !IS_ABSTRACT, !IS_INTERFACE,
		    IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNamespace_Namespace(), this.getNamespace(), null, "namespace", null, 1, 1, Namespace.class,
		    !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
		    !IS_DERIVED, IS_ORDERED);

		addEOperation(namespaceEClass, this.getEnvironment(), "getEnvironmentWithoutParents", 0, 1);

		addEOperation(namespaceEClass, this.getEnvironment(), "getEnvironmentWithParents", 0, 1);

		op = addEOperation(namespaceEClass, this.getModelElement(), "lookupOwnedElement", 0, 1);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1);

		op = addEOperation(namespaceEClass, ecorePackage.getEString(), "getFullName", 0, 1);
		addEParameter(op, ecorePackage.getEString(), "sep", 0, 1);

		op = addEOperation(namespaceEClass, theSemanticsPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theSemanticsPackage.getOclVisitor(), "visitor", 0, 1);
		addEParameter(op, theSemanticsPackage.getObject(), "data", 0, 1);

		initEClass(oclModelElementTypeEClass, OclModelElementType.class, "OclModelElementType", !IS_ABSTRACT,
		    !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(oclModelElementTypeEClass, theSemanticsPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theSemanticsPackage.getOclVisitor(), "visitor", 0, 1);
		addEParameter(op, theSemanticsPackage.getObject(), "data", 0, 1);

		initEClass(operationEClass, Operation.class, "Operation", !IS_ABSTRACT, !IS_INTERFACE,
		    IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOperation_OwnedParameter(), this.getParameter(), this.getParameter_Operation(),
		    "ownedParameter", null, 0, -1, Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
		    !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOperation_ReturnType(), this.getClassifier(), null, "returnType", null, 1, 1,
		    Operation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
		    !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(parameterEClass, Parameter.class, "Parameter", !IS_ABSTRACT, !IS_INTERFACE,
		    IS_GENERATED_INSTANCE_CLASS);
		initEReference(getParameter_Type(), this.getClassifier(), null, "type", null, 1, 1, Parameter.class,
		    !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
		    !IS_DERIVED, IS_ORDERED);
		initEReference(getParameter_Operation(), this.getOperation(), this.getOperation_OwnedParameter(), "operation",
		    null, 0, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
		    !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(primitiveEClass, Primitive.class, "Primitive", !IS_ABSTRACT, !IS_INTERFACE,
		    IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(primitiveEClass, theSemanticsPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theSemanticsPackage.getOclVisitor(), "visitor", 0, 1);
		addEParameter(op, theSemanticsPackage.getObject(), "data", 0, 1);

		initEClass(propertyEClass, Property.class, "Property", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProperty_Type(), this.getClassifier(), null, "type", null, 1, 1, Property.class,
		    !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
		    !IS_DERIVED, IS_ORDERED);

		op = addEOperation(propertyEClass, theSemanticsPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theSemanticsPackage.getOclVisitor(), "visitor", 0, 1);
		addEParameter(op, theSemanticsPackage.getObject(), "data", 0, 1);

		initEClass(sendActionEClass, SendAction.class, "SendAction", !IS_ABSTRACT, !IS_INTERFACE,
		    IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSendAction_Signal(), this.getSignal(), null, "signal", null, 1, 1, SendAction.class,
		    !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
		    !IS_DERIVED, IS_ORDERED);

		op = addEOperation(sendActionEClass, theSemanticsPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theSemanticsPackage.getOclVisitor(), "visitor", 0, 1);
		addEParameter(op, theSemanticsPackage.getObject(), "data", 0, 1);

		initEClass(signalEClass, Signal.class, "Signal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSignal_ParameterNames(), ecorePackage.getEString(), "parameterNames", null, 0, -1,
		    Signal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
		    IS_ORDERED);
		initEReference(getSignal_ParameterTypes(), this.getClassifier(), null, "parameterTypes", null, 0, -1,
		    Signal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
		    !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(signalEClass, theSemanticsPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theSemanticsPackage.getOclVisitor(), "visitor", 0, 1);
		addEParameter(op, theSemanticsPackage.getObject(), "data", 0, 1);

		initEClass(tagEClass, Tag.class, "Tag", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTag_Name(), ecorePackage.getEString(), "name", null, 1, 1, Tag.class, !IS_TRANSIENT,
		    !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTag_Value(), ecorePackage.getEString(), "value", null, 1, 1, Tag.class, !IS_TRANSIENT,
		    !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTag_Element(), this.getElement(), this.getElement_Tag(), "element", null, 0, -1, Tag.class,
		    !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
		    !IS_DERIVED, IS_ORDERED);

		op = addEOperation(tagEClass, theSemanticsPackage.getObject(), "accept", 0, 1);
		addEParameter(op, theSemanticsPackage.getOclVisitor(), "visitor", 0, 1);
		addEParameter(op, theSemanticsPackage.getObject(), "data", 0, 1);

		// Create annotations
		// see
		createSeeAnnotations();
	}

	/**
	 * Initializes the annotations for <b>see</b>. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void createSeeAnnotations() {
		String source = "see";
		addAnnotation(environmentEClass, source, new String[] { "see", "" });
	}

} // BridgePackageImpl
