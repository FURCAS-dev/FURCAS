/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.semantics.bridge.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.oslo.ocl20.semantics.bridge.*;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class BridgeFactoryImpl extends EFactoryImpl implements BridgeFactory {
	/**
	 * Creates the default factory implementation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static BridgeFactory init() {
		try {
			BridgeFactory theBridgeFactory = (BridgeFactory) EPackage.Registry.INSTANCE
			        .getEFactory("urn:semantics.bridge.ecore");
			if (theBridgeFactory != null) {
				return theBridgeFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new BridgeFactoryImpl();
	}

	/**
	 * Creates an instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public BridgeFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case BridgePackage.CALL_ACTION:
				return createCallAction();
			case BridgePackage.CLASSIFIER:
				return createClassifier();
			case BridgePackage.DATA_TYPE:
				return createDataType();
			case BridgePackage.DEFINED_CLASS:
				return createDefinedClass();
			case BridgePackage.DEFINED_OPERATION:
				return createDefinedOperation();
			case BridgePackage.DEFINED_PACKAGE:
				return createDefinedPackage();
			case BridgePackage.ELEMENT:
				return createElement();
			case BridgePackage.ENUM_LITERAL:
				return createEnumLiteral();
			case BridgePackage.ENUMERATION:
				return createEnumeration();
			case BridgePackage.ENVIRONMENT:
				return createEnvironment();
			case BridgePackage.MODEL_ELEMENT:
				return createModelElement();
			case BridgePackage.NAMED_ELEMENT:
				return createNamedElement();
			case BridgePackage.NAMESPACE:
				return createNamespace();
			case BridgePackage.OCL_MODEL_ELEMENT_TYPE:
				return createOclModelElementType();
			case BridgePackage.OPERATION:
				return createOperation();
			case BridgePackage.PARAMETER:
				return createParameter();
			case BridgePackage.PRIMITIVE:
				return createPrimitive();
			case BridgePackage.PROPERTY:
				return createProperty();
			case BridgePackage.SEND_ACTION:
				return createSendAction();
			case BridgePackage.SIGNAL:
				return createSignal();
			case BridgePackage.TAG:
				return createTag();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public CallAction createCallAction() {
		CallActionImpl callAction = new CallActionImpl();
		return callAction;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Classifier createClassifier() {
		ClassifierImpl classifier = new ClassifierImpl();
		return classifier;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DataType createDataType() {
		DataTypeImpl dataType = new DataTypeImpl();
		return dataType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DefinedClass createDefinedClass() {
		DefinedClassImpl definedClass = new DefinedClassImpl();
		return definedClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DefinedOperation createDefinedOperation() {
		DefinedOperationImpl definedOperation = new DefinedOperationImpl();
		return definedOperation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DefinedPackage createDefinedPackage() {
		DefinedPackageImpl definedPackage = new DefinedPackageImpl();
		return definedPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Element createElement() {
		ElementImpl element = new ElementImpl();
		return element;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EnumLiteral createEnumLiteral() {
		EnumLiteralImpl enumLiteral = new EnumLiteralImpl();
		return enumLiteral;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Enumeration createEnumeration() {
		EnumerationImpl enumeration = new EnumerationImpl();
		return enumeration;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Environment createEnvironment() {
		EnvironmentImpl environment = new EnvironmentImpl();
		return environment;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ModelElement createModelElement() {
		ModelElementImpl modelElement = new ModelElementImpl();
		return modelElement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NamedElement createNamedElement() {
		NamedElementImpl namedElement = new NamedElementImpl();
		return namedElement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Namespace createNamespace() {
		NamespaceImpl namespace = new NamespaceImpl();
		return namespace;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public OclModelElementType createOclModelElementType() {
		OclModelElementTypeImpl oclModelElementType = new OclModelElementTypeImpl();
		return oclModelElementType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Operation createOperation() {
		OperationImpl operation = new OperationImpl();
		return operation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Parameter createParameter() {
		ParameterImpl parameter = new ParameterImpl();
		return parameter;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Primitive createPrimitive() {
		PrimitiveImpl primitive = new PrimitiveImpl();
		return primitive;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Property createProperty() {
		PropertyImpl property = new PropertyImpl();
		return property;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public SendAction createSendAction() {
		SendActionImpl sendAction = new SendActionImpl();
		return sendAction;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Signal createSignal() {
		SignalImpl signal = new SignalImpl();
		return signal;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Tag createTag() {
		TagImpl tag = new TagImpl();
		return tag;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public BridgePackage getBridgePackage() {
		return (BridgePackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @deprecated
	 * @generated
	 */
	public static BridgePackage getPackage() {
		return BridgePackage.eINSTANCE;
	}

} // BridgeFactoryImpl
