/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package configuration.businessconfiguration.util;

import configuration.businessconfiguration.*;

import data.classes.TypedElement;

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
 * @see configuration.businessconfiguration.BusinessconfigurationPackage
 * @generated
 */
public class BusinessconfigurationSwitch<T> {
	/**
     * The cached model package
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	protected static BusinessconfigurationPackage modelPackage;

	/**
     * Creates an instance of the switch.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @generated
     */
	public BusinessconfigurationSwitch() {
        if (modelPackage == null) {
            modelPackage = BusinessconfigurationPackage.eINSTANCE;
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
            case BusinessconfigurationPackage.SCOPING_CONTEXT: {
                ScopingContext scopingContext = (ScopingContext)theEObject;
                T result = caseScopingContext(scopingContext);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case BusinessconfigurationPackage.INDUSTRY: {
                Industry industry = (Industry)theEObject;
                T result = caseIndustry(industry);
                if (result == null) result = caseScopingContext(industry);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case BusinessconfigurationPackage.COUNTRY: {
                Country country = (Country)theEObject;
                T result = caseCountry(country);
                if (result == null) result = caseScopingContext(country);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case BusinessconfigurationPackage.CONFIGURATION_ELEMENT: {
                ConfigurationElement configurationElement = (ConfigurationElement)theEObject;
                T result = caseConfigurationElement(configurationElement);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case BusinessconfigurationPackage.BUSINESS_TOPIC: {
                BusinessTopic businessTopic = (BusinessTopic)theEObject;
                T result = caseBusinessTopic(businessTopic);
                if (result == null) result = caseConfigurationElement(businessTopic);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case BusinessconfigurationPackage.BUSINESS_PACKAGE: {
                BusinessPackage businessPackage = (BusinessPackage)theEObject;
                T result = caseBusinessPackage(businessPackage);
                if (result == null) result = caseConfigurationElement(businessPackage);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case BusinessconfigurationPackage.BUSINESS_OPTION: {
                BusinessOption businessOption = (BusinessOption)theEObject;
                T result = caseBusinessOption(businessOption);
                if (result == null) result = caseConfigurationElement(businessOption);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case BusinessconfigurationPackage.BUSINESS_AREA: {
                BusinessArea businessArea = (BusinessArea)theEObject;
                T result = caseBusinessArea(businessArea);
                if (result == null) result = caseConfigurationElement(businessArea);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case BusinessconfigurationPackage.VALUE_SET: {
                ValueSet valueSet = (ValueSet)theEObject;
                T result = caseValueSet(valueSet);
                if (result == null) result = caseNamedElement(valueSet);
                if (result == null) result = caseTypedElement(valueSet);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            case BusinessconfigurationPackage.VALUE_SET_ENTRY: {
                ValueSetEntry valueSetEntry = (ValueSetEntry)theEObject;
                T result = caseValueSetEntry(valueSetEntry);
                if (result == null) result = caseNamedElement(valueSetEntry);
                if (result == null) result = defaultCase(theEObject);
                return result;
            }
            default: return defaultCase(theEObject);
        }
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Scoping Context</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Scoping Context</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseScopingContext(ScopingContext object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Industry</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Industry</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseIndustry(Industry object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Country</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Country</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseCountry(Country object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Configuration Element</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Configuration Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseConfigurationElement(ConfigurationElement object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Business Topic</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Business Topic</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseBusinessTopic(BusinessTopic object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Business Package</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Business Package</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseBusinessPackage(BusinessPackage object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Business Option</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Business Option</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseBusinessOption(BusinessOption object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Business Area</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Business Area</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseBusinessArea(BusinessArea object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Value Set</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Value Set</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseValueSet(ValueSet object) {
        return null;
    }

	/**
     * Returns the result of interpreting the object as an instance of '<em>Value Set Entry</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Value Set Entry</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseValueSetEntry(ValueSetEntry object) {
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
     * Returns the result of interpreting the object as an instance of '<em>Typed Element</em>'.
     * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
     * @param object the target of the switch.
     * @return the result of interpreting the object as an instance of '<em>Typed Element</em>'.
     * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
     * @generated
     */
	public T caseTypedElement(TypedElement object) {
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

} //BusinessconfigurationSwitch
