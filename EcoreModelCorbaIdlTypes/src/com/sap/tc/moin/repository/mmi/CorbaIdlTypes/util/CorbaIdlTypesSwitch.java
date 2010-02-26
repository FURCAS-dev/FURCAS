/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.sap.tc.moin.repository.mmi.CorbaIdlTypes.util;

import com.sap.tc.moin.repository.mmi.CorbaIdlTypes.*;

import java.util.List;

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
 * @see com.sap.tc.moin.repository.mmi.CorbaIdlTypes.CorbaIdlTypesPackage
 * @generated
 */
public class CorbaIdlTypesSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static CorbaIdlTypesPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CorbaIdlTypesSwitch() {
		if (modelPackage == null) {
			modelPackage = CorbaIdlTypesPackage.eINSTANCE;
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
			case CorbaIdlTypesPackage.CORBA_OCTET: {
				CorbaOctet corbaOctet = (CorbaOctet)theEObject;
				T result = caseCorbaOctet(corbaOctet);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorbaIdlTypesPackage.CORBA_SHORT: {
				CorbaShort corbaShort = (CorbaShort)theEObject;
				T result = caseCorbaShort(corbaShort);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorbaIdlTypesPackage.CORBA_UNSIGNED_SHORT: {
				CorbaUnsignedShort corbaUnsignedShort = (CorbaUnsignedShort)theEObject;
				T result = caseCorbaUnsignedShort(corbaUnsignedShort);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorbaIdlTypesPackage.CORBA_UNSIGNED_LONG: {
				CorbaUnsignedLong corbaUnsignedLong = (CorbaUnsignedLong)theEObject;
				T result = caseCorbaUnsignedLong(corbaUnsignedLong);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorbaIdlTypesPackage.CORBA_UNSIGNED_LONG_LONG: {
				CorbaUnsignedLongLong corbaUnsignedLongLong = (CorbaUnsignedLongLong)theEObject;
				T result = caseCorbaUnsignedLongLong(corbaUnsignedLongLong);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorbaIdlTypesPackage.CORBA_LONG_DOUBLE: {
				CorbaLongDouble corbaLongDouble = (CorbaLongDouble)theEObject;
				T result = caseCorbaLongDouble(corbaLongDouble);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorbaIdlTypesPackage.CORBA_STRING: {
				CorbaString corbaString = (CorbaString)theEObject;
				T result = caseCorbaString(corbaString);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorbaIdlTypesPackage.CORBA_CHAR: {
				CorbaChar corbaChar = (CorbaChar)theEObject;
				T result = caseCorbaChar(corbaChar);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CorbaIdlTypesPackage.CORBA_WCHAR: {
				CorbaWChar corbaWChar = (CorbaWChar)theEObject;
				T result = caseCorbaWChar(corbaWChar);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Corba Octet</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Corba Octet</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCorbaOctet(CorbaOctet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Corba Short</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Corba Short</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCorbaShort(CorbaShort object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Corba Unsigned Short</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Corba Unsigned Short</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCorbaUnsignedShort(CorbaUnsignedShort object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Corba Unsigned Long</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Corba Unsigned Long</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCorbaUnsignedLong(CorbaUnsignedLong object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Corba Unsigned Long Long</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Corba Unsigned Long Long</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCorbaUnsignedLongLong(CorbaUnsignedLongLong object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Corba Long Double</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Corba Long Double</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCorbaLongDouble(CorbaLongDouble object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Corba String</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Corba String</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCorbaString(CorbaString object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Corba Char</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Corba Char</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCorbaChar(CorbaChar object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Corba WChar</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Corba WChar</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCorbaWChar(CorbaWChar object) {
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

} //CorbaIdlTypesSwitch
