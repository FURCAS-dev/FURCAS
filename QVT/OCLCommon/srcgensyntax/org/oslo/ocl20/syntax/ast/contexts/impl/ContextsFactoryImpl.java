/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.syntax.ast.contexts.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.oslo.ocl20.syntax.ast.contexts.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ContextsFactoryImpl extends EFactoryImpl implements ContextsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ContextsFactory init() {
		try {
			ContextsFactory theContextsFactory = (ContextsFactory)EPackage.Registry.INSTANCE.getEFactory("urn:ast.contexts.ecore"); 
			if (theContextsFactory != null) {
				return theContextsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ContextsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContextsFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ContextsPackage.CLASSIFIER_CONTEXT_DECL_AS: return createClassifierContextDeclAS();
			case ContextsPackage.CONSTRAINT_AS: return createConstraintAS();
			case ContextsPackage.CONTEXT_DECLARATION_AS: return createContextDeclarationAS();
			case ContextsPackage.OPERATION_AS: return createOperationAS();
			case ContextsPackage.OPERATION_CONTEXT_DECL_AS: return createOperationContextDeclAS();
			case ContextsPackage.PACKAGE_DECLARATION_AS: return createPackageDeclarationAS();
			case ContextsPackage.PROPERTY_CONTEXT_DECL_AS: return createPropertyContextDeclAS();
			case ContextsPackage.VARIABLE_DECLARATION_AS: return createVariableDeclarationAS();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case ContextsPackage.CONSTRAINT_KIND_AS:
				return createConstraintKindASFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case ContextsPackage.CONSTRAINT_KIND_AS:
				return convertConstraintKindASToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassifierContextDeclAS createClassifierContextDeclAS() {
		ClassifierContextDeclASImpl classifierContextDeclAS = new ClassifierContextDeclASImpl();
		return classifierContextDeclAS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConstraintAS createConstraintAS() {
		ConstraintASImpl constraintAS = new ConstraintASImpl();
		return constraintAS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContextDeclarationAS createContextDeclarationAS() {
		ContextDeclarationASImpl contextDeclarationAS = new ContextDeclarationASImpl();
		return contextDeclarationAS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationAS createOperationAS() {
		OperationASImpl operationAS = new OperationASImpl();
		return operationAS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationContextDeclAS createOperationContextDeclAS() {
		OperationContextDeclASImpl operationContextDeclAS = new OperationContextDeclASImpl();
		return operationContextDeclAS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PackageDeclarationAS createPackageDeclarationAS() {
		PackageDeclarationASImpl packageDeclarationAS = new PackageDeclarationASImpl();
		return packageDeclarationAS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyContextDeclAS createPropertyContextDeclAS() {
		PropertyContextDeclASImpl propertyContextDeclAS = new PropertyContextDeclASImpl();
		return propertyContextDeclAS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableDeclarationAS createVariableDeclarationAS() {
		VariableDeclarationASImpl variableDeclarationAS = new VariableDeclarationASImpl();
		return variableDeclarationAS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConstraintKindAS createConstraintKindASFromString(EDataType eDataType, String initialValue) {
		ConstraintKindAS result = ConstraintKindAS.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertConstraintKindASToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContextsPackage getContextsPackage() {
		return (ContextsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static ContextsPackage getPackage() {
		return ContextsPackage.eINSTANCE;
	}

} //ContextsFactoryImpl
