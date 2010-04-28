/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager.util;

import de.hpi.sam.bp2009.solution.eventManager.*;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import de.hpi.sam.bp2009.solution.eventManager.AndFilter;
import de.hpi.sam.bp2009.solution.eventManager.AssociationFilter;
import de.hpi.sam.bp2009.solution.eventManager.AttributeFilter;
import de.hpi.sam.bp2009.solution.eventManager.ClassFilter;
import de.hpi.sam.bp2009.solution.eventManager.EventFilter;
import de.hpi.sam.bp2009.solution.eventManager.EventManager;
import de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage;
import de.hpi.sam.bp2009.solution.eventManager.EventTypeFilter;
import de.hpi.sam.bp2009.solution.eventManager.OrFilter;
import de.hpi.sam.bp2009.solution.eventManager.PackageFilter;
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
 * @see de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage
 * @generated
 */
public class EventManagerSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static EventManagerPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventManagerSwitch() {
		if (modelPackage == null) {
			modelPackage = EventManagerPackage.eINSTANCE;
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
			case EventManagerPackage.EVENT_MANAGER: {
				EventManager eventManager = (EventManager)theEObject;
				T result = caseEventManager(eventManager);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EventManagerPackage.EVENT_FILTER: {
				EventFilter eventFilter = (EventFilter)theEObject;
				T result = caseEventFilter(eventFilter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EventManagerPackage.EVENT_TYPE_FILTER: {
				EventTypeFilter eventTypeFilter = (EventTypeFilter)theEObject;
				T result = caseEventTypeFilter(eventTypeFilter);
				if (result == null) result = caseEventFilter(eventTypeFilter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EventManagerPackage.AND_FILTER: {
				AndFilter andFilter = (AndFilter)theEObject;
				T result = caseAndFilter(andFilter);
				if (result == null) result = caseEventFilter(andFilter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EventManagerPackage.OR_FILTER: {
				OrFilter orFilter = (OrFilter)theEObject;
				T result = caseOrFilter(orFilter);
				if (result == null) result = caseEventFilter(orFilter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EventManagerPackage.CLASS_FILTER: {
				ClassFilter classFilter = (ClassFilter)theEObject;
				T result = caseClassFilter(classFilter);
				if (result == null) result = caseEventFilter(classFilter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EventManagerPackage.ATTRIBUTE_FILTER: {
				AttributeFilter attributeFilter = (AttributeFilter)theEObject;
				T result = caseAttributeFilter(attributeFilter);
				if (result == null) result = caseStructuralFeatureFilter(attributeFilter);
				if (result == null) result = caseEventFilter(attributeFilter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EventManagerPackage.PACKAGE_FILTER: {
				PackageFilter packageFilter = (PackageFilter)theEObject;
				T result = casePackageFilter(packageFilter);
				if (result == null) result = caseEventFilter(packageFilter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EventManagerPackage.ASSOCIATION_FILTER: {
				AssociationFilter associationFilter = (AssociationFilter)theEObject;
				T result = caseAssociationFilter(associationFilter);
				if (result == null) result = caseStructuralFeatureFilter(associationFilter);
				if (result == null) result = caseEventFilter(associationFilter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EventManagerPackage.OLD_VALUE_CLASS_FILTER: {
				OldValueClassFilter oldValueClassFilter = (OldValueClassFilter)theEObject;
				T result = caseOldValueClassFilter(oldValueClassFilter);
				if (result == null) result = caseEventFilter(oldValueClassFilter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EventManagerPackage.CONTAINMENT_FILTER: {
				ContainmentFilter containmentFilter = (ContainmentFilter)theEObject;
				T result = caseContainmentFilter(containmentFilter);
				if (result == null) result = caseEventFilter(containmentFilter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EventManagerPackage.NEW_VALUE_CLASS_FILTER: {
				NewValueClassFilter newValueClassFilter = (NewValueClassFilter)theEObject;
				T result = caseNewValueClassFilter(newValueClassFilter);
				if (result == null) result = caseEventFilter(newValueClassFilter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case EventManagerPackage.STRUCTURAL_FEATURE_FILTER: {
				StructuralFeatureFilter structuralFeatureFilter = (StructuralFeatureFilter)theEObject;
				T result = caseStructuralFeatureFilter(structuralFeatureFilter);
				if (result == null) result = caseEventFilter(structuralFeatureFilter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Event Manager</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Event Manager</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEventManager(EventManager object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Event Filter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Event Filter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEventFilter(EventFilter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Event Type Filter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Event Type Filter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEventTypeFilter(EventTypeFilter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>And Filter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>And Filter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAndFilter(AndFilter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Or Filter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Or Filter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOrFilter(OrFilter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Class Filter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Class Filter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClassFilter(ClassFilter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Filter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Filter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttributeFilter(AttributeFilter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Package Filter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Package Filter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePackageFilter(PackageFilter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Association Filter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Association Filter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAssociationFilter(AssociationFilter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Old Value Class Filter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Old Value Class Filter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOldValueClassFilter(OldValueClassFilter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Containment Filter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Containment Filter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContainmentFilter(ContainmentFilter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>New Value Class Filter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>New Value Class Filter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNewValueClassFilter(NewValueClassFilter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Structural Feature Filter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Structural Feature Filter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStructuralFeatureFilter(StructuralFeatureFilter object) {
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

} //EventManagerSwitch
