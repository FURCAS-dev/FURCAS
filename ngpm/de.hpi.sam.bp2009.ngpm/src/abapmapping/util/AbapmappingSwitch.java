/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package abapmapping.util;

import abapmapping.*;

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
 * @see abapmapping.AbapmappingPackage
 * @generated
 */
public class AbapmappingSwitch<T> {
	/**
     * The cached model package
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static AbapmappingPackage modelPackage;

	/**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public AbapmappingSwitch() {
        if (modelPackage == null) {
            modelPackage = AbapmappingPackage.eINSTANCE;
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
            case AbapmappingPackage.ABAP_CLASS_IMPLEMENTATION_ANNOTATION: {
                AbapClassImplementationAnnotation abapClassImplementationAnnotation = (AbapClassImplementationAnnotation)theEObject;
                T result = caseAbapClassImplementationAnnotation(abapClassImplementationAnnotation);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case AbapmappingPackage.ABAP_ASSOCIATION_IMPLEMENTATION_ANNOTATION: {
                AbapAssociationImplementationAnnotation abapAssociationImplementationAnnotation = (AbapAssociationImplementationAnnotation)theEObject;
                T result = caseAbapAssociationImplementationAnnotation(abapAssociationImplementationAnnotation);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case AbapmappingPackage.ABAP_ASSOCIATION_END_IMPLEMENTATION_ANNOTATION: {
                AbapAssociationEndImplementationAnnotation abapAssociationEndImplementationAnnotation = (AbapAssociationEndImplementationAnnotation)theEObject;
                T result = caseAbapAssociationEndImplementationAnnotation(abapAssociationEndImplementationAnnotation);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case AbapmappingPackage.ABAP_SIGNATURE_IMPLEMENTATION_ANNOTATION: {
                AbapSignatureImplementationAnnotation abapSignatureImplementationAnnotation = (AbapSignatureImplementationAnnotation)theEObject;
                T result = caseAbapSignatureImplementationAnnotation(abapSignatureImplementationAnnotation);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            default: return defaultCase(theEObject);
        }
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Abap Class Implementation Annotation</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Abap Class Implementation Annotation</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseAbapClassImplementationAnnotation(AbapClassImplementationAnnotation object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Abap Association Implementation Annotation</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Abap Association Implementation Annotation</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseAbapAssociationImplementationAnnotation(AbapAssociationImplementationAnnotation object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Abap Association End Implementation Annotation</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Abap Association End Implementation Annotation</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseAbapAssociationEndImplementationAnnotation(AbapAssociationEndImplementationAnnotation object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Abap Signature Implementation Annotation</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Abap Signature Implementation Annotation</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseAbapSignatureImplementationAnnotation(AbapSignatureImplementationAnnotation object) {
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

} //AbapmappingSwitch
