/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.oslo.ocl20.syntax.ast.contexts.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.oslo.ocl20.syntax.ast.Visitable;

import org.oslo.ocl20.syntax.ast.contexts.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.oslo.ocl20.syntax.ast.contexts.ContextsPackage
 * @generated
 */
public class ContextsSwitch {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ContextsPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContextsSwitch() {
		if (modelPackage == null) {
			modelPackage = ContextsPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public Object doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch((EClass)eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case ContextsPackage.CLASSIFIER_CONTEXT_DECL_AS: {
				ClassifierContextDeclAS classifierContextDeclAS = (ClassifierContextDeclAS)theEObject;
				Object result = caseClassifierContextDeclAS(classifierContextDeclAS);
				if (result == null) result = caseContextDeclarationAS(classifierContextDeclAS);
				if (result == null) result = caseVisitable(classifierContextDeclAS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ContextsPackage.CONSTRAINT_AS: {
				ConstraintAS constraintAS = (ConstraintAS)theEObject;
				Object result = caseConstraintAS(constraintAS);
				if (result == null) result = caseVisitable(constraintAS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ContextsPackage.CONTEXT_DECLARATION_AS: {
				ContextDeclarationAS contextDeclarationAS = (ContextDeclarationAS)theEObject;
				Object result = caseContextDeclarationAS(contextDeclarationAS);
				if (result == null) result = caseVisitable(contextDeclarationAS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ContextsPackage.OPERATION_AS: {
				OperationAS operationAS = (OperationAS)theEObject;
				Object result = caseOperationAS(operationAS);
				if (result == null) result = caseVisitable(operationAS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ContextsPackage.OPERATION_CONTEXT_DECL_AS: {
				OperationContextDeclAS operationContextDeclAS = (OperationContextDeclAS)theEObject;
				Object result = caseOperationContextDeclAS(operationContextDeclAS);
				if (result == null) result = caseContextDeclarationAS(operationContextDeclAS);
				if (result == null) result = caseVisitable(operationContextDeclAS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ContextsPackage.PACKAGE_DECLARATION_AS: {
				PackageDeclarationAS packageDeclarationAS = (PackageDeclarationAS)theEObject;
				Object result = casePackageDeclarationAS(packageDeclarationAS);
				if (result == null) result = caseVisitable(packageDeclarationAS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ContextsPackage.PROPERTY_CONTEXT_DECL_AS: {
				PropertyContextDeclAS propertyContextDeclAS = (PropertyContextDeclAS)theEObject;
				Object result = casePropertyContextDeclAS(propertyContextDeclAS);
				if (result == null) result = caseContextDeclarationAS(propertyContextDeclAS);
				if (result == null) result = caseVisitable(propertyContextDeclAS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ContextsPackage.VARIABLE_DECLARATION_AS: {
				VariableDeclarationAS variableDeclarationAS = (VariableDeclarationAS)theEObject;
				Object result = caseVariableDeclarationAS(variableDeclarationAS);
				if (result == null) result = caseVisitable(variableDeclarationAS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Classifier Context Decl AS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Classifier Context Decl AS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseClassifierContextDeclAS(ClassifierContextDeclAS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Constraint AS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Constraint AS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseConstraintAS(ConstraintAS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Context Declaration AS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Context Declaration AS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseContextDeclarationAS(ContextDeclarationAS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operation AS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operation AS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseOperationAS(OperationAS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operation Context Decl AS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operation Context Decl AS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseOperationContextDeclAS(OperationContextDeclAS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Package Declaration AS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Package Declaration AS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casePackageDeclarationAS(PackageDeclarationAS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property Context Decl AS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property Context Decl AS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object casePropertyContextDeclAS(PropertyContextDeclAS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable Declaration AS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable Declaration AS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseVariableDeclarationAS(VariableDeclarationAS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Visitable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Visitable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseVisitable(Visitable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public Object defaultCase(EObject object) {
		return null;
	}

} //ContextsSwitch
