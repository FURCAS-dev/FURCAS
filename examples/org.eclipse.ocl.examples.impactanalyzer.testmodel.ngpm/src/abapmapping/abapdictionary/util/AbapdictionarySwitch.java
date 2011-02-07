/**
 * <copyright>
 * </copyright>
 *
 * $Id: AbapdictionarySwitch.java,v 1.1 2011/02/07 16:46:50 auhl Exp $
 */
package abapmapping.abapdictionary.util;

import abapmapping.abapdictionary.*;

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
 * @see abapmapping.abapdictionary.AbapdictionaryPackage
 * @generated
 */
public class AbapdictionarySwitch<T> {
	/**
     * The cached model package
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static AbapdictionaryPackage modelPackage;

	/**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public AbapdictionarySwitch() {
        if (modelPackage == null) {
            modelPackage = AbapdictionaryPackage.eINSTANCE;
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
            case AbapdictionaryPackage.XSD_TYPE: {
                XsdType xsdType = (XsdType)theEObject;
                T result = caseXsdType(xsdType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case AbapdictionaryPackage.UNSTRUCTURED_ABAP_TYPE: {
                UnstructuredAbapType unstructuredAbapType = (UnstructuredAbapType)theEObject;
                T result = caseUnstructuredAbapType(unstructuredAbapType);
                if (result == null) result = caseAbapType(unstructuredAbapType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case AbapdictionaryPackage.CODE_VALUE: {
                CodeValue codeValue = (CodeValue)theEObject;
                T result = caseCodeValue(codeValue);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case AbapdictionaryPackage.CODE: {
                Code code = (Code)theEObject;
                T result = caseCode(code);
                if (result == null) result = caseDataElement(code);
                if (result == null) result = caseUnstructuredAbapType(code);
                if (result == null) result = caseAbapType(code);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case AbapdictionaryPackage.DATA_ELEMENT: {
                DataElement dataElement = (DataElement)theEObject;
                T result = caseDataElement(dataElement);
                if (result == null) result = caseUnstructuredAbapType(dataElement);
                if (result == null) result = caseAbapType(dataElement);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case AbapdictionaryPackage.ABAP_TYPE: {
                AbapType abapType = (AbapType)theEObject;
                T result = caseAbapType(abapType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case AbapdictionaryPackage.ABAP_STRUCTURE_TYPE: {
                AbapStructureType abapStructureType = (AbapStructureType)theEObject;
                T result = caseAbapStructureType(abapStructureType);
                if (result == null) result = caseAbapType(abapStructureType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case AbapdictionaryPackage.ABAP_STRUCTURE_FIELD: {
                AbapStructureField abapStructureField = (AbapStructureField)theEObject;
                T result = caseAbapStructureField(abapStructureField);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case AbapdictionaryPackage.ABAP_PRIMTIVE_TYPE: {
                AbapPrimtiveType abapPrimtiveType = (AbapPrimtiveType)theEObject;
                T result = caseAbapPrimtiveType(abapPrimtiveType);
                if (result == null) result = caseUnstructuredAbapType(abapPrimtiveType);
                if (result == null) result = caseAbapType(abapPrimtiveType);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            default: return defaultCase(theEObject);
        }
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Xsd Type</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Xsd Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseXsdType(XsdType object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Unstructured Abap Type</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Unstructured Abap Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseUnstructuredAbapType(UnstructuredAbapType object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Code Value</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Code Value</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseCodeValue(CodeValue object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Code</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Code</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseCode(Code object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Data Element</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Data Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseDataElement(DataElement object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Abap Type</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Abap Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseAbapType(AbapType object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Abap Structure Type</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Abap Structure Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseAbapStructureType(AbapStructureType object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Abap Structure Field</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Abap Structure Field</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseAbapStructureField(AbapStructureField object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Abap Primtive Type</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Abap Primtive Type</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseAbapPrimtiveType(AbapPrimtiveType object) {
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

} //AbapdictionarySwitch
