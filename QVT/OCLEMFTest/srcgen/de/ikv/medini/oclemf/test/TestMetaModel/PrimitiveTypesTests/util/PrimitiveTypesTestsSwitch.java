/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesTests.util;

import de.ikv.medini.kernel.MediniObject;

import de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesTests.*;

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
 * @see de.ikv.medini.oclemf.test.TestMetaModel.PrimitiveTypesTests.PrimitiveTypesTestsPackage
 * @generated
 */
public class PrimitiveTypesTestsSwitch {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static PrimitiveTypesTestsPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrimitiveTypesTestsSwitch() {
		if (modelPackage == null) {
			modelPackage = PrimitiveTypesTestsPackage.eINSTANCE;
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
			case PrimitiveTypesTestsPackage.BOOLEAN_TEST: {
				BooleanTest booleanTest = (BooleanTest)theEObject;
				Object result = caseBooleanTest(booleanTest);
				if (result == null) result = caseMediniObject(booleanTest);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PrimitiveTypesTestsPackage.DOUBLE_TEST: {
				DoubleTest doubleTest = (DoubleTest)theEObject;
				Object result = caseDoubleTest(doubleTest);
				if (result == null) result = caseMediniObject(doubleTest);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PrimitiveTypesTestsPackage.FLOAT_TEST: {
				FloatTest floatTest = (FloatTest)theEObject;
				Object result = caseFloatTest(floatTest);
				if (result == null) result = caseMediniObject(floatTest);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PrimitiveTypesTestsPackage.INTEGER_TEST: {
				IntegerTest integerTest = (IntegerTest)theEObject;
				Object result = caseIntegerTest(integerTest);
				if (result == null) result = caseMediniObject(integerTest);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PrimitiveTypesTestsPackage.LONG_TEST: {
				LongTest longTest = (LongTest)theEObject;
				Object result = caseLongTest(longTest);
				if (result == null) result = caseMediniObject(longTest);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case PrimitiveTypesTestsPackage.STRING_TEST: {
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
	 * Returns the result of interpretting the object as an instance of '<em>Boolean Test</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Boolean Test</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseBooleanTest(BooleanTest object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Double Test</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Double Test</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseDoubleTest(DoubleTest object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Float Test</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Float Test</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseFloatTest(FloatTest object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Integer Test</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Integer Test</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseIntegerTest(IntegerTest object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Long Test</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Long Test</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseLongTest(LongTest object) {
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

} //PrimitiveTypesTestsSwitch
