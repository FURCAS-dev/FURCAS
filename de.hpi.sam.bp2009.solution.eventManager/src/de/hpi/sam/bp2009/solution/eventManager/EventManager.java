/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.hpi.sam.bp2009.solution.eventManager;

import org.eclipse.emf.common.notify.Adapter;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event Manager</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see de.hpi.sam.bp2009.solution.eventManager.EventManagerPackage#getEventManager()
 * @model
 * @generated
 */
public interface EventManager extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model callerDataType="de.hpi.sam.bp2009.solution.eventManager.Adapter"
	 * @generated
	 */
	void subscribe(EObject root, EventFilter filter, Adapter caller);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model callerDataType="de.hpi.sam.bp2009.solution.eventManager.Adapter"
	 * @generated
	 */
	void subscribe(Resource root, EventFilter filter, Adapter caller);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model callerDataType="de.hpi.sam.bp2009.solution.eventManager.Adapter"
	 * @generated
	 */
	void subscribe(ResourceSet root, EventFilter filter, Adapter caller);

} // EventManager
