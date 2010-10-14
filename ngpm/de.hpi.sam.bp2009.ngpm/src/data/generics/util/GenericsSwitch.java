/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package data.generics.util;

import behavioral.events.EventProducer;

import data.classes.SapClass;
import data.classes.SignatureOwner;

import data.generics.*;

import java.util.List;

import modelmanagement.NamedElement;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

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
 * @see data.generics.GenericsPackage
 * @generated
 */
public class GenericsSwitch<T> {
	/**
     * The cached model package
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static GenericsPackage modelPackage;

	/**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public GenericsSwitch() {
        if (modelPackage == null) {
            modelPackage = GenericsPackage.eINSTANCE;
        }
    }

	/**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
	public T doSwitch(EObject theEObject) {
        return doSwitch(theEObject.eClass(), theEObject);
    }

	/**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
        if (theEClass.eContainer() == modelPackage) {
            return doSwitch(theEClass.getClassifierID(), theEObject);
        }
        else {
            List<EClass> eSuperTypes = theEClass.getESuperTypes();
            return
                eSuperTypes.isEmpty() ?
                    defaultCase(theEObject) :
                    doSwitch(eSuperTypes.get(0), theEObject);
        }
    }

	/**
     * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @return the first non-null result returned by a <code>caseXXX</code> call.
     * @generated
     */
	protected T doSwitch(int classifierID, EObject theEObject) {
        switch (classifierID) {
            case GenericsPackage.FORMAL_TYPE_PARAMETER: {
                FormalTypeParameter formalTypeParameter = (FormalTypeParameter)theEObject;
                T result = caseFormalTypeParameter(formalTypeParameter);
                if (result == null) result = caseSapClass(formalTypeParameter);
                if (result == null) result = caseSignatureOwner(formalTypeParameter);
                if (result == null) result = caseEventProducer(formalTypeParameter);
                if (result == null) result = caseNamedElement(formalTypeParameter);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case GenericsPackage.PARAMETERIZED_CLASS_INSTANTIATION: {
                ParameterizedClassInstantiation parameterizedClassInstantiation = (ParameterizedClassInstantiation)theEObject;
                T result = caseParameterizedClassInstantiation(parameterizedClassInstantiation);
                if (result == null) result = caseSapClass(parameterizedClassInstantiation);
                if (result == null) result = caseSignatureOwner(parameterizedClassInstantiation);
                if (result == null) result = caseEventProducer(parameterizedClassInstantiation);
                if (result == null) result = caseNamedElement(parameterizedClassInstantiation);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case GenericsPackage.CLASS_PARAMETERIZATION: {
                ClassParameterization classParameterization = (ClassParameterization)theEObject;
                T result = caseClassParameterization(classParameterization);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case GenericsPackage.ACTUAL_TYPE_PARAMETER: {
                ActualTypeParameter actualTypeParameter = (ActualTypeParameter)theEObject;
                T result = caseActualTypeParameter(actualTypeParameter);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            default: return defaultCase(theEObject);
        }
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Formal Type Parameter</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Formal Type Parameter</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseFormalTypeParameter(FormalTypeParameter object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Parameterized Class Instantiation</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Parameterized Class Instantiation</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseParameterizedClassInstantiation(ParameterizedClassInstantiation object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Class Parameterization</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Class Parameterization</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseClassParameterization(ClassParameterization object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Actual Type Parameter</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Actual Type Parameter</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseActualTypeParameter(ActualTypeParameter object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseNamedElement(NamedElement object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Signature Owner</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Signature Owner</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseSignatureOwner(SignatureOwner object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Event Producer</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Event Producer</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseEventProducer(EventProducer object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Sap Class</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Sap Class</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseSapClass(SapClass object) {
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
	public T defaultCase(EObject object) {
        return null;
    }

} //GenericsSwitch
