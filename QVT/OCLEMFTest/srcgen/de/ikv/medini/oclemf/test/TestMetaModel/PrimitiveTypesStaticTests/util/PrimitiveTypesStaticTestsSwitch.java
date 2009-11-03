/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.util;

import de.ikv.medini.kernel.MediniObject;

import de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.*;

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
 * @see de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesStaticTests.PrimitiveTypesStaticTestsPackage
 * @generated
 */
public class PrimitiveTypesStaticTestsSwitch {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static PrimitiveTypesStaticTestsPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimitiveTypesStaticTestsSwitch() {
		if (modelPackage == null) {
			modelPackage = PrimitiveTypesStaticTestsPackage.eINSTANCE;
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
			case PrimitiveTypesStaticTestsPackage.STATIC_BOOLEAN_TEST: {
				StaticBooleanTest staticBooleanTest = (StaticBooleanTest)theEObject;
				Object result = caseStaticBooleanTest(staticBooleanTest);
				if (result == null) result = caseMediniObject(staticBooleanTest);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PrimitiveTypesStaticTestsPackage.STATIC_DOUBLE_TEST: {
				StaticDoubleTest staticDoubleTest = (StaticDoubleTest)theEObject;
				Object result = caseStaticDoubleTest(staticDoubleTest);
				if (result == null) result = caseMediniObject(staticDoubleTest);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PrimitiveTypesStaticTestsPackage.STATIC_FLOAT_TEST: {
				StaticFloatTest staticFloatTest = (StaticFloatTest)theEObject;
				Object result = caseStaticFloatTest(staticFloatTest);
				if (result == null) result = caseMediniObject(staticFloatTest);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PrimitiveTypesStaticTestsPackage.STATIC_INTEGER_TEST: {
				StaticIntegerTest staticIntegerTest = (StaticIntegerTest)theEObject;
				Object result = caseStaticIntegerTest(staticIntegerTest);
				if (result == null) result = caseMediniObject(staticIntegerTest);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PrimitiveTypesStaticTestsPackage.STATIC_LONG_TEST: {
				StaticLongTest staticLongTest = (StaticLongTest)theEObject;
				Object result = caseStaticLongTest(staticLongTest);
				if (result == null) result = caseMediniObject(staticLongTest);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PrimitiveTypesStaticTestsPackage.STRING_TEST: {
				StringTest stringTest = (StringTest)theEObject;
				Object result = caseStringTest(stringTest);
				if (result == null) result = caseMediniObject(stringTest);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Static Boolean Test</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Static Boolean Test</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseStaticBooleanTest(StaticBooleanTest object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Static Double Test</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Static Double Test</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseStaticDoubleTest(StaticDoubleTest object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Static Float Test</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Static Float Test</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseStaticFloatTest(StaticFloatTest object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Static Integer Test</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Static Integer Test</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseStaticIntegerTest(StaticIntegerTest object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Static Long Test</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Static Long Test</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseStaticLongTest(StaticLongTest object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>String Test</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>String Test</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseStringTest(StringTest object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Medini Object</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Medini Object</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseMediniObject(MediniObject object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public Object defaultCase(EObject object) {
		return null;
	}

} //PrimitiveTypesStaticTestsSwitch
