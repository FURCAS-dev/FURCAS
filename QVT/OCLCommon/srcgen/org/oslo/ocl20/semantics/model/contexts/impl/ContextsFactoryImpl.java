/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.semantics.model.contexts.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.oslo.ocl20.semantics.model.contexts.*;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class ContextsFactoryImpl extends EFactoryImpl implements ContextsFactory {
	/**
	 * Creates the default factory implementation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static ContextsFactory init() {
		try {
			ContextsFactory theContextsFactory = (ContextsFactory) EPackage.Registry.INSTANCE
			        .getEFactory("urn:semantics.model.contexts.ecore");
			if (theContextsFactory != null) {
				return theContextsFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ContextsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ContextsFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ContextsPackage.CLASSIFIER_CONTEXT_DECL:
				return createClassifierContextDecl();
			case ContextsPackage.CONSTRAINT:
				return createConstraint();
			case ContextsPackage.CONTEXT_DECLARATION:
				return createContextDeclaration();
			case ContextsPackage.DEFINED_OPERATION:
				return createDefinedOperation();
			case ContextsPackage.DEFINED_PROPERTY:
				return createDefinedProperty();
			case ContextsPackage.OPERATION_CONTEXT_DECL:
				return createOperationContextDecl();
			case ContextsPackage.PROPERTY_CONTEXT_DECL:
				return createPropertyContextDecl();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case ContextsPackage.CONSTRAINT_KIND:
				return createConstraintKindFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName()
				        + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case ContextsPackage.CONSTRAINT_KIND:
				return convertConstraintKindToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName()
				        + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ClassifierContextDecl createClassifierContextDecl() {
		ClassifierContextDeclImpl classifierContextDecl = new ClassifierContextDeclImpl();
		return classifierContextDecl;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Constraint createConstraint() {
		ConstraintImpl constraint = new ConstraintImpl();
		return constraint;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ContextDeclaration createContextDeclaration() {
		ContextDeclarationImpl contextDeclaration = new ContextDeclarationImpl();
		return contextDeclaration;
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
	public DefinedProperty createDefinedProperty() {
		DefinedPropertyImpl definedProperty = new DefinedPropertyImpl();
		return definedProperty;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public OperationContextDecl createOperationContextDecl() {
		OperationContextDeclImpl operationContextDecl = new OperationContextDeclImpl();
		return operationContextDecl;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public PropertyContextDecl createPropertyContextDecl() {
		PropertyContextDeclImpl propertyContextDecl = new PropertyContextDeclImpl();
		return propertyContextDecl;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ConstraintKind createConstraintKindFromString(EDataType eDataType, String initialValue) {
		ConstraintKind result = ConstraintKind.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '"
			        + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String convertConstraintKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ContextsPackage getContextsPackage() {
		return (ContextsPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @deprecated
	 * @generated
	 */
	public static ContextsPackage getPackage() {
		return ContextsPackage.eINSTANCE;
	}

} // ContextsFactoryImpl
