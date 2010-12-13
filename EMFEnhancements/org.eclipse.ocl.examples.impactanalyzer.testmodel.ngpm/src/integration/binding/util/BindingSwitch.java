/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package integration.binding.util;

import integration.binding.*;

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
 * @see integration.binding.BindingPackage
 * @generated
 */
public class BindingSwitch<T> {
	/**
     * The cached model package
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static BindingPackage modelPackage;

	/**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public BindingSwitch() {
        if (modelPackage == null) {
            modelPackage = BindingPackage.eINSTANCE;
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
            case BindingPackage.BINDING: {
                Binding binding = (Binding)theEObject;
                T result = caseBinding(binding);
                if (result == null) result = caseNamedElement(binding);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case BindingPackage.HTTP_BINDING: {
                HttpBinding httpBinding = (HttpBinding)theEObject;
                T result = caseHttpBinding(httpBinding);
                if (result == null) result = caseBinding(httpBinding);
                if (result == null) result = caseNamedElement(httpBinding);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case BindingPackage.HTTP_GET_BINDING: {
                HttpGetBinding httpGetBinding = (HttpGetBinding)theEObject;
                T result = caseHttpGetBinding(httpGetBinding);
                if (result == null) result = caseHttpBinding(httpGetBinding);
                if (result == null) result = caseBinding(httpGetBinding);
                if (result == null) result = caseNamedElement(httpGetBinding);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case BindingPackage.HTTP_PUT_BINDING: {
                HttpPutBinding httpPutBinding = (HttpPutBinding)theEObject;
                T result = caseHttpPutBinding(httpPutBinding);
                if (result == null) result = caseHttpBinding(httpPutBinding);
                if (result == null) result = caseBinding(httpPutBinding);
                if (result == null) result = caseNamedElement(httpPutBinding);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case BindingPackage.URL_PATTERN: {
                UrlPattern urlPattern = (UrlPattern)theEObject;
                T result = caseUrlPattern(urlPattern);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case BindingPackage.SIMPLE_URL_PATTERN: {
                SimpleUrlPattern simpleUrlPattern = (SimpleUrlPattern)theEObject;
                T result = caseSimpleUrlPattern(simpleUrlPattern);
                if (result == null) result = caseUrlPattern(simpleUrlPattern);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case BindingPackage.REST_URL_PATTERN: {
                RestUrlPattern restUrlPattern = (RestUrlPattern)theEObject;
                T result = caseRestUrlPattern(restUrlPattern);
                if (result == null) result = caseUrlPattern(restUrlPattern);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            default: return defaultCase(theEObject);
        }
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Binding</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Binding</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseBinding(Binding object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Http Binding</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Http Binding</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseHttpBinding(HttpBinding object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Http Get Binding</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Http Get Binding</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseHttpGetBinding(HttpGetBinding object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Http Put Binding</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Http Put Binding</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseHttpPutBinding(HttpPutBinding object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Url Pattern</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Url Pattern</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseUrlPattern(UrlPattern object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Simple Url Pattern</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Simple Url Pattern</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseSimpleUrlPattern(SimpleUrlPattern object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Rest Url Pattern</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Rest Url Pattern</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseRestUrlPattern(RestUrlPattern object) {
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

} //BindingSwitch
